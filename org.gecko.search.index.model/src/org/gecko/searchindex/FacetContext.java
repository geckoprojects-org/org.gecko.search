/**
 */
package org.gecko.searchindex;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Facet Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchindex.FacetContext#getFacetWriter <em>Facet Writer</em>}</li>
 *   <li>{@link org.gecko.searchindex.FacetContext#getFacetFields <em>Facet Fields</em>}</li>
 * </ul>
 *
 * @see org.gecko.searchindex.SearchIndexPackage#getFacetContext()
 * @model
 * @generated
 */
public interface FacetContext extends EObject {
	/**
	 * Returns the value of the '<em><b>Facet Writer</b></em>' attribute.
	 * The literals are from the enumeration {@link org.gecko.searchindex.FacetIndexWriterType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facet Writer</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Facet Writer</em>' attribute.
	 * @see org.gecko.searchindex.FacetIndexWriterType
	 * @see #setFacetWriter(FacetIndexWriterType)
	 * @see org.gecko.searchindex.SearchIndexPackage#getFacetContext_FacetWriter()
	 * @model
	 * @generated
	 */
	FacetIndexWriterType getFacetWriter();

	/**
	 * Sets the value of the '{@link org.gecko.searchindex.FacetContext#getFacetWriter <em>Facet Writer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Facet Writer</em>' attribute.
	 * @see org.gecko.searchindex.FacetIndexWriterType
	 * @see #getFacetWriter()
	 * @generated
	 */
	void setFacetWriter(FacetIndexWriterType value);

	/**
	 * Returns the value of the '<em><b>Facet Fields</b></em>' containment reference list.
	 * The list contents are of type {@link org.gecko.searchindex.FacetField}.
	 * It is bidirectional and its opposite is '{@link org.gecko.searchindex.FacetField#getFacetContext <em>Facet Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facet Fields</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Facet Fields</em>' containment reference list.
	 * @see org.gecko.searchindex.SearchIndexPackage#getFacetContext_FacetFields()
	 * @see org.gecko.searchindex.FacetField#getFacetContext
	 * @model opposite="facetContext" containment="true"
	 * @generated
	 */
	EList<FacetField> getFacetFields();

} // FacetContext
