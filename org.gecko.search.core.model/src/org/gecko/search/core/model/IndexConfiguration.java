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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Index Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.search.core.model.IndexConfiguration#getId <em>Id</em>}</li>
 *   <li>{@link org.gecko.search.core.model.IndexConfiguration#getName <em>Name</em>}</li>
 *   <li>{@link org.gecko.search.core.model.IndexConfiguration#getDescription <em>Description</em>}</li>
 *   <li>{@link org.gecko.search.core.model.IndexConfiguration#isActive <em>Active</em>}</li>
 *   <li>{@link org.gecko.search.core.model.IndexConfiguration#getIndexData <em>Index Data</em>}</li>
 *   <li>{@link org.gecko.search.core.model.IndexConfiguration#getIndexDescriptors <em>Index Descriptors</em>}</li>
 *   <li>{@link org.gecko.search.core.model.IndexConfiguration#getQueryDescriptors <em>Query Descriptors</em>}</li>
 *   <li>{@link org.gecko.search.core.model.IndexConfiguration#getResultDescriptors <em>Result Descriptors</em>}</li>
 * </ul>
 *
 * @see org.gecko.search.core.model.SearchPackage#getIndexConfiguration()
 * @model
 * @generated
 */
public interface IndexConfiguration extends EObject {
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
   * @see org.gecko.search.core.model.SearchPackage#getIndexConfiguration_Id()
   * @model id="true" required="true"
   * @generated
   */
	String getId();

	/**
   * Sets the value of the '{@link org.gecko.search.core.model.IndexConfiguration#getId <em>Id</em>}' attribute.
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
   * @see org.gecko.search.core.model.SearchPackage#getIndexConfiguration_Name()
   * @model required="true"
   * @generated
   */
	String getName();

	/**
   * Sets the value of the '{@link org.gecko.search.core.model.IndexConfiguration#getName <em>Name</em>}' attribute.
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
   * @see org.gecko.search.core.model.SearchPackage#getIndexConfiguration_Description()
   * @model
   * @generated
   */
	String getDescription();

	/**
   * Sets the value of the '{@link org.gecko.search.core.model.IndexConfiguration#getDescription <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' attribute.
   * @see #getDescription()
   * @generated
   */
	void setDescription(String value);

	/**
   * Returns the value of the '<em><b>Active</b></em>' attribute.
   * The default value is <code>"true"</code>.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Active</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Active</em>' attribute.
   * @see #setActive(boolean)
   * @see org.gecko.search.core.model.SearchPackage#getIndexConfiguration_Active()
   * @model default="true" required="true"
   * @generated
   */
	boolean isActive();

	/**
   * Sets the value of the '{@link org.gecko.search.core.model.IndexConfiguration#isActive <em>Active</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Active</em>' attribute.
   * @see #isActive()
   * @generated
   */
	void setActive(boolean value);

	/**
   * Returns the value of the '<em><b>Index Data</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index Data</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Index Data</em>' reference.
   * @see #setIndexData(IndexData)
   * @see org.gecko.search.core.model.SearchPackage#getIndexConfiguration_IndexData()
   * @model required="true"
   * @generated
   */
	IndexData getIndexData();

	/**
   * Sets the value of the '{@link org.gecko.search.core.model.IndexConfiguration#getIndexData <em>Index Data</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Index Data</em>' reference.
   * @see #getIndexData()
   * @generated
   */
	void setIndexData(IndexData value);

	/**
   * Returns the value of the '<em><b>Index Descriptors</b></em>' reference list.
   * The list contents are of type {@link org.gecko.search.core.model.Descriptor}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index Descriptors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Index Descriptors</em>' reference list.
   * @see org.gecko.search.core.model.SearchPackage#getIndexConfiguration_IndexDescriptors()
   * @model keys="id"
   * @generated
   */
	EList<Descriptor> getIndexDescriptors();

	/**
   * Returns the value of the '<em><b>Query Descriptors</b></em>' reference list.
   * The list contents are of type {@link org.gecko.search.core.model.Descriptor}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Query Descriptors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Query Descriptors</em>' reference list.
   * @see org.gecko.search.core.model.SearchPackage#getIndexConfiguration_QueryDescriptors()
   * @model keys="id"
   * @generated
   */
	EList<Descriptor> getQueryDescriptors();

	/**
   * Returns the value of the '<em><b>Result Descriptors</b></em>' reference list.
   * The list contents are of type {@link org.gecko.search.core.model.Descriptor}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Descriptors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Result Descriptors</em>' reference list.
   * @see org.gecko.search.core.model.SearchPackage#getIndexConfiguration_ResultDescriptors()
   * @model keys="id"
   * @generated
   */
	EList<Descriptor> getResultDescriptors();

} // IndexConfiguration
