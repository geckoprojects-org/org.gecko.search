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
package org.gecko.search.result.lucene.mapper;

import java.io.IOException;
import java.util.List;

import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.gecko.search.result.lucene.query.ISearchResultContext;
import org.gecko.searchresult.MatchHighlight;
import org.gecko.searchresult.SearchResult;

/**
 * Maps from the lucene {@link TopDocs} to a {@link SearchResult}
 * @author Mark Hoffmann
 * @since 08.08.2014
 */
public interface ISearchResultMapper {
	
	/**
	 * Maps from top docs to the search result
	 * @param reader the {@link IndexReader}
	 * @param topdocs the top docs to map
	 * @return the search result
	 */
	public SearchResult createSearchResult(IndexReader reader, TopDocs topdocs);
	
	/**
	 * Maps from top docs to the search result
	 * @param context the context object
	 * @return the search result
	 */
	public SearchResult createSearchResult(ISearchResultContext context);
	
	/**
	 * Maps from top docs to the search result
	 * @return the search result
	 */
	public SearchResult createSearchResult() throws IOException;
	
	/**
	 * Adds highlight information to the given {@link SearchResult} for the {@link TopDocs} and the {@link Query}
	 * @param result the search result to the highlight information for
	 * @param docs the {@link TopDocs}
	 * @param query the {@link Query}
	 * @deprecated use {@link ISearchResultMapper#createHighlightInformation(String, int, IndexSearcher, Highlighter, String)} instead
	 */
	public void createHighLightInformation(SearchResult result, TopDocs docs, Query query);
	
	/**
	 * Adds highlight information for the given field of the {@link document with the given id
	 * @param fieldName the name of the field to create highlight for
	 * @param docId the document id 
	 * @param searcher the searcher instance
	 * @param highlighter the highlighter instance
	 * @param originalText the original text from the field
	 * @return the list of {@link MatchHighlight} instances or an empty list
	 * @throws IOException
	 * @throws InvalidTokenOffsetsException
	 */
	public List<MatchHighlight> createHighlightInformation(String fieldName, int docId, IndexSearcher searcher, Highlighter highlighter, String originalText) throws IOException, InvalidTokenOffsetsException;
	
	/**
	 * Adds highlight information for the given field of the {@link document with the given id
	 * @param fieldName the name of the field to create highlight for
	 * @param docId the document id 
	 * @param originalText the original text from the field
	 * @param context the context
	 * @return the list of {@link MatchHighlight} instances or an empty list
	 * @throws IOException
	 * @throws InvalidTokenOffsetsException
	 */
	public List<MatchHighlight> createHighlightInformation(String fieldName, int docId, String originalText, ISearchResultContext context) throws IOException, InvalidTokenOffsetsException;

}
