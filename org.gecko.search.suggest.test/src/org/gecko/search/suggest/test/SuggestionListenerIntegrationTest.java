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
package org.gecko.search.suggest.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

import org.gecko.search.IndexListener;
import org.gecko.search.document.context.ObjectContextObject;
import org.gecko.search.suggest.api.SuggestionDescriptor;
import org.gecko.search.suggest.api.SuggestionService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.osgi.framework.BundleContext;
import org.osgi.test.common.annotation.InjectBundleContext;
import org.osgi.test.common.annotation.InjectService;
import org.osgi.test.common.annotation.Property;
import org.osgi.test.common.annotation.Property.Scalar;
import org.osgi.test.common.annotation.config.WithFactoryConfiguration;
import org.osgi.test.common.service.ServiceAware;
import org.osgi.test.junit5.cm.ConfigurationExtension;
import org.osgi.test.junit5.context.BundleContextExtension;
import org.osgi.test.junit5.service.ServiceExtension;
import org.osgi.util.promise.Promise;
import org.osgi.util.promise.PromiseFactory;
import org.osgi.util.pushstream.PushStream;

@ExtendWith(BundleContextExtension.class)
@ExtendWith(ServiceExtension.class)
@ExtendWith(ConfigurationExtension.class)
public class SuggestionListenerIntegrationTest {

	@InjectBundleContext
	BundleContext ctx;
	private final PromiseFactory pf = new PromiseFactory(Executors.newFixedThreadPool(3));
	
	@BeforeEach
	public void doBefore() throws InterruptedException, IOException {	
	}

	@AfterEach
	public void doAfter() {
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	@WithFactoryConfiguration(
			factoryPid = "ObjectSuggestionDescriptor",
			location = "?", 
			name = "suggDescrList",
			properties = {
					@Property(key = "suggestion.index", value = "true", scalar = Scalar.Boolean),
					@Property(key = "name", value = "dummy")
			})
	@WithFactoryConfiguration(
			factoryPid = "SuggestionIndexListener",
			location = "?", 
			name = "suggList",
			properties = {
					@Property(key = "slName", value = "test")
			})
	@WithFactoryConfiguration(
			factoryPid = "ObjectStreamSuggestionService",
			location = "?", 
			name = "suggServiceList",
			properties = {
					@Property(key = "descriptor.target", value = "(name=dummy)"),
					@Property(key = "directory.type", value = "ByteBuffer"),
					@Property(key = "suggestionName", value = "testIdxSug"),
					@Property(key = "suggestionNumberResults", value = "5", scalar = Scalar.Integer)
			})
	public void testSuggestStream(@InjectService ServiceAware<SuggestionDescriptor> suggDescAware,
			@InjectService(cardinality = 0, filter = "(slName=test)") ServiceAware<IndexListener> suggestionListenerAware,
			@InjectService(cardinality = 0) ServiceAware<SuggestionService> suggestionServiceAware,
			@InjectService(cardinality = 0) ServiceAware<PushStream> psAware) throws InterruptedException, InvocationTargetException {
		
		assertThat(suggestionServiceAware).isNotNull();
		assertThat(suggestionListenerAware).isNotNull();
		assertThat(suggestionListenerAware.getService()).isNotNull();
		
		SuggestionDescriptor<Object, Field> suggDescService = suggDescAware.waitForService(500L);
		assertThat(suggDescService).isNotNull();
		assertThat(suggDescService).isInstanceOf(DummySuggestionDescriptor.class);
		
		final Stream<Object> objectStream = suggDescService.getObjectStream();
		final IndexListener listenerService = suggestionListenerAware.getService();
		
		PushStream<Object> ps = psAware.waitForService(500l);
		assertThat(ps).isNotNull();
		Promise<Void> producer = pf.submit(()-> {
			objectStream.forEach(o->{
				ObjectContextObject oco = mock(ObjectContextObject.class);
				when(oco.getObject()).thenReturn(o);
				System.out.println("Put: " + o);
				listenerService.onIndex(oco);
				try {
					Thread.sleep(50l);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			ps.close();
			return null;
		});
		SuggestionService suggestionService = suggestionServiceAware.waitForService(500l);
		assertThat(suggestionService).isNotNull();
		
		Promise<Void> initializationPromise = suggestionService.getInitializationPromise();
		pf.all(List.of(initializationPromise, producer)).getValue();
				
		Map<String, String> suggestResult = suggestionService.getAutoCompletion("Tester", new String[] {"person"});
		assertNotNull(suggestResult);
		assertEquals(5, suggestResult.size());
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	@WithFactoryConfiguration(
			factoryPid = "ObjectSuggestionDescriptor",
			location = "?", 
			name = "suggDescrList2",
			properties = {
					@Property(key = "suggestion.index", value = "true", scalar = Scalar.Boolean),
					@Property(key = "name", value = "dummy")
			})
	@WithFactoryConfiguration(
			factoryPid = "SuggestionIndexListener",
			location = "?", 
			name = "suggList2",
			properties = {
					@Property(key = "slName", value = "test")
			})
	@WithFactoryConfiguration(
			factoryPid = "ObjectStreamSuggestionService",
			location = "?", 
			name = "suggServiceList2",
			properties = {
					@Property(key = "descriptor.target", value = "(name=dummy)"),
					@Property(key = "contextStream.target", value = "(sl.name=test)"),
					@Property(key = "suggestionName", value = "testIdxSug"),
					@Property(key = "directory.type", value = "ByteBuffer"),
					@Property(key = "suggestionNumberResults", value = "5", scalar = Scalar.Integer)
			})
	public void testSuggestBinding(@InjectService ServiceAware<SuggestionDescriptor> suggDescAware,
			@InjectService(cardinality = 0, filter = "(slName=test)") ServiceAware<IndexListener> suggestionListenerAware,
			@InjectService(cardinality = 0) ServiceAware<SuggestionService> suggestionServiceAware,
			@InjectService(cardinality = 0) ServiceAware<PushStream> psAware) throws InterruptedException, InvocationTargetException {
		
		assertThat(suggestionServiceAware).isNotNull();
		assertThat(suggestionListenerAware).isNotNull();
		assertThat(suggestionListenerAware.getService()).isNotNull();
		
		SuggestionDescriptor<Object, Field> suggDescService = suggDescAware.waitForService(500L);
		assertThat(suggDescService).isNotNull();
		assertThat(suggDescService).isInstanceOf(DummySuggestionDescriptor.class);
		
		PushStream<Object> ps = psAware.waitForService(500l);
		assertThat(ps).isNotNull();
		final Stream<Object> objectStream = suggDescService.getObjectStream();
		final IndexListener listenerService = suggestionListenerAware.getService();

		SuggestionService suggestionService = suggestionServiceAware.waitForService(500l);
		assertThat(suggestionService).isNotNull();

		Promise<Void> initializationPromise = suggestionService.getInitializationPromise();
		
		Promise<Void> producer = pf.submit(()-> {
			objectStream.forEach(o->{
				ObjectContextObject oco = mock(ObjectContextObject.class);
				when(oco.getObject()).thenReturn(o);
				System.out.println("Put: " + o);
				listenerService.onIndex(oco);
				try {
					Thread.sleep(50l);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
			ps.close();
			return null;
		});
		
		
		pf.all(List.of(initializationPromise, producer)).getValue();
		
		Map<String, String> suggestResult = suggestionService.getAutoCompletion("Tester", new String[] {"person"});
		assertNotNull(suggestResult);
		assertEquals(5, suggestResult.size());
		
	}
	
}