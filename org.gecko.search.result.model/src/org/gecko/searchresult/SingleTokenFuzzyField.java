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
 * A representation of the model object '<em><b>Single Token Fuzzy Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchresult.SingleTokenFuzzyField#isUppercase <em>Uppercase</em>}</li>
 *   <li>{@link org.gecko.searchresult.SingleTokenFuzzyField#getMaxEdits <em>Max Edits</em>}</li>
 * </ul>
 *
 * @see org.gecko.searchresult.SearchResultPackage#getSingleTokenFuzzyField()
 * @model
 * @generated
 */
public interface SingleTokenFuzzyField extends SingleTokenTermQuery {
	/**
	 * Returns the value of the '<em><b>Uppercase</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uppercase</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uppercase</em>' attribute.
	 * @see #setUppercase(boolean)
	 * @see org.gecko.searchresult.SearchResultPackage#getSingleTokenFuzzyField_Uppercase()
	 * @model default="false"
	 * @generated
	 */
	boolean isUppercase();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.SingleTokenFuzzyField#isUppercase <em>Uppercase</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uppercase</em>' attribute.
	 * @see #isUppercase()
	 * @generated
	 */
	void setUppercase(boolean value);

	/**
	 * Returns the value of the '<em><b>Max Edits</b></em>' attribute.
	 * The default value is <code>"2"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Edits</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Edits</em>' attribute.
	 * @see #setMaxEdits(int)
	 * @see org.gecko.searchresult.SearchResultPackage#getSingleTokenFuzzyField_MaxEdits()
	 * @model default="2"
	 * @generated
	 */
	int getMaxEdits();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.SingleTokenFuzzyField#getMaxEdits <em>Max Edits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Edits</em>' attribute.
	 * @see #getMaxEdits()
	 * @generated
	 */
	void setMaxEdits(int value);

} // SingleTokenFuzzyField
