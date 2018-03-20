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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.gecko.search.core.model.IndexData;
import org.gecko.search.core.model.IndexDataContainer;
import org.gecko.search.core.model.SearchPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Index Data Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.search.core.model.impl.IndexDataContainerImpl#getIndexData <em>Index Data</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IndexDataContainerImpl extends MinimalEObjectImpl.Container implements IndexDataContainer {
	/**
   * The cached value of the '{@link #getIndexData() <em>Index Data</em>}' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getIndexData()
   * @generated
   * @ordered
   */
	protected EList<IndexData> indexData;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected IndexDataContainerImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return SearchPackage.Literals.INDEX_DATA_CONTAINER;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<IndexData> getIndexData() {
    if (indexData == null) {
      indexData = new EObjectContainmentEList<IndexData>(IndexData.class, this, SearchPackage.INDEX_DATA_CONTAINER__INDEX_DATA);
    }
    return indexData;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case SearchPackage.INDEX_DATA_CONTAINER__INDEX_DATA:
        return ((InternalEList<?>)getIndexData()).basicRemove(otherEnd, msgs);
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
      case SearchPackage.INDEX_DATA_CONTAINER__INDEX_DATA:
        return getIndexData();
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
      case SearchPackage.INDEX_DATA_CONTAINER__INDEX_DATA:
        getIndexData().clear();
        getIndexData().addAll((Collection<? extends IndexData>)newValue);
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
      case SearchPackage.INDEX_DATA_CONTAINER__INDEX_DATA:
        getIndexData().clear();
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
      case SearchPackage.INDEX_DATA_CONTAINER__INDEX_DATA:
        return indexData != null && !indexData.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //IndexDataContainerImpl
