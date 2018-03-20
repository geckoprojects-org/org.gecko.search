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
package org.gecko.search.index.lucene.writer;

import java.io.IOException;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.facet.taxonomy.TaxonomyWriter;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.TwoPhaseCommit;
import org.apache.lucene.search.SearcherManager;
import org.gecko.searchindex.FacetContext;
import org.gecko.searchindex.IndexObject;
import org.gecko.searchindex.SearchableFacetDocumentObject;

/**
 * Interface that provides the Lucene IndexWriter
 * @author Mark Hoffmann
 * @since 04.08.2014
 */
public interface IIndexWriterProvider {
	
	/**
	 * Returns the id of this index writer provider
	 * @return the id of this index writer provider
	 */
	public String getWriterProviderId();
	
	/**
	 * Opens the index writer
	 * @param path the index path
	 * @return the {@link IndexWriter} instance
	 */
	public IndexWriter openIndexWriter(String path);
	
	/**
	 * Opens the index writer
	 * @param path the index path
	 * @param analyzerId the id of the used analyzer
	 * @return the {@link IndexWriter} instance
	 */
	public IndexWriter openIndexWriter(String path, String analyzerId);
	
	/**
	 * Looks for the required Analyser in the registry. If no Analyzer is found, the default Analyzer will be returned.
	 * @param analyzerId the analyzer Id
	 * @return the {@link Analyzer} desired. Will never be null
	 */
	public Analyzer getAnalyizerById(String analyzerId);
	
	/**
	 * Opens the facet index writer
	 * @param path the index path
	 * @param ctx the {@link FacetContext} describing the writer
	 * @return the {@link TaxonomyWriter} instance
	 */
	public TaxonomyWriter openFacetWriter(String path);
	
	/**
	 * Commits all changes to the facet writer with the given path
	 * @param path the path of the index
	 */
	public void commitFacetWriter(String path);
	
	/**
	 * Commits all changes to the index writer with the given path
	 * @param path the path of the index
	 * @param analizerId the analizer that is configued for the writer
	 */
	public void commitIndexWriter(String path, String analizerId);
	
	/**
	 * Commits all changes to the given {@link IndexWriter}
	 * @param path the path of the index
	 * @throws IOException 
	 */
	public void commitIndexWriter(TwoPhaseCommit writer) throws IOException;
	
	/**
	 * Closes the index writer after writing an index
	 * @param path the index path
	 * @param waitForMerges should be <code>true</code>, if the index should wait for further merges before closing it.
	 * @return <code>true</code>, if closing the index writer was successful
	 */
	public boolean closeIndexWriter(String path, boolean waitForMerges);
	
	/**
	 * Creates an index documents from the given {@link IndexObject}
	 * @param indexObject the index object with fields, descriptor and source object
	 * @return the {@link List} of documents
	 */
	public List<Document> createIndexDocuments(IndexObject indexObject);
	
	/**
	 * Drops the index for the given path
	 * @param path the path to drop the index
	 */
	public void dropIndex(String path);
	
	/**
	 * @param path the path of the index
	 * @return the shared {@link SearcherManager} for the given path
	 * @throws IOException
	 */
	public SearcherManager getSearcherManager(String path) throws IOException;
	
	/**
	 * Closes and removes the given {@link SearcherManager}
	 * @param manager the {@link SearcherManager} to close and remove
	 * @throws IOException
	 */
	public void closeSearcherManager(SearcherManager manager) throws IOException;

	/**
	 * Opens or returns an open special {@link IndexWriter} for the given path (a sufix will be added by default) to write the searchable facet documents to
	 * @param path the path of the originating index
	 * @param analyzerId the analyzers id to use for this writer
	 * @return the {@link IndexWriter}
	 */
	public IndexWriter openSearchableFacetWriter(String path, String analyzerId);

	/**
	 * Creates the Document for the given {@link SearchableFacetDocumentObject}
	 * @param object the {@link SearchableFacetDocumentObject}
	 * @return
	 */
	public Document createIndexDocumentsForSearchableFacetIndex(
			SearchableFacetDocumentObject object);
}
