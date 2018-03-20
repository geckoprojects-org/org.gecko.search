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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.gecko.searchresult.*;

import org.gecko.utilities.query.Query;
import org.gecko.utilities.query.QueryCondition;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.gecko.searchresult.SearchResultPackage
 * @generated
 */
public class SearchResultAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SearchResultPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SearchResultAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = SearchResultPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SearchResultSwitch<Adapter> modelSwitch =
		new SearchResultSwitch<Adapter>() {
			@Override
			public Adapter caseSearchResult(SearchResult object) {
				return createSearchResultAdapter();
			}
			@Override
			public Adapter caseCategory(Category object) {
				return createCategoryAdapter();
			}
			@Override
			public Adapter caseMatchResult(MatchResult object) {
				return createMatchResultAdapter();
			}
			@Override
			public Adapter caseMatchHighlight(MatchHighlight object) {
				return createMatchHighlightAdapter();
			}
			@Override
			public Adapter caseMatchField(MatchField object) {
				return createMatchFieldAdapter();
			}
			@Override
			public Adapter caseQueryObject(QueryObject object) {
				return createQueryObjectAdapter();
			}
			@Override
			public Adapter caseMultiTokenFuzzyField(MultiTokenFuzzyField object) {
				return createMultiTokenFuzzyFieldAdapter();
			}
			@Override
			public Adapter caseFilterField(FilterField object) {
				return createFilterFieldAdapter();
			}
			@Override
			public Adapter caseMultiTokenTermQuery(MultiTokenTermQuery object) {
				return createMultiTokenTermQueryAdapter();
			}
			@Override
			public Adapter caseQueryObjectContainer(QueryObjectContainer object) {
				return createQueryObjectContainerAdapter();
			}
			@Override
			public Adapter caseSortField(SortField object) {
				return createSortFieldAdapter();
			}
			@Override
			public Adapter caseSpatialFilterField(SpatialFilterField object) {
				return createSpatialFilterFieldAdapter();
			}
			@Override
			public Adapter caseWildcardField(WildcardField object) {
				return createWildcardFieldAdapter();
			}
			@Override
			public Adapter caseResultDescriptor(ResultDescriptor object) {
				return createResultDescriptorAdapter();
			}
			@Override
			public Adapter caseResultField(ResultField object) {
				return createResultFieldAdapter();
			}
			@Override
			public Adapter caseResultDescriptorContainer(ResultDescriptorContainer object) {
				return createResultDescriptorContainerAdapter();
			}
			@Override
			public Adapter caseLikeThisObject(LikeThisObject object) {
				return createLikeThisObjectAdapter();
			}
			@Override
			public Adapter caseFacetFilter(FacetFilter object) {
				return createFacetFilterAdapter();
			}
			@Override
			public Adapter caseFacetQueryContext(FacetQueryContext object) {
				return createFacetQueryContextAdapter();
			}
			@Override
			public Adapter caseFacetResult(FacetResult object) {
				return createFacetResultAdapter();
			}
			@Override
			public Adapter caseJoinQuery(JoinQuery object) {
				return createJoinQueryAdapter();
			}
			@Override
			public Adapter caseSpatialSortField(SpatialSortField object) {
				return createSpatialSortFieldAdapter();
			}
			@Override
			public Adapter caseGroupingContext(GroupingContext object) {
				return createGroupingContextAdapter();
			}
			@Override
			public Adapter caseSpatialField(SpatialField object) {
				return createSpatialFieldAdapter();
			}
			@Override
			public Adapter caseSpanTermField(SpanTermField object) {
				return createSpanTermFieldAdapter();
			}
			@Override
			public Adapter caseBooleanQuery(BooleanQuery object) {
				return createBooleanQueryAdapter();
			}
			@Override
			public Adapter caseLuceneQueryField(LuceneQueryField object) {
				return createLuceneQueryFieldAdapter();
			}
			@Override
			public Adapter caseBoostableField(BoostableField object) {
				return createBoostableFieldAdapter();
			}
			@Override
			public Adapter caseBooleanClause(BooleanClause object) {
				return createBooleanClauseAdapter();
			}
			@Override
			public Adapter caseNumericRangeQuery(NumericRangeQuery object) {
				return createNumericRangeQueryAdapter();
			}
			@Override
			public Adapter caseDoubleRangeQuery(DoubleRangeQuery object) {
				return createDoubleRangeQueryAdapter();
			}
			@Override
			public Adapter caseSingleTokenTermQuery(SingleTokenTermQuery object) {
				return createSingleTokenTermQueryAdapter();
			}
			@Override
			public Adapter caseSingleTokenFuzzyField(SingleTokenFuzzyField object) {
				return createSingleTokenFuzzyFieldAdapter();
			}
			@Override
			public Adapter caseSpanQueryField(SpanQueryField object) {
				return createSpanQueryFieldAdapter();
			}
			@Override
			public Adapter casePhraseQuery(PhraseQuery object) {
				return createPhraseQueryAdapter();
			}
			@Override
			public Adapter caseMultiPhraseQuery(MultiPhraseQuery object) {
				return createMultiPhraseQueryAdapter();
			}
			@Override
			public Adapter caseQuery(Query object) {
				return createQueryAdapter();
			}
			@Override
			public Adapter caseQueryCondition(QueryCondition object) {
				return createQueryConditionAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.searchresult.SearchResult <em>Search Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.searchresult.SearchResult
	 * @generated
	 */
	public Adapter createSearchResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.searchresult.Category <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.searchresult.Category
	 * @generated
	 */
	public Adapter createCategoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.searchresult.MatchResult <em>Match Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.searchresult.MatchResult
	 * @generated
	 */
	public Adapter createMatchResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.searchresult.MatchHighlight <em>Match Highlight</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.searchresult.MatchHighlight
	 * @generated
	 */
	public Adapter createMatchHighlightAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.searchresult.MatchField <em>Match Field</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.searchresult.MatchField
	 * @generated
	 */
	public Adapter createMatchFieldAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.searchresult.QueryObject <em>Query Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.searchresult.QueryObject
	 * @generated
	 */
	public Adapter createQueryObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.searchresult.MultiTokenFuzzyField <em>Multi Token Fuzzy Field</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.searchresult.MultiTokenFuzzyField
	 * @generated
	 */
	public Adapter createMultiTokenFuzzyFieldAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.searchresult.FilterField <em>Filter Field</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.searchresult.FilterField
	 * @generated
	 */
	public Adapter createFilterFieldAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.searchresult.MultiTokenTermQuery <em>Multi Token Term Query</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.searchresult.MultiTokenTermQuery
	 * @generated
	 */
	public Adapter createMultiTokenTermQueryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.searchresult.QueryObjectContainer <em>Query Object Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.searchresult.QueryObjectContainer
	 * @generated
	 */
	public Adapter createQueryObjectContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.searchresult.SortField <em>Sort Field</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.searchresult.SortField
	 * @generated
	 */
	public Adapter createSortFieldAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.searchresult.SpatialFilterField <em>Spatial Filter Field</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.searchresult.SpatialFilterField
	 * @generated
	 */
	public Adapter createSpatialFilterFieldAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.searchresult.WildcardField <em>Wildcard Field</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.searchresult.WildcardField
	 * @generated
	 */
	public Adapter createWildcardFieldAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.searchresult.ResultDescriptor <em>Result Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.searchresult.ResultDescriptor
	 * @generated
	 */
	public Adapter createResultDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.searchresult.ResultField <em>Result Field</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.searchresult.ResultField
	 * @generated
	 */
	public Adapter createResultFieldAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.searchresult.ResultDescriptorContainer <em>Result Descriptor Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.searchresult.ResultDescriptorContainer
	 * @generated
	 */
	public Adapter createResultDescriptorContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.searchresult.LikeThisObject <em>Like This Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.searchresult.LikeThisObject
	 * @generated
	 */
	public Adapter createLikeThisObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.searchresult.FacetFilter <em>Facet Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.searchresult.FacetFilter
	 * @generated
	 */
	public Adapter createFacetFilterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.searchresult.FacetQueryContext <em>Facet Query Context</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.searchresult.FacetQueryContext
	 * @generated
	 */
	public Adapter createFacetQueryContextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.searchresult.FacetResult <em>Facet Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.searchresult.FacetResult
	 * @generated
	 */
	public Adapter createFacetResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.searchresult.JoinQuery <em>Join Query</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.searchresult.JoinQuery
	 * @generated
	 */
	public Adapter createJoinQueryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.searchresult.SpatialSortField <em>Spatial Sort Field</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.searchresult.SpatialSortField
	 * @generated
	 */
	public Adapter createSpatialSortFieldAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.searchresult.GroupingContext <em>Grouping Context</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.searchresult.GroupingContext
	 * @generated
	 */
	public Adapter createGroupingContextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.searchresult.SpatialField <em>Spatial Field</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.searchresult.SpatialField
	 * @generated
	 */
	public Adapter createSpatialFieldAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.searchresult.SpanTermField <em>Span Term Field</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.searchresult.SpanTermField
	 * @generated
	 */
	public Adapter createSpanTermFieldAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.searchresult.BooleanQuery <em>Boolean Query</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.searchresult.BooleanQuery
	 * @generated
	 */
	public Adapter createBooleanQueryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.searchresult.LuceneQueryField <em>Lucene Query Field</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.searchresult.LuceneQueryField
	 * @generated
	 */
	public Adapter createLuceneQueryFieldAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.searchresult.BoostableField <em>Boostable Field</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.searchresult.BoostableField
	 * @generated
	 */
	public Adapter createBoostableFieldAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.searchresult.BooleanClause <em>Boolean Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.searchresult.BooleanClause
	 * @generated
	 */
	public Adapter createBooleanClauseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.searchresult.NumericRangeQuery <em>Numeric Range Query</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.searchresult.NumericRangeQuery
	 * @generated
	 */
	public Adapter createNumericRangeQueryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.searchresult.DoubleRangeQuery <em>Double Range Query</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.searchresult.DoubleRangeQuery
	 * @generated
	 */
	public Adapter createDoubleRangeQueryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.searchresult.SingleTokenTermQuery <em>Single Token Term Query</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.searchresult.SingleTokenTermQuery
	 * @generated
	 */
	public Adapter createSingleTokenTermQueryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.searchresult.SingleTokenFuzzyField <em>Single Token Fuzzy Field</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.searchresult.SingleTokenFuzzyField
	 * @generated
	 */
	public Adapter createSingleTokenFuzzyFieldAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.searchresult.SpanQueryField <em>Span Query Field</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.searchresult.SpanQueryField
	 * @generated
	 */
	public Adapter createSpanQueryFieldAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.searchresult.PhraseQuery <em>Phrase Query</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.searchresult.PhraseQuery
	 * @generated
	 */
	public Adapter createPhraseQueryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.searchresult.MultiPhraseQuery <em>Multi Phrase Query</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.searchresult.MultiPhraseQuery
	 * @generated
	 */
	public Adapter createMultiPhraseQueryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.utilities.query.Query <em>Query</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.utilities.query.Query
	 * @generated
	 */
	public Adapter createQueryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.utilities.query.QueryCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.utilities.query.QueryCondition
	 * @generated
	 */
	public Adapter createQueryConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //SearchResultAdapterFactory
