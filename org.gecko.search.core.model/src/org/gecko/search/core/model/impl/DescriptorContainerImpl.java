/**
 * Copyright (c) 2014 Data In Motion and others.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Data In Motion - initial API and implementation
 */
package org.gecko.search.core.model.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.gecko.search.core.model.Descriptor;
import org.gecko.search.core.model.DescriptorContainer;
import org.gecko.search.core.model.SearchPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Descriptor Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.search.core.model.impl.DescriptorContainerImpl#getDescriptors <em>Descriptors</em>}</li>
 *   <li>{@link org.gecko.search.core.model.impl.DescriptorContainerImpl#getQueryDescriptors <em>Query Descriptors</em>}</li>
 *   <li>{@link org.gecko.search.core.model.impl.DescriptorContainerImpl#getIndexDescriptors <em>Index Descriptors</em>}</li>
 *   <li>{@link org.gecko.search.core.model.impl.DescriptorContainerImpl#getResultDescriptors <em>Result Descriptors</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DescriptorContainerImpl extends MinimalEObjectImpl.Container implements DescriptorContainer {
	/**
   * The cached value of the '{@link #getDescriptors() <em>Descriptors</em>}' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getDescriptors()
   * @generated
   * @ordered
   */
	protected FeatureMap descriptors;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected DescriptorContainerImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return SearchPackage.Literals.DESCRIPTOR_CONTAINER;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public FeatureMap getDescriptors() {
    if (descriptors == null) {
      descriptors = new BasicFeatureMap(this, SearchPackage.DESCRIPTOR_CONTAINER__DESCRIPTORS);
    }
    return descriptors;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<Descriptor> getQueryDescriptors() {
    return getDescriptors().list(SearchPackage.Literals.DESCRIPTOR_CONTAINER__QUERY_DESCRIPTORS);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<Descriptor> getIndexDescriptors() {
    return getDescriptors().list(SearchPackage.Literals.DESCRIPTOR_CONTAINER__INDEX_DESCRIPTORS);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<Descriptor> getResultDescriptors() {
    return getDescriptors().list(SearchPackage.Literals.DESCRIPTOR_CONTAINER__RESULT_DESCRIPTORS);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case SearchPackage.DESCRIPTOR_CONTAINER__DESCRIPTORS:
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
      case SearchPackage.DESCRIPTOR_CONTAINER__DESCRIPTORS:
        if (coreType) return getDescriptors();
        return ((FeatureMap.Internal)getDescriptors()).getWrapper();
      case SearchPackage.DESCRIPTOR_CONTAINER__QUERY_DESCRIPTORS:
        return getQueryDescriptors();
      case SearchPackage.DESCRIPTOR_CONTAINER__INDEX_DESCRIPTORS:
        return getIndexDescriptors();
      case SearchPackage.DESCRIPTOR_CONTAINER__RESULT_DESCRIPTORS:
        return getResultDescriptors();
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
      case SearchPackage.DESCRIPTOR_CONTAINER__DESCRIPTORS:
        ((FeatureMap.Internal)getDescriptors()).set(newValue);
        return;
      case SearchPackage.DESCRIPTOR_CONTAINER__QUERY_DESCRIPTORS:
        getQueryDescriptors().clear();
        getQueryDescriptors().addAll((Collection<? extends Descriptor>)newValue);
        return;
      case SearchPackage.DESCRIPTOR_CONTAINER__INDEX_DESCRIPTORS:
        getIndexDescriptors().clear();
        getIndexDescriptors().addAll((Collection<? extends Descriptor>)newValue);
        return;
      case SearchPackage.DESCRIPTOR_CONTAINER__RESULT_DESCRIPTORS:
        getResultDescriptors().clear();
        getResultDescriptors().addAll((Collection<? extends Descriptor>)newValue);
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
      case SearchPackage.DESCRIPTOR_CONTAINER__DESCRIPTORS:
        getDescriptors().clear();
        return;
      case SearchPackage.DESCRIPTOR_CONTAINER__QUERY_DESCRIPTORS:
        getQueryDescriptors().clear();
        return;
      case SearchPackage.DESCRIPTOR_CONTAINER__INDEX_DESCRIPTORS:
        getIndexDescriptors().clear();
        return;
      case SearchPackage.DESCRIPTOR_CONTAINER__RESULT_DESCRIPTORS:
        getResultDescriptors().clear();
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
      case SearchPackage.DESCRIPTOR_CONTAINER__DESCRIPTORS:
        return descriptors != null && !descriptors.isEmpty();
      case SearchPackage.DESCRIPTOR_CONTAINER__QUERY_DESCRIPTORS:
        return !getQueryDescriptors().isEmpty();
      case SearchPackage.DESCRIPTOR_CONTAINER__INDEX_DESCRIPTORS:
        return !getIndexDescriptors().isEmpty();
      case SearchPackage.DESCRIPTOR_CONTAINER__RESULT_DESCRIPTORS:
        return !getResultDescriptors().isEmpty();
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
    result.append(" (descriptors: ");
    result.append(descriptors);
    result.append(')');
    return result.toString();
  }

} //DescriptorContainerImpl
