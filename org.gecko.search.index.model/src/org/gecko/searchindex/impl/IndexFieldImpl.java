/**
 */
package org.gecko.searchindex.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.gecko.emf.utilities.Converter;
import org.gecko.emf.utilities.FeaturePath;

import org.gecko.searchindex.IndexField;
import org.gecko.searchindex.IndexFieldType;
import org.gecko.searchindex.IndexType;
import org.gecko.searchindex.SearchIndexPackage;
import org.gecko.searchindex.StoreType;
import org.gecko.searchindex.TermVectorType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Index Field</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchindex.impl.IndexFieldImpl#getTermVector <em>Term Vector</em>}</li>
 *   <li>{@link org.gecko.searchindex.impl.IndexFieldImpl#getStore <em>Store</em>}</li>
 *   <li>{@link org.gecko.searchindex.impl.IndexFieldImpl#getBoost <em>Boost</em>}</li>
 *   <li>{@link org.gecko.searchindex.impl.IndexFieldImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.gecko.searchindex.impl.IndexFieldImpl#getKey <em>Key</em>}</li>
 *   <li>{@link org.gecko.searchindex.impl.IndexFieldImpl#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.gecko.searchindex.impl.IndexFieldImpl#getConverter <em>Converter</em>}</li>
 *   <li>{@link org.gecko.searchindex.impl.IndexFieldImpl#isOmitNorms <em>Omit Norms</em>}</li>
 *   <li>{@link org.gecko.searchindex.impl.IndexFieldImpl#isIdField <em>Id Field</em>}</li>
 *   <li>{@link org.gecko.searchindex.impl.IndexFieldImpl#getIndex <em>Index</em>}</li>
 *   <li>{@link org.gecko.searchindex.impl.IndexFieldImpl#isPkField <em>Pk Field</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IndexFieldImpl extends MinimalEObjectImpl.Container implements IndexField {
	/**
	 * The default value of the '{@link #getTermVector() <em>Term Vector</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTermVector()
	 * @generated
	 * @ordered
	 */
	protected static final TermVectorType TERM_VECTOR_EDEFAULT = TermVectorType.YES;

	/**
	 * The cached value of the '{@link #getTermVector() <em>Term Vector</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTermVector()
	 * @generated
	 * @ordered
	 */
	protected TermVectorType termVector = TERM_VECTOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getStore() <em>Store</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStore()
	 * @generated
	 * @ordered
	 */
	protected static final StoreType STORE_EDEFAULT = StoreType.NO;

	/**
	 * The cached value of the '{@link #getStore() <em>Store</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStore()
	 * @generated
	 * @ordered
	 */
	protected StoreType store = STORE_EDEFAULT;

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
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final IndexFieldType TYPE_EDEFAULT = IndexFieldType.STRING;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected IndexFieldType type = TYPE_EDEFAULT;

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
	 * The cached value of the '{@link #getConverter() <em>Converter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConverter()
	 * @generated
	 * @ordered
	 */
	protected Converter converter;

	/**
	 * The default value of the '{@link #isOmitNorms() <em>Omit Norms</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOmitNorms()
	 * @generated
	 * @ordered
	 */
	protected static final boolean OMIT_NORMS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isOmitNorms() <em>Omit Norms</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOmitNorms()
	 * @generated
	 * @ordered
	 */
	protected boolean omitNorms = OMIT_NORMS_EDEFAULT;

	/**
	 * The default value of the '{@link #isIdField() <em>Id Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIdField()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ID_FIELD_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIdField() <em>Id Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIdField()
	 * @generated
	 * @ordered
	 */
	protected boolean idField = ID_FIELD_EDEFAULT;

	/**
	 * The default value of the '{@link #getIndex() <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected static final IndexType INDEX_EDEFAULT = IndexType.ANALYZED;

	/**
	 * The cached value of the '{@link #getIndex() <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected IndexType index = INDEX_EDEFAULT;

	/**
	 * The default value of the '{@link #isPkField() <em>Pk Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPkField()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PK_FIELD_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPkField() <em>Pk Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPkField()
	 * @generated
	 * @ordered
	 */
	protected boolean pkField = PK_FIELD_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IndexFieldImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SearchIndexPackage.Literals.INDEX_FIELD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TermVectorType getTermVector() {
		return termVector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTermVector(TermVectorType newTermVector) {
		TermVectorType oldTermVector = termVector;
		termVector = newTermVector == null ? TERM_VECTOR_EDEFAULT : newTermVector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchIndexPackage.INDEX_FIELD__TERM_VECTOR, oldTermVector, termVector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StoreType getStore() {
		return store;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStore(StoreType newStore) {
		StoreType oldStore = store;
		store = newStore == null ? STORE_EDEFAULT : newStore;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchIndexPackage.INDEX_FIELD__STORE, oldStore, store));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SearchIndexPackage.INDEX_FIELD__BOOST, oldBoost, boost));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndexFieldType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(IndexFieldType newType) {
		IndexFieldType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchIndexPackage.INDEX_FIELD__TYPE, oldType, type));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SearchIndexPackage.INDEX_FIELD__KEY, oldKey, key));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SearchIndexPackage.INDEX_FIELD__FEATURE, oldFeature, newFeature);
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
				msgs = ((InternalEObject)feature).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SearchIndexPackage.INDEX_FIELD__FEATURE, null, msgs);
			if (newFeature != null)
				msgs = ((InternalEObject)newFeature).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SearchIndexPackage.INDEX_FIELD__FEATURE, null, msgs);
			msgs = basicSetFeature(newFeature, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchIndexPackage.INDEX_FIELD__FEATURE, newFeature, newFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Converter getConverter() {
		return converter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConverter(Converter newConverter, NotificationChain msgs) {
		Converter oldConverter = converter;
		converter = newConverter;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SearchIndexPackage.INDEX_FIELD__CONVERTER, oldConverter, newConverter);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConverter(Converter newConverter) {
		if (newConverter != converter) {
			NotificationChain msgs = null;
			if (converter != null)
				msgs = ((InternalEObject)converter).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SearchIndexPackage.INDEX_FIELD__CONVERTER, null, msgs);
			if (newConverter != null)
				msgs = ((InternalEObject)newConverter).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SearchIndexPackage.INDEX_FIELD__CONVERTER, null, msgs);
			msgs = basicSetConverter(newConverter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchIndexPackage.INDEX_FIELD__CONVERTER, newConverter, newConverter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOmitNorms() {
		return omitNorms;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOmitNorms(boolean newOmitNorms) {
		boolean oldOmitNorms = omitNorms;
		omitNorms = newOmitNorms;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchIndexPackage.INDEX_FIELD__OMIT_NORMS, oldOmitNorms, omitNorms));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIdField() {
		return idField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdField(boolean newIdField) {
		boolean oldIdField = idField;
		idField = newIdField;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchIndexPackage.INDEX_FIELD__ID_FIELD, oldIdField, idField));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndexType getIndex() {
		return index;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndex(IndexType newIndex) {
		IndexType oldIndex = index;
		index = newIndex == null ? INDEX_EDEFAULT : newIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchIndexPackage.INDEX_FIELD__INDEX, oldIndex, index));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPkField() {
		return pkField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPkField(boolean newPkField) {
		boolean oldPkField = pkField;
		pkField = newPkField;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchIndexPackage.INDEX_FIELD__PK_FIELD, oldPkField, pkField));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SearchIndexPackage.INDEX_FIELD__FEATURE:
				return basicSetFeature(null, msgs);
			case SearchIndexPackage.INDEX_FIELD__CONVERTER:
				return basicSetConverter(null, msgs);
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
			case SearchIndexPackage.INDEX_FIELD__TERM_VECTOR:
				return getTermVector();
			case SearchIndexPackage.INDEX_FIELD__STORE:
				return getStore();
			case SearchIndexPackage.INDEX_FIELD__BOOST:
				return getBoost();
			case SearchIndexPackage.INDEX_FIELD__TYPE:
				return getType();
			case SearchIndexPackage.INDEX_FIELD__KEY:
				return getKey();
			case SearchIndexPackage.INDEX_FIELD__FEATURE:
				return getFeature();
			case SearchIndexPackage.INDEX_FIELD__CONVERTER:
				return getConverter();
			case SearchIndexPackage.INDEX_FIELD__OMIT_NORMS:
				return isOmitNorms();
			case SearchIndexPackage.INDEX_FIELD__ID_FIELD:
				return isIdField();
			case SearchIndexPackage.INDEX_FIELD__INDEX:
				return getIndex();
			case SearchIndexPackage.INDEX_FIELD__PK_FIELD:
				return isPkField();
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
			case SearchIndexPackage.INDEX_FIELD__TERM_VECTOR:
				setTermVector((TermVectorType)newValue);
				return;
			case SearchIndexPackage.INDEX_FIELD__STORE:
				setStore((StoreType)newValue);
				return;
			case SearchIndexPackage.INDEX_FIELD__BOOST:
				setBoost((Float)newValue);
				return;
			case SearchIndexPackage.INDEX_FIELD__TYPE:
				setType((IndexFieldType)newValue);
				return;
			case SearchIndexPackage.INDEX_FIELD__KEY:
				setKey((String)newValue);
				return;
			case SearchIndexPackage.INDEX_FIELD__FEATURE:
				setFeature((FeaturePath)newValue);
				return;
			case SearchIndexPackage.INDEX_FIELD__CONVERTER:
				setConverter((Converter)newValue);
				return;
			case SearchIndexPackage.INDEX_FIELD__OMIT_NORMS:
				setOmitNorms((Boolean)newValue);
				return;
			case SearchIndexPackage.INDEX_FIELD__ID_FIELD:
				setIdField((Boolean)newValue);
				return;
			case SearchIndexPackage.INDEX_FIELD__INDEX:
				setIndex((IndexType)newValue);
				return;
			case SearchIndexPackage.INDEX_FIELD__PK_FIELD:
				setPkField((Boolean)newValue);
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
			case SearchIndexPackage.INDEX_FIELD__TERM_VECTOR:
				setTermVector(TERM_VECTOR_EDEFAULT);
				return;
			case SearchIndexPackage.INDEX_FIELD__STORE:
				setStore(STORE_EDEFAULT);
				return;
			case SearchIndexPackage.INDEX_FIELD__BOOST:
				setBoost(BOOST_EDEFAULT);
				return;
			case SearchIndexPackage.INDEX_FIELD__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case SearchIndexPackage.INDEX_FIELD__KEY:
				setKey(KEY_EDEFAULT);
				return;
			case SearchIndexPackage.INDEX_FIELD__FEATURE:
				setFeature((FeaturePath)null);
				return;
			case SearchIndexPackage.INDEX_FIELD__CONVERTER:
				setConverter((Converter)null);
				return;
			case SearchIndexPackage.INDEX_FIELD__OMIT_NORMS:
				setOmitNorms(OMIT_NORMS_EDEFAULT);
				return;
			case SearchIndexPackage.INDEX_FIELD__ID_FIELD:
				setIdField(ID_FIELD_EDEFAULT);
				return;
			case SearchIndexPackage.INDEX_FIELD__INDEX:
				setIndex(INDEX_EDEFAULT);
				return;
			case SearchIndexPackage.INDEX_FIELD__PK_FIELD:
				setPkField(PK_FIELD_EDEFAULT);
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
			case SearchIndexPackage.INDEX_FIELD__TERM_VECTOR:
				return termVector != TERM_VECTOR_EDEFAULT;
			case SearchIndexPackage.INDEX_FIELD__STORE:
				return store != STORE_EDEFAULT;
			case SearchIndexPackage.INDEX_FIELD__BOOST:
				return boost != BOOST_EDEFAULT;
			case SearchIndexPackage.INDEX_FIELD__TYPE:
				return type != TYPE_EDEFAULT;
			case SearchIndexPackage.INDEX_FIELD__KEY:
				return KEY_EDEFAULT == null ? key != null : !KEY_EDEFAULT.equals(key);
			case SearchIndexPackage.INDEX_FIELD__FEATURE:
				return feature != null;
			case SearchIndexPackage.INDEX_FIELD__CONVERTER:
				return converter != null;
			case SearchIndexPackage.INDEX_FIELD__OMIT_NORMS:
				return omitNorms != OMIT_NORMS_EDEFAULT;
			case SearchIndexPackage.INDEX_FIELD__ID_FIELD:
				return idField != ID_FIELD_EDEFAULT;
			case SearchIndexPackage.INDEX_FIELD__INDEX:
				return index != INDEX_EDEFAULT;
			case SearchIndexPackage.INDEX_FIELD__PK_FIELD:
				return pkField != PK_FIELD_EDEFAULT;
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
		result.append(" (termVector: ");
		result.append(termVector);
		result.append(", store: ");
		result.append(store);
		result.append(", boost: ");
		result.append(boost);
		result.append(", type: ");
		result.append(type);
		result.append(", key: ");
		result.append(key);
		result.append(", omitNorms: ");
		result.append(omitNorms);
		result.append(", idField: ");
		result.append(idField);
		result.append(", index: ");
		result.append(index);
		result.append(", pkField: ");
		result.append(pkField);
		result.append(')');
		return result.toString();
	}

} //IndexFieldImpl
