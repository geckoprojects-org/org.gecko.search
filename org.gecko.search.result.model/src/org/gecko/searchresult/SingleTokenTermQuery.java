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
 * A representation of the model object '<em><b>Single Token Term Query</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchresult.SingleTokenTermQuery#getToken <em>Token</em>}</li>
 *   <li>{@link org.gecko.searchresult.SingleTokenTermQuery#isPrefix <em>Prefix</em>}</li>
 * </ul>
 *
 * @see org.gecko.searchresult.SearchResultPackage#getSingleTokenTermQuery()
 * @model
 * @generated
 */
public interface SingleTokenTermQuery extends LuceneQueryField {
	/**
	 * Returns the value of the '<em><b>Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Token</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Token</em>' attribute.
	 * @see #setToken(String)
	 * @see org.gecko.searchresult.SearchResultPackage#getSingleTokenTermQuery_Token()
	 * @model required="true"
	 * @generated
	 */
	String getToken();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.SingleTokenTermQuery#getToken <em>Token</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Token</em>' attribute.
	 * @see #getToken()
	 * @generated
	 */
	void setToken(String value);

	/**
	 * Returns the value of the '<em><b>Prefix</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prefix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prefix</em>' attribute.
	 * @see #setPrefix(boolean)
	 * @see org.gecko.searchresult.SearchResultPackage#getSingleTokenTermQuery_Prefix()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isPrefix();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.SingleTokenTermQuery#isPrefix <em>Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prefix</em>' attribute.
	 * @see #isPrefix()
	 * @generated
	 */
	void setPrefix(boolean value);

} // SingleTokenTermQuery
