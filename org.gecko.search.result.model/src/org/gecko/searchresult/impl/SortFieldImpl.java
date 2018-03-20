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

import org.gecko.searchresult.Occur;
import org.gecko.searchresult.SearchResultPackage;
import org.gecko.searchresult.SortDirectionType;
import org.gecko.searchresult.SortField;
import org.gecko.searchresult.SortType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sort Field</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchresult.impl.SortFieldImpl#getKey <em>Key</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.SortFieldImpl#getTokens <em>Tokens</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.SortFieldImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.SortFieldImpl#getDirection <em>Direction</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.SortFieldImpl#getOccur <em>Occur</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SortFieldImpl extends MinimalEObjectImpl.Container implements SortField {
	/**
	 * The default value of the '{@link #getKey() <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKey()
	 * @generated
	 * @ordered
	 */
	protected static final String KEY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKey() <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKey()
	 * @generated
	 * @ordered
	 */
	protected String key = KEY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTokens() <em>Tokens</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTokens()
	 * @generated
	 * @ordered
	 */
	protected EList<String> tokens;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final SortType TYPE_EDEFAULT = SortType.SCORE;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected SortType type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected static final SortDirectionType DIRECTION_EDEFAULT = SortDirectionType.ASCENDING;

	/**
	 * The cached value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected SortDirectionType direction = DIRECTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getOccur() <em>Occur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOccur()
	 * @generated
	 * @ordered
	 */
	protected static final Occur OCCUR_EDEFAULT = Occur.SHOULD;

	/**
	 * The cached value of the '{@link #getOccur() <em>Occur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOccur()
	 * @generated
	 * @ordered
	 */
	protected Occur occur = OCCUR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SortFieldImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SearchResultPackage.Literals.SORT_FIELD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getKey() {
		return key;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKey(String newKey) {
		String oldKey = key;
		key = newKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.SORT_FIELD__KEY, oldKey, key));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getTokens() {
		if (tokens == null) {
			tokens = new EDataTypeUniqueEList<String>(String.class, this, SearchResultPackage.SORT_FIELD__TOKENS);
		}
		return tokens;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SortType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(SortType newType) {
		SortType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.SORT_FIELD__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SortDirectionType getDirection() {
		return direction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirection(SortDirectionType newDirection) {
		SortDirectionType oldDirection = direction;
		direction = newDirection == null ? DIRECTION_EDEFAULT : newDirection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.SORT_FIELD__DIRECTION, oldDirection, direction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Occur getOccur() {
		return occur;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOccur(Occur newOccur) {
		Occur oldOccur = occur;
		occur = newOccur == null ? OCCUR_EDEFAULT : newOccur;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.SORT_FIELD__OCCUR, oldOccur, occur));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SearchResultPackage.SORT_FIELD__KEY:
				return getKey();
			case SearchResultPackage.SORT_FIELD__TOKENS:
				return getTokens();
			case SearchResultPackage.SORT_FIELD__TYPE:
				return getType();
			case SearchResultPackage.SORT_FIELD__DIRECTION:
				return getDirection();
			case SearchResultPackage.SORT_FIELD__OCCUR:
				return getOccur();
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
			case SearchResultPackage.SORT_FIELD__KEY:
				setKey((String)newValue);
				return;
			case SearchResultPackage.SORT_FIELD__TOKENS:
				getTokens().clear();
				getTokens().addAll((Collection<? extends String>)newValue);
				return;
			case SearchResultPackage.SORT_FIELD__TYPE:
				setType((SortType)newValue);
				return;
			case SearchResultPackage.SORT_FIELD__DIRECTION:
				setDirection((SortDirectionType)newValue);
				return;
			case SearchResultPackage.SORT_FIELD__OCCUR:
				setOccur((Occur)newValue);
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
			case SearchResultPackage.SORT_FIELD__KEY:
				setKey(KEY_EDEFAULT);
				return;
			case SearchResultPackage.SORT_FIELD__TOKENS:
				getTokens().clear();
				return;
			case SearchResultPackage.SORT_FIELD__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case SearchResultPackage.SORT_FIELD__DIRECTION:
				setDirection(DIRECTION_EDEFAULT);
				return;
			case SearchResultPackage.SORT_FIELD__OCCUR:
				setOccur(OCCUR_EDEFAULT);
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
			case SearchResultPackage.SORT_FIELD__KEY:
				return KEY_EDEFAULT == null ? key != null : !KEY_EDEFAULT.equals(key);
			case SearchResultPackage.SORT_FIELD__TOKENS:
				return tokens != null && !tokens.isEmpty();
			case SearchResultPackage.SORT_FIELD__TYPE:
				return type != TYPE_EDEFAULT;
			case SearchResultPackage.SORT_FIELD__DIRECTION:
				return direction != DIRECTION_EDEFAULT;
			case SearchResultPackage.SORT_FIELD__OCCUR:
				return occur != OCCUR_EDEFAULT;
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
		result.append(" (key: ");
		result.append(key);
		result.append(", tokens: ");
		result.append(tokens);
		result.append(", type: ");
		result.append(type);
		result.append(", direction: ");
		result.append(direction);
		result.append(", occur: ");
		result.append(occur);
		result.append(')');
		return result.toString();
	}

} //SortFieldImpl
