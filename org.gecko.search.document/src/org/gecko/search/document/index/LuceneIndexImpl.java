/**
 * Copyright (c) 2012 - 2023 Data In Motion and others.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *     Data In Motion - initial API and implementation
 */
package org.gecko.search.document.index;

import static java.util.Objects.requireNonNull;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.SearcherManager;
import org.apache.lucene.store.Directory;
import org.gecko.search.BasicLuceneImpl;
import org.gecko.search.IndexListener;
import org.gecko.search.document.LuceneIndexService;
import org.gecko.search.document.context.DocumentIndexContextObject;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.PrototypeServiceFactory;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.osgi.util.promise.Promise;

/**
 * Service implementation using a {@link SearcherManager} to enable NRT search.
 * Indexing triggers commits using the push stream. The searcher are registered as {@link PrototypeServiceFactory} that are created 
 * out of the {@link SearcherManager}
 * @param <O> the business object type
 * @param <D> the concrete {@link DocumentIndexContextObject} of the business object type
 * @author Juergen Albert, Mark Hoffmann
 * @since 08.03.2023
 */
public abstract class LuceneIndexImpl<D extends DocumentIndexContextObject<?>> extends BasicLuceneImpl implements LuceneIndexService<D>{

	private static final Logger LOGGER = Logger.getLogger(LuceneIndexImpl.class.getName());

	private final List<IndexListener> indexListeners = new LinkedList<>();
	private IndexWriter indexWriter;
	private SearcherManager searcherManager;
	private ServiceRegistration<IndexSearcher> searcherRegistration;

	private IndexConfig configuration;


	@ObjectClassDefinition
	public @interface IndexConfig {
		String id();
		String directory_type();
		String base_path();
		int batchSize() default 500;
		long windowSize() default 500;
		int indexThreads() default 4;
	}	

	/**
	 * Adds an index listener
	 * @param listener the listener to add
	 */
	protected void addIndexListener(IndexListener listener) {
		requireNonNull(listener);
		indexListeners.add(listener);
	}

	/**
	 * Removes an index listener
	 * @param listener the listener to be removed
	 */
	protected void removeIndexListener(IndexListener listener) {
		requireNonNull(listener);
		indexListeners.remove(listener);
	}
	
	/**
	 * Returns the indexListeners.
	 * @return the indexListeners
	 */
	protected List<IndexListener> getIndexListeners() {
		return indexListeners;
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.document.index.BasicLuceneIndexImpl#createConfiguration()
	 */
	@Override
	public Configuration createInternalConfiguration() {
		return new Configuration() {

			@Override
			public String getIndexName() {
				return configuration.id();
			}

			@Override
			public String getDirectoryType() {
				return configuration.directory_type();
			}

			@Override
			public String getBasePath() {
				return configuration.base_path();
			}
		};
	}

	public void activate(IndexConfig configuration, BundleContext context) throws ConfigurationException {
		String id = "<no-id>";
		try {
			requireNonNull(configuration);
			requireNonNull(context);
			this.configuration = configuration;
			id = configuration.id();

			super.activate();

			Analyzer analyzer = getAnalyzer();
			requireNonNull(analyzer);
			IndexWriterConfig config = new IndexWriterConfig(analyzer);

			Directory directory = getDirectory();
			requireNonNull(directory);
			indexWriter = new IndexWriter(directory, config);
			searcherManager = new SearcherManager(indexWriter, null);
			registerIndexSearcher(configuration, context);
		} catch (ConfigurationException e) {
			throw e;
		} catch (IOException e) {
			throw new ConfigurationException("configuration", String.format("Cannot not open index directory for '%s' with message %s", id, e.getMessage()), e);
		} catch (Exception e) {
			throw new ConfigurationException("configuration", String.format("Cannot create index setup for '%s' with message %s", id, e.getMessage()), e);
		}
	}

	public void deactivate() {
		if (searcherRegistration != null) {
			searcherRegistration.unregister();
		}
		if (searcherManager != null) {
			try {
				searcherManager.close();
			} catch (IOException e) {
				LOGGER.log(Level.SEVERE, e, ()->"Failed to close searcher manager");
			}
		}
		if (indexWriter != null) {
			try {
				indexWriter.close();
			} catch (IOException e) {
				LOGGER.log(Level.SEVERE, e, ()->"Failed to close index writer");
			}
		}
		try {
			basicDeactivate();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e, ()->"Failed to deactivate implementation");
		}
	}

	/**
	 * Registers the Index Searcher as {@link PrototypeServiceFactory}
	 * @param configuration the index configuration
	 * @param context the {@link BundleContext}
	 */
	protected void registerIndexSearcher(IndexConfig configuration, BundleContext context) {
		Dictionary<String, Object> properties = new Hashtable<>();
		properties.put("id", configuration.id());
		searcherRegistration = context.registerService(IndexSearcher.class, new PrototypeServiceFactory<IndexSearcher>() {

			@Override
			public IndexSearcher getService(Bundle bundle, ServiceRegistration<IndexSearcher> registration) {
				return aquireSearcher();
			}

			@Override
			public void ungetService(Bundle bundle, ServiceRegistration<IndexSearcher> registration,
					IndexSearcher service) {
				releaseSearcher(service);
			}
		}, properties);
	}

	/**
	 * Performs the actual action on the index. Depending on the commit state, a commit will be executed,
	 * all commit callbacks will be informed and all index listeners will be called.
	 * @param context 
	 * @param commit
	 */
	protected Promise<Void> internalHandleContext(D context, boolean commit) {
		requireNonNull(getPromiseFactory());
		return getPromiseFactory().
				submit(()-> {
					requireNonNull(context);
					requireNonNull(context.getActionType());
					requireNonNull(indexWriter);
					switch (context.getActionType()) {
					case ADD:
						indexWriter.addDocuments(context.getDocuments());
						break;
					case MODIFY:
						indexWriter.updateDocuments(context.getIdentifyingTerm(), context.getDocuments());
						break;
					case REMOVE:
						indexWriter.deleteDocuments(context.getIdentifyingTerm());
						break;
					default:
						throw new UnsupportedOperationException("Currently not supported index type");
					}
					return null;
				}).
				then(v->commitWithCommitCallbacks(Collections.singleton(context), commit).
						then(c->notifyIndexListener(context)));
	}

	/**
	 * Delegates the indexing to a {@link Collections} of contexts
	 * @param contexts the collection of contexts
	 * @param commit <code>true</code>, if a commit should executed after the whole batch
	 * @return A {@link Promise}
	 */
	protected Promise<Void> internalHandleContexts(Collection<D> contexts, boolean commit) {
		requireNonNull(contexts);
		// We are batching here, so we do not
		List<Promise<Void>> promises = contexts.stream().map(partial(this::internalHandleContext, false)).collect(Collectors.toList());
		return getPromiseFactory().
				all(promises).
				then(p->commitWithCommitCallbacks(contexts, commit).then(null));
	}

	/**
	 * Executes a commit and notifies the commit callbacks, if they are available. This handles the batching,
	 * where few documents are indexed and commited after the batch.
	 * @param contexts the context to be notified
	 * @param commit <code>true</code>, if a commit is needed, otherwise <code>false</code>
	 * @return Promise that resolved with <code>true</code> on successful action
	 */
	protected Promise<Void> commitWithCommitCallbacks(Collection<D> contexts, boolean commit) {
		requireNonNull(contexts);
		if(commit) {
			return commit().then(c->{
				contexts.forEach(ctx -> 
				Optional.ofNullable(ctx.getCommitCallback()).ifPresent(callback -> callback.commited(ctx)));
				return c;
			}).onFailure(t->
				contexts.forEach(ctx -> 
				Optional.ofNullable(ctx.getCommitCallback()).ifPresent(callback ->  callback.error(ctx, t)))
			);
		} else  {
			LOGGER.log(Level.FINE, ()->"No commit needed for contexts " + contexts.size());
			return getPromiseFactory().resolved((Void)null);
		}
	}

	/**
	 * Notify all index listeners 
	 * @param context the document context
	 */
	protected Promise<Void> notifyIndexListener(D context) {
		requireNonNull(getPromiseFactory());
		// Trigger listeners asynchronous
		return getPromiseFactory().submit(()->{
			synchronized (indexListeners) {
				indexListeners.stream().
				filter(l->l.canHandle(context)).
				forEach(l->l.onIndex(context));
				return null;
			}
		});
	}

	public static <T> Function<T, Promise<Void>> partial(BiFunction<T, Boolean, Promise<Void>> f, boolean commit) {
		requireNonNull(f);
		return c -> f.apply(c, commit);
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.document.LuceneIndexService#handleContext(org.gecko.search.document.DocumentIndexContextObject)
	 */
	@Override
	public Promise<Void> handleContext(D context) {
		requireNonNull(context);
		requireNonNull(getPromiseFactory());
		return internalHandleContext(context, true);
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.document.LuceneIndexService#handleContextSync(org.gecko.search.document.DocumentIndexContextObject)
	 */
	@Override
	public void handleContextSync(D context) {
		try {
			internalHandleContext(context, true).getValue();
		} catch (InvocationTargetException e) {
			throw new IllegalStateException("Handling internalHandleContext caused an invocation target exception", e);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			throw new IllegalStateException("Handling internalHandleContext caused an interrupted exception", e);
		}
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.document.LuceneIndexService#handleContexts(java.util.Collection)
	 */
	@Override
	public Promise<Void> handleContexts(Collection<D> contexts) {
		requireNonNull(contexts);
		return internalHandleContexts(contexts, true);
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.document.LuceneIndexService#handleContextsSync(java.util.Collection)
	 */
	@Override
	public void handleContextsSync(Collection<D> contexts) {
		try {
			internalHandleContexts(contexts, true).getValue();
		} catch (InvocationTargetException e) {
			throw new IllegalStateException("Handling internalHandleContexts caused an invocation target exception", e);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			throw new IllegalStateException("Handling internalHandleContexts caused an interrupted exception", e);
		}
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.document.LuceneIndexService#getIndexWriter()
	 */
	@Override
	public IndexWriter getIndexWriter() {
		requireNonNull(indexWriter);
		return indexWriter;
	}
	
	/**
	 * Returns the searcherManager.
	 * @return the searcherManager
	 */
	public SearcherManager getSearcherManager() {
		return searcherManager;
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.document.LuceneIndexService#aquireSearch()
	 */
	@Override
	public IndexSearcher aquireSearcher() {
		requireNonNull(getSearcherManager());
		try {
			return getSearcherManager().acquire();
		} catch (IOException e) {
			throw new IllegalStateException("Could not aquire searcher", e);
		}
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.document.LuceneIndexService#releaseSearcher(org.apache.lucene.search.IndexSearcher)
	 */
	@Override
	public void releaseSearcher(IndexSearcher searcher) {
		requireNonNull(searcher);
		requireNonNull(getSearcherManager());
		try {
			getSearcherManager().release(searcher);
		} catch (Exception e) {
			throw new IllegalStateException("Could not release searcher", e);
		}
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.document.LuceneIndexService#commit()
	 */
	@Override
	public Promise<Void> commit()  {
		requireNonNull(getPromiseFactory());
		return getPromiseFactory().submit(()->{
			IndexWriter writer = getIndexWriter();
			requireNonNull(writer);
			if(writer.hasUncommittedChanges()) {
				try {
					writer.commit();
				} catch (IOException e) {
					throw new IllegalStateException(String.format("Could not commit indexer for index path '%s', because: '%s'", configuration.base_path(), e.getMessage()), e);
				}
			}
			SearcherManager manager = getSearcherManager();
			if(manager != null) {
				try {
					if(manager != null && !manager.maybeRefresh()) {
						LOGGER.log(Level.FINE, ()->"Refreshing did not work, because it was called from a wrong thread");
					}
				} catch (IOException e) {
					throw new IllegalStateException(String.format("Could not update SearcherManager for index path '%s', because: '%s'", configuration.base_path(), e.getMessage()), e);
				}
			} else {
				LOGGER.log(Level.WARNING, ()->"No searcher manager is available yet to be updated. Just committed the index");
			}
			return null;
		});
	}

}
