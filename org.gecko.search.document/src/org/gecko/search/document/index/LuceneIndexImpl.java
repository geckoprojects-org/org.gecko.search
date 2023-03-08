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

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.Collection;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.SearcherManager;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.MMapDirectory;
import org.apache.lucene.store.NIOFSDirectory;
import org.gecko.search.api.IndexListener;
import org.gecko.search.document.LuceneIndexService;
import org.gecko.search.document.context.DocumentIndexContextObject;
import org.osgi.framework.Bundle;
import org.osgi.framework.PrototypeServiceFactory;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.osgi.util.pushstream.PushEvent;
import org.osgi.util.pushstream.PushStream;
import org.osgi.util.pushstream.PushStreamProvider;
import org.osgi.util.pushstream.QueuePolicyOption;
import org.osgi.util.pushstream.SimplePushEventSource;

/**
 * Service implementation using a {@link SearcherManager} to enable NRT search.
 * Indexing triggers commits using the push stream. The searcher are registered as {@link PrototypeServiceFactory} that are created 
 * out of the {@link SearcherManager}
 * @param <O> the business object type
 * @param <DICO> the concrete {@link DocumentIndexContextObject} of the business object type
 * @author Juergen Albert, Mark Hoffmann
 * @since 08.03.2023
 */
public abstract class LuceneIndexImpl<DICO extends DocumentIndexContextObject<?>> implements PrototypeServiceFactory<IndexSearcher>, LuceneIndexService<DICO>{

	private static final Logger LOGGER = Logger.getLogger(LuceneIndexImpl.class.getName());

	private final PushStreamProvider psp = new PushStreamProvider();
	private final ExecutorService commitExecutors = Executors.newCachedThreadPool();
	private final List<IndexListener> indexListeners = new LinkedList<>();
	private Analyzer analyzer = null;;
	private Directory directory;
	private IndexWriter indexWriter;
	private SearcherManager searcherManager;

	private ExecutorService indexExecutors = null;
	private ServiceRegistration<IndexSearcher> searcherRegistration;
	private SimplePushEventSource<DICO> singleSource;
	private File indexFolder;

	@ObjectClassDefinition
	public @interface Config {
		String id();
		String directory_type();
		String base_path() default "";
		int batchSize() default 500;
		long windowSize() default 500;
		int indexThreads() default 5;
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
		Objects.requireNonNull(listener);
		indexListeners.add(listener);
	}
	
	/**
	 * Removes an index listener
	 * @param listener the listener to be removed
	 */
	protected void removeIndexListener(IndexListener listener) {
		Objects.requireNonNull(listener);
		indexListeners.remove(listener);
	}
	
	/**
	 * Returns the {@link PushStreamProvider}.
	 * @return the {@link PushStreamProvider}
	 */
	protected PushStreamProvider getPushStreamProvider() {
		return psp;
	}

	protected void activate(Config serviceConfig, ComponentContext context) throws ConfigurationException {
		URL url = null;
		if(serviceConfig.base_path().length() > 0) {
			try {
				url = new File(serviceConfig.base_path()).toURI().toURL();
			} catch (MalformedURLException e) {
				throw new ConfigurationException("base.path", "Base path has an invalid format ", e);
			}
		}
		if(url == null) {
			throw new ConfigurationException("base.path", "The property is required");
		}

		try {
			URI uri = url.toURI();

			if(uri.getAuthority() != null && uri.getAuthority().length() > 0) {
				// Hack for UNC Path
				uri = (new URL("file://" + url.toString().substring("file:".length()))).toURI();
			}

			indexFolder = new File(new File(uri), serviceConfig.id());
		} catch (URISyntaxException | MalformedURLException e) {
			//Can't happen. It was already checked multiple times
			throw new RuntimeException("This should not happen, but it did...", e);
		}

		IndexWriterConfig config = new IndexWriterConfig(analyzer);
		try {
			switch(serviceConfig.directory_type()) {
			case "FS":
				directory = FSDirectory.open(indexFolder.toPath());
			case "NIOFS":
				directory = new NIOFSDirectory(indexFolder.toPath());
			case "MMap":
			default:
				directory = MMapDirectory.open(indexFolder.toPath());
				break;
			}
			indexWriter = new IndexWriter(directory, config);
			indexWriter.commit();
			searcherManager = new SearcherManager(indexWriter, null);
		} catch (IOException e) {
			throw new IllegalArgumentException("Could not open index directory for " + indexFolder.getPath() + " with message "+ e.getMessage(), e);
		}
		indexExecutors = Executors.newScheduledThreadPool(serviceConfig.indexThreads());
		chainPushStream(serviceConfig);

		Dictionary<String, Object> properties = new Hashtable<String, Object>();
		properties.put("id", serviceConfig.id());
		searcherRegistration = context.getBundleContext().registerService(IndexSearcher.class, this, properties);
	}

	protected void deactivate() {
		singleSource.close();
		searcherRegistration.unregister();
		try {
			searcherManager.close();
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, e, ()->"Failed to close searcher manager");
		}
		try {
			indexWriter.close();
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, e, ()->"Failed to close index writer");
		}
		try {
			directory.close();
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, e, ()->"Failed to close index directory");
		}
	}
	
	protected abstract SimplePushEventSource<DICO> createSimplePushEventSource();
	
	/**
	 * Configures and chains the internal Pushstream according to the configuration
	 * @param serviceConfig the services configuration
	 */
	protected void chainPushStream(Config serviceConfig) {
		singleSource = createSimplePushEventSource();
		PushStream<DICO> pspBuilder = psp.buildStream(singleSource)
				.withPushbackPolicy( q -> {
					return Math.max(0, q.size() - (serviceConfig.batchSize() + 50));
				})
				.withQueuePolicy(QueuePolicyOption.BLOCK)
				.withBuffer(new ArrayBlockingQueue<PushEvent<? extends DICO>>(serviceConfig.batchSize() * 2))
				.build();
		pspBuilder
		.fork(serviceConfig.indexThreads(), 0, indexExecutors)
		.buildBuffer().withBuffer(new ArrayBlockingQueue<PushEvent<? extends DICO>>(serviceConfig.batchSize() * 2)).build()
		.adjustBackPressure(l -> 0)
		.window(() -> Duration.ofMillis(serviceConfig.windowSize()), () -> serviceConfig.batchSize(), indexExecutors , (l,list) -> {
			return list;
		})
		.filter(c -> !c.isEmpty())
		.forEach(this::handleContextsSync);
	}
	
	/**
	 * Performs the actual action on the index.
	 * @param context
	 * @param commit
	 */
	protected void internalHandleContext(DICO context, boolean commit) {
		try {
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
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, String.format("Could not handle %s with error %s",  context.getActionType().name(), e.getMessage(), e));
			throw new IllegalStateException("Could not handle " + context.getActionType().name(), e);
		}
		if(commit) {
			LOGGER.log(Level.FINE, ()->String.format("Handle commit from internalHandleContext"));
			commit();
		} else {
			LOGGER.log(Level.FINE, ()->String.format("Handle NO commit from internalHandleContext"));
		}
		// Trigger listeners asynchronous
		indexListeners.forEach(l->commitExecutors.submit(()->l.onIndex(context)));
	}

	protected void internalHandleContexts(Collection<DICO> contexts, boolean commit) {
		contexts.forEach(partial(this::internalHandleContext, false));
		if(commit) {
			try {
				commit();
				contexts.forEach(ctx -> Optional.ofNullable(ctx.getCommitCallback()).ifPresent(callback -> {
					commitExecutors.submit(() -> callback.commited(ctx));
				}));
			} catch (Throwable t) {
				contexts.forEach(ctx -> Optional.ofNullable(ctx.getCommitCallback()).ifPresent(callback -> {
					commitExecutors.submit(() -> callback.error(ctx, t));
				}));
			}
		}
	}

	public static <T> Consumer<T> partial(BiConsumer<T, Boolean> f, boolean commit) {
		return (c) -> f.accept(c, commit);
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.document.LuceneIndexService#handleContext(org.gecko.search.document.DocumentIndexContextObject)
	 */
	@Override
	public void handleContext(DICO context) {
		singleSource.publish(context);
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.document.LuceneIndexService#handleContextSync(org.gecko.search.document.DocumentIndexContextObject)
	 */
	@Override
	public void handleContextSync(DICO context) {
		internalHandleContext(context, true);
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.document.LuceneIndexService#handleContexts(java.util.Collection)
	 */
	@Override
	public void handleContexts(Collection<DICO> contexts) {
		contexts.forEach(singleSource::publish);
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.document.LuceneIndexService#handleContextsSync(java.util.Collection)
	 */
	@Override
	public void handleContextsSync(Collection<DICO> contexts) {
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
		if(indexWriter.hasUncommittedChanges()) {
			try {
				indexWriter.commit();
			} catch (IOException e) {
				throw new IllegalStateException("Could not commit indexer", e);
			}
		}
		if(searcherManager != null) {
			commitExecutors.submit(new Runnable() {
				@Override
				public void run() {
					try {
						if(searcherManager != null){
							if (!searcherManager.maybeRefresh()) {
								LOGGER.log(Level.SEVERE, "Refreshing did not work, because it was called from a wrong thread");
							}
						}
					} catch (IOException e) {
						LOGGER.log(Level.SEVERE, String.format("Could not update SearcherManager for path %s, because %s", indexFolder.toString(), e.getMessage(), e));
					} 
				}
			});
		}

	}

	/* 
	 * (non-Javadoc)
	 * @see org.osgi.framework.PrototypeServiceFactory#getService(org.osgi.framework.Bundle, org.osgi.framework.ServiceRegistration)
	 */
	@Override
	public IndexSearcher getService(Bundle bundle, ServiceRegistration<IndexSearcher> registration) {
		return aquireSearch();
	}

	/* 
	 * (non-Javadoc)
	 * @see org.osgi.framework.PrototypeServiceFactory#ungetService(org.osgi.framework.Bundle, org.osgi.framework.ServiceRegistration, java.lang.Object)
	 */
	@Override
	public void ungetService(Bundle bundle, ServiceRegistration<IndexSearcher> registration, IndexSearcher service) {
		releaseSearcher(service);
	}

}
