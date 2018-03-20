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

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.gecko.searchresult.GroupingContext;
import org.gecko.searchresult.SearchResultPackage;
import org.gecko.searchresult.SortField;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Grouping Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchresult.impl.GroupingContextImpl#getMaxGroups <em>Max Groups</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.GroupingContextImpl#getOffSet <em>Off Set</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.GroupingContextImpl#getGroupFieldName <em>Group Field Name</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.GroupingContextImpl#getResultsPerGroup <em>Results Per Group</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.GroupingContextImpl#getCachSize <em>Cach Size</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.GroupingContextImpl#getGroupSort <em>Group Sort</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GroupingContextImpl extends MinimalEObjectImpl.Container implements GroupingContext {
	/**
	 * The default value of the '{@link #getMaxGroups() <em>Max Groups</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxGroups()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_GROUPS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxGroups() <em>Max Groups</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxGroups()
	 * @generated
	 * @ordered
	 */
	protected int maxGroups = MAX_GROUPS_EDEFAULT;

	/**
	 * The default value of the '{@link #getOffSet() <em>Off Set</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffSet()
	 * @generated
	 * @ordered
	 */
	protected static final int OFF_SET_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getOffSet() <em>Off Set</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffSet()
	 * @generated
	 * @ordered
	 */
	protected int offSet = OFF_SET_EDEFAULT;

	/**
	 * The default value of the '{@link #getGroupFieldName() <em>Group Field Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroupFieldName()
	 * @generated
	 * @ordered
	 */
	protected static final String GROUP_FIELD_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGroupFieldName() <em>Group Field Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroupFieldName()
	 * @generated
	 * @ordered
	 */
	protected String groupFieldName = GROUP_FIELD_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getResultsPerGroup() <em>Results Per Group</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultsPerGroup()
	 * @generated
	 * @ordered
	 */
	protected static final int RESULTS_PER_GROUP_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getResultsPerGroup() <em>Results Per Group</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultsPerGroup()
	 * @generated
	 * @ordered
	 */
	protected int resultsPerGroup = RESULTS_PER_GROUP_EDEFAULT;

	/**
	 * The default value of the '{@link #getCachSize() <em>Cach Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCachSize()
	 * @generated
	 * @ordered
	 */
	protected static final double CACH_SIZE_EDEFAULT = 4.0;

	/**
	 * The cached value of the '{@link #getCachSize() <em>Cach Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCachSize()
	 * @generated
	 * @ordered
	 */
	protected double cachSize = CACH_SIZE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getGroupSort() <em>Group Sort</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroupSort()
	 * @generated
	 * @ordered
	 */
	protected EList<SortField> groupSort;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GroupingContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SearchResultPackage.Literals.GROUPING_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxGroups() {
		return maxGroups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxGroups(int newMaxGroups) {
		int oldMaxGroups = maxGroups;
		maxGroups = newMaxGroups;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.GROUPING_CONTEXT__MAX_GROUPS, oldMaxGroups, maxGroups));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getOffSet() {
		return offSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOffSet(int newOffSet) {
		int oldOffSet = offSet;
		offSet = newOffSet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.GROUPING_CONTEXT__OFF_SET, oldOffSet, offSet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGroupFieldName() {
		return groupFieldName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGroupFieldName(String newGroupFieldName) {
		String oldGroupFieldName = groupFieldName;
		groupFieldName = newGroupFieldName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.GROUPING_CONTEXT__GROUP_FIELD_NAME, oldGroupFieldName, groupFieldName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getResultsPerGroup() {
		return resultsPerGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResultsPerGroup(int newResultsPerGroup) {
		int oldResultsPerGroup = resultsPerGroup;
		resultsPerGroup = newResultsPerGroup;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.GROUPING_CONTEXT__RESULTS_PER_GROUP, oldResultsPerGroup, resultsPerGroup));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getCachSize() {
		return cachSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCachSize(double newCachSize) {
		double oldCachSize = cachSize;
		cachSize = newCachSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.GROUPING_CONTEXT__CACH_SIZE, oldCachSize, cachSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SortField> getGroupSort() {
		if (groupSort == null) {
			groupSort = new EObjectResolvingEList<SortField>(SortField.class, this, SearchResultPackage.GROUPING_CONTEXT__GROUP_SORT);
		}
		return groupSort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SearchResultPackage.GROUPING_CONTEXT__MAX_GROUPS:
				return getMaxGroups();
			case SearchResultPackage.GROUPING_CONTEXT__OFF_SET:
				return getOffSet();
			case SearchResultPackage.GROUPING_CONTEXT__GROUP_FIELD_NAME:
				return getGroupFieldName();
			case SearchResultPackage.GROUPING_CONTEXT__RESULTS_PER_GROUP:
				return getResultsPerGroup();
			case SearchResultPackage.GROUPING_CONTEXT__CACH_SIZE:
				return getCachSize();
			case SearchResultPackage.GROUPING_CONTEXT__GROUP_SORT:
				return getGroupSort();
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
			case SearchResultPackage.GROUPING_CONTEXT__MAX_GROUPS:
				setMaxGroups((Integer)newValue);
				return;
			case SearchResultPackage.GROUPING_CONTEXT__OFF_SET:
				setOffSet((Integer)newValue);
				return;
			case SearchResultPackage.GROUPING_CONTEXT__GROUP_FIELD_NAME:
				setGroupFieldName((String)newValue);
				return;
			case SearchResultPackage.GROUPING_CONTEXT__RESULTS_PER_GROUP:
				setResultsPerGroup((Integer)newValue);
				return;
			case SearchResultPackage.GROUPING_CONTEXT__CACH_SIZE:
				setCachSize((Double)newValue);
				return;
			case SearchResultPackage.GROUPING_CONTEXT__GROUP_SORT:
				getGroupSort().clear();
				getGroupSort().addAll((Collection<? extends SortField>)newValue);
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
			case SearchResultPackage.GROUPING_CONTEXT__MAX_GROUPS:
				setMaxGroups(MAX_GROUPS_EDEFAULT);
				return;
			case SearchResultPackage.GROUPING_CONTEXT__OFF_SET:
				setOffSet(OFF_SET_EDEFAULT);
				return;
			case SearchResultPackage.GROUPING_CONTEXT__GROUP_FIELD_NAME:
				setGroupFieldName(GROUP_FIELD_NAME_EDEFAULT);
				return;
			case SearchResultPackage.GROUPING_CONTEXT__RESULTS_PER_GROUP:
				setResultsPerGroup(RESULTS_PER_GROUP_EDEFAULT);
				return;
			case SearchResultPackage.GROUPING_CONTEXT__CACH_SIZE:
				setCachSize(CACH_SIZE_EDEFAULT);
				return;
			case SearchResultPackage.GROUPING_CONTEXT__GROUP_SORT:
				getGroupSort().clear();
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
			case SearchResultPackage.GROUPING_CONTEXT__MAX_GROUPS:
				return maxGroups != MAX_GROUPS_EDEFAULT;
			case SearchResultPackage.GROUPING_CONTEXT__OFF_SET:
				return offSet != OFF_SET_EDEFAULT;
			case SearchResultPackage.GROUPING_CONTEXT__GROUP_FIELD_NAME:
				return GROUP_FIELD_NAME_EDEFAULT == null ? groupFieldName != null : !GROUP_FIELD_NAME_EDEFAULT.equals(groupFieldName);
			case SearchResultPackage.GROUPING_CONTEXT__RESULTS_PER_GROUP:
				return resultsPerGroup != RESULTS_PER_GROUP_EDEFAULT;
			case SearchResultPackage.GROUPING_CONTEXT__CACH_SIZE:
				return cachSize != CACH_SIZE_EDEFAULT;
			case SearchResultPackage.GROUPING_CONTEXT__GROUP_SORT:
				return groupSort != null && !groupSort.isEmpty();
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
		result.append(" (maxGroups: ");
		result.append(maxGroups);
		result.append(", offSet: ");
		result.append(offSet);
		result.append(", groupFieldName: ");
		result.append(groupFieldName);
		result.append(", resultsPerGroup: ");
		result.append(resultsPerGroup);
		result.append(", cachSize: ");
		result.append(cachSize);
		result.append(')');
		return result.toString();
	}

} //GroupingContextImpl
