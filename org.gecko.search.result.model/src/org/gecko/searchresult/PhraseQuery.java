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
 * A representation of the model object '<em><b>Phrase Query</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchresult.PhraseQuery#getSlop <em>Slop</em>}</li>
 *   <li>{@link org.gecko.searchresult.PhraseQuery#getTerms <em>Terms</em>}</li>
 * </ul>
 *
 * @see org.gecko.searchresult.SearchResultPackage#getPhraseQuery()
 * @model
 * @generated
 */
public interface PhraseQuery extends LuceneQueryField {
	/**
	 * Returns the value of the '<em><b>Slop</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Slop</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Slop</em>' attribute.
	 * @see #setSlop(int)
	 * @see org.gecko.searchresult.SearchResultPackage#getPhraseQuery_Slop()
	 * @model
	 * @generated
	 */
	int getSlop();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.PhraseQuery#getSlop <em>Slop</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Slop</em>' attribute.
	 * @see #getSlop()
	 * @generated
	 */
	void setSlop(int value);

	/**
	 * Returns the value of the '<em><b>Terms</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Terms</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Terms</em>' attribute list.
	 * @see org.gecko.searchresult.SearchResultPackage#getPhraseQuery_Terms()
	 * @model required="true"
	 * @generated
	 */
	EList<String> getTerms();

} // PhraseQuery
