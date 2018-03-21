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
package org.gecko.search.result.lucene;

import java.util.Collections;
import java.util.LinkedList;
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
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.util.BytesRef;
import org.gecko.search.result.lucene.highlight.MatchHighlightFormatter;
import org.gecko.search.result.lucene.highlight.PositionPostingsHighlighter;
import org.gecko.search.result.lucene.mapper.impl.SearchResultMapper;
import org.gecko.search.result.lucene.query.ISearchResultContext;
import org.gecko.searchresult.MatchHighlight;
import org.gecko.searchresult.QueryObject;

/**
 * Context object for the result mapper
 * @author Mark Hoffmann
 * @since 08.08.2014
 */
@SuppressWarnings("deprecation")
public class SearchResultContext implements ISearchResultContext {
	
	private final PositionPostingsHighlighter highlighter = new PositionPostingsHighlighter();
	private final MatchHighlightFormatter formatter = new MatchHighlightFormatter();
	private final Analyzer analyzer;
	private final Query query;
	private final TopDocs topDocs;
	private final List<String> highlightFields;
	private final QueryObject queryObject;
	private final IndexReader reader;
	private final IndexSearcher searcher;
	private final Facets facets;
	private SearchResultMapper mapper = null;
	private Map<String, List<MatchHighlight>[]> highlights = null;
	private List<Collector> luceneCollectors = new LinkedList<>();
	private TopGroups<BytesRef> groups;
	private Query internalJoinQuery = null;
	
	public SearchResultContext(IndexSearcher indexSearcher, TopDocs topDocs, Query query, List<String> highlightFields, Analyzer analyzer) {
		reader = indexSearcher.getIndexReader();
		searcher = indexSearcher;
		this.topDocs = topDocs;
		this.query = query;
		this.analyzer = analyzer;
		this.queryObject = null;
		this.highlightFields = highlightFields;
		this.facets = null;
	}
	
	public SearchResultContext(IndexSearcher indexSearcher, TopDocs topDocs, Query query, QueryObject queryObject, Analyzer analyzer, List<Collector> luceneCollectors) {
		reader = indexSearcher.getIndexReader();
		searcher = indexSearcher;
		this.topDocs = topDocs;
		this.query = query;
		this.queryObject = queryObject;
		this.analyzer = analyzer;
		this.highlightFields = this.queryObject.getHighlightFields();
		this.facets = null;
		this.luceneCollectors = luceneCollectors;
	}

	public SearchResultContext(IndexSearcher indexSearcher, TopDocs topDocs,
			Query query, QueryObject queryObject, Analyzer analyzer,
			Facets facets, List<Collector> luceneCollectors) {
		reader = indexSearcher.getIndexReader();
		searcher = indexSearcher;
		this.topDocs = topDocs;
		this.query = query;
		this.queryObject = queryObject;
		this.analyzer = analyzer;
		this.facets = facets;
		this.luceneCollectors  = luceneCollectors;
		this.highlightFields = this.queryObject.getHighlightFields();
	}

	public SearchResultContext(IndexSearcher indexSearcher, Query query,
			QueryObject queryObject, Analyzer analyzer,
			TopGroups<BytesRef> groups, List<Collector> luceneCollectors) {
		reader = indexSearcher.getIndexReader();
		searcher = indexSearcher;
		this.groups = groups;
		this.topDocs = null;
		this.query = query;
		this.queryObject = queryObject;
		this.analyzer = analyzer;
		this.highlightFields = this.queryObject.getHighlightFields();
		this.facets = null;
		this.luceneCollectors = luceneCollectors;
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.result.lucene.mapper.ISearchResultContext#getHighlighter()
	 */
	@Override
	public Highlighter getHighlighter() {
		return new Highlighter(formatter, new QueryScorer(query));
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.result.lucene.query.ISearchResultContext#getPostingHighlighter()
	 */
	@Override
	public PositionPostingsHighlighter getPostingHighlighter() {
		return highlighter;
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.result.lucene.mapper.ISearchResultContext#getTopDocs()
	 */
	@Override
	public TopDocs getTopDocs() {
		return topDocs;
	}
	
	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.result.lucene.mapper.ISearchResultContext#getIndexReader()
	 */
	@Override
	public IndexReader getIndexReader() {
		return reader;
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.result.lucene.mapper.ISearchResultContext#getFormatter()
	 */
	@Override
	public MatchHighlightFormatter getFormatter() {
		return formatter;
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.result.lucene.mapper.ISearchResultContext#getHighlightFields()
	 */
	@Override
	public List<String> getHighlightFields() {
		return highlightFields == null ? Collections.<String>emptyList() : highlightFields;
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.result.lucene.mapper.ISearchResultContext#getAnalyzer()
	 */
	@Override
	public Analyzer getAnalyzer() {
		return analyzer;
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.result.lucene.ISearchResultContext#getMapper()
	 */
	@Override
	public SearchResultMapper getMapper() {
		if (mapper == null) {
			mapper = new SearchResultMapper(this);
		}
		return mapper;
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.result.lucene.ISearchResultContext#getQueryObject()
	 */
	@Override
	public QueryObject getQueryObject() {
		return queryObject;
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.result.lucene.ISearchResultContext#getQuery()
	 */
	@Override
	public Query getQuery() {
		return query;
	}

	/* (non-Javadoc)
	 * @see de.dim.search.result.lucene.ISearchResultContext#getFacets()
	 */
	@Override
	public Facets getFacets() {
		return facets;
	}

	/* (non-Javadoc)
	 * @see de.dim.search.result.lucene.ISearchResultContext#getCollectors()
	 */
	@Override
	public List<Collector> getCollectors() {
		return luceneCollectors;
	}
	
	/* (non-Javadoc)
	 * @see de.dim.search.result.lucene.ISearchResultContext#getGroups()
	 */
	@Override
	public TopGroups<BytesRef> getGroups() {
		return groups;
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.result.lucene.query.ISearchResultContext#getMatchHighlights()
	 */
	@Override
	public Map<String, List<MatchHighlight>[]> getMatchHighlights() {
		return highlights == null ? Collections.<String, List<MatchHighlight>[]>emptyMap() : highlights;
	}
	
	/**
	 * Sets the match highlights 
	 * @param highlights the highlights to set
	 */
	void setMatchHighlights(Map<String, List<MatchHighlight>[]> highlights) {
		this.highlights = highlights;
	}

	/**
	 * Sets the internal join query
	 * @param internalJoinQuery the inter join {@link Query}
	 */
	public void setInternalJoinQuery(Query internalJoinQuery) {
		this.internalJoinQuery  = internalJoinQuery;
	}

	/**
	 * @return the internalJoinQuery
	 */
	@Override
	public Query getInternalJoinQuery() {
		return internalJoinQuery;
	}

	/* (non-Javadoc)
	 * @see de.dim.search.result.lucene.query.ISearchResultContext#getIndexSearcher()
	 */
	@Override
	public IndexSearcher getIndexSearcher() {
		return searcher;
	}

}
