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

import org.gecko.searchresult.JoinQuery;
import org.gecko.searchresult.JoinScoreMode;
import org.gecko.searchresult.Occur;
import org.gecko.searchresult.SearchResultPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Join Query</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchresult.impl.JoinQueryImpl#getIndexPath <em>Index Path</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.JoinQueryImpl#getFromField <em>From Field</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.JoinQueryImpl#getToField <em>To Field</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.JoinQueryImpl#getScoreMode <em>Score Mode</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.JoinQueryImpl#getQueryObject <em>Query Object</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.JoinQueryImpl#getJoinAftermathCollectors <em>Join Aftermath Collectors</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.JoinQueryImpl#getOccur <em>Occur</em>}</li>
 * </ul>
 *
 * @generated
 */
public class JoinQueryImpl extends MinimalEObjectImpl.Container implements JoinQuery {
	/**
	 * The default value of the '{@link #getIndexPath() <em>Index Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexPath()
	 * @generated
	 * @ordered
	 */
	protected static final String INDEX_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIndexPath() <em>Index Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexPath()
	 * @generated
	 * @ordered
	 */
	protected String indexPath = INDEX_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getFromField() <em>From Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromField()
	 * @generated
	 * @ordered
	 */
	protected static final String FROM_FIELD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFromField() <em>From Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromField()
	 * @generated
	 * @ordered
	 */
	protected String fromField = FROM_FIELD_EDEFAULT;

	/**
	 * The default value of the '{@link #getToField() <em>To Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToField()
	 * @generated
	 * @ordered
	 */
	protected static final String TO_FIELD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getToField() <em>To Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToField()
	 * @generated
	 * @ordered
	 */
	protected String toField = TO_FIELD_EDEFAULT;

	/**
	 * The default value of the '{@link #getScoreMode() <em>Score Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScoreMode()
	 * @generated
	 * @ordered
	 */
	protected static final JoinScoreMode SCORE_MODE_EDEFAULT = JoinScoreMode.NONE;

	/**
	 * The cached value of the '{@link #getScoreMode() <em>Score Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScoreMode()
	 * @generated
	 * @ordered
	 */
	protected JoinScoreMode scoreMode = SCORE_MODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getQueryObject() <em>Query Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueryObject()
	 * @generated
	 * @ordered
	 */
	protected static final Object QUERY_OBJECT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQueryObject() <em>Query Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueryObject()
	 * @generated
	 * @ordered
	 */
	protected Object queryObject = QUERY_OBJECT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getJoinAftermathCollectors() <em>Join Aftermath Collectors</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJoinAftermathCollectors()
	 * @generated
	 * @ordered
	 */
	protected EList<Object> joinAftermathCollectors;

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
	protected JoinQueryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SearchResultPackage.Literals.JOIN_QUERY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIndexPath() {
		return indexPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndexPath(String newIndexPath) {
		String oldIndexPath = indexPath;
		indexPath = newIndexPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.JOIN_QUERY__INDEX_PATH, oldIndexPath, indexPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFromField() {
		return fromField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFromField(String newFromField) {
		String oldFromField = fromField;
		fromField = newFromField;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.JOIN_QUERY__FROM_FIELD, oldFromField, fromField));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getToField() {
		return toField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToField(String newToField) {
		String oldToField = toField;
		toField = newToField;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.JOIN_QUERY__TO_FIELD, oldToField, toField));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JoinScoreMode getScoreMode() {
		return scoreMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScoreMode(JoinScoreMode newScoreMode) {
		JoinScoreMode oldScoreMode = scoreMode;
		scoreMode = newScoreMode == null ? SCORE_MODE_EDEFAULT : newScoreMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.JOIN_QUERY__SCORE_MODE, oldScoreMode, scoreMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getQueryObject() {
		return queryObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQueryObject(Object newQueryObject) {
		Object oldQueryObject = queryObject;
		queryObject = newQueryObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.JOIN_QUERY__QUERY_OBJECT, oldQueryObject, queryObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Object> getJoinAftermathCollectors() {
		if (joinAftermathCollectors == null) {
			joinAftermathCollectors = new EDataTypeUniqueEList<Object>(Object.class, this, SearchResultPackage.JOIN_QUERY__JOIN_AFTERMATH_COLLECTORS);
		}
		return joinAftermathCollectors;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.JOIN_QUERY__OCCUR, oldOccur, occur));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SearchResultPackage.JOIN_QUERY__INDEX_PATH:
				return getIndexPath();
			case SearchResultPackage.JOIN_QUERY__FROM_FIELD:
				return getFromField();
			case SearchResultPackage.JOIN_QUERY__TO_FIELD:
				return getToField();
			case SearchResultPackage.JOIN_QUERY__SCORE_MODE:
				return getScoreMode();
			case SearchResultPackage.JOIN_QUERY__QUERY_OBJECT:
				return getQueryObject();
			case SearchResultPackage.JOIN_QUERY__JOIN_AFTERMATH_COLLECTORS:
				return getJoinAftermathCollectors();
			case SearchResultPackage.JOIN_QUERY__OCCUR:
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
			case SearchResultPackage.JOIN_QUERY__INDEX_PATH:
				setIndexPath((String)newValue);
				return;
			case SearchResultPackage.JOIN_QUERY__FROM_FIELD:
				setFromField((String)newValue);
				return;
			case SearchResultPackage.JOIN_QUERY__TO_FIELD:
				setToField((String)newValue);
				return;
			case SearchResultPackage.JOIN_QUERY__SCORE_MODE:
				setScoreMode((JoinScoreMode)newValue);
				return;
			case SearchResultPackage.JOIN_QUERY__QUERY_OBJECT:
				setQueryObject(newValue);
				return;
			case SearchResultPackage.JOIN_QUERY__JOIN_AFTERMATH_COLLECTORS:
				getJoinAftermathCollectors().clear();
				getJoinAftermathCollectors().addAll((Collection<? extends Object>)newValue);
				return;
			case SearchResultPackage.JOIN_QUERY__OCCUR:
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
			case SearchResultPackage.JOIN_QUERY__INDEX_PATH:
				setIndexPath(INDEX_PATH_EDEFAULT);
				return;
			case SearchResultPackage.JOIN_QUERY__FROM_FIELD:
				setFromField(FROM_FIELD_EDEFAULT);
				return;
			case SearchResultPackage.JOIN_QUERY__TO_FIELD:
				setToField(TO_FIELD_EDEFAULT);
				return;
			case SearchResultPackage.JOIN_QUERY__SCORE_MODE:
				setScoreMode(SCORE_MODE_EDEFAULT);
				return;
			case SearchResultPackage.JOIN_QUERY__QUERY_OBJECT:
				setQueryObject(QUERY_OBJECT_EDEFAULT);
				return;
			case SearchResultPackage.JOIN_QUERY__JOIN_AFTERMATH_COLLECTORS:
				getJoinAftermathCollectors().clear();
				return;
			case SearchResultPackage.JOIN_QUERY__OCCUR:
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
			case SearchResultPackage.JOIN_QUERY__INDEX_PATH:
				return INDEX_PATH_EDEFAULT == null ? indexPath != null : !INDEX_PATH_EDEFAULT.equals(indexPath);
			case SearchResultPackage.JOIN_QUERY__FROM_FIELD:
				return FROM_FIELD_EDEFAULT == null ? fromField != null : !FROM_FIELD_EDEFAULT.equals(fromField);
			case SearchResultPackage.JOIN_QUERY__TO_FIELD:
				return TO_FIELD_EDEFAULT == null ? toField != null : !TO_FIELD_EDEFAULT.equals(toField);
			case SearchResultPackage.JOIN_QUERY__SCORE_MODE:
				return scoreMode != SCORE_MODE_EDEFAULT;
			case SearchResultPackage.JOIN_QUERY__QUERY_OBJECT:
				return QUERY_OBJECT_EDEFAULT == null ? queryObject != null : !QUERY_OBJECT_EDEFAULT.equals(queryObject);
			case SearchResultPackage.JOIN_QUERY__JOIN_AFTERMATH_COLLECTORS:
				return joinAftermathCollectors != null && !joinAftermathCollectors.isEmpty();
			case SearchResultPackage.JOIN_QUERY__OCCUR:
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
		result.append(" (indexPath: ");
		result.append(indexPath);
		result.append(", fromField: ");
		result.append(fromField);
		result.append(", toField: ");
		result.append(toField);
		result.append(", scoreMode: ");
		result.append(scoreMode);
		result.append(", queryObject: ");
		result.append(queryObject);
		result.append(", joinAftermathCollectors: ");
		result.append(joinAftermathCollectors);
		result.append(", occur: ");
		result.append(occur);
		result.append(')');
		return result.toString();
	}

} //JoinQueryImpl
