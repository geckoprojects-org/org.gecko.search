/**
 */
package org.gecko.searchindex.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.gecko.searchindex.FacetFieldObject;
import org.gecko.searchindex.IndexDescriptor;
import org.gecko.searchindex.IndexFieldObject;
import org.gecko.searchindex.IndexObject;
import org.gecko.searchindex.SearchIndexPackage;
import org.gecko.searchindex.SearchableFacetDocumentObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Index Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchindex.impl.IndexObjectImpl#getObject <em>Object</em>}</li>
 *   <li>{@link org.gecko.searchindex.impl.IndexObjectImpl#getDescriptor <em>Descriptor</em>}</li>
 *   <li>{@link org.gecko.searchindex.impl.IndexObjectImpl#getFieldObjects <em>Field Objects</em>}</li>
 *   <li>{@link org.gecko.searchindex.impl.IndexObjectImpl#getIdField <em>Id Field</em>}</li>
 *   <li>{@link org.gecko.searchindex.impl.IndexObjectImpl#getFacetObjects <em>Facet Objects</em>}</li>
 *   <li>{@link org.gecko.searchindex.impl.IndexObjectImpl#getSearchableFacetDocumentObjects <em>Searchable Facet Document Objects</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IndexObjectImpl extends MinimalEObjectImpl.Container implements IndexObject {
	/**
	 * The cached value of the '{@link #getObject() <em>Object</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObject()
	 * @generated
	 * @ordered
	 */
	protected EList<Object> object;

	/**
	 * The cached value of the '{@link #getDescriptor() <em>Descriptor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptor()
	 * @generated
	 * @ordered
	 */
	protected IndexDescriptor descriptor;

	/**
	 * The cached value of the '{@link #getFieldObjects() <em>Field Objects</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFieldObjects()
	 * @generated
	 * @ordered
	 */
	protected EList<IndexFieldObject> fieldObjects;

	/**
	 * The cached value of the '{@link #getFacetObjects() <em>Facet Objects</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacetObjects()
	 * @generated
	 * @ordered
	 */
	protected EList<FacetFieldObject> facetObjects;

	/**
	 * The cached value of the '{@link #getSearchableFacetDocumentObjects() <em>Searchable Facet Document Objects</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSearchableFacetDocumentObjects()
	 * @generated
	 * @ordered
	 */
	protected EList<SearchableFacetDocumentObject> searchableFacetDocumentObjects;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IndexObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SearchIndexPackage.Literals.INDEX_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Object> getObject() {
		if (object == null) {
			object = new EDataTypeUniqueEList<Object>(Object.class, this, SearchIndexPackage.INDEX_OBJECT__OBJECT);
		}
		return object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndexDescriptor getDescriptor() {
		if (descriptor != null && descriptor.eIsProxy()) {
			InternalEObject oldDescriptor = (InternalEObject)descriptor;
			descriptor = (IndexDescriptor)eResolveProxy(oldDescriptor);
			if (descriptor != oldDescriptor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SearchIndexPackage.INDEX_OBJECT__DESCRIPTOR, oldDescriptor, descriptor));
			}
		}
		return descriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndexDescriptor basicGetDescriptor() {
		return descriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescriptor(IndexDescriptor newDescriptor) {
		IndexDescriptor oldDescriptor = descriptor;
		descriptor = newDescriptor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchIndexPackage.INDEX_OBJECT__DESCRIPTOR, oldDescriptor, descriptor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IndexFieldObject> getFieldObjects() {
		if (fieldObjects == null) {
			fieldObjects = new EObjectContainmentEList<IndexFieldObject>(IndexFieldObject.class, this, SearchIndexPackage.INDEX_OBJECT__FIELD_OBJECTS);
		}
		return fieldObjects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndexFieldObject getIdField() {
		IndexFieldObject idField = basicGetIdField();
		return idField != null && idField.eIsProxy() ? (IndexFieldObject)eResolveProxy((InternalEObject)idField) : idField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndexFieldObject basicGetIdField() {
		// TODO: implement this method to return the 'Id Field' reference
		// -> do not perform proxy resolution
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FacetFieldObject> getFacetObjects() {
		if (facetObjects == null) {
			facetObjects = new EObjectContainmentEList<FacetFieldObject>(FacetFieldObject.class, this, SearchIndexPackage.INDEX_OBJECT__FACET_OBJECTS);
		}
		return facetObjects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SearchableFacetDocumentObject> getSearchableFacetDocumentObjects() {
		if (searchableFacetDocumentObjects == null) {
			searchableFacetDocumentObjects = new EObjectContainmentEList<SearchableFacetDocumentObject>(SearchableFacetDocumentObject.class, this, SearchIndexPackage.INDEX_OBJECT__SEARCHABLE_FACET_DOCUMENT_OBJECTS);
		}
		return searchableFacetDocumentObjects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SearchIndexPackage.INDEX_OBJECT__FIELD_OBJECTS:
				return ((InternalEList<?>)getFieldObjects()).basicRemove(otherEnd, msgs);
			case SearchIndexPackage.INDEX_OBJECT__FACET_OBJECTS:
				return ((InternalEList<?>)getFacetObjects()).basicRemove(otherEnd, msgs);
			case SearchIndexPackage.INDEX_OBJECT__SEARCHABLE_FACET_DOCUMENT_OBJECTS:
				return ((InternalEList<?>)getSearchableFacetDocumentObjects()).basicRemove(otherEnd, msgs);
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
			case SearchIndexPackage.INDEX_OBJECT__OBJECT:
				return getObject();
			case SearchIndexPackage.INDEX_OBJECT__DESCRIPTOR:
				if (resolve) return getDescriptor();
				return basicGetDescriptor();
			case SearchIndexPackage.INDEX_OBJECT__FIELD_OBJECTS:
				return getFieldObjects();
			case SearchIndexPackage.INDEX_OBJECT__ID_FIELD:
				if (resolve) return getIdField();
				return basicGetIdField();
			case SearchIndexPackage.INDEX_OBJECT__FACET_OBJECTS:
				return getFacetObjects();
			case SearchIndexPackage.INDEX_OBJECT__SEARCHABLE_FACET_DOCUMENT_OBJECTS:
				return getSearchableFacetDocumentObjects();
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
			case SearchIndexPackage.INDEX_OBJECT__OBJECT:
				getObject().clear();
				getObject().addAll((Collection<? extends Object>)newValue);
				return;
			case SearchIndexPackage.INDEX_OBJECT__DESCRIPTOR:
				setDescriptor((IndexDescriptor)newValue);
				return;
			case SearchIndexPackage.INDEX_OBJECT__FIELD_OBJECTS:
				getFieldObjects().clear();
				getFieldObjects().addAll((Collection<? extends IndexFieldObject>)newValue);
				return;
			case SearchIndexPackage.INDEX_OBJECT__FACET_OBJECTS:
				getFacetObjects().clear();
				getFacetObjects().addAll((Collection<? extends FacetFieldObject>)newValue);
				return;
			case SearchIndexPackage.INDEX_OBJECT__SEARCHABLE_FACET_DOCUMENT_OBJECTS:
				getSearchableFacetDocumentObjects().clear();
				getSearchableFacetDocumentObjects().addAll((Collection<? extends SearchableFacetDocumentObject>)newValue);
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
			case SearchIndexPackage.INDEX_OBJECT__OBJECT:
				getObject().clear();
				return;
			case SearchIndexPackage.INDEX_OBJECT__DESCRIPTOR:
				setDescriptor((IndexDescriptor)null);
				return;
			case SearchIndexPackage.INDEX_OBJECT__FIELD_OBJECTS:
				getFieldObjects().clear();
				return;
			case SearchIndexPackage.INDEX_OBJECT__FACET_OBJECTS:
				getFacetObjects().clear();
				return;
			case SearchIndexPackage.INDEX_OBJECT__SEARCHABLE_FACET_DOCUMENT_OBJECTS:
				getSearchableFacetDocumentObjects().clear();
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
			case SearchIndexPackage.INDEX_OBJECT__OBJECT:
				return object != null && !object.isEmpty();
			case SearchIndexPackage.INDEX_OBJECT__DESCRIPTOR:
				return descriptor != null;
			case SearchIndexPackage.INDEX_OBJECT__FIELD_OBJECTS:
				return fieldObjects != null && !fieldObjects.isEmpty();
			case SearchIndexPackage.INDEX_OBJECT__ID_FIELD:
				return basicGetIdField() != null;
			case SearchIndexPackage.INDEX_OBJECT__FACET_OBJECTS:
				return facetObjects != null && !facetObjects.isEmpty();
			case SearchIndexPackage.INDEX_OBJECT__SEARCHABLE_FACET_DOCUMENT_OBJECTS:
				return searchableFacetDocumentObjects != null && !searchableFacetDocumentObjects.isEmpty();
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
		result.append(" (object: ");
		result.append(object);
		result.append(')');
		return result.toString();
	}

} //IndexObjectImpl
