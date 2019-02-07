/**
 * Copyright (c) 2012 - 2018 Data In Motion and others.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Data In Motion - initial API and implementation
 */
package org.gecko.search.document.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.IntPoint;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.gecko.search.api.IndexActionType;
import org.gecko.search.document.CommitCallback;
import org.gecko.search.document.DocumentIndexContextObject;
import org.gecko.search.document.DocumentIndexContextObjectImpl;
import org.gecko.search.document.LuceneIndexService;
import org.gecko.util.test.AbstractOSGiTest;
import org.gecko.util.test.ServiceChecker;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.osgi.framework.FrameworkUtil;
import org.osgi.service.cm.Configuration;

@RunWith(MockitoJUnitRunner.class)
public class IndexTest extends AbstractOSGiTest{

	private String tempPath;
	private Configuration indexerConfig;

	/**
	 * Creates a new instance.
	 * @param bundleContext
	 */
	public IndexTest() {
		super(FrameworkUtil.getBundle(IndexTest.class).getBundleContext());
	}

	@Test
	public void basicTest() throws InterruptedException, IOException {
		Dictionary<String, Object> indexConfig = new Hashtable<String, Object>();
		indexConfig.put("id", "test");
		indexConfig.put("directory.type", "MMAP");
		
		
		indexConfig.put("base.path", tempPath);
		
		ServiceChecker<LuceneIndexService> indexServiceChecker = createCheckerTrackedForCleanUp(LuceneIndexService.class);
		indexServiceChecker.start();
		
		indexerConfig = createConfigForCleanup("LuceneIndex", "?", indexConfig);
		
		assertTrue(indexServiceChecker.awaitCreation());
		
		LuceneIndexService indexService = getService(LuceneIndexService.class);
		
		CountDownLatch commitLatch = new CountDownLatch(1);
		
		DocumentIndexContextObject indexContextObjectImpl = DocumentIndexContextObjectImpl.builder()
		.withDocuments(Collections.singletonList(createTestDocument(1)))
		.withIndexActionType(IndexActionType.ADD)
		.withCommitCallback(new CommitCallback() {
			
			@Override
			public void error(DocumentIndexContextObject ctx, Throwable t) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void commited(DocumentIndexContextObject ctx) {
				commitLatch.countDown();
			}
		})
		.build();
		indexService.handleContext(indexContextObjectImpl);
		
		assertTrue(commitLatch.await(2, TimeUnit.SECONDS));

		Thread.sleep(100);
		
		IndexSearcher searcher = getService(IndexSearcher.class);
		
		TopDocs topDocs = searcher.search(new TermQuery(new Term("test", "test")), 1000);
		assertNotNull(topDocs);
		assertEquals(1, topDocs.scoreDocs.length);
		
	}

	@Test
	public void basicTestWithGeckoDataDir() throws InterruptedException, IOException {
		Dictionary<String, Object> indexConfig = new Hashtable<String, Object>();
		indexConfig.put("id", "test");
		indexConfig.put("directory.type", "MMAP");
		
		ServiceChecker<LuceneIndexService> indexServiceChecker = createCheckerTrackedForCleanUp(LuceneIndexService.class);
		indexServiceChecker.start();
		
		indexerConfig = createConfigForCleanup("LuceneIndex", "?", indexConfig);
		
		assertTrue(indexServiceChecker.awaitCreation());
		
		LuceneIndexService indexService = getService(LuceneIndexService.class);
		
		CountDownLatch commitLatch = new CountDownLatch(1);
		
		DocumentIndexContextObject indexContextObjectImpl = DocumentIndexContextObjectImpl.builder()
				.withDocuments(Collections.singletonList(createTestDocument(1)))
				.withIndexActionType(IndexActionType.ADD)
				.withCommitCallback(new CommitCallback() {
					
					@Override
					public void error(DocumentIndexContextObject ctx, Throwable t) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void commited(DocumentIndexContextObject ctx) {
						commitLatch.countDown();
					}
				})
				.build();
		indexService.handleContext(indexContextObjectImpl);
		
		assertTrue(commitLatch.await(2, TimeUnit.SECONDS));
		
		Thread.sleep(100);
		
		IndexSearcher searcher = getService(IndexSearcher.class);
		
		TopDocs topDocs = searcher.search(new TermQuery(new Term("test", "test")), 1000);
		assertNotNull(topDocs);
		assertEquals(1, topDocs.scoreDocs.length);
		
	}

	@Test
	public void basicTestMany() throws InterruptedException, IOException {
		Dictionary<String, Object> indexConfig = new Hashtable<String, Object>();
		indexConfig.put("id", "test");
		indexConfig.put("directory.type", "MMAP");
		
		
		indexConfig.put("base.path", tempPath);
		
		ServiceChecker<LuceneIndexService> indexServiceChecker = createCheckerTrackedForCleanUp(LuceneIndexService.class);
		indexServiceChecker.start();
		
		createConfigForCleanup("LuceneIndex", "?", indexConfig);
		
		assertTrue(indexServiceChecker.awaitCreation());
		
		LuceneIndexService indexService = getService(LuceneIndexService.class);
		
		int limit = 10000;
		
		CountDownLatch commitLatch = new CountDownLatch(1000);
		
		List<DocumentIndexContextObject> docs = new ArrayList<>();
		
		for(int i = 0; i < limit; i++) {
			DocumentIndexContextObject indexContextObjectImpl = DocumentIndexContextObjectImpl.builder()
					.withDocuments(Collections.singletonList(createTestDocument(i)))
					.withIndexActionType(IndexActionType.ADD)
					.withCommitCallback(new CommitCallback() {
						
						@Override
						public void error(DocumentIndexContextObject ctx, Throwable t) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void commited(DocumentIndexContextObject ctx) {
							commitLatch.countDown();
						}
					})
					.build();
			docs.add(indexContextObjectImpl);
		}
		
		long start = System.currentTimeMillis();
		indexService.handleContexts(docs);
		System.out.println("Adding took: " + (System.currentTimeMillis() - start));
		assertTrue("Current Commit count" + commitLatch.getCount(), commitLatch.await(5, TimeUnit.SECONDS));
		System.out.println("Indexing took: " + (System.currentTimeMillis() - start));
		
		Thread.sleep(5000);
		
		IndexSearcher searcher = getService(IndexSearcher.class);
		
		TopDocs topDocs = searcher.search(new TermQuery(new Term("test", "test")), 100000);
		assertNotNull(topDocs);
		assertEquals(limit, topDocs.scoreDocs.length);

	}
	
	private Document createTestDocument(int i) {
		Document d = new Document();
		d.add(new StoredField("id_stored", i));
		d.add(new IntPoint("id", i));
		d.add(new StringField("test", "test", Store.YES));
		return d;
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.util.test.AbstractOSGiTest#doBefore()
	 */
	@Override
	public void doBefore() {
		tempPath = System.getProperty("tempfolder");
		if(tempPath == null) {
			tempPath = System.getProperty("java.io.tmpdir");
		}
		tempPath = tempPath.replace("\\", "/");
		if(!tempPath.endsWith("/")) {
			tempPath += "/";
		}
		tempPath += "indexTest/";
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.util.test.AbstractOSGiTest#doAfter()
	 */
	@Override
	@After
	public void doAfter() {
		if(indexerConfig != null) {
			try {
				deleteConfigurationAndRemoveFromCleanupBlocking(indexerConfig);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		File tempFolder = new File(tempPath);
		delete(tempFolder);
		
	}

	/**
	 * @param tempFolder
	 */
	private void delete(File file) {
		if(!file.isFile()) {
			Arrays.asList(file.listFiles()).forEach(this::delete);
		}
		file.delete();
	}
}