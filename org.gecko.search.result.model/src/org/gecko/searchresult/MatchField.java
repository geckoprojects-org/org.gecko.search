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

import org.gecko.emf.utilities.Converter;
import org.gecko.emf.utilities.FeaturePath;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Match Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchresult.MatchField#getId <em>Id</em>}</li>
 *   <li>{@link org.gecko.searchresult.MatchField#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.gecko.searchresult.MatchField#getConverter <em>Converter</em>}</li>
 *   <li>{@link org.gecko.searchresult.MatchField#isMultiValue <em>Multi Value</em>}</li>
 *   <li>{@link org.gecko.searchresult.MatchField#getValue <em>Value</em>}</li>
 *   <li>{@link org.gecko.searchresult.MatchField#getHighlighting <em>Highlighting</em>}</li>
 * </ul>
 *
 * @see org.gecko.searchresult.SearchResultPackage#getMatchField()
 * @model
 * @generated
 */
public interface MatchField extends EObject {
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
	 * @see org.gecko.searchresult.SearchResultPackage#getMatchField_Id()
	 * @model id="true" required="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.MatchField#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Feature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature</em>' containment reference.
	 * @see #setFeature(FeaturePath)
	 * @see org.gecko.searchresult.SearchResultPackage#getMatchField_Feature()
	 * @model containment="true"
	 * @generated
	 */
	FeaturePath getFeature();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.MatchField#getFeature <em>Feature</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature</em>' containment reference.
	 * @see #getFeature()
	 * @generated
	 */
	void setFeature(FeaturePath value);

	/**
	 * Returns the value of the '<em><b>Converter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Converter</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Converter</em>' containment reference.
	 * @see #setConverter(Converter)
	 * @see org.gecko.searchresult.SearchResultPackage#getMatchField_Converter()
	 * @model containment="true"
	 * @generated
	 */
	Converter getConverter();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.MatchField#getConverter <em>Converter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Converter</em>' containment reference.
	 * @see #getConverter()
	 * @generated
	 */
	void setConverter(Converter value);

	/**
	 * Returns the value of the '<em><b>Multi Value</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multi Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multi Value</em>' attribute.
	 * @see #setMultiValue(boolean)
	 * @see org.gecko.searchresult.SearchResultPackage#getMatchField_MultiValue()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isMultiValue();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.MatchField#isMultiValue <em>Multi Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multi Value</em>' attribute.
	 * @see #isMultiValue()
	 * @generated
	 */
	void setMultiValue(boolean value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(Object)
	 * @see org.gecko.searchresult.SearchResultPackage#getMatchField_Value()
	 * @model required="true"
	 * @generated
	 */
	Object getValue();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.MatchField#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Object value);

	/**
	 * Returns the value of the '<em><b>Highlighting</b></em>' containment reference list.
	 * The list contents are of type {@link org.gecko.searchresult.MatchHighlight}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Highlighting</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Highlighting</em>' containment reference list.
	 * @see org.gecko.searchresult.SearchResultPackage#getMatchField_Highlighting()
	 * @model containment="true"
	 * @generated
	 */
	EList<MatchHighlight> getHighlighting();

} // MatchField
