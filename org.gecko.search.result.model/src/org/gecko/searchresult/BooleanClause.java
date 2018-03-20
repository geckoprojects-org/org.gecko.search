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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Clause</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchresult.BooleanClause#getOccur <em>Occur</em>}</li>
 *   <li>{@link org.gecko.searchresult.BooleanClause#getQuery <em>Query</em>}</li>
 * </ul>
 *
 * @see org.gecko.searchresult.SearchResultPackage#getBooleanClause()
 * @model
 * @generated
 */
public interface BooleanClause extends EObject {
	/**
	 * Returns the value of the '<em><b>Occur</b></em>' attribute.
	 * The literals are from the enumeration {@link org.gecko.searchresult.Occur}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Occur</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Occur</em>' attribute.
	 * @see org.gecko.searchresult.Occur
	 * @see #setOccur(Occur)
	 * @see org.gecko.searchresult.SearchResultPackage#getBooleanClause_Occur()
	 * @model
	 * @generated
	 */
	Occur getOccur();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.BooleanClause#getOccur <em>Occur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Occur</em>' attribute.
	 * @see org.gecko.searchresult.Occur
	 * @see #getOccur()
	 * @generated
	 */
	void setOccur(Occur value);

	/**
	 * Returns the value of the '<em><b>Query</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Query</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Query</em>' containment reference.
	 * @see #setQuery(BoostableField)
	 * @see org.gecko.searchresult.SearchResultPackage#getBooleanClause_Query()
	 * @model containment="true"
	 * @generated
	 */
	BoostableField getQuery();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.BooleanClause#getQuery <em>Query</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Query</em>' containment reference.
	 * @see #getQuery()
	 * @generated
	 */
	void setQuery(BoostableField value);

} // BooleanClause
