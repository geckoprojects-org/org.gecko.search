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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.gecko.search.core.model.Descriptor;
import org.gecko.search.core.model.IndexConfiguration;
import org.gecko.search.core.model.IndexData;
import org.gecko.search.core.model.SearchPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Index Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.search.core.model.impl.IndexConfigurationImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.gecko.search.core.model.impl.IndexConfigurationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.gecko.search.core.model.impl.IndexConfigurationImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.gecko.search.core.model.impl.IndexConfigurationImpl#isActive <em>Active</em>}</li>
 *   <li>{@link org.gecko.search.core.model.impl.IndexConfigurationImpl#getIndexData <em>Index Data</em>}</li>
 *   <li>{@link org.gecko.search.core.model.impl.IndexConfigurationImpl#getIndexDescriptors <em>Index Descriptors</em>}</li>
 *   <li>{@link org.gecko.search.core.model.impl.IndexConfigurationImpl#getQueryDescriptors <em>Query Descriptors</em>}</li>
 *   <li>{@link org.gecko.search.core.model.impl.IndexConfigurationImpl#getResultDescriptors <em>Result Descriptors</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IndexConfigurationImpl extends MinimalEObjectImpl.Container implements IndexConfiguration {
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
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
	protected static final String NAME_EDEFAULT = null;

	/**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
	protected String name = NAME_EDEFAULT;

	/**
   * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
   * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
   * The default value of the '{@link #isActive() <em>Active</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #isActive()
   * @generated
   * @ordered
   */
	protected static final boolean ACTIVE_EDEFAULT = true;

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
   * The cached value of the '{@link #getIndexData() <em>Index Data</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getIndexData()
   * @generated
   * @ordered
   */
	protected IndexData indexData;

	/**
   * The cached value of the '{@link #getIndexDescriptors() <em>Index Descriptors</em>}' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getIndexDescriptors()
   * @generated
   * @ordered
   */
	protected EList<Descriptor> indexDescriptors;

	/**
   * The cached value of the '{@link #getQueryDescriptors() <em>Query Descriptors</em>}' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getQueryDescriptors()
   * @generated
   * @ordered
   */
	protected EList<Descriptor> queryDescriptors;

	/**
   * The cached value of the '{@link #getResultDescriptors() <em>Result Descriptors</em>}' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getResultDescriptors()
   * @generated
   * @ordered
   */
	protected EList<Descriptor> resultDescriptors;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected IndexConfigurationImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return SearchPackage.Literals.INDEX_CONFIGURATION;
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
      eNotify(new ENotificationImpl(this, Notification.SET, SearchPackage.INDEX_CONFIGURATION__ID, oldId, id));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String getName() {
    return name;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setName(String newName) {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SearchPackage.INDEX_CONFIGURATION__NAME, oldName, name));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String getDescription() {
    return description;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setDescription(String newDescription) {
    String oldDescription = description;
    description = newDescription;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SearchPackage.INDEX_CONFIGURATION__DESCRIPTION, oldDescription, description));
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
      eNotify(new ENotificationImpl(this, Notification.SET, SearchPackage.INDEX_CONFIGURATION__ACTIVE, oldActive, active));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public IndexData getIndexData() {
    if (indexData != null && indexData.eIsProxy()) {
      InternalEObject oldIndexData = (InternalEObject)indexData;
      indexData = (IndexData)eResolveProxy(oldIndexData);
      if (indexData != oldIndexData) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, SearchPackage.INDEX_CONFIGURATION__INDEX_DATA, oldIndexData, indexData));
      }
    }
    return indexData;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public IndexData basicGetIndexData() {
    return indexData;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setIndexData(IndexData newIndexData) {
    IndexData oldIndexData = indexData;
    indexData = newIndexData;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SearchPackage.INDEX_CONFIGURATION__INDEX_DATA, oldIndexData, indexData));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<Descriptor> getIndexDescriptors() {
    if (indexDescriptors == null) {
      indexDescriptors = new EObjectResolvingEList<Descriptor>(Descriptor.class, this, SearchPackage.INDEX_CONFIGURATION__INDEX_DESCRIPTORS);
    }
    return indexDescriptors;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<Descriptor> getQueryDescriptors() {
    if (queryDescriptors == null) {
      queryDescriptors = new EObjectResolvingEList<Descriptor>(Descriptor.class, this, SearchPackage.INDEX_CONFIGURATION__QUERY_DESCRIPTORS);
    }
    return queryDescriptors;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<Descriptor> getResultDescriptors() {
    if (resultDescriptors == null) {
      resultDescriptors = new EObjectResolvingEList<Descriptor>(Descriptor.class, this, SearchPackage.INDEX_CONFIGURATION__RESULT_DESCRIPTORS);
    }
    return resultDescriptors;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case SearchPackage.INDEX_CONFIGURATION__ID:
        return getId();
      case SearchPackage.INDEX_CONFIGURATION__NAME:
        return getName();
      case SearchPackage.INDEX_CONFIGURATION__DESCRIPTION:
        return getDescription();
      case SearchPackage.INDEX_CONFIGURATION__ACTIVE:
        return isActive();
      case SearchPackage.INDEX_CONFIGURATION__INDEX_DATA:
        if (resolve) return getIndexData();
        return basicGetIndexData();
      case SearchPackage.INDEX_CONFIGURATION__INDEX_DESCRIPTORS:
        return getIndexDescriptors();
      case SearchPackage.INDEX_CONFIGURATION__QUERY_DESCRIPTORS:
        return getQueryDescriptors();
      case SearchPackage.INDEX_CONFIGURATION__RESULT_DESCRIPTORS:
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
      case SearchPackage.INDEX_CONFIGURATION__ID:
        setId((String)newValue);
        return;
      case SearchPackage.INDEX_CONFIGURATION__NAME:
        setName((String)newValue);
        return;
      case SearchPackage.INDEX_CONFIGURATION__DESCRIPTION:
        setDescription((String)newValue);
        return;
      case SearchPackage.INDEX_CONFIGURATION__ACTIVE:
        setActive((Boolean)newValue);
        return;
      case SearchPackage.INDEX_CONFIGURATION__INDEX_DATA:
        setIndexData((IndexData)newValue);
        return;
      case SearchPackage.INDEX_CONFIGURATION__INDEX_DESCRIPTORS:
        getIndexDescriptors().clear();
        getIndexDescriptors().addAll((Collection<? extends Descriptor>)newValue);
        return;
      case SearchPackage.INDEX_CONFIGURATION__QUERY_DESCRIPTORS:
        getQueryDescriptors().clear();
        getQueryDescriptors().addAll((Collection<? extends Descriptor>)newValue);
        return;
      case SearchPackage.INDEX_CONFIGURATION__RESULT_DESCRIPTORS:
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
      case SearchPackage.INDEX_CONFIGURATION__ID:
        setId(ID_EDEFAULT);
        return;
      case SearchPackage.INDEX_CONFIGURATION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case SearchPackage.INDEX_CONFIGURATION__DESCRIPTION:
        setDescription(DESCRIPTION_EDEFAULT);
        return;
      case SearchPackage.INDEX_CONFIGURATION__ACTIVE:
        setActive(ACTIVE_EDEFAULT);
        return;
      case SearchPackage.INDEX_CONFIGURATION__INDEX_DATA:
        setIndexData((IndexData)null);
        return;
      case SearchPackage.INDEX_CONFIGURATION__INDEX_DESCRIPTORS:
        getIndexDescriptors().clear();
        return;
      case SearchPackage.INDEX_CONFIGURATION__QUERY_DESCRIPTORS:
        getQueryDescriptors().clear();
        return;
      case SearchPackage.INDEX_CONFIGURATION__RESULT_DESCRIPTORS:
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
      case SearchPackage.INDEX_CONFIGURATION__ID:
        return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
      case SearchPackage.INDEX_CONFIGURATION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case SearchPackage.INDEX_CONFIGURATION__DESCRIPTION:
        return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
      case SearchPackage.INDEX_CONFIGURATION__ACTIVE:
        return active != ACTIVE_EDEFAULT;
      case SearchPackage.INDEX_CONFIGURATION__INDEX_DATA:
        return indexData != null;
      case SearchPackage.INDEX_CONFIGURATION__INDEX_DESCRIPTORS:
        return indexDescriptors != null && !indexDescriptors.isEmpty();
      case SearchPackage.INDEX_CONFIGURATION__QUERY_DESCRIPTORS:
        return queryDescriptors != null && !queryDescriptors.isEmpty();
      case SearchPackage.INDEX_CONFIGURATION__RESULT_DESCRIPTORS:
        return resultDescriptors != null && !resultDescriptors.isEmpty();
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
    result.append(", name: ");
    result.append(name);
    result.append(", description: ");
    result.append(description);
    result.append(", active: ");
    result.append(active);
    result.append(')');
    return result.toString();
  }

} //IndexConfigurationImpl
