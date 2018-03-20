/**
 * Copyright (c) 2014 Data In Motion and others.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Data In Motion - initial API and implementation
 */
package org.gecko.search.index.lucene.provider;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.facet.taxonomy.TaxonomyWriter;
import org.apache.lucene.facet.taxonomy.directory.DirectoryTaxonomyWriter;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.SearcherManager;
import org.apache.lucene.store.Directory;
import org.gecko.search.core.exceptions.SearchException;
import org.gecko.search.index.core.SearchIndexException;
import org.gecko.search.index.lucene.analyzer.LuceneAnalyzerRegistry;
import org.gecko.search.index.lucene.documents.LuceneDocumentBuilder;
import org.gecko.searchindex.IndexObject;

/**
 * Base implementation of the lucene index provider
 * @author Mark Hoffmann
 * @since 06.10.2014
 */
@Deprecated
public abstract class AbstractLuceneIndexProvider extends LuceneDocumentBuilder implements LuceneIndexProvider {
	
	private static final String DEFAULT_ANALYZER_ID = "default";
	private static final String FACET_INDEX_SUFIX = "-facet";
	private final Map<String, LuceneIndexObject> indexObjectMap = new ConcurrentHashMap<String, LuceneIndexObject>();
	private final Map<String, TaxonomyWriter> facetWriterMap = new ConcurrentHashMap<String, TaxonomyWriter>();
	private final List<LuceneIndexProviderConfigurer> configurerList = new LinkedList<LuceneIndexProviderConfigurer>();
	private LuceneAnalyzerRegistry analyzerRegistry;
	private boolean nearRealTime = false;
	
	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.lucene.provider.LuceneIndexProvider#getIndexWriter(java.lang.String)
	 */
	@Override
	public IndexWriter getIndexWriter(String path) {
		return getIndexWriter(path, DEFAULT_ANALYZER_ID);
	}
	
	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.lucene.provider.LuceneIndexProvider#getIndexWriter(java.lang.String, java.lang.String)
	 */
	@Override
	public IndexWriter getIndexWriter(String path, String analyzerId) {
		LuceneIndexObject lio = getLuceneIndexObject(path, analyzerId);
		if (lio != null) {
			return lio.getIndexWriter();
		}
		try {
			lio = initializeLuceneIndexObject(path, analyzerId);
			return lio.getIndexWriter();
		} catch (Exception e) {
			throw new SearchIndexException("Error creating IndexWriter ", e);
		}
	}
	
	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.lucene.provider.LuceneIndexProvider#getFacetWriter(java.lang.String)
	 */
	@Override
	public TaxonomyWriter getFacetWriter(String path) {
		Directory directory = null;
		String facetPath = path + FACET_INDEX_SUFIX; 
		TaxonomyWriter writer = facetWriterMap.get(facetPath);
		if (writer != null) {
			return writer;
		}
		try {
			directory = getDirectory(facetPath);
			writer = new DirectoryTaxonomyWriter(directory);
			facetWriterMap.put(facetPath, writer);
			return writer;
		} catch (Exception e) {
			throw new SearchIndexException("Error creating IndexWriter from the directory " + directory.getClass().getName(), e);
		}
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.lucene.provider.LuceneIndexProvider#commitIndexWriter(java.lang.String)
	 */
	@Override
	public void commitIndexWriter(String path) {
		commitIndexWriter(path, DEFAULT_ANALYZER_ID);
	}
	
	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.lucene.provider.LuceneIndexProvider#commitIndexWriter(java.lang.String, java.lang.String)
	 */
	@Override
	public void commitIndexWriter(String path, String analyzerId) {
		LuceneIndexObject lio = getLuceneIndexObject(path, analyzerId);
		if (lio != null) {
			IndexWriter writer = getIndexWriter(path, analyzerId);
			if (writer == null) {
				return;
			}
			try {
				writer.commit();
				updateSearcherManager(lio);
			} catch (CorruptIndexException e) {
				throw new SearchException("Error commiting corrupt index.", e);
			} catch (IOException e) {
				throw new SearchException("Error commiting index.", e);
			}
		}
	}

	private void updateSearcherManager(LuceneIndexObject lio) {
		try {
			SearcherManager searcherManager = lio.getSearcherManager();
			if (searcherManager == null) {
				throw new SearchException("Error getting SearcherManager but it must be available in NRT mode.");
			}
			lio.getSearcherManager().maybeRefresh();
		} catch (IOException e) {
			throw new SearchException("Error updating searcher manager in NRT mode.", e);
		}
	}
	
	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.lucene.provider.LuceneIndexProvider#commitFacetWriter(java.lang.String)
	 */
	@Override
	public void commitFacetWriter(String path) {
		TaxonomyWriter writer = getFacetWriter(path);
		if (writer == null) {
			return;
		}
		try {
			writer.commit();
		} catch (CorruptIndexException e) {
			throw new SearchException("Error commiting corrupt index.", e);
		} catch (IOException e) {
			throw new SearchException("Error commiting index.", e);
		}
	}
	
	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.lucene.provider.LuceneIndexProvider#aquireIndexSearcher(java.lang.String)
	 */
	@Override
	public IndexSearcher aquireIndexSearcher(String path) {
		return aquireIndexSearcher(path, DEFAULT_ANALYZER_ID);
	}
	
	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.lucene.provider.LuceneIndexProvider#aquireIndexSearcher(java.lang.String, java.lang.String)
	 */
	@Override
	public IndexSearcher aquireIndexSearcher(String path, String analyzerId) {
		LuceneIndexObject lio = getLuceneIndexObject(path, analyzerId);
		if (lio != null) {
			try {
				return lio.getSearcherManager().acquire();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.lucene.provider.LuceneIndexProvider#dropIndex(java.lang.String)
	 */
	@Override
	public void dropIndex(String path) {
		try {
			IndexWriter writer = getIndexWriter(path);
			if (writer == null) {
				writer = getIndexWriter(path);
			}
			writer.deleteAll();
			writer.commit();
		} catch (IOException e) {
			throw new SearchIndexException("Error dropping lucene index for path: " + path, e);
		}
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.lucene.provider.LuceneIndexProvider#createIndexDocuments(de.dim.searchindex.IndexObject)
	 */
	@Override
	public List<Document> createIndexDocuments(IndexObject indexObject) {
		List<Document> documentList = new LinkedList<Document>();
		if (indexObject == null) {
			return documentList;
		}
		// call from LucenDocumentBuilder
		super.buildDocuments(documentList, indexObject);
		return documentList;
	}
	
	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.lucene.provider.LuceneIndexProvider#addDocuments(java.lang.String, java.util.List)
	 */
	@Override
	public void addDocuments(String path, List<Document> documents) {
		addDocuments(path, DEFAULT_ANALYZER_ID, documents);
	}
	
	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.lucene.provider.LuceneIndexProvider#addDocuments(java.lang.String, java.lang.String, java.util.List)
	 */
	@Override
	public void addDocuments(String path, String analyzerId, List<Document> documents) {
		if (nearRealTime) {
		}
		
	}
	
	/**
	 * Adds a index provider configurer to the system 
	 * @param configurer the index provider configurer to add
	 */
	public void addConfigurer(LuceneIndexProviderConfigurer configurer) {
		synchronized (this.configurerList) {
			if (configurer != null) {
				this.configurerList.add(configurer);
			}
		}
	}
	
	/**
	 * Removes a index provider configurer from the system 
	 * @param configurer the index provider configurer to remove
	 */
	public void removeConfigurer(LuceneIndexProviderConfigurer configurer) {
		synchronized (this.configurerList) {
			if (configurer != null) {
				this.configurerList.remove(configurer);
			}
		}
	}
	
	/**
	 * Sets the analyzer registry
	 * @param analyzerRegistry
	 */
	public void setAnalyzerRegistry(LuceneAnalyzerRegistry analyzerRegistry) {
		this.analyzerRegistry = analyzerRegistry;
	}
	
	/**
	 * Method called to activate the service and give the initial configuration
	 * @param properties properties to configure the service
	 */
	public void activate(HashMap<String, Object> properties) {
		if (properties == null) {
			return;
		}
		if (properties.containsKey("nearRealTime")) {
			nearRealTime = true;
		} else {
			nearRealTime = false;
		}
	}
	
	/**
	 * Deactivate method called, to dispose all resources on service shutdown
	 * @throws IOException 
	 */
	public void deactivate() throws IOException {
		for (LuceneIndexObject lio : indexObjectMap.values()) {
			if (lio != null) {
				try {
					lio.dispose();
				} catch (IOException e) {
				}
			}
		}
		indexObjectMap.clear();
		for (TaxonomyWriter facetWriter : facetWriterMap.values()) {
			facetWriter.close();
		}
		facetWriterMap.clear();
	}

	/**
	 * Configures the index writer
	 * @param configuration the index writer configuration instance
	 */
	protected void configureIndexWriter(IndexWriterConfig configuration) {
		if (configuration == null) {
			return;
		}
		for (LuceneIndexProviderConfigurer configurer : configurerList) {
			configurer.configureIndexWriter(configuration);
		}
	}
	
	/**
	 * Returns the lucene directory to create the index writer from
	 * @param the path
	 * @return the lucene directory to create the index writer from
	 */
	protected abstract Directory getDirectory(String path);

	/**
	 * Returns the key of the {@link LuceneIndexObject} map from the given parameters
	 * @param path the path of the index
	 * @param analyzerId the analyzer id of the analyzer that is used
	 * @return the key as string
	 */
	private String createLIOKey(String path, String analyzerId) {
		if (path == null || analyzerId == null) {
			throw new SearchException("Error creating key for Lucene Index Object because either path or anaylzerId was null");
		}
		return path + "::" + analyzerId;
	}

	/**
	 * Returns the {@link LuceneIndexObject} if it already exists, otherwise <code>null</code>
	 * @param path the index path
	 * @param analyzerId the id of the analyzer
	 * @return the {@link LuceneIndexObject} instance or <code>null</code>
	 */
	private LuceneIndexObject getLuceneIndexObject(String path, String analyzerId) {
		if (path == null || analyzerId == null) {
			throw new SearchIndexException("Error getting LuceneIndexObject from path " + path + " and analyzer " + analyzerId);
		}
		String ioKey = createLIOKey(path, analyzerId);
		LuceneIndexObject lio = indexObjectMap.get(ioKey);
		return lio;
	}

	/**
	 * Initializes the Lucene index object instance
	 * @param path the index path
	 * @param analyzerId the analyzer id
	 * @return the initialized object
	 */
	private LuceneIndexObject initializeLuceneIndexObject(String path, String analyzerId) {
		try {
			LuceneIndexObject lio = createLuceneIndexObject(path, path, analyzerId);
			String key = createLIOKey(path, analyzerId);
			indexObjectMap.put(key, lio);
			return lio;
		} catch (Exception e) {
			throw new SearchIndexException("Error creating IndexWriter from the directory: " + path  + " and analyzer: " + analyzerId, e);
		}
	}

	/**
	 * Creates a new {@link LuceneIndexObject} and configures it, depending on the nearRealTime flag
	 * @param name the name of the index
	 * @param path the path of the index
	 * @param analyzerId the analyzer id
	 * @return the creates instance
	 * @throws IOException thrown on errors during initialization
	 */
	private LuceneIndexObject createLuceneIndexObject(String name, String path, String analyzerId) throws IOException {
		LuceneIndexObject lio = new LuceneIndexObject(path, path, nearRealTime);
		Directory directory = getDirectory(path);
		lio.setDirectory(directory);
		Analyzer analyzer = analyzerRegistry.getAnalyzer(analyzerId);
		lio.setAnalyzer(analyzer);
		IndexWriterConfig config = new IndexWriterConfig(analyzer);
		configureIndexWriter(config);
		IndexWriter indexWriter = new IndexWriter(directory, config);
		lio.setIndexWriter(indexWriter);
		return lio;
	}

}
