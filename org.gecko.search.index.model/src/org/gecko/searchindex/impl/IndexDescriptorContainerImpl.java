/**
 */
package org.gecko.searchindex.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.gecko.searchindex.IndexDescriptor;
import org.gecko.searchindex.IndexDescriptorContainer;
import org.gecko.searchindex.SearchIndexPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Index Descriptor Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchindex.impl.IndexDescriptorContainerImpl#getDescriptors <em>Descriptors</em>}</li>
 *   <li>{@link org.gecko.searchindex.impl.IndexDescriptorContainerImpl#getActiveDescriptors <em>Active Descriptors</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IndexDescriptorContainerImpl extends MinimalEObjectImpl.Container implements IndexDescriptorContainer {
	/**
	 * The cached value of the '{@link #getDescriptors() <em>Descriptors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptors()
	 * @generated
	 * @ordered
	 */
	protected EList<IndexDescriptor> descriptors;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IndexDescriptorContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SearchIndexPackage.Literals.INDEX_DESCRIPTOR_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IndexDescriptor> getDescriptors() {
		if (descriptors == null) {
			descriptors = new EObjectContainmentEList<IndexDescriptor>(IndexDescriptor.class, this, SearchIndexPackage.INDEX_DESCRIPTOR_CONTAINER__DESCRIPTORS);
		}
		return descriptors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IndexDescriptor> getActiveDescriptors() {
		// TODO: implement this method to return the 'Active Descriptors' reference list
		// Ensure that you remove @generated or mark it @generated NOT
		// The list is expected to implement org.eclipse.emf.ecore.util.InternalEList and org.eclipse.emf.ecore.EStructuralFeature.Setting
		// so it's likely that an appropriate subclass of org.eclipse.emf.ecore.util.EcoreEList should be used.
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
			case SearchIndexPackage.INDEX_DESCRIPTOR_CONTAINER__DESCRIPTORS:
				return ((InternalEList<?>)getDescriptors()).basicRemove(otherEnd, msgs);
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
			case SearchIndexPackage.INDEX_DESCRIPTOR_CONTAINER__DESCRIPTORS:
				return getDescriptors();
			case SearchIndexPackage.INDEX_DESCRIPTOR_CONTAINER__ACTIVE_DESCRIPTORS:
				return getActiveDescriptors();
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
			case SearchIndexPackage.INDEX_DESCRIPTOR_CONTAINER__DESCRIPTORS:
				getDescriptors().clear();
				getDescriptors().addAll((Collection<? extends IndexDescriptor>)newValue);
				return;
			case SearchIndexPackage.INDEX_DESCRIPTOR_CONTAINER__ACTIVE_DESCRIPTORS:
				getActiveDescriptors().clear();
				getActiveDescriptors().addAll((Collection<? extends IndexDescriptor>)newValue);
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
			case SearchIndexPackage.INDEX_DESCRIPTOR_CONTAINER__DESCRIPTORS:
				getDescriptors().clear();
				return;
			case SearchIndexPackage.INDEX_DESCRIPTOR_CONTAINER__ACTIVE_DESCRIPTORS:
				getActiveDescriptors().clear();
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
			case SearchIndexPackage.INDEX_DESCRIPTOR_CONTAINER__DESCRIPTORS:
				return descriptors != null && !descriptors.isEmpty();
			case SearchIndexPackage.INDEX_DESCRIPTOR_CONTAINER__ACTIVE_DESCRIPTORS:
				return !getActiveDescriptors().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //IndexDescriptorContainerImpl
