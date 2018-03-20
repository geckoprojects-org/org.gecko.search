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

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.gecko.searchresult.MultiTokenTermQuery;
import org.gecko.searchresult.Occur;
import org.gecko.searchresult.SearchResultPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multi Token Term Query</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchresult.impl.MultiTokenTermQueryImpl#getTokens <em>Tokens</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.MultiTokenTermQueryImpl#isPrefix <em>Prefix</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.MultiTokenTermQueryImpl#getTokensOccur <em>Tokens Occur</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MultiTokenTermQueryImpl extends LuceneQueryFieldImpl implements MultiTokenTermQuery {
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
	protected MultiTokenTermQueryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SearchResultPackage.Literals.MULTI_TOKEN_TERM_QUERY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getTokens() {
		if (tokens == null) {
			tokens = new EDataTypeUniqueEList<String>(String.class, this, SearchResultPackage.MULTI_TOKEN_TERM_QUERY__TOKENS);
		}
		return tokens;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.MULTI_TOKEN_TERM_QUERY__PREFIX, oldPrefix, prefix));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.MULTI_TOKEN_TERM_QUERY__TOKENS_OCCUR, oldTokensOccur, tokensOccur));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SearchResultPackage.MULTI_TOKEN_TERM_QUERY__TOKENS:
				return getTokens();
			case SearchResultPackage.MULTI_TOKEN_TERM_QUERY__PREFIX:
				return isPrefix();
			case SearchResultPackage.MULTI_TOKEN_TERM_QUERY__TOKENS_OCCUR:
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
			case SearchResultPackage.MULTI_TOKEN_TERM_QUERY__TOKENS:
				getTokens().clear();
				getTokens().addAll((Collection<? extends String>)newValue);
				return;
			case SearchResultPackage.MULTI_TOKEN_TERM_QUERY__PREFIX:
				setPrefix((Boolean)newValue);
				return;
			case SearchResultPackage.MULTI_TOKEN_TERM_QUERY__TOKENS_OCCUR:
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
			case SearchResultPackage.MULTI_TOKEN_TERM_QUERY__TOKENS:
				getTokens().clear();
				return;
			case SearchResultPackage.MULTI_TOKEN_TERM_QUERY__PREFIX:
				setPrefix(PREFIX_EDEFAULT);
				return;
			case SearchResultPackage.MULTI_TOKEN_TERM_QUERY__TOKENS_OCCUR:
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
			case SearchResultPackage.MULTI_TOKEN_TERM_QUERY__TOKENS:
				return tokens != null && !tokens.isEmpty();
			case SearchResultPackage.MULTI_TOKEN_TERM_QUERY__PREFIX:
				return prefix != PREFIX_EDEFAULT;
			case SearchResultPackage.MULTI_TOKEN_TERM_QUERY__TOKENS_OCCUR:
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
		result.append(" (tokens: ");
		result.append(tokens);
		result.append(", prefix: ");
		result.append(prefix);
		result.append(", tokensOccur: ");
		result.append(tokensOccur);
		result.append(')');
		return result.toString();
	}

} //MultiTokenTermQueryImpl
