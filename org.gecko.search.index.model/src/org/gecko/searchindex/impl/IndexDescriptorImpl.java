/**
 */
package org.gecko.searchindex.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.gecko.searchindex.FacetContext;
import org.gecko.searchindex.IndexDescriptor;
import org.gecko.searchindex.IndexField;
import org.gecko.searchindex.SearchIndexPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Index Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchindex.impl.IndexDescriptorImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.gecko.searchindex.impl.IndexDescriptorImpl#getFields <em>Fields</em>}</li>
 *   <li>{@link org.gecko.searchindex.impl.IndexDescriptorImpl#getBoost <em>Boost</em>}</li>
 *   <li>{@link org.gecko.searchindex.impl.IndexDescriptorImpl#getReferencedDescriptors <em>Referenced Descriptors</em>}</li>
 *   <li>{@link org.gecko.searchindex.impl.IndexDescriptorImpl#getClasses <em>Classes</em>}</li>
 *   <li>{@link org.gecko.searchindex.impl.IndexDescriptorImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.gecko.searchindex.impl.IndexDescriptorImpl#isActive <em>Active</em>}</li>
 *   <li>{@link org.gecko.searchindex.impl.IndexDescriptorImpl#getFacetContext <em>Facet Context</em>}</li>
 *   <li>{@link org.gecko.searchindex.impl.IndexDescriptorImpl#isUseDynamicPerFieldAnalyizer <em>Use Dynamic Per Field Analyizer</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IndexDescriptorImpl extends MinimalEObjectImpl.Container implements IndexDescriptor {
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
	 * The cached value of the '{@link #getFields() <em>Fields</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFields()
	 * @generated
	 * @ordered
	 */
	protected EList<IndexField> fields;

	/**
	 * The default value of the '{@link #getBoost() <em>Boost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoost()
	 * @generated
	 * @ordered
	 */
	protected static final float BOOST_EDEFAULT = 1.0F;

	/**
	 * The cached value of the '{@link #getBoost() <em>Boost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoost()
	 * @generated
	 * @ordered
	 */
	protected float boost = BOOST_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReferencedDescriptors() <em>Referenced Descriptors</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencedDescriptors()
	 * @generated
	 * @ordered
	 */
	protected EList<IndexDescriptor> referencedDescriptors;

	/**
	 * The cached value of the '{@link #getClasses() <em>Classes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<EClass> classes;

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
	protected static final boolean ACTIVE_EDEFAULT = false;

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
	 * The cached value of the '{@link #getFacetContext() <em>Facet Context</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacetContext()
	 * @generated
	 * @ordered
	 */
	protected FacetContext facetContext;

	/**
	 * The default value of the '{@link #isUseDynamicPerFieldAnalyizer() <em>Use Dynamic Per Field Analyizer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUseDynamicPerFieldAnalyizer()
	 * @generated
	 * @ordered
	 */
	protected static final boolean USE_DYNAMIC_PER_FIELD_ANALYIZER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUseDynamicPerFieldAnalyizer() <em>Use Dynamic Per Field Analyizer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUseDynamicPerFieldAnalyizer()
	 * @generated
	 * @ordered
	 */
	protected boolean useDynamicPerFieldAnalyizer = USE_DYNAMIC_PER_FIELD_ANALYIZER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IndexDescriptorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SearchIndexPackage.Literals.INDEX_DESCRIPTOR;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SearchIndexPackage.INDEX_DESCRIPTOR__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IndexField> getFields() {
		if (fields == null) {
			fields = new EObjectContainmentEList<IndexField>(IndexField.class, this, SearchIndexPackage.INDEX_DESCRIPTOR__FIELDS);
		}
		return fields;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getBoost() {
		return boost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoost(float newBoost) {
		float oldBoost = boost;
		boost = newBoost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchIndexPackage.INDEX_DESCRIPTOR__BOOST, oldBoost, boost));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IndexDescriptor> getReferencedDescriptors() {
		if (referencedDescriptors == null) {
			referencedDescriptors = new EObjectResolvingEList<IndexDescriptor>(IndexDescriptor.class, this, SearchIndexPackage.INDEX_DESCRIPTOR__REFERENCED_DESCRIPTORS);
		}
		return referencedDescriptors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EClass> getClasses() {
		if (classes == null) {
			classes = new EObjectResolvingEList<EClass>(EClass.class, this, SearchIndexPackage.INDEX_DESCRIPTOR__CLASSES);
		}
		return classes;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SearchIndexPackage.INDEX_DESCRIPTOR__DESCRIPTION, oldDescription, description));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SearchIndexPackage.INDEX_DESCRIPTOR__ACTIVE, oldActive, active));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FacetContext getFacetContext() {
		return facetContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFacetContext(FacetContext newFacetContext, NotificationChain msgs) {
		FacetContext oldFacetContext = facetContext;
		facetContext = newFacetContext;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SearchIndexPackage.INDEX_DESCRIPTOR__FACET_CONTEXT, oldFacetContext, newFacetContext);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFacetContext(FacetContext newFacetContext) {
		if (newFacetContext != facetContext) {
			NotificationChain msgs = null;
			if (facetContext != null)
				msgs = ((InternalEObject)facetContext).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SearchIndexPackage.INDEX_DESCRIPTOR__FACET_CONTEXT, null, msgs);
			if (newFacetContext != null)
				msgs = ((InternalEObject)newFacetContext).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SearchIndexPackage.INDEX_DESCRIPTOR__FACET_CONTEXT, null, msgs);
			msgs = basicSetFacetContext(newFacetContext, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchIndexPackage.INDEX_DESCRIPTOR__FACET_CONTEXT, newFacetContext, newFacetContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUseDynamicPerFieldAnalyizer() {
		return useDynamicPerFieldAnalyizer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUseDynamicPerFieldAnalyizer(boolean newUseDynamicPerFieldAnalyizer) {
		boolean oldUseDynamicPerFieldAnalyizer = useDynamicPerFieldAnalyizer;
		useDynamicPerFieldAnalyizer = newUseDynamicPerFieldAnalyizer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchIndexPackage.INDEX_DESCRIPTOR__USE_DYNAMIC_PER_FIELD_ANALYIZER, oldUseDynamicPerFieldAnalyizer, useDynamicPerFieldAnalyizer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndexField getIndexField(EStructuralFeature feature) {
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
			case SearchIndexPackage.INDEX_DESCRIPTOR__FIELDS:
				return ((InternalEList<?>)getFields()).basicRemove(otherEnd, msgs);
			case SearchIndexPackage.INDEX_DESCRIPTOR__FACET_CONTEXT:
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SearchIndexPackage.INDEX_DESCRIPTOR__ID:
				return getId();
			case SearchIndexPackage.INDEX_DESCRIPTOR__FIELDS:
				return getFields();
			case SearchIndexPackage.INDEX_DESCRIPTOR__BOOST:
				return getBoost();
			case SearchIndexPackage.INDEX_DESCRIPTOR__REFERENCED_DESCRIPTORS:
				return getReferencedDescriptors();
			case SearchIndexPackage.INDEX_DESCRIPTOR__CLASSES:
				return getClasses();
			case SearchIndexPackage.INDEX_DESCRIPTOR__DESCRIPTION:
				return getDescription();
			case SearchIndexPackage.INDEX_DESCRIPTOR__ACTIVE:
				return isActive();
			case SearchIndexPackage.INDEX_DESCRIPTOR__FACET_CONTEXT:
				return getFacetContext();
			case SearchIndexPackage.INDEX_DESCRIPTOR__USE_DYNAMIC_PER_FIELD_ANALYIZER:
				return isUseDynamicPerFieldAnalyizer();
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
			case SearchIndexPackage.INDEX_DESCRIPTOR__ID:
				setId((String)newValue);
				return;
			case SearchIndexPackage.INDEX_DESCRIPTOR__FIELDS:
				getFields().clear();
				getFields().addAll((Collection<? extends IndexField>)newValue);
				return;
			case SearchIndexPackage.INDEX_DESCRIPTOR__BOOST:
				setBoost((Float)newValue);
				return;
			case SearchIndexPackage.INDEX_DESCRIPTOR__REFERENCED_DESCRIPTORS:
				getReferencedDescriptors().clear();
				getReferencedDescriptors().addAll((Collection<? extends IndexDescriptor>)newValue);
				return;
			case SearchIndexPackage.INDEX_DESCRIPTOR__CLASSES:
				getClasses().clear();
				getClasses().addAll((Collection<? extends EClass>)newValue);
				return;
			case SearchIndexPackage.INDEX_DESCRIPTOR__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case SearchIndexPackage.INDEX_DESCRIPTOR__ACTIVE:
				setActive((Boolean)newValue);
				return;
			case SearchIndexPackage.INDEX_DESCRIPTOR__FACET_CONTEXT:
				setFacetContext((FacetContext)newValue);
				return;
			case SearchIndexPackage.INDEX_DESCRIPTOR__USE_DYNAMIC_PER_FIELD_ANALYIZER:
				setUseDynamicPerFieldAnalyizer((Boolean)newValue);
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
			case SearchIndexPackage.INDEX_DESCRIPTOR__ID:
				setId(ID_EDEFAULT);
				return;
			case SearchIndexPackage.INDEX_DESCRIPTOR__FIELDS:
				getFields().clear();
				return;
			case SearchIndexPackage.INDEX_DESCRIPTOR__BOOST:
				setBoost(BOOST_EDEFAULT);
				return;
			case SearchIndexPackage.INDEX_DESCRIPTOR__REFERENCED_DESCRIPTORS:
				getReferencedDescriptors().clear();
				return;
			case SearchIndexPackage.INDEX_DESCRIPTOR__CLASSES:
				getClasses().clear();
				return;
			case SearchIndexPackage.INDEX_DESCRIPTOR__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case SearchIndexPackage.INDEX_DESCRIPTOR__ACTIVE:
				setActive(ACTIVE_EDEFAULT);
				return;
			case SearchIndexPackage.INDEX_DESCRIPTOR__FACET_CONTEXT:
				setFacetContext((FacetContext)null);
				return;
			case SearchIndexPackage.INDEX_DESCRIPTOR__USE_DYNAMIC_PER_FIELD_ANALYIZER:
				setUseDynamicPerFieldAnalyizer(USE_DYNAMIC_PER_FIELD_ANALYIZER_EDEFAULT);
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
			case SearchIndexPackage.INDEX_DESCRIPTOR__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case SearchIndexPackage.INDEX_DESCRIPTOR__FIELDS:
				return fields != null && !fields.isEmpty();
			case SearchIndexPackage.INDEX_DESCRIPTOR__BOOST:
				return boost != BOOST_EDEFAULT;
			case SearchIndexPackage.INDEX_DESCRIPTOR__REFERENCED_DESCRIPTORS:
				return referencedDescriptors != null && !referencedDescriptors.isEmpty();
			case SearchIndexPackage.INDEX_DESCRIPTOR__CLASSES:
				return classes != null && !classes.isEmpty();
			case SearchIndexPackage.INDEX_DESCRIPTOR__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case SearchIndexPackage.INDEX_DESCRIPTOR__ACTIVE:
				return active != ACTIVE_EDEFAULT;
			case SearchIndexPackage.INDEX_DESCRIPTOR__FACET_CONTEXT:
				return facetContext != null;
			case SearchIndexPackage.INDEX_DESCRIPTOR__USE_DYNAMIC_PER_FIELD_ANALYIZER:
				return useDynamicPerFieldAnalyizer != USE_DYNAMIC_PER_FIELD_ANALYIZER_EDEFAULT;
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
			case SearchIndexPackage.INDEX_DESCRIPTOR___GET_INDEX_FIELD__ESTRUCTURALFEATURE:
				return getIndexField((EStructuralFeature)arguments.get(0));
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
		result.append(", boost: ");
		result.append(boost);
		result.append(", description: ");
		result.append(description);
		result.append(", active: ");
		result.append(active);
		result.append(", useDynamicPerFieldAnalyizer: ");
		result.append(useDynamicPerFieldAnalyizer);
		result.append(')');
		return result.toString();
	}

} //IndexDescriptorImpl
