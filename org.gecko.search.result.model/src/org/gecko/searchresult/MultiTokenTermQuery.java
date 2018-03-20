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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multi Token Term Query</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchresult.MultiTokenTermQuery#getTokens <em>Tokens</em>}</li>
 *   <li>{@link org.gecko.searchresult.MultiTokenTermQuery#isPrefix <em>Prefix</em>}</li>
 *   <li>{@link org.gecko.searchresult.MultiTokenTermQuery#getTokensOccur <em>Tokens Occur</em>}</li>
 * </ul>
 *
 * @see org.gecko.searchresult.SearchResultPackage#getMultiTokenTermQuery()
 * @model
 * @generated
 */
public interface MultiTokenTermQuery extends LuceneQueryField {
	/**
	 * Returns the value of the '<em><b>Tokens</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tokens</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tokens</em>' attribute list.
	 * @see org.gecko.searchresult.SearchResultPackage#getMultiTokenTermQuery_Tokens()
	 * @model required="true"
	 * @generated
	 */
	EList<String> getTokens();

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
	 * @see org.gecko.searchresult.SearchResultPackage#getMultiTokenTermQuery_Prefix()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isPrefix();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.MultiTokenTermQuery#isPrefix <em>Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prefix</em>' attribute.
	 * @see #isPrefix()
	 * @generated
	 */
	void setPrefix(boolean value);

	/**
	 * Returns the value of the '<em><b>Tokens Occur</b></em>' attribute.
	 * The literals are from the enumeration {@link org.gecko.searchresult.Occur}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tokens Occur</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tokens Occur</em>' attribute.
	 * @see org.gecko.searchresult.Occur
	 * @see #setTokensOccur(Occur)
	 * @see org.gecko.searchresult.SearchResultPackage#getMultiTokenTermQuery_TokensOccur()
	 * @model
	 * @generated
	 */
	Occur getTokensOccur();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.MultiTokenTermQuery#getTokensOccur <em>Tokens Occur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tokens Occur</em>' attribute.
	 * @see org.gecko.searchresult.Occur
	 * @see #getTokensOccur()
	 * @generated
	 */
	void setTokensOccur(Occur value);

} // MultiTokenTermQuery
