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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.gecko.searchresult.FilterField;
import org.gecko.searchresult.LikeThisObject;
import org.gecko.searchresult.SearchResultPackage;
import org.gecko.searchresult.SortField;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Like This Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchresult.impl.LikeThisObjectImpl#getLikeThisFields <em>Like This Fields</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.LikeThisObjectImpl#getFilterFields <em>Filter Fields</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.LikeThisObjectImpl#getSortFields <em>Sort Fields</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.LikeThisObjectImpl#isFilterSourceObject <em>Filter Source Object</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.LikeThisObjectImpl#getFilterSourceField <em>Filter Source Field</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.LikeThisObjectImpl#getMaxResults <em>Max Results</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LikeThisObjectImpl extends MinimalEObjectImpl.Container implements LikeThisObject {
	/**
	 * The cached value of the '{@link #getLikeThisFields() <em>Like This Fields</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLikeThisFields()
	 * @generated
	 * @ordered
	 */
	protected EList<String> likeThisFields;

	/**
	 * The cached value of the '{@link #getFilterFields() <em>Filter Fields</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilterFields()
	 * @generated
	 * @ordered
	 */
	protected EList<FilterField> filterFields;

	/**
	 * The cached value of the '{@link #getSortFields() <em>Sort Fields</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSortFields()
	 * @generated
	 * @ordered
	 */
	protected EList<SortField> sortFields;

	/**
	 * The default value of the '{@link #isFilterSourceObject() <em>Filter Source Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFilterSourceObject()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FILTER_SOURCE_OBJECT_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isFilterSourceObject() <em>Filter Source Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFilterSourceObject()
	 * @generated
	 * @ordered
	 */
	protected boolean filterSourceObject = FILTER_SOURCE_OBJECT_EDEFAULT;

	/**
	 * The default value of the '{@link #getFilterSourceField() <em>Filter Source Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilterSourceField()
	 * @generated
	 * @ordered
	 */
	protected static final String FILTER_SOURCE_FIELD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFilterSourceField() <em>Filter Source Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilterSourceField()
	 * @generated
	 * @ordered
	 */
	protected String filterSourceField = FILTER_SOURCE_FIELD_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxResults() <em>Max Results</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxResults()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_RESULTS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxResults() <em>Max Results</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxResults()
	 * @generated
	 * @ordered
	 */
	protected int maxResults = MAX_RESULTS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LikeThisObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SearchResultPackage.Literals.LIKE_THIS_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getLikeThisFields() {
		if (likeThisFields == null) {
			likeThisFields = new EDataTypeUniqueEList<String>(String.class, this, SearchResultPackage.LIKE_THIS_OBJECT__LIKE_THIS_FIELDS);
		}
		return likeThisFields;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FilterField> getFilterFields() {
		if (filterFields == null) {
			filterFields = new EObjectContainmentEList<FilterField>(FilterField.class, this, SearchResultPackage.LIKE_THIS_OBJECT__FILTER_FIELDS);
		}
		return filterFields;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SortField> getSortFields() {
		if (sortFields == null) {
			sortFields = new EObjectContainmentEList<SortField>(SortField.class, this, SearchResultPackage.LIKE_THIS_OBJECT__SORT_FIELDS);
		}
		return sortFields;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFilterSourceObject() {
		return filterSourceObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilterSourceObject(boolean newFilterSourceObject) {
		boolean oldFilterSourceObject = filterSourceObject;
		filterSourceObject = newFilterSourceObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.LIKE_THIS_OBJECT__FILTER_SOURCE_OBJECT, oldFilterSourceObject, filterSourceObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFilterSourceField() {
		return filterSourceField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilterSourceField(String newFilterSourceField) {
		String oldFilterSourceField = filterSourceField;
		filterSourceField = newFilterSourceField;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.LIKE_THIS_OBJECT__FILTER_SOURCE_FIELD, oldFilterSourceField, filterSourceField));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxResults() {
		return maxResults;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxResults(int newMaxResults) {
		int oldMaxResults = maxResults;
		maxResults = newMaxResults;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.LIKE_THIS_OBJECT__MAX_RESULTS, oldMaxResults, maxResults));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SearchResultPackage.LIKE_THIS_OBJECT__FILTER_FIELDS:
				return ((InternalEList<?>)getFilterFields()).basicRemove(otherEnd, msgs);
			case SearchResultPackage.LIKE_THIS_OBJECT__SORT_FIELDS:
				return ((InternalEList<?>)getSortFields()).basicRemove(otherEnd, msgs);
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
			case SearchResultPackage.LIKE_THIS_OBJECT__LIKE_THIS_FIELDS:
				return getLikeThisFields();
			case SearchResultPackage.LIKE_THIS_OBJECT__FILTER_FIELDS:
				return getFilterFields();
			case SearchResultPackage.LIKE_THIS_OBJECT__SORT_FIELDS:
				return getSortFields();
			case SearchResultPackage.LIKE_THIS_OBJECT__FILTER_SOURCE_OBJECT:
				return isFilterSourceObject();
			case SearchResultPackage.LIKE_THIS_OBJECT__FILTER_SOURCE_FIELD:
				return getFilterSourceField();
			case SearchResultPackage.LIKE_THIS_OBJECT__MAX_RESULTS:
				return getMaxResults();
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
			case SearchResultPackage.LIKE_THIS_OBJECT__LIKE_THIS_FIELDS:
				getLikeThisFields().clear();
				getLikeThisFields().addAll((Collection<? extends String>)newValue);
				return;
			case SearchResultPackage.LIKE_THIS_OBJECT__FILTER_FIELDS:
				getFilterFields().clear();
				getFilterFields().addAll((Collection<? extends FilterField>)newValue);
				return;
			case SearchResultPackage.LIKE_THIS_OBJECT__SORT_FIELDS:
				getSortFields().clear();
				getSortFields().addAll((Collection<? extends SortField>)newValue);
				return;
			case SearchResultPackage.LIKE_THIS_OBJECT__FILTER_SOURCE_OBJECT:
				setFilterSourceObject((Boolean)newValue);
				return;
			case SearchResultPackage.LIKE_THIS_OBJECT__FILTER_SOURCE_FIELD:
				setFilterSourceField((String)newValue);
				return;
			case SearchResultPackage.LIKE_THIS_OBJECT__MAX_RESULTS:
				setMaxResults((Integer)newValue);
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
			case SearchResultPackage.LIKE_THIS_OBJECT__LIKE_THIS_FIELDS:
				getLikeThisFields().clear();
				return;
			case SearchResultPackage.LIKE_THIS_OBJECT__FILTER_FIELDS:
				getFilterFields().clear();
				return;
			case SearchResultPackage.LIKE_THIS_OBJECT__SORT_FIELDS:
				getSortFields().clear();
				return;
			case SearchResultPackage.LIKE_THIS_OBJECT__FILTER_SOURCE_OBJECT:
				setFilterSourceObject(FILTER_SOURCE_OBJECT_EDEFAULT);
				return;
			case SearchResultPackage.LIKE_THIS_OBJECT__FILTER_SOURCE_FIELD:
				setFilterSourceField(FILTER_SOURCE_FIELD_EDEFAULT);
				return;
			case SearchResultPackage.LIKE_THIS_OBJECT__MAX_RESULTS:
				setMaxResults(MAX_RESULTS_EDEFAULT);
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
			case SearchResultPackage.LIKE_THIS_OBJECT__LIKE_THIS_FIELDS:
				return likeThisFields != null && !likeThisFields.isEmpty();
			case SearchResultPackage.LIKE_THIS_OBJECT__FILTER_FIELDS:
				return filterFields != null && !filterFields.isEmpty();
			case SearchResultPackage.LIKE_THIS_OBJECT__SORT_FIELDS:
				return sortFields != null && !sortFields.isEmpty();
			case SearchResultPackage.LIKE_THIS_OBJECT__FILTER_SOURCE_OBJECT:
				return filterSourceObject != FILTER_SOURCE_OBJECT_EDEFAULT;
			case SearchResultPackage.LIKE_THIS_OBJECT__FILTER_SOURCE_FIELD:
				return FILTER_SOURCE_FIELD_EDEFAULT == null ? filterSourceField != null : !FILTER_SOURCE_FIELD_EDEFAULT.equals(filterSourceField);
			case SearchResultPackage.LIKE_THIS_OBJECT__MAX_RESULTS:
				return maxResults != MAX_RESULTS_EDEFAULT;
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
		result.append(" (likeThisFields: ");
		result.append(likeThisFields);
		result.append(", filterSourceObject: ");
		result.append(filterSourceObject);
		result.append(", filterSourceField: ");
		result.append(filterSourceField);
		result.append(", maxResults: ");
		result.append(maxResults);
		result.append(')');
		return result.toString();
	}

} //LikeThisObjectImpl
