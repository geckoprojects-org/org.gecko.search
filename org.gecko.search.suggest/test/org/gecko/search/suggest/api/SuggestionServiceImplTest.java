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
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyCollection;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.search.suggest.analyzing.AnalyzingInfixSuggester;
import org.gecko.search.BasicLuceneImpl.Configuration;
import org.gecko.search.suggest.context.SuggestionContext;
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
 * @since 17.03.2023
 */
@ExtendWith(MockitoExtension.class)
public class SuggestionServiceImplTest {

	private Analyzer analyzer = new StandardAnalyzer();
	@Mock
	private Configuration configuration;
	@SuppressWarnings("rawtypes")
	@Mock
	private SuggestionDescriptor descriptor;
	@SuppressWarnings("rawtypes")
	private SuggestionServiceImpl suggestionService;
	private final Converter converter = Converters.standardConverter();

	@BeforeEach
	public void beforeEach() {
		suggestionService = createAbstractMock(SuggestionServiceImpl.class);
	}

	@AfterEach
	public void afterEach() {
		suggestionService.deactivate();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testActivation() {
		// no setup configuration
		assertThrows(ConfigurationException.class, ()->suggestionService.activate(null));
		Map<String, String> properties = Map.of("suggestionName", "1234", "directory.type", "bytebuffer");
		final SuggestionConfiguration config = converter.convert(properties).to(SuggestionConfiguration.class);
		// no analyzer
		assertThrows(ConfigurationException.class, ()->suggestionService.activate(config));
		suggestionService.setAnalyzer(analyzer);
		assertThrows(ConfigurationException.class, ()->suggestionService.activate(config));
		suggestionService.setDescriptor(descriptor);
		try {
			suggestionService.activate(config);
			AnalyzingInfixSuggester lookup = suggestionService.getLookup();
			assertNotNull(lookup);
		} catch (ConfigurationException e) {
			e.printStackTrace();
			fail("Unexpected exception");
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testInitializeSuggestionIndexNothing2Index() throws ConfigurationException, InvocationTargetException, InterruptedException {
		assertThrows(NullPointerException.class, ()->suggestionService.initializeSuggestionIndex());
		verify(suggestionService, never()).indexContexts(anyCollection());;
		verify(suggestionService, never()).buildIndexContext(anyList());
		verify(suggestionService, never()).createContext();
		Map<String, String> properties = Map.of("suggestionName", "1234", "directory.type", "bytebuffer");
		final SuggestionConfiguration config = converter.convert(properties).to(SuggestionConfiguration.class);
		// no analyzer
		suggestionService.setAnalyzer(analyzer);
		suggestionService.setDescriptor(descriptor);
		suggestionService.activate(config);
		AnalyzingInfixSuggester lookup = suggestionService.getLookup();
		assertNotNull(lookup);
		
		Promise<Void> p = suggestionService.getInitializationPromise();
		p.getValue();
		verify(suggestionService, times(1)).indexContexts(anyCollection());;
		verify(suggestionService, times(1)).buildIndexContext(anyList());
		verify(suggestionService, times(1)).createContext();
		verify(suggestionService, never()).indexContext(any());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testInitializeSuggestionIndex() throws ConfigurationException, InvocationTargetException, InterruptedException {
		when(descriptor.getObjectStream()).thenReturn(Stream.of("foo", "bar"));
		when(descriptor.getFields()).thenReturn(Set.of("fizz", "buzz"));
		when(descriptor.getLabels()).thenReturn(List.of("tag1", "tag2"));
		when(suggestionService.getPayload(any(), any())).thenAnswer(i->i.getArgument(0).toString() + "-id");
		when(suggestionService.getFieldValue(any(), any())).thenAnswer(i->"test" + i.getArgument(0).toString() + "-" + i.getArgument(1).toString());

		Map<String, String> properties = Map.of("suggestionName", "1234", "directory.type", "bytebuffer");
		final SuggestionConfiguration config = converter.convert(properties).to(SuggestionConfiguration.class);
		// no analyzer
		suggestionService.setAnalyzer(analyzer);
		suggestionService.setDescriptor(descriptor);
		suggestionService.activate(config);
		AnalyzingInfixSuggester lookup = suggestionService.getLookup();
		assertNotNull(lookup);
		
		
		Promise<Void> p = suggestionService.getInitializationPromise();
		p.getValue();
		verify(suggestionService, times(1)).indexContexts(anyCollection());;
		verify(suggestionService, times(1)).buildIndexContext(anyList());
		verify(suggestionService, times(1)).createContext();
		verify(suggestionService, times(4)).indexContext(any());
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testAutoCompletion() throws ConfigurationException, InvocationTargetException, InterruptedException {
		when(descriptor.getObjectStream()).thenReturn(Stream.of("foo", "bar", "fooz", "bazz"));
		when(descriptor.getFields()).thenReturn(Set.of("fizz", "buzz"));
		when(descriptor.getLabels()).thenReturn(List.of("tag1", "tag2"));
		when(suggestionService.getPayload(any(), any())).thenAnswer(i->i.getArgument(0).toString() + "-id");
		when(suggestionService.getFieldValue(any(), any())).thenAnswer(i->i.getArgument(0).toString() + "-" + i.getArgument(1).toString());

		Map<String, String> properties = Map.of("suggestionName", "1234", "directory.type", "bytebuffer");
		final SuggestionConfiguration config = converter.convert(properties).to(SuggestionConfiguration.class);
		// no analyzer
		suggestionService.setAnalyzer(analyzer);
		suggestionService.setDescriptor(descriptor);
		suggestionService.activate(config);
		
		Promise<Void> p = suggestionService.getInitializationPromise();
		p.getValue();
		verify(suggestionService, times(1)).indexContexts(anyCollection());;
		verify(suggestionService, times(1)).buildIndexContext(anyList());
		verify(suggestionService, times(1)).createContext();
		verify(suggestionService, times(8)).indexContext(any());
		
		Map<String, String> autoCompletion = suggestionService.getAutoCompletion("foo", new String[]{"tag2"});
		assertFalse(autoCompletion.isEmpty());
		assertEquals(4, autoCompletion.size());
		assertTrue(autoCompletion.keySet().contains("foo-fizz"));
		assertTrue(autoCompletion.keySet().contains("foo-buzz"));
		assertTrue(autoCompletion.keySet().contains("fooz-fizz"));
		assertTrue(autoCompletion.keySet().contains("fooz-buzz"));
		
		autoCompletion = suggestionService.getAutoCompletion("foo", new String[]{"tag3"});
		assertTrue(autoCompletion.isEmpty());
		
		autoCompletion = suggestionService.getAutoCompletion("baz", new String[]{"tag1", "tag3"});
		assertFalse(autoCompletion.isEmpty());
		assertEquals(2, autoCompletion.size());
		assertTrue(autoCompletion.keySet().contains("bazz-fizz"));
		assertTrue(autoCompletion.keySet().contains("bazz-buzz"));
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testCreateContext() {
		assertThrows(NullPointerException.class, ()->suggestionService.createContext());

		suggestionService.setDescriptor(descriptor);
		when(descriptor.getFields()).thenReturn(null);
		when(descriptor.getLabels()).thenReturn(null);
		when(descriptor.getObjectStream()).thenReturn(null);

		List<SuggestionContext> sctxList = suggestionService.createContext();
		assertTrue(sctxList.isEmpty());

		when(descriptor.getFields()).thenReturn(Set.of("ffoo"));
		when(suggestionService.getPayload(any(), any())).thenReturn("payload");
		when(suggestionService.getFieldValue(any(), any())).thenReturn("content");
		sctxList = suggestionService.createContext();
		assertTrue(sctxList.isEmpty());

		when(descriptor.getObjectStream()).thenReturn(Stream.of("fooo"));
		sctxList = suggestionService.createContext();
		assertEquals(1, sctxList.size());
		when(descriptor.getObjectStream()).thenReturn(Stream.of("fooo", "baro"));
		when(descriptor.getFields()).thenReturn(Set.of("ffoo", "ffizz"));
		sctxList = suggestionService.createContext();
		assertEquals(4, sctxList.size());
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testCreateContextISE() {
		assertThrows(NullPointerException.class, ()->suggestionService.createContext());
		assertThrows(NullPointerException.class, ()->suggestionService.createContext());

		suggestionService = mock(SuggestionServiceImpl.class);
		doCallRealMethod().when(suggestionService).setDescriptor(any());
		when(suggestionService.getDescriptor()).thenCallRealMethod();
		when(suggestionService.createContext()).thenCallRealMethod();
		when(suggestionService.createContextsForFields(any(), any(), any(), any(), anyInt())).thenThrow(IllegalStateException.class);

		SuggestionDescriptor descriptor = mock(SuggestionDescriptor.class);
		suggestionService.setDescriptor(descriptor);
		when(descriptor.getObjectStream()).thenReturn(Stream.of("fooo", "baro"));
		when(descriptor.getFields()).thenReturn(Set.of("ffoo"));
		when(descriptor.getLabels()).thenReturn(null);

		assertThrows(IllegalStateException.class, ()->suggestionService.createContext());
	}


	public <T> T createAbstractMock(Class<T> mockClass) {
		return mock(mockClass, 
				Mockito.withSettings().
				useConstructor().
				defaultAnswer(Mockito.CALLS_REAL_METHODS));
	}

}
