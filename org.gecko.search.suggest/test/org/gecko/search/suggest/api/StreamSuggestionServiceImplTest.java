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
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.mock;
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
import org.osgi.util.pushstream.PushStream;
import org.osgi.util.pushstream.PushStreamProvider;

/**
 * 
 * @author mark
 * @since 17.03.2023
 */
@ExtendWith(MockitoExtension.class)
public class StreamSuggestionServiceImplTest {

	private Analyzer analyzer = new StandardAnalyzer();
	@Mock
	private Configuration configuration;
	@SuppressWarnings("rawtypes")
	@Mock
	private SuggestionDescriptor descriptor;
	@SuppressWarnings("rawtypes")
	private StreamSuggestionServiceImpl suggestionService;
	private final Converter converter = Converters.standardConverter();

	@BeforeEach
	public void beforeEach() {
		suggestionService = createAbstractMock(StreamSuggestionServiceImpl.class);
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
		// no descriptor
		assertThrows(ConfigurationException.class, ()->suggestionService.activate(config));
		suggestionService.setDescriptor(descriptor);
		// no Context stream
		assertThrows(ConfigurationException.class, ()->suggestionService.activate(config));
		PushStreamProvider psp = new PushStreamProvider();
		PushStream<Object> pushStream = psp.streamOf(Stream.empty());
		suggestionService.setContextStream(pushStream);
		try {
			suggestionService.activate(config);
			AnalyzingInfixSuggester lookup = suggestionService.getLookup();
			assertNotNull(lookup);
		} catch (ConfigurationException e) {
			e.printStackTrace();
			fail("Unexpected exception");
		}
	}

//	@SuppressWarnings("unchecked")
//	@Test
//	public void testInitializeSuggestionIndex() throws ConfigurationException, InvocationTargetException, InterruptedException {
//		Map<String, String> properties = Map.of("suggestionName", "1234", "directory.type", "bytebuffer");
//		final SuggestionConfiguration config = converter.convert(properties).to(SuggestionConfiguration.class);
//		// no analyzer
//		suggestionService.setAnalyzer(analyzer);
//		suggestionService.setDescriptor(descriptor);
//		suggestionService.activate(config);
//		AnalyzingInfixSuggester lookup = suggestionService.getLookup();
//		assertNotNull(lookup);
//		
//		when(descriptor.getObjectStream()).thenReturn(Stream.of("foo", "bar"));
//		when(descriptor.getFields()).thenReturn(Set.of("fizz", "buzz"));
//		when(descriptor.getLabels()).thenReturn(List.of("tag1", "tag2"));
//		when(suggestionService.getPayload(any(), any())).thenAnswer(i->i.getArgument(0).toString() + "-id");
//		when(suggestionService.getFieldValue(any(), any())).thenAnswer(i->"test" + i.getArgument(0).toString() + "-" + i.getArgument(1).toString());
//		
//		Promise<Void> p = suggestionService.initializeSuggestionIndex();
//		p.getValue();
//		verify(suggestionService, times(1)).indexContexts(anyCollection());;
//		verify(suggestionService, times(1)).buildIndexContext(anyList());
//		verify(suggestionService, times(1)).createContext();
//		verify(suggestionService, times(4)).indexContext(any());
//		
//	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testAutoCompletion() throws ConfigurationException, InvocationTargetException, InterruptedException {
		when(descriptor.getFields()).thenReturn(Set.of("fizz", "buzz"));
		when(descriptor.getLabels()).thenReturn(List.of("tag1", "tag2"));
		when(suggestionService.getPayload(any(), any())).thenAnswer(i->i.getArgument(0).toString() + "-id");
		when(suggestionService.getFieldValue(any(), any())).thenAnswer(i->i.getArgument(0).toString() + "-" + i.getArgument(1).toString());

		Map<String, String> properties = Map.of("suggestionName", "1234", "directory.type", "bytebuffer");
		final SuggestionConfiguration config = converter.convert(properties).to(SuggestionConfiguration.class);
		// no analyzer
		suggestionService.setAnalyzer(analyzer);
		suggestionService.setDescriptor(descriptor);
		PushStreamProvider psp = new PushStreamProvider();
		PushStream<Object> pushStream = psp.streamOf(Stream.of("foo", "bar", "fooz", "bazz"));
		suggestionService.setContextStream(pushStream);
		suggestionService.activate(config);
		
		Promise<Void> initializationPromise = suggestionService.getInitializationPromise();
		initializationPromise.getValue();
		
		verify(suggestionService, times(4)).indexContexts(anyCollection());;
		verify(suggestionService, times(4)).buildIndexContext(anyList());
		verify(suggestionService, times(4)).createContext(any());
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

	public <T> T createAbstractMock(Class<T> mockClass) {
		return mock(mockClass, 
				Mockito.withSettings().
				useConstructor().
				defaultAnswer(Mockito.CALLS_REAL_METHODS));
	}

}
