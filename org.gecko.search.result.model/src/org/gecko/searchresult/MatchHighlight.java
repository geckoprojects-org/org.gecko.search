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
 * A representation of the model object '<em><b>Match Highlight</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchresult.MatchHighlight#getStartOffset <em>Start Offset</em>}</li>
 *   <li>{@link org.gecko.searchresult.MatchHighlight#getEndOffset <em>End Offset</em>}</li>
 *   <li>{@link org.gecko.searchresult.MatchHighlight#getText <em>Text</em>}</li>
 *   <li>{@link org.gecko.searchresult.MatchHighlight#getHighlightedText <em>Highlighted Text</em>}</li>
 * </ul>
 *
 * @see org.gecko.searchresult.SearchResultPackage#getMatchHighlight()
 * @model
 * @generated
 */
public interface MatchHighlight extends EObject {
	/**
	 * Returns the value of the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Offset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Offset</em>' attribute.
	 * @see #setStartOffset(int)
	 * @see org.gecko.searchresult.SearchResultPackage#getMatchHighlight_StartOffset()
	 * @model required="true"
	 * @generated
	 */
	int getStartOffset();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.MatchHighlight#getStartOffset <em>Start Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Offset</em>' attribute.
	 * @see #getStartOffset()
	 * @generated
	 */
	void setStartOffset(int value);

	/**
	 * Returns the value of the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Offset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Offset</em>' attribute.
	 * @see #setEndOffset(int)
	 * @see org.gecko.searchresult.SearchResultPackage#getMatchHighlight_EndOffset()
	 * @model required="true"
	 * @generated
	 */
	int getEndOffset();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.MatchHighlight#getEndOffset <em>End Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Offset</em>' attribute.
	 * @see #getEndOffset()
	 * @generated
	 */
	void setEndOffset(int value);

	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see org.gecko.searchresult.SearchResultPackage#getMatchHighlight_Text()
	 * @model
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.MatchHighlight#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

	/**
	 * Returns the value of the '<em><b>Highlighted Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Highlighted Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Highlighted Text</em>' attribute.
	 * @see #setHighlightedText(String)
	 * @see org.gecko.searchresult.SearchResultPackage#getMatchHighlight_HighlightedText()
	 * @model
	 * @generated
	 */
	String getHighlightedText();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.MatchHighlight#getHighlightedText <em>Highlighted Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Highlighted Text</em>' attribute.
	 * @see #getHighlightedText()
	 * @generated
	 */
	void setHighlightedText(String value);

} // MatchHighlight
