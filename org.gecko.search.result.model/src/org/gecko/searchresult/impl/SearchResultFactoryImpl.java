/**
 * Copyright (c) 2012 - 2018 Data In Motion and others.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *     Data In Motion - initial API and implementation
 */
package org.gecko.searchresult.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.gecko.searchresult.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SearchResultFactoryImpl extends EFactoryImpl implements SearchResultFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SearchResultFactory init() {
		try {
			SearchResultFactory theSearchResultFactory = (SearchResultFactory)EPackage.Registry.INSTANCE.getEFactory(SearchResultPackage.eNS_URI);
			if (theSearchResultFactory != null) {
				return theSearchResultFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SearchResultFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SearchResultFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SearchResultPackage.SEARCH_RESULT: return createSearchResult();
			case SearchResultPackage.CATEGORY: return createCategory();
			case SearchResultPackage.MATCH_RESULT: return createMatchResult();
			case SearchResultPackage.MATCH_HIGHLIGHT: return createMatchHighlight();
			case SearchResultPackage.MATCH_FIELD: return createMatchField();
			case SearchResultPackage.QUERY_OBJECT: return createQueryObject();
			case SearchResultPackage.MULTI_TOKEN_FUZZY_FIELD: return createMultiTokenFuzzyField();
			case SearchResultPackage.FILTER_FIELD: return createFilterField();
			case SearchResultPackage.MULTI_TOKEN_TERM_QUERY: return createMultiTokenTermQuery();
			case SearchResultPackage.QUERY_OBJECT_CONTAINER: return createQueryObjectContainer();
			case SearchResultPackage.SORT_FIELD: return createSortField();
			case SearchResultPackage.SPATIAL_FILTER_FIELD: return createSpatialFilterField();
			case SearchResultPackage.WILDCARD_FIELD: return createWildcardField();
			case SearchResultPackage.RESULT_DESCRIPTOR: return createResultDescriptor();
			case SearchResultPackage.RESULT_FIELD: return createResultField();
			case SearchResultPackage.RESULT_DESCRIPTOR_CONTAINER: return createResultDescriptorContainer();
			case SearchResultPackage.LIKE_THIS_OBJECT: return createLikeThisObject();
			case SearchResultPackage.FACET_FILTER: return createFacetFilter();
			case SearchResultPackage.FACET_QUERY_CONTEXT: return createFacetQueryContext();
			case SearchResultPackage.FACET_RESULT: return createFacetResult();
			case SearchResultPackage.JOIN_QUERY: return createJoinQuery();
			case SearchResultPackage.SPATIAL_SORT_FIELD: return createSpatialSortField();
			case SearchResultPackage.GROUPING_CONTEXT: return createGroupingContext();
			case SearchResultPackage.SPATIAL_FIELD: return createSpatialField();
			case SearchResultPackage.SPAN_TERM_FIELD: return createSpanTermField();
			case SearchResultPackage.BOOLEAN_QUERY: return createBooleanQuery();
			case SearchResultPackage.LUCENE_QUERY_FIELD: return createLuceneQueryField();
			case SearchResultPackage.BOOSTABLE_FIELD: return createBoostableField();
			case SearchResultPackage.BOOLEAN_CLAUSE: return createBooleanClause();
			case SearchResultPackage.DOUBLE_RANGE_QUERY: return createDoubleRangeQuery();
			case SearchResultPackage.SINGLE_TOKEN_TERM_QUERY: return createSingleTokenTermQuery();
			case SearchResultPackage.SINGLE_TOKEN_FUZZY_FIELD: return createSingleTokenFuzzyField();
			case SearchResultPackage.SPAN_QUERY_FIELD: return createSpanQueryField();
			case SearchResultPackage.PHRASE_QUERY: return createPhraseQuery();
			case SearchResultPackage.MULTI_PHRASE_QUERY: return createMultiPhraseQuery();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case SearchResultPackage.FILTERING_TYPE:
				return createFilteringTypeFromString(eDataType, initialValue);
			case SearchResultPackage.SORT_TYPE:
				return createSortTypeFromString(eDataType, initialValue);
			case SearchResultPackage.SORT_DIRECTION_TYPE:
				return createSortDirectionTypeFromString(eDataType, initialValue);
			case SearchResultPackage.OCCUR:
				return createOccurFromString(eDataType, initialValue);
			case SearchResultPackage.JOIN_SCORE_MODE:
				return createJoinScoreModeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case SearchResultPackage.FILTERING_TYPE:
				return convertFilteringTypeToString(eDataType, instanceValue);
			case SearchResultPackage.SORT_TYPE:
				return convertSortTypeToString(eDataType, instanceValue);
			case SearchResultPackage.SORT_DIRECTION_TYPE:
				return convertSortDirectionTypeToString(eDataType, instanceValue);
			case SearchResultPackage.OCCUR:
				return convertOccurToString(eDataType, instanceValue);
			case SearchResultPackage.JOIN_SCORE_MODE:
				return convertJoinScoreModeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SearchResult createSearchResult() {
		SearchResultImpl searchResult = new SearchResultImpl();
		return searchResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Category createCategory() {
		CategoryImpl category = new CategoryImpl();
		return category;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatchResult createMatchResult() {
		MatchResultImpl matchResult = new MatchResultImpl();
		return matchResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatchHighlight createMatchHighlight() {
		MatchHighlightImpl matchHighlight = new MatchHighlightImpl();
		return matchHighlight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatchField createMatchField() {
		MatchFieldImpl matchField = new MatchFieldImpl();
		return matchField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QueryObject createQueryObject() {
		QueryObjectImpl queryObject = new QueryObjectImpl();
		return queryObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiTokenFuzzyField createMultiTokenFuzzyField() {
		MultiTokenFuzzyFieldImpl multiTokenFuzzyField = new MultiTokenFuzzyFieldImpl();
		return multiTokenFuzzyField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FilterField createFilterField() {
		FilterFieldImpl filterField = new FilterFieldImpl();
		return filterField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiTokenTermQuery createMultiTokenTermQuery() {
		MultiTokenTermQueryImpl multiTokenTermQuery = new MultiTokenTermQueryImpl();
		return multiTokenTermQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QueryObjectContainer createQueryObjectContainer() {
		QueryObjectContainerImpl queryObjectContainer = new QueryObjectContainerImpl();
		return queryObjectContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SortField createSortField() {
		SortFieldImpl sortField = new SortFieldImpl();
		return sortField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpatialFilterField createSpatialFilterField() {
		SpatialFilterFieldImpl spatialFilterField = new SpatialFilterFieldImpl();
		return spatialFilterField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WildcardField createWildcardField() {
		WildcardFieldImpl wildcardField = new WildcardFieldImpl();
		return wildcardField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultDescriptor createResultDescriptor() {
		ResultDescriptorImpl resultDescriptor = new ResultDescriptorImpl();
		return resultDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultField createResultField() {
		ResultFieldImpl resultField = new ResultFieldImpl();
		return resultField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultDescriptorContainer createResultDescriptorContainer() {
		ResultDescriptorContainerImpl resultDescriptorContainer = new ResultDescriptorContainerImpl();
		return resultDescriptorContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LikeThisObject createLikeThisObject() {
		LikeThisObjectImpl likeThisObject = new LikeThisObjectImpl();
		return likeThisObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FacetFilter createFacetFilter() {
		FacetFilterImpl facetFilter = new FacetFilterImpl();
		return facetFilter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FacetQueryContext createFacetQueryContext() {
		FacetQueryContextImpl facetQueryContext = new FacetQueryContextImpl();
		return facetQueryContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FacetResult createFacetResult() {
		FacetResultImpl facetResult = new FacetResultImpl();
		return facetResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JoinQuery createJoinQuery() {
		JoinQueryImpl joinQuery = new JoinQueryImpl();
		return joinQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpatialSortField createSpatialSortField() {
		SpatialSortFieldImpl spatialSortField = new SpatialSortFieldImpl();
		return spatialSortField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GroupingContext createGroupingContext() {
		GroupingContextImpl groupingContext = new GroupingContextImpl();
		return groupingContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpatialField createSpatialField() {
		SpatialFieldImpl spatialField = new SpatialFieldImpl();
		return spatialField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpanTermField createSpanTermField() {
		SpanTermFieldImpl spanTermField = new SpanTermFieldImpl();
		return spanTermField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanQuery createBooleanQuery() {
		BooleanQueryImpl booleanQuery = new BooleanQueryImpl();
		return booleanQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LuceneQueryField createLuceneQueryField() {
		LuceneQueryFieldImpl luceneQueryField = new LuceneQueryFieldImpl();
		return luceneQueryField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoostableField createBoostableField() {
		BoostableFieldImpl boostableField = new BoostableFieldImpl();
		return boostableField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanClause createBooleanClause() {
		BooleanClauseImpl booleanClause = new BooleanClauseImpl();
		return booleanClause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleRangeQuery createDoubleRangeQuery() {
		DoubleRangeQueryImpl doubleRangeQuery = new DoubleRangeQueryImpl();
		return doubleRangeQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SingleTokenTermQuery createSingleTokenTermQuery() {
		SingleTokenTermQueryImpl singleTokenTermQuery = new SingleTokenTermQueryImpl();
		return singleTokenTermQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SingleTokenFuzzyField createSingleTokenFuzzyField() {
		SingleTokenFuzzyFieldImpl singleTokenFuzzyField = new SingleTokenFuzzyFieldImpl();
		return singleTokenFuzzyField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpanQueryField createSpanQueryField() {
		SpanQueryFieldImpl spanQueryField = new SpanQueryFieldImpl();
		return spanQueryField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PhraseQuery createPhraseQuery() {
		PhraseQueryImpl phraseQuery = new PhraseQueryImpl();
		return phraseQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiPhraseQuery createMultiPhraseQuery() {
		MultiPhraseQueryImpl multiPhraseQuery = new MultiPhraseQueryImpl();
		return multiPhraseQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FilteringType createFilteringTypeFromString(EDataType eDataType, String initialValue) {
		FilteringType result = FilteringType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFilteringTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SortType createSortTypeFromString(EDataType eDataType, String initialValue) {
		SortType result = SortType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSortTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SortDirectionType createSortDirectionTypeFromString(EDataType eDataType, String initialValue) {
		SortDirectionType result = SortDirectionType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSortDirectionTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Occur createOccurFromString(EDataType eDataType, String initialValue) {
		Occur result = Occur.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOccurToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JoinScoreMode createJoinScoreModeFromString(EDataType eDataType, String initialValue) {
		JoinScoreMode result = JoinScoreMode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJoinScoreModeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SearchResultPackage getSearchResultPackage() {
		return (SearchResultPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SearchResultPackage getPackage() {
		return SearchResultPackage.eINSTANCE;
	}

} //SearchResultFactoryImpl
