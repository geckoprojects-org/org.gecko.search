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
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
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
import java.util.concurrent.Executors;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.Directory;
import org.gecko.search.BasicLuceneImpl;
import org.gecko.search.BasicLuceneImpl.Configuration;
import org.gecko.search.IndexActionType;
import org.gecko.search.IndexListener;
import org.gecko.search.document.CommitCallback;
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
import org.osgi.service.cm.ConfigurationException;
import org.osgi.util.converter.Converter;
import org.osgi.util.converter.Converters;
import org.osgi.util.promise.FailedPromisesException;
import org.osgi.util.promise.Promise;
import org.osgi.util.promise.PromiseFactory;

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
	private Analyzer analyzer;
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
		indexService = mock(LuceneIndexImpl.class);
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
		indexService = mock(LuceneIndexImpl.class);
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
		indexService = mock(LuceneIndexImpl.class);
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
		indexService = mock(LuceneIndexImpl.class);
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
		indexService = mock(LuceneIndexImpl.class);
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
		indexService = mock(LuceneIndexImpl.class);
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
		IndexListener listener = mock(IndexListener.class);
		assertTrue(indexService.getIndexListeners().isEmpty());
		indexService.addIndexListener(listener);
		assertEquals(1, indexService.getIndexListeners().size());
		assertEquals(listener, indexService.getIndexListeners().get(0));
		assertThrows(NullPointerException.class, ()->indexService.removeIndexListener(null));
		assertEquals(1, indexService.getIndexListeners().size());
		assertEquals(listener, indexService.getIndexListeners().get(0));
		IndexListener listener2 = mock(IndexListener.class);
		indexService.removeIndexListener(listener2);
		assertEquals(1, indexService.getIndexListeners().size());
		assertEquals(listener, indexService.getIndexListeners().get(0));
		indexService.removeIndexListener(listener);
		assertTrue(indexService.getIndexListeners().isEmpty());
	}
	
	@Test
	public void testAquireSearcher() throws ConfigurationException {
		assertThrows(NullPointerException.class, ()->indexService.aquireSearch());
		Map<String, String> properties = Map.of("id", "1234", "directory.type", "bytebuffer");
		final IndexConfig config = converter.convert(properties).to(IndexConfig.class); 
		indexService.setAnalyzer(analyzer);
		indexService.activate(config, ctx);
		assertNotNull(indexService.aquireSearch());
		
	}
	
	@Test
	public void testReleaseSearcher() throws ConfigurationException {
		assertThrows(NullPointerException.class, ()->indexService.releaseSearcher(null));
		Map<String, String> properties = Map.of("id", "1234", "directory.type", "bytebuffer");
		final IndexConfig config = converter.convert(properties).to(IndexConfig.class); 
		indexService.setAnalyzer(analyzer);
		indexService.activate(config, ctx);
		IndexSearcher aquiredSearcher = indexService.aquireSearch();
		assertNotNull(aquiredSearcher);
		try {
			indexService.releaseSearcher(aquiredSearcher);
		} catch (Exception e) {
			fail("Unexpected exception on deactivate");
		}
		IndexSearcher mockedSearcher = mock(IndexSearcher.class);
		assertThrows(IllegalStateException.class, ()->indexService.releaseSearcher(mockedSearcher));
	}
	
	@Test
	public void testReleaseSearcherNoSearcherManager() throws ConfigurationException {
		indexService = mock(LuceneIndexImpl.class);
		IndexSearcher mockedSearcher = mock(IndexSearcher.class);
		when(indexService.getSearcherManager()).thenReturn(null);
		doCallRealMethod().when(indexService).releaseSearcher(any());
		assertThrows(NullPointerException.class, ()->indexService.releaseSearcher(mockedSearcher));
	}
	
	@Test
	public void testGetIndexWriter() throws ConfigurationException {
		assertThrows(NullPointerException.class, ()->indexService.getIndexWriter());
		Map<String, String> properties = Map.of("id", "1234", "directory.type", "bytebuffer");
		final IndexConfig config = converter.convert(properties).to(IndexConfig.class); 
		indexService.setAnalyzer(analyzer);
		indexService.activate(config, ctx);
		assertNotNull(indexService.getIndexWriter());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testCommit() throws ConfigurationException, InvocationTargetException, InterruptedException {
		// No promise factory
		assertThrows(NullPointerException.class, ()->indexService.commit());
		Map<String, String> properties = Map.of("id", "1234", "directory.type", "bytebuffer");
		final IndexConfig config = converter.convert(properties).to(IndexConfig.class); 
		indexService.setAnalyzer(analyzer);
		indexService.activate(config, ctx);
		assertNotNull(indexService.getPromiseFactory());
		Promise<Void> p = indexService.commit();
		Throwable failure = p.getFailure();
		assertNull(failure);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testCommitNoSearcherManager() throws ConfigurationException, InvocationTargetException, InterruptedException, IOException {
		// No promise factory
		indexService = mock(LuceneIndexImpl.class);
		doCallRealMethod().when(indexService).deactivate();
		doCallRealMethod().when(indexService).activate(any(), any());
		doCallRealMethod().when(indexService).setAnalyzer(analyzer);
		when(indexService.doInitializeDirectory(any(), any())).thenCallRealMethod();
		when(indexService.createConfiguration()).thenCallRealMethod();
		when(indexService.getAnalyzer()).thenCallRealMethod();
		when(indexService.getDirectory()).thenCallRealMethod();
		when(indexService.getPromiseFactory()).thenCallRealMethod();
		when(indexService.commit()).thenCallRealMethod();
		when(indexService.getIndexWriter()).thenCallRealMethod();
		when(indexService.getSearcherManager()).thenReturn(null);
		
		assertThrows(NullPointerException.class, ()->indexService.commit());
		
		Map<String, String> properties = Map.of("id", "1234", "directory.type", "bytebuffer");
		final IndexConfig config = converter.convert(properties).to(IndexConfig.class); 
		indexService.setAnalyzer(analyzer);
		indexService.activate(config, ctx);
		assertNotNull(indexService.getPromiseFactory());
		Promise<Void> p = indexService.commit();
		Throwable failure = p.getFailure();
		assertNull(failure);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testCommitFailNoWriter() throws ConfigurationException, InvocationTargetException, InterruptedException, IOException {
		// No promise factory
		indexService = mock(LuceneIndexImpl.class);
		doCallRealMethod().when(indexService).deactivate();
		doCallRealMethod().when(indexService).activate(any(), any());
		doCallRealMethod().when(indexService).setAnalyzer(analyzer);
		when(indexService.doInitializeDirectory(any(), any())).thenCallRealMethod();
		when(indexService.createConfiguration()).thenCallRealMethod();
		when(indexService.getAnalyzer()).thenCallRealMethod();
		when(indexService.getDirectory()).thenCallRealMethod();
		when(indexService.getPromiseFactory()).thenCallRealMethod();
		when(indexService.commit()).thenCallRealMethod();
		when(indexService.getIndexWriter()).thenReturn(null);
		
		assertThrows(NullPointerException.class, ()->indexService.commit());
		
		Map<String, String> properties = Map.of("id", "1234", "directory.type", "bytebuffer");
		final IndexConfig config = converter.convert(properties).to(IndexConfig.class); 
		indexService.setAnalyzer(analyzer);
		indexService.activate(config, ctx);
		assertNotNull(indexService.getPromiseFactory());
		Promise<Void> p = indexService.commit();
		Throwable failure = p.getFailure();
		assertNotNull(failure);
		assertInstanceOf(NullPointerException.class, failure);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testNotifyListeners() throws ConfigurationException, InvocationTargetException, InterruptedException {
		@SuppressWarnings("rawtypes")
		DocumentIndexContextObject dico = mock(DocumentIndexContextObject.class);
		assertThrows(NullPointerException.class, ()->indexService.notifyIndexListener(dico));
		assertTrue(indexService.getIndexListeners().isEmpty());
		// listener 1 can handle
		IndexListener listener01 = mock(IndexListener.class);
		when(listener01.canHandle(any())).thenReturn(Boolean.TRUE);
		indexService.addIndexListener(listener01);
		// listener 1 CANNOT handle
		IndexListener listener02 = mock(IndexListener.class);
		when(listener02.canHandle(any())).thenReturn(Boolean.FALSE);
		indexService.addIndexListener(listener02);
		assertEquals(2, indexService.getIndexListeners().size());
		Map<String, String> properties = Map.of("id", "1234", "directory.type", "bytebuffer");
		final IndexConfig config = converter.convert(properties).to(IndexConfig.class); 
		indexService.setAnalyzer(analyzer);
		indexService.activate(config, ctx);
		
		assertEquals(2, indexService.getIndexListeners().size());
		assertNotNull(indexService.getPromiseFactory());
		verify(listener01, never()).canHandle(any());
		verify(listener02, never()).canHandle(any());
		verify(listener01, never()).onIndex(any());
		verify(listener02, never()).onIndex(any());
		
		Promise<Void> p = indexService.notifyIndexListener(dico);
		p.getValue();
		assertNull(p.getFailure());
		verify(listener01, times(1)).canHandle(any());
		verify(listener02, times(1)).canHandle(any());
		verify(listener01, times(1)).onIndex(any());
		verify(listener02, never()).onIndex(any());
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testCommitWithCallbacksNoCommit() throws ConfigurationException, InvocationTargetException, InterruptedException {
		assertThrows(NullPointerException.class, ()->indexService.commitWithCommitCallbacks(null, true));
		assertThrows(NullPointerException.class, ()->indexService.commitWithCommitCallbacks(null, false));
		
		DocumentIndexContextObject dico01 = mock(DocumentIndexContextObject.class);
		CommitCallback cc01 = mock(CommitCallback.class);
		DocumentIndexContextObject dico02 = mock(DocumentIndexContextObject.class);
		CommitCallback cc02 = mock(CommitCallback.class);
		List<DocumentIndexContextObject> dicos = List.of(dico01, dico02);
//		
		assertThrows(NullPointerException.class, ()->indexService.commitWithCommitCallbacks(dicos, false));
		verify(dico01, never()).getCommitCallback();
		verify(cc01, never()).commited(any());
		verify(dico02, never()).getCommitCallback();
		verify(cc02, never()).commited(any());
		
		Map<String, String> properties = Map.of("id", "1234", "directory.type", "bytebuffer");
		final IndexConfig config = converter.convert(properties).to(IndexConfig.class); 
		indexService.setAnalyzer(analyzer);
		indexService.activate(config, ctx);
		
		Promise<Void> p = indexService.commitWithCommitCallbacks(dicos, false);
		p.getValue();
		verify(dico01, never()).getCommitCallback();
		verify(cc01, never()).commited(any());
		verify(dico02, never()).getCommitCallback();
		verify(cc02, never()).commited(any());
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testCommitWithCallbacksCommit() throws ConfigurationException, InvocationTargetException, InterruptedException {
		assertThrows(NullPointerException.class, ()->indexService.commitWithCommitCallbacks(null, true));
		assertThrows(NullPointerException.class, ()->indexService.commitWithCommitCallbacks(null, false));
		
		DocumentIndexContextObject dico01 = mock(DocumentIndexContextObject.class);
		CommitCallback cc01 = mock(CommitCallback.class);
		DocumentIndexContextObject dico02 = mock(DocumentIndexContextObject.class);
		CommitCallback cc02 = mock(CommitCallback.class);
		List<DocumentIndexContextObject> dicos = List.of(dico01, dico02);
//		
		assertThrows(NullPointerException.class, ()->indexService.commitWithCommitCallbacks(dicos, true));
		verify(dico01, never()).getCommitCallback();
		verify(cc01, never()).commited(any());
		verify(cc01, never()).error(any(), any());
		verify(dico02, never()).getCommitCallback();
		verify(cc02, never()).commited(any());
		verify(cc02, never()).error(any(), any());
		
		Map<String, String> properties = Map.of("id", "1234", "directory.type", "bytebuffer");
		final IndexConfig config = converter.convert(properties).to(IndexConfig.class); 
		indexService.setAnalyzer(analyzer);
		indexService.activate(config, ctx);
		
		Promise<Void> p = indexService.commitWithCommitCallbacks(dicos, true);
		p.getValue();
		verify(dico01, times(1)).getCommitCallback();
		verify(cc01, never()).commited(any());
		verify(cc01, never()).error(any(), any());
		verify(dico02, times(1)).getCommitCallback();
		verify(cc02, never()).commited(any());
		verify(cc02, never()).error(any(), any());
		
		when(dico01.getCommitCallback()).thenReturn(cc01);
		when(dico02.getCommitCallback()).thenReturn(cc02);
		p = indexService.commitWithCommitCallbacks(dicos, true);
		p.getValue();
		verify(dico01, times(2)).getCommitCallback();
		verify(cc01, times(1)).commited(any());
		verify(cc01, never()).error(any(), any());
		verify(dico02, times(2)).getCommitCallback();
		verify(cc02, times(1)).commited(any());
		verify(cc02, never()).error(any(), any());
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testCommitWithCallbacksCommitError() throws ConfigurationException, InvocationTargetException, InterruptedException, IOException {
		
		indexService = mock(LuceneIndexImpl.class);
		doCallRealMethod().when(indexService).deactivate();
		doCallRealMethod().when(indexService).activate(any(), any());
		doCallRealMethod().when(indexService).setAnalyzer(analyzer);
		when(indexService.doInitializeDirectory(any(), any())).thenCallRealMethod();
		when(indexService.createConfiguration()).thenCallRealMethod();
		when(indexService.getAnalyzer()).thenCallRealMethod();
		when(indexService.getDirectory()).thenCallRealMethod();
		when(indexService.commitWithCommitCallbacks(any(), anyBoolean())).thenCallRealMethod();
		
		DocumentIndexContextObject dico01 = mock(DocumentIndexContextObject.class);
		CommitCallback cc01 = mock(CommitCallback.class);
		DocumentIndexContextObject dico02 = mock(DocumentIndexContextObject.class);
		CommitCallback cc02 = mock(CommitCallback.class);
		List<DocumentIndexContextObject> dicos = List.of(dico01, dico02);
//		
		verify(dico01, never()).getCommitCallback();
		verify(cc01, never()).commited(any());
		verify(cc01, never()).error(any(), any());
		verify(dico02, never()).getCommitCallback();
		verify(cc02, never()).commited(any());
		verify(cc02, never()).error(any(), any());
		
		Map<String, String> properties = Map.of("id", "1234", "directory.type", "bytebuffer");
		final IndexConfig config = converter.convert(properties).to(IndexConfig.class); 
		indexService.setAnalyzer(analyzer);
		indexService.activate(config, ctx);
		
		
		when(dico01.getCommitCallback()).thenReturn(cc01);
		when(dico02.getCommitCallback()).thenReturn(cc02);
		
		PromiseFactory pf = new PromiseFactory(Executors.newSingleThreadExecutor());
		Promise<?> failed = pf.failed(new IllegalStateException());
		when(indexService.commit()).thenReturn(failed);
		Promise<Void> p = indexService.commitWithCommitCallbacks(dicos, true);
		assertNotNull(p.getFailure());
		
		verify(dico01, times(1)).getCommitCallback();
		verify(cc01, never()).commited(any());
		verify(cc01, times(1)).error(any(), any());
		verify(dico02, times(1)).getCommitCallback();
		verify(cc02, never()).commited(any());
		verify(cc02, times(1)).error(any(), any());
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testHandleContextNoCommit() throws InterruptedException, ConfigurationException, InvocationTargetException {
		assertThrows(NullPointerException.class, ()->indexService.internalHandleContext(null, true));
		assertThrows(NullPointerException.class, ()->indexService.internalHandleContext(null, false));
		
		Map<String, String> properties = Map.of("id", "1234", "directory.type", "bytebuffer");
		final IndexConfig config = converter.convert(properties).to(IndexConfig.class); 
		indexService.setAnalyzer(analyzer);
		indexService.activate(config, ctx);
		
		assertNotNull(indexService.getPromiseFactory());
		
		Promise<Void> p = indexService.internalHandleContext(null, false);
		Throwable failure = p.getFailure();
		assertNotNull(failure);
		assertInstanceOf(NullPointerException.class, failure);
		
		DocumentIndexContextObject dico01 = mock(DocumentIndexContextObject.class);
		CommitCallback cc01 = mock(CommitCallback.class);
		
		p = indexService.internalHandleContext(dico01, false);
		failure = p.getFailure();
		assertNotNull(failure);
		assertInstanceOf(NullPointerException.class, failure);
		
		verify(dico01, never()).getCommitCallback();
		verify(cc01, never()).commited(any());
		verify(cc01, never()).error(any(), any());
		
		when(dico01.getActionType()).thenReturn(IndexActionType.ADD);
		p = indexService.internalHandleContext(dico01, false);
		failure = p.getFailure();
		assertNull(failure);
		p.getValue();
		
		verify(dico01, never()).getCommitCallback();
		verify(cc01, never()).commited(any());
		verify(cc01, never()).error(any(), any());
		
		IndexListener listener = mock(IndexListener.class);
		when(listener.canHandle(any())).thenReturn(Boolean.TRUE);
		indexService.addIndexListener(listener);
		
		verify(listener, never()).canHandle(any());
		verify(listener, never()).onIndex(any());
		verify(dico01, never()).getCommitCallback();
		verify(cc01, never()).commited(any());
		verify(cc01, never()).error(any(), any());
		
		p = indexService.internalHandleContext(dico01, false);
		failure = p.getFailure();
		assertNull(failure);
		p.getValue();
		
		verify(dico01, never()).getCommitCallback();
		verify(cc01, never()).commited(any());
		verify(cc01, never()).error(any(), any());
		verify(listener, times(1)).canHandle(any());
		verify(listener, times(1)).onIndex(any());
		when(listener.canHandle(any())).thenReturn(Boolean.FALSE);

		p = indexService.internalHandleContext(dico01, false);
		failure = p.getFailure();
		assertNull(failure);
		p.getValue();
		
		verify(dico01, never()).getCommitCallback();
		verify(cc01, never()).commited(any());
		verify(cc01, never()).error(any(), any());
		verify(listener, times(2)).canHandle(any());
		verify(listener, times(1)).onIndex(any());
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testHandleContextCommit() throws InterruptedException, ConfigurationException, InvocationTargetException {
		assertThrows(NullPointerException.class, ()->indexService.internalHandleContext(null, true));
		assertThrows(NullPointerException.class, ()->indexService.internalHandleContext(null, false));
		
		Map<String, String> properties = Map.of("id", "1234", "directory.type", "bytebuffer");
		final IndexConfig config = converter.convert(properties).to(IndexConfig.class); 
		indexService.setAnalyzer(analyzer);
		indexService.activate(config, ctx);
		
		assertNotNull(indexService.getPromiseFactory());
		
		Promise<Void> p = indexService.internalHandleContext(null, true);
		Throwable failure = p.getFailure();
		assertNotNull(failure);
		assertInstanceOf(NullPointerException.class, failure);
		
		DocumentIndexContextObject dico01 = mock(DocumentIndexContextObject.class);
		CommitCallback cc01 = mock(CommitCallback.class);
		
		p = indexService.internalHandleContext(dico01, true);
		failure = p.getFailure();
		assertNotNull(failure);
		assertInstanceOf(NullPointerException.class, failure);
		
		verify(dico01, never()).getCommitCallback();
		verify(cc01, never()).commited(any());
		verify(cc01, never()).error(any(), any());
		
		when(dico01.getCommitCallback()).thenReturn(cc01);
		when(dico01.getActionType()).thenReturn(IndexActionType.ADD);
		p = indexService.internalHandleContext(dico01, true);
		failure = p.getFailure();
		assertNull(failure);
		p.getValue();
		
		verify(dico01, times(1)).getCommitCallback();
		verify(cc01, times(1)).commited(any());
		verify(cc01, never()).error(any(), any());
		
		IndexListener listener = mock(IndexListener.class);
		when(listener.canHandle(any())).thenReturn(Boolean.TRUE);
		indexService.addIndexListener(listener);
		
		verify(listener, never()).canHandle(any());
		verify(listener, never()).onIndex(any());
		
		p = indexService.internalHandleContext(dico01, true);
		failure = p.getFailure();
		assertNull(failure);
		p.getValue();
		
		verify(dico01, times(2)).getCommitCallback();
		verify(cc01, times(2)).commited(any());
		verify(cc01, never()).error(any(), any());
		verify(listener, times(1)).canHandle(any());
		verify(listener, times(1)).onIndex(any());
		when(listener.canHandle(any())).thenReturn(Boolean.FALSE);
		
		p = indexService.internalHandleContext(dico01, true);
		failure = p.getFailure();
		assertNull(failure);
		p.getValue();
		
		verify(dico01, times(3)).getCommitCallback();
		verify(cc01, times(3)).commited(any());
		verify(cc01, never()).error(any(), any());
		verify(listener, times(2)).canHandle(any());
		verify(listener, times(1)).onIndex(any());
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testHandleContextCommitError() throws InterruptedException, ConfigurationException, InvocationTargetException, IOException {
		assertThrows(NullPointerException.class, ()->indexService.internalHandleContext(null, true));
		assertThrows(NullPointerException.class, ()->indexService.internalHandleContext(null, false));
		
		indexService = mock(LuceneIndexImpl.class);
		doCallRealMethod().when(indexService).deactivate();
		doCallRealMethod().when(indexService).activate(any(), any());
		doCallRealMethod().when(indexService).setAnalyzer(analyzer);
		when(indexService.doInitializeDirectory(any(), any())).thenCallRealMethod();
		when(indexService.createConfiguration()).thenCallRealMethod();
		when(indexService.getAnalyzer()).thenCallRealMethod();
		when(indexService.getDirectory()).thenCallRealMethod();
		when(indexService.getPromiseFactory()).thenCallRealMethod();
		when(indexService.commitWithCommitCallbacks(any(), anyBoolean())).thenCallRealMethod();
		when(indexService.internalHandleContext(any(), anyBoolean())).thenCallRealMethod();
		
		Map<String, String> properties = Map.of("id", "1234", "directory.type", "bytebuffer");
		final IndexConfig config = converter.convert(properties).to(IndexConfig.class); 
		indexService.setAnalyzer(analyzer);
		indexService.activate(config, ctx);
		
		assertNotNull(indexService.getPromiseFactory());
		
		DocumentIndexContextObject dico01 = mock(DocumentIndexContextObject.class);
		CommitCallback cc01 = mock(CommitCallback.class);
		
		verify(dico01, never()).getCommitCallback();
		verify(cc01, never()).commited(any());
		verify(cc01, never()).error(any(), any());
		
		when(dico01.getCommitCallback()).thenReturn(cc01);
		when(dico01.getActionType()).thenReturn(IndexActionType.ADD);
		PromiseFactory pf = new PromiseFactory(Executors.newSingleThreadExecutor());
		Promise<?> failed = pf.failed(new IllegalStateException());
		when(indexService.commit()).thenReturn(failed);
		
		Promise<Void> p = indexService.internalHandleContext(dico01, true);
		Throwable failure = p.getFailure();
		assertNotNull(failure);
		
		verify(dico01, times(1)).getCommitCallback();
		verify(cc01, never()).commited(any());
		verify(cc01, times(1)).error(any(), any());
		
		IndexListener listener = mock(IndexListener.class);
		indexService.addIndexListener(listener);
		
		verify(listener, never()).canHandle(any());
		verify(listener, never()).onIndex(any());
		
		p = indexService.internalHandleContext(dico01, true);
		failure = p.getFailure();
		assertNotNull(failure);
		
		verify(dico01, times(2)).getCommitCallback();
		verify(cc01, never()).commited(any());
		verify(cc01, times(2)).error(any(), any());
		verify(listener, never()).canHandle(any());
		verify(listener, never()).onIndex(any());
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testHandleContextsNoCommit() throws InterruptedException, ConfigurationException, InvocationTargetException {
		assertThrows(NullPointerException.class, ()->indexService.internalHandleContexts(null, true));
		assertThrows(NullPointerException.class, ()->indexService.internalHandleContexts(null, false));
		
		Map<String, String> properties = Map.of("id", "1234", "directory.type", "bytebuffer");
		final IndexConfig config = converter.convert(properties).to(IndexConfig.class); 
		indexService.setAnalyzer(analyzer);
		indexService.activate(config, ctx);
		
		assertNotNull(indexService.getPromiseFactory());
		
		Promise<List<Void>> p = indexService.internalHandleContext(null, false);
		Throwable failure = p.getFailure();
		assertNotNull(failure);
		assertInstanceOf(NullPointerException.class, failure);
		
		DocumentIndexContextObject dico01 = mock(DocumentIndexContextObject.class);
		DocumentIndexContextObject dico02 = mock(DocumentIndexContextObject.class);
		DocumentIndexContextObject dico03 = mock(DocumentIndexContextObject.class);
		CommitCallback cc01 = mock(CommitCallback.class);
		CommitCallback cc02 = mock(CommitCallback.class);
		CommitCallback cc03 = mock(CommitCallback.class);
		List<DocumentIndexContextObject> dicos = List.of(dico01, dico02, dico03);
		
		p = indexService.internalHandleContexts(dicos, false);
		failure = p.getFailure();
		assertNotNull(failure);
		assertInstanceOf(FailedPromisesException.class, failure);
		Collection<Promise<?>> failedPromises = ((FailedPromisesException)failure).getFailedPromises();
		assertEquals(3, failedPromises.size());
		
		verify(dico01, never()).getCommitCallback();
		verify(cc01, never()).commited(any());
		verify(cc01, never()).error(any(), any());
		verify(dico02, never()).getCommitCallback();
		verify(cc02, never()).commited(any());
		verify(cc02, never()).error(any(), any());
		verify(dico03, never()).getCommitCallback();
		verify(cc03, never()).commited(any());
		verify(cc03, never()).error(any(), any());
		
		when(dico01.getActionType()).thenReturn(IndexActionType.ADD);
		when(dico02.getActionType()).thenReturn(IndexActionType.ADD);
		when(dico03.getActionType()).thenReturn(IndexActionType.ADD);
		p = indexService.internalHandleContexts(dicos, false);
		failure = p.getFailure();
		assertNull(failure);
		p.getValue();
		
		verify(dico01, never()).getCommitCallback();
		verify(cc01, never()).commited(any());
		verify(cc01, never()).error(any(), any());
		verify(dico02, never()).getCommitCallback();
		verify(cc02, never()).commited(any());
		verify(cc02, never()).error(any(), any());
		verify(dico03, never()).getCommitCallback();
		verify(cc03, never()).commited(any());
		verify(cc03, never()).error(any(), any());
		
		IndexListener listener = mock(IndexListener.class);
		when(listener.canHandle(any())).thenReturn(Boolean.TRUE);
		indexService.addIndexListener(listener);
		
		verify(listener, never()).canHandle(any());
		verify(listener, never()).onIndex(any());
		verify(dico01, never()).getCommitCallback();
		verify(cc01, never()).commited(any());
		verify(cc01, never()).error(any(), any());
		verify(dico02, never()).getCommitCallback();
		verify(cc02, never()).commited(any());
		verify(cc02, never()).error(any(), any());
		verify(dico03, never()).getCommitCallback();
		verify(cc03, never()).commited(any());
		verify(cc03, never()).error(any(), any());
		
		p = indexService.internalHandleContexts(dicos, false);
		failure = p.getFailure();
		assertNull(failure);
		p.getValue();
		
		verify(dico01, never()).getCommitCallback();
		verify(cc01, never()).commited(any());
		verify(cc01, never()).error(any(), any());
		verify(dico02, never()).getCommitCallback();
		verify(cc02, never()).commited(any());
		verify(cc02, never()).error(any(), any());
		verify(dico03, never()).getCommitCallback();
		verify(cc03, never()).commited(any());
		verify(cc03, never()).error(any(), any());
		verify(listener, times(3)).canHandle(any());
		verify(listener, times(3)).onIndex(any());
		when(listener.canHandle(any())).thenReturn(Boolean.FALSE);
		
		p = indexService.internalHandleContexts(dicos, false);
		failure = p.getFailure();
		assertNull(failure);
		p.getValue();
		
		verify(dico01, never()).getCommitCallback();
		verify(cc01, never()).commited(any());
		verify(cc01, never()).error(any(), any());
		verify(dico02, never()).getCommitCallback();
		verify(cc02, never()).commited(any());
		verify(cc02, never()).error(any(), any());
		verify(dico03, never()).getCommitCallback();
		verify(cc03, never()).commited(any());
		verify(cc03, never()).error(any(), any());
		verify(listener, times(6)).canHandle(any());
		verify(listener, times(3)).onIndex(any());
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testHandleContextsCommit() throws InterruptedException, ConfigurationException, InvocationTargetException {
		assertThrows(NullPointerException.class, ()->indexService.internalHandleContexts(null, true));
		assertThrows(NullPointerException.class, ()->indexService.internalHandleContexts(null, false));
		
		Map<String, String> properties = Map.of("id", "1234", "directory.type", "bytebuffer");
		final IndexConfig config = converter.convert(properties).to(IndexConfig.class); 
		indexService.setAnalyzer(analyzer);
		indexService.activate(config, ctx);
		
		assertNotNull(indexService.getPromiseFactory());
		
		Promise<Void> p = indexService.internalHandleContext(null, true);
		Throwable failure = p.getFailure();
		assertNotNull(failure);
		assertInstanceOf(NullPointerException.class, failure);
		
		DocumentIndexContextObject dico01 = mock(DocumentIndexContextObject.class);
		DocumentIndexContextObject dico02 = mock(DocumentIndexContextObject.class);
		DocumentIndexContextObject dico03 = mock(DocumentIndexContextObject.class);
		CommitCallback cc01 = mock(CommitCallback.class);
		CommitCallback cc02 = mock(CommitCallback.class);
		List<DocumentIndexContextObject> dicos = List.of(dico01, dico02, dico03);
		
		p = indexService.internalHandleContexts(dicos, true);
		failure = p.getFailure();
		assertNotNull(failure);
		assertInstanceOf(FailedPromisesException.class, failure);
		Collection<Promise<?>> failedPromises = ((FailedPromisesException)failure).getFailedPromises();
		assertEquals(3, failedPromises.size());
		
		verify(dico01, never()).getCommitCallback();
		verify(cc01, never()).commited(any());
		verify(cc01, never()).error(any(), any());
		verify(dico02, never()).getCommitCallback();
		verify(cc02, never()).commited(any());
		verify(cc02, never()).error(any(), any());
		verify(dico03, never()).getCommitCallback();
		
		when(dico01.getCommitCallback()).thenReturn(cc01);
		when(dico02.getCommitCallback()).thenReturn(cc02);
		when(dico01.getActionType()).thenReturn(IndexActionType.ADD);
		when(dico02.getActionType()).thenReturn(IndexActionType.ADD);
		when(dico03.getActionType()).thenReturn(IndexActionType.ADD);
		p = indexService.internalHandleContexts(dicos, true);
		failure = p.getFailure();
		assertNull(failure);
		p.getValue();
		
		verify(dico01, times(1)).getCommitCallback();
		verify(cc01, times(1)).commited(any());
		verify(cc01, never()).error(any(), any());
		verify(dico02, times(1)).getCommitCallback();
		verify(cc02, times(1)).commited(any());
		verify(cc02, never()).error(any(), any());
		verify(dico03, times(1)).getCommitCallback();
		
		IndexListener listener = mock(IndexListener.class);
		when(listener.canHandle(any())).thenReturn(Boolean.TRUE);
		indexService.addIndexListener(listener);
		
		verify(listener, never()).canHandle(any());
		verify(listener, never()).onIndex(any());
		
		p = indexService.internalHandleContexts(dicos, true);
		failure = p.getFailure();
		assertNull(failure);
		p.getValue();
		
		verify(dico01, times(2)).getCommitCallback();
		verify(cc01, times(2)).commited(any());
		verify(cc01, never()).error(any(), any());
		verify(dico02, times(2)).getCommitCallback();
		verify(cc02, times(2)).commited(any());
		verify(cc02, never()).error(any(), any());
		verify(dico03, times(2)).getCommitCallback();
		verify(listener, times(3)).canHandle(any());
		verify(listener, times(3)).onIndex(any());
		when(listener.canHandle(any())).thenReturn(Boolean.FALSE);
		
		p = indexService.internalHandleContexts(dicos, true);
		failure = p.getFailure();
		assertNull(failure);
		p.getValue();
		
		verify(dico01, times(3)).getCommitCallback();
		verify(cc01, times(3)).commited(any());
		verify(cc01, never()).error(any(), any());
		verify(dico02, times(3)).getCommitCallback();
		verify(cc02, times(3)).commited(any());
		verify(cc02, never()).error(any(), any());
		verify(dico03, times(3)).getCommitCallback();
		verify(listener, times(6)).canHandle(any());
		verify(listener, times(3)).onIndex(any());
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testHandleContextsCommitError() throws InterruptedException, ConfigurationException, InvocationTargetException, IOException {
		assertThrows(NullPointerException.class, ()->indexService.internalHandleContexts(null, true));
		assertThrows(NullPointerException.class, ()->indexService.internalHandleContexts(null, false));
		
		indexService = mock(LuceneIndexImpl.class);
		doCallRealMethod().when(indexService).deactivate();
		doCallRealMethod().when(indexService).activate(any(), any());
		doCallRealMethod().when(indexService).setAnalyzer(analyzer);
		when(indexService.doInitializeDirectory(any(), any())).thenCallRealMethod();
		when(indexService.createConfiguration()).thenCallRealMethod();
		when(indexService.getAnalyzer()).thenCallRealMethod();
		when(indexService.getDirectory()).thenCallRealMethod();
		when(indexService.getPromiseFactory()).thenCallRealMethod();
		when(indexService.commitWithCommitCallbacks(any(), anyBoolean())).thenCallRealMethod();
		when(indexService.internalHandleContext(any(), anyBoolean())).thenCallRealMethod();
		when(indexService.internalHandleContexts(any(), anyBoolean())).thenCallRealMethod();
		
		Map<String, String> properties = Map.of("id", "1234", "directory.type", "bytebuffer");
		final IndexConfig config = converter.convert(properties).to(IndexConfig.class); 
		indexService.setAnalyzer(analyzer);
		indexService.activate(config, ctx);
		
		assertNotNull(indexService.getPromiseFactory());
		
		DocumentIndexContextObject dico01 = mock(DocumentIndexContextObject.class);
		DocumentIndexContextObject dico02 = mock(DocumentIndexContextObject.class);
		DocumentIndexContextObject dico03 = mock(DocumentIndexContextObject.class);
		CommitCallback cc01 = mock(CommitCallback.class);
		CommitCallback cc02 = mock(CommitCallback.class);
		List<DocumentIndexContextObject> dicos = List.of(dico01, dico02, dico03);
		
		verify(dico01, never()).getCommitCallback();
		verify(cc01, never()).commited(any());
		verify(cc01, never()).error(any(), any());
		verify(dico02, never()).getCommitCallback();
		verify(cc02, never()).commited(any());
		verify(cc02, never()).error(any(), any());
		verify(dico03, never()).getCommitCallback();
		
		when(dico01.getCommitCallback()).thenReturn(cc01);
		when(dico02.getCommitCallback()).thenReturn(cc02);
		when(dico01.getActionType()).thenReturn(IndexActionType.ADD);
		when(dico02.getActionType()).thenReturn(IndexActionType.ADD);
		when(dico03.getActionType()).thenReturn(IndexActionType.ADD);
		
		PromiseFactory pf = new PromiseFactory(Executors.newSingleThreadExecutor());
		Promise<?> failed = pf.failed(new IllegalStateException());
		when(indexService.commit()).thenReturn(failed);
		
		Promise<Void> p = indexService.internalHandleContexts(dicos, true);
		Throwable failure = p.getFailure();
		assertNotNull(failure);
		assertInstanceOf(IllegalStateException.class, failure);
		
		verify(dico01, times(1)).getCommitCallback();
		verify(cc01, never()).commited(any());
		verify(cc01, times(1)).error(any(), any());
		verify(dico02, times(1)).getCommitCallback();
		verify(cc02, never()).commited(any());
		verify(cc02, times(1)).error(any(), any());
		verify(dico03, times(1)).getCommitCallback();
		
		IndexListener listener = mock(IndexListener.class);
		indexService.addIndexListener(listener);
		
		verify(listener, never()).canHandle(any());
		verify(listener, never()).onIndex(any());
		
		p = indexService.internalHandleContexts(dicos, true);
		failure = p.getFailure();
		assertNotNull(failure);
		
		verify(dico01, times(2)).getCommitCallback();
		verify(cc01, never()).commited(any());
		verify(cc01, times(2)).error(any(), any());
		verify(dico02, times(2)).getCommitCallback();
		verify(cc02, never()).commited(any());
		verify(cc02, times(2)).error(any(), any());
		verify(dico03, times(2)).getCommitCallback();
		verify(listener, never()).canHandle(any());
		verify(listener, never()).onIndex(any());
	}
	
	public <T> T createAbstractMock(Class<T> mockClass) {
		return mock(mockClass, 
				Mockito.withSettings().
				useConstructor().
				defaultAnswer(Mockito.CALLS_REAL_METHODS));
	}
	
}
