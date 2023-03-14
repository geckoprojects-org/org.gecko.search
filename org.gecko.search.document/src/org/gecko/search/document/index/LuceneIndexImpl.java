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

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
import org.apache.lucene.store.ByteBuffersDirectory;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.NIOFSDirectory;
import org.apache.lucene.store.NRTCachingDirectory;
import org.gecko.search.api.IndexListener;
import org.gecko.search.document.LuceneIndexService;
import org.gecko.search.document.context.DocumentIndexContextObject;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.PrototypeServiceFactory;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.osgi.util.promise.Promise;
import org.osgi.util.promise.PromiseFactory;

/**
 * Service implementation using a {@link SearcherManager} to enable NRT search.
 * Indexing triggers commits using the push stream. The searcher are registered as {@link PrototypeServiceFactory} that are created 
 * out of the {@link SearcherManager}
 * @param <O> the business object type
 * @param <D> the concrete {@link DocumentIndexContextObject} of the business object type
 * @author Juergen Albert, Mark Hoffmann
 * @since 08.03.2023
 */
public abstract class LuceneIndexImpl<D extends DocumentIndexContextObject<?>> implements LuceneIndexService<D>{

	/** BASE_PATH */
	private static final String BASE_PATH = "base.path";

	private static final Logger LOGGER = Logger.getLogger(LuceneIndexImpl.class.getName());

	private ExecutorService commitExecutors = null;
	private PromiseFactory pf = null;
	private final List<IndexListener> indexListeners = new LinkedList<>();
	private Analyzer analyzer = null;
	private Directory directory;
	private IndexWriter indexWriter;
	private SearcherManager searcherManager;

	private ServiceRegistration<IndexSearcher> searcherRegistration;
	private int threadCount = 0;

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
	 * Sets the analyzer.
	 * @param analyzer the analyzer to set
	 */
	public void setAnalyzer(Analyzer analyzer) {
		this.analyzer = analyzer;
	}

	/**
	 * Returns the analyzer.
	 * @return the analyzer
	 */
	protected Analyzer getAnalyzer() {
		return analyzer;
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

	protected void activate(IndexConfig configuration, BundleContext context) throws ConfigurationException {
		requireNonNull(configuration);
		requireNonNull(context);
		this.configuration = configuration;

		requireNonNull(analyzer);
		IndexWriterConfig config = new IndexWriterConfig(analyzer);
		try {
			directory = initializeDirectory(configuration);
			directory = new NRTCachingDirectory(directory, 5.0, 60.0);
			indexWriter = new IndexWriter(directory, config);
			searcherManager = new SearcherManager(indexWriter, null);
			initializeExecutors(configuration);
		} catch (IOException e) {
			throw new IllegalArgumentException(String.format("Could not open index directory for %s with message %s", configuration.base_path(), e.getMessage()), e);
		}

		registerIndexSearcher(configuration, context);
	}

	protected void deactivate() {
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
		if (directory != null) {
			try {
				directory.close();
			} catch (IOException e) {
				LOGGER.log(Level.SEVERE, e, ()->"Failed to close index directory");
			}
		}
	}

	/**
	 * Create the index creation location
	 * @param configuration the index configuration
	 * @throws ConfigurationException
	 */
	protected File initializeIndexLocation(IndexConfig configuration) throws ConfigurationException {
		URL url = null;
		if(configuration.base_path().length() > 0) {
			try {
				url = new File(configuration.base_path()).toURI().toURL();
			} catch (MalformedURLException e) {
				throw new ConfigurationException(BASE_PATH, "Base path has an invalid format ", e);
			}
		}
		if(url == null) {
			throw new ConfigurationException(BASE_PATH, "The property is required");
		}
		try {
			URI uri = url.toURI();
	
			if(uri.getAuthority() != null && uri.getAuthority().length() > 0) {
				// Hack for UNC Path
				uri = (new URL("file://" + url.toString().substring("file:".length()))).toURI();
			}
			return new File(new File(uri), configuration.id());
		} catch (URISyntaxException | MalformedURLException e) {
			//Should not happen. It was already checked multiple times
			throw new ConfigurationException(BASE_PATH, "The given path.path format is invalid '" + url.toString() + "'", e);
		}
	}

	/**
	 * Creates a Lucene {@link Directory} dependent on the configuration
	 * @param configuration the service configuration
	 * @return the directory instance
	 * @throws IOException thrown on errors during directory creation
	 * @throws ConfigurationException 
	 */
	protected Directory initializeDirectory(IndexConfig configuration) throws IOException, ConfigurationException {
		File indexFolder = initializeIndexLocation(configuration);
		switch(configuration.directory_type()) {
		case "NRT":
			directory = FSDirectory.open(indexFolder.toPath());
			break;
		case "ByteBuffer":
			directory = new ByteBuffersDirectory();
			break;
		case "FS":
			directory = FSDirectory.open(indexFolder.toPath());
			break;
		case "NIOFS":
			directory = new NIOFSDirectory(indexFolder.toPath());
			break;
		case "MMap":
		default:
			LOGGER.warning("Unrecognized directory format: " + configuration.directory_type() + "; Falling back to system defaults");
			directory = FSDirectory.open(indexFolder.toPath());
			break;
		}
		return directory;
	}
	
	/**
	 * Creates the setup for {@link ExecutorService} and {@link PromiseFactory}
	 * @param serviceConfig the configuration
	 */
	protected void initializeExecutors(IndexConfig serviceConfig) {
		commitExecutors = Executors.newFixedThreadPool(2, (r)->{
			Thread t = new Thread(r, "Index+Commit-" + threadCount++);
			t.setDaemon(true);
			return t;
		});
		pf = new PromiseFactory(commitExecutors);
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
		return pf.
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
		return pf.all(promises).onResolve(()->doCommitWithCommitCallbacks(contexts, commit)).map(null);
	}

	/**
	 * Commit index changes an refresh the searcher manager
	 * @return {@link Promise} that resolves when searcher manager is refreshed
	 */
	protected Promise<Void> doCommit() {
		requireNonNull(indexWriter);
		return pf.submit(()->{
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
						commitExecutors.submit(() -> callback.commited(ctx))));
				return c;
			}).onFailure((t)->{
				contexts.forEach(ctx -> 
					Optional.ofNullable(ctx.getCommitCallback()).ifPresent(callback -> 
						commitExecutors.submit(() -> callback.error(ctx, t))));
			});
		} else  {
			LOGGER.log(Level.FINE, ()->"No commit needed for contexts");
			return pf.resolved(null);
		}
	}

	/**
	 * Notify all index listeners 
	 * @param context the document context
	 */
	protected void notifyIndexListener(D context) {
		// Trigger listeners asynchronous
		commitExecutors.submit(()->{
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
		pf.submit(()->internalHandleContext(context, true));
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
		pf.submit(()-> internalHandleContexts(contexts, true));
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
