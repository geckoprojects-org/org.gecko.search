/**
 * Copyright (c) 2012 - 2023 Data In Motion and others.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made available under the terms of the 
 * Eclipse Public License v2.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *     Data In Motion - initial API and implementation
 */
package org.gecko.search.document.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.annotation.Testable;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceObjects;
import org.osgi.test.common.annotation.InjectBundleContext;
import org.osgi.test.common.annotation.InjectService;
import org.osgi.test.common.annotation.Property;
import org.osgi.test.common.annotation.config.WithFactoryConfiguration;
import org.osgi.test.common.service.ServiceAware;
import org.osgi.test.junit5.cm.ConfigurationExtension;
import org.osgi.test.junit5.context.BundleContextExtension;
import org.osgi.test.junit5.service.ServiceExtension;

@Testable
@ExtendWith(BundleContextExtension.class)
@ExtendWith(ServiceExtension.class)
@ExtendWith(ConfigurationExtension.class)
public class IndexTest {
	
	private BundleContext ctx;

	@BeforeEach
	public void doBeforeEach(@InjectBundleContext BundleContext ctx) {
		this.ctx = ctx;
	}

	@AfterEach() 
	public void doAfterEach() {
		File tempFolder = new File("/tmp/indexTest/");
		delete(tempFolder);
	}

	@Test
	@WithFactoryConfiguration(
			factoryPid = "LuceneIndex",
			location = "?", 
			name = "test",
			properties = {
					@Property(key = "id", value = "test"),
					@Property(key = "directory.type", value = "MMAP"),
					@Property(key = "base.path", value = "/tmp/indexTest/")
			})
	public void basicTest(@InjectService ServiceAware<LuceneIndexService> indexAware, @InjectService(cardinality = 0) ServiceAware<IndexSearcher> searcherAware) throws InterruptedException, IOException {

		assertThat(indexAware).isNotNull();			
		LuceneIndexService indexService = indexAware.getService();
		assertThat(indexService).isNotNull();			

		CountDownLatch commitLatch = new CountDownLatch(1);

		DocumentIndexContextObject indexContextObjectImpl = DocumentIndexContextObjectImpl.builder()
				.withDocuments(Collections.singletonList(createTestDocument(1)))
				.withIndexActionType(IndexActionType.ADD)
				.withCommitCallback(new CommitCallback() {

					@Override
					public void error(DocumentIndexContextObject ctx, Throwable t) {
						fail(t.getMessage());				
					}

					@Override
					public void commited(DocumentIndexContextObject ctx) {
						commitLatch.countDown();
					}
				})
				.build();
		long start = System.currentTimeMillis();
		indexService.handleContext(indexContextObjectImpl);
		System.out.println("Adding took: " + (System.currentTimeMillis() - start));
		assertTrue(commitLatch.await(5, TimeUnit.SECONDS));
		System.out.println("Indexing took: " + (System.currentTimeMillis() - start));
		Thread.sleep(500);

		assertThat(searcherAware).isNotNull();
		ServiceObjects<IndexSearcher> searcherSO = ctx.getServiceObjects(searcherAware.getServiceReference());
		assertThat(searcherSO).isNotNull();
		IndexSearcher searcher = searcherSO.getService();
		assertThat(searcher).isNotNull();		

		TopDocs topDocs = searcher.search(new TermQuery(new Term("test", "test")), 1000);
		assertNotNull(topDocs);
		assertEquals(1, topDocs.scoreDocs.length);
		
		searcherSO.ungetService(searcher);
	}

	@Test
	@WithFactoryConfiguration(
			factoryPid = "LuceneIndex",
			location = "?", 
			name = "test",
			properties = {
					@Property(key = "id", value = "test"),
					@Property(key = "directory.type", value = "MMAP"),
					@Property(key = "base.path", value =  "/tmp/indexTest/")
			})
	public void basicTestWithGeckoDataDir(@InjectService() ServiceAware<LuceneIndexService> indexAware,
			@InjectService() ServiceAware<IndexSearcher> searcherAware) throws InterruptedException, IOException {

		assertThat(indexAware).isNotNull();			
		LuceneIndexService indexService = indexAware.getService();
		assertThat(indexService).isNotNull();	

		indexService.getIndexWriter().deleteAll();
		indexService.commit();

		CountDownLatch commitLatch = new CountDownLatch(1);

		DocumentIndexContextObject indexContextObjectImpl = DocumentIndexContextObjectImpl.builder()
				.withDocuments(Collections.singletonList(createTestDocument(1)))
				.withIndexActionType(IndexActionType.ADD)
				.withCommitCallback(new CommitCallback() {

					@Override
					public void error(DocumentIndexContextObject ctx, Throwable t) {
						fail(t.getMessage());						
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

		assertThat(searcherAware).isNotNull();
		ServiceObjects<IndexSearcher> searcherSO = ctx.getServiceObjects(searcherAware.getServiceReference());
		assertThat(searcherSO).isNotNull();
		IndexSearcher searcher = searcherSO.getService();
		assertThat(searcher).isNotNull();		

		TopDocs topDocs = searcher.search(new TermQuery(new Term("test", "test")), 1000);
		assertNotNull(topDocs);
		assertEquals(1, topDocs.scoreDocs.length);

		searcherSO.ungetService(searcher);
	}

	@Test
	@WithFactoryConfiguration(
			factoryPid = "LuceneIndex",
			location = "?", 
			name = "test",
			properties = {
					@Property(key = "id", value = "test"),
					@Property(key = "directory.type", value = "MMAP"),
					@Property(key = "base.path", value =  "/tmp/indexTest/")
			})
	public void basicTestMany(@InjectService() ServiceAware<LuceneIndexService> indexAware,
			@InjectService() ServiceAware<IndexSearcher> searcherAware) throws InterruptedException, IOException {

		assertThat(indexAware).isNotNull();			
		LuceneIndexService indexService = indexAware.getService();
		assertThat(indexService).isNotNull();	

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
							fail(t.getMessage());							
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
		assertTrue(commitLatch.await(5, TimeUnit.SECONDS));
		System.out.println("Indexing took: " + (System.currentTimeMillis() - start));

		Thread.sleep(5000);

		assertThat(searcherAware).isNotNull();
		ServiceObjects<IndexSearcher> searcherSO = ctx.getServiceObjects(searcherAware.getServiceReference());
		assertThat(searcherSO).isNotNull();
		IndexSearcher searcher = searcherSO.getService();
		assertThat(searcher).isNotNull();

		TopDocs topDocs = searcher.search(new TermQuery(new Term("test", "test")), 100000);
		assertNotNull(topDocs);
		assertEquals(limit, topDocs.scoreDocs.length);
		
		searcherSO.ungetService(searcher);
	}

	private Document createTestDocument(int i) {
		Document d = new Document();
		d.add(new StoredField("id_stored", i));
		d.add(new IntPoint("id", i));
		d.add(new StringField("test", "test", Store.YES));
		return d;
	}

	private void delete(File file) {
		if(file.exists()) {
			if(!file.isFile()) {
				Arrays.asList(file.listFiles()).forEach(this::delete);
			}
			file.delete();
		}
	}
}