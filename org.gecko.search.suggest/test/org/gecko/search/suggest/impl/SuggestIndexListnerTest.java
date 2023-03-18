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
package org.gecko.search.suggest.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.gecko.search.document.context.ObjectContextObject;
import org.gecko.search.suggest.impl.SuggestIndexListener.SuggestListenerConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.util.converter.Converter;
import org.osgi.util.converter.Converters;
import org.osgi.util.promise.PromiseFactory;
import org.osgi.util.pushstream.PushStream;

/**
 * 
 * @author mark
 * @since 17.03.2023
 */
@ExtendWith(MockitoExtension.class)
public class SuggestIndexListnerTest {
	
	@Mock
	private BundleContext context;
	@SuppressWarnings("rawtypes")
	@Mock
	private ServiceRegistration registration;
	private SuggestIndexListener listenerService;
	private final Converter converter = Converters.standardConverter();

	@BeforeEach
	public void beforeEach() {
		listenerService = new SuggestIndexListener();
	}

	@AfterEach
	public void afterEach() {
	}
	
	@Test
	public void testActivateFail() {
		assertThrows(ConfigurationException.class, ()->listenerService.activate(null, null));
		assertThrows(ConfigurationException.class, ()->listenerService.activate(null, context));
		final SuggestListenerConfig configEmpty = converter.convert(Collections.emptyMap()).to(SuggestListenerConfig.class); 
		assertThrows(ConfigurationException.class, ()->listenerService.activate(configEmpty, context));
		Map<String, String> properties = Map.of("slName", "1234");
		final SuggestListenerConfig config = converter.convert(properties).to(SuggestListenerConfig.class);
		when(context.registerService(anyString(), any(), any())).thenThrow(IllegalStateException.class);
		assertThrows(ConfigurationException.class, ()->listenerService.activate(config, context));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testActivate() {
		Map<String, String> properties = Map.of("slName", "1234");
		final SuggestListenerConfig config = converter.convert(properties).to(SuggestListenerConfig.class);
		when(context.registerService(anyString(), any(), any())).thenReturn(registration);
		try {
			listenerService.activate(config, context);
		} catch (Exception e) {
			fail("Unexpected excpetion");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testDeactivate() {
		try {
			listenerService.deactivate();
		} catch (Exception e) {
			fail("Unexpected excpetion");
		}
		
		Map<String, String> properties = Map.of("slName", "1234");
		final SuggestListenerConfig config = converter.convert(properties).to(SuggestListenerConfig.class);
		when(context.registerService(anyString(), any(), any())).thenReturn(registration);
		try {
			listenerService.activate(config, context);
			listenerService.deactivate();
		} catch (Exception e) {
			fail("Unexpected excpetion");
		}
		when(context.registerService(anyString(), any(), any())).thenReturn(null);
		try {
			listenerService.activate(config, context);
			listenerService.deactivate();
		} catch (Exception e) {
			fail("Unexpected excpetion");
		}
	}
	
	@Test
	public void testCanHandle() throws ConfigurationException {
		ObjectContextObject oco = mock(ObjectContextObject.class);
		assertFalse(listenerService.canHandle(oco));
		Map<String, String> properties = Map.of("slName", "1234");
		final SuggestListenerConfig config = converter.convert(properties).to(SuggestListenerConfig.class);
		listenerService.activate(config, context);
		assertFalse(listenerService.canHandle(null));
		assertFalse(listenerService.canHandle(oco));
		when(oco.getObject()).thenReturn("test");
		assertTrue(listenerService.canHandle(oco));
		listenerService.deactivate();
		assertFalse(listenerService.canHandle(oco));
	}
	
	@Test
	public void testHandleContext() throws ConfigurationException, InvocationTargetException, InterruptedException {
		Map<String, String> properties = Map.of("slName", "1234");
		final SuggestListenerConfig config = converter.convert(properties).to(SuggestListenerConfig.class);
		listenerService.activate(config, context);
		
		ArgumentCaptor<PushStream<?>> psCapturer = ArgumentCaptor.forClass(PushStream.class);
		verify(context, times(1)).registerService(anyString(), psCapturer.capture(), any());
		final PushStream<?> pushStream = psCapturer.getValue();
		
		PromiseFactory pf = new PromiseFactory(Executors.newFixedThreadPool(3));
		final int count = 10;
		final CountDownLatch latch = new CountDownLatch(count);
		pf.submit(()-> {
			for(int i = 0; i < count; i++) {
				String o = "value-" + i;
				ObjectContextObject oco = mock(ObjectContextObject.class);
				when(oco.getObject()).thenReturn(o);
				System.out.println("Put: " + o);
				listenerService.onIndex(oco);
				Thread.sleep(50l);
			}
			return true;
		});
		pf.submit(()->{
			pushStream.forEach(o->{
				latch.countDown();
				System.out.println("Object " + latch.getCount() + " - '" + o + "'");
			});
			return true;
		});
		assertTrue(latch.await(1000l, TimeUnit.MILLISECONDS));
		pushStream.close();
		
	}
	
	@Test
	public void testHandleContextNull() throws ConfigurationException, InvocationTargetException, InterruptedException {
		Map<String, String> properties = Map.of("slName", "1234");
		final SuggestListenerConfig config = converter.convert(properties).to(SuggestListenerConfig.class);
		listenerService.activate(config, context);
		
		ArgumentCaptor<PushStream<?>> psCapturer = ArgumentCaptor.forClass(PushStream.class);
		verify(context, times(1)).registerService(anyString(), psCapturer.capture(), any());
		final PushStream<?> pushStream = psCapturer.getValue();
		
		PromiseFactory pf = new PromiseFactory(Executors.newFixedThreadPool(3));
		final int count = 10;
		final CountDownLatch latch = new CountDownLatch(count / 2);
		pf.submit(()-> {
			for(int i = 0; i < count; i++) {
				String o = "value-" + i;
				ObjectContextObject oco = mock(ObjectContextObject.class);
				when(oco.getObject()).thenReturn(o);
				if (i % 2 == 0) {
					System.out.println("Put: null");
					listenerService.onIndex(null);
				} else {
					System.out.println("Put: " + o);
					listenerService.onIndex(oco);
				}
				Thread.sleep(50l);
			}
			return true;
		});
		pf.submit(()->{
			pushStream.forEach(o->{
				latch.countDown();
				System.out.println("Object " + latch.getCount() + " - '" + o + "'");
			});
			return true;
		});
		assertTrue(latch.await(1000l, TimeUnit.MILLISECONDS));
		pushStream.close();
		
	}
	
	@Test
	public void testHandleContextNullObject() throws ConfigurationException, InvocationTargetException, InterruptedException {
		Map<String, String> properties = Map.of("slName", "1234");
		final SuggestListenerConfig config = converter.convert(properties).to(SuggestListenerConfig.class);
		listenerService.activate(config, context);
		
		ArgumentCaptor<PushStream<?>> psCapturer = ArgumentCaptor.forClass(PushStream.class);
		verify(context, times(1)).registerService(anyString(), psCapturer.capture(), any());
		final PushStream<?> pushStream = psCapturer.getValue();
		
		PromiseFactory pf = new PromiseFactory(Executors.newFixedThreadPool(3));
		final int count = 10;
		final CountDownLatch latch = new CountDownLatch(count / 2);
		pf.submit(()-> {
			for(int i = 0; i < count; i++) {
				String o = i % 2 == 0 ? "value-" + i : null;
				ObjectContextObject oco = mock(ObjectContextObject.class);
				when(oco.getObject()).thenReturn(o);
				System.out.println("Put: " + o);
				listenerService.onIndex(oco);
				Thread.sleep(50l);
			}
			return true;
		});
		pf.submit(()->{
			pushStream.forEach(o->{
				latch.countDown();
				System.out.println("Object " + latch.getCount() + " - '" + o + "'");
			});
			return true;
		});
		assertTrue(latch.await(1000l, TimeUnit.MILLISECONDS));
		pushStream.close();
		
	}
	
}
