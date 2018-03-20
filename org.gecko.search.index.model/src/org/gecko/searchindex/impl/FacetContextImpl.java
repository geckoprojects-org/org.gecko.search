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

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.gecko.searchindex.FacetContext;
import org.gecko.searchindex.FacetField;
import org.gecko.searchindex.FacetIndexWriterType;
import org.gecko.searchindex.SearchIndexPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Facet Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchindex.impl.FacetContextImpl#getFacetWriter <em>Facet Writer</em>}</li>
 *   <li>{@link org.gecko.searchindex.impl.FacetContextImpl#getFacetFields <em>Facet Fields</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FacetContextImpl extends MinimalEObjectImpl.Container implements FacetContext {
	/**
	 * The default value of the '{@link #getFacetWriter() <em>Facet Writer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacetWriter()
	 * @generated
	 * @ordered
	 */
	protected static final FacetIndexWriterType FACET_WRITER_EDEFAULT = FacetIndexWriterType.TAXONOMY_WRITER;

	/**
	 * The cached value of the '{@link #getFacetWriter() <em>Facet Writer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacetWriter()
	 * @generated
	 * @ordered
	 */
	protected FacetIndexWriterType facetWriter = FACET_WRITER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFacetFields() <em>Facet Fields</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacetFields()
	 * @generated
	 * @ordered
	 */
	protected EList<FacetField> facetFields;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FacetContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SearchIndexPackage.Literals.FACET_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FacetIndexWriterType getFacetWriter() {
		return facetWriter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFacetWriter(FacetIndexWriterType newFacetWriter) {
		FacetIndexWriterType oldFacetWriter = facetWriter;
		facetWriter = newFacetWriter == null ? FACET_WRITER_EDEFAULT : newFacetWriter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchIndexPackage.FACET_CONTEXT__FACET_WRITER, oldFacetWriter, facetWriter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FacetField> getFacetFields() {
		if (facetFields == null) {
			facetFields = new EObjectContainmentWithInverseEList<FacetField>(FacetField.class, this, SearchIndexPackage.FACET_CONTEXT__FACET_FIELDS, SearchIndexPackage.FACET_FIELD__FACET_CONTEXT);
		}
		return facetFields;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SearchIndexPackage.FACET_CONTEXT__FACET_FIELDS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFacetFields()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SearchIndexPackage.FACET_CONTEXT__FACET_FIELDS:
				return ((InternalEList<?>)getFacetFields()).basicRemove(otherEnd, msgs);
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
			case SearchIndexPackage.FACET_CONTEXT__FACET_WRITER:
				return getFacetWriter();
			case SearchIndexPackage.FACET_CONTEXT__FACET_FIELDS:
				return getFacetFields();
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
			case SearchIndexPackage.FACET_CONTEXT__FACET_WRITER:
				setFacetWriter((FacetIndexWriterType)newValue);
				return;
			case SearchIndexPackage.FACET_CONTEXT__FACET_FIELDS:
				getFacetFields().clear();
				getFacetFields().addAll((Collection<? extends FacetField>)newValue);
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
			case SearchIndexPackage.FACET_CONTEXT__FACET_WRITER:
				setFacetWriter(FACET_WRITER_EDEFAULT);
				return;
			case SearchIndexPackage.FACET_CONTEXT__FACET_FIELDS:
				getFacetFields().clear();
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
			case SearchIndexPackage.FACET_CONTEXT__FACET_WRITER:
				return facetWriter != FACET_WRITER_EDEFAULT;
			case SearchIndexPackage.FACET_CONTEXT__FACET_FIELDS:
				return facetFields != null && !facetFields.isEmpty();
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
		result.append(" (facetWriter: ");
		result.append(facetWriter);
		result.append(')');
		return result.toString();
	}

} //FacetContextImpl
