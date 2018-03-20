/**
 */
package org.gecko.searchindex;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Index Field Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchindex.IndexFieldObject#getValue <em>Value</em>}</li>
 *   <li>{@link org.gecko.searchindex.IndexFieldObject#getField <em>Field</em>}</li>
 * </ul>
 *
 * @see org.gecko.searchindex.SearchIndexPackage#getIndexFieldObject()
 * @model
 * @generated
 */
public interface IndexFieldObject extends EObject {
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
	 * @see org.gecko.searchindex.SearchIndexPackage#getIndexFieldObject_Value()
	 * @model
	 * @generated
	 */
	Object getValue();

	/**
	 * Sets the value of the '{@link org.gecko.searchindex.IndexFieldObject#getValue <em>Value</em>}' attribute.
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
	 * @see #setField(IndexField)
	 * @see org.gecko.searchindex.SearchIndexPackage#getIndexFieldObject_Field()
	 * @model required="true"
	 * @generated
	 */
	IndexField getField();

	/**
	 * Sets the value of the '{@link org.gecko.searchindex.IndexFieldObject#getField <em>Field</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Field</em>' reference.
	 * @see #getField()
	 * @generated
	 */
	void setField(IndexField value);

} // IndexFieldObject
