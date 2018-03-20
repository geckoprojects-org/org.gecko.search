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
 * A representation of the model object '<em><b>Wildcard Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchresult.WildcardField#isStartWithWildcard <em>Start With Wildcard</em>}</li>
 *   <li>{@link org.gecko.searchresult.WildcardField#isEndWithWildcard <em>End With Wildcard</em>}</li>
 *   <li>{@link org.gecko.searchresult.WildcardField#isIncludeUpperCase <em>Include Upper Case</em>}</li>
 * </ul>
 *
 * @see org.gecko.searchresult.SearchResultPackage#getWildcardField()
 * @model
 * @generated
 */
public interface WildcardField extends MultiTokenTermQuery {
	/**
	 * Returns the value of the '<em><b>Start With Wildcard</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start With Wildcard</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start With Wildcard</em>' attribute.
	 * @see #setStartWithWildcard(boolean)
	 * @see org.gecko.searchresult.SearchResultPackage#getWildcardField_StartWithWildcard()
	 * @model default="true"
	 * @generated
	 */
	boolean isStartWithWildcard();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.WildcardField#isStartWithWildcard <em>Start With Wildcard</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start With Wildcard</em>' attribute.
	 * @see #isStartWithWildcard()
	 * @generated
	 */
	void setStartWithWildcard(boolean value);

	/**
	 * Returns the value of the '<em><b>End With Wildcard</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End With Wildcard</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End With Wildcard</em>' attribute.
	 * @see #setEndWithWildcard(boolean)
	 * @see org.gecko.searchresult.SearchResultPackage#getWildcardField_EndWithWildcard()
	 * @model default="true"
	 * @generated
	 */
	boolean isEndWithWildcard();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.WildcardField#isEndWithWildcard <em>End With Wildcard</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End With Wildcard</em>' attribute.
	 * @see #isEndWithWildcard()
	 * @generated
	 */
	void setEndWithWildcard(boolean value);

	/**
	 * Returns the value of the '<em><b>Include Upper Case</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Include Upper Case</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Include Upper Case</em>' attribute.
	 * @see #setIncludeUpperCase(boolean)
	 * @see org.gecko.searchresult.SearchResultPackage#getWildcardField_IncludeUpperCase()
	 * @model default="true"
	 * @generated
	 */
	boolean isIncludeUpperCase();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.WildcardField#isIncludeUpperCase <em>Include Upper Case</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Include Upper Case</em>' attribute.
	 * @see #isIncludeUpperCase()
	 * @generated
	 */
	void setIncludeUpperCase(boolean value);

} // WildcardField
