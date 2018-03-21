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
package org.gecko.search.result.lucene.highlight;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.apache.lucene.search.highlight.TokenSources;
import org.gecko.search.result.lucene.SearchResultContext;
import org.gecko.search.result.lucene.query.ISearchResultContext;
import org.gecko.searchresult.MatchHighlight;
import org.gecko.searchresult.QueryObject;

/**
 * Custom highlight helper class
 * @author Mark Hoffmann
 * @since 31.08.2014
 */
public class HighlightingHelper {
	
	/**
	 * Creates highlight information
	 * @param fieldName the field name to get highlight information for
	 * @param docId the doc id
	 * @param originalText the original text
	 * @param context the context with all helper classes
	 * @return {@link List} with {@link MatchHighlight}
	 * @throws IOException
	 * @throws InvalidTokenOffsetsException
	 * @deprecated use {@link PositionPostingsHighlighter} instead
	 */
	public static List<MatchHighlight> createHighlightInformation(String fieldName, int docId, String originalText, ISearchResultContext context)
			throws IOException, InvalidTokenOffsetsException {
		return createHighlightInformation(fieldName, docId, originalText, context, context.getIndexReader());
	}
	
	/**
	 * Creates highlight information
	 * @param fieldName the field name to get highlight information for
	 * @param docId the doc id
	 * @param originalText the original text
	 * @param context the context with all helper classes
	 * @param reader the index reader
	 * @return {@link List} with {@link MatchHighlight}
	 * @throws IOException
	 * @throws InvalidTokenOffsetsException
	 * @deprecated use {@link PositionPostingsHighlighter} instead
	 */
	public static List<MatchHighlight> createHighlightInformation(String fieldName, int docId, String originalText, ISearchResultContext context, IndexReader reader)
			throws IOException, InvalidTokenOffsetsException {
		Highlighter highlighter = context.getHighlighter();
		TokenStream tokenStream = TokenSources.getAnyTokenStream(reader, docId, fieldName, context.getAnalyzer());
		highlighter.getBestTextFragments(tokenStream, originalText, false, 10);
		List<MatchHighlight> highlightResult = new ArrayList<>(context.getFormatter().getHighlightInformation());
		context.getFormatter().resetHighlightInformation();
		return highlightResult;
	}
	
	/**
	 * Creates highlight information from the given searcher and {@link ISearchResultContext} 
	 * @param searcher the {@link IndexSearcher}
	 * @param context the {@link ISearchResultContext}
	 * @return a map with field names as key and an arrays of highlight lists in order of the original result or an empty map
	 * @throws IOException
	 */
	public static Map<String, List<MatchHighlight>[]> createHighlighting(IndexSearcher searcher, SearchResultContext context) throws IOException {
		QueryObject queryObject = context.getQueryObject();
		if (queryObject.getHighlightFields().size() == 0) {
			return Collections.emptyMap();
		}
		PositionPostingsHighlighter highlighter = context.getPostingHighlighter();
		int fieldsSize = queryObject.getHighlightFields().size();
		String[] fields = queryObject.getHighlightFields().toArray(new String[fieldsSize]);
		Map<String, List<MatchHighlight>[]> highlights = highlighter.highlightFieldsAsMatchHighlight(fields, context.getQuery(), searcher, context.getTopDocs());
		return highlights;
	}


}
