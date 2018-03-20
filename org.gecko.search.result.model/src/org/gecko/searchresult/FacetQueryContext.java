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
 * A representation of the model object '<em><b>Facet Query Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchresult.FacetQueryContext#getFacetFields <em>Facet Fields</em>}</li>
 *   <li>{@link org.gecko.searchresult.FacetQueryContext#isCountFacets <em>Count Facets</em>}</li>
 *   <li>{@link org.gecko.searchresult.FacetQueryContext#isFillInCategories <em>Fill In Categories</em>}</li>
 *   <li>{@link org.gecko.searchresult.FacetQueryContext#isAllowDuplicatesInCategories <em>Allow Duplicates In Categories</em>}</li>
 *   <li>{@link org.gecko.searchresult.FacetQueryContext#getMaxFacets <em>Max Facets</em>}</li>
 *   <li>{@link org.gecko.searchresult.FacetQueryContext#getDimensions <em>Dimensions</em>}</li>
 *   <li>{@link org.gecko.searchresult.FacetQueryContext#getMaxResultPerCategory <em>Max Result Per Category</em>}</li>
 * </ul>
 *
 * @see org.gecko.searchresult.SearchResultPackage#getFacetQueryContext()
 * @model
 * @generated
 */
public interface FacetQueryContext extends EObject {
	/**
	 * Returns the value of the '<em><b>Facet Fields</b></em>' reference list.
	 * The list contents are of type {@link org.gecko.searchresult.FacetFilter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facet Fields</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Facet Fields</em>' reference list.
	 * @see org.gecko.searchresult.SearchResultPackage#getFacetQueryContext_FacetFields()
	 * @model
	 * @generated
	 */
	EList<FacetFilter> getFacetFields();

	/**
	 * Returns the value of the '<em><b>Count Facets</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Count Facets</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Count Facets</em>' attribute.
	 * @see #setCountFacets(boolean)
	 * @see org.gecko.searchresult.SearchResultPackage#getFacetQueryContext_CountFacets()
	 * @model
	 * @generated
	 */
	boolean isCountFacets();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.FacetQueryContext#isCountFacets <em>Count Facets</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Count Facets</em>' attribute.
	 * @see #isCountFacets()
	 * @generated
	 */
	void setCountFacets(boolean value);

	/**
	 * Returns the value of the '<em><b>Fill In Categories</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fill In Categories</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fill In Categories</em>' attribute.
	 * @see #setFillInCategories(boolean)
	 * @see org.gecko.searchresult.SearchResultPackage#getFacetQueryContext_FillInCategories()
	 * @model
	 * @generated
	 */
	boolean isFillInCategories();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.FacetQueryContext#isFillInCategories <em>Fill In Categories</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fill In Categories</em>' attribute.
	 * @see #isFillInCategories()
	 * @generated
	 */
	void setFillInCategories(boolean value);

	/**
	 * Returns the value of the '<em><b>Allow Duplicates In Categories</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allow Duplicates In Categories</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allow Duplicates In Categories</em>' attribute.
	 * @see #setAllowDuplicatesInCategories(boolean)
	 * @see org.gecko.searchresult.SearchResultPackage#getFacetQueryContext_AllowDuplicatesInCategories()
	 * @model default="true"
	 * @generated
	 */
	boolean isAllowDuplicatesInCategories();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.FacetQueryContext#isAllowDuplicatesInCategories <em>Allow Duplicates In Categories</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allow Duplicates In Categories</em>' attribute.
	 * @see #isAllowDuplicatesInCategories()
	 * @generated
	 */
	void setAllowDuplicatesInCategories(boolean value);

	/**
	 * Returns the value of the '<em><b>Max Facets</b></em>' attribute.
	 * The default value is <code>"10"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Facets</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Facets</em>' attribute.
	 * @see #setMaxFacets(int)
	 * @see org.gecko.searchresult.SearchResultPackage#getFacetQueryContext_MaxFacets()
	 * @model default="10"
	 * @generated
	 */
	int getMaxFacets();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.FacetQueryContext#getMaxFacets <em>Max Facets</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Facets</em>' attribute.
	 * @see #getMaxFacets()
	 * @generated
	 */
	void setMaxFacets(int value);

	/**
	 * Returns the value of the '<em><b>Dimensions</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dimensions</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dimensions</em>' attribute list.
	 * @see org.gecko.searchresult.SearchResultPackage#getFacetQueryContext_Dimensions()
	 * @model
	 * @generated
	 */
	EList<String> getDimensions();

	/**
	 * Returns the value of the '<em><b>Max Result Per Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Result Per Category</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Result Per Category</em>' attribute.
	 * @see #setMaxResultPerCategory(Integer)
	 * @see org.gecko.searchresult.SearchResultPackage#getFacetQueryContext_MaxResultPerCategory()
	 * @model
	 * @generated
	 */
	Integer getMaxResultPerCategory();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.FacetQueryContext#getMaxResultPerCategory <em>Max Result Per Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Result Per Category</em>' attribute.
	 * @see #getMaxResultPerCategory()
	 * @generated
	 */
	void setMaxResultPerCategory(Integer value);

} // FacetQueryContext
