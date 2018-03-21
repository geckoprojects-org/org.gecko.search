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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.facet.DrillDownQuery;
import org.apache.lucene.facet.DrillSideways;
import org.apache.lucene.facet.Facets;
import org.apache.lucene.facet.FacetsCollector;
import org.apache.lucene.facet.FacetsConfig;
import org.apache.lucene.facet.taxonomy.FastTaxonomyFacetCounts;
import org.apache.lucene.facet.taxonomy.TaxonomyReader;
import org.apache.lucene.facet.taxonomy.directory.DirectoryTaxonomyReader;
import org.apache.lucene.facet.taxonomy.directory.DirectoryTaxonomyWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.queries.mlt.MoreLikeThis;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.Collector;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.MultiCollector;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.SearcherManager;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.TopFieldCollector;
import org.apache.lucene.search.grouping.GroupDocs;
import org.apache.lucene.search.grouping.GroupingSearch;
import org.apache.lucene.search.grouping.TopGroups;
import org.apache.lucene.search.join.JoinUtil;
import org.apache.lucene.search.join.ScoreMode;
import org.apache.lucene.util.BytesRef;
import org.gecko.search.index.lucene.analyzer.LuceneAnalyzerRegistry;
import org.gecko.search.index.lucene.writer.IIndexWriterProvider;
import org.gecko.search.result.core.ISearcher;
import org.gecko.search.result.core.SearchResultException;
import org.gecko.search.result.lucene.helper.PagingHelper;
import org.gecko.search.result.lucene.helper.QueryHelper;
import org.gecko.search.result.lucene.highlight.HighlightingHelper;
import org.gecko.search.result.lucene.query.ICollectorConfigurator;
import org.gecko.search.result.lucene.query.ILuceneQueryProvider;
import org.gecko.search.result.lucene.query.ISearchResultContext;
import org.gecko.searchresult.Category;
import org.gecko.searchresult.FacetFilter;
import org.gecko.searchresult.FacetQueryContext;
import org.gecko.searchresult.GroupingContext;
import org.gecko.searchresult.JoinScoreMode;
import org.gecko.searchresult.LikeThisObject;
import org.gecko.searchresult.MatchHighlight;
import org.gecko.searchresult.QueryObject;
import org.gecko.searchresult.SearchResult;
import org.gecko.searchresult.SearchResultFactory;
import org.gecko.searchresult.SearchResultPackage;
import org.osgi.service.component.ComponentFactory;
import org.osgi.service.component.ComponentInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementation of the Lucene searcher
 * @author Mark Hoffmann
 * @since 08.08.2014
 */
public class LuceneSearcher implements ISearcher {

	private static final Logger LOG = LoggerFactory.getLogger("rds.component.log.create");
	private ILuceneQueryProvider queryProvider;
	private ComponentInstance queryProviderCI;
	private ComponentFactory queryProviderFactory;
	private IIndexWriterProvider indexWriterProvider;
	private LuceneAnalyzerRegistry analyzerRegistry;

	//	private static class Similarity extends DefaultSimilarity{
	//		
	//	    @Override
	//	    public float tf(float freq) {
	//	        return 1.0f;
	//	    }
	//
	//	    @Override
	//	    public float idf(long docFreq, long numDocs) {
	//	    	return 1.0f;
	//	    }
	//	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.result.core.ISearcher#search(de.dim.searchresult.QueryObject)
	 */
	@Override
	public SearchResult search(QueryObject query) throws SearchResultException {
		if (query == null) {
			return SearchResultFactory.eINSTANCE.createSearchResult();
		}
		long start = System.currentTimeMillis();
		List<Collector> luceneCollectors = getCollector(query);
		Query luceneFilter = queryProvider.createFilter(query);
		long filter = System.currentTimeMillis() - start;
		start = System.currentTimeMillis();
		LOG.debug("Preparing filter took {}ms", filter);
		Sort luceneSort = queryProvider.createSort(query);
		long sort = System.currentTimeMillis() - start - filter;
		start = System.currentTimeMillis();
		LOG.debug("Preparing sort took {}ms", sort);
		Analyzer luceneAnalyzer = analyzerRegistry.getAnalyzer(query.getAnalyzerId());
		Query luceneQuery = createQuery(query, luceneAnalyzer);
		//		Query luceneQuery = createQuery(query, luceneAnalyzer, queryProvider);
		long queryt = System.currentTimeMillis() - start;
		start = System.currentTimeMillis();
		LOG.debug("Create query took {}ms", queryt);
		Query internalJoinQuery = null;

		IndexSearcher joinSearcher = null;	
		IndexSearcher indexSearcher = null;

		TaxonomyReader taxoReader = null;

		start = System.currentTimeMillis();
		SearcherManager joinSearcherManager = null;
		SearcherManager searcherManager = null;
		try {
			searcherManager = getSearcherManager(query);
			LOG.debug("Create Searchmanager took {}ms", (System.currentTimeMillis() - start));
			indexSearcher = searcherManager.acquire();
			//			indexSearcher.setSimilarity(new Similarity());
			if(query.getJoinQuery() != null){
				joinSearcherManager = getSearcherManager(query.getJoinQuery().getIndexPath());
				joinSearcher = joinSearcherManager.acquire();
				if(query.getJoinQuery().getQueryObject() != null){
					start = System.currentTimeMillis();
					if(query.getJoinQuery().getQueryObject() instanceof QueryObject) {
						internalJoinQuery = createQuery((QueryObject) query.getJoinQuery().getQueryObject(), luceneAnalyzer);
					} else {
						internalJoinQuery = QueryHelper.getFromNativQuery(query.getJoinQuery().getQueryObject(), luceneAnalyzer) ;
					}
					internalJoinQuery = internalJoinQuery.rewrite(joinSearcher.getIndexReader());
					Query jq = JoinUtil.createJoinQuery(query.getJoinQuery().getFromField(), false, query.getJoinQuery().getToField(), internalJoinQuery, joinSearcher, getScoreMode(query.getJoinQuery().getScoreMode()));
					BooleanQuery.Builder bq = new BooleanQuery.Builder();
					if (query.getNativeQuery() != null ) {
						bq.add(luceneQuery, getLuceneOccur(query.getNativeQueryOccur()));
					} else {
						bq.add(luceneQuery, Occur.MUST);
					}
					switch (query.getJoinQuery().getOccur().getValue()) {
					case org.gecko.searchresult.Occur.MUST_VALUE:
						bq.add(jq, Occur.MUST);
						break;
					case org.gecko.searchresult.Occur.MUST_NOT_VALUE:
						bq.add(jq, Occur.MUST_NOT);
						break;
					default:
						bq.add(jq, Occur.SHOULD);
						break;
					}
					luceneQuery = bq.build();
					LOG.debug("Create Join Query took {}ms", (System.currentTimeMillis() - start));
				}
			}
			int maxResults = calculateMaxResult(query);
			if (luceneCollectors.size() > 0 && query.isRunCollectorExclusive()) {
				start = System.currentTimeMillis();
				SearchResult searchResult = SearchResultFactory.eINSTANCE.createSearchResult();
				executeCollectorQuery(luceneQuery, luceneCollectors, searchResult, indexSearcher);
				LOG.debug("Executing Collector Query took {}ms", (System.currentTimeMillis() - start));
				return searchResult;
			}  
			SearchResultContext ctx = null;
			start = System.currentTimeMillis();
			if(query.getFacetQueryContext() != null || query.getGroupingContext() != null){
				if(query.getFacetQueryContext() != null && query.getGroupingContext() != null)
					throw new SearchResultException("facetQueryContext and GroupingContext together is not allowed");
				if(query.getFacetQueryContext() != null){
					taxoReader = new DirectoryTaxonomyReader((DirectoryTaxonomyWriter) indexWriterProvider.openFacetWriter(query.getIndexPath()));
					ctx = executeFacetQuery(query, luceneQuery, luceneFilter, luceneSort, luceneAnalyzer, maxResults, indexSearcher, luceneCollectors, taxoReader);
					LOG.debug("Executing facet Query took {}ms", (System.currentTimeMillis() - start));
				} else {
					ctx = executeGroupedQuery(query, luceneQuery, luceneFilter, luceneSort, luceneAnalyzer, maxResults, indexSearcher, luceneCollectors);
					LOG.debug("Executing grouped Query took {}ms", (System.currentTimeMillis() - start));
				}
			} else {
				ctx = executeQueryContext(luceneQuery, luceneFilter, maxResults, luceneSort, luceneAnalyzer, query, indexSearcher, luceneCollectors);
				LOG.debug("Executing Query Context took {}ms", (System.currentTimeMillis() - start));
			}

			if(query.getJoinQuery() != null && query.getJoinQuery().getJoinAftermathCollectors().size() > 0){
				start = System.currentTimeMillis();
				ctx.setInternalJoinQuery(internalJoinQuery);
				executeJoinQueryAftemath(query, ctx, joinSearcher);
				LOG.debug("Executing Join-Query aftermath took {}ms", (System.currentTimeMillis() - start));
			}
			//			long startMap = System.currentTimeMillis();
			SearchResult searchResult = ctx.getMapper().createSearchResult();
			//			System.err.println("Mapping took " + (System.currentTimeMillis() - startMap) + "ms");
			//			System.err.println("Searching in LuceneSearcher took " + (System.currentTimeMillis() - start) + "ms");

			if (query.getLikeThisObject() != null) {
				start = System.currentTimeMillis();
				executeQueryLikeThis(ctx, searchResult, indexSearcher);
				LOG.debug("Executing Like-This Query took {}ms", (System.currentTimeMillis() - start));
			}
			return searchResult;

		} catch (Exception e) {
			throw new SearchResultException("Error searching for query " + luceneQuery, e);
		}  finally {
			if(indexSearcher != null) {
				try {
					searcherManager.release(indexSearcher);
				} catch (Throwable e) {
					throw new SearchResultException("Could not release index searcher for query " + query, e);
				}
			}
			if(taxoReader != null){
				try{
					taxoReader.close();
				} catch (IOException e) {
					throw new SearchResultException("Could not close Taxonomy Reader for query " + query, e);
				}
			}
			if(joinSearcherManager != null && joinSearcher != null){
				try {
					joinSearcherManager.release(joinSearcher);
				} catch (IOException e) {
					throw new SearchResultException("Could not release JoinSearcher for query " + query, e);
				}
			}
		}
	}

	/**
	 * Calculates the maximum result size from the input parameters.
	 * @param query the {@link QueryObject}
	 * @return the max result value
	 */
	private int calculateMaxResult(QueryObject query) {
		int pageNumber = -1;
		int pageSize = -1;
		int maxResults = 0;
		if (query.eIsSet(SearchResultPackage.Literals.QUERY_OBJECT__PAGE_INDEX) && 
				query.eIsSet(SearchResultPackage.Literals.QUERY_OBJECT__PAGE_RESULT_SIZE)  && 
				query.getPageIndex() != 0) {
			pageNumber = query.getPageIndex();
			pageSize = query.getPageResultSize();
			maxResults = pageNumber * pageSize;
			return maxResults;
		} else {
			return query.getMaxResults();
		}
	}

	/**
	 * Runs a grouped search if a {@link GroupingContext} is available
	 * @param query the emf {@link QueryObject}
	 * @param luceneQuery the actual lucene {@link Query}
	 * @param luceneFilter the actual lucene {@link Query}
	 * @param luceneSort the lucene {@link Sort}
	 * @param luceneAnalyzer the lucene {@link Analyzer}
	 * @param maxResults how many results
	 * @param searcherManager the searcher manager
	 * @param luceneCollectors {@link Collector}s to use with the search
	 * @return the {@link SearchResultContext} describing the search output
	 * @return
	 */
	private SearchResultContext executeGroupedQuery(QueryObject query,
			Query luceneQuery, Query luceneFilter, Sort luceneSort,
			Analyzer luceneAnalyzer, int maxResults,
			IndexSearcher indexSearcher, List<Collector> luceneCollectors) throws IOException {
		GroupingContext context = query.getGroupingContext();
		Query filteredQuery = createFilteredQuery(luceneQuery, luceneFilter);
		Sort groupSort = queryProvider.createSort(context.getGroupSort());
		if(groupSort == null){
			groupSort = Sort.RELEVANCE;
		}
		GroupingSearch groupingSearch = new GroupingSearch(context.getGroupFieldName());
		groupingSearch.setGroupSort(groupSort);
		groupingSearch.setSortWithinGroup(luceneSort == null ? Sort.RELEVANCE  : luceneSort);
		groupingSearch.setFillSortFields(true);
		groupingSearch.setGroupDocsLimit(context.getResultsPerGroup());
		groupingSearch.setCachingInMB(context.getCachSize(), true);
		//	    groupingSearch.setAllGroups(true);

		TopGroups<BytesRef> groups = groupingSearch.search(indexSearcher, filteredQuery , context.getOffSet(), context.getMaxGroups());

		SearchResultContext ctx = new SearchResultContext(indexSearcher, luceneQuery, query, luceneAnalyzer, groups, luceneCollectors);

		return ctx;
	}

	/**
	 * Executes the given aftermath collectors. This is currently the only known way to get the results of a joining index. 
	 * @param query the {@link QueryObject} to use
	 * @param ctx the current {@link ISearchResultContext}
	 * @param joinSearcher the join {@link IndexSearcher}
	 * @throws IOException
	 */
	private void executeJoinQueryAftemath(QueryObject query,
			SearchResultContext ctx, IndexSearcher joinSearcher) throws IOException {

		List<ScoreDoc> topDocs = new LinkedList<ScoreDoc>();
		if(ctx.getGroups() != null){
			for(GroupDocs<BytesRef> group : ctx.getGroups().groups){
				topDocs.addAll(Arrays.asList(group.scoreDocs));
			}
		} else  {
			topDocs = Arrays.asList(ctx.getTopDocs().scoreDocs);
		}

		//consider paging
		int maxResult = topDocs.size();
		int startIndex = 0;
		if (query.eIsSet(SearchResultPackage.Literals.QUERY_OBJECT__PAGE_INDEX) && 
				query.eIsSet(SearchResultPackage.Literals.QUERY_OBJECT__PAGE_RESULT_SIZE)  && 
				query.getPageIndex() != 0){
			startIndex = PagingHelper.calculateResultStartIndex(query.getPageIndex(), query.getPageResultSize());
		}


		if(BooleanQuery.getMaxClauseCount() < maxResult - startIndex + 1){
			BooleanQuery.setMaxClauseCount(topDocs.size() + 1);
		}
		BooleanQuery.Builder bqBuilder = new BooleanQuery.Builder();
		for (int i = startIndex; i < topDocs.size(); i++) {
			ScoreDoc scoreDoc = topDocs.get(i);
			Document doc = ctx.getIndexReader().document(scoreDoc.doc);
			String id = doc.get(query.getJoinQuery().getToField());
			String fromField = query.getJoinQuery().getFromField();
			fromField = fromField.substring(0, fromField.indexOf("_binary"));
			TermQuery tq = new TermQuery(new Term(fromField, id));
			bqBuilder.add(tq, Occur.SHOULD);
		}

		List<Collector> collectors = new LinkedList<>();
		for(Object o : query.getJoinQuery().getJoinAftermathCollectors()){
			if(o instanceof ICollectorConfigurator){
				ICollectorConfigurator col = (ICollectorConfigurator) o;
				col.setISearchResultContext(ctx);
				col.setIndexSearcher(joinSearcher);
				col.prepare();
				collectors.add((Collector) col);
			} else if(o instanceof Collector){
				collectors.add((Collector) o);
			} else {
				throw new SearchResultException("unknwon type");
			}
		}
		
//		long start = System.currentTimeMillis();
		joinSearcher.search(bqBuilder.build(), wrapCollectors(collectors));
		//		System.err.println("Time: " + (System.currentTimeMillis() - start) + " from " + startIndex + " to " + maxResult) ;
	}

	/**
	 * @param scoreMode the {@link JoinScoreMode} to switch
	 * @return the {@link ScoreMode}
	 */
	private ScoreMode getScoreMode(JoinScoreMode scoreMode) {
		switch (scoreMode) {
		case AVERAGE:
			return ScoreMode.Avg;
		case MAX:
			return ScoreMode.Max;
		case TOTAL:
			return ScoreMode.Total;
		default:
			return ScoreMode.None;
		}
	}

	/** Sets the query provider.
	 * @param queryProvider the query provider to set
	 */
	public void setQueryProvider(ComponentFactory queryProviderFactory) {
		this.queryProviderFactory = queryProviderFactory;
	}

	/**
	 * Un-sets the query provider.
	 * @param queryProvider the query provider to un-set
	 */
	public void unsetQueryProvider(ComponentFactory queryProviderFactory) {
		this.queryProviderFactory = null;
	}

	/**
	 * Returns the indexWriterProvider.
	 * @return the indexWriterProvider
	 */
	public IIndexWriterProvider getIndexWriterProvider() {
		return indexWriterProvider;
	}

	/**
	 * Sets the index writer provider.
	 * @param indexWriterProvider the index writer provider to set
	 */
	public void setIndexWriterProvider(IIndexWriterProvider indexWriterProvider) {
		this.indexWriterProvider = indexWriterProvider;
	}

	/**
	 * Un-sets the index writer provider.
	 * @param indexWriterProvider the index writer provider to un-set
	 */
	public void unsetIndexWriterProvider(IIndexWriterProvider indexWriterProvider) {
		this.indexWriterProvider = null;
	}

	/**
	 * Sets the {@link LuceneAnalyzerRegistry} to get a Analyzer
	 * @param analyzerRegistry the registry to set
	 */
	public void setAnalyzerRegistry(LuceneAnalyzerRegistry analyzerRegistry) {
		this.analyzerRegistry = analyzerRegistry;
	}

	/**
	 * Executes a Like-This-Query
	 * @param ctx the {@link ISearchResultContext} from the first query
	 * @param result the existing {@link SearchResult}, to append the similar results
	 * @param searcher the {@link IndexSearcher} to use
	 * @throws IOException thrown when errors during search occurs
	 */
	private void executeQueryLikeThis(ISearchResultContext ctx, SearchResult result, IndexSearcher searcher) throws IOException {
		MoreLikeThis mlt = new MoreLikeThis(ctx.getIndexReader());
		mlt.setAnalyzer(ctx.getAnalyzer());
		// These fields must be indexed as TextField
		LikeThisObject lto = ctx.getQueryObject().getLikeThisObject();
		if (lto == null) {
			return;
		}
		String[] likeThisFields = lto.getLikeThisFields().toArray(new String[lto.getLikeThisFields().size()]);
		mlt.setFieldNames(likeThisFields);
		mlt.setMinDocFreq(0);
		mlt.setMinTermFreq(0);
		// create sort and filter
		Sort sort = queryProvider.createSort(lto.getSortFields());
		Query filter = queryProvider.createFilter(lto.getFilterFields());
		int maxResults = lto.getMaxResults() < 1 ? 50 : lto.getMaxResults();

		// go through all resulting documents from the first query and execute the similarity searches
		for (ScoreDoc sd : ctx.getTopDocs().scoreDocs) {

			Query q = null;
			Query mltQuery = mlt.like(sd.doc);
			String fieldName = lto.getFilterSourceField();
			String id = null;
			// filter source object from the similar query
			if (lto.isFilterSourceObject()) {
				Document d = searcher.doc(sd.doc);
				id = d.get(fieldName);
				Query filterQuery = new TermQuery(new Term(fieldName, id));
				BooleanQuery.Builder bqBuilder = new BooleanQuery.Builder();
				bqBuilder.add(mltQuery, Occur.SHOULD);
				bqBuilder.add(filterQuery, Occur.MUST_NOT);
				q = bqBuilder.build();
			} else {
				q = mltQuery;
			}
			TopDocs mltTopDocs = executeQuery(q, filter, maxResults, sort, searcher, null);
			// map the similar result and append it to the result
			SearchResult newResult = ctx.getMapper().createSearchResult(ctx.getIndexReader(), mltTopDocs);
			if (newResult.getCategories().size() > 0) {
				Category c = newResult.getCategories().get(0);
				c.setId(id);
				//				c.setId(Integer.toString(sd.doc));
				c.setName("Like documents field: '" + fieldName + "' " + id);
				result.getCategories().add(c);
			}
		}
	}


	/**
	 * Executes a collector query
	 * @param query the Lucene {@link Query} object
	 * @param collector the {@link Collector} object
	 * @param result the {@link SearchResult}
	 * @param searcher the {@link IndexSearcher} to use
	 * @throws IOException thrown when errors during search occurs
	 */
	private void executeCollectorQuery(Query query, List<Collector> collectors, SearchResult result, IndexSearcher searcher) throws IOException {
		if (result == null || collectors == null || collectors.size() == 0 || query == null) {
			return;
		}
		if(collectors.size() == 1){
			searcher.search(query, collectors.get(0));	
		} else {
			searcher.search(query, wrapCollectors(collectors));	
		}
		result.getNativeCollectorResults().addAll(collectors);
	}

	/**
	 * Executes a faceted search.
	 * @param query the emf {@link QueryObject}
	 * @param luceneQuery the actual lucene {@link Query}
	 * @param luceneFilter the actual lucene {@link Query}
	 * @param luceneSort the lucene {@link Sort}
	 * @param luceneAnalyzer the lucene {@link Analyzer}
	 * @param maxResults how many results
	 * @param indexSearcher the {@link IndexSearcher} to use
	 * @param luceneCollectors {@link Collector}s to use with the search
	 * @param taxoReader 
	 * @return the {@link SearchResultContext} describing the search output
	 * @throws IOException
	 */
	private SearchResultContext executeFacetQuery(QueryObject query, Query luceneQuery,
			Query luceneFilter, Sort luceneSort, Analyzer luceneAnalyzer,
			int maxResults, IndexSearcher indexSearcher, List<Collector> luceneCollectors, TaxonomyReader taxoReader) throws IOException {
		long start = System.currentTimeMillis();
		LOG.debug("Prepare executeFacetQuery Aquire searcher took {}ms", (System.currentTimeMillis() - start));
		start = System.currentTimeMillis();
		Query filteredQuery = createFilteredQuery(luceneQuery, luceneFilter);
		FacetsConfig facetConfig = new FacetsConfig();
		FacetsCollector facetsCollector = new FacetsCollector();
		FacetQueryContext facetQueryContext = query.getFacetQueryContext();
		SearchResultContext ctx = null; 
		List<Collector> collectorsToUse = new LinkedList<Collector>(luceneCollectors);
		collectorsToUse.add(facetsCollector);
		if(luceneSort == null){
			luceneSort = Sort.RELEVANCE;
		}

		LOG.debug("Prepare executeFacetQuery Facet preparation took {}ms", (System.currentTimeMillis() - start));

		if(facetQueryContext.getFacetFields().size() == 0){
			start = System.currentTimeMillis();
			TopDocs topDocs = FacetsCollector.search(indexSearcher, filteredQuery, maxResults, luceneSort, wrapCollectors(collectorsToUse));
			Facets facets = new FastTaxonomyFacetCounts(taxoReader, facetConfig, facetsCollector);
			ctx = new SearchResultContext(indexSearcher, topDocs, luceneQuery, query, luceneAnalyzer, facets, luceneCollectors);
			LOG.debug("executeFacetQuery no facet fields took {}ms", (System.currentTimeMillis() - start));
		} else{
			start = System.currentTimeMillis();
			DrillDownQuery drillDownQuery = null;
			if(luceneFilter == null){
				drillDownQuery = new DrillDownQuery(facetConfig, luceneQuery);
			} else {
				drillDownQuery = new DrillDownQuery(facetConfig, filteredQuery);
			}
			for(FacetFilter ff : facetQueryContext.getFacetFields()){
				drillDownQuery.add(ff.getFacetKey(), ff.getValue().toArray(new String[0]));
			}
			DrillSideways ds = new DrillSideways(indexSearcher, facetConfig, taxoReader);

			TopFieldCollector topFieldCollector = TopFieldCollector.create(luceneSort,
					maxResults,
					true,
					true,
					true);
			collectorsToUse.add(topFieldCollector);
			ds.search(drillDownQuery, wrapCollectors(collectorsToUse));
			Facets facets = new FastTaxonomyFacetCounts(taxoReader, facetConfig, facetsCollector);

			ctx = new SearchResultContext(indexSearcher, topFieldCollector.topDocs(), luceneQuery, query, luceneAnalyzer, facets, luceneCollectors);
			LOG.debug("executeFacetQuery with facet fields took {}ms", (System.currentTimeMillis() - start));
		}
		start = System.currentTimeMillis();
		Map<String, List<MatchHighlight>[]> highlighting = HighlightingHelper.createHighlighting(indexSearcher, ctx);
		ctx.setMatchHighlights(highlighting);
		LOG.debug("executeFacetQuery create match highlight took {}ms", (System.currentTimeMillis() - start));
		return ctx;
	}

	public void deactivate() {
		if (queryProviderCI != null) {
			queryProviderCI.dispose();
		}
	}

	private Collector wrapCollectors(List<Collector> collectors) {
		return MultiCollector.wrap(collectors.toArray(new Collector[0]));
	}

	/**
	 * Executes a Lucene query
	 * @param query the {@link Query} object
	 * @param filter the {@link Query} object, can be <code>null</code>
	 * @param maxResults the number of maximum results
	 * @param sort the {@link Sort} object, can be <code>null</code>
	 * @param analyzer the {@link Analyzer}
	 * @param queryObject the query object
	 * @param searcher the {@link IndexSearcher} to use
	 * @param luceneCollectors {@link Collector}s to use with the search
	 * @return the {@link TopDocs}
	 * @throws IOException thrown when errors during search occurs
	 */
	private SearchResultContext executeQueryContext(Query query, Query filter, int maxResults, Sort sort, Analyzer analyzer, QueryObject queryObject, IndexSearcher searcher , List<Collector> luceneCollectors) throws IOException {
		TopDocs topDocs = executeQuery(query, filter, maxResults, sort, searcher, luceneCollectors);
		SearchResultContext ctx = new SearchResultContext(searcher, topDocs, query, queryObject, analyzer, luceneCollectors);
		Map<String, List<MatchHighlight>[]> highlights = HighlightingHelper.createHighlighting(searcher, ctx);
		ctx.setMatchHighlights(highlights);
		return ctx;
	}

	/**
	 * Executes a Lucene query
	 * @param query the {@link Query} object
	 * @param filter the {@link Query} object, can be <code>null</code>
	 * @param maxResults the number of maximum results
	 * @param sort the {@link Sort} object, can be <code>null</code>
	 * @param searcher the index searcher
	 * @param luceneCollectors the {@link Collector}s to use with the search
	 * @return the {@link TopDocs}
	 * @throws IOException throw when errors during search occurs
	 */
	private TopDocs executeQuery(Query query, Query filter, int maxResults, Sort sort, IndexSearcher searcher, List<Collector> luceneCollectors) throws IOException {
		if (searcher == null) {
			return null;
		}
		TopDocs topDocs = null;
		Query filteredQuery = createFilteredQuery(query, filter);
		if(luceneCollectors == null || luceneCollectors.size() == 0){
			if (filter == null) {
				if (sort != null) {
					sort = sort.rewrite(searcher);
					topDocs = searcher.search(query, maxResults, sort);
				} else {
					topDocs = searcher.search(query, maxResults);
				}
			} else {
				if (sort != null) {
					sort = sort.rewrite(searcher);
					topDocs = searcher.search(filteredQuery, maxResults, sort);
				} else {
					topDocs = searcher.search(filteredQuery, maxResults);
				}
			}
		} else {
			List<Collector> collectorsToUse = new LinkedList<Collector>(luceneCollectors);
			if(sort == null){
				sort = Sort.INDEXORDER;
			}
			sort = sort.rewrite(searcher);
			TopFieldCollector topFieldCollector = TopFieldCollector.create(sort,
					maxResults,
					true,
					true,
					true);
			collectorsToUse.add(topFieldCollector);
			searcher.search(filteredQuery, wrapCollectors(collectorsToUse));
			return topFieldCollector.topDocs();
		}
		return topDocs;
	}


	/**
	 * Creates a filter query
	 * @param luceneQuery the query
	 * @param luceneFilter the filter query
	 * @return the filter query
	 */
	private Query createFilteredQuery(Query luceneQuery, Query luceneFilter) {
		if (luceneQuery == null) {
			return null;
		}
		if (luceneFilter == null) {
			return luceneQuery;
		}
		BooleanQuery.Builder queryBuilder = new BooleanQuery.Builder();
		queryBuilder.add(luceneQuery, Occur.MUST);
		queryBuilder.add(luceneFilter, Occur.FILTER);
		return queryBuilder.build();
	}

	/**
	 * Creates a Lucene {@link Query} from the data model {@link QueryObject}
	 * @param queryObject the {@link QueryObject}
	 * @param analyzer the analyzer is optional, only used for the QueryBuilder/QueryParser
	 * @return the Lucene {@link Query} or <code>null</code>
	 */
	private Query createQuery(QueryObject queryObject, Analyzer analyzer) {
		if (queryObject == null) {
			return null;
		}
		Query generatedQuery = null;

		generatedQuery = queryProvider.createQuery(queryObject, analyzer);

		//		if(nativeQuery == null){
		//			return generatedQuery;
		//		} else {
		//			if(generatedQuery instanceof MatchAllDocsQuery){
		//				return nativeQuery;
		//			} else {
		//				BooleanQuery bq = new BooleanQuery();
		//				bq.add(nativeQuery, Occur.MUST);
		//				bq.add(generatedQuery, Occur.MUST);
		//				return bq;
		//			}
		//		}
		return generatedQuery; 

	}
	//	private Query createQuery(QueryObject queryObject, Analyzer analyzer, ILuceneQueryProvider queryProvider) {
	//		if (queryObject == null) {
	//			return null;
	//		}
	//		Query generatedQuery = null;
	//		
	//		generatedQuery = queryProvider.createQuery(queryObject, analyzer);
	//		
	////		if(nativeQuery == null){
	////			return generatedQuery;
	////		} else {
	////			if(generatedQuery instanceof MatchAllDocsQuery){
	////				return nativeQuery;
	////			} else {
	////				BooleanQuery bq = new BooleanQuery();
	////				bq.add(nativeQuery, Occur.MUST);
	////				bq.add(generatedQuery, Occur.MUST);
	////				return bq;
	////			}
	////		}
	//		return generatedQuery; 
	//		
	//	}

	/**
	 * Switches the model {@link de.dim.searchresult.Occur} to the corresponding lucene {@link Occur}
	 * @param occur the {@link de.dim.searchresult.Occur} from the model
	 * @return the corresponding {@link Occur} of lucene
	 */
	private Occur getLuceneOccur(org.gecko.searchresult.Occur occur) {
		switch (occur.getValue()){
		case org.gecko.searchresult.Occur.SHOULD_VALUE:
			return Occur.SHOULD;
		case org.gecko.searchresult.Occur.MUST_VALUE:
			return Occur.MUST;
		default:
			return Occur.MUST_NOT;
		}
	}

	/**
	 * Extracts the {@link Collector} from the queryObject parameter and returns it or <code>null</code>,
	 * if it doesn't exists
	 * @param queryObject the query object to get the collector from
	 * @return the {@link Collector} object or <code>null</code>
	 */
	private List<Collector> getCollector(QueryObject queryObject) {
		List<Object> collectors = queryObject.getNativeCollectors();
		List<Collector> result = new ArrayList<Collector>(collectors.size());		
		for(Object o : collectors){
			result.add((Collector) o);
		}
		return result;
	}

	/**
	 * Acquires a {@link SearcherManager} from the {@link IIndexWriterProvider} for the query object
	 * @param queryObject the query object
	 * @return the {@link SearcherManager} instance
	 * @throws IOException thrown on opening errors
	 */
	private SearcherManager getSearcherManager(QueryObject queryObject) throws IOException {
		return getSearcherManager(queryObject.getIndexPath());
	}

	/**
	 * Acquires a {@link SearcherManager} from the {@link IIndexWriterProvider} for the given path
	 * @param indexPath the path for the index
	 * @return the {@link SearcherManager} instance
	 * @throws IOException thrown on opening errors
	 */
	private SearcherManager getSearcherManager(String indexPath) throws IOException {
		return indexWriterProvider.getSearcherManager(indexPath);
	}

	public void activate(){
		queryProviderCI = queryProviderFactory.newInstance(null);
		queryProvider = (ILuceneQueryProvider) queryProviderCI.getInstance();
	}

	public void setQueryProviderInstance(ILuceneQueryProvider provider) {
		queryProvider = provider;
	}

}