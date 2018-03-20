/**
 */
package org.gecko.searchindex.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.gecko.emf.utilities.FeaturePath;

import org.gecko.searchindex.FacetContext;
import org.gecko.searchindex.FacetField;
import org.gecko.searchindex.IndexField;
import org.gecko.searchindex.SearchIndexPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Facet Field</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchindex.impl.FacetFieldImpl#getKey <em>Key</em>}</li>
 *   <li>{@link org.gecko.searchindex.impl.FacetFieldImpl#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.gecko.searchindex.impl.FacetFieldImpl#isMultiValued <em>Multi Valued</em>}</li>
 *   <li>{@link org.gecko.searchindex.impl.FacetFieldImpl#isHirachical <em>Hirachical</em>}</li>
 *   <li>{@link org.gecko.searchindex.impl.FacetFieldImpl#isRequireCount <em>Require Count</em>}</li>
 *   <li>{@link org.gecko.searchindex.impl.FacetFieldImpl#getReferencedIndexField <em>Referenced Index Field</em>}</li>
 *   <li>{@link org.gecko.searchindex.impl.FacetFieldImpl#getFacetContext <em>Facet Context</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FacetFieldImpl extends MinimalEObjectImpl.Container implements FacetField {
	/**
	 * The default value of the '{@link #getKey() <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKey()
	 * @generated
	 * @ordered
	 */
	protected static final String KEY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKey() <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKey()
	 * @generated
	 * @ordered
	 */
	protected String key = KEY_EDEFAULT;

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
	 * The default value of the '{@link #isMultiValued() <em>Multi Valued</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMultiValued()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MULTI_VALUED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMultiValued() <em>Multi Valued</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMultiValued()
	 * @generated
	 * @ordered
	 */
	protected boolean multiValued = MULTI_VALUED_EDEFAULT;

	/**
	 * The default value of the '{@link #isHirachical() <em>Hirachical</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHirachical()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HIRACHICAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHirachical() <em>Hirachical</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHirachical()
	 * @generated
	 * @ordered
	 */
	protected boolean hirachical = HIRACHICAL_EDEFAULT;

	/**
	 * The default value of the '{@link #isRequireCount() <em>Require Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRequireCount()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REQUIRE_COUNT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRequireCount() <em>Require Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRequireCount()
	 * @generated
	 * @ordered
	 */
	protected boolean requireCount = REQUIRE_COUNT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReferencedIndexField() <em>Referenced Index Field</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencedIndexField()
	 * @generated
	 * @ordered
	 */
	protected IndexField referencedIndexField;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FacetFieldImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SearchIndexPackage.Literals.FACET_FIELD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getKey() {
		return key;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKey(String newKey) {
		String oldKey = key;
		key = newKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchIndexPackage.FACET_FIELD__KEY, oldKey, key));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SearchIndexPackage.FACET_FIELD__FEATURE, oldFeature, newFeature);
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
				msgs = ((InternalEObject)feature).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SearchIndexPackage.FACET_FIELD__FEATURE, null, msgs);
			if (newFeature != null)
				msgs = ((InternalEObject)newFeature).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SearchIndexPackage.FACET_FIELD__FEATURE, null, msgs);
			msgs = basicSetFeature(newFeature, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchIndexPackage.FACET_FIELD__FEATURE, newFeature, newFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMultiValued() {
		return multiValued;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMultiValued(boolean newMultiValued) {
		boolean oldMultiValued = multiValued;
		multiValued = newMultiValued;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchIndexPackage.FACET_FIELD__MULTI_VALUED, oldMultiValued, multiValued));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHirachical() {
		return hirachical;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHirachical(boolean newHirachical) {
		boolean oldHirachical = hirachical;
		hirachical = newHirachical;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchIndexPackage.FACET_FIELD__HIRACHICAL, oldHirachical, hirachical));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRequireCount() {
		return requireCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequireCount(boolean newRequireCount) {
		boolean oldRequireCount = requireCount;
		requireCount = newRequireCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchIndexPackage.FACET_FIELD__REQUIRE_COUNT, oldRequireCount, requireCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndexField getReferencedIndexField() {
		if (referencedIndexField != null && referencedIndexField.eIsProxy()) {
			InternalEObject oldReferencedIndexField = (InternalEObject)referencedIndexField;
			referencedIndexField = (IndexField)eResolveProxy(oldReferencedIndexField);
			if (referencedIndexField != oldReferencedIndexField) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SearchIndexPackage.FACET_FIELD__REFERENCED_INDEX_FIELD, oldReferencedIndexField, referencedIndexField));
			}
		}
		return referencedIndexField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndexField basicGetReferencedIndexField() {
		return referencedIndexField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferencedIndexField(IndexField newReferencedIndexField) {
		IndexField oldReferencedIndexField = referencedIndexField;
		referencedIndexField = newReferencedIndexField;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchIndexPackage.FACET_FIELD__REFERENCED_INDEX_FIELD, oldReferencedIndexField, referencedIndexField));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FacetContext getFacetContext() {
		if (eContainerFeatureID() != SearchIndexPackage.FACET_FIELD__FACET_CONTEXT) return null;
		return (FacetContext)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFacetContext(FacetContext newFacetContext, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newFacetContext, SearchIndexPackage.FACET_FIELD__FACET_CONTEXT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFacetContext(FacetContext newFacetContext) {
		if (newFacetContext != eInternalContainer() || (eContainerFeatureID() != SearchIndexPackage.FACET_FIELD__FACET_CONTEXT && newFacetContext != null)) {
			if (EcoreUtil.isAncestor(this, newFacetContext))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newFacetContext != null)
				msgs = ((InternalEObject)newFacetContext).eInverseAdd(this, SearchIndexPackage.FACET_CONTEXT__FACET_FIELDS, FacetContext.class, msgs);
			msgs = basicSetFacetContext(newFacetContext, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchIndexPackage.FACET_FIELD__FACET_CONTEXT, newFacetContext, newFacetContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SearchIndexPackage.FACET_FIELD__FACET_CONTEXT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetFacetContext((FacetContext)otherEnd, msgs);
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
			case SearchIndexPackage.FACET_FIELD__FEATURE:
				return basicSetFeature(null, msgs);
			case SearchIndexPackage.FACET_FIELD__FACET_CONTEXT:
				return basicSetFacetContext(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case SearchIndexPackage.FACET_FIELD__FACET_CONTEXT:
				return eInternalContainer().eInverseRemove(this, SearchIndexPackage.FACET_CONTEXT__FACET_FIELDS, FacetContext.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SearchIndexPackage.FACET_FIELD__KEY:
				return getKey();
			case SearchIndexPackage.FACET_FIELD__FEATURE:
				return getFeature();
			case SearchIndexPackage.FACET_FIELD__MULTI_VALUED:
				return isMultiValued();
			case SearchIndexPackage.FACET_FIELD__HIRACHICAL:
				return isHirachical();
			case SearchIndexPackage.FACET_FIELD__REQUIRE_COUNT:
				return isRequireCount();
			case SearchIndexPackage.FACET_FIELD__REFERENCED_INDEX_FIELD:
				if (resolve) return getReferencedIndexField();
				return basicGetReferencedIndexField();
			case SearchIndexPackage.FACET_FIELD__FACET_CONTEXT:
				return getFacetContext();
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
			case SearchIndexPackage.FACET_FIELD__KEY:
				setKey((String)newValue);
				return;
			case SearchIndexPackage.FACET_FIELD__FEATURE:
				setFeature((FeaturePath)newValue);
				return;
			case SearchIndexPackage.FACET_FIELD__MULTI_VALUED:
				setMultiValued((Boolean)newValue);
				return;
			case SearchIndexPackage.FACET_FIELD__HIRACHICAL:
				setHirachical((Boolean)newValue);
				return;
			case SearchIndexPackage.FACET_FIELD__REQUIRE_COUNT:
				setRequireCount((Boolean)newValue);
				return;
			case SearchIndexPackage.FACET_FIELD__REFERENCED_INDEX_FIELD:
				setReferencedIndexField((IndexField)newValue);
				return;
			case SearchIndexPackage.FACET_FIELD__FACET_CONTEXT:
				setFacetContext((FacetContext)newValue);
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
			case SearchIndexPackage.FACET_FIELD__KEY:
				setKey(KEY_EDEFAULT);
				return;
			case SearchIndexPackage.FACET_FIELD__FEATURE:
				setFeature((FeaturePath)null);
				return;
			case SearchIndexPackage.FACET_FIELD__MULTI_VALUED:
				setMultiValued(MULTI_VALUED_EDEFAULT);
				return;
			case SearchIndexPackage.FACET_FIELD__HIRACHICAL:
				setHirachical(HIRACHICAL_EDEFAULT);
				return;
			case SearchIndexPackage.FACET_FIELD__REQUIRE_COUNT:
				setRequireCount(REQUIRE_COUNT_EDEFAULT);
				return;
			case SearchIndexPackage.FACET_FIELD__REFERENCED_INDEX_FIELD:
				setReferencedIndexField((IndexField)null);
				return;
			case SearchIndexPackage.FACET_FIELD__FACET_CONTEXT:
				setFacetContext((FacetContext)null);
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
			case SearchIndexPackage.FACET_FIELD__KEY:
				return KEY_EDEFAULT == null ? key != null : !KEY_EDEFAULT.equals(key);
			case SearchIndexPackage.FACET_FIELD__FEATURE:
				return feature != null;
			case SearchIndexPackage.FACET_FIELD__MULTI_VALUED:
				return multiValued != MULTI_VALUED_EDEFAULT;
			case SearchIndexPackage.FACET_FIELD__HIRACHICAL:
				return hirachical != HIRACHICAL_EDEFAULT;
			case SearchIndexPackage.FACET_FIELD__REQUIRE_COUNT:
				return requireCount != REQUIRE_COUNT_EDEFAULT;
			case SearchIndexPackage.FACET_FIELD__REFERENCED_INDEX_FIELD:
				return referencedIndexField != null;
			case SearchIndexPackage.FACET_FIELD__FACET_CONTEXT:
				return getFacetContext() != null;
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
		result.append(" (key: ");
		result.append(key);
		result.append(", multiValued: ");
		result.append(multiValued);
		result.append(", hirachical: ");
		result.append(hirachical);
		result.append(", requireCount: ");
		result.append(requireCount);
		result.append(')');
		return result.toString();
	}

} //FacetFieldImpl
