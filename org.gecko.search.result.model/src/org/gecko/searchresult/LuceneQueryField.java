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
 * A representation of the model object '<em><b>Lucene Query Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchresult.LuceneQueryField#getKey <em>Key</em>}</li>
 *   <li>{@link org.gecko.searchresult.LuceneQueryField#isAnalyzed <em>Analyzed</em>}</li>
 * </ul>
 *
 * @see org.gecko.searchresult.SearchResultPackage#getLuceneQueryField()
 * @model
 * @generated
 */
public interface LuceneQueryField extends BoostableField {
	/**
	 * Returns the value of the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key</em>' attribute.
	 * @see #setKey(String)
	 * @see org.gecko.searchresult.SearchResultPackage#getLuceneQueryField_Key()
	 * @model
	 * @generated
	 */
	String getKey();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.LuceneQueryField#getKey <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key</em>' attribute.
	 * @see #getKey()
	 * @generated
	 */
	void setKey(String value);

	/**
	 * Returns the value of the '<em><b>Analyzed</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Analyzed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Analyzed</em>' attribute.
	 * @see #setAnalyzed(boolean)
	 * @see org.gecko.searchresult.SearchResultPackage#getLuceneQueryField_Analyzed()
	 * @model default="false"
	 * @generated
	 */
	boolean isAnalyzed();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.LuceneQueryField#isAnalyzed <em>Analyzed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Analyzed</em>' attribute.
	 * @see #isAnalyzed()
	 * @generated
	 */
	void setAnalyzed(boolean value);

} // LuceneQueryField
