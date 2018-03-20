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
package org.gecko.searchresult;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.gecko.searchresult.SearchResultPackage
 * @generated
 */
public interface SearchResultFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SearchResultFactory eINSTANCE = org.gecko.searchresult.impl.SearchResultFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Search Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Search Result</em>'.
	 * @generated
	 */
	SearchResult createSearchResult();

	/**
	 * Returns a new object of class '<em>Category</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Category</em>'.
	 * @generated
	 */
	Category createCategory();

	/**
	 * Returns a new object of class '<em>Match Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Match Result</em>'.
	 * @generated
	 */
	MatchResult createMatchResult();

	/**
	 * Returns a new object of class '<em>Match Highlight</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Match Highlight</em>'.
	 * @generated
	 */
	MatchHighlight createMatchHighlight();

	/**
	 * Returns a new object of class '<em>Match Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Match Field</em>'.
	 * @generated
	 */
	MatchField createMatchField();

	/**
	 * Returns a new object of class '<em>Query Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Query Object</em>'.
	 * @generated
	 */
	QueryObject createQueryObject();

	/**
	 * Returns a new object of class '<em>Multi Token Fuzzy Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Multi Token Fuzzy Field</em>'.
	 * @generated
	 */
	MultiTokenFuzzyField createMultiTokenFuzzyField();

	/**
	 * Returns a new object of class '<em>Filter Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Filter Field</em>'.
	 * @generated
	 */
	FilterField createFilterField();

	/**
	 * Returns a new object of class '<em>Multi Token Term Query</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Multi Token Term Query</em>'.
	 * @generated
	 */
	MultiTokenTermQuery createMultiTokenTermQuery();

	/**
	 * Returns a new object of class '<em>Query Object Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Query Object Container</em>'.
	 * @generated
	 */
	QueryObjectContainer createQueryObjectContainer();

	/**
	 * Returns a new object of class '<em>Sort Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sort Field</em>'.
	 * @generated
	 */
	SortField createSortField();

	/**
	 * Returns a new object of class '<em>Spatial Filter Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Spatial Filter Field</em>'.
	 * @generated
	 */
	SpatialFilterField createSpatialFilterField();

	/**
	 * Returns a new object of class '<em>Wildcard Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Wildcard Field</em>'.
	 * @generated
	 */
	WildcardField createWildcardField();

	/**
	 * Returns a new object of class '<em>Result Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Result Descriptor</em>'.
	 * @generated
	 */
	ResultDescriptor createResultDescriptor();

	/**
	 * Returns a new object of class '<em>Result Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Result Field</em>'.
	 * @generated
	 */
	ResultField createResultField();

	/**
	 * Returns a new object of class '<em>Result Descriptor Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Result Descriptor Container</em>'.
	 * @generated
	 */
	ResultDescriptorContainer createResultDescriptorContainer();

	/**
	 * Returns a new object of class '<em>Like This Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Like This Object</em>'.
	 * @generated
	 */
	LikeThisObject createLikeThisObject();

	/**
	 * Returns a new object of class '<em>Facet Filter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Facet Filter</em>'.
	 * @generated
	 */
	FacetFilter createFacetFilter();

	/**
	 * Returns a new object of class '<em>Facet Query Context</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Facet Query Context</em>'.
	 * @generated
	 */
	FacetQueryContext createFacetQueryContext();

	/**
	 * Returns a new object of class '<em>Facet Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Facet Result</em>'.
	 * @generated
	 */
	FacetResult createFacetResult();

	/**
	 * Returns a new object of class '<em>Join Query</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Join Query</em>'.
	 * @generated
	 */
	JoinQuery createJoinQuery();

	/**
	 * Returns a new object of class '<em>Spatial Sort Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Spatial Sort Field</em>'.
	 * @generated
	 */
	SpatialSortField createSpatialSortField();

	/**
	 * Returns a new object of class '<em>Grouping Context</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Grouping Context</em>'.
	 * @generated
	 */
	GroupingContext createGroupingContext();

	/**
	 * Returns a new object of class '<em>Spatial Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Spatial Field</em>'.
	 * @generated
	 */
	SpatialField createSpatialField();

	/**
	 * Returns a new object of class '<em>Span Term Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Span Term Field</em>'.
	 * @generated
	 */
	SpanTermField createSpanTermField();

	/**
	 * Returns a new object of class '<em>Boolean Query</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Query</em>'.
	 * @generated
	 */
	BooleanQuery createBooleanQuery();

	/**
	 * Returns a new object of class '<em>Lucene Query Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lucene Query Field</em>'.
	 * @generated
	 */
	LuceneQueryField createLuceneQueryField();

	/**
	 * Returns a new object of class '<em>Boostable Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boostable Field</em>'.
	 * @generated
	 */
	BoostableField createBoostableField();

	/**
	 * Returns a new object of class '<em>Boolean Clause</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Clause</em>'.
	 * @generated
	 */
	BooleanClause createBooleanClause();

	/**
	 * Returns a new object of class '<em>Double Range Query</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Double Range Query</em>'.
	 * @generated
	 */
	DoubleRangeQuery createDoubleRangeQuery();

	/**
	 * Returns a new object of class '<em>Single Token Term Query</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Single Token Term Query</em>'.
	 * @generated
	 */
	SingleTokenTermQuery createSingleTokenTermQuery();

	/**
	 * Returns a new object of class '<em>Single Token Fuzzy Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Single Token Fuzzy Field</em>'.
	 * @generated
	 */
	SingleTokenFuzzyField createSingleTokenFuzzyField();

	/**
	 * Returns a new object of class '<em>Span Query Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Span Query Field</em>'.
	 * @generated
	 */
	SpanQueryField createSpanQueryField();

	/**
	 * Returns a new object of class '<em>Phrase Query</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Phrase Query</em>'.
	 * @generated
	 */
	PhraseQuery createPhraseQuery();

	/**
	 * Returns a new object of class '<em>Multi Phrase Query</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Multi Phrase Query</em>'.
	 * @generated
	 */
	MultiPhraseQuery createMultiPhraseQuery();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SearchResultPackage getSearchResultPackage();

} //SearchResultFactory
