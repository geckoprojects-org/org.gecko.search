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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.IntPoint;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.search.IndexSearcher;
import org.gecko.search.IndexActionType;
import org.gecko.search.IndexContextObject;
import org.gecko.search.IndexListener;
import org.gecko.search.document.LuceneIndexService;
import org.gecko.search.document.context.ObjectContextBuilder;
import org.gecko.search.document.context.ObjectContextObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.annotation.Testable;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.test.common.annotation.InjectBundleContext;
import org.osgi.test.common.annotation.InjectService;
import org.osgi.test.common.annotation.Property;
import org.osgi.test.common.annotation.config.WithFactoryConfiguration;
import org.osgi.test.common.dictionary.Dictionaries;
import org.osgi.test.common.service.ServiceAware;
import org.osgi.test.junit5.cm.ConfigurationExtension;
import org.osgi.test.junit5.context.BundleContextExtension;
import org.osgi.test.junit5.service.ServiceExtension;
import org.osgi.util.promise.Promise;

@Testable
@ExtendWith(BundleContextExtension.class)
@ExtendWith(ServiceExtension.class)
@ExtendWith(ConfigurationExtension.class)
@ExtendWith(MockitoExtension.class)
public class IndexListenerTest {
	
	private BundleContext ctx;
	@Mock
	private IndexListener listenerMock;

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
	public void basicTestListener(@InjectService(timeout = 1000l) ServiceAware<LuceneIndexService> indexAware, 
			@InjectService(cardinality = 0, timeout = 1000l) ServiceAware<IndexSearcher> searcherAware,
			@InjectService(cardinality = 0, timeout = 1000l) ServiceAware<IndexListener> listenerAware) throws InterruptedException, IOException, InvocationTargetException {

		assertThat(indexAware).isNotNull();			
		LuceneIndexService<ObjectContextObject> indexService = indexAware.getService();
		assertThat(indexService).isNotNull();	
		
		assertThat(listenerAware).isNotNull();
		assertThat(listenerAware.getService()).isNull();
		
		ServiceRegistration<IndexListener> registration = ctx.registerService(IndexListener.class, listenerMock, null);
		
		IndexListener listenerService = listenerAware.waitForService(500);
		assertThat(listenerService).isNotNull();
		when(listenerMock.canHandle(any(IndexContextObject.class))).thenReturn(Boolean.TRUE);

		CDLCommitCallback commitCallback = CDLCommitCallback.create(1);

		ObjectContextObject indexContextObjectImpl = ObjectContextBuilder.create()
				.withDocuments(Collections.singletonList(createTestDocument(1)))
				.withIndexActionType(IndexActionType.ADD)
				.withCommitCallback(commitCallback)
				.build();
		
		Promise<Void> p = indexService.handleContext(indexContextObjectImpl);
		p.getValue();
		assertTrue(commitCallback.getLatch().await(5, TimeUnit.SECONDS));
		Thread.sleep(200l);
		ArgumentCaptor<IndexContextObject<?>> captor = ArgumentCaptor.forClass(IndexContextObject.class);
		verify(listenerMock, times(1)).onIndex(captor.capture());
		assertEquals(indexContextObjectImpl, captor.getValue());
		verify(listenerMock, times(1)).canHandle(any(IndexContextObject.class));
		
		reset(listenerMock);
		registration.unregister();
		Thread.sleep(100l);
		listenerService = listenerAware.waitForService(500);
		assertThat(listenerService).isNull();
		
		commitCallback = CDLCommitCallback.create(1);

		indexContextObjectImpl = ObjectContextBuilder.create()
				.withDocuments(Collections.singletonList(createTestDocument(1)))
				.withIndexActionType(IndexActionType.ADD)
				.withCommitCallback(commitCallback)
				.build();
		
		p = indexService.handleContext(indexContextObjectImpl);
		p.getValue();
		assertTrue(commitCallback.getLatch().await(5, TimeUnit.SECONDS));
		
		verify(listenerMock, never()).onIndex(any(IndexContextObject.class));
		verify(listenerMock, never()).canHandle(any(IndexContextObject.class));
		
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
	public void noHandlingTestListener(@InjectService(timeout = 1000l) ServiceAware<LuceneIndexService> indexAware, 
			@InjectService(cardinality = 0, timeout = 1000l) ServiceAware<IndexSearcher> searcherAware,
			@InjectService(cardinality = 0, timeout = 1000l) ServiceAware<IndexListener> listenerAware) throws InterruptedException, IOException, InvocationTargetException {
		
		assertThat(indexAware).isNotNull();			
		LuceneIndexService<ObjectContextObject> indexService = indexAware.getService();
		assertThat(indexService).isNotNull();	
		
		assertThat(listenerAware).isNotNull();
		assertThat(listenerAware.getService()).isNull();
		
		ServiceRegistration<IndexListener> registration = ctx.registerService(IndexListener.class, listenerMock, null);
		
		IndexListener listenerService = listenerAware.waitForService(500);
		assertThat(listenerService).isNotNull();
		
		when(listenerMock.canHandle(any(IndexContextObject.class))).thenReturn(Boolean.FALSE);
		
		CDLCommitCallback commitCallback = CDLCommitCallback.create(1);
		
		ObjectContextObject indexContextObjectImpl = ObjectContextBuilder.create()
				.withDocuments(Collections.singletonList(createTestDocument(1)))
				.withIndexActionType(IndexActionType.ADD)
				.withCommitCallback(commitCallback)
				.build();
		
		Promise<Void> p = indexService.handleContext(indexContextObjectImpl);
		p.getValue();
		
		assertTrue(commitCallback.getLatch().await(5, TimeUnit.SECONDS));
		
		ArgumentCaptor<IndexContextObject<?>> captor = ArgumentCaptor.forClass(IndexContextObject.class);
		verify(listenerMock, never()).onIndex(any(IndexContextObject.class));
		verify(listenerMock, times(1)).canHandle(captor.capture());
		assertEquals(indexContextObjectImpl, captor.getValue());
		
		reset(listenerMock);
		registration.unregister();
		when(listenerMock.canHandle(any(IndexContextObject.class))).thenReturn(Boolean.TRUE);
		registration = ctx.registerService(IndexListener.class, listenerMock, null);
		
		listenerService = listenerAware.waitForService(500);
		assertThat(listenerService).isNotNull();
		
		commitCallback = CDLCommitCallback.create(1);
		
		indexContextObjectImpl = ObjectContextBuilder.create()
				.withDocuments(Collections.singletonList(createTestDocument(1)))
				.withIndexActionType(IndexActionType.ADD)
				.withCommitCallback(commitCallback)
				.build();
		
		p = indexService.handleContext(indexContextObjectImpl);
		p.getValue();
		
		assertTrue(commitCallback.getLatch().await(5, TimeUnit.SECONDS));
		
		verify(listenerMock, times(1)).onIndex(any(IndexContextObject.class));
		verify(listenerMock, times(1)).canHandle(any(IndexContextObject.class));
		
	}
	
	/**
	 * Tests target binding handling
	 * @param indexAware
	 * @param searcherAware
	 * @param listenerAware
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws InvocationTargetException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	@WithFactoryConfiguration(
			factoryPid = "DefaultLuceneIndex",
			location = "?", 
			name = "test",
			properties = {
					@Property(key = "id", value = "test"),
					@Property(key = "indexListener.target", value = "(type=test)"),
					@Property(key = "directory.type", value = "ByteBuffer")
			})
	public void bindTargetTestListener(@InjectService(timeout = 1000l) ServiceAware<LuceneIndexService> indexAware, 
			@InjectService(cardinality = 0, timeout = 1000l) ServiceAware<IndexSearcher> searcherAware,
			@InjectService(cardinality = 0, timeout = 1000l) ServiceAware<IndexListener> listenerAware) throws InterruptedException, IOException, InvocationTargetException {
		
		assertThat(indexAware).isNotNull();			
		LuceneIndexService<ObjectContextObject> indexService = indexAware.getService();
		assertThat(indexService).isNotNull();	
		
		assertThat(listenerAware).isNotNull();
		assertThat(listenerAware.getService()).isNull();
		
		ServiceRegistration<IndexListener> registration = ctx.registerService(IndexListener.class, listenerMock, null);
		
		IndexListener listenerService = listenerAware.waitForService(500);
		assertThat(listenerService).isNotNull();
		assertNull(listenerAware.getServiceReference().getProperty("type"));
		
		when(listenerMock.canHandle(any(IndexContextObject.class))).thenReturn(Boolean.TRUE);
		
		CDLCommitCallback commitCallback = CDLCommitCallback.create(1);
		
		ObjectContextObject indexContextObjectImpl = ObjectContextBuilder.create()
				.withDocuments(Collections.singletonList(createTestDocument(1)))
				.withIndexActionType(IndexActionType.ADD)
				.withCommitCallback(commitCallback)
				.build();
		
		Promise<Void> p = indexService.handleContext(indexContextObjectImpl);
		p.getValue();
		assertTrue(commitCallback.getLatch().await(5, TimeUnit.SECONDS));
		
		verify(listenerMock, never()).onIndex(any(IndexContextObject.class));
		verify(listenerMock, never()).canHandle(any(IndexContextObject.class));
		
		registration.setProperties(Dictionaries.dictionaryOf("type", "test"));
		
		Thread.sleep(500l);
		
		listenerService = listenerAware.waitForService(500);
		assertThat(listenerService).isNotNull();
		assertEquals("test", listenerAware.getServiceReference().getProperty("type"));
		
		commitCallback = CDLCommitCallback.create(1);
		
		indexContextObjectImpl = ObjectContextBuilder.create()
				.withDocuments(Collections.singletonList(createTestDocument(1)))
				.withIndexActionType(IndexActionType.ADD)
				.withCommitCallback(commitCallback)
				.build();
		
		p = indexService.handleContext(indexContextObjectImpl);
		p.getValue();
		assertTrue(commitCallback.getLatch().await(5, TimeUnit.SECONDS));
		
		ArgumentCaptor<IndexContextObject<?>> captor = ArgumentCaptor.forClass(IndexContextObject.class);
		verify(listenerMock, times(1)).onIndex(captor.capture());
		verify(listenerMock, times(1)).canHandle(any(IndexContextObject.class));
		assertEquals(indexContextObjectImpl, captor.getValue());
		
		reset(listenerMock);
		registration.setProperties(Dictionaries.dictionaryOf("type", "toast"));
		
		Thread.sleep(500l);
		
		listenerService = listenerAware.waitForService(500);
		assertThat(listenerService).isNotNull();
		assertEquals("toast", listenerAware.getServiceReference().getProperty("type"));
		
		commitCallback = CDLCommitCallback.create(1);
		
		indexContextObjectImpl = ObjectContextBuilder.create()
				.withDocuments(Collections.singletonList(createTestDocument(1)))
				.withIndexActionType(IndexActionType.ADD)
				.withCommitCallback(commitCallback)
				.build();
		
		p = indexService.handleContext(indexContextObjectImpl);
		p.getValue();
		assertTrue(commitCallback.getLatch().await(5, TimeUnit.SECONDS));
		
		verify(listenerMock, never()).onIndex(any(IndexContextObject.class));
		verify(listenerMock, never()).canHandle(any(IndexContextObject.class));
	}

	private Document createTestDocument(int i) {
		Document d = new Document();
		d.add(new StoredField("id_stored", i));
		d.add(new IntPoint("id", i));
		d.add(new StringField("test", "test", Store.YES));
		return d;
	}

}
