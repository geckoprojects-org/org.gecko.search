/**
 */
package org.gecko.searchindex.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.gecko.searchindex.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.gecko.searchindex.SearchIndexPackage
 * @generated
 */
public class SearchIndexAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SearchIndexPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SearchIndexAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = SearchIndexPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SearchIndexSwitch<Adapter> modelSwitch =
		new SearchIndexSwitch<Adapter>() {
			@Override
			public Adapter caseIndexDescriptor(IndexDescriptor object) {
				return createIndexDescriptorAdapter();
			}
			@Override
			public Adapter caseIndexDescriptorContainer(IndexDescriptorContainer object) {
				return createIndexDescriptorContainerAdapter();
			}
			@Override
			public Adapter caseIndexField(IndexField object) {
				return createIndexFieldAdapter();
			}
			@Override
			public Adapter caseIndexObject(IndexObject object) {
				return createIndexObjectAdapter();
			}
			@Override
			public Adapter caseIndexFieldObject(IndexFieldObject object) {
				return createIndexFieldObjectAdapter();
			}
			@Override
			public Adapter caseSpatialField(SpatialField object) {
				return createSpatialFieldAdapter();
			}
			@Override
			public Adapter caseAggregatedMultiIndexField(AggregatedMultiIndexField object) {
				return createAggregatedMultiIndexFieldAdapter();
			}
			@Override
			public Adapter caseFacetField(FacetField object) {
				return createFacetFieldAdapter();
			}
			@Override
			public Adapter caseFacetContext(FacetContext object) {
				return createFacetContextAdapter();
			}
			@Override
			public Adapter caseFacetFieldObject(FacetFieldObject object) {
				return createFacetFieldObjectAdapter();
			}
			@Override
			public Adapter caseSearchableFacetDocumentObject(SearchableFacetDocumentObject object) {
				return createSearchableFacetDocumentObjectAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.searchindex.IndexDescriptor <em>Index Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.searchindex.IndexDescriptor
	 * @generated
	 */
	public Adapter createIndexDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.searchindex.IndexDescriptorContainer <em>Index Descriptor Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.searchindex.IndexDescriptorContainer
	 * @generated
	 */
	public Adapter createIndexDescriptorContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.searchindex.IndexField <em>Index Field</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.searchindex.IndexField
	 * @generated
	 */
	public Adapter createIndexFieldAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.searchindex.IndexObject <em>Index Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.searchindex.IndexObject
	 * @generated
	 */
	public Adapter createIndexObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.searchindex.IndexFieldObject <em>Index Field Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.searchindex.IndexFieldObject
	 * @generated
	 */
	public Adapter createIndexFieldObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.searchindex.SpatialField <em>Spatial Field</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.searchindex.SpatialField
	 * @generated
	 */
	public Adapter createSpatialFieldAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.searchindex.AggregatedMultiIndexField <em>Aggregated Multi Index Field</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.searchindex.AggregatedMultiIndexField
	 * @generated
	 */
	public Adapter createAggregatedMultiIndexFieldAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.searchindex.FacetField <em>Facet Field</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.searchindex.FacetField
	 * @generated
	 */
	public Adapter createFacetFieldAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.searchindex.FacetContext <em>Facet Context</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.searchindex.FacetContext
	 * @generated
	 */
	public Adapter createFacetContextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.searchindex.FacetFieldObject <em>Facet Field Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.searchindex.FacetFieldObject
	 * @generated
	 */
	public Adapter createFacetFieldObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gecko.searchindex.SearchableFacetDocumentObject <em>Searchable Facet Document Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gecko.searchindex.SearchableFacetDocumentObject
	 * @generated
	 */
	public Adapter createSearchableFacetDocumentObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //SearchIndexAdapterFactory
