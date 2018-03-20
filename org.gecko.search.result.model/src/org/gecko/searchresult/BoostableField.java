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

import org.gecko.utilities.query.QueryCondition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boostable Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchresult.BoostableField#getBoost <em>Boost</em>}</li>
 * </ul>
 *
 * @see org.gecko.searchresult.SearchResultPackage#getBoostableField()
 * @model
 * @generated
 */
public interface BoostableField extends QueryCondition {
	/**
	 * Returns the value of the '<em><b>Boost</b></em>' attribute.
	 * The default value is <code>"0.4"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Boost</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Boost</em>' attribute.
	 * @see #setBoost(float)
	 * @see org.gecko.searchresult.SearchResultPackage#getBoostableField_Boost()
	 * @model default="0.4"
	 * @generated
	 */
	float getBoost();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.BoostableField#getBoost <em>Boost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Boost</em>' attribute.
	 * @see #getBoost()
	 * @generated
	 */
	void setBoost(float value);

} // BoostableField
