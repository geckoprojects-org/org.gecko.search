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

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.Map;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.search.IndexSearcher;
import org.gecko.search.document.context.DocumentIndexContextObject;
import org.gecko.search.document.index.LuceneIndexImpl.Config;
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
import org.osgi.util.pushstream.PushStreamProvider;

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
	private DocumentIndexContextObject<?> dico;
	@SuppressWarnings("rawtypes")
	private LuceneIndexImpl indexService;
	private final Converter converter = Converters.standardConverter();
	private final PushStreamProvider psp = new PushStreamProvider();

	@BeforeEach
	public void beforeEach() {
		indexService = createAbstractMock(LuceneIndexImpl.class);
	}
	
	@AfterEach
	public void afterEach() {
		indexService.deactivate();
	}
	
	@Test
	public void testActivate() {
		assertThrows(NullPointerException.class, ()->indexService.activate(null, null));
		Map<String, String> properties = Map.of("id", "1234", "directory.type", "MMap");
		final Config config = converter.convert(properties).to(Config.class);
		assertThrows(ConfigurationException.class, ()->indexService.activate(config, ctx));
		indexService.deactivate();
		
		properties = Map.of("id", "1234", "directory.type", "MMap", "base.path", "/tmp/demo2");
		final Config config2 = converter.convert(properties).to(Config.class);
		// no event source
		assertThrows(NullPointerException.class, ()->indexService.activate(config2, ctx));
		indexService.deactivate();
		
		//no Analyzer
		when(indexService.createSimplePushEventSource()).thenReturn(psp.createSimpleEventSource(Object.class));
		assertThrows(NullPointerException.class, ()->indexService.activate(config2, ctx));
		indexService.deactivate();
		
		indexService.setAnalyzer(new StandardAnalyzer());
		
		try {
			indexService.activate(config2, ctx);
		} catch (ConfigurationException e) {
			fail("Unexpected exception");
		}
	}
	
	@Test
	public void testWrongPath() {
		Map<String, String> properties = Map.of("id", "1234", "directory.type", "MMap", "base.path", "");
		final Config config2 = converter.convert(properties).to(Config.class);
		// no event source
		indexService.setAnalyzer(new StandardAnalyzer());
		assertThrows(ConfigurationException.class, ()->indexService.activate(config2, ctx));
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
	
	
	private <T> T createAbstractMock(Class<T> mockClass) {
		return Mockito.mock(mockClass, 
				Mockito.withSettings().
				useConstructor().
				defaultAnswer(Mockito.CALLS_REAL_METHODS));
	}

}
