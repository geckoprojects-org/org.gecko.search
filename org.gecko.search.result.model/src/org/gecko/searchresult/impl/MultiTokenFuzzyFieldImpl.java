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
package org.gecko.searchresult.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.gecko.searchresult.MultiTokenFuzzyField;
import org.gecko.searchresult.SearchResultPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multi Token Fuzzy Field</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchresult.impl.MultiTokenFuzzyFieldImpl#isUppercase <em>Uppercase</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.MultiTokenFuzzyFieldImpl#getMaxEdits <em>Max Edits</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MultiTokenFuzzyFieldImpl extends MultiTokenTermQueryImpl implements MultiTokenFuzzyField {
	/**
	 * The default value of the '{@link #isUppercase() <em>Uppercase</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUppercase()
	 * @generated
	 * @ordered
	 */
	protected static final boolean UPPERCASE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUppercase() <em>Uppercase</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUppercase()
	 * @generated
	 * @ordered
	 */
	protected boolean uppercase = UPPERCASE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxEdits() <em>Max Edits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxEdits()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_EDITS_EDEFAULT = 2;

	/**
	 * The cached value of the '{@link #getMaxEdits() <em>Max Edits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxEdits()
	 * @generated
	 * @ordered
	 */
	protected int maxEdits = MAX_EDITS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MultiTokenFuzzyFieldImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SearchResultPackage.Literals.MULTI_TOKEN_FUZZY_FIELD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUppercase() {
		return uppercase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUppercase(boolean newUppercase) {
		boolean oldUppercase = uppercase;
		uppercase = newUppercase;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.MULTI_TOKEN_FUZZY_FIELD__UPPERCASE, oldUppercase, uppercase));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxEdits() {
		return maxEdits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxEdits(int newMaxEdits) {
		int oldMaxEdits = maxEdits;
		maxEdits = newMaxEdits;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.MULTI_TOKEN_FUZZY_FIELD__MAX_EDITS, oldMaxEdits, maxEdits));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SearchResultPackage.MULTI_TOKEN_FUZZY_FIELD__UPPERCASE:
				return isUppercase();
			case SearchResultPackage.MULTI_TOKEN_FUZZY_FIELD__MAX_EDITS:
				return getMaxEdits();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SearchResultPackage.MULTI_TOKEN_FUZZY_FIELD__UPPERCASE:
				setUppercase((Boolean)newValue);
				return;
			case SearchResultPackage.MULTI_TOKEN_FUZZY_FIELD__MAX_EDITS:
				setMaxEdits((Integer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SearchResultPackage.MULTI_TOKEN_FUZZY_FIELD__UPPERCASE:
				setUppercase(UPPERCASE_EDEFAULT);
				return;
			case SearchResultPackage.MULTI_TOKEN_FUZZY_FIELD__MAX_EDITS:
				setMaxEdits(MAX_EDITS_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SearchResultPackage.MULTI_TOKEN_FUZZY_FIELD__UPPERCASE:
				return uppercase != UPPERCASE_EDEFAULT;
			case SearchResultPackage.MULTI_TOKEN_FUZZY_FIELD__MAX_EDITS:
				return maxEdits != MAX_EDITS_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (uppercase: ");
		result.append(uppercase);
		result.append(", maxEdits: ");
		result.append(maxEdits);
		result.append(')');
		return result.toString();
	}

} //MultiTokenFuzzyFieldImpl
