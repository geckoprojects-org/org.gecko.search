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
 * A representation of the model object '<em><b>Numeric Range Query</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchresult.NumericRangeQuery#getPrecisionStep <em>Precision Step</em>}</li>
 *   <li>{@link org.gecko.searchresult.NumericRangeQuery#isMinInclusive <em>Min Inclusive</em>}</li>
 *   <li>{@link org.gecko.searchresult.NumericRangeQuery#isMaxInclusive <em>Max Inclusive</em>}</li>
 * </ul>
 *
 * @see org.gecko.searchresult.SearchResultPackage#getNumericRangeQuery()
 * @model abstract="true"
 * @generated
 */
public interface NumericRangeQuery extends LuceneQueryField {
	/**
	 * Returns the value of the '<em><b>Precision Step</b></em>' attribute.
	 * The default value is <code>"4"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Precision Step</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Precision Step</em>' attribute.
	 * @see #setPrecisionStep(int)
	 * @see org.gecko.searchresult.SearchResultPackage#getNumericRangeQuery_PrecisionStep()
	 * @model default="4"
	 * @generated
	 */
	int getPrecisionStep();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.NumericRangeQuery#getPrecisionStep <em>Precision Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Precision Step</em>' attribute.
	 * @see #getPrecisionStep()
	 * @generated
	 */
	void setPrecisionStep(int value);

	/**
	 * Returns the value of the '<em><b>Min Inclusive</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Inclusive</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Inclusive</em>' attribute.
	 * @see #setMinInclusive(boolean)
	 * @see org.gecko.searchresult.SearchResultPackage#getNumericRangeQuery_MinInclusive()
	 * @model default="true"
	 * @generated
	 */
	boolean isMinInclusive();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.NumericRangeQuery#isMinInclusive <em>Min Inclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Inclusive</em>' attribute.
	 * @see #isMinInclusive()
	 * @generated
	 */
	void setMinInclusive(boolean value);

	/**
	 * Returns the value of the '<em><b>Max Inclusive</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Inclusive</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Inclusive</em>' attribute.
	 * @see #setMaxInclusive(boolean)
	 * @see org.gecko.searchresult.SearchResultPackage#getNumericRangeQuery_MaxInclusive()
	 * @model default="true"
	 * @generated
	 */
	boolean isMaxInclusive();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.NumericRangeQuery#isMaxInclusive <em>Max Inclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Inclusive</em>' attribute.
	 * @see #isMaxInclusive()
	 * @generated
	 */
	void setMaxInclusive(boolean value);

} // NumericRangeQuery
