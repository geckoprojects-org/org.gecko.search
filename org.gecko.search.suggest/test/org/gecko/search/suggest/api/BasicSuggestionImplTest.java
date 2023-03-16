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
package org.gecko.search.suggest.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.search.suggest.analyzing.AnalyzingInfixSuggester;
import org.gecko.search.BasicLuceneImpl.Configuration;
import org.gecko.search.IndexActionType;
import org.gecko.search.suggest.context.SuggestionContext;
import org.gecko.search.suggest.context.SuggestionContextWrapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.util.converter.Converter;
import org.osgi.util.converter.Converters;
import org.osgi.util.promise.Promise;

/**
 * 
 * @author mark
 * @since 16.03.2023
 */
@ExtendWith(MockitoExtension.class)
public class BasicSuggestionImplTest {

	private Analyzer analyzer = new StandardAnalyzer();
	@Mock
	private Configuration configuration;
	@SuppressWarnings("rawtypes")
	private BasicSuggestionImpl suggestionService;
	private final Converter converter = Converters.standardConverter();

	@BeforeEach
	public void beforeEach() {
		suggestionService = createAbstractMock(BasicSuggestionImpl.class);
	}

	@AfterEach
	public void afterEach() {
		suggestionService.deactivate();
	}

	@Test
	public void testFilterLabel() {
		assertFalse(suggestionService.filterLabel(null));
		assertFalse(suggestionService.filterLabel(" "));
		assertFalse(suggestionService.filterLabel("  "));
		assertFalse(suggestionService.filterLabel(""));
		assertTrue(suggestionService.filterLabel("test"));
	}

	@Test
	public void testConvertLabels() {
		assertTrue(suggestionService.convertLabels(null).isEmpty());
		assertTrue(suggestionService.convertLabels(new String[0]).isEmpty());
		assertEquals(1, suggestionService.convertLabels(new String[] {"foo"}).size());
		assertEquals(1, suggestionService.convertLabels(new String[] {"foo", "foo"}).size());
		assertEquals(2, suggestionService.convertLabels(new String[] {"foo", "bar"}).size());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testDescriptor() {
		assertNull(suggestionService.getDescriptor());
		suggestionService.setDescriptor(null);
		assertNull(suggestionService.getDescriptor());
		SuggestionDescriptor<?, ?> descriptor = mock(SuggestionDescriptor.class);
		suggestionService.setDescriptor(descriptor);
		assertNotNull(suggestionService.getDescriptor());
		assertEquals(descriptor, suggestionService.getDescriptor());
	}

	@Test
	public void testLookup() throws ConfigurationException {
		assertThrows(NullPointerException.class, ()->suggestionService.getLookup());

		Map<String, String> properties = Map.of("suggestionName", "1234", "directory.type", "bytebuffer");
		final SuggestionConfiguration config = converter.convert(properties).to(SuggestionConfiguration.class);
		suggestionService.setAnalyzer(analyzer);
		suggestionService.activate(config);

		assertNotNull(suggestionService.getLookup());

		assertThrows(NullPointerException.class, ()->suggestionService.createLookup(null));
		try {
			AnalyzingInfixSuggester lookup = suggestionService.createLookup(config);
			assertNotNull(lookup);

		} catch (IOException e) {
			fail("Unexpected exception");
		}

	}

	@SuppressWarnings("unchecked")
	@Test
	public void testInitializeSuggestionIndex() throws ConfigurationException, InvocationTargetException, InterruptedException {
		assertThrows(NullPointerException.class, ()->suggestionService.initializeSuggestionIndex());
		Map<String, String> properties = Map.of("suggestionName", "1234", "directory.type", "bytebuffer");
		final SuggestionConfiguration config = converter.convert(properties).to(SuggestionConfiguration.class);
		suggestionService.setAnalyzer(analyzer);
		suggestionService.activate(config);

		try {
			Promise<Void> p = suggestionService.initializeSuggestionIndex();
			p.getValue();
		} catch (Exception e) {
			fail("Unexpected exception");
		}
	}

	@Test
	public void testActivate() throws IOException {
		// null parameters
		assertThrows(ConfigurationException.class, ()->suggestionService.activate(null));
		Map<String, String> properties = Map.of("suggestionName", "1234", "directory.type", "bytebuffer");
		final SuggestionConfiguration config = converter.convert(properties).to(SuggestionConfiguration.class);
		// no analyzer
		assertThrows(ConfigurationException.class, ()->suggestionService.activate(config));
		suggestionService.setAnalyzer(analyzer);
		try {
			suggestionService.activate(config);
		} catch (ConfigurationException e) {
			fail("Unexpected exception");
		}
		verify(suggestionService, times(1)).createLookup(any());
		assertNotNull(suggestionService.getLookup());
	}

	@Test
	public void testActivateFailNoName() throws IOException, ConfigurationException {
		suggestionService = mock(BasicSuggestionImpl.class);
		doCallRealMethod().when(suggestionService).activate(any());
		// null parameters
		assertThrows(ConfigurationException.class, ()->suggestionService.activate(null));
		Map<String, String> properties = Map.of("directory.type", "bytebuffer");
		final SuggestionConfiguration config = converter.convert(properties).to(SuggestionConfiguration.class);
		// no analyzer
		assertThrows(ConfigurationException.class, ()->suggestionService.activate(config));
		suggestionService.setAnalyzer(analyzer);
		assertThrows(ConfigurationException.class, ()->suggestionService.activate(config));
		verify(suggestionService, never()).createLookup(any());
	}

	@Test
	public void testActivateFailLookup() throws IOException, ConfigurationException {
		suggestionService = mock(BasicSuggestionImpl.class);
		doCallRealMethod().when(suggestionService).activate(any());
		doCallRealMethod().when(suggestionService).setAnalyzer(any());
		doCallRealMethod().when(suggestionService).doInitializeExecutors(any());
		when(suggestionService.createInternalConfiguration()).thenCallRealMethod();
		when(suggestionService.doInitializeDirectory(any(), any())).thenCallRealMethod();
		doThrow(IllegalStateException.class).when(suggestionService).createLookup(any());
		// null parameters
		assertThrows(ConfigurationException.class, ()->suggestionService.activate(null));
		Map<String, String> properties = Map.of("suggestionName", "1234", "directory.type", "bytebuffer");
		final SuggestionConfiguration config = converter.convert(properties).to(SuggestionConfiguration.class);
		// no analyzer
		assertThrows(ConfigurationException.class, ()->suggestionService.activate(config));
		suggestionService.setAnalyzer(analyzer);
		assertThrows(ConfigurationException.class, ()->suggestionService.activate(config));
	}

	@Test
	public void testDeactivate() throws ConfigurationException {
		try {
			suggestionService.deactivate();
		} catch (Exception e) {
			fail("unexpected exception");
		}
		doThrow(IllegalStateException.class).when(suggestionService).basicDeactivate();
		try {
			suggestionService.deactivate();
		} catch (Exception e) {
			fail("unexpected exception");
		}
		Map<String, String> properties = Map.of("suggestionName", "1234", "directory.type", "bytebuffer");
		final SuggestionConfiguration config = converter.convert(properties).to(SuggestionConfiguration.class);
		suggestionService.setAnalyzer(analyzer);
		suggestionService.activate(config);
		assertNotNull(suggestionService.getLookup());
		try {
			suggestionService.deactivate();
		} catch (Exception e) {
			fail("unexpected exception");
		}
		assertThrows(NullPointerException.class, ()-> suggestionService.getLookup());
	}

	@Test
	public void testInternalConfiguration() throws ConfigurationException {
		assertThrows(NullPointerException.class, ()->suggestionService.createInternalConfiguration());
		Map<String, String> properties = Map.of("suggestionName", "1234", "directory.type", "bytebuffer");
		SuggestionConfiguration config = converter.convert(properties).to(SuggestionConfiguration.class);
		suggestionService.setAnalyzer(analyzer);
		suggestionService.activate(config);
		Configuration c = suggestionService.createInternalConfiguration();
		assertNotNull(c);
		assertEquals("1234", c.getIndexName());
		assertEquals("bytebuffer", c.getDirectoryType());
		assertEquals("", c.getBasePath());
	}

	@Test
	public void testConfiguration() throws ConfigurationException {
		assertNull(suggestionService.getConfiguration());
		Map<String, String> properties = Map.of("suggestionName", "1234", "directory.type", "bytebuffer");
		SuggestionConfiguration config = converter.convert(properties).to(SuggestionConfiguration.class);
		assertThrows(ConfigurationException.class, ()->suggestionService.activate(config));
		assertNull(suggestionService.getConfiguration());
		suggestionService.setAnalyzer(analyzer);
		suggestionService.activate(config);
		assertNotNull(suggestionService.getConfiguration());
		assertEquals(config, suggestionService.getConfiguration());
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testCreateContextFromDescriptor() {
		suggestionService = mock(BasicSuggestionImpl.class);
		doCallRealMethod().when(suggestionService).createContextFromDescriptor();
		doCallRealMethod().when(suggestionService).setDescriptor(any());

		SuggestionDescriptor descriptor = mock(SuggestionDescriptor.class);
		assertThrows(NullPointerException.class, ()->suggestionService.createContextFromDescriptor());
		suggestionService.setDescriptor(descriptor);
		when(descriptor.getFields()).thenReturn(null);
		when(descriptor.getLabels()).thenReturn(null);
		when(descriptor.getObjectStream()).thenReturn(null);

		List descriptorResult = suggestionService.createContextFromDescriptor();
		assertTrue(descriptorResult.isEmpty());

		when(descriptor.getFields()).thenReturn(Set.of("foo", "bar"));
		when(descriptor.getLabels()).thenReturn(null);
		when(descriptor.getObjectStream()).thenReturn(null);

		descriptorResult = suggestionService.createContextFromDescriptor();
		assertTrue(descriptorResult.isEmpty());

		when(descriptor.getFields()).thenReturn(Set.of("foo", "bar"));
		when(descriptor.getLabels()).thenReturn(null);
		when(descriptor.getObjectStream()).thenReturn(Stream.of(new FooBar()));
		SuggestionContext ctx01 = mock(SuggestionContext.class);
		SuggestionContext ctx02 = mock(SuggestionContext.class);
		when(suggestionService.createContextsForFields(any(), any(), any(), any(), anyInt())).thenReturn(List.of(ctx01, ctx02));

		descriptorResult = suggestionService.createContextFromDescriptor();
		assertEquals(2, descriptorResult.size());
	}


	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testCreateContextForField() {
		assertThrows(NullPointerException.class, ()->suggestionService.createContextsForFields(null, "bar", IndexActionType.ADD, new String[0], 42));
		assertThrows(NullPointerException.class, ()->suggestionService.createContextsForFields(Set.of("foo"), null, IndexActionType.ADD, new String[0], 42));
		assertThrows(NullPointerException.class, ()->suggestionService.createContextsForFields(Set.of("foo"), "bar", null, new String[0], 42));
		assertThrows(NullPointerException.class, ()->suggestionService.createContextsForFields(Set.of("foo"), "bar", IndexActionType.ADD, null, 42));
		suggestionService = mock(BasicSuggestionImpl.class);
		doCallRealMethod().when(suggestionService).createContextsForFields(any(), any(), any(), any(), anyInt());
		doCallRealMethod().when(suggestionService).setDescriptor(any());
		when(suggestionService.getPayload(any(), any())).thenReturn(null);
		when(suggestionService.getFieldValue(any(), any())).thenReturn(null);
		// no descriptor
		assertThrows(NullPointerException.class, ()->suggestionService.createContextsForFields(Set.of("foo"), "bar", IndexActionType.ADD, new String[0], 42));

		SuggestionDescriptor descriptor = mock(SuggestionDescriptor.class);
		suggestionService.setDescriptor(descriptor);
		List<SuggestionContext<?, ?>> contextsForFields = suggestionService.createContextsForFields(Set.of("foo"), "bar", IndexActionType.ADD, new String[0], 42);
		assertTrue(contextsForFields.isEmpty());
		// no fields
		contextsForFields = suggestionService.createContextsForFields(null, "bar", IndexActionType.ADD, new String[0], 42);
		assertTrue(contextsForFields.isEmpty());

		when(suggestionService.getFieldValue(any(), any())).thenReturn("fizz");
		contextsForFields = suggestionService.createContextsForFields(Set.of("foo"), "bar", IndexActionType.ADD, new String[0], 42);
		assertEquals(1, contextsForFields.size());
		assertEquals("foo", contextsForFields.get(0).getField());
		assertEquals("bar", contextsForFields.get(0).getObject());
		assertEquals("fizz", contextsForFields.get(0).getContent());
		assertEquals(0, contextsForFields.get(0).getLabels().length);
		assertNull(contextsForFields.get(0).getPayload());

		when(suggestionService.getPayload(any(), any())).thenReturn("buzz");
		contextsForFields = suggestionService.createContextsForFields(Set.of("foo", "foots"), "bar", IndexActionType.ADD, new String[] {"tag", "label"}, 42);
		assertEquals(2, contextsForFields.size());
		for (SuggestionContext sctx : contextsForFields) {
			if (sctx.getField().equals("foo")) {
				assertEquals("foo", sctx.getField());
				assertEquals("bar", sctx.getObject());
				assertEquals("fizz", sctx.getContent());
				assertEquals("buzz", sctx.getPayload());
				assertEquals(2, sctx.getLabels().length);
				assertEquals("tag", sctx.getLabels()[0]);
				assertEquals("label", sctx.getLabels()[1]);
			} else if (sctx.getField().equals("foots")) {
				assertEquals("foots", sctx.getField());
				assertEquals("bar", sctx.getObject());
				assertEquals("fizz", sctx.getContent());
				assertEquals("buzz", sctx.getPayload());
				assertEquals(2, sctx.getLabels().length);
				assertEquals("tag", sctx.getLabels()[0]);
				assertEquals("label", sctx.getLabels()[1]);
			} else {
				fail("unexpected context");
			}
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testCreateContextForFieldErrorPayload() {
		suggestionService = mock(BasicSuggestionImpl.class);
		doCallRealMethod().when(suggestionService).createContextsForFields(any(), any(), any(), any(), anyInt());
		doCallRealMethod().when(suggestionService).setDescriptor(any());
		when(suggestionService.getPayload(any(), any())).thenThrow(RuntimeException.class);
		SuggestionDescriptor descriptor = mock(SuggestionDescriptor.class);
		suggestionService.setDescriptor(descriptor);
		try {
			suggestionService.createContextsForFields(Set.of("foo"), "bar", IndexActionType.ADD, new String[0], 42);
		} catch (Exception e) {
			assertInstanceOf(IllegalStateException.class, e);
			assertInstanceOf(RuntimeException.class, e.getCause());
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testCreateContextForFieldErrorFieldValue() {
		suggestionService = mock(BasicSuggestionImpl.class);
		doCallRealMethod().when(suggestionService).createContextsForFields(any(), any(), any(), any(), anyInt());
		doCallRealMethod().when(suggestionService).setDescriptor(any());
		when(suggestionService.getPayload(any(), any())).thenReturn(null);
		when(suggestionService.getFieldValue(any(), any())).thenThrow(NullPointerException.class);
		SuggestionDescriptor descriptor = mock(SuggestionDescriptor.class);
		suggestionService.setDescriptor(descriptor);
		try {
			suggestionService.createContextsForFields(Set.of("foo"), "bar", IndexActionType.ADD, new String[0], 42);
		} catch (Exception e) {
			assertInstanceOf(IllegalStateException.class, e);
			assertInstanceOf(NullPointerException.class, e.getCause());
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testBuildIndexContext() {
		assertThrows(NullPointerException.class, ()->suggestionService.buildIndexContext(null));
		SuggestionContext sctx01 = mock(SuggestionContext.class);
		SuggestionContext sctx02 = mock(SuggestionContext.class);
		Collection<SuggestionContextWrapper> buildIndexContext = suggestionService.buildIndexContext(List.of(sctx01, sctx02));
		assertEquals(2, buildIndexContext.size());
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testCreateContext() {
		assertThrows(NullPointerException.class, ()->suggestionService.createContext(null));
		assertThrows(NullPointerException.class, ()->suggestionService.createContext("foo"));
		
		SuggestionDescriptor descriptor = mock(SuggestionDescriptor.class);
		suggestionService.setDescriptor(descriptor);
		when(descriptor.getFields()).thenReturn(null);
		when(descriptor.getLabels()).thenReturn(null);
		
		List<SuggestionContext> sctxList = suggestionService.createContext("foo");
		assertTrue(sctxList.isEmpty());
		
		when(descriptor.getFields()).thenReturn(Set.of("ffoo"));
		when(suggestionService.getPayload(any(), any())).thenReturn("payload");
		when(suggestionService.getFieldValue(any(), any())).thenReturn("content");
		sctxList = suggestionService.createContext("foo");
		assertEquals(1, sctxList.size());
		when(descriptor.getFields()).thenReturn(Set.of("ffoo", "ffizz"));
		sctxList = suggestionService.createContext("foo");
		assertEquals(2, sctxList.size());
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testCreateContextISE() {
		assertThrows(NullPointerException.class, ()->suggestionService.createContext(null));
		assertThrows(NullPointerException.class, ()->suggestionService.createContext("foo"));
		
		suggestionService = mock(BasicSuggestionImpl.class);
		doCallRealMethod().when(suggestionService).setDescriptor(any());
		when(suggestionService.createContext(any())).thenCallRealMethod();
		when(suggestionService.createContextsForFields(any(), any(), any(), any(), anyInt())).thenThrow(IllegalStateException.class);
		
		SuggestionDescriptor descriptor = mock(SuggestionDescriptor.class);
		suggestionService.setDescriptor(descriptor);
		when(descriptor.getFields()).thenReturn(Set.of("ffoo"));
		when(descriptor.getLabels()).thenReturn(null);
		
		assertThrows(IllegalStateException.class, ()->suggestionService.createContext("foo"));
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testIndexContext() throws ConfigurationException {
		assertThrows(NullPointerException.class, ()->suggestionService.indexContext(null));
		SuggestionContext sctx = mock(SuggestionContext.class);
		SuggestionContextWrapper wrapper = SuggestionContext.toIndexContext(sctx);
		assertThrows(NullPointerException.class, ()->suggestionService.indexContext(wrapper));
		// bo lookup
		Map<String, String> properties = Map.of("suggestionName", "1234", "directory.type", "bytebuffer");
		final SuggestionConfiguration config = converter.convert(properties).to(SuggestionConfiguration.class);
		// no analyzer
		suggestionService.setAnalyzer(analyzer);
		suggestionService.activate(config);
		when(sctx.getActionType()).thenReturn(null);
		suggestionService.indexContext(wrapper);
		
		when(sctx.getActionType()).thenReturn(IndexActionType.ADD);
		when(sctx.getContent()).thenReturn("test");
		when(sctx.getPayload()).thenReturn("foo");
		suggestionService.indexContext(wrapper);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testIndexContexts() throws ConfigurationException, IOException, InvocationTargetException, InterruptedException {
		assertThrows(NullPointerException.class, ()->suggestionService.indexContexts(null));
		SuggestionContext sctx01 = mock(SuggestionContext.class);
		SuggestionContextWrapper wrapper01 = SuggestionContext.toIndexContext(sctx01);
		SuggestionContext sctx02 = mock(SuggestionContext.class);
		SuggestionContextWrapper wrapper02 = SuggestionContext.toIndexContext(sctx02);
		assertThrows(NullPointerException.class, ()->suggestionService.indexContexts(List.of(wrapper01, wrapper02)));
		// bo lookup
		Map<String, String> properties = Map.of("suggestionName", "1234", "directory.type", "bytebuffer");
		final SuggestionConfiguration config = converter.convert(properties).to(SuggestionConfiguration.class);
		// no analyzer
		suggestionService.setAnalyzer(analyzer);
		suggestionService.activate(config);
		when(sctx01.getActionType()).thenReturn(null);
		when(sctx02.getActionType()).thenReturn(IndexActionType.ADD);
		suggestionService.indexContexts(List.of(wrapper01, wrapper02));
		verify(suggestionService, times(2)).indexContext(any());
		
		when(sctx01.getActionType()).thenReturn(IndexActionType.ADD);
		when(sctx02.getActionType()).thenReturn(IndexActionType.ADD);
		when(sctx01.getContent()).thenReturn("test");
		when(sctx01.getContent()).thenReturn("test-2");
		when(sctx01.getPayload()).thenReturn("foo");
		when(sctx02.getPayload()).thenReturn("foo-2");
		suggestionService.indexContexts(List.of(wrapper01, wrapper02));
		
		verify(suggestionService, times(4)).indexContext(any());
		
		// this is just a simulation because we use mocked data. Lucene throws the ISE here
		suggestionService.doLookup("te", suggestionService.convertLabels(new String[] {"tag"}));
	}
	
	@SuppressWarnings({ "unchecked" })
	@Test
	public void testDoLookup() throws ConfigurationException, IOException {
		assertThrows(NullPointerException.class, ()->suggestionService.doLookup(null, null));
		assertThrows(NullPointerException.class, ()->suggestionService.doLookup("te", null));
		assertThrows(NullPointerException.class, ()->suggestionService.doLookup("te", suggestionService.convertLabels(new String[] {"tag"})));
		Map<String, String> properties = Map.of("suggestionName", "1234", "directory.type", "bytebuffer");
		final SuggestionConfiguration config = converter.convert(properties).to(SuggestionConfiguration.class);
		// no analyzer
		suggestionService.setAnalyzer(analyzer);
		suggestionService.activate(config);
		assertNotNull(suggestionService.getLookup());
		// this is just a simulation because we use mocked data. Lucene throws the ISE here
		suggestionService.doLookup("te", suggestionService.convertLabels(new String[] {"tag"}));
	}

	public <T> T createAbstractMock(Class<T> mockClass) {
		return mock(mockClass, 
				Mockito.withSettings().
				useConstructor().
				defaultAnswer(Mockito.CALLS_REAL_METHODS));
	}

	public static class FooBar {
		String foo = "foo";
		String bar = "bar";
	}

}
