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
package org.gecko.search.document.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
import org.gecko.search.IndexActionType;
import org.gecko.search.document.LuceneIndexService;
import org.gecko.search.document.context.ObjectContextBuilder;
import org.gecko.search.document.context.ObjectContextObject;
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
import org.osgi.util.promise.Promise;

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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	@WithFactoryConfiguration(
			factoryPid = "DefaultLuceneIndex",
			location = "?", 
			name = "test",
			properties = {
					@Property(key = "id", value = "test"),
					@Property(key = "directory.type", value = "ByteBuffer")
			})
	public void basicTest(@InjectService ServiceAware<LuceneIndexService> indexAware, @InjectService(cardinality = 0) ServiceAware<IndexSearcher> searcherAware) throws InterruptedException, IOException, InvocationTargetException {

		assertThat(indexAware).isNotNull();			
		LuceneIndexService<ObjectContextObject> indexService = indexAware.getService();
		assertThat(indexService).isNotNull();			

		CDLCommitCallback commitCallback = CDLCommitCallback.create(1);

		ObjectContextObject indexContextObjectImpl = ObjectContextBuilder.create()
				.withDocuments(Collections.singletonList(createTestDocument(1)))
				.withIndexActionType(IndexActionType.ADD)
				.withCommitCallback(commitCallback)
				.build();
		long start = System.currentTimeMillis();
		Promise<Void> p = indexService.handleContext(indexContextObjectImpl);
		p.getValue();
		System.out.println("Adding took: " + (System.currentTimeMillis() - start));
		assertTrue(commitCallback.getLatch().await(5, TimeUnit.SECONDS));
		System.out.println("Indexing took: " + (System.currentTimeMillis() - start));

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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	@WithFactoryConfiguration(
			factoryPid = "DefaultLuceneIndex",
			location = "?", 
			name = "test",
			properties = {
					@Property(key = "id", value = "test"),
					@Property(key = "directory.type", value = "ByteBuffer")
			})
	public void basicTestMany(@InjectService() ServiceAware<LuceneIndexService> indexAware,
			@InjectService() ServiceAware<IndexSearcher> searcherAware) throws InterruptedException, IOException, InvocationTargetException {

		assertThat(indexAware).isNotNull();			
		LuceneIndexService<ObjectContextObject> indexService = indexAware.getService();
		assertThat(indexService).isNotNull();	

		int limit = 100;

		CDLCommitCallback commitCallback = CDLCommitCallback.create(limit);

		List<ObjectContextObject> docs = new ArrayList<>();

		for(int i = 0; i < limit; i++) {
			ObjectContextObject indexContextObjectImpl = ObjectContextBuilder.create()
					.withDocuments(Collections.singletonList(createTestDocument(i)))
					.withIndexActionType(IndexActionType.ADD)
					.withCommitCallback(commitCallback)
					.build();
			docs.add(indexContextObjectImpl);
		}

		long start = System.currentTimeMillis();
		Promise<Void> p = indexService.handleContexts(docs);
		p.getValue();
		System.out.println("Adding took: " + (System.currentTimeMillis() - start));
		assertTrue(commitCallback.getLatch().await(5, TimeUnit.SECONDS));
		System.out.println("Indexing took: " + (System.currentTimeMillis() - start));

		assertThat(searcherAware).isNotNull();
		ServiceObjects<IndexSearcher> searcherSO = ctx.getServiceObjects(searcherAware.getServiceReference());
		assertThat(searcherSO).isNotNull();
		IndexSearcher searcher = searcherSO.getService();
		assertThat(searcher).isNotNull();

		TopDocs topDocs = searcher.search(new TermQuery(new Term("test", "test")), 100);
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

}
