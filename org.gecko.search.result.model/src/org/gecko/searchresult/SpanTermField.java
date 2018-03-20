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
 * A representation of the model object '<em><b>Span Term Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchresult.SpanTermField#getTokens <em>Tokens</em>}</li>
 *   <li>{@link org.gecko.searchresult.SpanTermField#getSpan <em>Span</em>}</li>
 * </ul>
 *
 * @see org.gecko.searchresult.SearchResultPackage#getSpanTermField()
 * @model
 * @generated
 */
public interface SpanTermField extends LuceneQueryField {
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
	 * @see org.gecko.searchresult.SearchResultPackage#getSpanTermField_Tokens()
	 * @model
	 * @generated
	 */
	EList<String> getTokens();

	/**
	 * Returns the value of the '<em><b>Span</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Span</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Span</em>' attribute.
	 * @see #setSpan(int)
	 * @see org.gecko.searchresult.SearchResultPackage#getSpanTermField_Span()
	 * @model default="1"
	 * @generated
	 */
	int getSpan();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.SpanTermField#getSpan <em>Span</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Span</em>' attribute.
	 * @see #getSpan()
	 * @generated
	 */
	void setSpan(int value);

} // SpanTermField
