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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.gecko.utilities.query.QueryPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.gecko.searchresult.SearchResultFactory
 * @model kind="package"
 * @generated
 */
public interface SearchResultPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "searchresult";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://data-in-motion.biz/search/result/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "searchresult";

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eCONTENT_TYPE = "searchresult#1.0";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SearchResultPackage eINSTANCE = org.gecko.searchresult.impl.SearchResultPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.gecko.searchresult.impl.SearchResultImpl <em>Search Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchresult.impl.SearchResultImpl
	 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getSearchResult()
	 * @generated
	 */
	int SEARCH_RESULT = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_RESULT__ID = 0;

	/**
	 * The feature id for the '<em><b>Categories</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_RESULT__CATEGORIES = 1;

	/**
	 * The feature id for the '<em><b>Category Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_RESULT__CATEGORY_SIZE = 2;

	/**
	 * The feature id for the '<em><b>All Match Result Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_RESULT__ALL_MATCH_RESULT_SIZE = 3;

	/**
	 * The feature id for the '<em><b>Native Result</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_RESULT__NATIVE_RESULT = 4;

	/**
	 * The feature id for the '<em><b>Facet Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_RESULT__FACET_RESULTS = 5;

	/**
	 * The feature id for the '<em><b>Native Collector Results</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_RESULT__NATIVE_COLLECTOR_RESULTS = 6;

	/**
	 * The feature id for the '<em><b>Native Join Collector Results</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_RESULT__NATIVE_JOIN_COLLECTOR_RESULTS = 7;

	/**
	 * The feature id for the '<em><b>Number Pages</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_RESULT__NUMBER_PAGES = 8;

	/**
	 * The feature id for the '<em><b>Page Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_RESULT__PAGE_SIZE = 9;

	/**
	 * The number of structural features of the '<em>Search Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_RESULT_FEATURE_COUNT = 10;

	/**
	 * The number of operations of the '<em>Search Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_RESULT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.gecko.searchresult.impl.CategoryImpl <em>Category</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchresult.impl.CategoryImpl
	 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getCategory()
	 * @generated
	 */
	int CATEGORY = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__ID = 0;

	/**
	 * The feature id for the '<em><b>Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__RESULTS = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__NAME = 2;

	/**
	 * The feature id for the '<em><b>Match Result Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__MATCH_RESULT_SIZE = 3;

	/**
	 * The number of structural features of the '<em>Category</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Category</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.gecko.searchresult.impl.MatchResultImpl <em>Match Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchresult.impl.MatchResultImpl
	 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getMatchResult()
	 * @generated
	 */
	int MATCH_RESULT = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_RESULT__ID = 0;

	/**
	 * The feature id for the '<em><b>Highlights</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_RESULT__HIGHLIGHTS = 1;

	/**
	 * The feature id for the '<em><b>Fields</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_RESULT__FIELDS = 2;

	/**
	 * The feature id for the '<em><b>Score</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_RESULT__SCORE = 3;

	/**
	 * The feature id for the '<em><b>Explanation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_RESULT__EXPLANATION = 4;

	/**
	 * The number of structural features of the '<em>Match Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_RESULT_FEATURE_COUNT = 5;

	/**
	 * The operation id for the '<em>Get Match Field By Id</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_RESULT___GET_MATCH_FIELD_BY_ID__STRING = 0;

	/**
	 * The number of operations of the '<em>Match Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_RESULT_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.gecko.searchresult.impl.MatchHighlightImpl <em>Match Highlight</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchresult.impl.MatchHighlightImpl
	 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getMatchHighlight()
	 * @generated
	 */
	int MATCH_HIGHLIGHT = 3;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_HIGHLIGHT__START_OFFSET = 0;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_HIGHLIGHT__END_OFFSET = 1;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_HIGHLIGHT__TEXT = 2;

	/**
	 * The feature id for the '<em><b>Highlighted Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_HIGHLIGHT__HIGHLIGHTED_TEXT = 3;

	/**
	 * The number of structural features of the '<em>Match Highlight</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_HIGHLIGHT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Match Highlight</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_HIGHLIGHT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.gecko.searchresult.impl.MatchFieldImpl <em>Match Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchresult.impl.MatchFieldImpl
	 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getMatchField()
	 * @generated
	 */
	int MATCH_FIELD = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_FIELD__ID = 0;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_FIELD__FEATURE = 1;

	/**
	 * The feature id for the '<em><b>Converter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_FIELD__CONVERTER = 2;

	/**
	 * The feature id for the '<em><b>Multi Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_FIELD__MULTI_VALUE = 3;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_FIELD__VALUE = 4;

	/**
	 * The feature id for the '<em><b>Highlighting</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_FIELD__HIGHLIGHTING = 5;

	/**
	 * The number of structural features of the '<em>Match Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_FIELD_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Match Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_FIELD_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.gecko.searchresult.impl.QueryObjectImpl <em>Query Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchresult.impl.QueryObjectImpl
	 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getQueryObject()
	 * @generated
	 */
	int QUERY_OBJECT = 5;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_OBJECT__CONDITION = QueryPackage.QUERY__CONDITION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_OBJECT__ID = QueryPackage.QUERY__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_OBJECT__NAME = QueryPackage.QUERY__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_OBJECT__DESCRIPTION = QueryPackage.QUERY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_OBJECT__ACTIVE = QueryPackage.QUERY__ACTIVE;

	/**
	 * The feature id for the '<em><b>Native Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_OBJECT__NATIVE_QUERY = QueryPackage.QUERY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Index Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_OBJECT__INDEX_PATH = QueryPackage.QUERY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Max Results</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_OBJECT__MAX_RESULTS = QueryPackage.QUERY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Filter Fields</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_OBJECT__FILTER_FIELDS = QueryPackage.QUERY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Sort Fields</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_OBJECT__SORT_FIELDS = QueryPackage.QUERY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Native Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_OBJECT__NATIVE_OBJECT = QueryPackage.QUERY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Spatial Filter Field</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_OBJECT__SPATIAL_FILTER_FIELD = QueryPackage.QUERY_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Highlight Fields</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_OBJECT__HIGHLIGHT_FIELDS = QueryPackage.QUERY_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Like This Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_OBJECT__LIKE_THIS_OBJECT = QueryPackage.QUERY_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Analyzer Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_OBJECT__ANALYZER_ID = QueryPackage.QUERY_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Facet Query Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_OBJECT__FACET_QUERY_CONTEXT = QueryPackage.QUERY_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Native Collectors</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_OBJECT__NATIVE_COLLECTORS = QueryPackage.QUERY_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Run Collector Exclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_OBJECT__RUN_COLLECTOR_EXCLUSIVE = QueryPackage.QUERY_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Join Query</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_OBJECT__JOIN_QUERY = QueryPackage.QUERY_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Grouping Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_OBJECT__GROUPING_CONTEXT = QueryPackage.QUERY_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Native Query Occur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_OBJECT__NATIVE_QUERY_OCCUR = QueryPackage.QUERY_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Explain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_OBJECT__EXPLAIN = QueryPackage.QUERY_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Page Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_OBJECT__PAGE_INDEX = QueryPackage.QUERY_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Page Result Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_OBJECT__PAGE_RESULT_SIZE = QueryPackage.QUERY_FEATURE_COUNT + 18;

	/**
	 * The number of structural features of the '<em>Query Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_OBJECT_FEATURE_COUNT = QueryPackage.QUERY_FEATURE_COUNT + 19;

	/**
	 * The number of operations of the '<em>Query Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_OBJECT_OPERATION_COUNT = QueryPackage.QUERY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gecko.searchresult.impl.BoostableFieldImpl <em>Boostable Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchresult.impl.BoostableFieldImpl
	 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getBoostableField()
	 * @generated
	 */
	int BOOSTABLE_FIELD = 27;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOSTABLE_FIELD__ID = QueryPackage.QUERY_CONDITION__ID;

	/**
	 * The feature id for the '<em><b>Boost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOSTABLE_FIELD__BOOST = QueryPackage.QUERY_CONDITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boostable Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOSTABLE_FIELD_FEATURE_COUNT = QueryPackage.QUERY_CONDITION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Boostable Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOSTABLE_FIELD_OPERATION_COUNT = QueryPackage.QUERY_CONDITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gecko.searchresult.impl.LuceneQueryFieldImpl <em>Lucene Query Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchresult.impl.LuceneQueryFieldImpl
	 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getLuceneQueryField()
	 * @generated
	 */
	int LUCENE_QUERY_FIELD = 26;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LUCENE_QUERY_FIELD__ID = BOOSTABLE_FIELD__ID;

	/**
	 * The feature id for the '<em><b>Boost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LUCENE_QUERY_FIELD__BOOST = BOOSTABLE_FIELD__BOOST;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LUCENE_QUERY_FIELD__KEY = BOOSTABLE_FIELD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Analyzed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LUCENE_QUERY_FIELD__ANALYZED = BOOSTABLE_FIELD_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Lucene Query Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LUCENE_QUERY_FIELD_FEATURE_COUNT = BOOSTABLE_FIELD_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Lucene Query Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LUCENE_QUERY_FIELD_OPERATION_COUNT = BOOSTABLE_FIELD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gecko.searchresult.impl.MultiTokenTermQueryImpl <em>Multi Token Term Query</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchresult.impl.MultiTokenTermQueryImpl
	 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getMultiTokenTermQuery()
	 * @generated
	 */
	int MULTI_TOKEN_TERM_QUERY = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_TOKEN_TERM_QUERY__ID = LUCENE_QUERY_FIELD__ID;

	/**
	 * The feature id for the '<em><b>Boost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_TOKEN_TERM_QUERY__BOOST = LUCENE_QUERY_FIELD__BOOST;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_TOKEN_TERM_QUERY__KEY = LUCENE_QUERY_FIELD__KEY;

	/**
	 * The feature id for the '<em><b>Analyzed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_TOKEN_TERM_QUERY__ANALYZED = LUCENE_QUERY_FIELD__ANALYZED;

	/**
	 * The feature id for the '<em><b>Tokens</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_TOKEN_TERM_QUERY__TOKENS = LUCENE_QUERY_FIELD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_TOKEN_TERM_QUERY__PREFIX = LUCENE_QUERY_FIELD_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Tokens Occur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_TOKEN_TERM_QUERY__TOKENS_OCCUR = LUCENE_QUERY_FIELD_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Multi Token Term Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_TOKEN_TERM_QUERY_FEATURE_COUNT = LUCENE_QUERY_FIELD_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Multi Token Term Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_TOKEN_TERM_QUERY_OPERATION_COUNT = LUCENE_QUERY_FIELD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gecko.searchresult.impl.MultiTokenFuzzyFieldImpl <em>Multi Token Fuzzy Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchresult.impl.MultiTokenFuzzyFieldImpl
	 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getMultiTokenFuzzyField()
	 * @generated
	 */
	int MULTI_TOKEN_FUZZY_FIELD = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_TOKEN_FUZZY_FIELD__ID = MULTI_TOKEN_TERM_QUERY__ID;

	/**
	 * The feature id for the '<em><b>Boost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_TOKEN_FUZZY_FIELD__BOOST = MULTI_TOKEN_TERM_QUERY__BOOST;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_TOKEN_FUZZY_FIELD__KEY = MULTI_TOKEN_TERM_QUERY__KEY;

	/**
	 * The feature id for the '<em><b>Analyzed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_TOKEN_FUZZY_FIELD__ANALYZED = MULTI_TOKEN_TERM_QUERY__ANALYZED;

	/**
	 * The feature id for the '<em><b>Tokens</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_TOKEN_FUZZY_FIELD__TOKENS = MULTI_TOKEN_TERM_QUERY__TOKENS;

	/**
	 * The feature id for the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_TOKEN_FUZZY_FIELD__PREFIX = MULTI_TOKEN_TERM_QUERY__PREFIX;

	/**
	 * The feature id for the '<em><b>Tokens Occur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_TOKEN_FUZZY_FIELD__TOKENS_OCCUR = MULTI_TOKEN_TERM_QUERY__TOKENS_OCCUR;

	/**
	 * The feature id for the '<em><b>Uppercase</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_TOKEN_FUZZY_FIELD__UPPERCASE = MULTI_TOKEN_TERM_QUERY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Max Edits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_TOKEN_FUZZY_FIELD__MAX_EDITS = MULTI_TOKEN_TERM_QUERY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Multi Token Fuzzy Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_TOKEN_FUZZY_FIELD_FEATURE_COUNT = MULTI_TOKEN_TERM_QUERY_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Multi Token Fuzzy Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_TOKEN_FUZZY_FIELD_OPERATION_COUNT = MULTI_TOKEN_TERM_QUERY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gecko.searchresult.impl.FilterFieldImpl <em>Filter Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchresult.impl.FilterFieldImpl
	 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getFilterField()
	 * @generated
	 */
	int FILTER_FIELD = 7;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_FIELD__KEY = 0;

	/**
	 * The feature id for the '<em><b>Tokens</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_FIELD__TOKENS = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_FIELD__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_FIELD__PREFIX = 3;

	/**
	 * The feature id for the '<em><b>Occur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_FIELD__OCCUR = 4;

	/**
	 * The feature id for the '<em><b>Tokens Occur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_FIELD__TOKENS_OCCUR = 5;

	/**
	 * The number of structural features of the '<em>Filter Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_FIELD_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Filter Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_FIELD_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.gecko.searchresult.impl.QueryObjectContainerImpl <em>Query Object Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchresult.impl.QueryObjectContainerImpl
	 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getQueryObjectContainer()
	 * @generated
	 */
	int QUERY_OBJECT_CONTAINER = 9;

	/**
	 * The feature id for the '<em><b>Queries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_OBJECT_CONTAINER__QUERIES = 0;

	/**
	 * The feature id for the '<em><b>Active Queries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_OBJECT_CONTAINER__ACTIVE_QUERIES = 1;

	/**
	 * The number of structural features of the '<em>Query Object Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_OBJECT_CONTAINER_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Query Object Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_OBJECT_CONTAINER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.gecko.searchresult.impl.SortFieldImpl <em>Sort Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchresult.impl.SortFieldImpl
	 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getSortField()
	 * @generated
	 */
	int SORT_FIELD = 10;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORT_FIELD__KEY = 0;

	/**
	 * The feature id for the '<em><b>Tokens</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORT_FIELD__TOKENS = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORT_FIELD__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORT_FIELD__DIRECTION = 3;

	/**
	 * The feature id for the '<em><b>Occur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORT_FIELD__OCCUR = 4;

	/**
	 * The number of structural features of the '<em>Sort Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORT_FIELD_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Sort Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORT_FIELD_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.gecko.searchresult.impl.SpatialFieldImpl <em>Spatial Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchresult.impl.SpatialFieldImpl
	 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getSpatialField()
	 * @generated
	 */
	int SPATIAL_FIELD = 23;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_FIELD__ID = LUCENE_QUERY_FIELD__ID;

	/**
	 * The feature id for the '<em><b>Boost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_FIELD__BOOST = LUCENE_QUERY_FIELD__BOOST;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_FIELD__KEY = LUCENE_QUERY_FIELD__KEY;

	/**
	 * The feature id for the '<em><b>Analyzed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_FIELD__ANALYZED = LUCENE_QUERY_FIELD__ANALYZED;

	/**
	 * The feature id for the '<em><b>Lat Lng</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_FIELD__LAT_LNG = LUCENE_QUERY_FIELD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Distance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_FIELD__DISTANCE = LUCENE_QUERY_FIELD_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Spatial Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_FIELD_FEATURE_COUNT = LUCENE_QUERY_FIELD_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Spatial Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_FIELD_OPERATION_COUNT = LUCENE_QUERY_FIELD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gecko.searchresult.impl.SpatialFilterFieldImpl <em>Spatial Filter Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchresult.impl.SpatialFilterFieldImpl
	 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getSpatialFilterField()
	 * @generated
	 */
	int SPATIAL_FILTER_FIELD = 11;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_FILTER_FIELD__ID = SPATIAL_FIELD__ID;

	/**
	 * The feature id for the '<em><b>Boost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_FILTER_FIELD__BOOST = SPATIAL_FIELD__BOOST;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_FILTER_FIELD__KEY = SPATIAL_FIELD__KEY;

	/**
	 * The feature id for the '<em><b>Analyzed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_FILTER_FIELD__ANALYZED = SPATIAL_FIELD__ANALYZED;

	/**
	 * The feature id for the '<em><b>Lat Lng</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_FILTER_FIELD__LAT_LNG = SPATIAL_FIELD__LAT_LNG;

	/**
	 * The feature id for the '<em><b>Distance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_FILTER_FIELD__DISTANCE = SPATIAL_FIELD__DISTANCE;

	/**
	 * The number of structural features of the '<em>Spatial Filter Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_FILTER_FIELD_FEATURE_COUNT = SPATIAL_FIELD_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Spatial Filter Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_FILTER_FIELD_OPERATION_COUNT = SPATIAL_FIELD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gecko.searchresult.impl.WildcardFieldImpl <em>Wildcard Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchresult.impl.WildcardFieldImpl
	 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getWildcardField()
	 * @generated
	 */
	int WILDCARD_FIELD = 12;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD_FIELD__ID = MULTI_TOKEN_TERM_QUERY__ID;

	/**
	 * The feature id for the '<em><b>Boost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD_FIELD__BOOST = MULTI_TOKEN_TERM_QUERY__BOOST;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD_FIELD__KEY = MULTI_TOKEN_TERM_QUERY__KEY;

	/**
	 * The feature id for the '<em><b>Analyzed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD_FIELD__ANALYZED = MULTI_TOKEN_TERM_QUERY__ANALYZED;

	/**
	 * The feature id for the '<em><b>Tokens</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD_FIELD__TOKENS = MULTI_TOKEN_TERM_QUERY__TOKENS;

	/**
	 * The feature id for the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD_FIELD__PREFIX = MULTI_TOKEN_TERM_QUERY__PREFIX;

	/**
	 * The feature id for the '<em><b>Tokens Occur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD_FIELD__TOKENS_OCCUR = MULTI_TOKEN_TERM_QUERY__TOKENS_OCCUR;

	/**
	 * The feature id for the '<em><b>Start With Wildcard</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD_FIELD__START_WITH_WILDCARD = MULTI_TOKEN_TERM_QUERY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End With Wildcard</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD_FIELD__END_WITH_WILDCARD = MULTI_TOKEN_TERM_QUERY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Include Upper Case</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD_FIELD__INCLUDE_UPPER_CASE = MULTI_TOKEN_TERM_QUERY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Wildcard Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD_FIELD_FEATURE_COUNT = MULTI_TOKEN_TERM_QUERY_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Wildcard Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WILDCARD_FIELD_OPERATION_COUNT = MULTI_TOKEN_TERM_QUERY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gecko.searchresult.impl.ResultDescriptorImpl <em>Result Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchresult.impl.ResultDescriptorImpl
	 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getResultDescriptor()
	 * @generated
	 */
	int RESULT_DESCRIPTOR = 13;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_DESCRIPTOR__ID = 0;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_DESCRIPTOR__ACTIVE = 1;

	/**
	 * The feature id for the '<em><b>Index Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_DESCRIPTOR__INDEX_ID = 2;

	/**
	 * The feature id for the '<em><b>Fields</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_DESCRIPTOR__FIELDS = 3;

	/**
	 * The number of structural features of the '<em>Result Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_DESCRIPTOR_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Result Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_DESCRIPTOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.gecko.searchresult.impl.ResultFieldImpl <em>Result Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchresult.impl.ResultFieldImpl
	 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getResultField()
	 * @generated
	 */
	int RESULT_FIELD = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_FIELD__NAME = 0;

	/**
	 * The feature id for the '<em><b>Highlight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_FIELD__HIGHLIGHT = 1;

	/**
	 * The number of structural features of the '<em>Result Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_FIELD_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Result Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_FIELD_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.gecko.searchresult.impl.ResultDescriptorContainerImpl <em>Result Descriptor Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchresult.impl.ResultDescriptorContainerImpl
	 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getResultDescriptorContainer()
	 * @generated
	 */
	int RESULT_DESCRIPTOR_CONTAINER = 15;

	/**
	 * The feature id for the '<em><b>Descriptors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_DESCRIPTOR_CONTAINER__DESCRIPTORS = 0;

	/**
	 * The feature id for the '<em><b>Active Descriptors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_DESCRIPTOR_CONTAINER__ACTIVE_DESCRIPTORS = 1;

	/**
	 * The number of structural features of the '<em>Result Descriptor Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_DESCRIPTOR_CONTAINER_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Result Descriptor Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_DESCRIPTOR_CONTAINER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.gecko.searchresult.impl.LikeThisObjectImpl <em>Like This Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchresult.impl.LikeThisObjectImpl
	 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getLikeThisObject()
	 * @generated
	 */
	int LIKE_THIS_OBJECT = 16;

	/**
	 * The feature id for the '<em><b>Like This Fields</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIKE_THIS_OBJECT__LIKE_THIS_FIELDS = 0;

	/**
	 * The feature id for the '<em><b>Filter Fields</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIKE_THIS_OBJECT__FILTER_FIELDS = 1;

	/**
	 * The feature id for the '<em><b>Sort Fields</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIKE_THIS_OBJECT__SORT_FIELDS = 2;

	/**
	 * The feature id for the '<em><b>Filter Source Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIKE_THIS_OBJECT__FILTER_SOURCE_OBJECT = 3;

	/**
	 * The feature id for the '<em><b>Filter Source Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIKE_THIS_OBJECT__FILTER_SOURCE_FIELD = 4;

	/**
	 * The feature id for the '<em><b>Max Results</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIKE_THIS_OBJECT__MAX_RESULTS = 5;

	/**
	 * The number of structural features of the '<em>Like This Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIKE_THIS_OBJECT_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Like This Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIKE_THIS_OBJECT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.gecko.searchresult.impl.FacetFilterImpl <em>Facet Filter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchresult.impl.FacetFilterImpl
	 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getFacetFilter()
	 * @generated
	 */
	int FACET_FILTER = 17;

	/**
	 * The feature id for the '<em><b>Facet Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_FILTER__FACET_KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_FILTER__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Facet Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_FILTER_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Facet Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_FILTER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.gecko.searchresult.impl.FacetQueryContextImpl <em>Facet Query Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchresult.impl.FacetQueryContextImpl
	 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getFacetQueryContext()
	 * @generated
	 */
	int FACET_QUERY_CONTEXT = 18;

	/**
	 * The feature id for the '<em><b>Facet Fields</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_QUERY_CONTEXT__FACET_FIELDS = 0;

	/**
	 * The feature id for the '<em><b>Count Facets</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_QUERY_CONTEXT__COUNT_FACETS = 1;

	/**
	 * The feature id for the '<em><b>Fill In Categories</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_QUERY_CONTEXT__FILL_IN_CATEGORIES = 2;

	/**
	 * The feature id for the '<em><b>Allow Duplicates In Categories</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_QUERY_CONTEXT__ALLOW_DUPLICATES_IN_CATEGORIES = 3;

	/**
	 * The feature id for the '<em><b>Max Facets</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_QUERY_CONTEXT__MAX_FACETS = 4;

	/**
	 * The feature id for the '<em><b>Dimensions</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_QUERY_CONTEXT__DIMENSIONS = 5;

	/**
	 * The feature id for the '<em><b>Max Result Per Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_QUERY_CONTEXT__MAX_RESULT_PER_CATEGORY = 6;

	/**
	 * The number of structural features of the '<em>Facet Query Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_QUERY_CONTEXT_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Facet Query Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_QUERY_CONTEXT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.gecko.searchresult.impl.FacetResultImpl <em>Facet Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchresult.impl.FacetResultImpl
	 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getFacetResult()
	 * @generated
	 */
	int FACET_RESULT = 19;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_RESULT__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_RESULT__VALUE = 1;

	/**
	 * The feature id for the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_RESULT__COUNT = 2;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_RESULT__CHILDREN = 3;

	/**
	 * The number of structural features of the '<em>Facet Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_RESULT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Facet Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_RESULT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.gecko.searchresult.impl.JoinQueryImpl <em>Join Query</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchresult.impl.JoinQueryImpl
	 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getJoinQuery()
	 * @generated
	 */
	int JOIN_QUERY = 20;

	/**
	 * The feature id for the '<em><b>Index Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_QUERY__INDEX_PATH = 0;

	/**
	 * The feature id for the '<em><b>From Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_QUERY__FROM_FIELD = 1;

	/**
	 * The feature id for the '<em><b>To Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_QUERY__TO_FIELD = 2;

	/**
	 * The feature id for the '<em><b>Score Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_QUERY__SCORE_MODE = 3;

	/**
	 * The feature id for the '<em><b>Query Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_QUERY__QUERY_OBJECT = 4;

	/**
	 * The feature id for the '<em><b>Join Aftermath Collectors</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_QUERY__JOIN_AFTERMATH_COLLECTORS = 5;

	/**
	 * The feature id for the '<em><b>Occur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_QUERY__OCCUR = 6;

	/**
	 * The number of structural features of the '<em>Join Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_QUERY_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Join Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_QUERY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.gecko.searchresult.impl.SpatialSortFieldImpl <em>Spatial Sort Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchresult.impl.SpatialSortFieldImpl
	 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getSpatialSortField()
	 * @generated
	 */
	int SPATIAL_SORT_FIELD = 21;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_SORT_FIELD__KEY = SORT_FIELD__KEY;

	/**
	 * The feature id for the '<em><b>Tokens</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_SORT_FIELD__TOKENS = SORT_FIELD__TOKENS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_SORT_FIELD__TYPE = SORT_FIELD__TYPE;

	/**
	 * The feature id for the '<em><b>Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_SORT_FIELD__DIRECTION = SORT_FIELD__DIRECTION;

	/**
	 * The feature id for the '<em><b>Occur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_SORT_FIELD__OCCUR = SORT_FIELD__OCCUR;

	/**
	 * The feature id for the '<em><b>Lat Lng</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_SORT_FIELD__LAT_LNG = SORT_FIELD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Spatial Sort Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_SORT_FIELD_FEATURE_COUNT = SORT_FIELD_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Spatial Sort Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_SORT_FIELD_OPERATION_COUNT = SORT_FIELD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gecko.searchresult.impl.GroupingContextImpl <em>Grouping Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchresult.impl.GroupingContextImpl
	 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getGroupingContext()
	 * @generated
	 */
	int GROUPING_CONTEXT = 22;

	/**
	 * The feature id for the '<em><b>Max Groups</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUPING_CONTEXT__MAX_GROUPS = 0;

	/**
	 * The feature id for the '<em><b>Off Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUPING_CONTEXT__OFF_SET = 1;

	/**
	 * The feature id for the '<em><b>Group Field Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUPING_CONTEXT__GROUP_FIELD_NAME = 2;

	/**
	 * The feature id for the '<em><b>Results Per Group</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUPING_CONTEXT__RESULTS_PER_GROUP = 3;

	/**
	 * The feature id for the '<em><b>Cach Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUPING_CONTEXT__CACH_SIZE = 4;

	/**
	 * The feature id for the '<em><b>Group Sort</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUPING_CONTEXT__GROUP_SORT = 5;

	/**
	 * The number of structural features of the '<em>Grouping Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUPING_CONTEXT_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Grouping Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUPING_CONTEXT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.gecko.searchresult.impl.SpanTermFieldImpl <em>Span Term Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchresult.impl.SpanTermFieldImpl
	 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getSpanTermField()
	 * @generated
	 */
	int SPAN_TERM_FIELD = 24;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPAN_TERM_FIELD__ID = LUCENE_QUERY_FIELD__ID;

	/**
	 * The feature id for the '<em><b>Boost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPAN_TERM_FIELD__BOOST = LUCENE_QUERY_FIELD__BOOST;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPAN_TERM_FIELD__KEY = LUCENE_QUERY_FIELD__KEY;

	/**
	 * The feature id for the '<em><b>Analyzed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPAN_TERM_FIELD__ANALYZED = LUCENE_QUERY_FIELD__ANALYZED;

	/**
	 * The feature id for the '<em><b>Tokens</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPAN_TERM_FIELD__TOKENS = LUCENE_QUERY_FIELD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Span</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPAN_TERM_FIELD__SPAN = LUCENE_QUERY_FIELD_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Span Term Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPAN_TERM_FIELD_FEATURE_COUNT = LUCENE_QUERY_FIELD_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Span Term Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPAN_TERM_FIELD_OPERATION_COUNT = LUCENE_QUERY_FIELD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gecko.searchresult.impl.BooleanQueryImpl <em>Boolean Query</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchresult.impl.BooleanQueryImpl
	 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getBooleanQuery()
	 * @generated
	 */
	int BOOLEAN_QUERY = 25;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_QUERY__ID = BOOSTABLE_FIELD__ID;

	/**
	 * The feature id for the '<em><b>Boost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_QUERY__BOOST = BOOSTABLE_FIELD__BOOST;

	/**
	 * The feature id for the '<em><b>Clauses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_QUERY__CLAUSES = BOOSTABLE_FIELD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_QUERY_FEATURE_COUNT = BOOSTABLE_FIELD_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Boolean Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_QUERY_OPERATION_COUNT = BOOSTABLE_FIELD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gecko.searchresult.impl.BooleanClauseImpl <em>Boolean Clause</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchresult.impl.BooleanClauseImpl
	 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getBooleanClause()
	 * @generated
	 */
	int BOOLEAN_CLAUSE = 28;

	/**
	 * The feature id for the '<em><b>Occur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_CLAUSE__OCCUR = 0;

	/**
	 * The feature id for the '<em><b>Query</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_CLAUSE__QUERY = 1;

	/**
	 * The number of structural features of the '<em>Boolean Clause</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_CLAUSE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Boolean Clause</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_CLAUSE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.gecko.searchresult.impl.NumericRangeQueryImpl <em>Numeric Range Query</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchresult.impl.NumericRangeQueryImpl
	 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getNumericRangeQuery()
	 * @generated
	 */
	int NUMERIC_RANGE_QUERY = 29;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_RANGE_QUERY__ID = LUCENE_QUERY_FIELD__ID;

	/**
	 * The feature id for the '<em><b>Boost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_RANGE_QUERY__BOOST = LUCENE_QUERY_FIELD__BOOST;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_RANGE_QUERY__KEY = LUCENE_QUERY_FIELD__KEY;

	/**
	 * The feature id for the '<em><b>Analyzed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_RANGE_QUERY__ANALYZED = LUCENE_QUERY_FIELD__ANALYZED;

	/**
	 * The feature id for the '<em><b>Precision Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_RANGE_QUERY__PRECISION_STEP = LUCENE_QUERY_FIELD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Min Inclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_RANGE_QUERY__MIN_INCLUSIVE = LUCENE_QUERY_FIELD_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Max Inclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_RANGE_QUERY__MAX_INCLUSIVE = LUCENE_QUERY_FIELD_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Numeric Range Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_RANGE_QUERY_FEATURE_COUNT = LUCENE_QUERY_FIELD_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Numeric Range Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_RANGE_QUERY_OPERATION_COUNT = LUCENE_QUERY_FIELD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gecko.searchresult.impl.DoubleRangeQueryImpl <em>Double Range Query</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchresult.impl.DoubleRangeQueryImpl
	 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getDoubleRangeQuery()
	 * @generated
	 */
	int DOUBLE_RANGE_QUERY = 30;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_RANGE_QUERY__ID = NUMERIC_RANGE_QUERY__ID;

	/**
	 * The feature id for the '<em><b>Boost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_RANGE_QUERY__BOOST = NUMERIC_RANGE_QUERY__BOOST;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_RANGE_QUERY__KEY = NUMERIC_RANGE_QUERY__KEY;

	/**
	 * The feature id for the '<em><b>Analyzed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_RANGE_QUERY__ANALYZED = NUMERIC_RANGE_QUERY__ANALYZED;

	/**
	 * The feature id for the '<em><b>Precision Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_RANGE_QUERY__PRECISION_STEP = NUMERIC_RANGE_QUERY__PRECISION_STEP;

	/**
	 * The feature id for the '<em><b>Min Inclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_RANGE_QUERY__MIN_INCLUSIVE = NUMERIC_RANGE_QUERY__MIN_INCLUSIVE;

	/**
	 * The feature id for the '<em><b>Max Inclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_RANGE_QUERY__MAX_INCLUSIVE = NUMERIC_RANGE_QUERY__MAX_INCLUSIVE;

	/**
	 * The feature id for the '<em><b>Min Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_RANGE_QUERY__MIN_VALUE = NUMERIC_RANGE_QUERY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Max Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_RANGE_QUERY__MAX_VALUE = NUMERIC_RANGE_QUERY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Double Range Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_RANGE_QUERY_FEATURE_COUNT = NUMERIC_RANGE_QUERY_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Double Range Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_RANGE_QUERY_OPERATION_COUNT = NUMERIC_RANGE_QUERY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gecko.searchresult.impl.SingleTokenTermQueryImpl <em>Single Token Term Query</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchresult.impl.SingleTokenTermQueryImpl
	 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getSingleTokenTermQuery()
	 * @generated
	 */
	int SINGLE_TOKEN_TERM_QUERY = 31;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_TOKEN_TERM_QUERY__ID = LUCENE_QUERY_FIELD__ID;

	/**
	 * The feature id for the '<em><b>Boost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_TOKEN_TERM_QUERY__BOOST = LUCENE_QUERY_FIELD__BOOST;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_TOKEN_TERM_QUERY__KEY = LUCENE_QUERY_FIELD__KEY;

	/**
	 * The feature id for the '<em><b>Analyzed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_TOKEN_TERM_QUERY__ANALYZED = LUCENE_QUERY_FIELD__ANALYZED;

	/**
	 * The feature id for the '<em><b>Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_TOKEN_TERM_QUERY__TOKEN = LUCENE_QUERY_FIELD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_TOKEN_TERM_QUERY__PREFIX = LUCENE_QUERY_FIELD_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Single Token Term Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_TOKEN_TERM_QUERY_FEATURE_COUNT = LUCENE_QUERY_FIELD_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Single Token Term Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_TOKEN_TERM_QUERY_OPERATION_COUNT = LUCENE_QUERY_FIELD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gecko.searchresult.impl.SingleTokenFuzzyFieldImpl <em>Single Token Fuzzy Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchresult.impl.SingleTokenFuzzyFieldImpl
	 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getSingleTokenFuzzyField()
	 * @generated
	 */
	int SINGLE_TOKEN_FUZZY_FIELD = 32;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_TOKEN_FUZZY_FIELD__ID = SINGLE_TOKEN_TERM_QUERY__ID;

	/**
	 * The feature id for the '<em><b>Boost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_TOKEN_FUZZY_FIELD__BOOST = SINGLE_TOKEN_TERM_QUERY__BOOST;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_TOKEN_FUZZY_FIELD__KEY = SINGLE_TOKEN_TERM_QUERY__KEY;

	/**
	 * The feature id for the '<em><b>Analyzed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_TOKEN_FUZZY_FIELD__ANALYZED = SINGLE_TOKEN_TERM_QUERY__ANALYZED;

	/**
	 * The feature id for the '<em><b>Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_TOKEN_FUZZY_FIELD__TOKEN = SINGLE_TOKEN_TERM_QUERY__TOKEN;

	/**
	 * The feature id for the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_TOKEN_FUZZY_FIELD__PREFIX = SINGLE_TOKEN_TERM_QUERY__PREFIX;

	/**
	 * The feature id for the '<em><b>Uppercase</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_TOKEN_FUZZY_FIELD__UPPERCASE = SINGLE_TOKEN_TERM_QUERY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Max Edits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_TOKEN_FUZZY_FIELD__MAX_EDITS = SINGLE_TOKEN_TERM_QUERY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Single Token Fuzzy Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_TOKEN_FUZZY_FIELD_FEATURE_COUNT = SINGLE_TOKEN_TERM_QUERY_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Single Token Fuzzy Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_TOKEN_FUZZY_FIELD_OPERATION_COUNT = SINGLE_TOKEN_TERM_QUERY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gecko.searchresult.impl.SpanQueryFieldImpl <em>Span Query Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchresult.impl.SpanQueryFieldImpl
	 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getSpanQueryField()
	 * @generated
	 */
	int SPAN_QUERY_FIELD = 33;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPAN_QUERY_FIELD__ID = LUCENE_QUERY_FIELD__ID;

	/**
	 * The feature id for the '<em><b>Boost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPAN_QUERY_FIELD__BOOST = LUCENE_QUERY_FIELD__BOOST;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPAN_QUERY_FIELD__KEY = LUCENE_QUERY_FIELD__KEY;

	/**
	 * The feature id for the '<em><b>Analyzed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPAN_QUERY_FIELD__ANALYZED = LUCENE_QUERY_FIELD__ANALYZED;

	/**
	 * The feature id for the '<em><b>Span</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPAN_QUERY_FIELD__SPAN = LUCENE_QUERY_FIELD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Query Fields</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPAN_QUERY_FIELD__QUERY_FIELDS = LUCENE_QUERY_FIELD_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Span Query Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPAN_QUERY_FIELD_FEATURE_COUNT = LUCENE_QUERY_FIELD_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Span Query Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPAN_QUERY_FIELD_OPERATION_COUNT = LUCENE_QUERY_FIELD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gecko.searchresult.impl.PhraseQueryImpl <em>Phrase Query</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchresult.impl.PhraseQueryImpl
	 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getPhraseQuery()
	 * @generated
	 */
	int PHRASE_QUERY = 34;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHRASE_QUERY__ID = LUCENE_QUERY_FIELD__ID;

	/**
	 * The feature id for the '<em><b>Boost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHRASE_QUERY__BOOST = LUCENE_QUERY_FIELD__BOOST;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHRASE_QUERY__KEY = LUCENE_QUERY_FIELD__KEY;

	/**
	 * The feature id for the '<em><b>Analyzed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHRASE_QUERY__ANALYZED = LUCENE_QUERY_FIELD__ANALYZED;

	/**
	 * The feature id for the '<em><b>Slop</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHRASE_QUERY__SLOP = LUCENE_QUERY_FIELD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Terms</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHRASE_QUERY__TERMS = LUCENE_QUERY_FIELD_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Phrase Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHRASE_QUERY_FEATURE_COUNT = LUCENE_QUERY_FIELD_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Phrase Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHRASE_QUERY_OPERATION_COUNT = LUCENE_QUERY_FIELD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gecko.searchresult.impl.MultiPhraseQueryImpl <em>Multi Phrase Query</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchresult.impl.MultiPhraseQueryImpl
	 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getMultiPhraseQuery()
	 * @generated
	 */
	int MULTI_PHRASE_QUERY = 35;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_PHRASE_QUERY__ID = PHRASE_QUERY__ID;

	/**
	 * The feature id for the '<em><b>Boost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_PHRASE_QUERY__BOOST = PHRASE_QUERY__BOOST;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_PHRASE_QUERY__KEY = PHRASE_QUERY__KEY;

	/**
	 * The feature id for the '<em><b>Analyzed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_PHRASE_QUERY__ANALYZED = PHRASE_QUERY__ANALYZED;

	/**
	 * The feature id for the '<em><b>Slop</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_PHRASE_QUERY__SLOP = PHRASE_QUERY__SLOP;

	/**
	 * The feature id for the '<em><b>Terms</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_PHRASE_QUERY__TERMS = PHRASE_QUERY__TERMS;

	/**
	 * The number of structural features of the '<em>Multi Phrase Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_PHRASE_QUERY_FEATURE_COUNT = PHRASE_QUERY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Multi Phrase Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_PHRASE_QUERY_OPERATION_COUNT = PHRASE_QUERY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gecko.searchresult.FilteringType <em>Filtering Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchresult.FilteringType
	 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getFilteringType()
	 * @generated
	 */
	int FILTERING_TYPE = 36;

	/**
	 * The meta object id for the '{@link org.gecko.searchresult.SortType <em>Sort Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchresult.SortType
	 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getSortType()
	 * @generated
	 */
	int SORT_TYPE = 37;

	/**
	 * The meta object id for the '{@link org.gecko.searchresult.SortDirectionType <em>Sort Direction Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchresult.SortDirectionType
	 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getSortDirectionType()
	 * @generated
	 */
	int SORT_DIRECTION_TYPE = 38;

	/**
	 * The meta object id for the '{@link org.gecko.searchresult.Occur <em>Occur</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchresult.Occur
	 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getOccur()
	 * @generated
	 */
	int OCCUR = 39;

	/**
	 * The meta object id for the '{@link org.gecko.searchresult.JoinScoreMode <em>Join Score Mode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchresult.JoinScoreMode
	 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getJoinScoreMode()
	 * @generated
	 */
	int JOIN_SCORE_MODE = 40;


	/**
	 * Returns the meta object for class '{@link org.gecko.searchresult.SearchResult <em>Search Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Search Result</em>'.
	 * @see org.gecko.searchresult.SearchResult
	 * @generated
	 */
	EClass getSearchResult();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.SearchResult#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.gecko.searchresult.SearchResult#getId()
	 * @see #getSearchResult()
	 * @generated
	 */
	EAttribute getSearchResult_Id();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gecko.searchresult.SearchResult#getCategories <em>Categories</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Categories</em>'.
	 * @see org.gecko.searchresult.SearchResult#getCategories()
	 * @see #getSearchResult()
	 * @generated
	 */
	EReference getSearchResult_Categories();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.SearchResult#getCategorySize <em>Category Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Category Size</em>'.
	 * @see org.gecko.searchresult.SearchResult#getCategorySize()
	 * @see #getSearchResult()
	 * @generated
	 */
	EAttribute getSearchResult_CategorySize();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.SearchResult#getAllMatchResultSize <em>All Match Result Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>All Match Result Size</em>'.
	 * @see org.gecko.searchresult.SearchResult#getAllMatchResultSize()
	 * @see #getSearchResult()
	 * @generated
	 */
	EAttribute getSearchResult_AllMatchResultSize();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.SearchResult#getNativeResult <em>Native Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Native Result</em>'.
	 * @see org.gecko.searchresult.SearchResult#getNativeResult()
	 * @see #getSearchResult()
	 * @generated
	 */
	EAttribute getSearchResult_NativeResult();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gecko.searchresult.SearchResult#getFacetResults <em>Facet Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Facet Results</em>'.
	 * @see org.gecko.searchresult.SearchResult#getFacetResults()
	 * @see #getSearchResult()
	 * @generated
	 */
	EReference getSearchResult_FacetResults();

	/**
	 * Returns the meta object for the attribute list '{@link org.gecko.searchresult.SearchResult#getNativeCollectorResults <em>Native Collector Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Native Collector Results</em>'.
	 * @see org.gecko.searchresult.SearchResult#getNativeCollectorResults()
	 * @see #getSearchResult()
	 * @generated
	 */
	EAttribute getSearchResult_NativeCollectorResults();

	/**
	 * Returns the meta object for the attribute list '{@link org.gecko.searchresult.SearchResult#getNativeJoinCollectorResults <em>Native Join Collector Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Native Join Collector Results</em>'.
	 * @see org.gecko.searchresult.SearchResult#getNativeJoinCollectorResults()
	 * @see #getSearchResult()
	 * @generated
	 */
	EAttribute getSearchResult_NativeJoinCollectorResults();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.SearchResult#getNumberPages <em>Number Pages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Pages</em>'.
	 * @see org.gecko.searchresult.SearchResult#getNumberPages()
	 * @see #getSearchResult()
	 * @generated
	 */
	EAttribute getSearchResult_NumberPages();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.SearchResult#getPageSize <em>Page Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Page Size</em>'.
	 * @see org.gecko.searchresult.SearchResult#getPageSize()
	 * @see #getSearchResult()
	 * @generated
	 */
	EAttribute getSearchResult_PageSize();

	/**
	 * Returns the meta object for class '{@link org.gecko.searchresult.Category <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Category</em>'.
	 * @see org.gecko.searchresult.Category
	 * @generated
	 */
	EClass getCategory();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.Category#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.gecko.searchresult.Category#getId()
	 * @see #getCategory()
	 * @generated
	 */
	EAttribute getCategory_Id();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gecko.searchresult.Category#getResults <em>Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Results</em>'.
	 * @see org.gecko.searchresult.Category#getResults()
	 * @see #getCategory()
	 * @generated
	 */
	EReference getCategory_Results();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.Category#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.gecko.searchresult.Category#getName()
	 * @see #getCategory()
	 * @generated
	 */
	EAttribute getCategory_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.Category#getMatchResultSize <em>Match Result Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Match Result Size</em>'.
	 * @see org.gecko.searchresult.Category#getMatchResultSize()
	 * @see #getCategory()
	 * @generated
	 */
	EAttribute getCategory_MatchResultSize();

	/**
	 * Returns the meta object for class '{@link org.gecko.searchresult.MatchResult <em>Match Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Match Result</em>'.
	 * @see org.gecko.searchresult.MatchResult
	 * @generated
	 */
	EClass getMatchResult();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.MatchResult#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.gecko.searchresult.MatchResult#getId()
	 * @see #getMatchResult()
	 * @generated
	 */
	EAttribute getMatchResult_Id();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gecko.searchresult.MatchResult#getHighlights <em>Highlights</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Highlights</em>'.
	 * @see org.gecko.searchresult.MatchResult#getHighlights()
	 * @see #getMatchResult()
	 * @generated
	 */
	EReference getMatchResult_Highlights();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gecko.searchresult.MatchResult#getFields <em>Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fields</em>'.
	 * @see org.gecko.searchresult.MatchResult#getFields()
	 * @see #getMatchResult()
	 * @generated
	 */
	EReference getMatchResult_Fields();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.MatchResult#getScore <em>Score</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Score</em>'.
	 * @see org.gecko.searchresult.MatchResult#getScore()
	 * @see #getMatchResult()
	 * @generated
	 */
	EAttribute getMatchResult_Score();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.MatchResult#getExplanation <em>Explanation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Explanation</em>'.
	 * @see org.gecko.searchresult.MatchResult#getExplanation()
	 * @see #getMatchResult()
	 * @generated
	 */
	EAttribute getMatchResult_Explanation();

	/**
	 * Returns the meta object for the '{@link org.gecko.searchresult.MatchResult#getMatchFieldById(java.lang.String) <em>Get Match Field By Id</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Match Field By Id</em>' operation.
	 * @see org.gecko.searchresult.MatchResult#getMatchFieldById(java.lang.String)
	 * @generated
	 */
	EOperation getMatchResult__GetMatchFieldById__String();

	/**
	 * Returns the meta object for class '{@link org.gecko.searchresult.MatchHighlight <em>Match Highlight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Match Highlight</em>'.
	 * @see org.gecko.searchresult.MatchHighlight
	 * @generated
	 */
	EClass getMatchHighlight();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.MatchHighlight#getStartOffset <em>Start Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Offset</em>'.
	 * @see org.gecko.searchresult.MatchHighlight#getStartOffset()
	 * @see #getMatchHighlight()
	 * @generated
	 */
	EAttribute getMatchHighlight_StartOffset();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.MatchHighlight#getEndOffset <em>End Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Offset</em>'.
	 * @see org.gecko.searchresult.MatchHighlight#getEndOffset()
	 * @see #getMatchHighlight()
	 * @generated
	 */
	EAttribute getMatchHighlight_EndOffset();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.MatchHighlight#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.gecko.searchresult.MatchHighlight#getText()
	 * @see #getMatchHighlight()
	 * @generated
	 */
	EAttribute getMatchHighlight_Text();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.MatchHighlight#getHighlightedText <em>Highlighted Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Highlighted Text</em>'.
	 * @see org.gecko.searchresult.MatchHighlight#getHighlightedText()
	 * @see #getMatchHighlight()
	 * @generated
	 */
	EAttribute getMatchHighlight_HighlightedText();

	/**
	 * Returns the meta object for class '{@link org.gecko.searchresult.MatchField <em>Match Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Match Field</em>'.
	 * @see org.gecko.searchresult.MatchField
	 * @generated
	 */
	EClass getMatchField();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.MatchField#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.gecko.searchresult.MatchField#getId()
	 * @see #getMatchField()
	 * @generated
	 */
	EAttribute getMatchField_Id();

	/**
	 * Returns the meta object for the containment reference '{@link org.gecko.searchresult.MatchField#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Feature</em>'.
	 * @see org.gecko.searchresult.MatchField#getFeature()
	 * @see #getMatchField()
	 * @generated
	 */
	EReference getMatchField_Feature();

	/**
	 * Returns the meta object for the containment reference '{@link org.gecko.searchresult.MatchField#getConverter <em>Converter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Converter</em>'.
	 * @see org.gecko.searchresult.MatchField#getConverter()
	 * @see #getMatchField()
	 * @generated
	 */
	EReference getMatchField_Converter();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.MatchField#isMultiValue <em>Multi Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Multi Value</em>'.
	 * @see org.gecko.searchresult.MatchField#isMultiValue()
	 * @see #getMatchField()
	 * @generated
	 */
	EAttribute getMatchField_MultiValue();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.MatchField#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.gecko.searchresult.MatchField#getValue()
	 * @see #getMatchField()
	 * @generated
	 */
	EAttribute getMatchField_Value();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gecko.searchresult.MatchField#getHighlighting <em>Highlighting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Highlighting</em>'.
	 * @see org.gecko.searchresult.MatchField#getHighlighting()
	 * @see #getMatchField()
	 * @generated
	 */
	EReference getMatchField_Highlighting();

	/**
	 * Returns the meta object for class '{@link org.gecko.searchresult.QueryObject <em>Query Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Query Object</em>'.
	 * @see org.gecko.searchresult.QueryObject
	 * @generated
	 */
	EClass getQueryObject();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.QueryObject#getNativeQuery <em>Native Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Native Query</em>'.
	 * @see org.gecko.searchresult.QueryObject#getNativeQuery()
	 * @see #getQueryObject()
	 * @generated
	 */
	EAttribute getQueryObject_NativeQuery();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.QueryObject#getIndexPath <em>Index Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index Path</em>'.
	 * @see org.gecko.searchresult.QueryObject#getIndexPath()
	 * @see #getQueryObject()
	 * @generated
	 */
	EAttribute getQueryObject_IndexPath();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.QueryObject#getMaxResults <em>Max Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Results</em>'.
	 * @see org.gecko.searchresult.QueryObject#getMaxResults()
	 * @see #getQueryObject()
	 * @generated
	 */
	EAttribute getQueryObject_MaxResults();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gecko.searchresult.QueryObject#getFilterFields <em>Filter Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Filter Fields</em>'.
	 * @see org.gecko.searchresult.QueryObject#getFilterFields()
	 * @see #getQueryObject()
	 * @generated
	 */
	EReference getQueryObject_FilterFields();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gecko.searchresult.QueryObject#getSortFields <em>Sort Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sort Fields</em>'.
	 * @see org.gecko.searchresult.QueryObject#getSortFields()
	 * @see #getQueryObject()
	 * @generated
	 */
	EReference getQueryObject_SortFields();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.QueryObject#getNativeObject <em>Native Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Native Object</em>'.
	 * @see org.gecko.searchresult.QueryObject#getNativeObject()
	 * @see #getQueryObject()
	 * @generated
	 */
	EAttribute getQueryObject_NativeObject();

	/**
	 * Returns the meta object for the reference '{@link org.gecko.searchresult.QueryObject#getSpatialFilterField <em>Spatial Filter Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Spatial Filter Field</em>'.
	 * @see org.gecko.searchresult.QueryObject#getSpatialFilterField()
	 * @see #getQueryObject()
	 * @generated
	 */
	EReference getQueryObject_SpatialFilterField();

	/**
	 * Returns the meta object for the attribute list '{@link org.gecko.searchresult.QueryObject#getHighlightFields <em>Highlight Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Highlight Fields</em>'.
	 * @see org.gecko.searchresult.QueryObject#getHighlightFields()
	 * @see #getQueryObject()
	 * @generated
	 */
	EAttribute getQueryObject_HighlightFields();

	/**
	 * Returns the meta object for the containment reference '{@link org.gecko.searchresult.QueryObject#getLikeThisObject <em>Like This Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Like This Object</em>'.
	 * @see org.gecko.searchresult.QueryObject#getLikeThisObject()
	 * @see #getQueryObject()
	 * @generated
	 */
	EReference getQueryObject_LikeThisObject();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.QueryObject#getAnalyzerId <em>Analyzer Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Analyzer Id</em>'.
	 * @see org.gecko.searchresult.QueryObject#getAnalyzerId()
	 * @see #getQueryObject()
	 * @generated
	 */
	EAttribute getQueryObject_AnalyzerId();

	/**
	 * Returns the meta object for the containment reference '{@link org.gecko.searchresult.QueryObject#getFacetQueryContext <em>Facet Query Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Facet Query Context</em>'.
	 * @see org.gecko.searchresult.QueryObject#getFacetQueryContext()
	 * @see #getQueryObject()
	 * @generated
	 */
	EReference getQueryObject_FacetQueryContext();

	/**
	 * Returns the meta object for the attribute list '{@link org.gecko.searchresult.QueryObject#getNativeCollectors <em>Native Collectors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Native Collectors</em>'.
	 * @see org.gecko.searchresult.QueryObject#getNativeCollectors()
	 * @see #getQueryObject()
	 * @generated
	 */
	EAttribute getQueryObject_NativeCollectors();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.QueryObject#isRunCollectorExclusive <em>Run Collector Exclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Run Collector Exclusive</em>'.
	 * @see org.gecko.searchresult.QueryObject#isRunCollectorExclusive()
	 * @see #getQueryObject()
	 * @generated
	 */
	EAttribute getQueryObject_RunCollectorExclusive();

	/**
	 * Returns the meta object for the containment reference '{@link org.gecko.searchresult.QueryObject#getJoinQuery <em>Join Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Join Query</em>'.
	 * @see org.gecko.searchresult.QueryObject#getJoinQuery()
	 * @see #getQueryObject()
	 * @generated
	 */
	EReference getQueryObject_JoinQuery();

	/**
	 * Returns the meta object for the reference '{@link org.gecko.searchresult.QueryObject#getGroupingContext <em>Grouping Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Grouping Context</em>'.
	 * @see org.gecko.searchresult.QueryObject#getGroupingContext()
	 * @see #getQueryObject()
	 * @generated
	 */
	EReference getQueryObject_GroupingContext();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.QueryObject#getNativeQueryOccur <em>Native Query Occur</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Native Query Occur</em>'.
	 * @see org.gecko.searchresult.QueryObject#getNativeQueryOccur()
	 * @see #getQueryObject()
	 * @generated
	 */
	EAttribute getQueryObject_NativeQueryOccur();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.QueryObject#isExplain <em>Explain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Explain</em>'.
	 * @see org.gecko.searchresult.QueryObject#isExplain()
	 * @see #getQueryObject()
	 * @generated
	 */
	EAttribute getQueryObject_Explain();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.QueryObject#getPageIndex <em>Page Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Page Index</em>'.
	 * @see org.gecko.searchresult.QueryObject#getPageIndex()
	 * @see #getQueryObject()
	 * @generated
	 */
	EAttribute getQueryObject_PageIndex();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.QueryObject#getPageResultSize <em>Page Result Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Page Result Size</em>'.
	 * @see org.gecko.searchresult.QueryObject#getPageResultSize()
	 * @see #getQueryObject()
	 * @generated
	 */
	EAttribute getQueryObject_PageResultSize();

	/**
	 * Returns the meta object for class '{@link org.gecko.searchresult.MultiTokenFuzzyField <em>Multi Token Fuzzy Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multi Token Fuzzy Field</em>'.
	 * @see org.gecko.searchresult.MultiTokenFuzzyField
	 * @generated
	 */
	EClass getMultiTokenFuzzyField();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.MultiTokenFuzzyField#isUppercase <em>Uppercase</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uppercase</em>'.
	 * @see org.gecko.searchresult.MultiTokenFuzzyField#isUppercase()
	 * @see #getMultiTokenFuzzyField()
	 * @generated
	 */
	EAttribute getMultiTokenFuzzyField_Uppercase();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.MultiTokenFuzzyField#getMaxEdits <em>Max Edits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Edits</em>'.
	 * @see org.gecko.searchresult.MultiTokenFuzzyField#getMaxEdits()
	 * @see #getMultiTokenFuzzyField()
	 * @generated
	 */
	EAttribute getMultiTokenFuzzyField_MaxEdits();

	/**
	 * Returns the meta object for class '{@link org.gecko.searchresult.FilterField <em>Filter Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Filter Field</em>'.
	 * @see org.gecko.searchresult.FilterField
	 * @generated
	 */
	EClass getFilterField();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.FilterField#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see org.gecko.searchresult.FilterField#getKey()
	 * @see #getFilterField()
	 * @generated
	 */
	EAttribute getFilterField_Key();

	/**
	 * Returns the meta object for the attribute list '{@link org.gecko.searchresult.FilterField#getTokens <em>Tokens</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Tokens</em>'.
	 * @see org.gecko.searchresult.FilterField#getTokens()
	 * @see #getFilterField()
	 * @generated
	 */
	EAttribute getFilterField_Tokens();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.FilterField#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.gecko.searchresult.FilterField#getType()
	 * @see #getFilterField()
	 * @generated
	 */
	EAttribute getFilterField_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.FilterField#isPrefix <em>Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prefix</em>'.
	 * @see org.gecko.searchresult.FilterField#isPrefix()
	 * @see #getFilterField()
	 * @generated
	 */
	EAttribute getFilterField_Prefix();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.FilterField#getOccur <em>Occur</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Occur</em>'.
	 * @see org.gecko.searchresult.FilterField#getOccur()
	 * @see #getFilterField()
	 * @generated
	 */
	EAttribute getFilterField_Occur();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.FilterField#getTokensOccur <em>Tokens Occur</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tokens Occur</em>'.
	 * @see org.gecko.searchresult.FilterField#getTokensOccur()
	 * @see #getFilterField()
	 * @generated
	 */
	EAttribute getFilterField_TokensOccur();

	/**
	 * Returns the meta object for class '{@link org.gecko.searchresult.MultiTokenTermQuery <em>Multi Token Term Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multi Token Term Query</em>'.
	 * @see org.gecko.searchresult.MultiTokenTermQuery
	 * @generated
	 */
	EClass getMultiTokenTermQuery();

	/**
	 * Returns the meta object for the attribute list '{@link org.gecko.searchresult.MultiTokenTermQuery#getTokens <em>Tokens</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Tokens</em>'.
	 * @see org.gecko.searchresult.MultiTokenTermQuery#getTokens()
	 * @see #getMultiTokenTermQuery()
	 * @generated
	 */
	EAttribute getMultiTokenTermQuery_Tokens();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.MultiTokenTermQuery#isPrefix <em>Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prefix</em>'.
	 * @see org.gecko.searchresult.MultiTokenTermQuery#isPrefix()
	 * @see #getMultiTokenTermQuery()
	 * @generated
	 */
	EAttribute getMultiTokenTermQuery_Prefix();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.MultiTokenTermQuery#getTokensOccur <em>Tokens Occur</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tokens Occur</em>'.
	 * @see org.gecko.searchresult.MultiTokenTermQuery#getTokensOccur()
	 * @see #getMultiTokenTermQuery()
	 * @generated
	 */
	EAttribute getMultiTokenTermQuery_TokensOccur();

	/**
	 * Returns the meta object for class '{@link org.gecko.searchresult.QueryObjectContainer <em>Query Object Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Query Object Container</em>'.
	 * @see org.gecko.searchresult.QueryObjectContainer
	 * @generated
	 */
	EClass getQueryObjectContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gecko.searchresult.QueryObjectContainer#getQueries <em>Queries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Queries</em>'.
	 * @see org.gecko.searchresult.QueryObjectContainer#getQueries()
	 * @see #getQueryObjectContainer()
	 * @generated
	 */
	EReference getQueryObjectContainer_Queries();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gecko.searchresult.QueryObjectContainer#getActiveQueries <em>Active Queries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Active Queries</em>'.
	 * @see org.gecko.searchresult.QueryObjectContainer#getActiveQueries()
	 * @see #getQueryObjectContainer()
	 * @generated
	 */
	EReference getQueryObjectContainer_ActiveQueries();

	/**
	 * Returns the meta object for class '{@link org.gecko.searchresult.SortField <em>Sort Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sort Field</em>'.
	 * @see org.gecko.searchresult.SortField
	 * @generated
	 */
	EClass getSortField();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.SortField#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see org.gecko.searchresult.SortField#getKey()
	 * @see #getSortField()
	 * @generated
	 */
	EAttribute getSortField_Key();

	/**
	 * Returns the meta object for the attribute list '{@link org.gecko.searchresult.SortField#getTokens <em>Tokens</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Tokens</em>'.
	 * @see org.gecko.searchresult.SortField#getTokens()
	 * @see #getSortField()
	 * @generated
	 */
	EAttribute getSortField_Tokens();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.SortField#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.gecko.searchresult.SortField#getType()
	 * @see #getSortField()
	 * @generated
	 */
	EAttribute getSortField_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.SortField#getDirection <em>Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Direction</em>'.
	 * @see org.gecko.searchresult.SortField#getDirection()
	 * @see #getSortField()
	 * @generated
	 */
	EAttribute getSortField_Direction();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.SortField#getOccur <em>Occur</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Occur</em>'.
	 * @see org.gecko.searchresult.SortField#getOccur()
	 * @see #getSortField()
	 * @generated
	 */
	EAttribute getSortField_Occur();

	/**
	 * Returns the meta object for class '{@link org.gecko.searchresult.SpatialFilterField <em>Spatial Filter Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Spatial Filter Field</em>'.
	 * @see org.gecko.searchresult.SpatialFilterField
	 * @generated
	 */
	EClass getSpatialFilterField();

	/**
	 * Returns the meta object for class '{@link org.gecko.searchresult.WildcardField <em>Wildcard Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Wildcard Field</em>'.
	 * @see org.gecko.searchresult.WildcardField
	 * @generated
	 */
	EClass getWildcardField();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.WildcardField#isStartWithWildcard <em>Start With Wildcard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start With Wildcard</em>'.
	 * @see org.gecko.searchresult.WildcardField#isStartWithWildcard()
	 * @see #getWildcardField()
	 * @generated
	 */
	EAttribute getWildcardField_StartWithWildcard();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.WildcardField#isEndWithWildcard <em>End With Wildcard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End With Wildcard</em>'.
	 * @see org.gecko.searchresult.WildcardField#isEndWithWildcard()
	 * @see #getWildcardField()
	 * @generated
	 */
	EAttribute getWildcardField_EndWithWildcard();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.WildcardField#isIncludeUpperCase <em>Include Upper Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Include Upper Case</em>'.
	 * @see org.gecko.searchresult.WildcardField#isIncludeUpperCase()
	 * @see #getWildcardField()
	 * @generated
	 */
	EAttribute getWildcardField_IncludeUpperCase();

	/**
	 * Returns the meta object for class '{@link org.gecko.searchresult.ResultDescriptor <em>Result Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Result Descriptor</em>'.
	 * @see org.gecko.searchresult.ResultDescriptor
	 * @generated
	 */
	EClass getResultDescriptor();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.ResultDescriptor#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.gecko.searchresult.ResultDescriptor#getId()
	 * @see #getResultDescriptor()
	 * @generated
	 */
	EAttribute getResultDescriptor_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.ResultDescriptor#isActive <em>Active</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Active</em>'.
	 * @see org.gecko.searchresult.ResultDescriptor#isActive()
	 * @see #getResultDescriptor()
	 * @generated
	 */
	EAttribute getResultDescriptor_Active();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.ResultDescriptor#getIndexId <em>Index Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index Id</em>'.
	 * @see org.gecko.searchresult.ResultDescriptor#getIndexId()
	 * @see #getResultDescriptor()
	 * @generated
	 */
	EAttribute getResultDescriptor_IndexId();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gecko.searchresult.ResultDescriptor#getFields <em>Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fields</em>'.
	 * @see org.gecko.searchresult.ResultDescriptor#getFields()
	 * @see #getResultDescriptor()
	 * @generated
	 */
	EReference getResultDescriptor_Fields();

	/**
	 * Returns the meta object for class '{@link org.gecko.searchresult.ResultField <em>Result Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Result Field</em>'.
	 * @see org.gecko.searchresult.ResultField
	 * @generated
	 */
	EClass getResultField();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.ResultField#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.gecko.searchresult.ResultField#getName()
	 * @see #getResultField()
	 * @generated
	 */
	EAttribute getResultField_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.ResultField#isHighlight <em>Highlight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Highlight</em>'.
	 * @see org.gecko.searchresult.ResultField#isHighlight()
	 * @see #getResultField()
	 * @generated
	 */
	EAttribute getResultField_Highlight();

	/**
	 * Returns the meta object for class '{@link org.gecko.searchresult.ResultDescriptorContainer <em>Result Descriptor Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Result Descriptor Container</em>'.
	 * @see org.gecko.searchresult.ResultDescriptorContainer
	 * @generated
	 */
	EClass getResultDescriptorContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gecko.searchresult.ResultDescriptorContainer#getDescriptors <em>Descriptors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Descriptors</em>'.
	 * @see org.gecko.searchresult.ResultDescriptorContainer#getDescriptors()
	 * @see #getResultDescriptorContainer()
	 * @generated
	 */
	EReference getResultDescriptorContainer_Descriptors();

	/**
	 * Returns the meta object for the reference list '{@link org.gecko.searchresult.ResultDescriptorContainer#getActiveDescriptors <em>Active Descriptors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Active Descriptors</em>'.
	 * @see org.gecko.searchresult.ResultDescriptorContainer#getActiveDescriptors()
	 * @see #getResultDescriptorContainer()
	 * @generated
	 */
	EReference getResultDescriptorContainer_ActiveDescriptors();

	/**
	 * Returns the meta object for class '{@link org.gecko.searchresult.LikeThisObject <em>Like This Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Like This Object</em>'.
	 * @see org.gecko.searchresult.LikeThisObject
	 * @generated
	 */
	EClass getLikeThisObject();

	/**
	 * Returns the meta object for the attribute list '{@link org.gecko.searchresult.LikeThisObject#getLikeThisFields <em>Like This Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Like This Fields</em>'.
	 * @see org.gecko.searchresult.LikeThisObject#getLikeThisFields()
	 * @see #getLikeThisObject()
	 * @generated
	 */
	EAttribute getLikeThisObject_LikeThisFields();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gecko.searchresult.LikeThisObject#getFilterFields <em>Filter Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Filter Fields</em>'.
	 * @see org.gecko.searchresult.LikeThisObject#getFilterFields()
	 * @see #getLikeThisObject()
	 * @generated
	 */
	EReference getLikeThisObject_FilterFields();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gecko.searchresult.LikeThisObject#getSortFields <em>Sort Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sort Fields</em>'.
	 * @see org.gecko.searchresult.LikeThisObject#getSortFields()
	 * @see #getLikeThisObject()
	 * @generated
	 */
	EReference getLikeThisObject_SortFields();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.LikeThisObject#isFilterSourceObject <em>Filter Source Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filter Source Object</em>'.
	 * @see org.gecko.searchresult.LikeThisObject#isFilterSourceObject()
	 * @see #getLikeThisObject()
	 * @generated
	 */
	EAttribute getLikeThisObject_FilterSourceObject();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.LikeThisObject#getFilterSourceField <em>Filter Source Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filter Source Field</em>'.
	 * @see org.gecko.searchresult.LikeThisObject#getFilterSourceField()
	 * @see #getLikeThisObject()
	 * @generated
	 */
	EAttribute getLikeThisObject_FilterSourceField();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.LikeThisObject#getMaxResults <em>Max Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Results</em>'.
	 * @see org.gecko.searchresult.LikeThisObject#getMaxResults()
	 * @see #getLikeThisObject()
	 * @generated
	 */
	EAttribute getLikeThisObject_MaxResults();

	/**
	 * Returns the meta object for class '{@link org.gecko.searchresult.FacetFilter <em>Facet Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Facet Filter</em>'.
	 * @see org.gecko.searchresult.FacetFilter
	 * @generated
	 */
	EClass getFacetFilter();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.FacetFilter#getFacetKey <em>Facet Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Facet Key</em>'.
	 * @see org.gecko.searchresult.FacetFilter#getFacetKey()
	 * @see #getFacetFilter()
	 * @generated
	 */
	EAttribute getFacetFilter_FacetKey();

	/**
	 * Returns the meta object for the attribute list '{@link org.gecko.searchresult.FacetFilter#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Value</em>'.
	 * @see org.gecko.searchresult.FacetFilter#getValue()
	 * @see #getFacetFilter()
	 * @generated
	 */
	EAttribute getFacetFilter_Value();

	/**
	 * Returns the meta object for class '{@link org.gecko.searchresult.FacetQueryContext <em>Facet Query Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Facet Query Context</em>'.
	 * @see org.gecko.searchresult.FacetQueryContext
	 * @generated
	 */
	EClass getFacetQueryContext();

	/**
	 * Returns the meta object for the reference list '{@link org.gecko.searchresult.FacetQueryContext#getFacetFields <em>Facet Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Facet Fields</em>'.
	 * @see org.gecko.searchresult.FacetQueryContext#getFacetFields()
	 * @see #getFacetQueryContext()
	 * @generated
	 */
	EReference getFacetQueryContext_FacetFields();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.FacetQueryContext#isCountFacets <em>Count Facets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Count Facets</em>'.
	 * @see org.gecko.searchresult.FacetQueryContext#isCountFacets()
	 * @see #getFacetQueryContext()
	 * @generated
	 */
	EAttribute getFacetQueryContext_CountFacets();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.FacetQueryContext#isFillInCategories <em>Fill In Categories</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fill In Categories</em>'.
	 * @see org.gecko.searchresult.FacetQueryContext#isFillInCategories()
	 * @see #getFacetQueryContext()
	 * @generated
	 */
	EAttribute getFacetQueryContext_FillInCategories();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.FacetQueryContext#isAllowDuplicatesInCategories <em>Allow Duplicates In Categories</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Allow Duplicates In Categories</em>'.
	 * @see org.gecko.searchresult.FacetQueryContext#isAllowDuplicatesInCategories()
	 * @see #getFacetQueryContext()
	 * @generated
	 */
	EAttribute getFacetQueryContext_AllowDuplicatesInCategories();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.FacetQueryContext#getMaxFacets <em>Max Facets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Facets</em>'.
	 * @see org.gecko.searchresult.FacetQueryContext#getMaxFacets()
	 * @see #getFacetQueryContext()
	 * @generated
	 */
	EAttribute getFacetQueryContext_MaxFacets();

	/**
	 * Returns the meta object for the attribute list '{@link org.gecko.searchresult.FacetQueryContext#getDimensions <em>Dimensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Dimensions</em>'.
	 * @see org.gecko.searchresult.FacetQueryContext#getDimensions()
	 * @see #getFacetQueryContext()
	 * @generated
	 */
	EAttribute getFacetQueryContext_Dimensions();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.FacetQueryContext#getMaxResultPerCategory <em>Max Result Per Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Result Per Category</em>'.
	 * @see org.gecko.searchresult.FacetQueryContext#getMaxResultPerCategory()
	 * @see #getFacetQueryContext()
	 * @generated
	 */
	EAttribute getFacetQueryContext_MaxResultPerCategory();

	/**
	 * Returns the meta object for class '{@link org.gecko.searchresult.FacetResult <em>Facet Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Facet Result</em>'.
	 * @see org.gecko.searchresult.FacetResult
	 * @generated
	 */
	EClass getFacetResult();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.FacetResult#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see org.gecko.searchresult.FacetResult#getKey()
	 * @see #getFacetResult()
	 * @generated
	 */
	EAttribute getFacetResult_Key();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.FacetResult#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.gecko.searchresult.FacetResult#getValue()
	 * @see #getFacetResult()
	 * @generated
	 */
	EAttribute getFacetResult_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.FacetResult#getCount <em>Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Count</em>'.
	 * @see org.gecko.searchresult.FacetResult#getCount()
	 * @see #getFacetResult()
	 * @generated
	 */
	EAttribute getFacetResult_Count();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gecko.searchresult.FacetResult#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see org.gecko.searchresult.FacetResult#getChildren()
	 * @see #getFacetResult()
	 * @generated
	 */
	EReference getFacetResult_Children();

	/**
	 * Returns the meta object for class '{@link org.gecko.searchresult.JoinQuery <em>Join Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Join Query</em>'.
	 * @see org.gecko.searchresult.JoinQuery
	 * @generated
	 */
	EClass getJoinQuery();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.JoinQuery#getIndexPath <em>Index Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index Path</em>'.
	 * @see org.gecko.searchresult.JoinQuery#getIndexPath()
	 * @see #getJoinQuery()
	 * @generated
	 */
	EAttribute getJoinQuery_IndexPath();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.JoinQuery#getFromField <em>From Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>From Field</em>'.
	 * @see org.gecko.searchresult.JoinQuery#getFromField()
	 * @see #getJoinQuery()
	 * @generated
	 */
	EAttribute getJoinQuery_FromField();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.JoinQuery#getToField <em>To Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>To Field</em>'.
	 * @see org.gecko.searchresult.JoinQuery#getToField()
	 * @see #getJoinQuery()
	 * @generated
	 */
	EAttribute getJoinQuery_ToField();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.JoinQuery#getScoreMode <em>Score Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Score Mode</em>'.
	 * @see org.gecko.searchresult.JoinQuery#getScoreMode()
	 * @see #getJoinQuery()
	 * @generated
	 */
	EAttribute getJoinQuery_ScoreMode();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.JoinQuery#getQueryObject <em>Query Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Query Object</em>'.
	 * @see org.gecko.searchresult.JoinQuery#getQueryObject()
	 * @see #getJoinQuery()
	 * @generated
	 */
	EAttribute getJoinQuery_QueryObject();

	/**
	 * Returns the meta object for the attribute list '{@link org.gecko.searchresult.JoinQuery#getJoinAftermathCollectors <em>Join Aftermath Collectors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Join Aftermath Collectors</em>'.
	 * @see org.gecko.searchresult.JoinQuery#getJoinAftermathCollectors()
	 * @see #getJoinQuery()
	 * @generated
	 */
	EAttribute getJoinQuery_JoinAftermathCollectors();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.JoinQuery#getOccur <em>Occur</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Occur</em>'.
	 * @see org.gecko.searchresult.JoinQuery#getOccur()
	 * @see #getJoinQuery()
	 * @generated
	 */
	EAttribute getJoinQuery_Occur();

	/**
	 * Returns the meta object for class '{@link org.gecko.searchresult.SpatialSortField <em>Spatial Sort Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Spatial Sort Field</em>'.
	 * @see org.gecko.searchresult.SpatialSortField
	 * @generated
	 */
	EClass getSpatialSortField();

	/**
	 * Returns the meta object for the containment reference '{@link org.gecko.searchresult.SpatialSortField#getLatLng <em>Lat Lng</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Lat Lng</em>'.
	 * @see org.gecko.searchresult.SpatialSortField#getLatLng()
	 * @see #getSpatialSortField()
	 * @generated
	 */
	EReference getSpatialSortField_LatLng();

	/**
	 * Returns the meta object for class '{@link org.gecko.searchresult.GroupingContext <em>Grouping Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Grouping Context</em>'.
	 * @see org.gecko.searchresult.GroupingContext
	 * @generated
	 */
	EClass getGroupingContext();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.GroupingContext#getMaxGroups <em>Max Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Groups</em>'.
	 * @see org.gecko.searchresult.GroupingContext#getMaxGroups()
	 * @see #getGroupingContext()
	 * @generated
	 */
	EAttribute getGroupingContext_MaxGroups();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.GroupingContext#getOffSet <em>Off Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Off Set</em>'.
	 * @see org.gecko.searchresult.GroupingContext#getOffSet()
	 * @see #getGroupingContext()
	 * @generated
	 */
	EAttribute getGroupingContext_OffSet();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.GroupingContext#getGroupFieldName <em>Group Field Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Group Field Name</em>'.
	 * @see org.gecko.searchresult.GroupingContext#getGroupFieldName()
	 * @see #getGroupingContext()
	 * @generated
	 */
	EAttribute getGroupingContext_GroupFieldName();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.GroupingContext#getResultsPerGroup <em>Results Per Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Results Per Group</em>'.
	 * @see org.gecko.searchresult.GroupingContext#getResultsPerGroup()
	 * @see #getGroupingContext()
	 * @generated
	 */
	EAttribute getGroupingContext_ResultsPerGroup();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.GroupingContext#getCachSize <em>Cach Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cach Size</em>'.
	 * @see org.gecko.searchresult.GroupingContext#getCachSize()
	 * @see #getGroupingContext()
	 * @generated
	 */
	EAttribute getGroupingContext_CachSize();

	/**
	 * Returns the meta object for the reference list '{@link org.gecko.searchresult.GroupingContext#getGroupSort <em>Group Sort</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Group Sort</em>'.
	 * @see org.gecko.searchresult.GroupingContext#getGroupSort()
	 * @see #getGroupingContext()
	 * @generated
	 */
	EReference getGroupingContext_GroupSort();

	/**
	 * Returns the meta object for class '{@link org.gecko.searchresult.SpatialField <em>Spatial Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Spatial Field</em>'.
	 * @see org.gecko.searchresult.SpatialField
	 * @generated
	 */
	EClass getSpatialField();

	/**
	 * Returns the meta object for the containment reference '{@link org.gecko.searchresult.SpatialField#getLatLng <em>Lat Lng</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Lat Lng</em>'.
	 * @see org.gecko.searchresult.SpatialField#getLatLng()
	 * @see #getSpatialField()
	 * @generated
	 */
	EReference getSpatialField_LatLng();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.SpatialField#getDistance <em>Distance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Distance</em>'.
	 * @see org.gecko.searchresult.SpatialField#getDistance()
	 * @see #getSpatialField()
	 * @generated
	 */
	EAttribute getSpatialField_Distance();

	/**
	 * Returns the meta object for class '{@link org.gecko.searchresult.SpanTermField <em>Span Term Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Span Term Field</em>'.
	 * @see org.gecko.searchresult.SpanTermField
	 * @generated
	 */
	EClass getSpanTermField();

	/**
	 * Returns the meta object for the attribute list '{@link org.gecko.searchresult.SpanTermField#getTokens <em>Tokens</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Tokens</em>'.
	 * @see org.gecko.searchresult.SpanTermField#getTokens()
	 * @see #getSpanTermField()
	 * @generated
	 */
	EAttribute getSpanTermField_Tokens();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.SpanTermField#getSpan <em>Span</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Span</em>'.
	 * @see org.gecko.searchresult.SpanTermField#getSpan()
	 * @see #getSpanTermField()
	 * @generated
	 */
	EAttribute getSpanTermField_Span();

	/**
	 * Returns the meta object for class '{@link org.gecko.searchresult.BooleanQuery <em>Boolean Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Query</em>'.
	 * @see org.gecko.searchresult.BooleanQuery
	 * @generated
	 */
	EClass getBooleanQuery();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gecko.searchresult.BooleanQuery#getClauses <em>Clauses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Clauses</em>'.
	 * @see org.gecko.searchresult.BooleanQuery#getClauses()
	 * @see #getBooleanQuery()
	 * @generated
	 */
	EReference getBooleanQuery_Clauses();

	/**
	 * Returns the meta object for class '{@link org.gecko.searchresult.LuceneQueryField <em>Lucene Query Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lucene Query Field</em>'.
	 * @see org.gecko.searchresult.LuceneQueryField
	 * @generated
	 */
	EClass getLuceneQueryField();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.LuceneQueryField#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see org.gecko.searchresult.LuceneQueryField#getKey()
	 * @see #getLuceneQueryField()
	 * @generated
	 */
	EAttribute getLuceneQueryField_Key();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.LuceneQueryField#isAnalyzed <em>Analyzed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Analyzed</em>'.
	 * @see org.gecko.searchresult.LuceneQueryField#isAnalyzed()
	 * @see #getLuceneQueryField()
	 * @generated
	 */
	EAttribute getLuceneQueryField_Analyzed();

	/**
	 * Returns the meta object for class '{@link org.gecko.searchresult.BoostableField <em>Boostable Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boostable Field</em>'.
	 * @see org.gecko.searchresult.BoostableField
	 * @generated
	 */
	EClass getBoostableField();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.BoostableField#getBoost <em>Boost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Boost</em>'.
	 * @see org.gecko.searchresult.BoostableField#getBoost()
	 * @see #getBoostableField()
	 * @generated
	 */
	EAttribute getBoostableField_Boost();

	/**
	 * Returns the meta object for class '{@link org.gecko.searchresult.BooleanClause <em>Boolean Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Clause</em>'.
	 * @see org.gecko.searchresult.BooleanClause
	 * @generated
	 */
	EClass getBooleanClause();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.BooleanClause#getOccur <em>Occur</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Occur</em>'.
	 * @see org.gecko.searchresult.BooleanClause#getOccur()
	 * @see #getBooleanClause()
	 * @generated
	 */
	EAttribute getBooleanClause_Occur();

	/**
	 * Returns the meta object for the containment reference '{@link org.gecko.searchresult.BooleanClause#getQuery <em>Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Query</em>'.
	 * @see org.gecko.searchresult.BooleanClause#getQuery()
	 * @see #getBooleanClause()
	 * @generated
	 */
	EReference getBooleanClause_Query();

	/**
	 * Returns the meta object for class '{@link org.gecko.searchresult.NumericRangeQuery <em>Numeric Range Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Numeric Range Query</em>'.
	 * @see org.gecko.searchresult.NumericRangeQuery
	 * @generated
	 */
	EClass getNumericRangeQuery();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.NumericRangeQuery#getPrecisionStep <em>Precision Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Precision Step</em>'.
	 * @see org.gecko.searchresult.NumericRangeQuery#getPrecisionStep()
	 * @see #getNumericRangeQuery()
	 * @generated
	 */
	EAttribute getNumericRangeQuery_PrecisionStep();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.NumericRangeQuery#isMinInclusive <em>Min Inclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Inclusive</em>'.
	 * @see org.gecko.searchresult.NumericRangeQuery#isMinInclusive()
	 * @see #getNumericRangeQuery()
	 * @generated
	 */
	EAttribute getNumericRangeQuery_MinInclusive();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.NumericRangeQuery#isMaxInclusive <em>Max Inclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Inclusive</em>'.
	 * @see org.gecko.searchresult.NumericRangeQuery#isMaxInclusive()
	 * @see #getNumericRangeQuery()
	 * @generated
	 */
	EAttribute getNumericRangeQuery_MaxInclusive();

	/**
	 * Returns the meta object for class '{@link org.gecko.searchresult.DoubleRangeQuery <em>Double Range Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Double Range Query</em>'.
	 * @see org.gecko.searchresult.DoubleRangeQuery
	 * @generated
	 */
	EClass getDoubleRangeQuery();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.DoubleRangeQuery#getMinValue <em>Min Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Value</em>'.
	 * @see org.gecko.searchresult.DoubleRangeQuery#getMinValue()
	 * @see #getDoubleRangeQuery()
	 * @generated
	 */
	EAttribute getDoubleRangeQuery_MinValue();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.DoubleRangeQuery#getMaxValue <em>Max Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Value</em>'.
	 * @see org.gecko.searchresult.DoubleRangeQuery#getMaxValue()
	 * @see #getDoubleRangeQuery()
	 * @generated
	 */
	EAttribute getDoubleRangeQuery_MaxValue();

	/**
	 * Returns the meta object for class '{@link org.gecko.searchresult.SingleTokenTermQuery <em>Single Token Term Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Single Token Term Query</em>'.
	 * @see org.gecko.searchresult.SingleTokenTermQuery
	 * @generated
	 */
	EClass getSingleTokenTermQuery();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.SingleTokenTermQuery#getToken <em>Token</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Token</em>'.
	 * @see org.gecko.searchresult.SingleTokenTermQuery#getToken()
	 * @see #getSingleTokenTermQuery()
	 * @generated
	 */
	EAttribute getSingleTokenTermQuery_Token();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.SingleTokenTermQuery#isPrefix <em>Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prefix</em>'.
	 * @see org.gecko.searchresult.SingleTokenTermQuery#isPrefix()
	 * @see #getSingleTokenTermQuery()
	 * @generated
	 */
	EAttribute getSingleTokenTermQuery_Prefix();

	/**
	 * Returns the meta object for class '{@link org.gecko.searchresult.SingleTokenFuzzyField <em>Single Token Fuzzy Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Single Token Fuzzy Field</em>'.
	 * @see org.gecko.searchresult.SingleTokenFuzzyField
	 * @generated
	 */
	EClass getSingleTokenFuzzyField();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.SingleTokenFuzzyField#isUppercase <em>Uppercase</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uppercase</em>'.
	 * @see org.gecko.searchresult.SingleTokenFuzzyField#isUppercase()
	 * @see #getSingleTokenFuzzyField()
	 * @generated
	 */
	EAttribute getSingleTokenFuzzyField_Uppercase();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.SingleTokenFuzzyField#getMaxEdits <em>Max Edits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Edits</em>'.
	 * @see org.gecko.searchresult.SingleTokenFuzzyField#getMaxEdits()
	 * @see #getSingleTokenFuzzyField()
	 * @generated
	 */
	EAttribute getSingleTokenFuzzyField_MaxEdits();

	/**
	 * Returns the meta object for class '{@link org.gecko.searchresult.SpanQueryField <em>Span Query Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Span Query Field</em>'.
	 * @see org.gecko.searchresult.SpanQueryField
	 * @generated
	 */
	EClass getSpanQueryField();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.SpanQueryField#getSpan <em>Span</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Span</em>'.
	 * @see org.gecko.searchresult.SpanQueryField#getSpan()
	 * @see #getSpanQueryField()
	 * @generated
	 */
	EAttribute getSpanQueryField_Span();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gecko.searchresult.SpanQueryField#getQueryFields <em>Query Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Query Fields</em>'.
	 * @see org.gecko.searchresult.SpanQueryField#getQueryFields()
	 * @see #getSpanQueryField()
	 * @generated
	 */
	EReference getSpanQueryField_QueryFields();

	/**
	 * Returns the meta object for class '{@link org.gecko.searchresult.PhraseQuery <em>Phrase Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Phrase Query</em>'.
	 * @see org.gecko.searchresult.PhraseQuery
	 * @generated
	 */
	EClass getPhraseQuery();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchresult.PhraseQuery#getSlop <em>Slop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Slop</em>'.
	 * @see org.gecko.searchresult.PhraseQuery#getSlop()
	 * @see #getPhraseQuery()
	 * @generated
	 */
	EAttribute getPhraseQuery_Slop();

	/**
	 * Returns the meta object for the attribute list '{@link org.gecko.searchresult.PhraseQuery#getTerms <em>Terms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Terms</em>'.
	 * @see org.gecko.searchresult.PhraseQuery#getTerms()
	 * @see #getPhraseQuery()
	 * @generated
	 */
	EAttribute getPhraseQuery_Terms();

	/**
	 * Returns the meta object for class '{@link org.gecko.searchresult.MultiPhraseQuery <em>Multi Phrase Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multi Phrase Query</em>'.
	 * @see org.gecko.searchresult.MultiPhraseQuery
	 * @generated
	 */
	EClass getMultiPhraseQuery();

	/**
	 * Returns the meta object for enum '{@link org.gecko.searchresult.FilteringType <em>Filtering Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Filtering Type</em>'.
	 * @see org.gecko.searchresult.FilteringType
	 * @generated
	 */
	EEnum getFilteringType();

	/**
	 * Returns the meta object for enum '{@link org.gecko.searchresult.SortType <em>Sort Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Sort Type</em>'.
	 * @see org.gecko.searchresult.SortType
	 * @generated
	 */
	EEnum getSortType();

	/**
	 * Returns the meta object for enum '{@link org.gecko.searchresult.SortDirectionType <em>Sort Direction Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Sort Direction Type</em>'.
	 * @see org.gecko.searchresult.SortDirectionType
	 * @generated
	 */
	EEnum getSortDirectionType();

	/**
	 * Returns the meta object for enum '{@link org.gecko.searchresult.Occur <em>Occur</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Occur</em>'.
	 * @see org.gecko.searchresult.Occur
	 * @generated
	 */
	EEnum getOccur();

	/**
	 * Returns the meta object for enum '{@link org.gecko.searchresult.JoinScoreMode <em>Join Score Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Join Score Mode</em>'.
	 * @see org.gecko.searchresult.JoinScoreMode
	 * @generated
	 */
	EEnum getJoinScoreMode();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SearchResultFactory getSearchResultFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.gecko.searchresult.impl.SearchResultImpl <em>Search Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchresult.impl.SearchResultImpl
		 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getSearchResult()
		 * @generated
		 */
		EClass SEARCH_RESULT = eINSTANCE.getSearchResult();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEARCH_RESULT__ID = eINSTANCE.getSearchResult_Id();

		/**
		 * The meta object literal for the '<em><b>Categories</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEARCH_RESULT__CATEGORIES = eINSTANCE.getSearchResult_Categories();

		/**
		 * The meta object literal for the '<em><b>Category Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEARCH_RESULT__CATEGORY_SIZE = eINSTANCE.getSearchResult_CategorySize();

		/**
		 * The meta object literal for the '<em><b>All Match Result Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEARCH_RESULT__ALL_MATCH_RESULT_SIZE = eINSTANCE.getSearchResult_AllMatchResultSize();

		/**
		 * The meta object literal for the '<em><b>Native Result</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEARCH_RESULT__NATIVE_RESULT = eINSTANCE.getSearchResult_NativeResult();

		/**
		 * The meta object literal for the '<em><b>Facet Results</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEARCH_RESULT__FACET_RESULTS = eINSTANCE.getSearchResult_FacetResults();

		/**
		 * The meta object literal for the '<em><b>Native Collector Results</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEARCH_RESULT__NATIVE_COLLECTOR_RESULTS = eINSTANCE.getSearchResult_NativeCollectorResults();

		/**
		 * The meta object literal for the '<em><b>Native Join Collector Results</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEARCH_RESULT__NATIVE_JOIN_COLLECTOR_RESULTS = eINSTANCE.getSearchResult_NativeJoinCollectorResults();

		/**
		 * The meta object literal for the '<em><b>Number Pages</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEARCH_RESULT__NUMBER_PAGES = eINSTANCE.getSearchResult_NumberPages();

		/**
		 * The meta object literal for the '<em><b>Page Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEARCH_RESULT__PAGE_SIZE = eINSTANCE.getSearchResult_PageSize();

		/**
		 * The meta object literal for the '{@link org.gecko.searchresult.impl.CategoryImpl <em>Category</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchresult.impl.CategoryImpl
		 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getCategory()
		 * @generated
		 */
		EClass CATEGORY = eINSTANCE.getCategory();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATEGORY__ID = eINSTANCE.getCategory_Id();

		/**
		 * The meta object literal for the '<em><b>Results</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CATEGORY__RESULTS = eINSTANCE.getCategory_Results();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATEGORY__NAME = eINSTANCE.getCategory_Name();

		/**
		 * The meta object literal for the '<em><b>Match Result Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATEGORY__MATCH_RESULT_SIZE = eINSTANCE.getCategory_MatchResultSize();

		/**
		 * The meta object literal for the '{@link org.gecko.searchresult.impl.MatchResultImpl <em>Match Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchresult.impl.MatchResultImpl
		 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getMatchResult()
		 * @generated
		 */
		EClass MATCH_RESULT = eINSTANCE.getMatchResult();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATCH_RESULT__ID = eINSTANCE.getMatchResult_Id();

		/**
		 * The meta object literal for the '<em><b>Highlights</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATCH_RESULT__HIGHLIGHTS = eINSTANCE.getMatchResult_Highlights();

		/**
		 * The meta object literal for the '<em><b>Fields</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATCH_RESULT__FIELDS = eINSTANCE.getMatchResult_Fields();

		/**
		 * The meta object literal for the '<em><b>Score</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATCH_RESULT__SCORE = eINSTANCE.getMatchResult_Score();

		/**
		 * The meta object literal for the '<em><b>Explanation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATCH_RESULT__EXPLANATION = eINSTANCE.getMatchResult_Explanation();

		/**
		 * The meta object literal for the '<em><b>Get Match Field By Id</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MATCH_RESULT___GET_MATCH_FIELD_BY_ID__STRING = eINSTANCE.getMatchResult__GetMatchFieldById__String();

		/**
		 * The meta object literal for the '{@link org.gecko.searchresult.impl.MatchHighlightImpl <em>Match Highlight</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchresult.impl.MatchHighlightImpl
		 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getMatchHighlight()
		 * @generated
		 */
		EClass MATCH_HIGHLIGHT = eINSTANCE.getMatchHighlight();

		/**
		 * The meta object literal for the '<em><b>Start Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATCH_HIGHLIGHT__START_OFFSET = eINSTANCE.getMatchHighlight_StartOffset();

		/**
		 * The meta object literal for the '<em><b>End Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATCH_HIGHLIGHT__END_OFFSET = eINSTANCE.getMatchHighlight_EndOffset();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATCH_HIGHLIGHT__TEXT = eINSTANCE.getMatchHighlight_Text();

		/**
		 * The meta object literal for the '<em><b>Highlighted Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATCH_HIGHLIGHT__HIGHLIGHTED_TEXT = eINSTANCE.getMatchHighlight_HighlightedText();

		/**
		 * The meta object literal for the '{@link org.gecko.searchresult.impl.MatchFieldImpl <em>Match Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchresult.impl.MatchFieldImpl
		 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getMatchField()
		 * @generated
		 */
		EClass MATCH_FIELD = eINSTANCE.getMatchField();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATCH_FIELD__ID = eINSTANCE.getMatchField_Id();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATCH_FIELD__FEATURE = eINSTANCE.getMatchField_Feature();

		/**
		 * The meta object literal for the '<em><b>Converter</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATCH_FIELD__CONVERTER = eINSTANCE.getMatchField_Converter();

		/**
		 * The meta object literal for the '<em><b>Multi Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATCH_FIELD__MULTI_VALUE = eINSTANCE.getMatchField_MultiValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATCH_FIELD__VALUE = eINSTANCE.getMatchField_Value();

		/**
		 * The meta object literal for the '<em><b>Highlighting</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATCH_FIELD__HIGHLIGHTING = eINSTANCE.getMatchField_Highlighting();

		/**
		 * The meta object literal for the '{@link org.gecko.searchresult.impl.QueryObjectImpl <em>Query Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchresult.impl.QueryObjectImpl
		 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getQueryObject()
		 * @generated
		 */
		EClass QUERY_OBJECT = eINSTANCE.getQueryObject();

		/**
		 * The meta object literal for the '<em><b>Native Query</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUERY_OBJECT__NATIVE_QUERY = eINSTANCE.getQueryObject_NativeQuery();

		/**
		 * The meta object literal for the '<em><b>Index Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUERY_OBJECT__INDEX_PATH = eINSTANCE.getQueryObject_IndexPath();

		/**
		 * The meta object literal for the '<em><b>Max Results</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUERY_OBJECT__MAX_RESULTS = eINSTANCE.getQueryObject_MaxResults();

		/**
		 * The meta object literal for the '<em><b>Filter Fields</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUERY_OBJECT__FILTER_FIELDS = eINSTANCE.getQueryObject_FilterFields();

		/**
		 * The meta object literal for the '<em><b>Sort Fields</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUERY_OBJECT__SORT_FIELDS = eINSTANCE.getQueryObject_SortFields();

		/**
		 * The meta object literal for the '<em><b>Native Object</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUERY_OBJECT__NATIVE_OBJECT = eINSTANCE.getQueryObject_NativeObject();

		/**
		 * The meta object literal for the '<em><b>Spatial Filter Field</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUERY_OBJECT__SPATIAL_FILTER_FIELD = eINSTANCE.getQueryObject_SpatialFilterField();

		/**
		 * The meta object literal for the '<em><b>Highlight Fields</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUERY_OBJECT__HIGHLIGHT_FIELDS = eINSTANCE.getQueryObject_HighlightFields();

		/**
		 * The meta object literal for the '<em><b>Like This Object</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUERY_OBJECT__LIKE_THIS_OBJECT = eINSTANCE.getQueryObject_LikeThisObject();

		/**
		 * The meta object literal for the '<em><b>Analyzer Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUERY_OBJECT__ANALYZER_ID = eINSTANCE.getQueryObject_AnalyzerId();

		/**
		 * The meta object literal for the '<em><b>Facet Query Context</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUERY_OBJECT__FACET_QUERY_CONTEXT = eINSTANCE.getQueryObject_FacetQueryContext();

		/**
		 * The meta object literal for the '<em><b>Native Collectors</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUERY_OBJECT__NATIVE_COLLECTORS = eINSTANCE.getQueryObject_NativeCollectors();

		/**
		 * The meta object literal for the '<em><b>Run Collector Exclusive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUERY_OBJECT__RUN_COLLECTOR_EXCLUSIVE = eINSTANCE.getQueryObject_RunCollectorExclusive();

		/**
		 * The meta object literal for the '<em><b>Join Query</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUERY_OBJECT__JOIN_QUERY = eINSTANCE.getQueryObject_JoinQuery();

		/**
		 * The meta object literal for the '<em><b>Grouping Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUERY_OBJECT__GROUPING_CONTEXT = eINSTANCE.getQueryObject_GroupingContext();

		/**
		 * The meta object literal for the '<em><b>Native Query Occur</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUERY_OBJECT__NATIVE_QUERY_OCCUR = eINSTANCE.getQueryObject_NativeQueryOccur();

		/**
		 * The meta object literal for the '<em><b>Explain</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUERY_OBJECT__EXPLAIN = eINSTANCE.getQueryObject_Explain();

		/**
		 * The meta object literal for the '<em><b>Page Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUERY_OBJECT__PAGE_INDEX = eINSTANCE.getQueryObject_PageIndex();

		/**
		 * The meta object literal for the '<em><b>Page Result Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUERY_OBJECT__PAGE_RESULT_SIZE = eINSTANCE.getQueryObject_PageResultSize();

		/**
		 * The meta object literal for the '{@link org.gecko.searchresult.impl.MultiTokenFuzzyFieldImpl <em>Multi Token Fuzzy Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchresult.impl.MultiTokenFuzzyFieldImpl
		 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getMultiTokenFuzzyField()
		 * @generated
		 */
		EClass MULTI_TOKEN_FUZZY_FIELD = eINSTANCE.getMultiTokenFuzzyField();

		/**
		 * The meta object literal for the '<em><b>Uppercase</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTI_TOKEN_FUZZY_FIELD__UPPERCASE = eINSTANCE.getMultiTokenFuzzyField_Uppercase();

		/**
		 * The meta object literal for the '<em><b>Max Edits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTI_TOKEN_FUZZY_FIELD__MAX_EDITS = eINSTANCE.getMultiTokenFuzzyField_MaxEdits();

		/**
		 * The meta object literal for the '{@link org.gecko.searchresult.impl.FilterFieldImpl <em>Filter Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchresult.impl.FilterFieldImpl
		 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getFilterField()
		 * @generated
		 */
		EClass FILTER_FIELD = eINSTANCE.getFilterField();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILTER_FIELD__KEY = eINSTANCE.getFilterField_Key();

		/**
		 * The meta object literal for the '<em><b>Tokens</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILTER_FIELD__TOKENS = eINSTANCE.getFilterField_Tokens();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILTER_FIELD__TYPE = eINSTANCE.getFilterField_Type();

		/**
		 * The meta object literal for the '<em><b>Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILTER_FIELD__PREFIX = eINSTANCE.getFilterField_Prefix();

		/**
		 * The meta object literal for the '<em><b>Occur</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILTER_FIELD__OCCUR = eINSTANCE.getFilterField_Occur();

		/**
		 * The meta object literal for the '<em><b>Tokens Occur</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILTER_FIELD__TOKENS_OCCUR = eINSTANCE.getFilterField_TokensOccur();

		/**
		 * The meta object literal for the '{@link org.gecko.searchresult.impl.MultiTokenTermQueryImpl <em>Multi Token Term Query</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchresult.impl.MultiTokenTermQueryImpl
		 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getMultiTokenTermQuery()
		 * @generated
		 */
		EClass MULTI_TOKEN_TERM_QUERY = eINSTANCE.getMultiTokenTermQuery();

		/**
		 * The meta object literal for the '<em><b>Tokens</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTI_TOKEN_TERM_QUERY__TOKENS = eINSTANCE.getMultiTokenTermQuery_Tokens();

		/**
		 * The meta object literal for the '<em><b>Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTI_TOKEN_TERM_QUERY__PREFIX = eINSTANCE.getMultiTokenTermQuery_Prefix();

		/**
		 * The meta object literal for the '<em><b>Tokens Occur</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTI_TOKEN_TERM_QUERY__TOKENS_OCCUR = eINSTANCE.getMultiTokenTermQuery_TokensOccur();

		/**
		 * The meta object literal for the '{@link org.gecko.searchresult.impl.QueryObjectContainerImpl <em>Query Object Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchresult.impl.QueryObjectContainerImpl
		 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getQueryObjectContainer()
		 * @generated
		 */
		EClass QUERY_OBJECT_CONTAINER = eINSTANCE.getQueryObjectContainer();

		/**
		 * The meta object literal for the '<em><b>Queries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUERY_OBJECT_CONTAINER__QUERIES = eINSTANCE.getQueryObjectContainer_Queries();

		/**
		 * The meta object literal for the '<em><b>Active Queries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUERY_OBJECT_CONTAINER__ACTIVE_QUERIES = eINSTANCE.getQueryObjectContainer_ActiveQueries();

		/**
		 * The meta object literal for the '{@link org.gecko.searchresult.impl.SortFieldImpl <em>Sort Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchresult.impl.SortFieldImpl
		 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getSortField()
		 * @generated
		 */
		EClass SORT_FIELD = eINSTANCE.getSortField();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SORT_FIELD__KEY = eINSTANCE.getSortField_Key();

		/**
		 * The meta object literal for the '<em><b>Tokens</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SORT_FIELD__TOKENS = eINSTANCE.getSortField_Tokens();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SORT_FIELD__TYPE = eINSTANCE.getSortField_Type();

		/**
		 * The meta object literal for the '<em><b>Direction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SORT_FIELD__DIRECTION = eINSTANCE.getSortField_Direction();

		/**
		 * The meta object literal for the '<em><b>Occur</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SORT_FIELD__OCCUR = eINSTANCE.getSortField_Occur();

		/**
		 * The meta object literal for the '{@link org.gecko.searchresult.impl.SpatialFilterFieldImpl <em>Spatial Filter Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchresult.impl.SpatialFilterFieldImpl
		 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getSpatialFilterField()
		 * @generated
		 */
		EClass SPATIAL_FILTER_FIELD = eINSTANCE.getSpatialFilterField();

		/**
		 * The meta object literal for the '{@link org.gecko.searchresult.impl.WildcardFieldImpl <em>Wildcard Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchresult.impl.WildcardFieldImpl
		 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getWildcardField()
		 * @generated
		 */
		EClass WILDCARD_FIELD = eINSTANCE.getWildcardField();

		/**
		 * The meta object literal for the '<em><b>Start With Wildcard</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WILDCARD_FIELD__START_WITH_WILDCARD = eINSTANCE.getWildcardField_StartWithWildcard();

		/**
		 * The meta object literal for the '<em><b>End With Wildcard</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WILDCARD_FIELD__END_WITH_WILDCARD = eINSTANCE.getWildcardField_EndWithWildcard();

		/**
		 * The meta object literal for the '<em><b>Include Upper Case</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WILDCARD_FIELD__INCLUDE_UPPER_CASE = eINSTANCE.getWildcardField_IncludeUpperCase();

		/**
		 * The meta object literal for the '{@link org.gecko.searchresult.impl.ResultDescriptorImpl <em>Result Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchresult.impl.ResultDescriptorImpl
		 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getResultDescriptor()
		 * @generated
		 */
		EClass RESULT_DESCRIPTOR = eINSTANCE.getResultDescriptor();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESULT_DESCRIPTOR__ID = eINSTANCE.getResultDescriptor_Id();

		/**
		 * The meta object literal for the '<em><b>Active</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESULT_DESCRIPTOR__ACTIVE = eINSTANCE.getResultDescriptor_Active();

		/**
		 * The meta object literal for the '<em><b>Index Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESULT_DESCRIPTOR__INDEX_ID = eINSTANCE.getResultDescriptor_IndexId();

		/**
		 * The meta object literal for the '<em><b>Fields</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESULT_DESCRIPTOR__FIELDS = eINSTANCE.getResultDescriptor_Fields();

		/**
		 * The meta object literal for the '{@link org.gecko.searchresult.impl.ResultFieldImpl <em>Result Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchresult.impl.ResultFieldImpl
		 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getResultField()
		 * @generated
		 */
		EClass RESULT_FIELD = eINSTANCE.getResultField();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESULT_FIELD__NAME = eINSTANCE.getResultField_Name();

		/**
		 * The meta object literal for the '<em><b>Highlight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESULT_FIELD__HIGHLIGHT = eINSTANCE.getResultField_Highlight();

		/**
		 * The meta object literal for the '{@link org.gecko.searchresult.impl.ResultDescriptorContainerImpl <em>Result Descriptor Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchresult.impl.ResultDescriptorContainerImpl
		 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getResultDescriptorContainer()
		 * @generated
		 */
		EClass RESULT_DESCRIPTOR_CONTAINER = eINSTANCE.getResultDescriptorContainer();

		/**
		 * The meta object literal for the '<em><b>Descriptors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESULT_DESCRIPTOR_CONTAINER__DESCRIPTORS = eINSTANCE.getResultDescriptorContainer_Descriptors();

		/**
		 * The meta object literal for the '<em><b>Active Descriptors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESULT_DESCRIPTOR_CONTAINER__ACTIVE_DESCRIPTORS = eINSTANCE.getResultDescriptorContainer_ActiveDescriptors();

		/**
		 * The meta object literal for the '{@link org.gecko.searchresult.impl.LikeThisObjectImpl <em>Like This Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchresult.impl.LikeThisObjectImpl
		 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getLikeThisObject()
		 * @generated
		 */
		EClass LIKE_THIS_OBJECT = eINSTANCE.getLikeThisObject();

		/**
		 * The meta object literal for the '<em><b>Like This Fields</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIKE_THIS_OBJECT__LIKE_THIS_FIELDS = eINSTANCE.getLikeThisObject_LikeThisFields();

		/**
		 * The meta object literal for the '<em><b>Filter Fields</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIKE_THIS_OBJECT__FILTER_FIELDS = eINSTANCE.getLikeThisObject_FilterFields();

		/**
		 * The meta object literal for the '<em><b>Sort Fields</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIKE_THIS_OBJECT__SORT_FIELDS = eINSTANCE.getLikeThisObject_SortFields();

		/**
		 * The meta object literal for the '<em><b>Filter Source Object</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIKE_THIS_OBJECT__FILTER_SOURCE_OBJECT = eINSTANCE.getLikeThisObject_FilterSourceObject();

		/**
		 * The meta object literal for the '<em><b>Filter Source Field</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIKE_THIS_OBJECT__FILTER_SOURCE_FIELD = eINSTANCE.getLikeThisObject_FilterSourceField();

		/**
		 * The meta object literal for the '<em><b>Max Results</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIKE_THIS_OBJECT__MAX_RESULTS = eINSTANCE.getLikeThisObject_MaxResults();

		/**
		 * The meta object literal for the '{@link org.gecko.searchresult.impl.FacetFilterImpl <em>Facet Filter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchresult.impl.FacetFilterImpl
		 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getFacetFilter()
		 * @generated
		 */
		EClass FACET_FILTER = eINSTANCE.getFacetFilter();

		/**
		 * The meta object literal for the '<em><b>Facet Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FACET_FILTER__FACET_KEY = eINSTANCE.getFacetFilter_FacetKey();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FACET_FILTER__VALUE = eINSTANCE.getFacetFilter_Value();

		/**
		 * The meta object literal for the '{@link org.gecko.searchresult.impl.FacetQueryContextImpl <em>Facet Query Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchresult.impl.FacetQueryContextImpl
		 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getFacetQueryContext()
		 * @generated
		 */
		EClass FACET_QUERY_CONTEXT = eINSTANCE.getFacetQueryContext();

		/**
		 * The meta object literal for the '<em><b>Facet Fields</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FACET_QUERY_CONTEXT__FACET_FIELDS = eINSTANCE.getFacetQueryContext_FacetFields();

		/**
		 * The meta object literal for the '<em><b>Count Facets</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FACET_QUERY_CONTEXT__COUNT_FACETS = eINSTANCE.getFacetQueryContext_CountFacets();

		/**
		 * The meta object literal for the '<em><b>Fill In Categories</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FACET_QUERY_CONTEXT__FILL_IN_CATEGORIES = eINSTANCE.getFacetQueryContext_FillInCategories();

		/**
		 * The meta object literal for the '<em><b>Allow Duplicates In Categories</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FACET_QUERY_CONTEXT__ALLOW_DUPLICATES_IN_CATEGORIES = eINSTANCE.getFacetQueryContext_AllowDuplicatesInCategories();

		/**
		 * The meta object literal for the '<em><b>Max Facets</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FACET_QUERY_CONTEXT__MAX_FACETS = eINSTANCE.getFacetQueryContext_MaxFacets();

		/**
		 * The meta object literal for the '<em><b>Dimensions</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FACET_QUERY_CONTEXT__DIMENSIONS = eINSTANCE.getFacetQueryContext_Dimensions();

		/**
		 * The meta object literal for the '<em><b>Max Result Per Category</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FACET_QUERY_CONTEXT__MAX_RESULT_PER_CATEGORY = eINSTANCE.getFacetQueryContext_MaxResultPerCategory();

		/**
		 * The meta object literal for the '{@link org.gecko.searchresult.impl.FacetResultImpl <em>Facet Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchresult.impl.FacetResultImpl
		 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getFacetResult()
		 * @generated
		 */
		EClass FACET_RESULT = eINSTANCE.getFacetResult();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FACET_RESULT__KEY = eINSTANCE.getFacetResult_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FACET_RESULT__VALUE = eINSTANCE.getFacetResult_Value();

		/**
		 * The meta object literal for the '<em><b>Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FACET_RESULT__COUNT = eINSTANCE.getFacetResult_Count();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FACET_RESULT__CHILDREN = eINSTANCE.getFacetResult_Children();

		/**
		 * The meta object literal for the '{@link org.gecko.searchresult.impl.JoinQueryImpl <em>Join Query</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchresult.impl.JoinQueryImpl
		 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getJoinQuery()
		 * @generated
		 */
		EClass JOIN_QUERY = eINSTANCE.getJoinQuery();

		/**
		 * The meta object literal for the '<em><b>Index Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOIN_QUERY__INDEX_PATH = eINSTANCE.getJoinQuery_IndexPath();

		/**
		 * The meta object literal for the '<em><b>From Field</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOIN_QUERY__FROM_FIELD = eINSTANCE.getJoinQuery_FromField();

		/**
		 * The meta object literal for the '<em><b>To Field</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOIN_QUERY__TO_FIELD = eINSTANCE.getJoinQuery_ToField();

		/**
		 * The meta object literal for the '<em><b>Score Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOIN_QUERY__SCORE_MODE = eINSTANCE.getJoinQuery_ScoreMode();

		/**
		 * The meta object literal for the '<em><b>Query Object</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOIN_QUERY__QUERY_OBJECT = eINSTANCE.getJoinQuery_QueryObject();

		/**
		 * The meta object literal for the '<em><b>Join Aftermath Collectors</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOIN_QUERY__JOIN_AFTERMATH_COLLECTORS = eINSTANCE.getJoinQuery_JoinAftermathCollectors();

		/**
		 * The meta object literal for the '<em><b>Occur</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOIN_QUERY__OCCUR = eINSTANCE.getJoinQuery_Occur();

		/**
		 * The meta object literal for the '{@link org.gecko.searchresult.impl.SpatialSortFieldImpl <em>Spatial Sort Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchresult.impl.SpatialSortFieldImpl
		 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getSpatialSortField()
		 * @generated
		 */
		EClass SPATIAL_SORT_FIELD = eINSTANCE.getSpatialSortField();

		/**
		 * The meta object literal for the '<em><b>Lat Lng</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPATIAL_SORT_FIELD__LAT_LNG = eINSTANCE.getSpatialSortField_LatLng();

		/**
		 * The meta object literal for the '{@link org.gecko.searchresult.impl.GroupingContextImpl <em>Grouping Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchresult.impl.GroupingContextImpl
		 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getGroupingContext()
		 * @generated
		 */
		EClass GROUPING_CONTEXT = eINSTANCE.getGroupingContext();

		/**
		 * The meta object literal for the '<em><b>Max Groups</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GROUPING_CONTEXT__MAX_GROUPS = eINSTANCE.getGroupingContext_MaxGroups();

		/**
		 * The meta object literal for the '<em><b>Off Set</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GROUPING_CONTEXT__OFF_SET = eINSTANCE.getGroupingContext_OffSet();

		/**
		 * The meta object literal for the '<em><b>Group Field Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GROUPING_CONTEXT__GROUP_FIELD_NAME = eINSTANCE.getGroupingContext_GroupFieldName();

		/**
		 * The meta object literal for the '<em><b>Results Per Group</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GROUPING_CONTEXT__RESULTS_PER_GROUP = eINSTANCE.getGroupingContext_ResultsPerGroup();

		/**
		 * The meta object literal for the '<em><b>Cach Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GROUPING_CONTEXT__CACH_SIZE = eINSTANCE.getGroupingContext_CachSize();

		/**
		 * The meta object literal for the '<em><b>Group Sort</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GROUPING_CONTEXT__GROUP_SORT = eINSTANCE.getGroupingContext_GroupSort();

		/**
		 * The meta object literal for the '{@link org.gecko.searchresult.impl.SpatialFieldImpl <em>Spatial Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchresult.impl.SpatialFieldImpl
		 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getSpatialField()
		 * @generated
		 */
		EClass SPATIAL_FIELD = eINSTANCE.getSpatialField();

		/**
		 * The meta object literal for the '<em><b>Lat Lng</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPATIAL_FIELD__LAT_LNG = eINSTANCE.getSpatialField_LatLng();

		/**
		 * The meta object literal for the '<em><b>Distance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPATIAL_FIELD__DISTANCE = eINSTANCE.getSpatialField_Distance();

		/**
		 * The meta object literal for the '{@link org.gecko.searchresult.impl.SpanTermFieldImpl <em>Span Term Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchresult.impl.SpanTermFieldImpl
		 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getSpanTermField()
		 * @generated
		 */
		EClass SPAN_TERM_FIELD = eINSTANCE.getSpanTermField();

		/**
		 * The meta object literal for the '<em><b>Tokens</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPAN_TERM_FIELD__TOKENS = eINSTANCE.getSpanTermField_Tokens();

		/**
		 * The meta object literal for the '<em><b>Span</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPAN_TERM_FIELD__SPAN = eINSTANCE.getSpanTermField_Span();

		/**
		 * The meta object literal for the '{@link org.gecko.searchresult.impl.BooleanQueryImpl <em>Boolean Query</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchresult.impl.BooleanQueryImpl
		 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getBooleanQuery()
		 * @generated
		 */
		EClass BOOLEAN_QUERY = eINSTANCE.getBooleanQuery();

		/**
		 * The meta object literal for the '<em><b>Clauses</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOLEAN_QUERY__CLAUSES = eINSTANCE.getBooleanQuery_Clauses();

		/**
		 * The meta object literal for the '{@link org.gecko.searchresult.impl.LuceneQueryFieldImpl <em>Lucene Query Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchresult.impl.LuceneQueryFieldImpl
		 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getLuceneQueryField()
		 * @generated
		 */
		EClass LUCENE_QUERY_FIELD = eINSTANCE.getLuceneQueryField();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LUCENE_QUERY_FIELD__KEY = eINSTANCE.getLuceneQueryField_Key();

		/**
		 * The meta object literal for the '<em><b>Analyzed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LUCENE_QUERY_FIELD__ANALYZED = eINSTANCE.getLuceneQueryField_Analyzed();

		/**
		 * The meta object literal for the '{@link org.gecko.searchresult.impl.BoostableFieldImpl <em>Boostable Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchresult.impl.BoostableFieldImpl
		 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getBoostableField()
		 * @generated
		 */
		EClass BOOSTABLE_FIELD = eINSTANCE.getBoostableField();

		/**
		 * The meta object literal for the '<em><b>Boost</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOSTABLE_FIELD__BOOST = eINSTANCE.getBoostableField_Boost();

		/**
		 * The meta object literal for the '{@link org.gecko.searchresult.impl.BooleanClauseImpl <em>Boolean Clause</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchresult.impl.BooleanClauseImpl
		 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getBooleanClause()
		 * @generated
		 */
		EClass BOOLEAN_CLAUSE = eINSTANCE.getBooleanClause();

		/**
		 * The meta object literal for the '<em><b>Occur</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_CLAUSE__OCCUR = eINSTANCE.getBooleanClause_Occur();

		/**
		 * The meta object literal for the '<em><b>Query</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOLEAN_CLAUSE__QUERY = eINSTANCE.getBooleanClause_Query();

		/**
		 * The meta object literal for the '{@link org.gecko.searchresult.impl.NumericRangeQueryImpl <em>Numeric Range Query</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchresult.impl.NumericRangeQueryImpl
		 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getNumericRangeQuery()
		 * @generated
		 */
		EClass NUMERIC_RANGE_QUERY = eINSTANCE.getNumericRangeQuery();

		/**
		 * The meta object literal for the '<em><b>Precision Step</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMERIC_RANGE_QUERY__PRECISION_STEP = eINSTANCE.getNumericRangeQuery_PrecisionStep();

		/**
		 * The meta object literal for the '<em><b>Min Inclusive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMERIC_RANGE_QUERY__MIN_INCLUSIVE = eINSTANCE.getNumericRangeQuery_MinInclusive();

		/**
		 * The meta object literal for the '<em><b>Max Inclusive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMERIC_RANGE_QUERY__MAX_INCLUSIVE = eINSTANCE.getNumericRangeQuery_MaxInclusive();

		/**
		 * The meta object literal for the '{@link org.gecko.searchresult.impl.DoubleRangeQueryImpl <em>Double Range Query</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchresult.impl.DoubleRangeQueryImpl
		 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getDoubleRangeQuery()
		 * @generated
		 */
		EClass DOUBLE_RANGE_QUERY = eINSTANCE.getDoubleRangeQuery();

		/**
		 * The meta object literal for the '<em><b>Min Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOUBLE_RANGE_QUERY__MIN_VALUE = eINSTANCE.getDoubleRangeQuery_MinValue();

		/**
		 * The meta object literal for the '<em><b>Max Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOUBLE_RANGE_QUERY__MAX_VALUE = eINSTANCE.getDoubleRangeQuery_MaxValue();

		/**
		 * The meta object literal for the '{@link org.gecko.searchresult.impl.SingleTokenTermQueryImpl <em>Single Token Term Query</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchresult.impl.SingleTokenTermQueryImpl
		 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getSingleTokenTermQuery()
		 * @generated
		 */
		EClass SINGLE_TOKEN_TERM_QUERY = eINSTANCE.getSingleTokenTermQuery();

		/**
		 * The meta object literal for the '<em><b>Token</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SINGLE_TOKEN_TERM_QUERY__TOKEN = eINSTANCE.getSingleTokenTermQuery_Token();

		/**
		 * The meta object literal for the '<em><b>Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SINGLE_TOKEN_TERM_QUERY__PREFIX = eINSTANCE.getSingleTokenTermQuery_Prefix();

		/**
		 * The meta object literal for the '{@link org.gecko.searchresult.impl.SingleTokenFuzzyFieldImpl <em>Single Token Fuzzy Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchresult.impl.SingleTokenFuzzyFieldImpl
		 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getSingleTokenFuzzyField()
		 * @generated
		 */
		EClass SINGLE_TOKEN_FUZZY_FIELD = eINSTANCE.getSingleTokenFuzzyField();

		/**
		 * The meta object literal for the '<em><b>Uppercase</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SINGLE_TOKEN_FUZZY_FIELD__UPPERCASE = eINSTANCE.getSingleTokenFuzzyField_Uppercase();

		/**
		 * The meta object literal for the '<em><b>Max Edits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SINGLE_TOKEN_FUZZY_FIELD__MAX_EDITS = eINSTANCE.getSingleTokenFuzzyField_MaxEdits();

		/**
		 * The meta object literal for the '{@link org.gecko.searchresult.impl.SpanQueryFieldImpl <em>Span Query Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchresult.impl.SpanQueryFieldImpl
		 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getSpanQueryField()
		 * @generated
		 */
		EClass SPAN_QUERY_FIELD = eINSTANCE.getSpanQueryField();

		/**
		 * The meta object literal for the '<em><b>Span</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPAN_QUERY_FIELD__SPAN = eINSTANCE.getSpanQueryField_Span();

		/**
		 * The meta object literal for the '<em><b>Query Fields</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPAN_QUERY_FIELD__QUERY_FIELDS = eINSTANCE.getSpanQueryField_QueryFields();

		/**
		 * The meta object literal for the '{@link org.gecko.searchresult.impl.PhraseQueryImpl <em>Phrase Query</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchresult.impl.PhraseQueryImpl
		 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getPhraseQuery()
		 * @generated
		 */
		EClass PHRASE_QUERY = eINSTANCE.getPhraseQuery();

		/**
		 * The meta object literal for the '<em><b>Slop</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PHRASE_QUERY__SLOP = eINSTANCE.getPhraseQuery_Slop();

		/**
		 * The meta object literal for the '<em><b>Terms</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PHRASE_QUERY__TERMS = eINSTANCE.getPhraseQuery_Terms();

		/**
		 * The meta object literal for the '{@link org.gecko.searchresult.impl.MultiPhraseQueryImpl <em>Multi Phrase Query</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchresult.impl.MultiPhraseQueryImpl
		 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getMultiPhraseQuery()
		 * @generated
		 */
		EClass MULTI_PHRASE_QUERY = eINSTANCE.getMultiPhraseQuery();

		/**
		 * The meta object literal for the '{@link org.gecko.searchresult.FilteringType <em>Filtering Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchresult.FilteringType
		 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getFilteringType()
		 * @generated
		 */
		EEnum FILTERING_TYPE = eINSTANCE.getFilteringType();

		/**
		 * The meta object literal for the '{@link org.gecko.searchresult.SortType <em>Sort Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchresult.SortType
		 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getSortType()
		 * @generated
		 */
		EEnum SORT_TYPE = eINSTANCE.getSortType();

		/**
		 * The meta object literal for the '{@link org.gecko.searchresult.SortDirectionType <em>Sort Direction Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchresult.SortDirectionType
		 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getSortDirectionType()
		 * @generated
		 */
		EEnum SORT_DIRECTION_TYPE = eINSTANCE.getSortDirectionType();

		/**
		 * The meta object literal for the '{@link org.gecko.searchresult.Occur <em>Occur</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchresult.Occur
		 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getOccur()
		 * @generated
		 */
		EEnum OCCUR = eINSTANCE.getOccur();

		/**
		 * The meta object literal for the '{@link org.gecko.searchresult.JoinScoreMode <em>Join Score Mode</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchresult.JoinScoreMode
		 * @see org.gecko.searchresult.impl.SearchResultPackageImpl#getJoinScoreMode()
		 * @generated
		 */
		EEnum JOIN_SCORE_MODE = eINSTANCE.getJoinScoreMode();

	}

} //SearchResultPackage
