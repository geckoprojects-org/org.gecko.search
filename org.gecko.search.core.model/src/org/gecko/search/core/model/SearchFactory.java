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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.gecko.search.core.model.SearchPackage
 * @generated
 */
public interface SearchFactory extends EFactory {
	/**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	SearchFactory eINSTANCE = org.gecko.search.core.model.impl.SearchFactoryImpl.init();

	/**
   * Returns a new object of class '<em>Index Data Container</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Index Data Container</em>'.
   * @generated
   */
	IndexDataContainer createIndexDataContainer();

	/**
   * Returns a new object of class '<em>Index Data</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Index Data</em>'.
   * @generated
   */
	IndexData createIndexData();

	/**
   * Returns a new object of class '<em>Descriptor</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Descriptor</em>'.
   * @generated
   */
	Descriptor createDescriptor();

	/**
   * Returns a new object of class '<em>Descriptor Container</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Descriptor Container</em>'.
   * @generated
   */
	DescriptorContainer createDescriptorContainer();

	/**
   * Returns a new object of class '<em>Index Configuration</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Index Configuration</em>'.
   * @generated
   */
	IndexConfiguration createIndexConfiguration();

	/**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
	SearchPackage getSearchPackage();

} //SearchFactory
