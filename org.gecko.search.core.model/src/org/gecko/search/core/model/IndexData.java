/**
 * Copyright (c) 2014 Data In Motion and others.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Data In Motion - initial API and implementation
 */
package org.gecko.search.core.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Index Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.search.core.model.IndexData#getId <em>Id</em>}</li>
 *   <li>{@link org.gecko.search.core.model.IndexData#getName <em>Name</em>}</li>
 *   <li>{@link org.gecko.search.core.model.IndexData#getDescription <em>Description</em>}</li>
 *   <li>{@link org.gecko.search.core.model.IndexData#getType <em>Type</em>}</li>
 *   <li>{@link org.gecko.search.core.model.IndexData#getUri <em>Uri</em>}</li>
 *   <li>{@link org.gecko.search.core.model.IndexData#getWorkspaceProviderId <em>Workspace Provider Id</em>}</li>
 * </ul>
 *
 * @see org.gecko.search.core.model.SearchPackage#getIndexData()
 * @model
 * @generated
 */
public interface IndexData extends EObject {
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
   * @see org.gecko.search.core.model.SearchPackage#getIndexData_Id()
   * @model id="true" required="true"
   * @generated
   */
	String getId();

	/**
   * Sets the value of the '{@link org.gecko.search.core.model.IndexData#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #getId()
   * @generated
   */
	void setId(String value);

	/**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.gecko.search.core.model.SearchPackage#getIndexData_Name()
   * @model required="true"
   * @generated
   */
	String getName();

	/**
   * Sets the value of the '{@link org.gecko.search.core.model.IndexData#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
	void setName(String value);

	/**
   * Returns the value of the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Description</em>' attribute.
   * @see #setDescription(String)
   * @see org.gecko.search.core.model.SearchPackage#getIndexData_Description()
   * @model
   * @generated
   */
	String getDescription();

	/**
   * Sets the value of the '{@link org.gecko.search.core.model.IndexData#getDescription <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' attribute.
   * @see #getDescription()
   * @generated
   */
	void setDescription(String value);

	/**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * The literals are from the enumeration {@link org.gecko.search.core.model.IndexDataType}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see org.gecko.search.core.model.IndexDataType
   * @see #setType(IndexDataType)
   * @see org.gecko.search.core.model.SearchPackage#getIndexData_Type()
   * @model required="true"
   * @generated
   */
	IndexDataType getType();

	/**
   * Sets the value of the '{@link org.gecko.search.core.model.IndexData#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see org.gecko.search.core.model.IndexDataType
   * @see #getType()
   * @generated
   */
	void setType(IndexDataType value);

	/**
   * Returns the value of the '<em><b>Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Uri</em>' attribute.
   * @see #setUri(String)
   * @see org.gecko.search.core.model.SearchPackage#getIndexData_Uri()
   * @model required="true"
   * @generated
   */
	String getUri();

	/**
   * Sets the value of the '{@link org.gecko.search.core.model.IndexData#getUri <em>Uri</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Uri</em>' attribute.
   * @see #getUri()
   * @generated
   */
	void setUri(String value);

	/**
   * Returns the value of the '<em><b>Workspace Provider Id</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Workspace Provider Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Workspace Provider Id</em>' attribute.
   * @see #setWorkspaceProviderId(String)
   * @see org.gecko.search.core.model.SearchPackage#getIndexData_WorkspaceProviderId()
   * @model required="true"
   * @generated
   */
	String getWorkspaceProviderId();

	/**
   * Sets the value of the '{@link org.gecko.search.core.model.IndexData#getWorkspaceProviderId <em>Workspace Provider Id</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Workspace Provider Id</em>' attribute.
   * @see #getWorkspaceProviderId()
   * @generated
   */
	void setWorkspaceProviderId(String value);

} // IndexData
