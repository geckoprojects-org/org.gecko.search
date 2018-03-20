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
 * A representation of the model object '<em><b>Index Data Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.search.core.model.IndexDataContainer#getIndexData <em>Index Data</em>}</li>
 * </ul>
 *
 * @see org.gecko.search.core.model.SearchPackage#getIndexDataContainer()
 * @model
 * @generated
 */
public interface IndexDataContainer extends EObject {
	/**
   * Returns the value of the '<em><b>Index Data</b></em>' containment reference list.
   * The list contents are of type {@link org.gecko.search.core.model.IndexData}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index Data</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Index Data</em>' containment reference list.
   * @see org.gecko.search.core.model.SearchPackage#getIndexDataContainer_IndexData()
   * @model containment="true" keys="id"
   * @generated
   */
	EList<IndexData> getIndexData();

} // IndexDataContainer
