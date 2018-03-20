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
 * A representation of the model object '<em><b>Sort Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchresult.SortField#getKey <em>Key</em>}</li>
 *   <li>{@link org.gecko.searchresult.SortField#getTokens <em>Tokens</em>}</li>
 *   <li>{@link org.gecko.searchresult.SortField#getType <em>Type</em>}</li>
 *   <li>{@link org.gecko.searchresult.SortField#getDirection <em>Direction</em>}</li>
 *   <li>{@link org.gecko.searchresult.SortField#getOccur <em>Occur</em>}</li>
 * </ul>
 *
 * @see org.gecko.searchresult.SearchResultPackage#getSortField()
 * @model
 * @generated
 */
public interface SortField extends EObject {
	/**
	 * Returns the value of the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key</em>' attribute.
	 * @see #setKey(String)
	 * @see org.gecko.searchresult.SearchResultPackage#getSortField_Key()
	 * @model
	 * @generated
	 */
	String getKey();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.SortField#getKey <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key</em>' attribute.
	 * @see #getKey()
	 * @generated
	 */
	void setKey(String value);

	/**
	 * Returns the value of the '<em><b>Tokens</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tokens</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tokens</em>' attribute list.
	 * @see org.gecko.searchresult.SearchResultPackage#getSortField_Tokens()
	 * @model
	 * @generated
	 */
	EList<String> getTokens();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.gecko.searchresult.SortType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.gecko.searchresult.SortType
	 * @see #setType(SortType)
	 * @see org.gecko.searchresult.SearchResultPackage#getSortField_Type()
	 * @model required="true"
	 * @generated
	 */
	SortType getType();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.SortField#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.gecko.searchresult.SortType
	 * @see #getType()
	 * @generated
	 */
	void setType(SortType value);

	/**
	 * Returns the value of the '<em><b>Direction</b></em>' attribute.
	 * The literals are from the enumeration {@link org.gecko.searchresult.SortDirectionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Direction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Direction</em>' attribute.
	 * @see org.gecko.searchresult.SortDirectionType
	 * @see #setDirection(SortDirectionType)
	 * @see org.gecko.searchresult.SearchResultPackage#getSortField_Direction()
	 * @model required="true"
	 * @generated
	 */
	SortDirectionType getDirection();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.SortField#getDirection <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Direction</em>' attribute.
	 * @see org.gecko.searchresult.SortDirectionType
	 * @see #getDirection()
	 * @generated
	 */
	void setDirection(SortDirectionType value);

	/**
	 * Returns the value of the '<em><b>Occur</b></em>' attribute.
	 * The literals are from the enumeration {@link org.gecko.searchresult.Occur}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Occur</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Occur</em>' attribute.
	 * @see org.gecko.searchresult.Occur
	 * @see #setOccur(Occur)
	 * @see org.gecko.searchresult.SearchResultPackage#getSortField_Occur()
	 * @model
	 * @generated
	 */
	Occur getOccur();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.SortField#getOccur <em>Occur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Occur</em>' attribute.
	 * @see org.gecko.searchresult.Occur
	 * @see #getOccur()
	 * @generated
	 */
	void setOccur(Occur value);

} // SortField
