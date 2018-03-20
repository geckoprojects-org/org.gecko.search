/**
 */
package org.gecko.searchindex.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.gecko.searchindex.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.gecko.searchindex.SearchIndexPackage
 * @generated
 */
public class SearchIndexSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SearchIndexPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SearchIndexSwitch() {
		if (modelPackage == null) {
			modelPackage = SearchIndexPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case SearchIndexPackage.INDEX_DESCRIPTOR: {
				IndexDescriptor indexDescriptor = (IndexDescriptor)theEObject;
				T result = caseIndexDescriptor(indexDescriptor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SearchIndexPackage.INDEX_DESCRIPTOR_CONTAINER: {
				IndexDescriptorContainer indexDescriptorContainer = (IndexDescriptorContainer)theEObject;
				T result = caseIndexDescriptorContainer(indexDescriptorContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SearchIndexPackage.INDEX_FIELD: {
				IndexField indexField = (IndexField)theEObject;
				T result = caseIndexField(indexField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SearchIndexPackage.INDEX_OBJECT: {
				IndexObject indexObject = (IndexObject)theEObject;
				T result = caseIndexObject(indexObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SearchIndexPackage.INDEX_FIELD_OBJECT: {
				IndexFieldObject indexFieldObject = (IndexFieldObject)theEObject;
				T result = caseIndexFieldObject(indexFieldObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SearchIndexPackage.SPATIAL_FIELD: {
				SpatialField spatialField = (SpatialField)theEObject;
				T result = caseSpatialField(spatialField);
				if (result == null) result = caseIndexField(spatialField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SearchIndexPackage.AGGREGATED_MULTI_INDEX_FIELD: {
				AggregatedMultiIndexField aggregatedMultiIndexField = (AggregatedMultiIndexField)theEObject;
				T result = caseAggregatedMultiIndexField(aggregatedMultiIndexField);
				if (result == null) result = caseIndexField(aggregatedMultiIndexField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SearchIndexPackage.FACET_FIELD: {
				FacetField facetField = (FacetField)theEObject;
				T result = caseFacetField(facetField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SearchIndexPackage.FACET_CONTEXT: {
				FacetContext facetContext = (FacetContext)theEObject;
				T result = caseFacetContext(facetContext);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SearchIndexPackage.FACET_FIELD_OBJECT: {
				FacetFieldObject facetFieldObject = (FacetFieldObject)theEObject;
				T result = caseFacetFieldObject(facetFieldObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SearchIndexPackage.SEARCHABLE_FACET_DOCUMENT_OBJECT: {
				SearchableFacetDocumentObject searchableFacetDocumentObject = (SearchableFacetDocumentObject)theEObject;
				T result = caseSearchableFacetDocumentObject(searchableFacetDocumentObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Index Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Index Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIndexDescriptor(IndexDescriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Index Descriptor Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Index Descriptor Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIndexDescriptorContainer(IndexDescriptorContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Index Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Index Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIndexField(IndexField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Index Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Index Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIndexObject(IndexObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Index Field Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Index Field Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIndexFieldObject(IndexFieldObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Spatial Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Spatial Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpatialField(SpatialField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Aggregated Multi Index Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aggregated Multi Index Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAggregatedMultiIndexField(AggregatedMultiIndexField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Facet Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Facet Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFacetField(FacetField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Facet Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Facet Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFacetContext(FacetContext object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Facet Field Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Facet Field Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFacetFieldObject(FacetFieldObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Searchable Facet Document Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Searchable Facet Document Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSearchableFacetDocumentObject(SearchableFacetDocumentObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //SearchIndexSwitch
