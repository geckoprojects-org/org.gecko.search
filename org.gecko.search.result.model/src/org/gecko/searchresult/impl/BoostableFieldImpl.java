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

import org.gecko.searchresult.BoostableField;
import org.gecko.searchresult.SearchResultPackage;

import org.gecko.utilities.query.impl.QueryConditionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Boostable Field</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchresult.impl.BoostableFieldImpl#getBoost <em>Boost</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BoostableFieldImpl extends QueryConditionImpl implements BoostableField {
	/**
	 * The default value of the '{@link #getBoost() <em>Boost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoost()
	 * @generated
	 * @ordered
	 */
	protected static final float BOOST_EDEFAULT = 0.4F;

	/**
	 * The cached value of the '{@link #getBoost() <em>Boost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoost()
	 * @generated
	 * @ordered
	 */
	protected float boost = BOOST_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BoostableFieldImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SearchResultPackage.Literals.BOOSTABLE_FIELD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getBoost() {
		return boost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoost(float newBoost) {
		float oldBoost = boost;
		boost = newBoost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.BOOSTABLE_FIELD__BOOST, oldBoost, boost));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SearchResultPackage.BOOSTABLE_FIELD__BOOST:
				return getBoost();
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
			case SearchResultPackage.BOOSTABLE_FIELD__BOOST:
				setBoost((Float)newValue);
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
			case SearchResultPackage.BOOSTABLE_FIELD__BOOST:
				setBoost(BOOST_EDEFAULT);
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
			case SearchResultPackage.BOOSTABLE_FIELD__BOOST:
				return boost != BOOST_EDEFAULT;
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
		result.append(" (boost: ");
		result.append(boost);
		result.append(')');
		return result.toString();
	}

} //BoostableFieldImpl
