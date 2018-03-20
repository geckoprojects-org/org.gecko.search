/**
 */
package org.gecko.searchindex;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Facet Field Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchindex.FacetFieldObject#getValue <em>Value</em>}</li>
 *   <li>{@link org.gecko.searchindex.FacetFieldObject#getField <em>Field</em>}</li>
 * </ul>
 *
 * @see org.gecko.searchindex.SearchIndexPackage#getFacetFieldObject()
 * @model
 * @generated
 */
public interface FacetFieldObject extends EObject {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(Object)
	 * @see org.gecko.searchindex.SearchIndexPackage#getFacetFieldObject_Value()
	 * @model
	 * @generated
	 */
	Object getValue();

	/**
	 * Sets the value of the '{@link org.gecko.searchindex.FacetFieldObject#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Object value);

	/**
	 * Returns the value of the '<em><b>Field</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Field</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Field</em>' reference.
	 * @see #setField(FacetField)
	 * @see org.gecko.searchindex.SearchIndexPackage#getFacetFieldObject_Field()
	 * @model required="true"
	 * @generated
	 */
	FacetField getField();

	/**
	 * Sets the value of the '{@link org.gecko.searchindex.FacetFieldObject#getField <em>Field</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Field</em>' reference.
	 * @see #getField()
	 * @generated
	 */
	void setField(FacetField value);

} // FacetFieldObject
