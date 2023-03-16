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

import static java.util.Objects.requireNonNull;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.search.SearcherManager;
import org.apache.lucene.store.ByteBuffersDirectory;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.MMapDirectory;
import org.apache.lucene.store.NIOFSDirectory;
import org.osgi.framework.PrototypeServiceFactory;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.util.promise.PromiseFactory;

/**
 * Basic implementation creating a Lucene {@link Directory} with an {@link Analyzer}. The directory will be created out of an simple configuration.
 * Beside that this basis class provided clean-up functionality and delegates
 * Indexing triggers commits using the push stream. The searcher are registered as {@link PrototypeServiceFactory} that are created 
 * out of the {@link SearcherManager}
 * @param <O> the business object type
 * @param <D> the concrete {@link DocumentIndexContextObject} of the business object type
 * @author Juergen Albert, Mark Hoffmann
 * @since 08.03.2023
 */
public abstract class BasicLuceneImpl {

	/** BASE_PATH */
	private static final String BASE_PATH = "base.path";
	private static final Logger LOGGER = Logger.getLogger(BasicLuceneImpl.class.getName());

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
	 * Sets the analyzer.
	 * @param analyzer the analyzer to set
	 */
	public void setAnalyzer(Analyzer analyzer) {
		this.analyzer = analyzer;
	}

	/**
	 * Creates a configuration, that is used for the setup. Must not be <code>null</code>
	 * @return a configuration, that is used for the setup
	 */
	abstract public Configuration createInternalConfiguration();

	/**
	 * Returns the analyzer.
	 * @return the analyzer
	 */
	public Analyzer getAnalyzer() {
		return analyzer;
	}

	/**
	 * Returns the directory.
	 * @return the directory
	 */
	public Directory getDirectory() {
		return directory;
	}

	/**
	 * Returns the configuration.
	 * @return the configuration
	 */
	protected Configuration getInternalConfiguration() {
		return configuration;
	}

	/**
	 * Returns the {@link PromiseFactory}
	 * @return the {@link PromiseFactory}
	 */
	public PromiseFactory getPromiseFactory() {
		return pf;
	}

	/**
	 * Returns the indexExecutors.
	 * @return the indexExecutors
	 */
	public ExecutorService getIndexExecutors() {
		return indexExecutors;
	}

	/**
	 * Activates the Lucene index
	 * @throws ConfigurationException
	 */
	public final void activate() throws ConfigurationException {
		try {
			Configuration c = createInternalConfiguration();
			requireNonNull(c);
			requireNonNull(analyzer);
			directory = initializeDirectory(c);
			initializeExecutors(c);
			this.configuration = c;
		} catch (IOException e) {
			throw new ConfigurationException(BASE_PATH, String.format("Could not open index directory for %s with message %s", configuration.getBasePath(), e.getMessage()), e);
		} catch (Exception e) {
			throw new ConfigurationException(BASE_PATH, String.format("Error getting appropriate configuration for (Analyzer is missing?) with message: %s", e.getMessage()), e);
		}
	}

	/**
	 * Deactivates the index
	 */
	public void basicDeactivate() {
		if (indexExecutors != null) {
			indexExecutors.shutdown();// $COVERAGE-IGNORE$
			try {
				if (!indexExecutors.awaitTermination(800, TimeUnit.MILLISECONDS)) {// $COVERAGE-IGNORE$
					indexExecutors.shutdownNow();// $COVERAGE-IGNORE$
				} 
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				indexExecutors.shutdownNow();// $COVERAGE-IGNORE$
			} finally {
				pf = null;
				indexExecutors = null;
			}
		}
		if (directory != null) {
			try {
				directory.close();// $COVERAGE-IGNORE$
			} catch (IOException e) {
				LOGGER.log(Level.SEVERE, e, ()->"Failed to close index directory");
			} finally {
				directory = null;
			}
		}
		if (configuration != null) {
			configuration = null;
		}
	}

	/**
	 * Create the index creation location
	 * @param configuration the index configuration
	 * @throws ConfigurationException
	 */
	protected File initializeIndexLocation(Configuration configuration) throws ConfigurationException {
		requireNonNull(configuration);
		requireNonNull(configuration.getBasePath());
		requireNonNull(configuration.getIndexName());
		URL url = null;
		if(configuration.getBasePath().length() > 0) {
			try {
				url = new File(configuration.getBasePath()).toURI().toURL();
			} catch (MalformedURLException e) {
				throw new IllegalStateException(String.format("Base path has an invalid format: '%s' ", configuration.getBasePath()), e);
			}
		}
		if(url == null) {
			throw new IllegalStateException(String.format("The url is null: '%s'", configuration.getBasePath()));
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
			throw new IllegalStateException(String.format("The given base.path format is invalid '%s'", url.toString()), e);
		}
	}

	/**
	 * Executes additional directory initialization steps
	 * @param configuration the configuration
	 * @param directory the pre-created directory
	 * @return the directory
	 */
	public Directory doInitializeDirectory(Configuration configuration, Directory directory) throws IOException {
		return directory;
	}

	/**
	 * Executes additional executor initialization steps
	 * @param configuration	the configuration
	 */
	public void doInitializeExecutors(Configuration configuration) {
		// To be implemented by extenders
	}

	/**
	 * Creates a Lucene {@link Directory} dependent on the configuration
	 * @param configuration the service configuration
	 * @return the directory instance
	 * @throws IOException thrown on errors during directory creation
	 * @throws ConfigurationException 
	 */
	private Directory initializeDirectory(Configuration configuration) throws IOException, ConfigurationException {
		requireNonNull(configuration.getDirectoryType());
		File indexFolder = null;
		switch(configuration.getDirectoryType().toLowerCase()) {
		case "bytebuffer":
			directory = new ByteBuffersDirectory();
			break;
		case "niofs":
			indexFolder = initializeIndexLocation(configuration);
			directory = new NIOFSDirectory(indexFolder.toPath());
			break;
		case "mmap":
			indexFolder = initializeIndexLocation(configuration);
			directory = new MMapDirectory(indexFolder.toPath());
			break;
		default:
			indexFolder = initializeIndexLocation(configuration);
			directory = FSDirectory.open(indexFolder.toPath());
			break;
		}
		return requireNonNull(doInitializeDirectory(configuration, directory));
	}

	/**
	 * Creates the setup for {@link ExecutorService} and {@link PromiseFactory}
	 * @param configuration the configuration
	 */
	private void initializeExecutors(Configuration configuration) {
		requireNonNull(configuration);
		requireNonNull(configuration.getIndexName());
		indexExecutors = Executors.newFixedThreadPool(2, (r)->{
			Thread t = new Thread(r, "Index-" + configuration.getIndexName() + "-" + threadCount++);
			t.setDaemon(true);
			return t;
		});
		pf = new PromiseFactory(indexExecutors);
		doInitializeExecutors(configuration);
	}

}
