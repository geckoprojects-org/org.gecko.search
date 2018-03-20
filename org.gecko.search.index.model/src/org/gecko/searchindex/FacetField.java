/**
 */
package org.gecko.searchindex;

import org.eclipse.emf.ecore.EObject;

import org.gecko.emf.utilities.FeaturePath;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Facet Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchindex.FacetField#getKey <em>Key</em>}</li>
 *   <li>{@link org.gecko.searchindex.FacetField#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.gecko.searchindex.FacetField#isMultiValued <em>Multi Valued</em>}</li>
 *   <li>{@link org.gecko.searchindex.FacetField#isHirachical <em>Hirachical</em>}</li>
 *   <li>{@link org.gecko.searchindex.FacetField#isRequireCount <em>Require Count</em>}</li>
 *   <li>{@link org.gecko.searchindex.FacetField#getReferencedIndexField <em>Referenced Index Field</em>}</li>
 *   <li>{@link org.gecko.searchindex.FacetField#getFacetContext <em>Facet Context</em>}</li>
 * </ul>
 *
 * @see org.gecko.searchindex.SearchIndexPackage#getFacetField()
 * @model
 * @generated
 */
public interface FacetField extends EObject {
	/**
	 * Returns the value of the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key</em>' attribute.
	 * @see #setKey(String)
	 * @see org.gecko.searchindex.SearchIndexPackage#getFacetField_Key()
	 * @model unique="false"
	 * @generated
	 */
	String getKey();

	/**
	 * Sets the value of the '{@link org.gecko.searchindex.FacetField#getKey <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key</em>' attribute.
	 * @see #getKey()
	 * @generated
	 */
	void setKey(String value);

	/**
	 * Returns the value of the '<em><b>Feature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature</em>' containment reference.
	 * @see #setFeature(FeaturePath)
	 * @see org.gecko.searchindex.SearchIndexPackage#getFacetField_Feature()
	 * @model containment="true" required="true"
	 * @generated
	 */
	FeaturePath getFeature();

	/**
	 * Sets the value of the '{@link org.gecko.searchindex.FacetField#getFeature <em>Feature</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature</em>' containment reference.
	 * @see #getFeature()
	 * @generated
	 */
	void setFeature(FeaturePath value);

	/**
	 * Returns the value of the '<em><b>Multi Valued</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multi Valued</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multi Valued</em>' attribute.
	 * @see #setMultiValued(boolean)
	 * @see org.gecko.searchindex.SearchIndexPackage#getFacetField_MultiValued()
	 * @model
	 * @generated
	 */
	boolean isMultiValued();

	/**
	 * Sets the value of the '{@link org.gecko.searchindex.FacetField#isMultiValued <em>Multi Valued</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multi Valued</em>' attribute.
	 * @see #isMultiValued()
	 * @generated
	 */
	void setMultiValued(boolean value);

	/**
	 * Returns the value of the '<em><b>Hirachical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hirachical</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hirachical</em>' attribute.
	 * @see #setHirachical(boolean)
	 * @see org.gecko.searchindex.SearchIndexPackage#getFacetField_Hirachical()
	 * @model
	 * @generated
	 */
	boolean isHirachical();

	/**
	 * Sets the value of the '{@link org.gecko.searchindex.FacetField#isHirachical <em>Hirachical</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hirachical</em>' attribute.
	 * @see #isHirachical()
	 * @generated
	 */
	void setHirachical(boolean value);

	/**
	 * Returns the value of the '<em><b>Require Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Require Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Require Count</em>' attribute.
	 * @see #setRequireCount(boolean)
	 * @see org.gecko.searchindex.SearchIndexPackage#getFacetField_RequireCount()
	 * @model
	 * @generated
	 */
	boolean isRequireCount();

	/**
	 * Sets the value of the '{@link org.gecko.searchindex.FacetField#isRequireCount <em>Require Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Require Count</em>' attribute.
	 * @see #isRequireCount()
	 * @generated
	 */
	void setRequireCount(boolean value);

	/**
	 * Returns the value of the '<em><b>Referenced Index Field</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced Index Field</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Index Field</em>' reference.
	 * @see #setReferencedIndexField(IndexField)
	 * @see org.gecko.searchindex.SearchIndexPackage#getFacetField_ReferencedIndexField()
	 * @model
	 * @generated
	 */
	IndexField getReferencedIndexField();

	/**
	 * Sets the value of the '{@link org.gecko.searchindex.FacetField#getReferencedIndexField <em>Referenced Index Field</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referenced Index Field</em>' reference.
	 * @see #getReferencedIndexField()
	 * @generated
	 */
	void setReferencedIndexField(IndexField value);

	/**
	 * Returns the value of the '<em><b>Facet Context</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.gecko.searchindex.FacetContext#getFacetFields <em>Facet Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facet Context</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Facet Context</em>' container reference.
	 * @see #setFacetContext(FacetContext)
	 * @see org.gecko.searchindex.SearchIndexPackage#getFacetField_FacetContext()
	 * @see org.gecko.searchindex.FacetContext#getFacetFields
	 * @model opposite="facetFields" transient="false"
	 * @generated
	 */
	FacetContext getFacetContext();

	/**
	 * Sets the value of the '{@link org.gecko.searchindex.FacetField#getFacetContext <em>Facet Context</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Facet Context</em>' container reference.
	 * @see #getFacetContext()
	 * @generated
	 */
	void setFacetContext(FacetContext value);

} // FacetField
