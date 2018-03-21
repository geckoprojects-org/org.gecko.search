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
package org.gecko.search.result.lucene.query;

import java.util.List;
import java.util.Map;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.facet.Facets;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.Collector;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.grouping.TopGroups;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.postingshighlight.PostingsHighlighter;
import org.apache.lucene.util.BytesRef;
import org.gecko.search.result.lucene.highlight.MatchHighlightFormatter;
import org.gecko.search.result.lucene.highlight.PositionPostingsHighlighter;
import org.gecko.search.result.lucene.mapper.impl.SearchResultMapper;
import org.gecko.searchresult.MatchHighlight;
import org.gecko.searchresult.QueryObject;

/**
 * Context object for the result mapper
 * @author Mark Hoffmann
 * @since 08.08.2014
 */
public interface ISearchResultContext {
	
	/**
	 * Returns the lucene highlighter 
	 * @return the lucene highlighter
	 * @deprecated use the {@link ISearchResultContext#getPostingHighlighter()} instead
	 */
	public Highlighter getHighlighter();
	
	/**
	 * Returns the Lucene {@link PostingsHighlighter}
	 * @return the Lucene {@link PostingsHighlighter}
	 */
	public PositionPostingsHighlighter getPostingHighlighter();
	
	/**
	 * Returns the map with match highlight per documents per field name or an empty map 
	 * @return the map with match highlight per documents per field name or an empty map
	 */
	public Map<String, List<MatchHighlight>[]> getMatchHighlights();
	
	/**
	 * Returns the {@link TopDocs}
	 * @return the {@link TopDocs}
	 */
	public TopDocs getTopDocs();
	
	/**
	 * Returns index reader
	 * @return index reader
	 */
	public IndexReader getIndexReader();
	
	/**
	 * Returns index searcher
	 * @return index searcher
	 */
	public IndexSearcher getIndexSearcher();
	
	/**
	 * Returns the {@link MatchHighlightFormatter}
	 * @return the {@link MatchHighlightFormatter}
	 * @deprecated with the {@link PositionPostingsHighlighter} there is no need for the {@link MatchHighlightFormatter}
	 */
	public MatchHighlightFormatter getFormatter();
	
	/**
	 * Returns the field names to highlighted
	 * @return the field names to highlighted
	 */
	public List<String> getHighlightFields();
	
	/**
	 * Returns the {@link Analyzer}
	 * @return the {@link Analyzer}
	 */
	public Analyzer getAnalyzer();
	
	/**
	 * Return the search result mapper
	 * @return the search result mapper
	 */
	public SearchResultMapper getMapper();
	
	/**
	 * Returns the query object
	 * @return the query object
	 */
	public QueryObject getQueryObject();
	
	/**
	 * Returns the {@link Query}
	 * @return the {@link Query}
	 */
	public Query getQuery();
	
	/**
	 * Returns the {@link Facets}
	 * @return tje {@link Facets}
	 */
	public Facets getFacets();
	
	/**
	 * Returns the nativ lucene {@link Collector}s
	 * @return the nativ lucene {@link Collector}s
	 */
	public List<Collector> getCollectors();

	TopGroups<BytesRef> getGroups();

	Query getInternalJoinQuery();
}
