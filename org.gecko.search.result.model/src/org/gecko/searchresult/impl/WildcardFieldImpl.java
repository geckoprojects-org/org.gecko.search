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

import org.gecko.searchresult.SearchResultPackage;
import org.gecko.searchresult.WildcardField;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Wildcard Field</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchresult.impl.WildcardFieldImpl#isStartWithWildcard <em>Start With Wildcard</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.WildcardFieldImpl#isEndWithWildcard <em>End With Wildcard</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.WildcardFieldImpl#isIncludeUpperCase <em>Include Upper Case</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WildcardFieldImpl extends MultiTokenTermQueryImpl implements WildcardField {
	/**
	 * The default value of the '{@link #isStartWithWildcard() <em>Start With Wildcard</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStartWithWildcard()
	 * @generated
	 * @ordered
	 */
	protected static final boolean START_WITH_WILDCARD_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isStartWithWildcard() <em>Start With Wildcard</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStartWithWildcard()
	 * @generated
	 * @ordered
	 */
	protected boolean startWithWildcard = START_WITH_WILDCARD_EDEFAULT;

	/**
	 * The default value of the '{@link #isEndWithWildcard() <em>End With Wildcard</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEndWithWildcard()
	 * @generated
	 * @ordered
	 */
	protected static final boolean END_WITH_WILDCARD_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isEndWithWildcard() <em>End With Wildcard</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEndWithWildcard()
	 * @generated
	 * @ordered
	 */
	protected boolean endWithWildcard = END_WITH_WILDCARD_EDEFAULT;

	/**
	 * The default value of the '{@link #isIncludeUpperCase() <em>Include Upper Case</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIncludeUpperCase()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INCLUDE_UPPER_CASE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isIncludeUpperCase() <em>Include Upper Case</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIncludeUpperCase()
	 * @generated
	 * @ordered
	 */
	protected boolean includeUpperCase = INCLUDE_UPPER_CASE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WildcardFieldImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SearchResultPackage.Literals.WILDCARD_FIELD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isStartWithWildcard() {
		return startWithWildcard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartWithWildcard(boolean newStartWithWildcard) {
		boolean oldStartWithWildcard = startWithWildcard;
		startWithWildcard = newStartWithWildcard;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.WILDCARD_FIELD__START_WITH_WILDCARD, oldStartWithWildcard, startWithWildcard));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEndWithWildcard() {
		return endWithWildcard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndWithWildcard(boolean newEndWithWildcard) {
		boolean oldEndWithWildcard = endWithWildcard;
		endWithWildcard = newEndWithWildcard;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.WILDCARD_FIELD__END_WITH_WILDCARD, oldEndWithWildcard, endWithWildcard));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIncludeUpperCase() {
		return includeUpperCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIncludeUpperCase(boolean newIncludeUpperCase) {
		boolean oldIncludeUpperCase = includeUpperCase;
		includeUpperCase = newIncludeUpperCase;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.WILDCARD_FIELD__INCLUDE_UPPER_CASE, oldIncludeUpperCase, includeUpperCase));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SearchResultPackage.WILDCARD_FIELD__START_WITH_WILDCARD:
				return isStartWithWildcard();
			case SearchResultPackage.WILDCARD_FIELD__END_WITH_WILDCARD:
				return isEndWithWildcard();
			case SearchResultPackage.WILDCARD_FIELD__INCLUDE_UPPER_CASE:
				return isIncludeUpperCase();
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
			case SearchResultPackage.WILDCARD_FIELD__START_WITH_WILDCARD:
				setStartWithWildcard((Boolean)newValue);
				return;
			case SearchResultPackage.WILDCARD_FIELD__END_WITH_WILDCARD:
				setEndWithWildcard((Boolean)newValue);
				return;
			case SearchResultPackage.WILDCARD_FIELD__INCLUDE_UPPER_CASE:
				setIncludeUpperCase((Boolean)newValue);
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
			case SearchResultPackage.WILDCARD_FIELD__START_WITH_WILDCARD:
				setStartWithWildcard(START_WITH_WILDCARD_EDEFAULT);
				return;
			case SearchResultPackage.WILDCARD_FIELD__END_WITH_WILDCARD:
				setEndWithWildcard(END_WITH_WILDCARD_EDEFAULT);
				return;
			case SearchResultPackage.WILDCARD_FIELD__INCLUDE_UPPER_CASE:
				setIncludeUpperCase(INCLUDE_UPPER_CASE_EDEFAULT);
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
			case SearchResultPackage.WILDCARD_FIELD__START_WITH_WILDCARD:
				return startWithWildcard != START_WITH_WILDCARD_EDEFAULT;
			case SearchResultPackage.WILDCARD_FIELD__END_WITH_WILDCARD:
				return endWithWildcard != END_WITH_WILDCARD_EDEFAULT;
			case SearchResultPackage.WILDCARD_FIELD__INCLUDE_UPPER_CASE:
				return includeUpperCase != INCLUDE_UPPER_CASE_EDEFAULT;
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
		result.append(" (startWithWildcard: ");
		result.append(startWithWildcard);
		result.append(", endWithWildcard: ");
		result.append(endWithWildcard);
		result.append(", includeUpperCase: ");
		result.append(includeUpperCase);
		result.append(')');
		return result.toString();
	}

} //WildcardFieldImpl
