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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Search Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchresult.SearchResult#getId <em>Id</em>}</li>
 *   <li>{@link org.gecko.searchresult.SearchResult#getCategories <em>Categories</em>}</li>
 *   <li>{@link org.gecko.searchresult.SearchResult#getCategorySize <em>Category Size</em>}</li>
 *   <li>{@link org.gecko.searchresult.SearchResult#getAllMatchResultSize <em>All Match Result Size</em>}</li>
 *   <li>{@link org.gecko.searchresult.SearchResult#getNativeResult <em>Native Result</em>}</li>
 *   <li>{@link org.gecko.searchresult.SearchResult#getFacetResults <em>Facet Results</em>}</li>
 *   <li>{@link org.gecko.searchresult.SearchResult#getNativeCollectorResults <em>Native Collector Results</em>}</li>
 *   <li>{@link org.gecko.searchresult.SearchResult#getNativeJoinCollectorResults <em>Native Join Collector Results</em>}</li>
 *   <li>{@link org.gecko.searchresult.SearchResult#getNumberPages <em>Number Pages</em>}</li>
 *   <li>{@link org.gecko.searchresult.SearchResult#getPageSize <em>Page Size</em>}</li>
 * </ul>
 *
 * @see org.gecko.searchresult.SearchResultPackage#getSearchResult()
 * @model
 * @generated
 */
public interface SearchResult extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.gecko.searchresult.SearchResultPackage#getSearchResult_Id()
	 * @model id="true" required="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.SearchResult#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Categories</b></em>' containment reference list.
	 * The list contents are of type {@link org.gecko.searchresult.Category}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Categories</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Categories</em>' containment reference list.
	 * @see org.gecko.searchresult.SearchResultPackage#getSearchResult_Categories()
	 * @model containment="true" keys="id"
	 * @generated
	 */
	EList<Category> getCategories();

	/**
	 * Returns the value of the '<em><b>Category Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Category Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Category Size</em>' attribute.
	 * @see org.gecko.searchresult.SearchResultPackage#getSearchResult_CategorySize()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	int getCategorySize();

	/**
	 * Returns the value of the '<em><b>All Match Result Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Match Result Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Match Result Size</em>' attribute.
	 * @see org.gecko.searchresult.SearchResultPackage#getSearchResult_AllMatchResultSize()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	int getAllMatchResultSize();

	/**
	 * Returns the value of the '<em><b>Native Result</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Native Result</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Native Result</em>' attribute.
	 * @see #setNativeResult(Object)
	 * @see org.gecko.searchresult.SearchResultPackage#getSearchResult_NativeResult()
	 * @model
	 * @generated
	 */
	Object getNativeResult();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.SearchResult#getNativeResult <em>Native Result</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Native Result</em>' attribute.
	 * @see #getNativeResult()
	 * @generated
	 */
	void setNativeResult(Object value);

	/**
	 * Returns the value of the '<em><b>Facet Results</b></em>' containment reference list.
	 * The list contents are of type {@link org.gecko.searchresult.FacetResult}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facet Results</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Facet Results</em>' containment reference list.
	 * @see org.gecko.searchresult.SearchResultPackage#getSearchResult_FacetResults()
	 * @model containment="true"
	 * @generated
	 */
	EList<FacetResult> getFacetResults();

	/**
	 * Returns the value of the '<em><b>Native Collector Results</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Object}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Native Collector Results</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Native Collector Results</em>' attribute list.
	 * @see org.gecko.searchresult.SearchResultPackage#getSearchResult_NativeCollectorResults()
	 * @model
	 * @generated
	 */
	EList<Object> getNativeCollectorResults();

	/**
	 * Returns the value of the '<em><b>Native Join Collector Results</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Object}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Native Join Collector Results</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Native Join Collector Results</em>' attribute list.
	 * @see org.gecko.searchresult.SearchResultPackage#getSearchResult_NativeJoinCollectorResults()
	 * @model
	 * @generated
	 */
	EList<Object> getNativeJoinCollectorResults();

	/**
	 * Returns the value of the '<em><b>Number Pages</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Pages</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Pages</em>' attribute.
	 * @see #setNumberPages(Integer)
	 * @see org.gecko.searchresult.SearchResultPackage#getSearchResult_NumberPages()
	 * @model
	 * @generated
	 */
	Integer getNumberPages();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.SearchResult#getNumberPages <em>Number Pages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Pages</em>' attribute.
	 * @see #getNumberPages()
	 * @generated
	 */
	void setNumberPages(Integer value);

	/**
	 * Returns the value of the '<em><b>Page Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Page Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Page Size</em>' attribute.
	 * @see #setPageSize(Integer)
	 * @see org.gecko.searchresult.SearchResultPackage#getSearchResult_PageSize()
	 * @model
	 * @generated
	 */
	Integer getPageSize();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.SearchResult#getPageSize <em>Page Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Page Size</em>' attribute.
	 * @see #getPageSize()
	 * @generated
	 */
	void setPageSize(Integer value);

} // SearchResult
