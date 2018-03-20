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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Double Range Query</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchresult.DoubleRangeQuery#getMinValue <em>Min Value</em>}</li>
 *   <li>{@link org.gecko.searchresult.DoubleRangeQuery#getMaxValue <em>Max Value</em>}</li>
 * </ul>
 *
 * @see org.gecko.searchresult.SearchResultPackage#getDoubleRangeQuery()
 * @model
 * @generated
 */
public interface DoubleRangeQuery extends NumericRangeQuery {
	/**
	 * Returns the value of the '<em><b>Min Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Value</em>' attribute.
	 * @see #setMinValue(double)
	 * @see org.gecko.searchresult.SearchResultPackage#getDoubleRangeQuery_MinValue()
	 * @model required="true"
	 * @generated
	 */
	double getMinValue();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.DoubleRangeQuery#getMinValue <em>Min Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Value</em>' attribute.
	 * @see #getMinValue()
	 * @generated
	 */
	void setMinValue(double value);

	/**
	 * Returns the value of the '<em><b>Max Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Value</em>' attribute.
	 * @see #setMaxValue(double)
	 * @see org.gecko.searchresult.SearchResultPackage#getDoubleRangeQuery_MaxValue()
	 * @model required="true"
	 * @generated
	 */
	double getMaxValue();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.DoubleRangeQuery#getMaxValue <em>Max Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Value</em>' attribute.
	 * @see #getMaxValue()
	 * @generated
	 */
	void setMaxValue(double value);

} // DoubleRangeQuery
