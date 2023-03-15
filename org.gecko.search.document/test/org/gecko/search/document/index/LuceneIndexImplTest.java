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
package org.gecko.search.document.index;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.Directory;
import org.gecko.search.IndexListener;
import org.gecko.search.BasicLuceneImpl;
import org.gecko.search.BasicLuceneImpl.Configuration;
import org.gecko.search.document.context.DocumentIndexContextObject;
import org.gecko.search.document.index.LuceneIndexImpl.IndexConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.util.converter.Converter;
import org.osgi.util.converter.Converters;

/**
 * 
 * @author mark
 * @since 10.03.2023
 */
@ExtendWith(MockitoExtension.class)
public class LuceneIndexImplTest {
	
	@Mock
	private BundleContext ctx;
	@Mock
	private ServiceRegistration<?> registration;
	@Mock
	private IndexSearcher searcherMock;
	@Mock
	private Analyzer analyzer;
	@Mock
	private Directory directory;
	@Mock
	private DocumentIndexContextObject<?> dico;
	@SuppressWarnings("rawtypes")
	private LuceneIndexImpl indexService;
	private final Converter converter = Converters.standardConverter();

	@BeforeEach
	public void beforeEach() {
		indexService = createAbstractMock(LuceneIndexImpl.class);
	}
	
	@AfterEach
	public void afterEach() {
		indexService.deactivate();
	}
	
	@Test
	public void testActivate() throws ConfigurationException, IOException {
		// null parameters
		assertThrows(ConfigurationException.class, ()->indexService.activate(null, null));
		Map<String, String> properties = Map.of("id", "1234", "directory.type", "bytebuffer");
		final IndexConfig config = converter.convert(properties).to(IndexConfig.class); 
		// no analyzer
		assertThrows(ConfigurationException.class, ()->indexService.activate(config, ctx));
		indexService.setAnalyzer(analyzer);
		verify(indexService, never()).registerIndexSearcher(any(), any());
		try {
			indexService.activate(config, ctx);
		} catch (ConfigurationException e) {
			fail("Unexpected exception");
		}
		verify(indexService, times(1)).registerIndexSearcher(any(), any());
		
		when(indexService.doInitializeDirectory(any(Configuration.class), any(Directory.class))).thenThrow(new IOException());
		assertThrows(ConfigurationException.class, ()->indexService.activate(config, ctx));
		
	}
	
	@Test
	public void testActivateFailCreateConfig() throws ConfigurationException, IOException {
		indexService = Mockito.mock(LuceneIndexImpl.class);
		doCallRealMethod().when(indexService).activate(any(), any());
		doCallRealMethod().when(indexService).setAnalyzer(analyzer);
		when(indexService.createConfiguration()).thenThrow(NullPointerException.class);
		indexService.setAnalyzer(analyzer);
		Map<String, String> properties = Map.of("id", "1234", "directory.type", "bytebuffer");
		final IndexConfig config = converter.convert(properties).to(IndexConfig.class); 
		// npe createConfiguration
		assertThrows(ConfigurationException.class, ()->indexService.activate(config, ctx));
		verify(indexService, never()).registerIndexSearcher(any(), any());
	}
	
	@Test
	public void testActivateFailGetAnalyzer() throws ConfigurationException, IOException {
		indexService = Mockito.mock(LuceneIndexImpl.class);
		doCallRealMethod().when(indexService).activate(any(), any());
		doCallRealMethod().when(indexService).setAnalyzer(analyzer);
		when(indexService.doInitializeDirectory(any(), any())).thenCallRealMethod();
		when(indexService.createConfiguration()).thenCallRealMethod();
		when(indexService.getAnalyzer()).thenThrow(NullPointerException.class);
		indexService.setAnalyzer(analyzer);
		Map<String, String> properties = Map.of("id", "1234", "directory.type", "bytebuffer");
		final IndexConfig config = converter.convert(properties).to(IndexConfig.class); 
		// npe getAnalyzer
		assertThrows(ConfigurationException.class, ()->indexService.activate(config, ctx));
		verify(indexService, never()).registerIndexSearcher(any(), any());
	}
	
	@Test
	public void testActivateFailSuperActivate() throws ConfigurationException, IOException {
		indexService = Mockito.mock(LuceneIndexImpl.class);
		doCallRealMethod().when(indexService).activate(any(), any());
		doCallRealMethod().when(indexService).setAnalyzer(analyzer);
		when(indexService.createConfiguration()).thenThrow(NullPointerException.class);
		indexService.setAnalyzer(analyzer);
		Map<String, String> properties = Map.of("id", "1234", "directory.type", "bytebuffer");
		final IndexConfig config = converter.convert(properties).to(IndexConfig.class); 
		// npe getAnalyzer
		assertThrows(ConfigurationException.class, ()->indexService.activate(config, ctx));
		verify(indexService, never()).registerIndexSearcher(any(), any());
	}
	
	@Test
	public void testActivateFailGetDirectory() throws ConfigurationException, IOException {
		indexService = Mockito.mock(LuceneIndexImpl.class);
		doCallRealMethod().when(indexService).activate(any(), any());
		doCallRealMethod().when(indexService).setAnalyzer(analyzer);
		when(indexService.doInitializeDirectory(any(), any())).thenCallRealMethod();
		when(indexService.createConfiguration()).thenCallRealMethod();
		when(indexService.getAnalyzer()).thenCallRealMethod();
		when(indexService.getDirectory()).thenThrow(NullPointerException.class);
		indexService.setAnalyzer(analyzer);
		Map<String, String> properties = Map.of("id", "1234", "directory.type", "bytebuffer");
		final IndexConfig config = converter.convert(properties).to(IndexConfig.class); 
		// npe getDirectory
		assertThrows(ConfigurationException.class, ()->indexService.activate(config, ctx));
		verify(indexService, never()).registerIndexSearcher(any(), any());
	}
	
	@Test
	public void testActivateFailRegisterService() throws ConfigurationException, IOException {
		indexService = Mockito.mock(LuceneIndexImpl.class);
		doCallRealMethod().when(indexService).activate(any(), any());
		doCallRealMethod().when(indexService).setAnalyzer(analyzer);
		when(indexService.doInitializeDirectory(any(), any())).thenCallRealMethod();
		when(indexService.createConfiguration()).thenCallRealMethod();
		when(indexService.getAnalyzer()).thenCallRealMethod();
		when(indexService.getDirectory()).thenCallRealMethod();
		doThrow(RuntimeException.class).when(indexService).registerIndexSearcher(any(), any());
		indexService.setAnalyzer(analyzer);
		Map<String, String> properties = Map.of("id", "1234", "directory.type", "bytebuffer");
		final IndexConfig config = converter.convert(properties).to(IndexConfig.class); 
		// registerSearcher exception
		assertThrows(ConfigurationException.class, ()->indexService.activate(config, ctx));
		verify(indexService, times(1)).registerIndexSearcher(any(), any());
	}
	
	@Test
	public void testDeactivate() throws ConfigurationException {
		Map<String, String> properties = Map.of("id", "1234", "directory.type", "bytebuffer");
		final IndexConfig config = converter.convert(properties).to(IndexConfig.class); 
		indexService.setAnalyzer(analyzer);
		verify(indexService, never()).registerIndexSearcher(any(), any());
		indexService.activate(config, ctx);
		verify(indexService, times(1)).registerIndexSearcher(any(), any());
		
		try {
			indexService.deactivate();
		} catch (Exception e) {
			fail("Unexpected exception on deactivate");
		}
	}
	
	@Test
	public void testDeactivateFail() throws ConfigurationException, IOException {
		indexService = Mockito.mock(LuceneIndexImpl.class);
		doCallRealMethod().when(indexService).deactivate();
		doCallRealMethod().when(indexService).activate(any(), any());
		doCallRealMethod().when(indexService).setAnalyzer(analyzer);
		when(indexService.doInitializeDirectory(any(), any())).thenCallRealMethod();
		when(indexService.createConfiguration()).thenCallRealMethod();
		when(indexService.getAnalyzer()).thenCallRealMethod();
		when(indexService.getDirectory()).thenCallRealMethod();
		doThrow(IllegalStateException.class).when((BasicLuceneImpl)indexService).basicDeactivate();
		Map<String, String> properties = Map.of("id", "1234", "directory.type", "bytebuffer");
		final IndexConfig config = converter.convert(properties).to(IndexConfig.class); 
		indexService.setAnalyzer(analyzer);
		verify(indexService, never()).registerIndexSearcher(any(), any());
		indexService.activate(config, ctx);
		verify(indexService, times(1)).registerIndexSearcher(any(), any());
		try {
			indexService.deactivate();
		} catch (Exception e) {
			fail("Unexpected exception on deactivate");
		}
	}
	
	@Test
	public void testIndexListeners() {
		assertThrows(NullPointerException.class, ()->indexService.addIndexListener(null));
		IndexListener listener = Mockito.mock(IndexListener.class);
		assertTrue(indexService.getIndexListeners().isEmpty());
		indexService.addIndexListener(listener);
		assertEquals(1, indexService.getIndexListeners().size());
		assertEquals(listener, indexService.getIndexListeners().get(0));
		assertThrows(NullPointerException.class, ()->indexService.removeIndexListener(null));
		assertEquals(1, indexService.getIndexListeners().size());
		assertEquals(listener, indexService.getIndexListeners().get(0));
		IndexListener listener2 = Mockito.mock(IndexListener.class);
		indexService.removeIndexListener(listener2);
		assertEquals(1, indexService.getIndexListeners().size());
		assertEquals(listener, indexService.getIndexListeners().get(0));
		indexService.removeIndexListener(listener);
		assertTrue(indexService.getIndexListeners().isEmpty());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testNoActivationFail() {
		assertThrows(NullPointerException.class, ()->indexService.commit());
		assertThrows(NullPointerException.class, ()->indexService.aquireSearch());
		assertThrows(NullPointerException.class, ()->indexService.releaseSearcher(null));
		assertThrows(NullPointerException.class, ()->indexService.releaseSearcher(searcherMock));
		assertThrows(NullPointerException.class, ()->indexService.handleContext(null));
		assertThrows(NullPointerException.class, ()->indexService.handleContext(dico));
		assertThrows(NullPointerException.class, ()->indexService.handleContexts(null));
		assertThrows(NullPointerException.class, ()->indexService.handleContexts(Collections.singleton(dico)));
		assertThrows(NullPointerException.class, ()->indexService.handleContextsSync(null));
		assertThrows(NullPointerException.class, ()->indexService.handleContextsSync(Collections.singleton(dico)));
		assertThrows(NullPointerException.class, ()->indexService.handleContextSync(null));
		assertThrows(NullPointerException.class, ()->indexService.handleContextSync(dico));
	}
	
	public <T> T createAbstractMock(Class<T> mockClass) {
		return Mockito.mock(mockClass, 
				Mockito.withSettings().
				useConstructor().
				defaultAnswer(Mockito.CALLS_REAL_METHODS));
	}
	
}
