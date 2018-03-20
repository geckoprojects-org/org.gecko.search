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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.gecko.search.core.model.IndexData;
import org.gecko.search.core.model.IndexDataType;
import org.gecko.search.core.model.SearchPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Index Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.search.core.model.impl.IndexDataImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.gecko.search.core.model.impl.IndexDataImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.gecko.search.core.model.impl.IndexDataImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.gecko.search.core.model.impl.IndexDataImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.gecko.search.core.model.impl.IndexDataImpl#getUri <em>Uri</em>}</li>
 *   <li>{@link org.gecko.search.core.model.impl.IndexDataImpl#getWorkspaceProviderId <em>Workspace Provider Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IndexDataImpl extends MinimalEObjectImpl.Container implements IndexData {
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
   * The default value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
	protected static final IndexDataType TYPE_EDEFAULT = IndexDataType.FILE_SYSTEM;

	/**
   * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
	protected IndexDataType type = TYPE_EDEFAULT;

	/**
   * The default value of the '{@link #getUri() <em>Uri</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getUri()
   * @generated
   * @ordered
   */
	protected static final String URI_EDEFAULT = null;

	/**
   * The cached value of the '{@link #getUri() <em>Uri</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getUri()
   * @generated
   * @ordered
   */
	protected String uri = URI_EDEFAULT;

	/**
   * The default value of the '{@link #getWorkspaceProviderId() <em>Workspace Provider Id</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getWorkspaceProviderId()
   * @generated
   * @ordered
   */
	protected static final String WORKSPACE_PROVIDER_ID_EDEFAULT = null;

	/**
   * The cached value of the '{@link #getWorkspaceProviderId() <em>Workspace Provider Id</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getWorkspaceProviderId()
   * @generated
   * @ordered
   */
	protected String workspaceProviderId = WORKSPACE_PROVIDER_ID_EDEFAULT;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected IndexDataImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return SearchPackage.Literals.INDEX_DATA;
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
      eNotify(new ENotificationImpl(this, Notification.SET, SearchPackage.INDEX_DATA__ID, oldId, id));
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
      eNotify(new ENotificationImpl(this, Notification.SET, SearchPackage.INDEX_DATA__NAME, oldName, name));
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
      eNotify(new ENotificationImpl(this, Notification.SET, SearchPackage.INDEX_DATA__DESCRIPTION, oldDescription, description));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public IndexDataType getType() {
    return type;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setType(IndexDataType newType) {
    IndexDataType oldType = type;
    type = newType == null ? TYPE_EDEFAULT : newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SearchPackage.INDEX_DATA__TYPE, oldType, type));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String getUri() {
    return uri;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setUri(String newUri) {
    String oldUri = uri;
    uri = newUri;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SearchPackage.INDEX_DATA__URI, oldUri, uri));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String getWorkspaceProviderId() {
    return workspaceProviderId;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setWorkspaceProviderId(String newWorkspaceProviderId) {
    String oldWorkspaceProviderId = workspaceProviderId;
    workspaceProviderId = newWorkspaceProviderId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SearchPackage.INDEX_DATA__WORKSPACE_PROVIDER_ID, oldWorkspaceProviderId, workspaceProviderId));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case SearchPackage.INDEX_DATA__ID:
        return getId();
      case SearchPackage.INDEX_DATA__NAME:
        return getName();
      case SearchPackage.INDEX_DATA__DESCRIPTION:
        return getDescription();
      case SearchPackage.INDEX_DATA__TYPE:
        return getType();
      case SearchPackage.INDEX_DATA__URI:
        return getUri();
      case SearchPackage.INDEX_DATA__WORKSPACE_PROVIDER_ID:
        return getWorkspaceProviderId();
    }
    return super.eGet(featureID, resolve, coreType);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case SearchPackage.INDEX_DATA__ID:
        setId((String)newValue);
        return;
      case SearchPackage.INDEX_DATA__NAME:
        setName((String)newValue);
        return;
      case SearchPackage.INDEX_DATA__DESCRIPTION:
        setDescription((String)newValue);
        return;
      case SearchPackage.INDEX_DATA__TYPE:
        setType((IndexDataType)newValue);
        return;
      case SearchPackage.INDEX_DATA__URI:
        setUri((String)newValue);
        return;
      case SearchPackage.INDEX_DATA__WORKSPACE_PROVIDER_ID:
        setWorkspaceProviderId((String)newValue);
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
      case SearchPackage.INDEX_DATA__ID:
        setId(ID_EDEFAULT);
        return;
      case SearchPackage.INDEX_DATA__NAME:
        setName(NAME_EDEFAULT);
        return;
      case SearchPackage.INDEX_DATA__DESCRIPTION:
        setDescription(DESCRIPTION_EDEFAULT);
        return;
      case SearchPackage.INDEX_DATA__TYPE:
        setType(TYPE_EDEFAULT);
        return;
      case SearchPackage.INDEX_DATA__URI:
        setUri(URI_EDEFAULT);
        return;
      case SearchPackage.INDEX_DATA__WORKSPACE_PROVIDER_ID:
        setWorkspaceProviderId(WORKSPACE_PROVIDER_ID_EDEFAULT);
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
      case SearchPackage.INDEX_DATA__ID:
        return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
      case SearchPackage.INDEX_DATA__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case SearchPackage.INDEX_DATA__DESCRIPTION:
        return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
      case SearchPackage.INDEX_DATA__TYPE:
        return type != TYPE_EDEFAULT;
      case SearchPackage.INDEX_DATA__URI:
        return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
      case SearchPackage.INDEX_DATA__WORKSPACE_PROVIDER_ID:
        return WORKSPACE_PROVIDER_ID_EDEFAULT == null ? workspaceProviderId != null : !WORKSPACE_PROVIDER_ID_EDEFAULT.equals(workspaceProviderId);
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
    result.append(", type: ");
    result.append(type);
    result.append(", uri: ");
    result.append(uri);
    result.append(", workspaceProviderId: ");
    result.append(workspaceProviderId);
    result.append(')');
    return result.toString();
  }

} //IndexDataImpl
