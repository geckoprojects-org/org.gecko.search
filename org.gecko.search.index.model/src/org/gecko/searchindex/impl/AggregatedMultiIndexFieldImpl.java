/**
 */
package org.gecko.searchindex.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.gecko.emf.utilities.FeaturePath;

import org.gecko.searchindex.AggregatedMultiIndexField;
import org.gecko.searchindex.IndexField;
import org.gecko.searchindex.SearchIndexPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Aggregated Multi Index Field</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchindex.impl.AggregatedMultiIndexFieldImpl#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.gecko.searchindex.impl.AggregatedMultiIndexFieldImpl#getIndexFields <em>Index Fields</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AggregatedMultiIndexFieldImpl extends IndexFieldImpl implements AggregatedMultiIndexField {
	/**
	 * The cached value of the '{@link #getFeatures() <em>Features</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<FeaturePath> features;

	/**
	 * The cached value of the '{@link #getIndexFields() <em>Index Fields</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexFields()
	 * @generated
	 * @ordered
	 */
	protected EList<IndexField> indexFields;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AggregatedMultiIndexFieldImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SearchIndexPackage.Literals.AGGREGATED_MULTI_INDEX_FIELD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FeaturePath> getFeatures() {
		if (features == null) {
			features = new EObjectContainmentEList<FeaturePath>(FeaturePath.class, this, SearchIndexPackage.AGGREGATED_MULTI_INDEX_FIELD__FEATURES);
		}
		return features;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IndexField> getIndexFields() {
		if (indexFields == null) {
			indexFields = new EObjectResolvingEList<IndexField>(IndexField.class, this, SearchIndexPackage.AGGREGATED_MULTI_INDEX_FIELD__INDEX_FIELDS);
		}
		return indexFields;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SearchIndexPackage.AGGREGATED_MULTI_INDEX_FIELD__FEATURES:
				return ((InternalEList<?>)getFeatures()).basicRemove(otherEnd, msgs);
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
			case SearchIndexPackage.AGGREGATED_MULTI_INDEX_FIELD__FEATURES:
				return getFeatures();
			case SearchIndexPackage.AGGREGATED_MULTI_INDEX_FIELD__INDEX_FIELDS:
				return getIndexFields();
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
			case SearchIndexPackage.AGGREGATED_MULTI_INDEX_FIELD__FEATURES:
				getFeatures().clear();
				getFeatures().addAll((Collection<? extends FeaturePath>)newValue);
				return;
			case SearchIndexPackage.AGGREGATED_MULTI_INDEX_FIELD__INDEX_FIELDS:
				getIndexFields().clear();
				getIndexFields().addAll((Collection<? extends IndexField>)newValue);
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
			case SearchIndexPackage.AGGREGATED_MULTI_INDEX_FIELD__FEATURES:
				getFeatures().clear();
				return;
			case SearchIndexPackage.AGGREGATED_MULTI_INDEX_FIELD__INDEX_FIELDS:
				getIndexFields().clear();
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
			case SearchIndexPackage.AGGREGATED_MULTI_INDEX_FIELD__FEATURES:
				return features != null && !features.isEmpty();
			case SearchIndexPackage.AGGREGATED_MULTI_INDEX_FIELD__INDEX_FIELDS:
				return indexFields != null && !indexFields.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AggregatedMultiIndexFieldImpl
