/**
 */
package org.gecko.searchindex;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Index Descriptor Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchindex.IndexDescriptorContainer#getDescriptors <em>Descriptors</em>}</li>
 *   <li>{@link org.gecko.searchindex.IndexDescriptorContainer#getActiveDescriptors <em>Active Descriptors</em>}</li>
 * </ul>
 *
 * @see org.gecko.searchindex.SearchIndexPackage#getIndexDescriptorContainer()
 * @model
 * @generated
 */
public interface IndexDescriptorContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Descriptors</b></em>' containment reference list.
	 * The list contents are of type {@link org.gecko.searchindex.IndexDescriptor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Descriptors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Descriptors</em>' containment reference list.
	 * @see org.gecko.searchindex.SearchIndexPackage#getIndexDescriptorContainer_Descriptors()
	 * @model containment="true" keys="id"
	 * @generated
	 */
	EList<IndexDescriptor> getDescriptors();

	/**
	 * Returns the value of the '<em><b>Active Descriptors</b></em>' reference list.
	 * The list contents are of type {@link org.gecko.searchindex.IndexDescriptor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Active Descriptors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Active Descriptors</em>' reference list.
	 * @see org.gecko.searchindex.SearchIndexPackage#getIndexDescriptorContainer_ActiveDescriptors()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<IndexDescriptor> getActiveDescriptors();

} // IndexDescriptorContainer
