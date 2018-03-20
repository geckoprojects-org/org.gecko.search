/**
 */
package org.gecko.searchindex;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Index Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchindex.IndexDescriptor#getId <em>Id</em>}</li>
 *   <li>{@link org.gecko.searchindex.IndexDescriptor#getFields <em>Fields</em>}</li>
 *   <li>{@link org.gecko.searchindex.IndexDescriptor#getBoost <em>Boost</em>}</li>
 *   <li>{@link org.gecko.searchindex.IndexDescriptor#getReferencedDescriptors <em>Referenced Descriptors</em>}</li>
 *   <li>{@link org.gecko.searchindex.IndexDescriptor#getClasses <em>Classes</em>}</li>
 *   <li>{@link org.gecko.searchindex.IndexDescriptor#getDescription <em>Description</em>}</li>
 *   <li>{@link org.gecko.searchindex.IndexDescriptor#isActive <em>Active</em>}</li>
 *   <li>{@link org.gecko.searchindex.IndexDescriptor#getFacetContext <em>Facet Context</em>}</li>
 *   <li>{@link org.gecko.searchindex.IndexDescriptor#isUseDynamicPerFieldAnalyizer <em>Use Dynamic Per Field Analyizer</em>}</li>
 * </ul>
 *
 * @see org.gecko.searchindex.SearchIndexPackage#getIndexDescriptor()
 * @model
 * @generated
 */
public interface IndexDescriptor extends EObject {
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
	 * @see org.gecko.searchindex.SearchIndexPackage#getIndexDescriptor_Id()
	 * @model id="true" required="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.gecko.searchindex.IndexDescriptor#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Fields</b></em>' containment reference list.
	 * The list contents are of type {@link org.gecko.searchindex.IndexField}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fields</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fields</em>' containment reference list.
	 * @see org.gecko.searchindex.SearchIndexPackage#getIndexDescriptor_Fields()
	 * @model containment="true"
	 * @generated
	 */
	EList<IndexField> getFields();

	/**
	 * Returns the value of the '<em><b>Boost</b></em>' attribute.
	 * The default value is <code>"1.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Boost</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Boost</em>' attribute.
	 * @see #setBoost(float)
	 * @see org.gecko.searchindex.SearchIndexPackage#getIndexDescriptor_Boost()
	 * @model default="1.0"
	 * @generated
	 */
	float getBoost();

	/**
	 * Sets the value of the '{@link org.gecko.searchindex.IndexDescriptor#getBoost <em>Boost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Boost</em>' attribute.
	 * @see #getBoost()
	 * @generated
	 */
	void setBoost(float value);

	/**
	 * Returns the value of the '<em><b>Referenced Descriptors</b></em>' reference list.
	 * The list contents are of type {@link org.gecko.searchindex.IndexDescriptor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced Descriptors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Descriptors</em>' reference list.
	 * @see org.gecko.searchindex.SearchIndexPackage#getIndexDescriptor_ReferencedDescriptors()
	 * @model keys="id"
	 * @generated
	 */
	EList<IndexDescriptor> getReferencedDescriptors();

	/**
	 * Returns the value of the '<em><b>Classes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classes</em>' reference list.
	 * @see org.gecko.searchindex.SearchIndexPackage#getIndexDescriptor_Classes()
	 * @model
	 * @generated
	 */
	EList<EClass> getClasses();

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.gecko.searchindex.SearchIndexPackage#getIndexDescriptor_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.gecko.searchindex.IndexDescriptor#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Active</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Active</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Active</em>' attribute.
	 * @see #setActive(boolean)
	 * @see org.gecko.searchindex.SearchIndexPackage#getIndexDescriptor_Active()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isActive();

	/**
	 * Sets the value of the '{@link org.gecko.searchindex.IndexDescriptor#isActive <em>Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Active</em>' attribute.
	 * @see #isActive()
	 * @generated
	 */
	void setActive(boolean value);

	/**
	 * Returns the value of the '<em><b>Facet Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facet Context</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Facet Context</em>' containment reference.
	 * @see #setFacetContext(FacetContext)
	 * @see org.gecko.searchindex.SearchIndexPackage#getIndexDescriptor_FacetContext()
	 * @model containment="true"
	 * @generated
	 */
	FacetContext getFacetContext();

	/**
	 * Sets the value of the '{@link org.gecko.searchindex.IndexDescriptor#getFacetContext <em>Facet Context</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Facet Context</em>' containment reference.
	 * @see #getFacetContext()
	 * @generated
	 */
	void setFacetContext(FacetContext value);

	/**
	 * Returns the value of the '<em><b>Use Dynamic Per Field Analyizer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Dynamic Per Field Analyizer</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Dynamic Per Field Analyizer</em>' attribute.
	 * @see #setUseDynamicPerFieldAnalyizer(boolean)
	 * @see org.gecko.searchindex.SearchIndexPackage#getIndexDescriptor_UseDynamicPerFieldAnalyizer()
	 * @model
	 * @generated
	 */
	boolean isUseDynamicPerFieldAnalyizer();

	/**
	 * Sets the value of the '{@link org.gecko.searchindex.IndexDescriptor#isUseDynamicPerFieldAnalyizer <em>Use Dynamic Per Field Analyizer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Dynamic Per Field Analyizer</em>' attribute.
	 * @see #isUseDynamicPerFieldAnalyizer()
	 * @generated
	 */
	void setUseDynamicPerFieldAnalyizer(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model featureRequired="true"
	 * @generated
	 */
	IndexField getIndexField(EStructuralFeature feature);

} // IndexDescriptor
