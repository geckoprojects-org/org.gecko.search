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
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Descriptor Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.search.core.model.DescriptorContainer#getDescriptors <em>Descriptors</em>}</li>
 *   <li>{@link org.gecko.search.core.model.DescriptorContainer#getQueryDescriptors <em>Query Descriptors</em>}</li>
 *   <li>{@link org.gecko.search.core.model.DescriptorContainer#getIndexDescriptors <em>Index Descriptors</em>}</li>
 *   <li>{@link org.gecko.search.core.model.DescriptorContainer#getResultDescriptors <em>Result Descriptors</em>}</li>
 * </ul>
 *
 * @see org.gecko.search.core.model.SearchPackage#getDescriptorContainer()
 * @model
 * @generated
 */
public interface DescriptorContainer extends EObject {
	/**
   * Returns the value of the '<em><b>Descriptors</b></em>' attribute list.
   * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Descriptors</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Descriptors</em>' attribute list.
   * @see org.gecko.search.core.model.SearchPackage#getDescriptorContainer_Descriptors()
   * @model dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
   *        extendedMetaData="kind='group'"
   * @generated
   */
	FeatureMap getDescriptors();

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
   * @see org.gecko.search.core.model.SearchPackage#getDescriptorContainer_QueryDescriptors()
   * @model transient="true" volatile="true" derived="true"
   *        extendedMetaData="group='#descriptors' kind='QUERY'"
   * @generated
   */
	EList<Descriptor> getQueryDescriptors();

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
   * @see org.gecko.search.core.model.SearchPackage#getDescriptorContainer_IndexDescriptors()
   * @model transient="true" volatile="true" derived="true"
   *        extendedMetaData="group='#descriptors' kind='INDEX'"
   * @generated
   */
	EList<Descriptor> getIndexDescriptors();

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
   * @see org.gecko.search.core.model.SearchPackage#getDescriptorContainer_ResultDescriptors()
   * @model transient="true" volatile="true" derived="true"
   *        extendedMetaData="group='#descriptors' kind='RESULT'"
   * @generated
   */
	EList<Descriptor> getResultDescriptors();

} // DescriptorContainer
