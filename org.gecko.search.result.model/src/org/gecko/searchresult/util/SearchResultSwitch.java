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
package org.gecko.searchresult.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.gecko.searchresult.*;

import org.gecko.utilities.query.Query;
import org.gecko.utilities.query.QueryCondition;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.gecko.searchresult.SearchResultPackage
 * @generated
 */
public class SearchResultSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SearchResultPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SearchResultSwitch() {
		if (modelPackage == null) {
			modelPackage = SearchResultPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case SearchResultPackage.SEARCH_RESULT: {
				SearchResult searchResult = (SearchResult)theEObject;
				T result = caseSearchResult(searchResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SearchResultPackage.CATEGORY: {
				Category category = (Category)theEObject;
				T result = caseCategory(category);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SearchResultPackage.MATCH_RESULT: {
				MatchResult matchResult = (MatchResult)theEObject;
				T result = caseMatchResult(matchResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SearchResultPackage.MATCH_HIGHLIGHT: {
				MatchHighlight matchHighlight = (MatchHighlight)theEObject;
				T result = caseMatchHighlight(matchHighlight);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SearchResultPackage.MATCH_FIELD: {
				MatchField matchField = (MatchField)theEObject;
				T result = caseMatchField(matchField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SearchResultPackage.QUERY_OBJECT: {
				QueryObject queryObject = (QueryObject)theEObject;
				T result = caseQueryObject(queryObject);
				if (result == null) result = caseQuery(queryObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SearchResultPackage.MULTI_TOKEN_FUZZY_FIELD: {
				MultiTokenFuzzyField multiTokenFuzzyField = (MultiTokenFuzzyField)theEObject;
				T result = caseMultiTokenFuzzyField(multiTokenFuzzyField);
				if (result == null) result = caseMultiTokenTermQuery(multiTokenFuzzyField);
				if (result == null) result = caseLuceneQueryField(multiTokenFuzzyField);
				if (result == null) result = caseBoostableField(multiTokenFuzzyField);
				if (result == null) result = caseQueryCondition(multiTokenFuzzyField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SearchResultPackage.FILTER_FIELD: {
				FilterField filterField = (FilterField)theEObject;
				T result = caseFilterField(filterField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SearchResultPackage.MULTI_TOKEN_TERM_QUERY: {
				MultiTokenTermQuery multiTokenTermQuery = (MultiTokenTermQuery)theEObject;
				T result = caseMultiTokenTermQuery(multiTokenTermQuery);
				if (result == null) result = caseLuceneQueryField(multiTokenTermQuery);
				if (result == null) result = caseBoostableField(multiTokenTermQuery);
				if (result == null) result = caseQueryCondition(multiTokenTermQuery);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SearchResultPackage.QUERY_OBJECT_CONTAINER: {
				QueryObjectContainer queryObjectContainer = (QueryObjectContainer)theEObject;
				T result = caseQueryObjectContainer(queryObjectContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SearchResultPackage.SORT_FIELD: {
				SortField sortField = (SortField)theEObject;
				T result = caseSortField(sortField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SearchResultPackage.SPATIAL_FILTER_FIELD: {
				SpatialFilterField spatialFilterField = (SpatialFilterField)theEObject;
				T result = caseSpatialFilterField(spatialFilterField);
				if (result == null) result = caseSpatialField(spatialFilterField);
				if (result == null) result = caseLuceneQueryField(spatialFilterField);
				if (result == null) result = caseBoostableField(spatialFilterField);
				if (result == null) result = caseQueryCondition(spatialFilterField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SearchResultPackage.WILDCARD_FIELD: {
				WildcardField wildcardField = (WildcardField)theEObject;
				T result = caseWildcardField(wildcardField);
				if (result == null) result = caseMultiTokenTermQuery(wildcardField);
				if (result == null) result = caseLuceneQueryField(wildcardField);
				if (result == null) result = caseBoostableField(wildcardField);
				if (result == null) result = caseQueryCondition(wildcardField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SearchResultPackage.RESULT_DESCRIPTOR: {
				ResultDescriptor resultDescriptor = (ResultDescriptor)theEObject;
				T result = caseResultDescriptor(resultDescriptor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SearchResultPackage.RESULT_FIELD: {
				ResultField resultField = (ResultField)theEObject;
				T result = caseResultField(resultField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SearchResultPackage.RESULT_DESCRIPTOR_CONTAINER: {
				ResultDescriptorContainer resultDescriptorContainer = (ResultDescriptorContainer)theEObject;
				T result = caseResultDescriptorContainer(resultDescriptorContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SearchResultPackage.LIKE_THIS_OBJECT: {
				LikeThisObject likeThisObject = (LikeThisObject)theEObject;
				T result = caseLikeThisObject(likeThisObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SearchResultPackage.FACET_FILTER: {
				FacetFilter facetFilter = (FacetFilter)theEObject;
				T result = caseFacetFilter(facetFilter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SearchResultPackage.FACET_QUERY_CONTEXT: {
				FacetQueryContext facetQueryContext = (FacetQueryContext)theEObject;
				T result = caseFacetQueryContext(facetQueryContext);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SearchResultPackage.FACET_RESULT: {
				FacetResult facetResult = (FacetResult)theEObject;
				T result = caseFacetResult(facetResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SearchResultPackage.JOIN_QUERY: {
				JoinQuery joinQuery = (JoinQuery)theEObject;
				T result = caseJoinQuery(joinQuery);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SearchResultPackage.SPATIAL_SORT_FIELD: {
				SpatialSortField spatialSortField = (SpatialSortField)theEObject;
				T result = caseSpatialSortField(spatialSortField);
				if (result == null) result = caseSortField(spatialSortField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SearchResultPackage.GROUPING_CONTEXT: {
				GroupingContext groupingContext = (GroupingContext)theEObject;
				T result = caseGroupingContext(groupingContext);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SearchResultPackage.SPATIAL_FIELD: {
				SpatialField spatialField = (SpatialField)theEObject;
				T result = caseSpatialField(spatialField);
				if (result == null) result = caseLuceneQueryField(spatialField);
				if (result == null) result = caseBoostableField(spatialField);
				if (result == null) result = caseQueryCondition(spatialField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SearchResultPackage.SPAN_TERM_FIELD: {
				SpanTermField spanTermField = (SpanTermField)theEObject;
				T result = caseSpanTermField(spanTermField);
				if (result == null) result = caseLuceneQueryField(spanTermField);
				if (result == null) result = caseBoostableField(spanTermField);
				if (result == null) result = caseQueryCondition(spanTermField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SearchResultPackage.BOOLEAN_QUERY: {
				BooleanQuery booleanQuery = (BooleanQuery)theEObject;
				T result = caseBooleanQuery(booleanQuery);
				if (result == null) result = caseBoostableField(booleanQuery);
				if (result == null) result = caseQueryCondition(booleanQuery);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SearchResultPackage.LUCENE_QUERY_FIELD: {
				LuceneQueryField luceneQueryField = (LuceneQueryField)theEObject;
				T result = caseLuceneQueryField(luceneQueryField);
				if (result == null) result = caseBoostableField(luceneQueryField);
				if (result == null) result = caseQueryCondition(luceneQueryField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SearchResultPackage.BOOSTABLE_FIELD: {
				BoostableField boostableField = (BoostableField)theEObject;
				T result = caseBoostableField(boostableField);
				if (result == null) result = caseQueryCondition(boostableField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SearchResultPackage.BOOLEAN_CLAUSE: {
				BooleanClause booleanClause = (BooleanClause)theEObject;
				T result = caseBooleanClause(booleanClause);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SearchResultPackage.NUMERIC_RANGE_QUERY: {
				NumericRangeQuery numericRangeQuery = (NumericRangeQuery)theEObject;
				T result = caseNumericRangeQuery(numericRangeQuery);
				if (result == null) result = caseLuceneQueryField(numericRangeQuery);
				if (result == null) result = caseBoostableField(numericRangeQuery);
				if (result == null) result = caseQueryCondition(numericRangeQuery);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SearchResultPackage.DOUBLE_RANGE_QUERY: {
				DoubleRangeQuery doubleRangeQuery = (DoubleRangeQuery)theEObject;
				T result = caseDoubleRangeQuery(doubleRangeQuery);
				if (result == null) result = caseNumericRangeQuery(doubleRangeQuery);
				if (result == null) result = caseLuceneQueryField(doubleRangeQuery);
				if (result == null) result = caseBoostableField(doubleRangeQuery);
				if (result == null) result = caseQueryCondition(doubleRangeQuery);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SearchResultPackage.SINGLE_TOKEN_TERM_QUERY: {
				SingleTokenTermQuery singleTokenTermQuery = (SingleTokenTermQuery)theEObject;
				T result = caseSingleTokenTermQuery(singleTokenTermQuery);
				if (result == null) result = caseLuceneQueryField(singleTokenTermQuery);
				if (result == null) result = caseBoostableField(singleTokenTermQuery);
				if (result == null) result = caseQueryCondition(singleTokenTermQuery);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SearchResultPackage.SINGLE_TOKEN_FUZZY_FIELD: {
				SingleTokenFuzzyField singleTokenFuzzyField = (SingleTokenFuzzyField)theEObject;
				T result = caseSingleTokenFuzzyField(singleTokenFuzzyField);
				if (result == null) result = caseSingleTokenTermQuery(singleTokenFuzzyField);
				if (result == null) result = caseLuceneQueryField(singleTokenFuzzyField);
				if (result == null) result = caseBoostableField(singleTokenFuzzyField);
				if (result == null) result = caseQueryCondition(singleTokenFuzzyField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SearchResultPackage.SPAN_QUERY_FIELD: {
				SpanQueryField spanQueryField = (SpanQueryField)theEObject;
				T result = caseSpanQueryField(spanQueryField);
				if (result == null) result = caseLuceneQueryField(spanQueryField);
				if (result == null) result = caseBoostableField(spanQueryField);
				if (result == null) result = caseQueryCondition(spanQueryField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SearchResultPackage.PHRASE_QUERY: {
				PhraseQuery phraseQuery = (PhraseQuery)theEObject;
				T result = casePhraseQuery(phraseQuery);
				if (result == null) result = caseLuceneQueryField(phraseQuery);
				if (result == null) result = caseBoostableField(phraseQuery);
				if (result == null) result = caseQueryCondition(phraseQuery);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SearchResultPackage.MULTI_PHRASE_QUERY: {
				MultiPhraseQuery multiPhraseQuery = (MultiPhraseQuery)theEObject;
				T result = caseMultiPhraseQuery(multiPhraseQuery);
				if (result == null) result = casePhraseQuery(multiPhraseQuery);
				if (result == null) result = caseLuceneQueryField(multiPhraseQuery);
				if (result == null) result = caseBoostableField(multiPhraseQuery);
				if (result == null) result = caseQueryCondition(multiPhraseQuery);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Search Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Search Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSearchResult(SearchResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Category</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Category</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCategory(Category object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Match Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Match Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMatchResult(MatchResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Match Highlight</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Match Highlight</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMatchHighlight(MatchHighlight object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Match Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Match Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMatchField(MatchField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Query Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Query Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQueryObject(QueryObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multi Token Fuzzy Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multi Token Fuzzy Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultiTokenFuzzyField(MultiTokenFuzzyField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Filter Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Filter Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFilterField(FilterField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multi Token Term Query</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multi Token Term Query</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultiTokenTermQuery(MultiTokenTermQuery object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Query Object Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Query Object Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQueryObjectContainer(QueryObjectContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sort Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sort Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSortField(SortField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Spatial Filter Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Spatial Filter Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpatialFilterField(SpatialFilterField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Wildcard Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Wildcard Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWildcardField(WildcardField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Result Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Result Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResultDescriptor(ResultDescriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Result Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Result Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResultField(ResultField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Result Descriptor Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Result Descriptor Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResultDescriptorContainer(ResultDescriptorContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Like This Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Like This Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLikeThisObject(LikeThisObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Facet Filter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Facet Filter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFacetFilter(FacetFilter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Facet Query Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Facet Query Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFacetQueryContext(FacetQueryContext object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Facet Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Facet Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFacetResult(FacetResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Join Query</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Join Query</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJoinQuery(JoinQuery object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Spatial Sort Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Spatial Sort Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpatialSortField(SpatialSortField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Grouping Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Grouping Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGroupingContext(GroupingContext object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Spatial Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Spatial Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpatialField(SpatialField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Span Term Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Span Term Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpanTermField(SpanTermField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Query</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Query</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanQuery(BooleanQuery object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Lucene Query Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Lucene Query Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLuceneQueryField(LuceneQueryField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boostable Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boostable Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBoostableField(BoostableField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Clause</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Clause</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanClause(BooleanClause object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Numeric Range Query</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Numeric Range Query</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNumericRangeQuery(NumericRangeQuery object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Double Range Query</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Double Range Query</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDoubleRangeQuery(DoubleRangeQuery object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Single Token Term Query</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Single Token Term Query</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSingleTokenTermQuery(SingleTokenTermQuery object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Single Token Fuzzy Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Single Token Fuzzy Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSingleTokenFuzzyField(SingleTokenFuzzyField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Span Query Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Span Query Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpanQueryField(SpanQueryField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Phrase Query</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Phrase Query</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePhraseQuery(PhraseQuery object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multi Phrase Query</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multi Phrase Query</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultiPhraseQuery(MultiPhraseQuery object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Query</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Query</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQuery(Query object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQueryCondition(QueryCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //SearchResultSwitch
