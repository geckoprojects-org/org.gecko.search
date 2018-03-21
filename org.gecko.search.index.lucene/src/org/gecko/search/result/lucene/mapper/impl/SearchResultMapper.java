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
package org.gecko.search.result.lucene.mapper.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.facet.FacetResult;
import org.apache.lucene.facet.Facets;
import org.apache.lucene.facet.LabelAndValue;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.search.Explanation;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.grouping.GroupDocs;
import org.apache.lucene.search.grouping.TopGroups;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.apache.lucene.search.highlight.TokenSources;
import org.apache.lucene.util.BytesRef;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.gecko.search.result.core.SearchResultException;
import org.gecko.search.result.lucene.helper.PagingHelper;
import org.gecko.search.result.lucene.highlight.HighlightingHelper;
import org.gecko.search.result.lucene.mapper.ISearchResultMapper;
import org.gecko.search.result.lucene.query.ISearchResultContext;
import org.gecko.searchresult.Category;
import org.gecko.searchresult.FacetQueryContext;
import org.gecko.searchresult.GroupingContext;
import org.gecko.searchresult.MatchField;
import org.gecko.searchresult.MatchHighlight;
import org.gecko.searchresult.MatchResult;
import org.gecko.searchresult.SearchResult;
import org.gecko.searchresult.SearchResultFactory;

/**
 * Mapper implementation from {@link TopDocs} search result into search result 
 * @author Mark Hoffmann
 * @since 08.08.2014
 */
@SuppressWarnings("deprecation")
public class SearchResultMapper implements ISearchResultMapper {

	private final Map<Integer, Explanation> explanationMap = new HashMap<Integer, Explanation>();
	private ISearchResultContext context;
	private FacetQueryContext facetQueryContext;
	
	/**
	 * Creates a new instance.
	 */
	public SearchResultMapper(ISearchResultContext context) {
		this.context = context;
	}
	
	/**
	 * Creates a new instance.
	 */
	public SearchResultMapper() {
	}
	
	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.result.lucene.mapper.ISearchResultMapper#createSearchResult(de.dim.search.result.lucene.mapper.ISearchResultContext)
	 */
	@Override
	public SearchResult createSearchResult(ISearchResultContext context) {
		//XXX Muessen wir das redundant machen oder koennen wir das nich alles zu einer der drei methoden zusammenfuehren?
		if (context == null) {
			throw new SearchResultException("Error creating SearchResult with a null context");
		}
		if (context.getIndexReader() == null) {
			throw new SearchResultException("Error creating SearchResult with a null IndexSearcher");
		}
		this.context = context;
		SearchResult result = SearchResultFactory.eINSTANCE.createSearchResult();
		Category category = SearchResultFactory.eINSTANCE.createCategory();
		result.getCategories().add(category);
		TopDocs topdocs = context.getTopDocs();
		category.setMatchResultSize(topdocs.totalHits);
		for (int i = 0 ; i < topdocs.scoreDocs.length ; i++) {
			ScoreDoc sd = topdocs.scoreDocs[i];
			try {
				Document document = context.getIndexSearcher().doc(sd.doc);
				MatchResult mr = SearchResultFactory.eINSTANCE.createMatchResult();
				category.getResults().add(mr);
				mr.setScore(sd.score);
//				List<MatchField> fields = mapFieldsOld(document, sd.doc, context);
				List<MatchField> fields = mapFields(document, i, context);
				mr.getFields().addAll(fields);
			} catch (IOException e) {
				throw new SearchResultException("Error mapping score docs into SearchResult", e);
			}
		}
		return result;
	}
	
	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.result.lucene.mapper.ISearchResultMapper#createSearchResult(org.apache.lucene.index.IndexReader, org.apache.lucene.search.TopDocs)
	 */
	public SearchResult createSearchResult(IndexReader reader, TopDocs topdocs) {
		//XXX Muessen wir das redundant machen oder koennen wir das nich alles zu einer der drei methoden zusammenschieben?
		
		if (reader == null) {
			throw new SearchResultException("Error creating SearchResult with a null IndexSearcher");
		}
		if (topdocs == null) {
			throw new SearchResultException("Error creating SearchResult with null TopDocs");
		}
		SearchResult result = SearchResultFactory.eINSTANCE.createSearchResult();
		Category category = SearchResultFactory.eINSTANCE.createCategory();
		result.getCategories().add(category);
		category.setMatchResultSize(topdocs.totalHits);
		;
		for (int i = 0 ; i < topdocs.scoreDocs.length ; i++) {
			ScoreDoc sd = topdocs.scoreDocs[i];
			try {
				Document document = context.getIndexSearcher().doc(sd.doc);
				MatchResult mr = SearchResultFactory.eINSTANCE.createMatchResult();
				category.getResults().add(mr);
				mr.setScore(sd.score);
				List<MatchField> fields = mapFields(document, i, context);
//				List<MatchField> fields = mapFieldsOld(document, sd.doc, context);
				mr.getFields().addAll(fields);
			} catch (IOException e) {
				throw new SearchResultException("Error mapping score docs into SearchResult", e);
			}
		}
		return result;
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.result.lucene.mapper.ISearchResultMapper#createSearchResult(de.dim.search.result.lucene.mapper.ISearchResultContext)
	 */
	@Override
	public SearchResult createSearchResult() throws IOException {
		if (context == null) {
			throw new SearchResultException("Error creating SearchResult with a null context");
		}
		if (context.getIndexReader() == null) {
			throw new SearchResultException("Error creating SearchResult with a null IndexSearcher");
		}
		IndexReader reader = context.getIndexReader();
		SearchResult result = SearchResultFactory.eINSTANCE.createSearchResult();
		result.getNativeCollectorResults().addAll(context.getCollectors());
		if(context.getQueryObject().getJoinQuery() != null){
			result.getNativeJoinCollectorResults().addAll(context.getQueryObject().getJoinQuery().getJoinAftermathCollectors());
		}
		
		if(context.getGroups() != null){
			return buildGroupResult(reader, result);
		}
		
		if(context.getFacets() != null){
			facetQueryContext = context.getQueryObject().getFacetQueryContext();
			Facets facets = context.getFacets();
//			if(facets instanceof MultiFacets){
//				//TODO Multifacets implementieren
//				throw new UnsupportedOperationException("Hircachical Facets are not Implemented right now!!!!");
//			}
			if(facetQueryContext.getMaxFacets() > 0){
				List<FacetResult> allDims = facets.getAllDims(facetQueryContext.getMaxFacets());
				for(FacetResult facetResult : allDims){
					if(facetResult != null && (facetQueryContext.getDimensions().isEmpty() || facetQueryContext.getDimensions().contains(facetResult.dim))){
						for(LabelAndValue lav : facetResult.labelValues){
							org.gecko.searchresult.FacetResult fr = SearchResultFactory.eINSTANCE.createFacetResult();
							fr.setKey(facetResult.dim);
							fr.setValue(lav.label);
							if(facetQueryContext.isCountFacets()){
								fr.setCount(lav.value.intValue());
							}
							result.getFacetResults().add(fr);
							if(isFillInCategories()){
								Category category = SearchResultFactory.eINSTANCE.createCategory();
								category.setMatchResultSize(lav.value.intValue());
								category.setId(fr.getKey() + "_" + fr.getValue());
								category.setName(fr.getValue());
								result.getCategories().add(category);
							}
						}
					}
				}
			}
		}
		
		
		
		TopDocs topdocs = context.getTopDocs();
		Category defaultCategory = null;
		defaultCategory = SearchResultFactory.eINSTANCE.createCategory();
		if(!isFillInCategories()){
			result.getCategories().add(defaultCategory);
			defaultCategory.setMatchResultSize(topdocs.totalHits);
		}
		int start = 0;
		int max = topdocs.scoreDocs.length;
		
		if(!isFillInCategories() && context.getQueryObject().getPageIndex() != null && context.getQueryObject().getPageResultSize() != null){
			result.setPageSize(context.getQueryObject().getPageResultSize() );
			result.setNumberPages(PagingHelper.getPageSize(topdocs.totalHits, context.getQueryObject().getPageResultSize()));
			start = PagingHelper.calculateResultStartIndex(context.getQueryObject().getPageIndex(), context.getQueryObject().getPageResultSize());
		}
		
		for (int i = start; i < max; i++) {
			try {
				ScoreDoc sd = topdocs.scoreDocs[i];
				Document document = context.getIndexSearcher().doc(sd.doc);
				MatchResult mr = SearchResultFactory.eINSTANCE.createMatchResult();
				mr.setScore(sd.score);
				List<MatchField> fields = mapFields(document, i, context);
				if(context.getQueryObject().isExplain()){
					Explanation explain = context.getIndexSearcher().explain(context.getQuery(), sd.doc);
					mr.setExplanation(explain);
				}
				mr.getFields().addAll(fields);
				if(isFillInCategories()){
					List<Category> catsToAddTo = identifyCategories(document, result, defaultCategory);
					for (Category cat : catsToAddTo){
						if(facetQueryContext.getMaxResultPerCategory() == null || cat.getResults().size() < facetQueryContext.getMaxResultPerCategory()){
							cat.getResults().add(EcoreUtil.copy(mr));
							if(!allowDuplicatesInCategories()){
								break;
							}
						}
					}
				} else {
					defaultCategory.getResults().add(mr);
				}
			} catch (IOException e) {
				throw new SearchResultException("Error mapping score docs into SearchResult", e);
			}
			//To get a little bt performance we stop after all categories are full
			if(checkIfCategoriesAreFull(result)){
				break;
			}
		}
		
		result.setId(context.getQueryObject().getId());
		return result;
	}
	


	/**
	 * Maps the group search result
	 * @param reader
	 * @param result
	 * @return
	 */
	private SearchResult buildGroupResult(IndexReader reader,
			SearchResult result) {
		TopGroups<BytesRef> groups = context.getGroups();
		GroupingContext groupingContext = context.getQueryObject().getGroupingContext();
		for(GroupDocs<BytesRef> group : groups.groups){
			Category category = SearchResultFactory.eINSTANCE.createCategory();
			category.setMatchResultSize(group.totalHits);
			String value = "EMPTY";
			if(group.groupValue != null){
				value = group.groupValue.utf8ToString();
			}
			category.setId(value);
			category.setName(value);
			result.getCategories().add(category);
			boolean nameSet = false;
			for(ScoreDoc sd : group.scoreDocs){
				try {
					Document document = context.getIndexSearcher().doc(sd.doc);
					MatchResult mr = SearchResultFactory.eINSTANCE.createMatchResult();
					mr.setScore(sd.score);
					List<MatchField> fields = mapFields(document, sd.doc, context);
					mr.getFields().addAll(fields);
					category.getResults().add(mr);
					if(!nameSet){
						MatchField groupName = mr.getMatchFieldById(groupingContext.getGroupFieldName());
						if(groupName != null){
							category.setId(groupingContext.getGroupFieldName() + "_" + (String) groupName.getValue());
							category.setName(((String) groupName.getValue()));
						}
					}
				} catch (IOException e) {
					throw new SearchResultException("Error mapping score docs into SearchResult", e);
				}
			}
		}
		return result;
	}

	/**
	 * Checks if all Categories are filed with the max desired or available results
	 * @param result the current result
	 * @return false a category <code>cat.getResults().size() != facetQueryContext.getMaxResultPerCategory() || cat.getResults().size() != cat.getMatchResultSize()</code>
	 */
	private boolean checkIfCategoriesAreFull(SearchResult result) {
		if(facetQueryContext == null || facetQueryContext.getMaxResultPerCategory() == null){
			return false;
		}
		for(Category cat : result.getCategories()){
			if(cat.getResults().size() != facetQueryContext.getMaxResultPerCategory() || cat.getResults().size() != cat.getMatchResultSize())
				return false;
		}
		return true;
	}

	/**
	 * @return true if duplcates are allowed in categories
	 */
	private boolean allowDuplicatesInCategories() {
		if( facetQueryContext == null)
			facetQueryContext = context.getQueryObject().getFacetQueryContext();
		if( facetQueryContext == null)
			return false;
		
		return facetQueryContext.isAllowDuplicatesInCategories();
	}

	private List<Category> identifyCategories(Document document,
			SearchResult result, Category defaultCategory) {
		List<Category> resultList = new LinkedList<Category>();
		IndexableField[] fields = document.getFields("_facet");
		for(IndexableField field : fields){
			String stringValue = field.stringValue();
			String[] valueLable = stringValue.split("\\$");
			//XXX We currently support only normal facets. For hirachy, we have to add do something...
			if(valueLable.length > 2){
				throw new UnsupportedOperationException("Hirachical Facets are not supported for categoriesatio rigth now");
			}
			
			String toLookFor = valueLable[0] + "_" + valueLable[1];
			for(Category cat : result.getCategories()){
				if(toLookFor.equals(cat.getId())){
					resultList.add(cat);
					break;
				}
			}
			
		}
		if(resultList.size() == 0 ){
			if(defaultCategory.eContainer() == null){
				result.getCategories().add(defaultCategory);
			}
			resultList.add(defaultCategory);
		}
		return resultList;
	}

	/**
	 * @return true if categories should be filled according to known facets
	 */
	private boolean isFillInCategories() {
		if( facetQueryContext == null)
			facetQueryContext = context.getQueryObject().getFacetQueryContext();
		if( facetQueryContext == null)
			return false;
		
		return facetQueryContext.isFillInCategories();
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.result.lucene.ISearchResultMapper#createHighLightInformation(de.dim.searchresult.SearchResult, org.apache.lucene.search.TopDocs, org.apache.lucene.search.Query)
	 */
	@Override
	public void createHighLightInformation(SearchResult result, TopDocs topDocs, Query query) {
		if (context.getIndexReader() == null) {
			throw new SearchResultException("Error creating HighLightInformation with a null IndexSearcher");
		}
		if (result == null || topDocs == null || query == null) {
			return;
		}
		IndexReader reader = context.getIndexReader();
		for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
			try {
				Explanation explanation = context.getIndexSearcher().explain(query, scoreDoc.doc);
				explanationMap.put(scoreDoc.doc, explanation);
			} catch (IOException e) {
				throw new SearchResultException("Error creating explanation map", e);
			}
		}
	}
	
	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.result.lucene.mapper.ISearchResultMapper#createHighlightInformation(java.lang.String, int, org.apache.lucene.search.IndexSearcher, org.apache.lucene.search.highlight.Highlighter, java.lang.String)
	 */
	public List<MatchHighlight> createHighlightInformation(String fieldName, int docId, IndexSearcher searcher, Highlighter highlighter, String originalText) throws IOException, InvalidTokenOffsetsException {
		TokenStream tokenStream = TokenSources.getAnyTokenStream(searcher.getIndexReader(), docId, fieldName, context.getAnalyzer());
		highlighter.getBestTextFragments(tokenStream, originalText, false, 10);
		List<MatchHighlight> highlightResult = new ArrayList<>(context.getFormatter().getHighlightInformation());
		context.getFormatter().resetHighlightInformation();
		return highlightResult;
	}
	
	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.result.lucene.mapper.ISearchResultMapper#createHighlightInformation(java.lang.String, int, java.lang.String, de.dim.search.result.lucene.mapper.ISearchResultContext)
	 */
	@Override
	public List<MatchHighlight> createHighlightInformation(String fieldName, int docId, String originalText, ISearchResultContext context)
			throws IOException, InvalidTokenOffsetsException {
		return HighlightingHelper.createHighlightInformation(fieldName, docId, originalText, context);
	}
	
	/**
	 * Maps all fields from a given {@link Document}
	 * @param document the Lucene document
	 * @param index the document index
	 * @param context the context can be <code>null</code>
	 * @return the list of {@link MatchField}
	 */
	private List<MatchField> mapFields(Document document, int index, ISearchResultContext context) {
		List<MatchField> resultFields = new ArrayList<>(document.getFields().size());
		Map<String, MatchField> resultFieldMap = new HashMap<>(document.getFields().size());
		for (IndexableField field : document.getFields()) {
			String key = field.name();
			MatchField mf = null;
			if (resultFieldMap.containsKey(key)) {
				mf = resultFieldMap.get(key);
				mf.setMultiValue(true);
				mapMultiValue(field, mf);
			} else {
				mf = SearchResultFactory.eINSTANCE.createMatchField();
				mf.setId(key);
				
				Object value = getValue((Field) field);
				if (context != null && context.getHighlightFields().contains(key) && value instanceof String) {
					try {
						List<MatchHighlight> highlights = context.getMatchHighlights().get(key)[index];
						mf.getHighlighting().addAll(highlights);
					} catch (Exception e) {
						// ignore
					}
				}
				mf.setValue(value);
				resultFieldMap.put(key, mf);
				resultFields.add(mf);
			}
		}
		resultFieldMap.clear();
		return resultFields;
	}
	
	/**
	 * Maps all fields from a given {@link Document}
	 * @param document the Lucene document
	 * @param docId the score doc id
	 * @param context the context can be <code>null</code>
	 * @return the list of {@link MatchField}
	 * @deprecated use {@link SearchResultMapper#mapFields(Document, int, ISearchResultContext)} instead
	 */
	private List<MatchField> mapFieldsOld(Document document, int docId, ISearchResultContext context) {
		List<MatchField> resultFields = new ArrayList<>(document.getFields().size());
		Map<String, MatchField> resultFieldMap = new HashMap<>(document.getFields().size());
		for (IndexableField field : document.getFields()) {
			String key = field.name();
			MatchField mf = null;
			if (resultFieldMap.containsKey(key)) {
				mf = resultFieldMap.get(key);
				mf.setMultiValue(true);
				mapMultiValue(field, mf);
			} else {
				mf = SearchResultFactory.eINSTANCE.createMatchField();
				mf.setId(key);
				
				Object value = getValue((Field) field);
				if (context != null && context.getHighlightFields().contains(key) && value instanceof String) {
					List<MatchHighlight> highlighting;
					try {
						highlighting = createHighlightInformation(key, docId, (String)value, context);
						mf.getHighlighting().addAll(highlighting);
					} catch (Exception e) {
						// ignore
					}
				}
				mf.setValue(value);
				resultFieldMap.put(key, mf);
				resultFields.add(mf);
			}
		}
		resultFieldMap.clear();
		return resultFields;
	}

	/**
	 * Maps the content of the lucene field for multi value fields
	 * @param field the lucene field
	 * @param matchField the {@link MatchField} multi value field
	 */
	@SuppressWarnings("unchecked")
	private void mapMultiValue(IndexableField field, MatchField matchField) {
		Object oldValue = matchField.getValue();
		List<Object> resultList;
		if (oldValue instanceof List<?>) {
			resultList = (List<Object>) oldValue;
		} else {
			resultList = new LinkedList<Object>();
			matchField.setValue(resultList);
			resultList.add(oldValue);
		}
		resultList.add(field.stringValue());
	}

	/**
	 * Returns the field value
	 * @param field the field to get the value from
	 * @return the value as object
	 */
	private Object getValue(Field field) {
		if (field.numericValue() == null) {
			return field.stringValue();
		} else {
			return field.numericValue();
		}
	}
	
}
