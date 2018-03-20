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

import org.gecko.searchresult.FilterField;
import org.gecko.searchresult.FilteringType;
import org.gecko.searchresult.Occur;
import org.gecko.searchresult.SearchResultPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Filter Field</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchresult.impl.FilterFieldImpl#getKey <em>Key</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.FilterFieldImpl#getTokens <em>Tokens</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.FilterFieldImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.FilterFieldImpl#isPrefix <em>Prefix</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.FilterFieldImpl#getOccur <em>Occur</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.FilterFieldImpl#getTokensOccur <em>Tokens Occur</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FilterFieldImpl extends MinimalEObjectImpl.Container implements FilterField {
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
	protected static final FilteringType TYPE_EDEFAULT = FilteringType.OR;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected FilteringType type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #isPrefix() <em>Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPrefix()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PREFIX_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPrefix() <em>Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPrefix()
	 * @generated
	 * @ordered
	 */
	protected boolean prefix = PREFIX_EDEFAULT;

	/**
	 * The default value of the '{@link #getOccur() <em>Occur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOccur()
	 * @generated
	 * @ordered
	 */
	protected static final Occur OCCUR_EDEFAULT = Occur.MUST;

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
	 * The default value of the '{@link #getTokensOccur() <em>Tokens Occur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTokensOccur()
	 * @generated
	 * @ordered
	 */
	protected static final Occur TOKENS_OCCUR_EDEFAULT = Occur.SHOULD;

	/**
	 * The cached value of the '{@link #getTokensOccur() <em>Tokens Occur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTokensOccur()
	 * @generated
	 * @ordered
	 */
	protected Occur tokensOccur = TOKENS_OCCUR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FilterFieldImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SearchResultPackage.Literals.FILTER_FIELD;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.FILTER_FIELD__KEY, oldKey, key));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getTokens() {
		if (tokens == null) {
			tokens = new EDataTypeUniqueEList<String>(String.class, this, SearchResultPackage.FILTER_FIELD__TOKENS);
		}
		return tokens;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FilteringType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(FilteringType newType) {
		FilteringType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.FILTER_FIELD__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPrefix() {
		return prefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrefix(boolean newPrefix) {
		boolean oldPrefix = prefix;
		prefix = newPrefix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.FILTER_FIELD__PREFIX, oldPrefix, prefix));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.FILTER_FIELD__OCCUR, oldOccur, occur));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Occur getTokensOccur() {
		return tokensOccur;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTokensOccur(Occur newTokensOccur) {
		Occur oldTokensOccur = tokensOccur;
		tokensOccur = newTokensOccur == null ? TOKENS_OCCUR_EDEFAULT : newTokensOccur;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.FILTER_FIELD__TOKENS_OCCUR, oldTokensOccur, tokensOccur));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SearchResultPackage.FILTER_FIELD__KEY:
				return getKey();
			case SearchResultPackage.FILTER_FIELD__TOKENS:
				return getTokens();
			case SearchResultPackage.FILTER_FIELD__TYPE:
				return getType();
			case SearchResultPackage.FILTER_FIELD__PREFIX:
				return isPrefix();
			case SearchResultPackage.FILTER_FIELD__OCCUR:
				return getOccur();
			case SearchResultPackage.FILTER_FIELD__TOKENS_OCCUR:
				return getTokensOccur();
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
			case SearchResultPackage.FILTER_FIELD__KEY:
				setKey((String)newValue);
				return;
			case SearchResultPackage.FILTER_FIELD__TOKENS:
				getTokens().clear();
				getTokens().addAll((Collection<? extends String>)newValue);
				return;
			case SearchResultPackage.FILTER_FIELD__TYPE:
				setType((FilteringType)newValue);
				return;
			case SearchResultPackage.FILTER_FIELD__PREFIX:
				setPrefix((Boolean)newValue);
				return;
			case SearchResultPackage.FILTER_FIELD__OCCUR:
				setOccur((Occur)newValue);
				return;
			case SearchResultPackage.FILTER_FIELD__TOKENS_OCCUR:
				setTokensOccur((Occur)newValue);
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
			case SearchResultPackage.FILTER_FIELD__KEY:
				setKey(KEY_EDEFAULT);
				return;
			case SearchResultPackage.FILTER_FIELD__TOKENS:
				getTokens().clear();
				return;
			case SearchResultPackage.FILTER_FIELD__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case SearchResultPackage.FILTER_FIELD__PREFIX:
				setPrefix(PREFIX_EDEFAULT);
				return;
			case SearchResultPackage.FILTER_FIELD__OCCUR:
				setOccur(OCCUR_EDEFAULT);
				return;
			case SearchResultPackage.FILTER_FIELD__TOKENS_OCCUR:
				setTokensOccur(TOKENS_OCCUR_EDEFAULT);
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
			case SearchResultPackage.FILTER_FIELD__KEY:
				return KEY_EDEFAULT == null ? key != null : !KEY_EDEFAULT.equals(key);
			case SearchResultPackage.FILTER_FIELD__TOKENS:
				return tokens != null && !tokens.isEmpty();
			case SearchResultPackage.FILTER_FIELD__TYPE:
				return type != TYPE_EDEFAULT;
			case SearchResultPackage.FILTER_FIELD__PREFIX:
				return prefix != PREFIX_EDEFAULT;
			case SearchResultPackage.FILTER_FIELD__OCCUR:
				return occur != OCCUR_EDEFAULT;
			case SearchResultPackage.FILTER_FIELD__TOKENS_OCCUR:
				return tokensOccur != TOKENS_OCCUR_EDEFAULT;
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
		result.append(", prefix: ");
		result.append(prefix);
		result.append(", occur: ");
		result.append(occur);
		result.append(", tokensOccur: ");
		result.append(tokensOccur);
		result.append(')');
		return result.toString();
	}

} //FilterFieldImpl
