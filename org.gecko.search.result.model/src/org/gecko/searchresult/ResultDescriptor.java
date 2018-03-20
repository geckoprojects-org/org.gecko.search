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
 * A representation of the model object '<em><b>Result Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchresult.ResultDescriptor#getId <em>Id</em>}</li>
 *   <li>{@link org.gecko.searchresult.ResultDescriptor#isActive <em>Active</em>}</li>
 *   <li>{@link org.gecko.searchresult.ResultDescriptor#getIndexId <em>Index Id</em>}</li>
 *   <li>{@link org.gecko.searchresult.ResultDescriptor#getFields <em>Fields</em>}</li>
 * </ul>
 *
 * @see org.gecko.searchresult.SearchResultPackage#getResultDescriptor()
 * @model
 * @generated
 */
public interface ResultDescriptor extends EObject {
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
	 * @see org.gecko.searchresult.SearchResultPackage#getResultDescriptor_Id()
	 * @model id="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.ResultDescriptor#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Active</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Active</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Active</em>' attribute.
	 * @see #setActive(boolean)
	 * @see org.gecko.searchresult.SearchResultPackage#getResultDescriptor_Active()
	 * @model default="false"
	 * @generated
	 */
	boolean isActive();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.ResultDescriptor#isActive <em>Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Active</em>' attribute.
	 * @see #isActive()
	 * @generated
	 */
	void setActive(boolean value);

	/**
	 * Returns the value of the '<em><b>Index Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index Id</em>' attribute.
	 * @see #setIndexId(String)
	 * @see org.gecko.searchresult.SearchResultPackage#getResultDescriptor_IndexId()
	 * @model
	 * @generated
	 */
	String getIndexId();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.ResultDescriptor#getIndexId <em>Index Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index Id</em>' attribute.
	 * @see #getIndexId()
	 * @generated
	 */
	void setIndexId(String value);

	/**
	 * Returns the value of the '<em><b>Fields</b></em>' containment reference list.
	 * The list contents are of type {@link org.gecko.searchresult.ResultField}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fields</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fields</em>' containment reference list.
	 * @see org.gecko.searchresult.SearchResultPackage#getResultDescriptor_Fields()
	 * @model containment="true"
	 * @generated
	 */
	EList<ResultField> getFields();

} // ResultDescriptor
