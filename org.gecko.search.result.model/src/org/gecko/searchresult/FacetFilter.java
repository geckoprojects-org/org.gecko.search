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
 * A representation of the model object '<em><b>Facet Filter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchresult.FacetFilter#getFacetKey <em>Facet Key</em>}</li>
 *   <li>{@link org.gecko.searchresult.FacetFilter#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.gecko.searchresult.SearchResultPackage#getFacetFilter()
 * @model
 * @generated
 */
public interface FacetFilter extends EObject {
	/**
	 * Returns the value of the '<em><b>Facet Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facet Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Facet Key</em>' attribute.
	 * @see #setFacetKey(String)
	 * @see org.gecko.searchresult.SearchResultPackage#getFacetFilter_FacetKey()
	 * @model
	 * @generated
	 */
	String getFacetKey();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.FacetFilter#getFacetKey <em>Facet Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Facet Key</em>' attribute.
	 * @see #getFacetKey()
	 * @generated
	 */
	void setFacetKey(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute list.
	 * @see org.gecko.searchresult.SearchResultPackage#getFacetFilter_Value()
	 * @model
	 * @generated
	 */
	EList<String> getValue();

} // FacetFilter
