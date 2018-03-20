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
 * A representation of the model object '<em><b>Match Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchresult.MatchResult#getId <em>Id</em>}</li>
 *   <li>{@link org.gecko.searchresult.MatchResult#getHighlights <em>Highlights</em>}</li>
 *   <li>{@link org.gecko.searchresult.MatchResult#getFields <em>Fields</em>}</li>
 *   <li>{@link org.gecko.searchresult.MatchResult#getScore <em>Score</em>}</li>
 *   <li>{@link org.gecko.searchresult.MatchResult#getExplanation <em>Explanation</em>}</li>
 * </ul>
 *
 * @see org.gecko.searchresult.SearchResultPackage#getMatchResult()
 * @model
 * @generated
 */
public interface MatchResult extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.gecko.searchresult.SearchResultPackage#getMatchResult_Id()
	 * @model id="true" required="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.MatchResult#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Highlights</b></em>' containment reference list.
	 * The list contents are of type {@link org.gecko.searchresult.MatchHighlight}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Highlights</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Highlights</em>' containment reference list.
	 * @see org.gecko.searchresult.SearchResultPackage#getMatchResult_Highlights()
	 * @model containment="true"
	 * @generated
	 */
	EList<MatchHighlight> getHighlights();

	/**
	 * Returns the value of the '<em><b>Fields</b></em>' containment reference list.
	 * The list contents are of type {@link org.gecko.searchresult.MatchField}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fields</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fields</em>' containment reference list.
	 * @see org.gecko.searchresult.SearchResultPackage#getMatchResult_Fields()
	 * @model containment="true" keys="id"
	 * @generated
	 */
	EList<MatchField> getFields();

	/**
	 * Returns the value of the '<em><b>Score</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Score</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Score</em>' attribute.
	 * @see #setScore(float)
	 * @see org.gecko.searchresult.SearchResultPackage#getMatchResult_Score()
	 * @model
	 * @generated
	 */
	float getScore();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.MatchResult#getScore <em>Score</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Score</em>' attribute.
	 * @see #getScore()
	 * @generated
	 */
	void setScore(float value);

	/**
	 * Returns the value of the '<em><b>Explanation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Explanation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Explanation</em>' attribute.
	 * @see #setExplanation(Object)
	 * @see org.gecko.searchresult.SearchResultPackage#getMatchResult_Explanation()
	 * @model
	 * @generated
	 */
	Object getExplanation();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.MatchResult#getExplanation <em>Explanation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Explanation</em>' attribute.
	 * @see #getExplanation()
	 * @generated
	 */
	void setExplanation(Object value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model keyRequired="true"
	 * @generated
	 */
	MatchField getMatchFieldById(String key);

} // MatchResult
