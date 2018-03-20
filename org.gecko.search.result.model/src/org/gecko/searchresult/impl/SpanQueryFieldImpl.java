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
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.gecko.searchresult.LuceneQueryField;
import org.gecko.searchresult.SearchResultPackage;
import org.gecko.searchresult.SpanQueryField;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Span Query Field</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchresult.impl.SpanQueryFieldImpl#getSpan <em>Span</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.SpanQueryFieldImpl#getQueryFields <em>Query Fields</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SpanQueryFieldImpl extends LuceneQueryFieldImpl implements SpanQueryField {
	/**
	 * The default value of the '{@link #getSpan() <em>Span</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpan()
	 * @generated
	 * @ordered
	 */
	protected static final int SPAN_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getSpan() <em>Span</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpan()
	 * @generated
	 * @ordered
	 */
	protected int span = SPAN_EDEFAULT;

	/**
	 * The cached value of the '{@link #getQueryFields() <em>Query Fields</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueryFields()
	 * @generated
	 * @ordered
	 */
	protected EList<LuceneQueryField> queryFields;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpanQueryFieldImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SearchResultPackage.Literals.SPAN_QUERY_FIELD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSpan() {
		return span;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpan(int newSpan) {
		int oldSpan = span;
		span = newSpan;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.SPAN_QUERY_FIELD__SPAN, oldSpan, span));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LuceneQueryField> getQueryFields() {
		if (queryFields == null) {
			queryFields = new EObjectContainmentEList<LuceneQueryField>(LuceneQueryField.class, this, SearchResultPackage.SPAN_QUERY_FIELD__QUERY_FIELDS);
		}
		return queryFields;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SearchResultPackage.SPAN_QUERY_FIELD__QUERY_FIELDS:
				return ((InternalEList<?>)getQueryFields()).basicRemove(otherEnd, msgs);
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
			case SearchResultPackage.SPAN_QUERY_FIELD__SPAN:
				return getSpan();
			case SearchResultPackage.SPAN_QUERY_FIELD__QUERY_FIELDS:
				return getQueryFields();
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
			case SearchResultPackage.SPAN_QUERY_FIELD__SPAN:
				setSpan((Integer)newValue);
				return;
			case SearchResultPackage.SPAN_QUERY_FIELD__QUERY_FIELDS:
				getQueryFields().clear();
				getQueryFields().addAll((Collection<? extends LuceneQueryField>)newValue);
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
			case SearchResultPackage.SPAN_QUERY_FIELD__SPAN:
				setSpan(SPAN_EDEFAULT);
				return;
			case SearchResultPackage.SPAN_QUERY_FIELD__QUERY_FIELDS:
				getQueryFields().clear();
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
			case SearchResultPackage.SPAN_QUERY_FIELD__SPAN:
				return span != SPAN_EDEFAULT;
			case SearchResultPackage.SPAN_QUERY_FIELD__QUERY_FIELDS:
				return queryFields != null && !queryFields.isEmpty();
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
		result.append(" (span: ");
		result.append(span);
		result.append(')');
		return result.toString();
	}

} //SpanQueryFieldImpl
