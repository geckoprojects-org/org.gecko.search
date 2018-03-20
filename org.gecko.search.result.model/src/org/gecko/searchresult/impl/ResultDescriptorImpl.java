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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.gecko.searchresult.ResultDescriptor;
import org.gecko.searchresult.ResultField;
import org.gecko.searchresult.SearchResultPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Result Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchresult.impl.ResultDescriptorImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.ResultDescriptorImpl#isActive <em>Active</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.ResultDescriptorImpl#getIndexId <em>Index Id</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.ResultDescriptorImpl#getFields <em>Fields</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResultDescriptorImpl extends MinimalEObjectImpl.Container implements ResultDescriptor {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #isActive() <em>Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isActive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ACTIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isActive() <em>Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isActive()
	 * @generated
	 * @ordered
	 */
	protected boolean active = ACTIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #getIndexId() <em>Index Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexId()
	 * @generated
	 * @ordered
	 */
	protected static final String INDEX_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIndexId() <em>Index Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexId()
	 * @generated
	 * @ordered
	 */
	protected String indexId = INDEX_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFields() <em>Fields</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFields()
	 * @generated
	 * @ordered
	 */
	protected EList<ResultField> fields;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResultDescriptorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SearchResultPackage.Literals.RESULT_DESCRIPTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.RESULT_DESCRIPTOR__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActive(boolean newActive) {
		boolean oldActive = active;
		active = newActive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.RESULT_DESCRIPTOR__ACTIVE, oldActive, active));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIndexId() {
		return indexId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndexId(String newIndexId) {
		String oldIndexId = indexId;
		indexId = newIndexId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.RESULT_DESCRIPTOR__INDEX_ID, oldIndexId, indexId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ResultField> getFields() {
		if (fields == null) {
			fields = new EObjectContainmentEList<ResultField>(ResultField.class, this, SearchResultPackage.RESULT_DESCRIPTOR__FIELDS);
		}
		return fields;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SearchResultPackage.RESULT_DESCRIPTOR__FIELDS:
				return ((InternalEList<?>)getFields()).basicRemove(otherEnd, msgs);
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
			case SearchResultPackage.RESULT_DESCRIPTOR__ID:
				return getId();
			case SearchResultPackage.RESULT_DESCRIPTOR__ACTIVE:
				return isActive();
			case SearchResultPackage.RESULT_DESCRIPTOR__INDEX_ID:
				return getIndexId();
			case SearchResultPackage.RESULT_DESCRIPTOR__FIELDS:
				return getFields();
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
			case SearchResultPackage.RESULT_DESCRIPTOR__ID:
				setId((String)newValue);
				return;
			case SearchResultPackage.RESULT_DESCRIPTOR__ACTIVE:
				setActive((Boolean)newValue);
				return;
			case SearchResultPackage.RESULT_DESCRIPTOR__INDEX_ID:
				setIndexId((String)newValue);
				return;
			case SearchResultPackage.RESULT_DESCRIPTOR__FIELDS:
				getFields().clear();
				getFields().addAll((Collection<? extends ResultField>)newValue);
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
			case SearchResultPackage.RESULT_DESCRIPTOR__ID:
				setId(ID_EDEFAULT);
				return;
			case SearchResultPackage.RESULT_DESCRIPTOR__ACTIVE:
				setActive(ACTIVE_EDEFAULT);
				return;
			case SearchResultPackage.RESULT_DESCRIPTOR__INDEX_ID:
				setIndexId(INDEX_ID_EDEFAULT);
				return;
			case SearchResultPackage.RESULT_DESCRIPTOR__FIELDS:
				getFields().clear();
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
			case SearchResultPackage.RESULT_DESCRIPTOR__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case SearchResultPackage.RESULT_DESCRIPTOR__ACTIVE:
				return active != ACTIVE_EDEFAULT;
			case SearchResultPackage.RESULT_DESCRIPTOR__INDEX_ID:
				return INDEX_ID_EDEFAULT == null ? indexId != null : !INDEX_ID_EDEFAULT.equals(indexId);
			case SearchResultPackage.RESULT_DESCRIPTOR__FIELDS:
				return fields != null && !fields.isEmpty();
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
		result.append(" (id: ");
		result.append(id);
		result.append(", active: ");
		result.append(active);
		result.append(", indexId: ");
		result.append(indexId);
		result.append(')');
		return result.toString();
	}

} //ResultDescriptorImpl
