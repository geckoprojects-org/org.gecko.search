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

import org.gecko.searchresult.PhraseQuery;
import org.gecko.searchresult.SearchResultPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Phrase Query</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchresult.impl.PhraseQueryImpl#getSlop <em>Slop</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.PhraseQueryImpl#getTerms <em>Terms</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PhraseQueryImpl extends LuceneQueryFieldImpl implements PhraseQuery {
	/**
	 * The default value of the '{@link #getSlop() <em>Slop</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlop()
	 * @generated
	 * @ordered
	 */
	protected static final int SLOP_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSlop() <em>Slop</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlop()
	 * @generated
	 * @ordered
	 */
	protected int slop = SLOP_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTerms() <em>Terms</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTerms()
	 * @generated
	 * @ordered
	 */
	protected EList<String> terms;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PhraseQueryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SearchResultPackage.Literals.PHRASE_QUERY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSlop() {
		return slop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSlop(int newSlop) {
		int oldSlop = slop;
		slop = newSlop;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.PHRASE_QUERY__SLOP, oldSlop, slop));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getTerms() {
		if (terms == null) {
			terms = new EDataTypeUniqueEList<String>(String.class, this, SearchResultPackage.PHRASE_QUERY__TERMS);
		}
		return terms;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SearchResultPackage.PHRASE_QUERY__SLOP:
				return getSlop();
			case SearchResultPackage.PHRASE_QUERY__TERMS:
				return getTerms();
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
			case SearchResultPackage.PHRASE_QUERY__SLOP:
				setSlop((Integer)newValue);
				return;
			case SearchResultPackage.PHRASE_QUERY__TERMS:
				getTerms().clear();
				getTerms().addAll((Collection<? extends String>)newValue);
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
			case SearchResultPackage.PHRASE_QUERY__SLOP:
				setSlop(SLOP_EDEFAULT);
				return;
			case SearchResultPackage.PHRASE_QUERY__TERMS:
				getTerms().clear();
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
			case SearchResultPackage.PHRASE_QUERY__SLOP:
				return slop != SLOP_EDEFAULT;
			case SearchResultPackage.PHRASE_QUERY__TERMS:
				return terms != null && !terms.isEmpty();
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
		result.append(" (slop: ");
		result.append(slop);
		result.append(", terms: ");
		result.append(terms);
		result.append(')');
		return result.toString();
	}

} //PhraseQueryImpl
