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
 * A representation of the model object '<em><b>Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.search.core.model.Descriptor#getId <em>Id</em>}</li>
 *   <li>{@link org.gecko.search.core.model.Descriptor#getName <em>Name</em>}</li>
 *   <li>{@link org.gecko.search.core.model.Descriptor#getDescription <em>Description</em>}</li>
 *   <li>{@link org.gecko.search.core.model.Descriptor#isActive <em>Active</em>}</li>
 *   <li>{@link org.gecko.search.core.model.Descriptor#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see org.gecko.search.core.model.SearchPackage#getDescriptor()
 * @model
 * @generated
 */
public interface Descriptor extends EObject {
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
   * @see org.gecko.search.core.model.SearchPackage#getDescriptor_Id()
   * @model id="true" required="true"
   * @generated
   */
	String getId();

	/**
   * Sets the value of the '{@link org.gecko.search.core.model.Descriptor#getId <em>Id</em>}' attribute.
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
   * @see org.gecko.search.core.model.SearchPackage#getDescriptor_Name()
   * @model required="true"
   * @generated
   */
	String getName();

	/**
   * Sets the value of the '{@link org.gecko.search.core.model.Descriptor#getName <em>Name</em>}' attribute.
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
   * @see org.gecko.search.core.model.SearchPackage#getDescriptor_Description()
   * @model
   * @generated
   */
	String getDescription();

	/**
   * Sets the value of the '{@link org.gecko.search.core.model.Descriptor#getDescription <em>Description</em>}' attribute.
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
   * @see org.gecko.search.core.model.SearchPackage#getDescriptor_Active()
   * @model default="true" required="true"
   * @generated
   */
	boolean isActive();

	/**
   * Sets the value of the '{@link org.gecko.search.core.model.Descriptor#isActive <em>Active</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Active</em>' attribute.
   * @see #isActive()
   * @generated
   */
	void setActive(boolean value);

	/**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * The literals are from the enumeration {@link org.gecko.search.core.model.DescriptorType}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see org.gecko.search.core.model.DescriptorType
   * @see #setType(DescriptorType)
   * @see org.gecko.search.core.model.SearchPackage#getDescriptor_Type()
   * @model required="true"
   * @generated
   */
	DescriptorType getType();

	/**
   * Sets the value of the '{@link org.gecko.search.core.model.Descriptor#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see org.gecko.search.core.model.DescriptorType
   * @see #getType()
   * @generated
   */
	void setType(DescriptorType value);

} // Descriptor
