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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.gecko.searchresult.FacetFilter;
import org.gecko.searchresult.SearchResultPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Facet Filter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchresult.impl.FacetFilterImpl#getFacetKey <em>Facet Key</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.FacetFilterImpl#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FacetFilterImpl extends MinimalEObjectImpl.Container implements FacetFilter {
	/**
	 * The default value of the '{@link #getFacetKey() <em>Facet Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacetKey()
	 * @generated
	 * @ordered
	 */
	protected static final String FACET_KEY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFacetKey() <em>Facet Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacetKey()
	 * @generated
	 * @ordered
	 */
	protected String facetKey = FACET_KEY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected EList<String> value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FacetFilterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SearchResultPackage.Literals.FACET_FILTER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFacetKey() {
		return facetKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFacetKey(String newFacetKey) {
		String oldFacetKey = facetKey;
		facetKey = newFacetKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.FACET_FILTER__FACET_KEY, oldFacetKey, facetKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getValue() {
		if (value == null) {
			value = new EDataTypeUniqueEList<String>(String.class, this, SearchResultPackage.FACET_FILTER__VALUE);
		}
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SearchResultPackage.FACET_FILTER__FACET_KEY:
				return getFacetKey();
			case SearchResultPackage.FACET_FILTER__VALUE:
				return getValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SearchResultPackage.FACET_FILTER__FACET_KEY:
				setFacetKey((String)newValue);
				return;
			case SearchResultPackage.FACET_FILTER__VALUE:
				getValue().clear();
				getValue().addAll((Collection<? extends String>)newValue);
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
			case SearchResultPackage.FACET_FILTER__FACET_KEY:
				setFacetKey(FACET_KEY_EDEFAULT);
				return;
			case SearchResultPackage.FACET_FILTER__VALUE:
				getValue().clear();
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
			case SearchResultPackage.FACET_FILTER__FACET_KEY:
				return FACET_KEY_EDEFAULT == null ? facetKey != null : !FACET_KEY_EDEFAULT.equals(facetKey);
			case SearchResultPackage.FACET_FILTER__VALUE:
				return value != null && !value.isEmpty();
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
		result.append(" (facetKey: ");
		result.append(facetKey);
		result.append(", value: ");
		result.append(value);
		result.append(')');
		return result.toString();
	}

} //FacetFilterImpl
