/**
 * Copyright (c) 2012 - 2019 Data In Motion and others.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Data In Motion - initial API and implementation
 */
package org.gecko.search.document.impl;

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
import java.util.Optional;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.SearcherManager;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.MMapDirectory;
import org.apache.lucene.store.NIOFSDirectory;
import org.gecko.runtime.boot.GeckoBootConstants;
import org.gecko.search.document.DocumentIndexContextObject;
import org.gecko.search.document.LuceneIndexService;
import org.osgi.framework.Bundle;
import org.osgi.framework.PrototypeServiceFactory;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.log.Logger;
import org.osgi.service.log.LoggerFactory;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.osgi.util.pushstream.PushEvent;
import org.osgi.util.pushstream.PushStream;
import org.osgi.util.pushstream.PushStreamProvider;
import org.osgi.util.pushstream.QueuePolicyOption;
import org.osgi.util.pushstream.SimplePushEventSource;

/**
 * 
 * @author Juergen Albert
 * @since 30 Jan 2019
 */
@Component(name = "LuceneIndex", service = LuceneIndexService.class, configurationPolicy = ConfigurationPolicy.REQUIRE)
public class LuceneIndex implements PrototypeServiceFactory<IndexSearcher>, LuceneIndexService{

	@Reference(service = LoggerFactory.class)
	private Logger logger;
	
	@Reference(target = "(" + GeckoBootConstants.PROP_GECKO_DATA_DIR + "=true)", cardinality=ReferenceCardinality.OPTIONAL)
	private URL geckoDataDir;
	
	@Reference(name="analyzer", target="(type=standard)")
	private Analyzer analyzer = null;;
	
	private Directory directory;

	private IndexWriter indexWriter;
	
	SearcherManager searcherManager;
	
	private PushStreamProvider psp = new PushStreamProvider();
	
	private final ExecutorService commitExecutors = Executors.newCachedThreadPool();
	private ExecutorService indexExecutors = null;

	private ServiceRegistration<IndexSearcher> searcherRegistration;
	
	SimplePushEventSource<DocumentIndexContextObject> singleSource;

	private File indexFolder;

	@ObjectClassDefinition
	@interface Config {
		String id();
		String directory_type();
		String base_path() default "";
		int batchSize() default 500;
		long windowSize() default 500;
		int indexThreads() default 5;
	}	
	
	@Activate
	public void activate(Config serviceConfig, ComponentContext context) throws ConfigurationException {
		URL url = geckoDataDir;
		if(serviceConfig.base_path().length() > 0) {
			try {
				url = new File(serviceConfig.base_path()).toURI().toURL();
			} catch (MalformedURLException e) {
				throw new ConfigurationException("base.path", "has a invlaid format ", e);
			}
		}
		if(url == null) {
			throw new ConfigurationException("base.path", "the Property is required if no gecko data dir is present");
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
			throw new RuntimeException("should not happen, but it did...", e);
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
	
	/**
	 * Configures and chains the internal Pushsstream according to the configuration
	 * @param serviceConfig the services configuration
	 */
	private void chainPushStream(Config serviceConfig) {
		singleSource = psp.buildSimpleEventSource(DocumentIndexContextObject.class).withBuffer(new ArrayBlockingQueue<PushEvent<? extends DocumentIndexContextObject>>(100)).withQueuePolicy(QueuePolicyOption.BLOCK).build();
		PushStream<DocumentIndexContextObject> pspBuilder = psp.buildStream(singleSource)
				.withPushbackPolicy( q -> {
					return Math.max(0, q.size() - (serviceConfig.batchSize() + 50));
				})
				.withQueuePolicy(QueuePolicyOption.BLOCK)
				.withBuffer(new ArrayBlockingQueue<PushEvent<? extends DocumentIndexContextObject>>(serviceConfig.batchSize() * 2))
				.build();
		pspBuilder
		.fork(serviceConfig.indexThreads(), 0, indexExecutors)
			.buildBuffer().withBuffer(new ArrayBlockingQueue<PushEvent<? extends DocumentIndexContextObject>>(serviceConfig.batchSize() * 2)).build()
			.adjustBackPressure(l -> 0)
			.window(() -> Duration.ofMillis(serviceConfig.windowSize()), () -> serviceConfig.batchSize(), indexExecutors , (l,list) -> {
				return list;
			})			
			.forEach(this::internalHandleContexts);
	}
	
	@Deactivate
	public void deactivate() throws IOException {
		singleSource.close();
		searcherRegistration.unregister();
		searcherManager.close();
		indexWriter.close();
		directory.close();
	}
	
	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.document.LuceneIndexService#handleContext(org.gecko.search.document.DocumentIndexContextObject)
	 */
	@Override
	public void handleContext(DocumentIndexContextObject context) {
		singleSource.publish(context);
	}

	/**
	 * performes the actual action on the index.
	 * @param context
	 * @param commit
	 */
	public void internalHandleContext(DocumentIndexContextObject context, boolean commit) {
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
			logger.error("Could not handle {} with error {}", context.getActionType().name(), e.getMessage(), e);
			throw new IllegalStateException("Could not handle " + context.getActionType().name(), e);
		}
		if(commit) {
			commit();
		}
	}
	
	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.document.LuceneIndexService#handleContexts(java.util.Collection)
	 */
	@Override
	public void handleContexts(Collection<? extends DocumentIndexContextObject> contexts) {
		contexts.forEach(singleSource::publish);
	}

	public void internalHandleContexts(Collection<? extends DocumentIndexContextObject> contexts) {
		internalHandleContexts(contexts, true);
	}
	
	public void internalHandleContexts(Collection<? extends DocumentIndexContextObject> contexts, boolean commit) {
		contexts.forEach(partial(this::internalHandleContext, false));
		System.out.println("indexing " + contexts.size());
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
	
	public static  Consumer<DocumentIndexContextObject> partial(BiConsumer<DocumentIndexContextObject, Boolean> f, boolean commit) {
        return (c) -> f.accept(c, commit);
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
							searcherManager.maybeRefresh();
						}
					} catch (IOException e) {
						logger.error("Could not update SearcherManager for path {}, because {}", indexFolder.toString(), e.getMessage(), e);
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
