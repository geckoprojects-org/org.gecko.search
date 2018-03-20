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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.gecko.emf.utilities.UtilPackage;

import org.gecko.searchresult.BooleanClause;
import org.gecko.searchresult.BooleanQuery;
import org.gecko.searchresult.BoostableField;
import org.gecko.searchresult.Category;
import org.gecko.searchresult.DoubleRangeQuery;
import org.gecko.searchresult.FacetFilter;
import org.gecko.searchresult.FacetQueryContext;
import org.gecko.searchresult.FacetResult;
import org.gecko.searchresult.FilterField;
import org.gecko.searchresult.FilteringType;
import org.gecko.searchresult.GroupingContext;
import org.gecko.searchresult.JoinQuery;
import org.gecko.searchresult.JoinScoreMode;
import org.gecko.searchresult.LikeThisObject;
import org.gecko.searchresult.LuceneQueryField;
import org.gecko.searchresult.MatchField;
import org.gecko.searchresult.MatchHighlight;
import org.gecko.searchresult.MatchResult;
import org.gecko.searchresult.MultiPhraseQuery;
import org.gecko.searchresult.MultiTokenFuzzyField;
import org.gecko.searchresult.MultiTokenTermQuery;
import org.gecko.searchresult.NumericRangeQuery;
import org.gecko.searchresult.Occur;
import org.gecko.searchresult.PhraseQuery;
import org.gecko.searchresult.QueryObject;
import org.gecko.searchresult.QueryObjectContainer;
import org.gecko.searchresult.ResultDescriptor;
import org.gecko.searchresult.ResultDescriptorContainer;
import org.gecko.searchresult.ResultField;
import org.gecko.searchresult.SearchResult;
import org.gecko.searchresult.SearchResultFactory;
import org.gecko.searchresult.SearchResultPackage;
import org.gecko.searchresult.SingleTokenFuzzyField;
import org.gecko.searchresult.SingleTokenTermQuery;
import org.gecko.searchresult.SortDirectionType;
import org.gecko.searchresult.SortField;
import org.gecko.searchresult.SortType;
import org.gecko.searchresult.SpanQueryField;
import org.gecko.searchresult.SpanTermField;
import org.gecko.searchresult.SpatialField;
import org.gecko.searchresult.SpatialFilterField;
import org.gecko.searchresult.SpatialSortField;
import org.gecko.searchresult.WildcardField;

import org.gecko.utilities.query.QueryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SearchResultPackageImpl extends EPackageImpl implements SearchResultPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass searchResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass categoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass matchResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass matchHighlightEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass matchFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass queryObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiTokenFuzzyFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass filterFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiTokenTermQueryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass queryObjectContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sortFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass spatialFilterFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wildcardFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resultDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resultFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resultDescriptorContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass likeThisObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass facetFilterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass facetQueryContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass facetResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass joinQueryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass spatialSortFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass groupingContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass spatialFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass spanTermFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanQueryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass luceneQueryFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass boostableFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanClauseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass numericRangeQueryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass doubleRangeQueryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass singleTokenTermQueryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass singleTokenFuzzyFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass spanQueryFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass phraseQueryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiPhraseQueryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum filteringTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum sortTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum sortDirectionTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum occurEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum joinScoreModeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.gecko.searchresult.SearchResultPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SearchResultPackageImpl() {
		super(eNS_URI, SearchResultFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link SearchResultPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SearchResultPackage init() {
		if (isInited) return (SearchResultPackage)EPackage.Registry.INSTANCE.getEPackage(SearchResultPackage.eNS_URI);

		// Obtain or create and register package
		SearchResultPackageImpl theSearchResultPackage = (SearchResultPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SearchResultPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SearchResultPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		QueryPackage.eINSTANCE.eClass();
		UtilPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theSearchResultPackage.createPackageContents();

		// Initialize created meta-data
		theSearchResultPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSearchResultPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SearchResultPackage.eNS_URI, theSearchResultPackage);
		return theSearchResultPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSearchResult() {
		return searchResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSearchResult_Id() {
		return (EAttribute)searchResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSearchResult_Categories() {
		return (EReference)searchResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSearchResult_CategorySize() {
		return (EAttribute)searchResultEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSearchResult_AllMatchResultSize() {
		return (EAttribute)searchResultEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSearchResult_NativeResult() {
		return (EAttribute)searchResultEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSearchResult_FacetResults() {
		return (EReference)searchResultEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSearchResult_NativeCollectorResults() {
		return (EAttribute)searchResultEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSearchResult_NativeJoinCollectorResults() {
		return (EAttribute)searchResultEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSearchResult_NumberPages() {
		return (EAttribute)searchResultEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSearchResult_PageSize() {
		return (EAttribute)searchResultEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCategory() {
		return categoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCategory_Id() {
		return (EAttribute)categoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCategory_Results() {
		return (EReference)categoryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCategory_Name() {
		return (EAttribute)categoryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCategory_MatchResultSize() {
		return (EAttribute)categoryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMatchResult() {
		return matchResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMatchResult_Id() {
		return (EAttribute)matchResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMatchResult_Highlights() {
		return (EReference)matchResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMatchResult_Fields() {
		return (EReference)matchResultEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMatchResult_Score() {
		return (EAttribute)matchResultEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMatchResult_Explanation() {
		return (EAttribute)matchResultEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMatchResult__GetMatchFieldById__String() {
		return matchResultEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMatchHighlight() {
		return matchHighlightEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMatchHighlight_StartOffset() {
		return (EAttribute)matchHighlightEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMatchHighlight_EndOffset() {
		return (EAttribute)matchHighlightEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMatchHighlight_Text() {
		return (EAttribute)matchHighlightEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMatchHighlight_HighlightedText() {
		return (EAttribute)matchHighlightEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMatchField() {
		return matchFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMatchField_Id() {
		return (EAttribute)matchFieldEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMatchField_Feature() {
		return (EReference)matchFieldEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMatchField_Converter() {
		return (EReference)matchFieldEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMatchField_MultiValue() {
		return (EAttribute)matchFieldEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMatchField_Value() {
		return (EAttribute)matchFieldEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMatchField_Highlighting() {
		return (EReference)matchFieldEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQueryObject() {
		return queryObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQueryObject_NativeQuery() {
		return (EAttribute)queryObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQueryObject_IndexPath() {
		return (EAttribute)queryObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQueryObject_MaxResults() {
		return (EAttribute)queryObjectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQueryObject_FilterFields() {
		return (EReference)queryObjectEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQueryObject_SortFields() {
		return (EReference)queryObjectEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQueryObject_NativeObject() {
		return (EAttribute)queryObjectEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQueryObject_SpatialFilterField() {
		return (EReference)queryObjectEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQueryObject_HighlightFields() {
		return (EAttribute)queryObjectEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQueryObject_LikeThisObject() {
		return (EReference)queryObjectEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQueryObject_AnalyzerId() {
		return (EAttribute)queryObjectEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQueryObject_FacetQueryContext() {
		return (EReference)queryObjectEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQueryObject_NativeCollectors() {
		return (EAttribute)queryObjectEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQueryObject_RunCollectorExclusive() {
		return (EAttribute)queryObjectEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQueryObject_JoinQuery() {
		return (EReference)queryObjectEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQueryObject_GroupingContext() {
		return (EReference)queryObjectEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQueryObject_NativeQueryOccur() {
		return (EAttribute)queryObjectEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQueryObject_Explain() {
		return (EAttribute)queryObjectEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQueryObject_PageIndex() {
		return (EAttribute)queryObjectEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQueryObject_PageResultSize() {
		return (EAttribute)queryObjectEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiTokenFuzzyField() {
		return multiTokenFuzzyFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiTokenFuzzyField_Uppercase() {
		return (EAttribute)multiTokenFuzzyFieldEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiTokenFuzzyField_MaxEdits() {
		return (EAttribute)multiTokenFuzzyFieldEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFilterField() {
		return filterFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFilterField_Key() {
		return (EAttribute)filterFieldEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFilterField_Tokens() {
		return (EAttribute)filterFieldEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFilterField_Type() {
		return (EAttribute)filterFieldEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFilterField_Prefix() {
		return (EAttribute)filterFieldEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFilterField_Occur() {
		return (EAttribute)filterFieldEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFilterField_TokensOccur() {
		return (EAttribute)filterFieldEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiTokenTermQuery() {
		return multiTokenTermQueryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiTokenTermQuery_Tokens() {
		return (EAttribute)multiTokenTermQueryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiTokenTermQuery_Prefix() {
		return (EAttribute)multiTokenTermQueryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiTokenTermQuery_TokensOccur() {
		return (EAttribute)multiTokenTermQueryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQueryObjectContainer() {
		return queryObjectContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQueryObjectContainer_Queries() {
		return (EReference)queryObjectContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQueryObjectContainer_ActiveQueries() {
		return (EReference)queryObjectContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSortField() {
		return sortFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSortField_Key() {
		return (EAttribute)sortFieldEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSortField_Tokens() {
		return (EAttribute)sortFieldEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSortField_Type() {
		return (EAttribute)sortFieldEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSortField_Direction() {
		return (EAttribute)sortFieldEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSortField_Occur() {
		return (EAttribute)sortFieldEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSpatialFilterField() {
		return spatialFilterFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWildcardField() {
		return wildcardFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWildcardField_StartWithWildcard() {
		return (EAttribute)wildcardFieldEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWildcardField_EndWithWildcard() {
		return (EAttribute)wildcardFieldEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWildcardField_IncludeUpperCase() {
		return (EAttribute)wildcardFieldEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResultDescriptor() {
		return resultDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResultDescriptor_Id() {
		return (EAttribute)resultDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResultDescriptor_Active() {
		return (EAttribute)resultDescriptorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResultDescriptor_IndexId() {
		return (EAttribute)resultDescriptorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResultDescriptor_Fields() {
		return (EReference)resultDescriptorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResultField() {
		return resultFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResultField_Name() {
		return (EAttribute)resultFieldEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResultField_Highlight() {
		return (EAttribute)resultFieldEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResultDescriptorContainer() {
		return resultDescriptorContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResultDescriptorContainer_Descriptors() {
		return (EReference)resultDescriptorContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResultDescriptorContainer_ActiveDescriptors() {
		return (EReference)resultDescriptorContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLikeThisObject() {
		return likeThisObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLikeThisObject_LikeThisFields() {
		return (EAttribute)likeThisObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLikeThisObject_FilterFields() {
		return (EReference)likeThisObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLikeThisObject_SortFields() {
		return (EReference)likeThisObjectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLikeThisObject_FilterSourceObject() {
		return (EAttribute)likeThisObjectEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLikeThisObject_FilterSourceField() {
		return (EAttribute)likeThisObjectEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLikeThisObject_MaxResults() {
		return (EAttribute)likeThisObjectEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFacetFilter() {
		return facetFilterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFacetFilter_FacetKey() {
		return (EAttribute)facetFilterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFacetFilter_Value() {
		return (EAttribute)facetFilterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFacetQueryContext() {
		return facetQueryContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFacetQueryContext_FacetFields() {
		return (EReference)facetQueryContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFacetQueryContext_CountFacets() {
		return (EAttribute)facetQueryContextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFacetQueryContext_FillInCategories() {
		return (EAttribute)facetQueryContextEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFacetQueryContext_AllowDuplicatesInCategories() {
		return (EAttribute)facetQueryContextEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFacetQueryContext_MaxFacets() {
		return (EAttribute)facetQueryContextEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFacetQueryContext_Dimensions() {
		return (EAttribute)facetQueryContextEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFacetQueryContext_MaxResultPerCategory() {
		return (EAttribute)facetQueryContextEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFacetResult() {
		return facetResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFacetResult_Key() {
		return (EAttribute)facetResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFacetResult_Value() {
		return (EAttribute)facetResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFacetResult_Count() {
		return (EAttribute)facetResultEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFacetResult_Children() {
		return (EReference)facetResultEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJoinQuery() {
		return joinQueryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJoinQuery_IndexPath() {
		return (EAttribute)joinQueryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJoinQuery_FromField() {
		return (EAttribute)joinQueryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJoinQuery_ToField() {
		return (EAttribute)joinQueryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJoinQuery_ScoreMode() {
		return (EAttribute)joinQueryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJoinQuery_QueryObject() {
		return (EAttribute)joinQueryEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJoinQuery_JoinAftermathCollectors() {
		return (EAttribute)joinQueryEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJoinQuery_Occur() {
		return (EAttribute)joinQueryEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSpatialSortField() {
		return spatialSortFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpatialSortField_LatLng() {
		return (EReference)spatialSortFieldEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGroupingContext() {
		return groupingContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGroupingContext_MaxGroups() {
		return (EAttribute)groupingContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGroupingContext_OffSet() {
		return (EAttribute)groupingContextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGroupingContext_GroupFieldName() {
		return (EAttribute)groupingContextEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGroupingContext_ResultsPerGroup() {
		return (EAttribute)groupingContextEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGroupingContext_CachSize() {
		return (EAttribute)groupingContextEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGroupingContext_GroupSort() {
		return (EReference)groupingContextEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSpatialField() {
		return spatialFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpatialField_LatLng() {
		return (EReference)spatialFieldEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSpatialField_Distance() {
		return (EAttribute)spatialFieldEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSpanTermField() {
		return spanTermFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSpanTermField_Tokens() {
		return (EAttribute)spanTermFieldEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSpanTermField_Span() {
		return (EAttribute)spanTermFieldEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanQuery() {
		return booleanQueryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBooleanQuery_Clauses() {
		return (EReference)booleanQueryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLuceneQueryField() {
		return luceneQueryFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLuceneQueryField_Key() {
		return (EAttribute)luceneQueryFieldEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLuceneQueryField_Analyzed() {
		return (EAttribute)luceneQueryFieldEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBoostableField() {
		return boostableFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBoostableField_Boost() {
		return (EAttribute)boostableFieldEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanClause() {
		return booleanClauseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBooleanClause_Occur() {
		return (EAttribute)booleanClauseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBooleanClause_Query() {
		return (EReference)booleanClauseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNumericRangeQuery() {
		return numericRangeQueryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNumericRangeQuery_PrecisionStep() {
		return (EAttribute)numericRangeQueryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNumericRangeQuery_MinInclusive() {
		return (EAttribute)numericRangeQueryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNumericRangeQuery_MaxInclusive() {
		return (EAttribute)numericRangeQueryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDoubleRangeQuery() {
		return doubleRangeQueryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDoubleRangeQuery_MinValue() {
		return (EAttribute)doubleRangeQueryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDoubleRangeQuery_MaxValue() {
		return (EAttribute)doubleRangeQueryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSingleTokenTermQuery() {
		return singleTokenTermQueryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSingleTokenTermQuery_Token() {
		return (EAttribute)singleTokenTermQueryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSingleTokenTermQuery_Prefix() {
		return (EAttribute)singleTokenTermQueryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSingleTokenFuzzyField() {
		return singleTokenFuzzyFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSingleTokenFuzzyField_Uppercase() {
		return (EAttribute)singleTokenFuzzyFieldEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSingleTokenFuzzyField_MaxEdits() {
		return (EAttribute)singleTokenFuzzyFieldEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSpanQueryField() {
		return spanQueryFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSpanQueryField_Span() {
		return (EAttribute)spanQueryFieldEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpanQueryField_QueryFields() {
		return (EReference)spanQueryFieldEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPhraseQuery() {
		return phraseQueryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPhraseQuery_Slop() {
		return (EAttribute)phraseQueryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPhraseQuery_Terms() {
		return (EAttribute)phraseQueryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiPhraseQuery() {
		return multiPhraseQueryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFilteringType() {
		return filteringTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSortType() {
		return sortTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSortDirectionType() {
		return sortDirectionTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getOccur() {
		return occurEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getJoinScoreMode() {
		return joinScoreModeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SearchResultFactory getSearchResultFactory() {
		return (SearchResultFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		searchResultEClass = createEClass(SEARCH_RESULT);
		createEAttribute(searchResultEClass, SEARCH_RESULT__ID);
		createEReference(searchResultEClass, SEARCH_RESULT__CATEGORIES);
		createEAttribute(searchResultEClass, SEARCH_RESULT__CATEGORY_SIZE);
		createEAttribute(searchResultEClass, SEARCH_RESULT__ALL_MATCH_RESULT_SIZE);
		createEAttribute(searchResultEClass, SEARCH_RESULT__NATIVE_RESULT);
		createEReference(searchResultEClass, SEARCH_RESULT__FACET_RESULTS);
		createEAttribute(searchResultEClass, SEARCH_RESULT__NATIVE_COLLECTOR_RESULTS);
		createEAttribute(searchResultEClass, SEARCH_RESULT__NATIVE_JOIN_COLLECTOR_RESULTS);
		createEAttribute(searchResultEClass, SEARCH_RESULT__NUMBER_PAGES);
		createEAttribute(searchResultEClass, SEARCH_RESULT__PAGE_SIZE);

		categoryEClass = createEClass(CATEGORY);
		createEAttribute(categoryEClass, CATEGORY__ID);
		createEReference(categoryEClass, CATEGORY__RESULTS);
		createEAttribute(categoryEClass, CATEGORY__NAME);
		createEAttribute(categoryEClass, CATEGORY__MATCH_RESULT_SIZE);

		matchResultEClass = createEClass(MATCH_RESULT);
		createEAttribute(matchResultEClass, MATCH_RESULT__ID);
		createEReference(matchResultEClass, MATCH_RESULT__HIGHLIGHTS);
		createEReference(matchResultEClass, MATCH_RESULT__FIELDS);
		createEAttribute(matchResultEClass, MATCH_RESULT__SCORE);
		createEAttribute(matchResultEClass, MATCH_RESULT__EXPLANATION);
		createEOperation(matchResultEClass, MATCH_RESULT___GET_MATCH_FIELD_BY_ID__STRING);

		matchHighlightEClass = createEClass(MATCH_HIGHLIGHT);
		createEAttribute(matchHighlightEClass, MATCH_HIGHLIGHT__START_OFFSET);
		createEAttribute(matchHighlightEClass, MATCH_HIGHLIGHT__END_OFFSET);
		createEAttribute(matchHighlightEClass, MATCH_HIGHLIGHT__TEXT);
		createEAttribute(matchHighlightEClass, MATCH_HIGHLIGHT__HIGHLIGHTED_TEXT);

		matchFieldEClass = createEClass(MATCH_FIELD);
		createEAttribute(matchFieldEClass, MATCH_FIELD__ID);
		createEReference(matchFieldEClass, MATCH_FIELD__FEATURE);
		createEReference(matchFieldEClass, MATCH_FIELD__CONVERTER);
		createEAttribute(matchFieldEClass, MATCH_FIELD__MULTI_VALUE);
		createEAttribute(matchFieldEClass, MATCH_FIELD__VALUE);
		createEReference(matchFieldEClass, MATCH_FIELD__HIGHLIGHTING);

		queryObjectEClass = createEClass(QUERY_OBJECT);
		createEAttribute(queryObjectEClass, QUERY_OBJECT__NATIVE_QUERY);
		createEAttribute(queryObjectEClass, QUERY_OBJECT__INDEX_PATH);
		createEAttribute(queryObjectEClass, QUERY_OBJECT__MAX_RESULTS);
		createEReference(queryObjectEClass, QUERY_OBJECT__FILTER_FIELDS);
		createEReference(queryObjectEClass, QUERY_OBJECT__SORT_FIELDS);
		createEAttribute(queryObjectEClass, QUERY_OBJECT__NATIVE_OBJECT);
		createEReference(queryObjectEClass, QUERY_OBJECT__SPATIAL_FILTER_FIELD);
		createEAttribute(queryObjectEClass, QUERY_OBJECT__HIGHLIGHT_FIELDS);
		createEReference(queryObjectEClass, QUERY_OBJECT__LIKE_THIS_OBJECT);
		createEAttribute(queryObjectEClass, QUERY_OBJECT__ANALYZER_ID);
		createEReference(queryObjectEClass, QUERY_OBJECT__FACET_QUERY_CONTEXT);
		createEAttribute(queryObjectEClass, QUERY_OBJECT__NATIVE_COLLECTORS);
		createEAttribute(queryObjectEClass, QUERY_OBJECT__RUN_COLLECTOR_EXCLUSIVE);
		createEReference(queryObjectEClass, QUERY_OBJECT__JOIN_QUERY);
		createEReference(queryObjectEClass, QUERY_OBJECT__GROUPING_CONTEXT);
		createEAttribute(queryObjectEClass, QUERY_OBJECT__NATIVE_QUERY_OCCUR);
		createEAttribute(queryObjectEClass, QUERY_OBJECT__EXPLAIN);
		createEAttribute(queryObjectEClass, QUERY_OBJECT__PAGE_INDEX);
		createEAttribute(queryObjectEClass, QUERY_OBJECT__PAGE_RESULT_SIZE);

		multiTokenFuzzyFieldEClass = createEClass(MULTI_TOKEN_FUZZY_FIELD);
		createEAttribute(multiTokenFuzzyFieldEClass, MULTI_TOKEN_FUZZY_FIELD__UPPERCASE);
		createEAttribute(multiTokenFuzzyFieldEClass, MULTI_TOKEN_FUZZY_FIELD__MAX_EDITS);

		filterFieldEClass = createEClass(FILTER_FIELD);
		createEAttribute(filterFieldEClass, FILTER_FIELD__KEY);
		createEAttribute(filterFieldEClass, FILTER_FIELD__TOKENS);
		createEAttribute(filterFieldEClass, FILTER_FIELD__TYPE);
		createEAttribute(filterFieldEClass, FILTER_FIELD__PREFIX);
		createEAttribute(filterFieldEClass, FILTER_FIELD__OCCUR);
		createEAttribute(filterFieldEClass, FILTER_FIELD__TOKENS_OCCUR);

		multiTokenTermQueryEClass = createEClass(MULTI_TOKEN_TERM_QUERY);
		createEAttribute(multiTokenTermQueryEClass, MULTI_TOKEN_TERM_QUERY__TOKENS);
		createEAttribute(multiTokenTermQueryEClass, MULTI_TOKEN_TERM_QUERY__PREFIX);
		createEAttribute(multiTokenTermQueryEClass, MULTI_TOKEN_TERM_QUERY__TOKENS_OCCUR);

		queryObjectContainerEClass = createEClass(QUERY_OBJECT_CONTAINER);
		createEReference(queryObjectContainerEClass, QUERY_OBJECT_CONTAINER__QUERIES);
		createEReference(queryObjectContainerEClass, QUERY_OBJECT_CONTAINER__ACTIVE_QUERIES);

		sortFieldEClass = createEClass(SORT_FIELD);
		createEAttribute(sortFieldEClass, SORT_FIELD__KEY);
		createEAttribute(sortFieldEClass, SORT_FIELD__TOKENS);
		createEAttribute(sortFieldEClass, SORT_FIELD__TYPE);
		createEAttribute(sortFieldEClass, SORT_FIELD__DIRECTION);
		createEAttribute(sortFieldEClass, SORT_FIELD__OCCUR);

		spatialFilterFieldEClass = createEClass(SPATIAL_FILTER_FIELD);

		wildcardFieldEClass = createEClass(WILDCARD_FIELD);
		createEAttribute(wildcardFieldEClass, WILDCARD_FIELD__START_WITH_WILDCARD);
		createEAttribute(wildcardFieldEClass, WILDCARD_FIELD__END_WITH_WILDCARD);
		createEAttribute(wildcardFieldEClass, WILDCARD_FIELD__INCLUDE_UPPER_CASE);

		resultDescriptorEClass = createEClass(RESULT_DESCRIPTOR);
		createEAttribute(resultDescriptorEClass, RESULT_DESCRIPTOR__ID);
		createEAttribute(resultDescriptorEClass, RESULT_DESCRIPTOR__ACTIVE);
		createEAttribute(resultDescriptorEClass, RESULT_DESCRIPTOR__INDEX_ID);
		createEReference(resultDescriptorEClass, RESULT_DESCRIPTOR__FIELDS);

		resultFieldEClass = createEClass(RESULT_FIELD);
		createEAttribute(resultFieldEClass, RESULT_FIELD__NAME);
		createEAttribute(resultFieldEClass, RESULT_FIELD__HIGHLIGHT);

		resultDescriptorContainerEClass = createEClass(RESULT_DESCRIPTOR_CONTAINER);
		createEReference(resultDescriptorContainerEClass, RESULT_DESCRIPTOR_CONTAINER__DESCRIPTORS);
		createEReference(resultDescriptorContainerEClass, RESULT_DESCRIPTOR_CONTAINER__ACTIVE_DESCRIPTORS);

		likeThisObjectEClass = createEClass(LIKE_THIS_OBJECT);
		createEAttribute(likeThisObjectEClass, LIKE_THIS_OBJECT__LIKE_THIS_FIELDS);
		createEReference(likeThisObjectEClass, LIKE_THIS_OBJECT__FILTER_FIELDS);
		createEReference(likeThisObjectEClass, LIKE_THIS_OBJECT__SORT_FIELDS);
		createEAttribute(likeThisObjectEClass, LIKE_THIS_OBJECT__FILTER_SOURCE_OBJECT);
		createEAttribute(likeThisObjectEClass, LIKE_THIS_OBJECT__FILTER_SOURCE_FIELD);
		createEAttribute(likeThisObjectEClass, LIKE_THIS_OBJECT__MAX_RESULTS);

		facetFilterEClass = createEClass(FACET_FILTER);
		createEAttribute(facetFilterEClass, FACET_FILTER__FACET_KEY);
		createEAttribute(facetFilterEClass, FACET_FILTER__VALUE);

		facetQueryContextEClass = createEClass(FACET_QUERY_CONTEXT);
		createEReference(facetQueryContextEClass, FACET_QUERY_CONTEXT__FACET_FIELDS);
		createEAttribute(facetQueryContextEClass, FACET_QUERY_CONTEXT__COUNT_FACETS);
		createEAttribute(facetQueryContextEClass, FACET_QUERY_CONTEXT__FILL_IN_CATEGORIES);
		createEAttribute(facetQueryContextEClass, FACET_QUERY_CONTEXT__ALLOW_DUPLICATES_IN_CATEGORIES);
		createEAttribute(facetQueryContextEClass, FACET_QUERY_CONTEXT__MAX_FACETS);
		createEAttribute(facetQueryContextEClass, FACET_QUERY_CONTEXT__DIMENSIONS);
		createEAttribute(facetQueryContextEClass, FACET_QUERY_CONTEXT__MAX_RESULT_PER_CATEGORY);

		facetResultEClass = createEClass(FACET_RESULT);
		createEAttribute(facetResultEClass, FACET_RESULT__KEY);
		createEAttribute(facetResultEClass, FACET_RESULT__VALUE);
		createEAttribute(facetResultEClass, FACET_RESULT__COUNT);
		createEReference(facetResultEClass, FACET_RESULT__CHILDREN);

		joinQueryEClass = createEClass(JOIN_QUERY);
		createEAttribute(joinQueryEClass, JOIN_QUERY__INDEX_PATH);
		createEAttribute(joinQueryEClass, JOIN_QUERY__FROM_FIELD);
		createEAttribute(joinQueryEClass, JOIN_QUERY__TO_FIELD);
		createEAttribute(joinQueryEClass, JOIN_QUERY__SCORE_MODE);
		createEAttribute(joinQueryEClass, JOIN_QUERY__QUERY_OBJECT);
		createEAttribute(joinQueryEClass, JOIN_QUERY__JOIN_AFTERMATH_COLLECTORS);
		createEAttribute(joinQueryEClass, JOIN_QUERY__OCCUR);

		spatialSortFieldEClass = createEClass(SPATIAL_SORT_FIELD);
		createEReference(spatialSortFieldEClass, SPATIAL_SORT_FIELD__LAT_LNG);

		groupingContextEClass = createEClass(GROUPING_CONTEXT);
		createEAttribute(groupingContextEClass, GROUPING_CONTEXT__MAX_GROUPS);
		createEAttribute(groupingContextEClass, GROUPING_CONTEXT__OFF_SET);
		createEAttribute(groupingContextEClass, GROUPING_CONTEXT__GROUP_FIELD_NAME);
		createEAttribute(groupingContextEClass, GROUPING_CONTEXT__RESULTS_PER_GROUP);
		createEAttribute(groupingContextEClass, GROUPING_CONTEXT__CACH_SIZE);
		createEReference(groupingContextEClass, GROUPING_CONTEXT__GROUP_SORT);

		spatialFieldEClass = createEClass(SPATIAL_FIELD);
		createEReference(spatialFieldEClass, SPATIAL_FIELD__LAT_LNG);
		createEAttribute(spatialFieldEClass, SPATIAL_FIELD__DISTANCE);

		spanTermFieldEClass = createEClass(SPAN_TERM_FIELD);
		createEAttribute(spanTermFieldEClass, SPAN_TERM_FIELD__TOKENS);
		createEAttribute(spanTermFieldEClass, SPAN_TERM_FIELD__SPAN);

		booleanQueryEClass = createEClass(BOOLEAN_QUERY);
		createEReference(booleanQueryEClass, BOOLEAN_QUERY__CLAUSES);

		luceneQueryFieldEClass = createEClass(LUCENE_QUERY_FIELD);
		createEAttribute(luceneQueryFieldEClass, LUCENE_QUERY_FIELD__KEY);
		createEAttribute(luceneQueryFieldEClass, LUCENE_QUERY_FIELD__ANALYZED);

		boostableFieldEClass = createEClass(BOOSTABLE_FIELD);
		createEAttribute(boostableFieldEClass, BOOSTABLE_FIELD__BOOST);

		booleanClauseEClass = createEClass(BOOLEAN_CLAUSE);
		createEAttribute(booleanClauseEClass, BOOLEAN_CLAUSE__OCCUR);
		createEReference(booleanClauseEClass, BOOLEAN_CLAUSE__QUERY);

		numericRangeQueryEClass = createEClass(NUMERIC_RANGE_QUERY);
		createEAttribute(numericRangeQueryEClass, NUMERIC_RANGE_QUERY__PRECISION_STEP);
		createEAttribute(numericRangeQueryEClass, NUMERIC_RANGE_QUERY__MIN_INCLUSIVE);
		createEAttribute(numericRangeQueryEClass, NUMERIC_RANGE_QUERY__MAX_INCLUSIVE);

		doubleRangeQueryEClass = createEClass(DOUBLE_RANGE_QUERY);
		createEAttribute(doubleRangeQueryEClass, DOUBLE_RANGE_QUERY__MIN_VALUE);
		createEAttribute(doubleRangeQueryEClass, DOUBLE_RANGE_QUERY__MAX_VALUE);

		singleTokenTermQueryEClass = createEClass(SINGLE_TOKEN_TERM_QUERY);
		createEAttribute(singleTokenTermQueryEClass, SINGLE_TOKEN_TERM_QUERY__TOKEN);
		createEAttribute(singleTokenTermQueryEClass, SINGLE_TOKEN_TERM_QUERY__PREFIX);

		singleTokenFuzzyFieldEClass = createEClass(SINGLE_TOKEN_FUZZY_FIELD);
		createEAttribute(singleTokenFuzzyFieldEClass, SINGLE_TOKEN_FUZZY_FIELD__UPPERCASE);
		createEAttribute(singleTokenFuzzyFieldEClass, SINGLE_TOKEN_FUZZY_FIELD__MAX_EDITS);

		spanQueryFieldEClass = createEClass(SPAN_QUERY_FIELD);
		createEAttribute(spanQueryFieldEClass, SPAN_QUERY_FIELD__SPAN);
		createEReference(spanQueryFieldEClass, SPAN_QUERY_FIELD__QUERY_FIELDS);

		phraseQueryEClass = createEClass(PHRASE_QUERY);
		createEAttribute(phraseQueryEClass, PHRASE_QUERY__SLOP);
		createEAttribute(phraseQueryEClass, PHRASE_QUERY__TERMS);

		multiPhraseQueryEClass = createEClass(MULTI_PHRASE_QUERY);

		// Create enums
		filteringTypeEEnum = createEEnum(FILTERING_TYPE);
		sortTypeEEnum = createEEnum(SORT_TYPE);
		sortDirectionTypeEEnum = createEEnum(SORT_DIRECTION_TYPE);
		occurEEnum = createEEnum(OCCUR);
		joinScoreModeEEnum = createEEnum(JOIN_SCORE_MODE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		UtilPackage theUtilPackage = (UtilPackage)EPackage.Registry.INSTANCE.getEPackage(UtilPackage.eNS_URI);
		QueryPackage theQueryPackage = (QueryPackage)EPackage.Registry.INSTANCE.getEPackage(QueryPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		queryObjectEClass.getESuperTypes().add(theQueryPackage.getQuery());
		multiTokenFuzzyFieldEClass.getESuperTypes().add(this.getMultiTokenTermQuery());
		multiTokenTermQueryEClass.getESuperTypes().add(this.getLuceneQueryField());
		spatialFilterFieldEClass.getESuperTypes().add(this.getSpatialField());
		wildcardFieldEClass.getESuperTypes().add(this.getMultiTokenTermQuery());
		spatialSortFieldEClass.getESuperTypes().add(this.getSortField());
		spatialFieldEClass.getESuperTypes().add(this.getLuceneQueryField());
		spanTermFieldEClass.getESuperTypes().add(this.getLuceneQueryField());
		booleanQueryEClass.getESuperTypes().add(this.getBoostableField());
		luceneQueryFieldEClass.getESuperTypes().add(this.getBoostableField());
		boostableFieldEClass.getESuperTypes().add(theQueryPackage.getQueryCondition());
		numericRangeQueryEClass.getESuperTypes().add(this.getLuceneQueryField());
		doubleRangeQueryEClass.getESuperTypes().add(this.getNumericRangeQuery());
		singleTokenTermQueryEClass.getESuperTypes().add(this.getLuceneQueryField());
		singleTokenFuzzyFieldEClass.getESuperTypes().add(this.getSingleTokenTermQuery());
		spanQueryFieldEClass.getESuperTypes().add(this.getLuceneQueryField());
		phraseQueryEClass.getESuperTypes().add(this.getLuceneQueryField());
		multiPhraseQueryEClass.getESuperTypes().add(this.getPhraseQuery());

		// Initialize classes, features, and operations; add parameters
		initEClass(searchResultEClass, SearchResult.class, "SearchResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSearchResult_Id(), ecorePackage.getEString(), "id", null, 1, 1, SearchResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSearchResult_Categories(), this.getCategory(), null, "categories", null, 0, -1, SearchResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getSearchResult_Categories().getEKeys().add(this.getCategory_Id());
		initEAttribute(getSearchResult_CategorySize(), ecorePackage.getEInt(), "categorySize", null, 0, 1, SearchResult.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getSearchResult_AllMatchResultSize(), ecorePackage.getEInt(), "allMatchResultSize", null, 0, 1, SearchResult.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getSearchResult_NativeResult(), ecorePackage.getEJavaObject(), "nativeResult", null, 0, 1, SearchResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSearchResult_FacetResults(), this.getFacetResult(), null, "facetResults", null, 0, -1, SearchResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSearchResult_NativeCollectorResults(), ecorePackage.getEJavaObject(), "nativeCollectorResults", null, 0, -1, SearchResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSearchResult_NativeJoinCollectorResults(), ecorePackage.getEJavaObject(), "nativeJoinCollectorResults", null, 0, -1, SearchResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSearchResult_NumberPages(), ecorePackage.getEIntegerObject(), "numberPages", null, 0, 1, SearchResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSearchResult_PageSize(), ecorePackage.getEIntegerObject(), "pageSize", null, 0, 1, SearchResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(categoryEClass, Category.class, "Category", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCategory_Id(), ecorePackage.getEString(), "id", null, 1, 1, Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCategory_Results(), this.getMatchResult(), null, "results", null, 0, -1, Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCategory_Name(), ecorePackage.getEString(), "name", null, 1, 1, Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCategory_MatchResultSize(), ecorePackage.getEInt(), "matchResultSize", null, 0, 1, Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(matchResultEClass, MatchResult.class, "MatchResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMatchResult_Id(), ecorePackage.getEString(), "id", null, 1, 1, MatchResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMatchResult_Highlights(), this.getMatchHighlight(), null, "highlights", null, 0, -1, MatchResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMatchResult_Fields(), this.getMatchField(), null, "fields", null, 0, -1, MatchResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getMatchResult_Fields().getEKeys().add(this.getMatchField_Id());
		initEAttribute(getMatchResult_Score(), ecorePackage.getEFloat(), "score", null, 0, 1, MatchResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMatchResult_Explanation(), ecorePackage.getEJavaObject(), "explanation", null, 0, 1, MatchResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getMatchResult__GetMatchFieldById__String(), this.getMatchField(), "getMatchFieldById", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "key", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(matchHighlightEClass, MatchHighlight.class, "MatchHighlight", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMatchHighlight_StartOffset(), ecorePackage.getEInt(), "startOffset", null, 1, 1, MatchHighlight.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMatchHighlight_EndOffset(), ecorePackage.getEInt(), "endOffset", null, 1, 1, MatchHighlight.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMatchHighlight_Text(), ecorePackage.getEString(), "text", null, 0, 1, MatchHighlight.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMatchHighlight_HighlightedText(), ecorePackage.getEString(), "highlightedText", null, 0, 1, MatchHighlight.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(matchFieldEClass, MatchField.class, "MatchField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMatchField_Id(), ecorePackage.getEString(), "id", null, 1, 1, MatchField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMatchField_Feature(), theUtilPackage.getFeaturePath(), null, "feature", null, 0, 1, MatchField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMatchField_Converter(), theUtilPackage.getConverter(), null, "converter", null, 0, 1, MatchField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMatchField_MultiValue(), ecorePackage.getEBoolean(), "multiValue", "false", 1, 1, MatchField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMatchField_Value(), ecorePackage.getEJavaObject(), "value", null, 1, 1, MatchField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMatchField_Highlighting(), this.getMatchHighlight(), null, "highlighting", null, 0, -1, MatchField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(queryObjectEClass, QueryObject.class, "QueryObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getQueryObject_NativeQuery(), ecorePackage.getEJavaObject(), "nativeQuery", null, 0, 1, QueryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQueryObject_IndexPath(), ecorePackage.getEString(), "indexPath", null, 1, 1, QueryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQueryObject_MaxResults(), ecorePackage.getEInt(), "maxResults", null, 0, 1, QueryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQueryObject_FilterFields(), this.getFilterField(), null, "filterFields", null, 0, -1, QueryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQueryObject_SortFields(), this.getSortField(), null, "sortFields", null, 0, -1, QueryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQueryObject_NativeObject(), ecorePackage.getEJavaObject(), "nativeObject", null, 0, 1, QueryObject.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQueryObject_SpatialFilterField(), this.getSpatialFilterField(), null, "spatialFilterField", null, 0, 1, QueryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQueryObject_HighlightFields(), ecorePackage.getEString(), "highlightFields", null, 0, -1, QueryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQueryObject_LikeThisObject(), this.getLikeThisObject(), null, "likeThisObject", null, 0, 1, QueryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQueryObject_AnalyzerId(), ecorePackage.getEString(), "analyzerId", "default", 0, 1, QueryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQueryObject_FacetQueryContext(), this.getFacetQueryContext(), null, "facetQueryContext", null, 0, 1, QueryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQueryObject_NativeCollectors(), ecorePackage.getEJavaObject(), "nativeCollectors", null, 0, -1, QueryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQueryObject_RunCollectorExclusive(), ecorePackage.getEBoolean(), "runCollectorExclusive", "true", 0, 1, QueryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQueryObject_JoinQuery(), this.getJoinQuery(), null, "joinQuery", null, 0, 1, QueryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQueryObject_GroupingContext(), this.getGroupingContext(), null, "groupingContext", null, 0, 1, QueryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQueryObject_NativeQueryOccur(), this.getOccur(), "nativeQueryOccur", "MUST", 0, 1, QueryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQueryObject_Explain(), ecorePackage.getEBoolean(), "explain", "false", 0, 1, QueryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQueryObject_PageIndex(), ecorePackage.getEIntegerObject(), "pageIndex", null, 0, 1, QueryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQueryObject_PageResultSize(), ecorePackage.getEIntegerObject(), "pageResultSize", "-1", 0, 1, QueryObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multiTokenFuzzyFieldEClass, MultiTokenFuzzyField.class, "MultiTokenFuzzyField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMultiTokenFuzzyField_Uppercase(), ecorePackage.getEBoolean(), "uppercase", "false", 0, 1, MultiTokenFuzzyField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMultiTokenFuzzyField_MaxEdits(), ecorePackage.getEInt(), "maxEdits", "2", 0, 1, MultiTokenFuzzyField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(filterFieldEClass, FilterField.class, "FilterField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFilterField_Key(), ecorePackage.getEString(), "key", null, 0, 1, FilterField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFilterField_Tokens(), ecorePackage.getEString(), "tokens", null, 0, -1, FilterField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFilterField_Type(), this.getFilteringType(), "type", null, 1, 1, FilterField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFilterField_Prefix(), ecorePackage.getEBoolean(), "prefix", "false", 1, 1, FilterField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFilterField_Occur(), this.getOccur(), "occur", "MUST", 0, 1, FilterField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFilterField_TokensOccur(), this.getOccur(), "tokensOccur", "SHOULD", 0, 1, FilterField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multiTokenTermQueryEClass, MultiTokenTermQuery.class, "MultiTokenTermQuery", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMultiTokenTermQuery_Tokens(), ecorePackage.getEString(), "tokens", null, 1, -1, MultiTokenTermQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMultiTokenTermQuery_Prefix(), ecorePackage.getEBoolean(), "prefix", "false", 1, 1, MultiTokenTermQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMultiTokenTermQuery_TokensOccur(), this.getOccur(), "tokensOccur", null, 0, 1, MultiTokenTermQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(queryObjectContainerEClass, QueryObjectContainer.class, "QueryObjectContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQueryObjectContainer_Queries(), this.getQueryObject(), null, "queries", null, 0, -1, QueryObjectContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQueryObjectContainer_ActiveQueries(), this.getQueryObject(), null, "activeQueries", null, 0, -1, QueryObjectContainer.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(sortFieldEClass, SortField.class, "SortField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSortField_Key(), ecorePackage.getEString(), "key", null, 0, 1, SortField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSortField_Tokens(), ecorePackage.getEString(), "tokens", null, 0, -1, SortField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSortField_Type(), this.getSortType(), "type", null, 1, 1, SortField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSortField_Direction(), this.getSortDirectionType(), "direction", null, 1, 1, SortField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSortField_Occur(), this.getOccur(), "occur", null, 0, 1, SortField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(spatialFilterFieldEClass, SpatialFilterField.class, "SpatialFilterField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(wildcardFieldEClass, WildcardField.class, "WildcardField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWildcardField_StartWithWildcard(), ecorePackage.getEBoolean(), "startWithWildcard", "true", 0, 1, WildcardField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWildcardField_EndWithWildcard(), ecorePackage.getEBoolean(), "endWithWildcard", "true", 0, 1, WildcardField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWildcardField_IncludeUpperCase(), ecorePackage.getEBoolean(), "includeUpperCase", "true", 0, 1, WildcardField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resultDescriptorEClass, ResultDescriptor.class, "ResultDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResultDescriptor_Id(), ecorePackage.getEString(), "id", null, 0, 1, ResultDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResultDescriptor_Active(), ecorePackage.getEBoolean(), "active", "false", 0, 1, ResultDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResultDescriptor_IndexId(), ecorePackage.getEString(), "indexId", null, 0, 1, ResultDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResultDescriptor_Fields(), this.getResultField(), null, "fields", null, 0, -1, ResultDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resultFieldEClass, ResultField.class, "ResultField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResultField_Name(), ecorePackage.getEString(), "name", null, 1, 1, ResultField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResultField_Highlight(), ecorePackage.getEBoolean(), "highlight", "false", 0, 1, ResultField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resultDescriptorContainerEClass, ResultDescriptorContainer.class, "ResultDescriptorContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResultDescriptorContainer_Descriptors(), this.getResultDescriptor(), null, "descriptors", null, 0, -1, ResultDescriptorContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResultDescriptorContainer_ActiveDescriptors(), this.getResultDescriptor(), null, "activeDescriptors", null, 0, -1, ResultDescriptorContainer.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(likeThisObjectEClass, LikeThisObject.class, "LikeThisObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLikeThisObject_LikeThisFields(), ecorePackage.getEString(), "likeThisFields", null, 0, -1, LikeThisObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLikeThisObject_FilterFields(), this.getFilterField(), null, "filterFields", null, 0, -1, LikeThisObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLikeThisObject_SortFields(), this.getSortField(), null, "sortFields", null, 0, -1, LikeThisObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLikeThisObject_FilterSourceObject(), ecorePackage.getEBoolean(), "filterSourceObject", "true", 1, 1, LikeThisObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLikeThisObject_FilterSourceField(), ecorePackage.getEString(), "filterSourceField", null, 0, 1, LikeThisObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLikeThisObject_MaxResults(), ecorePackage.getEInt(), "maxResults", null, 0, 1, LikeThisObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(facetFilterEClass, FacetFilter.class, "FacetFilter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFacetFilter_FacetKey(), ecorePackage.getEString(), "facetKey", null, 0, 1, FacetFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFacetFilter_Value(), ecorePackage.getEString(), "value", null, 0, -1, FacetFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(facetQueryContextEClass, FacetQueryContext.class, "FacetQueryContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFacetQueryContext_FacetFields(), this.getFacetFilter(), null, "facetFields", null, 0, -1, FacetQueryContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFacetQueryContext_CountFacets(), ecorePackage.getEBoolean(), "countFacets", null, 0, 1, FacetQueryContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFacetQueryContext_FillInCategories(), ecorePackage.getEBoolean(), "fillInCategories", null, 0, 1, FacetQueryContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFacetQueryContext_AllowDuplicatesInCategories(), ecorePackage.getEBoolean(), "allowDuplicatesInCategories", "true", 0, 1, FacetQueryContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFacetQueryContext_MaxFacets(), ecorePackage.getEInt(), "maxFacets", "10", 0, 1, FacetQueryContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFacetQueryContext_Dimensions(), ecorePackage.getEString(), "dimensions", null, 0, -1, FacetQueryContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFacetQueryContext_MaxResultPerCategory(), ecorePackage.getEIntegerObject(), "maxResultPerCategory", null, 0, 1, FacetQueryContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(facetResultEClass, FacetResult.class, "FacetResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFacetResult_Key(), ecorePackage.getEString(), "key", null, 0, 1, FacetResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFacetResult_Value(), ecorePackage.getEString(), "value", null, 0, 1, FacetResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFacetResult_Count(), ecorePackage.getEInt(), "count", null, 0, 1, FacetResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFacetResult_Children(), this.getFacetResult(), null, "children", null, 0, -1, FacetResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(joinQueryEClass, JoinQuery.class, "JoinQuery", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJoinQuery_IndexPath(), ecorePackage.getEString(), "indexPath", null, 1, 1, JoinQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJoinQuery_FromField(), ecorePackage.getEString(), "fromField", null, 0, 1, JoinQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJoinQuery_ToField(), ecorePackage.getEString(), "toField", null, 0, 1, JoinQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJoinQuery_ScoreMode(), this.getJoinScoreMode(), "scoreMode", null, 0, 1, JoinQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJoinQuery_QueryObject(), ecorePackage.getEJavaObject(), "queryObject", null, 0, 1, JoinQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJoinQuery_JoinAftermathCollectors(), ecorePackage.getEJavaObject(), "joinAftermathCollectors", null, 0, -1, JoinQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJoinQuery_Occur(), this.getOccur(), "occur", "SHOULD", 0, 1, JoinQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(spatialSortFieldEClass, SpatialSortField.class, "SpatialSortField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSpatialSortField_LatLng(), theUtilPackage.getLatLng(), null, "latLng", null, 0, 1, SpatialSortField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(groupingContextEClass, GroupingContext.class, "GroupingContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGroupingContext_MaxGroups(), ecorePackage.getEInt(), "maxGroups", null, 0, 1, GroupingContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGroupingContext_OffSet(), ecorePackage.getEInt(), "offSet", null, 0, 1, GroupingContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGroupingContext_GroupFieldName(), ecorePackage.getEString(), "groupFieldName", null, 0, 1, GroupingContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGroupingContext_ResultsPerGroup(), ecorePackage.getEInt(), "resultsPerGroup", "0", 0, 1, GroupingContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGroupingContext_CachSize(), ecorePackage.getEDouble(), "cachSize", "4.0", 0, 1, GroupingContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGroupingContext_GroupSort(), this.getSortField(), null, "groupSort", null, 0, -1, GroupingContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(spatialFieldEClass, SpatialField.class, "SpatialField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSpatialField_LatLng(), theUtilPackage.getLatLng(), null, "latLng", null, 0, 1, SpatialField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSpatialField_Distance(), ecorePackage.getEDouble(), "distance", "100", 0, 1, SpatialField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(spanTermFieldEClass, SpanTermField.class, "SpanTermField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSpanTermField_Tokens(), ecorePackage.getEString(), "tokens", null, 0, -1, SpanTermField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSpanTermField_Span(), ecorePackage.getEInt(), "span", "1", 0, 1, SpanTermField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(booleanQueryEClass, BooleanQuery.class, "BooleanQuery", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBooleanQuery_Clauses(), this.getBooleanClause(), null, "clauses", null, 1, -1, BooleanQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(luceneQueryFieldEClass, LuceneQueryField.class, "LuceneQueryField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLuceneQueryField_Key(), ecorePackage.getEString(), "key", null, 0, 1, LuceneQueryField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLuceneQueryField_Analyzed(), ecorePackage.getEBoolean(), "analyzed", "false", 0, 1, LuceneQueryField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(boostableFieldEClass, BoostableField.class, "BoostableField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBoostableField_Boost(), ecorePackage.getEFloat(), "boost", "0.4", 0, 1, BoostableField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(booleanClauseEClass, BooleanClause.class, "BooleanClause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBooleanClause_Occur(), this.getOccur(), "occur", null, 0, 1, BooleanClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBooleanClause_Query(), this.getBoostableField(), null, "query", null, 0, 1, BooleanClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(numericRangeQueryEClass, NumericRangeQuery.class, "NumericRangeQuery", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNumericRangeQuery_PrecisionStep(), ecorePackage.getEInt(), "precisionStep", "4", 0, 1, NumericRangeQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNumericRangeQuery_MinInclusive(), ecorePackage.getEBoolean(), "minInclusive", "true", 0, 1, NumericRangeQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNumericRangeQuery_MaxInclusive(), ecorePackage.getEBoolean(), "maxInclusive", "true", 0, 1, NumericRangeQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(doubleRangeQueryEClass, DoubleRangeQuery.class, "DoubleRangeQuery", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDoubleRangeQuery_MinValue(), ecorePackage.getEDouble(), "minValue", null, 1, 1, DoubleRangeQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDoubleRangeQuery_MaxValue(), ecorePackage.getEDouble(), "maxValue", null, 1, 1, DoubleRangeQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(singleTokenTermQueryEClass, SingleTokenTermQuery.class, "SingleTokenTermQuery", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSingleTokenTermQuery_Token(), ecorePackage.getEString(), "token", null, 1, 1, SingleTokenTermQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSingleTokenTermQuery_Prefix(), ecorePackage.getEBoolean(), "prefix", "false", 1, 1, SingleTokenTermQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(singleTokenFuzzyFieldEClass, SingleTokenFuzzyField.class, "SingleTokenFuzzyField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSingleTokenFuzzyField_Uppercase(), ecorePackage.getEBoolean(), "uppercase", "false", 0, 1, SingleTokenFuzzyField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSingleTokenFuzzyField_MaxEdits(), ecorePackage.getEInt(), "maxEdits", "2", 0, 1, SingleTokenFuzzyField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(spanQueryFieldEClass, SpanQueryField.class, "SpanQueryField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSpanQueryField_Span(), ecorePackage.getEInt(), "span", "1", 0, 1, SpanQueryField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpanQueryField_QueryFields(), this.getLuceneQueryField(), null, "queryFields", null, 1, -1, SpanQueryField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(phraseQueryEClass, PhraseQuery.class, "PhraseQuery", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPhraseQuery_Slop(), ecorePackage.getEInt(), "slop", null, 0, 1, PhraseQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPhraseQuery_Terms(), ecorePackage.getEString(), "terms", null, 1, -1, PhraseQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multiPhraseQueryEClass, MultiPhraseQuery.class, "MultiPhraseQuery", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(filteringTypeEEnum, FilteringType.class, "FilteringType");
		addEEnumLiteral(filteringTypeEEnum, FilteringType.OR);
		addEEnumLiteral(filteringTypeEEnum, FilteringType.AND);

		initEEnum(sortTypeEEnum, SortType.class, "SortType");
		addEEnumLiteral(sortTypeEEnum, SortType.SCORE);
		addEEnumLiteral(sortTypeEEnum, SortType.DOC);
		addEEnumLiteral(sortTypeEEnum, SortType.STRING);
		addEEnumLiteral(sortTypeEEnum, SortType.INT);
		addEEnumLiteral(sortTypeEEnum, SortType.FLOAT);
		addEEnumLiteral(sortTypeEEnum, SortType.LONG);
		addEEnumLiteral(sortTypeEEnum, SortType.DOUBLE);
		addEEnumLiteral(sortTypeEEnum, SortType.CUSTOM);
		addEEnumLiteral(sortTypeEEnum, SortType.STRING_VAL);
		addEEnumLiteral(sortTypeEEnum, SortType.BYTES);
		addEEnumLiteral(sortTypeEEnum, SortType.REWRITABLE);

		initEEnum(sortDirectionTypeEEnum, SortDirectionType.class, "SortDirectionType");
		addEEnumLiteral(sortDirectionTypeEEnum, SortDirectionType.ASCENDING);
		addEEnumLiteral(sortDirectionTypeEEnum, SortDirectionType.DESCENDING);

		initEEnum(occurEEnum, Occur.class, "Occur");
		addEEnumLiteral(occurEEnum, Occur.SHOULD);
		addEEnumLiteral(occurEEnum, Occur.MUST);
		addEEnumLiteral(occurEEnum, Occur.MUST_NOT);

		initEEnum(joinScoreModeEEnum, JoinScoreMode.class, "JoinScoreMode");
		addEEnumLiteral(joinScoreModeEEnum, JoinScoreMode.NONE);
		addEEnumLiteral(joinScoreModeEEnum, JoinScoreMode.AVERAGE);
		addEEnumLiteral(joinScoreModeEEnum, JoinScoreMode.MAX);
		addEEnumLiteral(joinScoreModeEEnum, JoinScoreMode.TOTAL);

		// Create resource
		createResource(eNS_URI);
	}

} //SearchResultPackageImpl
