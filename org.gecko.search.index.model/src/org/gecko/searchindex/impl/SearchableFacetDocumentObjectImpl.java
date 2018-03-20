/**
 */
package org.gecko.searchindex.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.gecko.searchindex.SearchIndexPackage;
import org.gecko.searchindex.SearchableFacetDocumentObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Searchable Facet Document Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchindex.impl.SearchableFacetDocumentObjectImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.gecko.searchindex.impl.SearchableFacetDocumentObjectImpl#getSystemName <em>System Name</em>}</li>
 *   <li>{@link org.gecko.searchindex.impl.SearchableFacetDocumentObjectImpl#getLanguage <em>Language</em>}</li>
 *   <li>{@link org.gecko.searchindex.impl.SearchableFacetDocumentObjectImpl#getTranslation <em>Translation</em>}</li>
 *   <li>{@link org.gecko.searchindex.impl.SearchableFacetDocumentObjectImpl#getFacet <em>Facet</em>}</li>
 *   <li>{@link org.gecko.searchindex.impl.SearchableFacetDocumentObjectImpl#getTranslationFieldKey <em>Translation Field Key</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SearchableFacetDocumentObjectImpl extends MinimalEObjectImpl.Container implements SearchableFacetDocumentObject {
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
	 * The default value of the '{@link #getSystemName() <em>System Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemName()
	 * @generated
	 * @ordered
	 */
	protected static final String SYSTEM_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSystemName() <em>System Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemName()
	 * @generated
	 * @ordered
	 */
	protected String systemName = SYSTEM_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getLanguage() <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final String LANGUAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLanguage() <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected String language = LANGUAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTranslation() <em>Translation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTranslation()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSLATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTranslation() <em>Translation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTranslation()
	 * @generated
	 * @ordered
	 */
	protected String translation = TRANSLATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getFacet() <em>Facet</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacet()
	 * @generated
	 * @ordered
	 */
	protected static final String FACET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFacet() <em>Facet</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacet()
	 * @generated
	 * @ordered
	 */
	protected String facet = FACET_EDEFAULT;

	/**
	 * The default value of the '{@link #getTranslationFieldKey() <em>Translation Field Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTranslationFieldKey()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSLATION_FIELD_KEY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTranslationFieldKey() <em>Translation Field Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTranslationFieldKey()
	 * @generated
	 * @ordered
	 */
	protected String translationFieldKey = TRANSLATION_FIELD_KEY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SearchableFacetDocumentObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SearchIndexPackage.Literals.SEARCHABLE_FACET_DOCUMENT_OBJECT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SearchIndexPackage.SEARCHABLE_FACET_DOCUMENT_OBJECT__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSystemName() {
		return systemName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystemName(String newSystemName) {
		String oldSystemName = systemName;
		systemName = newSystemName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchIndexPackage.SEARCHABLE_FACET_DOCUMENT_OBJECT__SYSTEM_NAME, oldSystemName, systemName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLanguage(String newLanguage) {
		String oldLanguage = language;
		language = newLanguage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchIndexPackage.SEARCHABLE_FACET_DOCUMENT_OBJECT__LANGUAGE, oldLanguage, language));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTranslation() {
		return translation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTranslation(String newTranslation) {
		String oldTranslation = translation;
		translation = newTranslation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchIndexPackage.SEARCHABLE_FACET_DOCUMENT_OBJECT__TRANSLATION, oldTranslation, translation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFacet() {
		return facet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFacet(String newFacet) {
		String oldFacet = facet;
		facet = newFacet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchIndexPackage.SEARCHABLE_FACET_DOCUMENT_OBJECT__FACET, oldFacet, facet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTranslationFieldKey() {
		return translationFieldKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTranslationFieldKey(String newTranslationFieldKey) {
		String oldTranslationFieldKey = translationFieldKey;
		translationFieldKey = newTranslationFieldKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchIndexPackage.SEARCHABLE_FACET_DOCUMENT_OBJECT__TRANSLATION_FIELD_KEY, oldTranslationFieldKey, translationFieldKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SearchIndexPackage.SEARCHABLE_FACET_DOCUMENT_OBJECT__ID:
				return getId();
			case SearchIndexPackage.SEARCHABLE_FACET_DOCUMENT_OBJECT__SYSTEM_NAME:
				return getSystemName();
			case SearchIndexPackage.SEARCHABLE_FACET_DOCUMENT_OBJECT__LANGUAGE:
				return getLanguage();
			case SearchIndexPackage.SEARCHABLE_FACET_DOCUMENT_OBJECT__TRANSLATION:
				return getTranslation();
			case SearchIndexPackage.SEARCHABLE_FACET_DOCUMENT_OBJECT__FACET:
				return getFacet();
			case SearchIndexPackage.SEARCHABLE_FACET_DOCUMENT_OBJECT__TRANSLATION_FIELD_KEY:
				return getTranslationFieldKey();
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
			case SearchIndexPackage.SEARCHABLE_FACET_DOCUMENT_OBJECT__ID:
				setId((String)newValue);
				return;
			case SearchIndexPackage.SEARCHABLE_FACET_DOCUMENT_OBJECT__SYSTEM_NAME:
				setSystemName((String)newValue);
				return;
			case SearchIndexPackage.SEARCHABLE_FACET_DOCUMENT_OBJECT__LANGUAGE:
				setLanguage((String)newValue);
				return;
			case SearchIndexPackage.SEARCHABLE_FACET_DOCUMENT_OBJECT__TRANSLATION:
				setTranslation((String)newValue);
				return;
			case SearchIndexPackage.SEARCHABLE_FACET_DOCUMENT_OBJECT__FACET:
				setFacet((String)newValue);
				return;
			case SearchIndexPackage.SEARCHABLE_FACET_DOCUMENT_OBJECT__TRANSLATION_FIELD_KEY:
				setTranslationFieldKey((String)newValue);
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
			case SearchIndexPackage.SEARCHABLE_FACET_DOCUMENT_OBJECT__ID:
				setId(ID_EDEFAULT);
				return;
			case SearchIndexPackage.SEARCHABLE_FACET_DOCUMENT_OBJECT__SYSTEM_NAME:
				setSystemName(SYSTEM_NAME_EDEFAULT);
				return;
			case SearchIndexPackage.SEARCHABLE_FACET_DOCUMENT_OBJECT__LANGUAGE:
				setLanguage(LANGUAGE_EDEFAULT);
				return;
			case SearchIndexPackage.SEARCHABLE_FACET_DOCUMENT_OBJECT__TRANSLATION:
				setTranslation(TRANSLATION_EDEFAULT);
				return;
			case SearchIndexPackage.SEARCHABLE_FACET_DOCUMENT_OBJECT__FACET:
				setFacet(FACET_EDEFAULT);
				return;
			case SearchIndexPackage.SEARCHABLE_FACET_DOCUMENT_OBJECT__TRANSLATION_FIELD_KEY:
				setTranslationFieldKey(TRANSLATION_FIELD_KEY_EDEFAULT);
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
			case SearchIndexPackage.SEARCHABLE_FACET_DOCUMENT_OBJECT__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case SearchIndexPackage.SEARCHABLE_FACET_DOCUMENT_OBJECT__SYSTEM_NAME:
				return SYSTEM_NAME_EDEFAULT == null ? systemName != null : !SYSTEM_NAME_EDEFAULT.equals(systemName);
			case SearchIndexPackage.SEARCHABLE_FACET_DOCUMENT_OBJECT__LANGUAGE:
				return LANGUAGE_EDEFAULT == null ? language != null : !LANGUAGE_EDEFAULT.equals(language);
			case SearchIndexPackage.SEARCHABLE_FACET_DOCUMENT_OBJECT__TRANSLATION:
				return TRANSLATION_EDEFAULT == null ? translation != null : !TRANSLATION_EDEFAULT.equals(translation);
			case SearchIndexPackage.SEARCHABLE_FACET_DOCUMENT_OBJECT__FACET:
				return FACET_EDEFAULT == null ? facet != null : !FACET_EDEFAULT.equals(facet);
			case SearchIndexPackage.SEARCHABLE_FACET_DOCUMENT_OBJECT__TRANSLATION_FIELD_KEY:
				return TRANSLATION_FIELD_KEY_EDEFAULT == null ? translationFieldKey != null : !TRANSLATION_FIELD_KEY_EDEFAULT.equals(translationFieldKey);
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
		result.append(", systemName: ");
		result.append(systemName);
		result.append(", language: ");
		result.append(language);
		result.append(", translation: ");
		result.append(translation);
		result.append(", facet: ");
		result.append(facet);
		result.append(", translationFieldKey: ");
		result.append(translationFieldKey);
		result.append(')');
		return result.toString();
	}

} //SearchableFacetDocumentObjectImpl
