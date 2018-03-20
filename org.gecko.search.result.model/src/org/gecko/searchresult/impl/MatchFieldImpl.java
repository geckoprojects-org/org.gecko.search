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

import org.gecko.emf.utilities.Converter;
import org.gecko.emf.utilities.FeaturePath;

import org.gecko.searchresult.MatchField;
import org.gecko.searchresult.MatchHighlight;
import org.gecko.searchresult.SearchResultPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Match Field</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchresult.impl.MatchFieldImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.MatchFieldImpl#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.MatchFieldImpl#getConverter <em>Converter</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.MatchFieldImpl#isMultiValue <em>Multi Value</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.MatchFieldImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.MatchFieldImpl#getHighlighting <em>Highlighting</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MatchFieldImpl extends MinimalEObjectImpl.Container implements MatchField {
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
	 * The cached value of the '{@link #getFeature() <em>Feature</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeature()
	 * @generated
	 * @ordered
	 */
	protected FeaturePath feature;

	/**
	 * The cached value of the '{@link #getConverter() <em>Converter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConverter()
	 * @generated
	 * @ordered
	 */
	protected Converter converter;

	/**
	 * The default value of the '{@link #isMultiValue() <em>Multi Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMultiValue()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MULTI_VALUE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMultiValue() <em>Multi Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMultiValue()
	 * @generated
	 * @ordered
	 */
	protected boolean multiValue = MULTI_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final Object VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected Object value = VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getHighlighting() <em>Highlighting</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHighlighting()
	 * @generated
	 * @ordered
	 */
	protected EList<MatchHighlight> highlighting;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MatchFieldImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SearchResultPackage.Literals.MATCH_FIELD;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.MATCH_FIELD__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeaturePath getFeature() {
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFeature(FeaturePath newFeature, NotificationChain msgs) {
		FeaturePath oldFeature = feature;
		feature = newFeature;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SearchResultPackage.MATCH_FIELD__FEATURE, oldFeature, newFeature);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeature(FeaturePath newFeature) {
		if (newFeature != feature) {
			NotificationChain msgs = null;
			if (feature != null)
				msgs = ((InternalEObject)feature).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SearchResultPackage.MATCH_FIELD__FEATURE, null, msgs);
			if (newFeature != null)
				msgs = ((InternalEObject)newFeature).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SearchResultPackage.MATCH_FIELD__FEATURE, null, msgs);
			msgs = basicSetFeature(newFeature, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.MATCH_FIELD__FEATURE, newFeature, newFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Converter getConverter() {
		return converter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConverter(Converter newConverter, NotificationChain msgs) {
		Converter oldConverter = converter;
		converter = newConverter;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SearchResultPackage.MATCH_FIELD__CONVERTER, oldConverter, newConverter);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConverter(Converter newConverter) {
		if (newConverter != converter) {
			NotificationChain msgs = null;
			if (converter != null)
				msgs = ((InternalEObject)converter).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SearchResultPackage.MATCH_FIELD__CONVERTER, null, msgs);
			if (newConverter != null)
				msgs = ((InternalEObject)newConverter).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SearchResultPackage.MATCH_FIELD__CONVERTER, null, msgs);
			msgs = basicSetConverter(newConverter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.MATCH_FIELD__CONVERTER, newConverter, newConverter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMultiValue() {
		return multiValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMultiValue(boolean newMultiValue) {
		boolean oldMultiValue = multiValue;
		multiValue = newMultiValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.MATCH_FIELD__MULTI_VALUE, oldMultiValue, multiValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(Object newValue) {
		Object oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.MATCH_FIELD__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MatchHighlight> getHighlighting() {
		if (highlighting == null) {
			highlighting = new EObjectContainmentEList<MatchHighlight>(MatchHighlight.class, this, SearchResultPackage.MATCH_FIELD__HIGHLIGHTING);
		}
		return highlighting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SearchResultPackage.MATCH_FIELD__FEATURE:
				return basicSetFeature(null, msgs);
			case SearchResultPackage.MATCH_FIELD__CONVERTER:
				return basicSetConverter(null, msgs);
			case SearchResultPackage.MATCH_FIELD__HIGHLIGHTING:
				return ((InternalEList<?>)getHighlighting()).basicRemove(otherEnd, msgs);
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
			case SearchResultPackage.MATCH_FIELD__ID:
				return getId();
			case SearchResultPackage.MATCH_FIELD__FEATURE:
				return getFeature();
			case SearchResultPackage.MATCH_FIELD__CONVERTER:
				return getConverter();
			case SearchResultPackage.MATCH_FIELD__MULTI_VALUE:
				return isMultiValue();
			case SearchResultPackage.MATCH_FIELD__VALUE:
				return getValue();
			case SearchResultPackage.MATCH_FIELD__HIGHLIGHTING:
				return getHighlighting();
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
			case SearchResultPackage.MATCH_FIELD__ID:
				setId((String)newValue);
				return;
			case SearchResultPackage.MATCH_FIELD__FEATURE:
				setFeature((FeaturePath)newValue);
				return;
			case SearchResultPackage.MATCH_FIELD__CONVERTER:
				setConverter((Converter)newValue);
				return;
			case SearchResultPackage.MATCH_FIELD__MULTI_VALUE:
				setMultiValue((Boolean)newValue);
				return;
			case SearchResultPackage.MATCH_FIELD__VALUE:
				setValue(newValue);
				return;
			case SearchResultPackage.MATCH_FIELD__HIGHLIGHTING:
				getHighlighting().clear();
				getHighlighting().addAll((Collection<? extends MatchHighlight>)newValue);
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
			case SearchResultPackage.MATCH_FIELD__ID:
				setId(ID_EDEFAULT);
				return;
			case SearchResultPackage.MATCH_FIELD__FEATURE:
				setFeature((FeaturePath)null);
				return;
			case SearchResultPackage.MATCH_FIELD__CONVERTER:
				setConverter((Converter)null);
				return;
			case SearchResultPackage.MATCH_FIELD__MULTI_VALUE:
				setMultiValue(MULTI_VALUE_EDEFAULT);
				return;
			case SearchResultPackage.MATCH_FIELD__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case SearchResultPackage.MATCH_FIELD__HIGHLIGHTING:
				getHighlighting().clear();
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
			case SearchResultPackage.MATCH_FIELD__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case SearchResultPackage.MATCH_FIELD__FEATURE:
				return feature != null;
			case SearchResultPackage.MATCH_FIELD__CONVERTER:
				return converter != null;
			case SearchResultPackage.MATCH_FIELD__MULTI_VALUE:
				return multiValue != MULTI_VALUE_EDEFAULT;
			case SearchResultPackage.MATCH_FIELD__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case SearchResultPackage.MATCH_FIELD__HIGHLIGHTING:
				return highlighting != null && !highlighting.isEmpty();
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
		result.append(", multiValue: ");
		result.append(multiValue);
		result.append(", value: ");
		result.append(value);
		result.append(')');
		return result.toString();
	}

} //MatchFieldImpl
