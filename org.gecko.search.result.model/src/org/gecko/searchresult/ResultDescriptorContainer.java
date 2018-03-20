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
 * A representation of the model object '<em><b>Result Descriptor Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchresult.ResultDescriptorContainer#getDescriptors <em>Descriptors</em>}</li>
 *   <li>{@link org.gecko.searchresult.ResultDescriptorContainer#getActiveDescriptors <em>Active Descriptors</em>}</li>
 * </ul>
 *
 * @see org.gecko.searchresult.SearchResultPackage#getResultDescriptorContainer()
 * @model
 * @generated
 */
public interface ResultDescriptorContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Descriptors</b></em>' containment reference list.
	 * The list contents are of type {@link org.gecko.searchresult.ResultDescriptor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Descriptors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Descriptors</em>' containment reference list.
	 * @see org.gecko.searchresult.SearchResultPackage#getResultDescriptorContainer_Descriptors()
	 * @model containment="true"
	 * @generated
	 */
	EList<ResultDescriptor> getDescriptors();

	/**
	 * Returns the value of the '<em><b>Active Descriptors</b></em>' reference list.
	 * The list contents are of type {@link org.gecko.searchresult.ResultDescriptor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Active Descriptors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Active Descriptors</em>' reference list.
	 * @see org.gecko.searchresult.SearchResultPackage#getResultDescriptorContainer_ActiveDescriptors()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<ResultDescriptor> getActiveDescriptors();

} // ResultDescriptorContainer
