/**
 */
package org.gecko.searchindex.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.gecko.searchindex.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SearchIndexFactoryImpl extends EFactoryImpl implements SearchIndexFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SearchIndexFactory init() {
		try {
			SearchIndexFactory theSearchIndexFactory = (SearchIndexFactory)EPackage.Registry.INSTANCE.getEFactory(SearchIndexPackage.eNS_URI);
			if (theSearchIndexFactory != null) {
				return theSearchIndexFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SearchIndexFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SearchIndexFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SearchIndexPackage.INDEX_DESCRIPTOR: return createIndexDescriptor();
			case SearchIndexPackage.INDEX_DESCRIPTOR_CONTAINER: return createIndexDescriptorContainer();
			case SearchIndexPackage.INDEX_FIELD: return createIndexField();
			case SearchIndexPackage.INDEX_OBJECT: return createIndexObject();
			case SearchIndexPackage.INDEX_FIELD_OBJECT: return createIndexFieldObject();
			case SearchIndexPackage.SPATIAL_FIELD: return createSpatialField();
			case SearchIndexPackage.AGGREGATED_MULTI_INDEX_FIELD: return createAggregatedMultiIndexField();
			case SearchIndexPackage.FACET_FIELD: return createFacetField();
			case SearchIndexPackage.FACET_CONTEXT: return createFacetContext();
			case SearchIndexPackage.FACET_FIELD_OBJECT: return createFacetFieldObject();
			case SearchIndexPackage.SEARCHABLE_FACET_DOCUMENT_OBJECT: return createSearchableFacetDocumentObject();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case SearchIndexPackage.STORE_TYPE:
				return createStoreTypeFromString(eDataType, initialValue);
			case SearchIndexPackage.TERM_VECTOR_TYPE:
				return createTermVectorTypeFromString(eDataType, initialValue);
			case SearchIndexPackage.INDEX_TYPE:
				return createIndexTypeFromString(eDataType, initialValue);
			case SearchIndexPackage.INDEX_FIELD_TYPE:
				return createIndexFieldTypeFromString(eDataType, initialValue);
			case SearchIndexPackage.FACET_INDEX_WRITER_TYPE:
				return createFacetIndexWriterTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case SearchIndexPackage.STORE_TYPE:
				return convertStoreTypeToString(eDataType, instanceValue);
			case SearchIndexPackage.TERM_VECTOR_TYPE:
				return convertTermVectorTypeToString(eDataType, instanceValue);
			case SearchIndexPackage.INDEX_TYPE:
				return convertIndexTypeToString(eDataType, instanceValue);
			case SearchIndexPackage.INDEX_FIELD_TYPE:
				return convertIndexFieldTypeToString(eDataType, instanceValue);
			case SearchIndexPackage.FACET_INDEX_WRITER_TYPE:
				return convertFacetIndexWriterTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndexDescriptor createIndexDescriptor() {
		IndexDescriptorImpl indexDescriptor = new IndexDescriptorImpl();
		return indexDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndexDescriptorContainer createIndexDescriptorContainer() {
		IndexDescriptorContainerImpl indexDescriptorContainer = new IndexDescriptorContainerImpl();
		return indexDescriptorContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndexField createIndexField() {
		IndexFieldImpl indexField = new IndexFieldImpl();
		return indexField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndexObject createIndexObject() {
		IndexObjectImpl indexObject = new IndexObjectImpl();
		return indexObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndexFieldObject createIndexFieldObject() {
		IndexFieldObjectImpl indexFieldObject = new IndexFieldObjectImpl();
		return indexFieldObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpatialField createSpatialField() {
		SpatialFieldImpl spatialField = new SpatialFieldImpl();
		return spatialField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AggregatedMultiIndexField createAggregatedMultiIndexField() {
		AggregatedMultiIndexFieldImpl aggregatedMultiIndexField = new AggregatedMultiIndexFieldImpl();
		return aggregatedMultiIndexField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FacetField createFacetField() {
		FacetFieldImpl facetField = new FacetFieldImpl();
		return facetField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FacetContext createFacetContext() {
		FacetContextImpl facetContext = new FacetContextImpl();
		return facetContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FacetFieldObject createFacetFieldObject() {
		FacetFieldObjectImpl facetFieldObject = new FacetFieldObjectImpl();
		return facetFieldObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SearchableFacetDocumentObject createSearchableFacetDocumentObject() {
		SearchableFacetDocumentObjectImpl searchableFacetDocumentObject = new SearchableFacetDocumentObjectImpl();
		return searchableFacetDocumentObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StoreType createStoreTypeFromString(EDataType eDataType, String initialValue) {
		StoreType result = StoreType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStoreTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TermVectorType createTermVectorTypeFromString(EDataType eDataType, String initialValue) {
		TermVectorType result = TermVectorType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTermVectorTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndexType createIndexTypeFromString(EDataType eDataType, String initialValue) {
		IndexType result = IndexType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIndexTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndexFieldType createIndexFieldTypeFromString(EDataType eDataType, String initialValue) {
		IndexFieldType result = IndexFieldType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIndexFieldTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FacetIndexWriterType createFacetIndexWriterTypeFromString(EDataType eDataType, String initialValue) {
		FacetIndexWriterType result = FacetIndexWriterType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFacetIndexWriterTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SearchIndexPackage getSearchIndexPackage() {
		return (SearchIndexPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SearchIndexPackage getPackage() {
		return SearchIndexPackage.eINSTANCE;
	}

} //SearchIndexFactoryImpl
