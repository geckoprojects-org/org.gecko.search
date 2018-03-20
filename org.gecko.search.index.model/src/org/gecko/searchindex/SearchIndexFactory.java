/**
 */
package org.gecko.searchindex;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.gecko.searchindex.SearchIndexPackage
 * @generated
 */
public interface SearchIndexFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SearchIndexFactory eINSTANCE = org.gecko.searchindex.impl.SearchIndexFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Index Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Index Descriptor</em>'.
	 * @generated
	 */
	IndexDescriptor createIndexDescriptor();

	/**
	 * Returns a new object of class '<em>Index Descriptor Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Index Descriptor Container</em>'.
	 * @generated
	 */
	IndexDescriptorContainer createIndexDescriptorContainer();

	/**
	 * Returns a new object of class '<em>Index Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Index Field</em>'.
	 * @generated
	 */
	IndexField createIndexField();

	/**
	 * Returns a new object of class '<em>Index Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Index Object</em>'.
	 * @generated
	 */
	IndexObject createIndexObject();

	/**
	 * Returns a new object of class '<em>Index Field Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Index Field Object</em>'.
	 * @generated
	 */
	IndexFieldObject createIndexFieldObject();

	/**
	 * Returns a new object of class '<em>Spatial Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Spatial Field</em>'.
	 * @generated
	 */
	SpatialField createSpatialField();

	/**
	 * Returns a new object of class '<em>Aggregated Multi Index Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Aggregated Multi Index Field</em>'.
	 * @generated
	 */
	AggregatedMultiIndexField createAggregatedMultiIndexField();

	/**
	 * Returns a new object of class '<em>Facet Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Facet Field</em>'.
	 * @generated
	 */
	FacetField createFacetField();

	/**
	 * Returns a new object of class '<em>Facet Context</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Facet Context</em>'.
	 * @generated
	 */
	FacetContext createFacetContext();

	/**
	 * Returns a new object of class '<em>Facet Field Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Facet Field Object</em>'.
	 * @generated
	 */
	FacetFieldObject createFacetFieldObject();

	/**
	 * Returns a new object of class '<em>Searchable Facet Document Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Searchable Facet Document Object</em>'.
	 * @generated
	 */
	SearchableFacetDocumentObject createSearchableFacetDocumentObject();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SearchIndexPackage getSearchIndexPackage();

} //SearchIndexFactory
