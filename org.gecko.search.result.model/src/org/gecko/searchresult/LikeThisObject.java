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
 * A representation of the model object '<em><b>Like This Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchresult.LikeThisObject#getLikeThisFields <em>Like This Fields</em>}</li>
 *   <li>{@link org.gecko.searchresult.LikeThisObject#getFilterFields <em>Filter Fields</em>}</li>
 *   <li>{@link org.gecko.searchresult.LikeThisObject#getSortFields <em>Sort Fields</em>}</li>
 *   <li>{@link org.gecko.searchresult.LikeThisObject#isFilterSourceObject <em>Filter Source Object</em>}</li>
 *   <li>{@link org.gecko.searchresult.LikeThisObject#getFilterSourceField <em>Filter Source Field</em>}</li>
 *   <li>{@link org.gecko.searchresult.LikeThisObject#getMaxResults <em>Max Results</em>}</li>
 * </ul>
 *
 * @see org.gecko.searchresult.SearchResultPackage#getLikeThisObject()
 * @model
 * @generated
 */
public interface LikeThisObject extends EObject {
	/**
	 * Returns the value of the '<em><b>Like This Fields</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Like This Fields</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Like This Fields</em>' attribute list.
	 * @see org.gecko.searchresult.SearchResultPackage#getLikeThisObject_LikeThisFields()
	 * @model
	 * @generated
	 */
	EList<String> getLikeThisFields();

	/**
	 * Returns the value of the '<em><b>Filter Fields</b></em>' containment reference list.
	 * The list contents are of type {@link org.gecko.searchresult.FilterField}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filter Fields</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filter Fields</em>' containment reference list.
	 * @see org.gecko.searchresult.SearchResultPackage#getLikeThisObject_FilterFields()
	 * @model containment="true"
	 * @generated
	 */
	EList<FilterField> getFilterFields();

	/**
	 * Returns the value of the '<em><b>Sort Fields</b></em>' containment reference list.
	 * The list contents are of type {@link org.gecko.searchresult.SortField}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sort Fields</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sort Fields</em>' containment reference list.
	 * @see org.gecko.searchresult.SearchResultPackage#getLikeThisObject_SortFields()
	 * @model containment="true"
	 * @generated
	 */
	EList<SortField> getSortFields();

	/**
	 * Returns the value of the '<em><b>Filter Source Object</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filter Source Object</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filter Source Object</em>' attribute.
	 * @see #setFilterSourceObject(boolean)
	 * @see org.gecko.searchresult.SearchResultPackage#getLikeThisObject_FilterSourceObject()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isFilterSourceObject();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.LikeThisObject#isFilterSourceObject <em>Filter Source Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filter Source Object</em>' attribute.
	 * @see #isFilterSourceObject()
	 * @generated
	 */
	void setFilterSourceObject(boolean value);

	/**
	 * Returns the value of the '<em><b>Filter Source Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filter Source Field</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filter Source Field</em>' attribute.
	 * @see #setFilterSourceField(String)
	 * @see org.gecko.searchresult.SearchResultPackage#getLikeThisObject_FilterSourceField()
	 * @model
	 * @generated
	 */
	String getFilterSourceField();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.LikeThisObject#getFilterSourceField <em>Filter Source Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filter Source Field</em>' attribute.
	 * @see #getFilterSourceField()
	 * @generated
	 */
	void setFilterSourceField(String value);

	/**
	 * Returns the value of the '<em><b>Max Results</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Results</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Results</em>' attribute.
	 * @see #setMaxResults(int)
	 * @see org.gecko.searchresult.SearchResultPackage#getLikeThisObject_MaxResults()
	 * @model
	 * @generated
	 */
	int getMaxResults();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.LikeThisObject#getMaxResults <em>Max Results</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Results</em>' attribute.
	 * @see #getMaxResults()
	 * @generated
	 */
	void setMaxResults(int value);

} // LikeThisObject
