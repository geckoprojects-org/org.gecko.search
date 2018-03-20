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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Join Query</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchresult.JoinQuery#getIndexPath <em>Index Path</em>}</li>
 *   <li>{@link org.gecko.searchresult.JoinQuery#getFromField <em>From Field</em>}</li>
 *   <li>{@link org.gecko.searchresult.JoinQuery#getToField <em>To Field</em>}</li>
 *   <li>{@link org.gecko.searchresult.JoinQuery#getScoreMode <em>Score Mode</em>}</li>
 *   <li>{@link org.gecko.searchresult.JoinQuery#getQueryObject <em>Query Object</em>}</li>
 *   <li>{@link org.gecko.searchresult.JoinQuery#getJoinAftermathCollectors <em>Join Aftermath Collectors</em>}</li>
 *   <li>{@link org.gecko.searchresult.JoinQuery#getOccur <em>Occur</em>}</li>
 * </ul>
 *
 * @see org.gecko.searchresult.SearchResultPackage#getJoinQuery()
 * @model
 * @generated
 */
public interface JoinQuery extends EObject {
	/**
	 * Returns the value of the '<em><b>Index Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index Path</em>' attribute.
	 * @see #setIndexPath(String)
	 * @see org.gecko.searchresult.SearchResultPackage#getJoinQuery_IndexPath()
	 * @model required="true"
	 * @generated
	 */
	String getIndexPath();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.JoinQuery#getIndexPath <em>Index Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index Path</em>' attribute.
	 * @see #getIndexPath()
	 * @generated
	 */
	void setIndexPath(String value);

	/**
	 * Returns the value of the '<em><b>From Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From Field</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From Field</em>' attribute.
	 * @see #setFromField(String)
	 * @see org.gecko.searchresult.SearchResultPackage#getJoinQuery_FromField()
	 * @model
	 * @generated
	 */
	String getFromField();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.JoinQuery#getFromField <em>From Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From Field</em>' attribute.
	 * @see #getFromField()
	 * @generated
	 */
	void setFromField(String value);

	/**
	 * Returns the value of the '<em><b>To Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To Field</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Field</em>' attribute.
	 * @see #setToField(String)
	 * @see org.gecko.searchresult.SearchResultPackage#getJoinQuery_ToField()
	 * @model
	 * @generated
	 */
	String getToField();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.JoinQuery#getToField <em>To Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Field</em>' attribute.
	 * @see #getToField()
	 * @generated
	 */
	void setToField(String value);

	/**
	 * Returns the value of the '<em><b>Score Mode</b></em>' attribute.
	 * The literals are from the enumeration {@link org.gecko.searchresult.JoinScoreMode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Score Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Score Mode</em>' attribute.
	 * @see org.gecko.searchresult.JoinScoreMode
	 * @see #setScoreMode(JoinScoreMode)
	 * @see org.gecko.searchresult.SearchResultPackage#getJoinQuery_ScoreMode()
	 * @model
	 * @generated
	 */
	JoinScoreMode getScoreMode();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.JoinQuery#getScoreMode <em>Score Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Score Mode</em>' attribute.
	 * @see org.gecko.searchresult.JoinScoreMode
	 * @see #getScoreMode()
	 * @generated
	 */
	void setScoreMode(JoinScoreMode value);

	/**
	 * Returns the value of the '<em><b>Query Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Query Object</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Query Object</em>' attribute.
	 * @see #setQueryObject(Object)
	 * @see org.gecko.searchresult.SearchResultPackage#getJoinQuery_QueryObject()
	 * @model
	 * @generated
	 */
	Object getQueryObject();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.JoinQuery#getQueryObject <em>Query Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Query Object</em>' attribute.
	 * @see #getQueryObject()
	 * @generated
	 */
	void setQueryObject(Object value);

	/**
	 * Returns the value of the '<em><b>Join Aftermath Collectors</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Object}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Join Aftermath Collectors</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Join Aftermath Collectors</em>' attribute list.
	 * @see org.gecko.searchresult.SearchResultPackage#getJoinQuery_JoinAftermathCollectors()
	 * @model
	 * @generated
	 */
	EList<Object> getJoinAftermathCollectors();

	/**
	 * Returns the value of the '<em><b>Occur</b></em>' attribute.
	 * The default value is <code>"SHOULD"</code>.
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
	 * @see org.gecko.searchresult.SearchResultPackage#getJoinQuery_Occur()
	 * @model default="SHOULD"
	 * @generated
	 */
	Occur getOccur();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.JoinQuery#getOccur <em>Occur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Occur</em>' attribute.
	 * @see org.gecko.searchresult.Occur
	 * @see #getOccur()
	 * @generated
	 */
	void setOccur(Occur value);

} // JoinQuery
