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

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.facet.taxonomy.TaxonomyWriter;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.search.ControlledRealTimeReopenThread;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.SearcherManager;
import org.apache.lucene.store.Directory;

/**
 * Object with all lucene index, searcher instances for a given index
 * @author Mark Hoffmann
 * @since 06.10.2014
 */
@Deprecated
public class LuceneIndexObject {
	
	private final String indexName;
	private final String indexPath;
	private Analyzer analyzer;
	private Directory directory;
	private Directory facetDirectory;
	private IndexWriter indexWriter;
	private TaxonomyWriter facetIndexWriter;
	private ControlledRealTimeReopenThread<IndexSearcher> searchManagerThread = null;
	private SearcherManager searcherManager;
	private final boolean nearRealTime;
	
	/**
	 * Creates a new instance.
	 * @param name the index name
	 * @param path the index path
	 */
	public LuceneIndexObject(String name, String path) {
		this(name, path, false);
	}
	
	/**
	 * Creates a new instance.
	 * Creates a new instance.
	 * @param name the index name
	 * @param path the index path
	 * @param isNearrealTime <code>true</code>, if this object is for near realtime search
	 */
	public LuceneIndexObject(String name, String path, boolean isNearrealTime) {
		indexName = name;
		indexPath = path;
		nearRealTime = isNearrealTime;
	}
	
	/**
	 * Cleans up all resources
	 * @throws IOException 
	 */
	public void dispose() throws IOException {
		if (searchManagerThread != null) {
			searchManagerThread.close();
		}
		if (getSearcherManager() != null) {
			getSearcherManager().close();
		}
		if (indexWriter != null) {
			indexWriter.close();
		}
		if (directory != null) {
			directory.close();
		}
	}

	/**
	 * Returns the indexPath.
	 * @return the indexPath
	 */
	public String getIndexPath() {
		return indexPath;
	}

	/**
	 * Returns the indexName.
	 * @return the indexName
	 */
	public String getIndexName() {
		return indexName;
	}

	/**
	 * Returns the nearRealTime.
	 * @return the nearRealTime
	 */
	public boolean isNearRealTime() {
		return nearRealTime;
	}

	/**
	 * Returns the directory.
	 * @return the directory
	 */
	public Directory getDirectory() {
		return directory;
	}

	/**
	 * Returns the indexWriter.
	 * @return the indexWriter
	 */
	public IndexWriter getIndexWriter() {
		return indexWriter;
	}

	/**
	 * Returns the facetIndexWriter.
	 * @return the facetIndexWriter
	 */
	public TaxonomyWriter getFacetIndexWriter() {
		return facetIndexWriter;
	}

	/**
	 * Returns the analyzer.
	 * @return the analyzer
	 */
	public Analyzer getAnalyzer() {
		return analyzer;
	}

	/**
	 * Returns the common searcher manager for near real time search or creates a new manager otherwise 
	 * @return the searcher manager
	 * @throws IOException thrown on error during creation
	 */
	public SearcherManager getSearcherManager() throws IOException {
		if (isNearRealTime()) {
			return searcherManager;
		}
		return createSearcherManager();
	}

	/**
	 * Sets the indexWriter.
	 * @param indexWriter the indexWriter to set
	 */
	void setIndexWriter(IndexWriter indexWriter) {
		this.indexWriter = indexWriter;
	}

	/**
	 * Sets the directory.
	 * @param directory the directory to set
	 */
	void setDirectory(Directory directory) {
		this.directory = directory;
	}
	
	/**
	 * Sets the directory for the facets.
	 * @param directory the directory to set
	 */
	void setFacetDirectory(Directory directory) {
		this.facetDirectory = directory;
	}

	/**
	 * Sets the analyzer.
	 * @param analyzer the analyzer to set
	 */
	void setAnalyzer(Analyzer analyzer) {
		this.analyzer = analyzer;
	}
	
	/**
	 * Creates a new searcher manager
	 * @return a new searcher manager
	 * @throws IOException
	 */
	SearcherManager createSearcherManager() throws IOException {
		return new SearcherManager(indexWriter, true, false, null);
	}

}
