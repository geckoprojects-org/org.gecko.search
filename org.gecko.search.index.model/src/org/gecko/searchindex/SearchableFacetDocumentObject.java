/**
 */
package org.gecko.searchindex;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Searchable Facet Document Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchindex.SearchableFacetDocumentObject#getId <em>Id</em>}</li>
 *   <li>{@link org.gecko.searchindex.SearchableFacetDocumentObject#getSystemName <em>System Name</em>}</li>
 *   <li>{@link org.gecko.searchindex.SearchableFacetDocumentObject#getLanguage <em>Language</em>}</li>
 *   <li>{@link org.gecko.searchindex.SearchableFacetDocumentObject#getTranslation <em>Translation</em>}</li>
 *   <li>{@link org.gecko.searchindex.SearchableFacetDocumentObject#getFacet <em>Facet</em>}</li>
 *   <li>{@link org.gecko.searchindex.SearchableFacetDocumentObject#getTranslationFieldKey <em>Translation Field Key</em>}</li>
 * </ul>
 *
 * @see org.gecko.searchindex.SearchIndexPackage#getSearchableFacetDocumentObject()
 * @model
 * @generated
 */
public interface SearchableFacetDocumentObject extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.gecko.searchindex.SearchIndexPackage#getSearchableFacetDocumentObject_Id()
	 * @model id="true" required="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.gecko.searchindex.SearchableFacetDocumentObject#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>System Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System Name</em>' attribute.
	 * @see #setSystemName(String)
	 * @see org.gecko.searchindex.SearchIndexPackage#getSearchableFacetDocumentObject_SystemName()
	 * @model required="true"
	 * @generated
	 */
	String getSystemName();

	/**
	 * Sets the value of the '{@link org.gecko.searchindex.SearchableFacetDocumentObject#getSystemName <em>System Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System Name</em>' attribute.
	 * @see #getSystemName()
	 * @generated
	 */
	void setSystemName(String value);

	/**
	 * Returns the value of the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Language</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Language</em>' attribute.
	 * @see #setLanguage(String)
	 * @see org.gecko.searchindex.SearchIndexPackage#getSearchableFacetDocumentObject_Language()
	 * @model
	 * @generated
	 */
	String getLanguage();

	/**
	 * Sets the value of the '{@link org.gecko.searchindex.SearchableFacetDocumentObject#getLanguage <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Language</em>' attribute.
	 * @see #getLanguage()
	 * @generated
	 */
	void setLanguage(String value);

	/**
	 * Returns the value of the '<em><b>Translation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Translation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Translation</em>' attribute.
	 * @see #setTranslation(String)
	 * @see org.gecko.searchindex.SearchIndexPackage#getSearchableFacetDocumentObject_Translation()
	 * @model required="true"
	 * @generated
	 */
	String getTranslation();

	/**
	 * Sets the value of the '{@link org.gecko.searchindex.SearchableFacetDocumentObject#getTranslation <em>Translation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Translation</em>' attribute.
	 * @see #getTranslation()
	 * @generated
	 */
	void setTranslation(String value);

	/**
	 * Returns the value of the '<em><b>Facet</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facet</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Facet</em>' attribute.
	 * @see #setFacet(String)
	 * @see org.gecko.searchindex.SearchIndexPackage#getSearchableFacetDocumentObject_Facet()
	 * @model required="true"
	 * @generated
	 */
	String getFacet();

	/**
	 * Sets the value of the '{@link org.gecko.searchindex.SearchableFacetDocumentObject#getFacet <em>Facet</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Facet</em>' attribute.
	 * @see #getFacet()
	 * @generated
	 */
	void setFacet(String value);

	/**
	 * Returns the value of the '<em><b>Translation Field Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Translation Field Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Translation Field Key</em>' attribute.
	 * @see #setTranslationFieldKey(String)
	 * @see org.gecko.searchindex.SearchIndexPackage#getSearchableFacetDocumentObject_TranslationFieldKey()
	 * @model
	 * @generated
	 */
	String getTranslationFieldKey();

	/**
	 * Sets the value of the '{@link org.gecko.searchindex.SearchableFacetDocumentObject#getTranslationFieldKey <em>Translation Field Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Translation Field Key</em>' attribute.
	 * @see #getTranslationFieldKey()
	 * @generated
	 */
	void setTranslationFieldKey(String value);

} // SearchableFacetDocumentObject
