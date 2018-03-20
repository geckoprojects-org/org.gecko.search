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
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.gecko.emf.utilities.LatLng;

import org.gecko.searchresult.SearchResultPackage;
import org.gecko.searchresult.SpatialSortField;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Spatial Sort Field</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchresult.impl.SpatialSortFieldImpl#getLatLng <em>Lat Lng</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SpatialSortFieldImpl extends SortFieldImpl implements SpatialSortField {
	/**
	 * The cached value of the '{@link #getLatLng() <em>Lat Lng</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLatLng()
	 * @generated
	 * @ordered
	 */
	protected LatLng latLng;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpatialSortFieldImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SearchResultPackage.Literals.SPATIAL_SORT_FIELD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LatLng getLatLng() {
		return latLng;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLatLng(LatLng newLatLng, NotificationChain msgs) {
		LatLng oldLatLng = latLng;
		latLng = newLatLng;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SearchResultPackage.SPATIAL_SORT_FIELD__LAT_LNG, oldLatLng, newLatLng);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLatLng(LatLng newLatLng) {
		if (newLatLng != latLng) {
			NotificationChain msgs = null;
			if (latLng != null)
				msgs = ((InternalEObject)latLng).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SearchResultPackage.SPATIAL_SORT_FIELD__LAT_LNG, null, msgs);
			if (newLatLng != null)
				msgs = ((InternalEObject)newLatLng).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SearchResultPackage.SPATIAL_SORT_FIELD__LAT_LNG, null, msgs);
			msgs = basicSetLatLng(newLatLng, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.SPATIAL_SORT_FIELD__LAT_LNG, newLatLng, newLatLng));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SearchResultPackage.SPATIAL_SORT_FIELD__LAT_LNG:
				return basicSetLatLng(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SearchResultPackage.SPATIAL_SORT_FIELD__LAT_LNG:
				return getLatLng();
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
			case SearchResultPackage.SPATIAL_SORT_FIELD__LAT_LNG:
				setLatLng((LatLng)newValue);
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
			case SearchResultPackage.SPATIAL_SORT_FIELD__LAT_LNG:
				setLatLng((LatLng)null);
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
			case SearchResultPackage.SPATIAL_SORT_FIELD__LAT_LNG:
				return latLng != null;
		}
		return super.eIsSet(featureID);
	}

} //SpatialSortFieldImpl
