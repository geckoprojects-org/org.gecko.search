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
		String base_path() default "";
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
	public Configuration createConfiguration() {
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
		String basePath = "<no-base.path>";
		try {
			requireNonNull(configuration);
			requireNonNull(context);
			this.configuration = configuration;
			basePath = configuration.base_path();

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
			throw new ConfigurationException("configuration", String.format("Cannot not open index directory for '%s' with message %s", basePath, e.getMessage()), e);
		} catch (Exception e) {
			throw new ConfigurationException("configuration", String.format("Cannot create index setup for '%s' with message %s", basePath, e.getMessage()), e);
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
				return aquireSearch();
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
		return getPromiseFactory().
				submit(()-> {
					requireNonNull(context);
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
						throw new UnsupportedOperationException("SEARCH is currerntly not supported");
					}
					return null;
				}).
				then(v->doCommitWithCommitCallbacks(Collections.singleton(context), commit).
						onResolve(()->notifyIndexListener(context)));
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
		List<Promise<Void>> promises = contexts.parallelStream().map(partial(this::internalHandleContext, false)).collect(Collectors.toList());
		return getPromiseFactory().all(promises).onResolve(()->doCommitWithCommitCallbacks(contexts, commit)).map(null);
	}

	/**
	 * Commit index changes an refresh the searcher manager
	 * @return {@link Promise} that resolves when searcher manager is refreshed
	 */
	protected Promise<Void> doCommit() {
		requireNonNull(indexWriter);
		return getPromiseFactory().submit(()->{
			if(indexWriter.hasUncommittedChanges()) {
				try {
					indexWriter.commit();
				} catch (IOException e) {
					throw new IllegalStateException(String.format("Could not commit indexer for index path '%s', because: '%s'", configuration.base_path(), e.getMessage()), e);
				}
			}
			if(searcherManager != null) {
				try {
					if(searcherManager != null && !searcherManager.maybeRefresh()) {
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

	/**
	 * Executes a commit and notifies the commit callbacks, if they are available. This handles the batching,
	 * where few documents are indexed and commited after the batch.
	 * @param contexts the context to be notified
	 * @param commit <code>true</code>, if a commit is needed, otherwise <code>false</code>
	 * @return Promise that resolved with <code>true</code> on successful action
	 */
	protected Promise<Void> doCommitWithCommitCallbacks(Collection<D> contexts, boolean commit) {
		if(commit) {
			return doCommit().then((c)->{
				contexts.forEach(ctx -> 
				Optional.ofNullable(ctx.getCommitCallback()).ifPresent(callback -> 
				getIndexExecutors().submit(() -> callback.commited(ctx))));
				return c;
			}).onFailure((t)->{
				contexts.forEach(ctx -> 
				Optional.ofNullable(ctx.getCommitCallback()).ifPresent(callback -> 
				getIndexExecutors().submit(() -> callback.error(ctx, t))));
			});
		} else  {
			LOGGER.log(Level.FINE, ()->"No commit needed for contexts");
			return getPromiseFactory().resolved(null);
		}
	}

	/**
	 * Notify all index listeners 
	 * @param context the document context
	 */
	protected void notifyIndexListener(D context) {
		// Trigger listeners asynchronous
		getIndexExecutors().submit(()->{
			synchronized (indexListeners) {
				indexListeners.stream().
				filter(l->l.canHandle(context)).
				forEach(l->l.onIndex(context));
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
	public void handleContext(D context) {
		requireNonNull(context);
		getPromiseFactory().submit(()->internalHandleContext(context, true));
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.document.LuceneIndexService#handleContextSync(org.gecko.search.document.DocumentIndexContextObject)
	 */
	@Override
	public void handleContextSync(D context) {
		internalHandleContext(context, true);
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.document.LuceneIndexService#handleContexts(java.util.Collection)
	 */
	@Override
	public void handleContexts(Collection<D> contexts) {
		requireNonNull(contexts);
		getPromiseFactory().submit(()-> internalHandleContexts(contexts, true));
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.document.LuceneIndexService#handleContextsSync(java.util.Collection)
	 */
	@Override
	public void handleContextsSync(Collection<D> contexts) {
		internalHandleContexts(contexts, true);
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.document.LuceneIndexService#getIndexWriter()
	 */
	@Override
	public IndexWriter getIndexWriter() {
		return indexWriter;
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.document.LuceneIndexService#aquireSearch()
	 */
	@Override
	public IndexSearcher aquireSearch() {
		requireNonNull(searcherManager);
		try {
			return searcherManager.acquire();
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
		requireNonNull(searcherManager);
		requireNonNull(searcher);
		try {
			searcherManager.release(searcher);
		} catch (IOException e) {
			throw new IllegalStateException("Could not release searcher", e);
		}
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.document.LuceneIndexService#commit()
	 */
	@Override
	public void commit()  {
		try {
			doCommit().getValue();
		} catch (InvocationTargetException e) {
			LOGGER.log(Level.SEVERE, "Commit failed with invocation target exception", e);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			LOGGER.log(Level.SEVERE, "Commit failed with interrupted exception", e);
		}
	}

}
