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
package org.gecko.search;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.store.ByteBuffersDirectory;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.MMapDirectory;
import org.apache.lucene.store.NIOFSDirectory;
import org.gecko.search.BasicLuceneImpl.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.osgi.service.cm.ConfigurationException;

/**
 * 
 * @author mark
 * @since 14.03.2023
 */
@ExtendWith(MockitoExtension.class)
public class BasicLuceneIndexTest {

	@Mock
	private Configuration config;
	@Mock
	private Analyzer analyzer;
	private BasicLuceneImpl basicService;

	@BeforeEach
	public void beforeEach() {
		basicService = createAbstractMock(BasicLuceneImpl.class);
	}

	@AfterEach
	public void afterEach() {
		basicService.basicDeactivate();
	}
	
	@Test
	public void testActivate() throws IOException {
		assertNull(basicService.getPromiseFactory());
		assertNull(basicService.getIndexExecutors());
		assertNull(basicService.getConfiguration());
		assertNull(basicService.getDirectory());
		assertNull(basicService.getAnalyzer());
		// no analyzer, no config
		assertThrows(ConfigurationException.class, ()->basicService.activate());
		// no config
		basicService.setAnalyzer(analyzer);
		assertEquals(analyzer, basicService.getAnalyzer());
		
		assertThrows(ConfigurationException.class, ()->basicService.activate());
		assertNull(basicService.getConfiguration());
		assertNull(basicService.getDirectory());
		assertNull(basicService.getPromiseFactory());
		assertNull(basicService.getIndexExecutors());
		assertEquals(analyzer, basicService.getAnalyzer());
		
		// we have a analyzer and config; but the config will return nothing in its methods
		when(basicService.createConfiguration()).thenReturn(config);
		assertThrows(ConfigurationException.class, ()->basicService.activate());
		assertNull(basicService.getConfiguration());
		assertNull(basicService.getPromiseFactory());
		assertNull(basicService.getDirectory());
		assertNull(basicService.getIndexExecutors());
		assertEquals(analyzer, basicService.getAnalyzer());
		
		// return config id
		when(config.getIndexName()).thenReturn("foo");
		assertThrows(ConfigurationException.class, ()->basicService.activate());
		assertNull(basicService.getConfiguration());
		assertNull(basicService.getPromiseFactory());
		assertNull(basicService.getDirectory());
		assertNull(basicService.getIndexExecutors());
		assertEquals(analyzer, basicService.getAnalyzer());
		
		// return config path
		when(config.getBasePath()).thenReturn("foo/bar");
		assertThrows(ConfigurationException.class, ()->basicService.activate());
		assertNull(basicService.getConfiguration());
		assertNull(basicService.getPromiseFactory());
		assertNull(basicService.getDirectory());
		assertNull(basicService.getIndexExecutors());
		assertEquals(analyzer, basicService.getAnalyzer());
		
		// return config directoryType
		when(config.getDirectoryType()).thenReturn("ByteBuffer");
		assertEquals(analyzer, basicService.getAnalyzer());
		try {
			basicService.activate();
		} catch (ConfigurationException e) {
			fail("Unexpected exception while activating the service");
		}
		Directory d = basicService.getDirectory();
		assertNotNull(d);
		assertInstanceOf(ByteBuffersDirectory.class, d);
		assertNotNull(basicService.getPromiseFactory());
		assertNotNull(basicService.getIndexExecutors());
		assertEquals(analyzer, basicService.getAnalyzer());
		assertEquals(config, basicService.getConfiguration());
		
		// Test IOException handling
		when(basicService.doInitializeDirectory(any(Configuration.class), any(Directory.class))).thenThrow(new IOException());
		assertThrows(ConfigurationException.class, ()->basicService.activate());
		when(basicService.doInitializeDirectory(any(Configuration.class), any(Directory.class))).thenThrow(new RuntimeException());
		assertThrows(ConfigurationException.class, ()->basicService.activate());
		
	}
	
	@Test
	public void testDoCallbacks() throws IOException {
		assertNull(basicService.getPromiseFactory());
		assertNull(basicService.getIndexExecutors());
		assertNull(basicService.getConfiguration());
		assertNull(basicService.getDirectory());
		assertNull(basicService.getAnalyzer());
		
		basicService.setAnalyzer(analyzer);
		when(basicService.createConfiguration()).thenReturn(config);
		when(config.getIndexName()).thenReturn("foo");
		lenient().when(config.getBasePath()).thenReturn("foo/bar");
		when(config.getDirectoryType()).thenReturn("ByteBuffer");
		verify(basicService, never()).doInitializeDirectory(any(Configuration.class), any(Directory.class));
		verify(basicService, never()).doInitializeExecutors(any(Configuration.class));
		
		assertEquals(analyzer, basicService.getAnalyzer());
		try {
			basicService.activate();
		} catch (ConfigurationException e) {
			fail("Unexpected exception while activating the service");
		}
		Directory d = basicService.getDirectory();
		assertNotNull(d);
		assertInstanceOf(ByteBuffersDirectory.class, d);
		assertNotNull(basicService.getPromiseFactory());
		assertNotNull(basicService.getIndexExecutors());
		assertEquals(analyzer, basicService.getAnalyzer());
		assertEquals(config, basicService.getConfiguration());
		
		verify(basicService, times(1)).doInitializeDirectory(any(Configuration.class), any(Directory.class));
		verify(basicService, times(1)).doInitializeExecutors(any(Configuration.class));
	}

	@Test
	public void testBasicDeactivate() {
		try {
			basicService.basicDeactivate();

			basicService.setAnalyzer(analyzer);
			basicService.basicDeactivate();

			when(basicService.createConfiguration()).thenReturn(config);
			when(config.getIndexName()).thenReturn("foo");
			lenient().when(config.getBasePath()).thenReturn("foo/bar");
			when(config.getDirectoryType()).thenReturn("ByteBuffer");
			basicService.activate();
			Directory d = basicService.getDirectory();
			assertNotNull(d);
			assertInstanceOf(ByteBuffersDirectory.class, d);
			assertNotNull(basicService.getPromiseFactory());
			assertNotNull(basicService.getIndexExecutors());
			assertEquals(analyzer, basicService.getAnalyzer());
			assertEquals(config, basicService.getConfiguration());
			
			basicService.basicDeactivate();
			
			assertNull(basicService.getConfiguration());
			assertNull(basicService.getPromiseFactory());
			assertNull(basicService.getDirectory());
			assertNull(basicService.getIndexExecutors());
			assertEquals(analyzer, basicService.getAnalyzer());
		} catch (Exception e) {
			fail("Unexpected exception while deactivating the service");
		}
	}
	
	@Test
	public void testInitializeLocationSuccess() {
		
		assertThrows(NullPointerException.class, ()->basicService.initializeIndexLocation(null));
		
		lenient().when(config.getDirectoryType()).thenReturn("ByteBuffer");
		assertThrows(NullPointerException.class, ()->basicService.initializeIndexLocation(config));
		lenient().when(config.getIndexName()).thenReturn("foo");
		assertThrows(NullPointerException.class, ()->basicService.initializeIndexLocation(config));
		when(config.getBasePath()).thenReturn("foo/bar");
		try {
			File location = basicService.initializeIndexLocation(config);
			assertNotNull(location);
			String path = location.getAbsolutePath();
			assertTrue(path.endsWith("foo/bar/foo"));
		} catch (ConfigurationException e) {
			fail("unexpected exception in initializing location");
		}
		
	}
	
	@Test
	public void testInitializeLocationFailure() {
		
		assertThrows(NullPointerException.class, ()->basicService.initializeIndexLocation(null));
		
		lenient().when(config.getDirectoryType()).thenReturn("ByteBuffer");
		assertThrows(NullPointerException.class, ()->basicService.initializeIndexLocation(config));
		lenient().when(config.getIndexName()).thenReturn("foo");
		assertThrows(NullPointerException.class, ()->basicService.initializeIndexLocation(config));
		when(config.getBasePath()).thenReturn("");
		assertThrows(IllegalStateException.class, ()->basicService.initializeIndexLocation(config));
		
		AtomicInteger ai = new AtomicInteger();
		when(config.getBasePath()).then(i-> {
			if (ai.incrementAndGet() == 3) {
				throw new MalformedURLException("Nope");
			}
			return "/test";
		});
		assertThrows(IllegalStateException.class, ()->basicService.initializeIndexLocation(config));
		
	}
	
	@Test
	public void testDirectories() throws ConfigurationException {
		basicService.setAnalyzer(analyzer);
		when(basicService.createConfiguration()).thenReturn(config);
		when(config.getIndexName()).thenReturn("foo");
		when(config.getDirectoryType()).thenReturn("ByteBuffer");
		basicService.activate();
		Directory d = basicService.getDirectory();
		assertNotNull(d);
		assertInstanceOf(ByteBuffersDirectory.class, d);
		when(config.getBasePath()).thenReturn("foo/bar");
		when(config.getDirectoryType()).thenReturn("NIOFS");
		basicService.activate();
		d = basicService.getDirectory();
		assertNotNull(d);
		assertInstanceOf(NIOFSDirectory.class, d);
		when(config.getDirectoryType()).thenReturn("niofs");
		basicService.activate();
		d = basicService.getDirectory();
		assertNotNull(d);
		assertInstanceOf(NIOFSDirectory.class, d);
		when(config.getDirectoryType()).thenReturn("mmap");
		basicService.activate();
		d = basicService.getDirectory();
		assertNotNull(d);
		assertInstanceOf(MMapDirectory.class, d);
		when(config.getDirectoryType()).thenReturn("foo");
		basicService.activate();
		d = basicService.getDirectory();
		assertNotNull(d);
		assertTrue(d instanceof MMapDirectory || d instanceof NIOFSDirectory);
	}
	
	public <T> T createAbstractMock(Class<T> mockClass) {
		return Mockito.mock(mockClass, 
				Mockito.withSettings().
				useConstructor().
				defaultAnswer(Mockito.CALLS_REAL_METHODS));
	}
	
}
