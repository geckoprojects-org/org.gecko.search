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
 * A representation of the model object '<em><b>Span Query Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchresult.SpanQueryField#getSpan <em>Span</em>}</li>
 *   <li>{@link org.gecko.searchresult.SpanQueryField#getQueryFields <em>Query Fields</em>}</li>
 * </ul>
 *
 * @see org.gecko.searchresult.SearchResultPackage#getSpanQueryField()
 * @model
 * @generated
 */
public interface SpanQueryField extends LuceneQueryField {
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
	 * @see org.gecko.searchresult.SearchResultPackage#getSpanQueryField_Span()
	 * @model default="1"
	 * @generated
	 */
	int getSpan();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.SpanQueryField#getSpan <em>Span</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Span</em>' attribute.
	 * @see #getSpan()
	 * @generated
	 */
	void setSpan(int value);

	/**
	 * Returns the value of the '<em><b>Query Fields</b></em>' containment reference list.
	 * The list contents are of type {@link org.gecko.searchresult.LuceneQueryField}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Query Fields</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Query Fields</em>' containment reference list.
	 * @see org.gecko.searchresult.SearchResultPackage#getSpanQueryField_QueryFields()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<LuceneQueryField> getQueryFields();

} // SpanQueryField
