/**
 */
package org.gecko.searchindex;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Index Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchindex.IndexObject#getObject <em>Object</em>}</li>
 *   <li>{@link org.gecko.searchindex.IndexObject#getDescriptor <em>Descriptor</em>}</li>
 *   <li>{@link org.gecko.searchindex.IndexObject#getFieldObjects <em>Field Objects</em>}</li>
 *   <li>{@link org.gecko.searchindex.IndexObject#getIdField <em>Id Field</em>}</li>
 *   <li>{@link org.gecko.searchindex.IndexObject#getFacetObjects <em>Facet Objects</em>}</li>
 *   <li>{@link org.gecko.searchindex.IndexObject#getSearchableFacetDocumentObjects <em>Searchable Facet Document Objects</em>}</li>
 * </ul>
 *
 * @see org.gecko.searchindex.SearchIndexPackage#getIndexObject()
 * @model
 * @generated
 */
public interface IndexObject extends EObject {
	/**
	 * Returns the value of the '<em><b>Object</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Object}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object</em>' attribute list.
	 * @see org.gecko.searchindex.SearchIndexPackage#getIndexObject_Object()
	 * @model required="true"
	 * @generated
	 */
	EList<Object> getObject();

	/**
	 * Returns the value of the '<em><b>Descriptor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Descriptor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Descriptor</em>' reference.
	 * @see #setDescriptor(IndexDescriptor)
	 * @see org.gecko.searchindex.SearchIndexPackage#getIndexObject_Descriptor()
	 * @model required="true"
	 * @generated
	 */
	IndexDescriptor getDescriptor();

	/**
	 * Sets the value of the '{@link org.gecko.searchindex.IndexObject#getDescriptor <em>Descriptor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Descriptor</em>' reference.
	 * @see #getDescriptor()
	 * @generated
	 */
	void setDescriptor(IndexDescriptor value);

	/**
	 * Returns the value of the '<em><b>Field Objects</b></em>' containment reference list.
	 * The list contents are of type {@link org.gecko.searchindex.IndexFieldObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Field Objects</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Field Objects</em>' containment reference list.
	 * @see org.gecko.searchindex.SearchIndexPackage#getIndexObject_FieldObjects()
	 * @model containment="true"
	 * @generated
	 */
	EList<IndexFieldObject> getFieldObjects();

	/**
	 * Returns the value of the '<em><b>Id Field</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id Field</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id Field</em>' reference.
	 * @see org.gecko.searchindex.SearchIndexPackage#getIndexObject_IdField()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	IndexFieldObject getIdField();

	/**
	 * Returns the value of the '<em><b>Facet Objects</b></em>' containment reference list.
	 * The list contents are of type {@link org.gecko.searchindex.FacetFieldObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facet Objects</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Facet Objects</em>' containment reference list.
	 * @see org.gecko.searchindex.SearchIndexPackage#getIndexObject_FacetObjects()
	 * @model containment="true"
	 * @generated
	 */
	EList<FacetFieldObject> getFacetObjects();

	/**
	 * Returns the value of the '<em><b>Searchable Facet Document Objects</b></em>' containment reference list.
	 * The list contents are of type {@link org.gecko.searchindex.SearchableFacetDocumentObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Searchable Facet Document Objects</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Searchable Facet Document Objects</em>' containment reference list.
	 * @see org.gecko.searchindex.SearchIndexPackage#getIndexObject_SearchableFacetDocumentObjects()
	 * @model containment="true"
	 * @generated
	 */
	EList<SearchableFacetDocumentObject> getSearchableFacetDocumentObjects();

} // IndexObject
