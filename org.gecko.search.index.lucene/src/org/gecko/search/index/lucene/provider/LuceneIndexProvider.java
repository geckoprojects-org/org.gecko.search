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

import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.facet.taxonomy.TaxonomyWriter;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.SearcherManager;
import org.gecko.searchindex.IndexObject;

/**
 * Interface to provide all lucene specific instance to handle indexing and search
 * @author Mark Hoffmann
 * @since 06.10.2014
 */
@Deprecated
public interface LuceneIndexProvider {
	
	/**
	 * Returns the index writer for the given path
	 * @param path the index path
	 * @return the {@link IndexWriter} instance
	 */
	public IndexWriter getIndexWriter(String path);
	
	/**
	 * Returns the index writer for the given path an analyzer id.
	 * The analyzer will be provided by the analyzer registry
	 * @param path the index path
	 * @param analyzerId the id of the used analyzer
	 * @return the {@link IndexWriter} instance
	 */
	public IndexWriter getIndexWriter(String path, String analyzerId);
	
	/**
	 * Returns the facet index writer
	 * @param path the index path
	 * @return the {@link TaxonomyWriter} instance
	 */
	public TaxonomyWriter getFacetWriter(String path);
	
	/**
	 * Returns the searcher manager for the given path
	 * @param path the index path
	 * @return the searcher manager for the given path
	 */
	public SearcherManager getSearcherManager(String path);
	
	/**
	 * Returns the searcher manager for the given path and analyzer id
	 * @param path the index path
	 * @param analyzerId the analyzer id
	 * @return the searcher manager for the given path
	 */
	public SearcherManager getSearcherManager(String path, String analyzerId);
	
	/**
	 * Commits all changes to the index writer with the given path
	 * @param path the path of the index
	 */
	public void commitIndexWriter(String path);
	
	/**
	 * Commits all changes to the index writer with the given path
	 * @param path the path of the index
	 * @param analyzerId the id of the used analyzer
	 */
	public void commitIndexWriter(String path, String analyzerId);

	/**
	 * Commits all changes to the facet writer with the given path
	 * @param path the path of the index
	 */
	public void commitFacetWriter(String path);
	
	/**
	 * Creates a new index searcher
	 * @param path the path of the index to get the searcher for
	 * @return a new index searcher
	 */
	public IndexSearcher aquireIndexSearcher(String path);
	
	/**
	 * Creates a new index searcher
	 * @param path the path of the index to get the searcher for
	 * @param analyzerId the analyzer to get the searcher for
	 * @return a new index searcher
	 */
	public IndexSearcher aquireIndexSearcher(String path, String analyzerId);
	
	/**
	 * Releases the searcher instance, if it isn't used anymore
	 * @param searcher The index searcher instance
	 */
	public void releaseIndexSearcher(IndexSearcher searcher);
	
	/**
	 * Creates an index documents from the given {@link IndexObject}
	 * @param indexObject the index object with fields, descriptor and source object
	 * @return the {@link List} of documents
	 */
	public List<Document> createIndexDocuments(IndexObject indexObject);
	
	
	public void addDocuments(String path, List<Document> documents);
	public void addDocuments(String path, String analyzerId, List<Document> documents);
	
	public void updateDocuments(String path, Term updateTerm, List<Document> documents);
	public void updateDocuments(String path, String analyzerId, Term updateTerm, List<Document> documents);
	
	public void deleteDocuments(String path, Term deleteTerm);
	public void deleteDocuments(String path, String analyzerId, Term deleteTerm);
	
	/**
	 * Drops the index for the given path
	 * @param path the path to drop the index
	 */
	public void dropIndex(String path);

}
