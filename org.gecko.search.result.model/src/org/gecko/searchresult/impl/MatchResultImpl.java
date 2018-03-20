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

import java.lang.reflect.InvocationTargetException;

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

import org.gecko.searchresult.MatchField;
import org.gecko.searchresult.MatchHighlight;
import org.gecko.searchresult.MatchResult;
import org.gecko.searchresult.SearchResultPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Match Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchresult.impl.MatchResultImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.MatchResultImpl#getHighlights <em>Highlights</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.MatchResultImpl#getFields <em>Fields</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.MatchResultImpl#getScore <em>Score</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.MatchResultImpl#getExplanation <em>Explanation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MatchResultImpl extends MinimalEObjectImpl.Container implements MatchResult {
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
	 * The cached value of the '{@link #getHighlights() <em>Highlights</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHighlights()
	 * @generated
	 * @ordered
	 */
	protected EList<MatchHighlight> highlights;

	/**
	 * The cached value of the '{@link #getFields() <em>Fields</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFields()
	 * @generated
	 * @ordered
	 */
	protected EList<MatchField> fields;

	/**
	 * The default value of the '{@link #getScore() <em>Score</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScore()
	 * @generated
	 * @ordered
	 */
	protected static final float SCORE_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getScore() <em>Score</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScore()
	 * @generated
	 * @ordered
	 */
	protected float score = SCORE_EDEFAULT;

	/**
	 * The default value of the '{@link #getExplanation() <em>Explanation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExplanation()
	 * @generated
	 * @ordered
	 */
	protected static final Object EXPLANATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExplanation() <em>Explanation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExplanation()
	 * @generated
	 * @ordered
	 */
	protected Object explanation = EXPLANATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MatchResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SearchResultPackage.Literals.MATCH_RESULT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.MATCH_RESULT__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MatchHighlight> getHighlights() {
		if (highlights == null) {
			highlights = new EObjectContainmentEList<MatchHighlight>(MatchHighlight.class, this, SearchResultPackage.MATCH_RESULT__HIGHLIGHTS);
		}
		return highlights;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MatchField> getFields() {
		if (fields == null) {
			fields = new EObjectContainmentEList<MatchField>(MatchField.class, this, SearchResultPackage.MATCH_RESULT__FIELDS);
		}
		return fields;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getScore() {
		return score;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScore(float newScore) {
		float oldScore = score;
		score = newScore;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.MATCH_RESULT__SCORE, oldScore, score));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getExplanation() {
		return explanation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExplanation(Object newExplanation) {
		Object oldExplanation = explanation;
		explanation = newExplanation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.MATCH_RESULT__EXPLANATION, oldExplanation, explanation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatchField getMatchFieldById(String key) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SearchResultPackage.MATCH_RESULT__HIGHLIGHTS:
				return ((InternalEList<?>)getHighlights()).basicRemove(otherEnd, msgs);
			case SearchResultPackage.MATCH_RESULT__FIELDS:
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
			case SearchResultPackage.MATCH_RESULT__ID:
				return getId();
			case SearchResultPackage.MATCH_RESULT__HIGHLIGHTS:
				return getHighlights();
			case SearchResultPackage.MATCH_RESULT__FIELDS:
				return getFields();
			case SearchResultPackage.MATCH_RESULT__SCORE:
				return getScore();
			case SearchResultPackage.MATCH_RESULT__EXPLANATION:
				return getExplanation();
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
			case SearchResultPackage.MATCH_RESULT__ID:
				setId((String)newValue);
				return;
			case SearchResultPackage.MATCH_RESULT__HIGHLIGHTS:
				getHighlights().clear();
				getHighlights().addAll((Collection<? extends MatchHighlight>)newValue);
				return;
			case SearchResultPackage.MATCH_RESULT__FIELDS:
				getFields().clear();
				getFields().addAll((Collection<? extends MatchField>)newValue);
				return;
			case SearchResultPackage.MATCH_RESULT__SCORE:
				setScore((Float)newValue);
				return;
			case SearchResultPackage.MATCH_RESULT__EXPLANATION:
				setExplanation(newValue);
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
			case SearchResultPackage.MATCH_RESULT__ID:
				setId(ID_EDEFAULT);
				return;
			case SearchResultPackage.MATCH_RESULT__HIGHLIGHTS:
				getHighlights().clear();
				return;
			case SearchResultPackage.MATCH_RESULT__FIELDS:
				getFields().clear();
				return;
			case SearchResultPackage.MATCH_RESULT__SCORE:
				setScore(SCORE_EDEFAULT);
				return;
			case SearchResultPackage.MATCH_RESULT__EXPLANATION:
				setExplanation(EXPLANATION_EDEFAULT);
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
			case SearchResultPackage.MATCH_RESULT__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case SearchResultPackage.MATCH_RESULT__HIGHLIGHTS:
				return highlights != null && !highlights.isEmpty();
			case SearchResultPackage.MATCH_RESULT__FIELDS:
				return fields != null && !fields.isEmpty();
			case SearchResultPackage.MATCH_RESULT__SCORE:
				return score != SCORE_EDEFAULT;
			case SearchResultPackage.MATCH_RESULT__EXPLANATION:
				return EXPLANATION_EDEFAULT == null ? explanation != null : !EXPLANATION_EDEFAULT.equals(explanation);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case SearchResultPackage.MATCH_RESULT___GET_MATCH_FIELD_BY_ID__STRING:
				return getMatchFieldById((String)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(", score: ");
		result.append(score);
		result.append(", explanation: ");
		result.append(explanation);
		result.append(')');
		return result.toString();
	}

} //MatchResultImpl
