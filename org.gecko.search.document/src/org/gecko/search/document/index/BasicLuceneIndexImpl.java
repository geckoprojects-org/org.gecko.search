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

import static java.util.Objects.requireNonNull;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.search.SearcherManager;
import org.apache.lucene.store.ByteBuffersDirectory;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.NIOFSDirectory;
import org.gecko.search.document.context.DocumentIndexContextObject;
import org.osgi.framework.PrototypeServiceFactory;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.util.promise.PromiseFactory;

/**
 * Service implementation using a {@link SearcherManager} to enable NRT search.
 * Indexing triggers commits using the push stream. The searcher are registered as {@link PrototypeServiceFactory} that are created 
 * out of the {@link SearcherManager}
 * @param <O> the business object type
 * @param <D> the concrete {@link DocumentIndexContextObject} of the business object type
 * @author Juergen Albert, Mark Hoffmann
 * @since 08.03.2023
 */
public abstract class BasicLuceneIndexImpl {

	/** BASE_PATH */
	private static final String BASE_PATH = "base.path";
	private static final Logger LOGGER = Logger.getLogger(BasicLuceneIndexImpl.class.getName());

	private ExecutorService indexExecutors = null;
	private PromiseFactory pf = null;
	private Analyzer analyzer = null;
	private Directory directory;
	private int threadCount = 0;
	private Configuration configuration;
	
	public static interface Configuration {
		String getIndexName();
		String getBasePath();
		String getDirectoryType();
	}
	
	/**
	 * Creates a configuration, that is used for the setup. Must not be <code>null</code>
	 * @return a configuration, that is used for the setup
	 */
	abstract protected Configuration createConfiguration();

	/**
	 * Sets the analyzer.
	 * @param analyzer the analyzer to set
	 */
	public void setAnalyzer(Analyzer analyzer) {
		this.analyzer = analyzer;
	}

	/**
	 * Returns the analyzer.
	 * @return the analyzer
	 */
	protected Analyzer getAnalyzer() {
		return analyzer;
	}
	
	/**
	 * Returns the directory.
	 * @return the directory
	 */
	protected Directory getDirectory() {
		return directory;
	}
	
	/**
	 * Returns the configuration.
	 * @return the configuration
	 */
	protected Configuration getConfiguration() {
		return configuration;
	}
	
	/**
	 * Returns the {@link PromiseFactory}
	 * @return the {@link PromiseFactory}
	 */
	protected PromiseFactory getPromiseFactory() {
		return pf;
	}

	protected void activate() throws ConfigurationException {
		configuration = createConfiguration();
		requireNonNull(configuration);
		requireNonNull(analyzer);
		try {
			directory = initializeDirectory(configuration);
			initializeExecutors(configuration);
		} catch (IOException e) {
			throw new IllegalArgumentException(String.format("Could not open index directory for %s with message %s", configuration.getBasePath(), e.getMessage()), e);
		}
	}

	protected void deactivate() {
		if (directory != null) {
			try {
				directory.close();
			} catch (IOException e) {
				LOGGER.log(Level.SEVERE, e, ()->"Failed to close index directory");
			}
		}
	}

	/**
	 * Create the index creation location
	 * @param configuration the index configuration
	 * @throws ConfigurationException
	 */
	protected File initializeIndexLocation(Configuration configuration) throws ConfigurationException {
		requireNonNull(configuration);
		URL url = null;
		if(configuration.getBasePath().length() > 0) {
			try {
				url = new File(configuration.getBasePath()).toURI().toURL();
			} catch (MalformedURLException e) {
				throw new ConfigurationException(BASE_PATH, "Base path has an invalid format ", e);
			}
		}
		if(url == null) {
			throw new ConfigurationException(BASE_PATH, "The property is required");
		}
		try {
			URI uri = url.toURI();
	
			if(uri.getAuthority() != null && uri.getAuthority().length() > 0) {
				// Hack for UNC Path
				uri = (new URL("file://" + url.toString().substring("file:".length()))).toURI();
			}
			return new File(new File(uri), configuration.getIndexName());
		} catch (URISyntaxException | MalformedURLException e) {
			//Should not happen. It was already checked multiple times
			throw new ConfigurationException(BASE_PATH, "The given path.path format is invalid '" + url.toString() + "'", e);
		}
	}

	/**
	 * Creates a Lucene {@link Directory} dependent on the configuration
	 * @param configuration the service configuration
	 * @return the directory instance
	 * @throws IOException thrown on errors during directory creation
	 * @throws ConfigurationException 
	 */
	protected Directory initializeDirectory(Configuration configuration) throws IOException, ConfigurationException {
		File indexFolder = initializeIndexLocation(configuration);
		switch(configuration.getDirectoryType()) {
		case "NRT":
			directory = FSDirectory.open(indexFolder.toPath());
			break;
		case "ByteBuffer":
			directory = new ByteBuffersDirectory();
			break;
		case "FS":
			directory = FSDirectory.open(indexFolder.toPath());
			break;
		case "NIOFS":
			directory = new NIOFSDirectory(indexFolder.toPath());
			break;
		case "MMap":
		default:
			LOGGER.warning(String.format("Unrecognized directory format: '%s'; Falling back to system defaults", configuration.getDirectoryType()));
			directory = FSDirectory.open(indexFolder.toPath());
			break;
		}
		return directory;
	}

	/**
	 * Creates the setup for {@link ExecutorService} and {@link PromiseFactory}
	 * @param configuration the configuration
	 */
	protected void initializeExecutors(Configuration configuration) {
		indexExecutors = Executors.newFixedThreadPool(2, (r)->{
			Thread t = new Thread(r, "Index+Commit-" + threadCount++);
			t.setDaemon(true);
			return t;
		});
		pf = new PromiseFactory(indexExecutors);
	}

}
