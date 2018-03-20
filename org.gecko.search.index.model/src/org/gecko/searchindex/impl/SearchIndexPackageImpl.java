/**
 */
package org.gecko.searchindex.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.gecko.emf.utilities.UtilPackage;
import org.gecko.searchindex.AggregatedMultiIndexField;
import org.gecko.searchindex.FacetContext;
import org.gecko.searchindex.FacetField;
import org.gecko.searchindex.FacetFieldObject;
import org.gecko.searchindex.FacetIndexWriterType;
import org.gecko.searchindex.IndexDescriptor;
import org.gecko.searchindex.IndexDescriptorContainer;
import org.gecko.searchindex.IndexField;
import org.gecko.searchindex.IndexFieldObject;
import org.gecko.searchindex.IndexFieldType;
import org.gecko.searchindex.IndexObject;
import org.gecko.searchindex.IndexType;
import org.gecko.searchindex.SearchIndexFactory;
import org.gecko.searchindex.SearchIndexPackage;
import org.gecko.searchindex.SearchableFacetDocumentObject;
import org.gecko.searchindex.SpatialField;
import org.gecko.searchindex.StoreType;
import org.gecko.searchindex.TermVectorType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SearchIndexPackageImpl extends EPackageImpl implements SearchIndexPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass indexDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass indexDescriptorContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass indexFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass indexObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass indexFieldObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass spatialFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aggregatedMultiIndexFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass facetFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass facetContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass facetFieldObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass searchableFacetDocumentObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum storeTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum termVectorTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum indexTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum indexFieldTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum facetIndexWriterTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.gecko.searchindex.SearchIndexPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SearchIndexPackageImpl() {
		super(eNS_URI, SearchIndexFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link SearchIndexPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SearchIndexPackage init() {
		if (isInited) return (SearchIndexPackage)EPackage.Registry.INSTANCE.getEPackage(SearchIndexPackage.eNS_URI);

		// Obtain or create and register package
		SearchIndexPackageImpl theSearchIndexPackage = (SearchIndexPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SearchIndexPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SearchIndexPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		UtilPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theSearchIndexPackage.createPackageContents();

		// Initialize created meta-data
		theSearchIndexPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSearchIndexPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SearchIndexPackage.eNS_URI, theSearchIndexPackage);
		return theSearchIndexPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIndexDescriptor() {
		return indexDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIndexDescriptor_Id() {
		return (EAttribute)indexDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIndexDescriptor_Fields() {
		return (EReference)indexDescriptorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIndexDescriptor_Boost() {
		return (EAttribute)indexDescriptorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIndexDescriptor_ReferencedDescriptors() {
		return (EReference)indexDescriptorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIndexDescriptor_Classes() {
		return (EReference)indexDescriptorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIndexDescriptor_Description() {
		return (EAttribute)indexDescriptorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIndexDescriptor_Active() {
		return (EAttribute)indexDescriptorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIndexDescriptor_FacetContext() {
		return (EReference)indexDescriptorEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIndexDescriptor_UseDynamicPerFieldAnalyizer() {
		return (EAttribute)indexDescriptorEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIndexDescriptor__GetIndexField__EStructuralFeature() {
		return indexDescriptorEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIndexDescriptorContainer() {
		return indexDescriptorContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIndexDescriptorContainer_Descriptors() {
		return (EReference)indexDescriptorContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIndexDescriptorContainer_ActiveDescriptors() {
		return (EReference)indexDescriptorContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIndexField() {
		return indexFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIndexField_TermVector() {
		return (EAttribute)indexFieldEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIndexField_Store() {
		return (EAttribute)indexFieldEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIndexField_Boost() {
		return (EAttribute)indexFieldEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIndexField_Type() {
		return (EAttribute)indexFieldEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIndexField_Key() {
		return (EAttribute)indexFieldEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIndexField_Feature() {
		return (EReference)indexFieldEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIndexField_Converter() {
		return (EReference)indexFieldEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIndexField_OmitNorms() {
		return (EAttribute)indexFieldEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIndexField_IdField() {
		return (EAttribute)indexFieldEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIndexField_Index() {
		return (EAttribute)indexFieldEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIndexField_PkField() {
		return (EAttribute)indexFieldEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIndexObject() {
		return indexObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIndexObject_Object() {
		return (EAttribute)indexObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIndexObject_Descriptor() {
		return (EReference)indexObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIndexObject_FieldObjects() {
		return (EReference)indexObjectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIndexObject_IdField() {
		return (EReference)indexObjectEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIndexObject_FacetObjects() {
		return (EReference)indexObjectEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIndexObject_SearchableFacetDocumentObjects() {
		return (EReference)indexObjectEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIndexFieldObject() {
		return indexFieldObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIndexFieldObject_Value() {
		return (EAttribute)indexFieldObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIndexFieldObject_Field() {
		return (EReference)indexFieldObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSpatialField() {
		return spatialFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpatialField_Longitude() {
		return (EReference)spatialFieldEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpatialField_Latitude() {
		return (EReference)spatialFieldEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAggregatedMultiIndexField() {
		return aggregatedMultiIndexFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAggregatedMultiIndexField_Features() {
		return (EReference)aggregatedMultiIndexFieldEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAggregatedMultiIndexField_IndexFields() {
		return (EReference)aggregatedMultiIndexFieldEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFacetField() {
		return facetFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFacetField_Key() {
		return (EAttribute)facetFieldEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFacetField_Feature() {
		return (EReference)facetFieldEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFacetField_MultiValued() {
		return (EAttribute)facetFieldEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFacetField_Hirachical() {
		return (EAttribute)facetFieldEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFacetField_RequireCount() {
		return (EAttribute)facetFieldEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFacetField_ReferencedIndexField() {
		return (EReference)facetFieldEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFacetField_FacetContext() {
		return (EReference)facetFieldEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFacetContext() {
		return facetContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFacetContext_FacetWriter() {
		return (EAttribute)facetContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFacetContext_FacetFields() {
		return (EReference)facetContextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFacetFieldObject() {
		return facetFieldObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFacetFieldObject_Value() {
		return (EAttribute)facetFieldObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFacetFieldObject_Field() {
		return (EReference)facetFieldObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSearchableFacetDocumentObject() {
		return searchableFacetDocumentObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSearchableFacetDocumentObject_Id() {
		return (EAttribute)searchableFacetDocumentObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSearchableFacetDocumentObject_SystemName() {
		return (EAttribute)searchableFacetDocumentObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSearchableFacetDocumentObject_Language() {
		return (EAttribute)searchableFacetDocumentObjectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSearchableFacetDocumentObject_Translation() {
		return (EAttribute)searchableFacetDocumentObjectEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSearchableFacetDocumentObject_Facet() {
		return (EAttribute)searchableFacetDocumentObjectEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSearchableFacetDocumentObject_TranslationFieldKey() {
		return (EAttribute)searchableFacetDocumentObjectEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getStoreType() {
		return storeTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTermVectorType() {
		return termVectorTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIndexType() {
		return indexTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIndexFieldType() {
		return indexFieldTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFacetIndexWriterType() {
		return facetIndexWriterTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SearchIndexFactory getSearchIndexFactory() {
		return (SearchIndexFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		indexDescriptorEClass = createEClass(INDEX_DESCRIPTOR);
		createEAttribute(indexDescriptorEClass, INDEX_DESCRIPTOR__ID);
		createEReference(indexDescriptorEClass, INDEX_DESCRIPTOR__FIELDS);
		createEAttribute(indexDescriptorEClass, INDEX_DESCRIPTOR__BOOST);
		createEReference(indexDescriptorEClass, INDEX_DESCRIPTOR__REFERENCED_DESCRIPTORS);
		createEReference(indexDescriptorEClass, INDEX_DESCRIPTOR__CLASSES);
		createEAttribute(indexDescriptorEClass, INDEX_DESCRIPTOR__DESCRIPTION);
		createEAttribute(indexDescriptorEClass, INDEX_DESCRIPTOR__ACTIVE);
		createEReference(indexDescriptorEClass, INDEX_DESCRIPTOR__FACET_CONTEXT);
		createEAttribute(indexDescriptorEClass, INDEX_DESCRIPTOR__USE_DYNAMIC_PER_FIELD_ANALYIZER);
		createEOperation(indexDescriptorEClass, INDEX_DESCRIPTOR___GET_INDEX_FIELD__ESTRUCTURALFEATURE);

		indexDescriptorContainerEClass = createEClass(INDEX_DESCRIPTOR_CONTAINER);
		createEReference(indexDescriptorContainerEClass, INDEX_DESCRIPTOR_CONTAINER__DESCRIPTORS);
		createEReference(indexDescriptorContainerEClass, INDEX_DESCRIPTOR_CONTAINER__ACTIVE_DESCRIPTORS);

		indexFieldEClass = createEClass(INDEX_FIELD);
		createEAttribute(indexFieldEClass, INDEX_FIELD__TERM_VECTOR);
		createEAttribute(indexFieldEClass, INDEX_FIELD__STORE);
		createEAttribute(indexFieldEClass, INDEX_FIELD__BOOST);
		createEAttribute(indexFieldEClass, INDEX_FIELD__TYPE);
		createEAttribute(indexFieldEClass, INDEX_FIELD__KEY);
		createEReference(indexFieldEClass, INDEX_FIELD__FEATURE);
		createEReference(indexFieldEClass, INDEX_FIELD__CONVERTER);
		createEAttribute(indexFieldEClass, INDEX_FIELD__OMIT_NORMS);
		createEAttribute(indexFieldEClass, INDEX_FIELD__ID_FIELD);
		createEAttribute(indexFieldEClass, INDEX_FIELD__INDEX);
		createEAttribute(indexFieldEClass, INDEX_FIELD__PK_FIELD);

		indexObjectEClass = createEClass(INDEX_OBJECT);
		createEAttribute(indexObjectEClass, INDEX_OBJECT__OBJECT);
		createEReference(indexObjectEClass, INDEX_OBJECT__DESCRIPTOR);
		createEReference(indexObjectEClass, INDEX_OBJECT__FIELD_OBJECTS);
		createEReference(indexObjectEClass, INDEX_OBJECT__ID_FIELD);
		createEReference(indexObjectEClass, INDEX_OBJECT__FACET_OBJECTS);
		createEReference(indexObjectEClass, INDEX_OBJECT__SEARCHABLE_FACET_DOCUMENT_OBJECTS);

		indexFieldObjectEClass = createEClass(INDEX_FIELD_OBJECT);
		createEAttribute(indexFieldObjectEClass, INDEX_FIELD_OBJECT__VALUE);
		createEReference(indexFieldObjectEClass, INDEX_FIELD_OBJECT__FIELD);

		spatialFieldEClass = createEClass(SPATIAL_FIELD);
		createEReference(spatialFieldEClass, SPATIAL_FIELD__LONGITUDE);
		createEReference(spatialFieldEClass, SPATIAL_FIELD__LATITUDE);

		aggregatedMultiIndexFieldEClass = createEClass(AGGREGATED_MULTI_INDEX_FIELD);
		createEReference(aggregatedMultiIndexFieldEClass, AGGREGATED_MULTI_INDEX_FIELD__FEATURES);
		createEReference(aggregatedMultiIndexFieldEClass, AGGREGATED_MULTI_INDEX_FIELD__INDEX_FIELDS);

		facetFieldEClass = createEClass(FACET_FIELD);
		createEAttribute(facetFieldEClass, FACET_FIELD__KEY);
		createEReference(facetFieldEClass, FACET_FIELD__FEATURE);
		createEAttribute(facetFieldEClass, FACET_FIELD__MULTI_VALUED);
		createEAttribute(facetFieldEClass, FACET_FIELD__HIRACHICAL);
		createEAttribute(facetFieldEClass, FACET_FIELD__REQUIRE_COUNT);
		createEReference(facetFieldEClass, FACET_FIELD__REFERENCED_INDEX_FIELD);
		createEReference(facetFieldEClass, FACET_FIELD__FACET_CONTEXT);

		facetContextEClass = createEClass(FACET_CONTEXT);
		createEAttribute(facetContextEClass, FACET_CONTEXT__FACET_WRITER);
		createEReference(facetContextEClass, FACET_CONTEXT__FACET_FIELDS);

		facetFieldObjectEClass = createEClass(FACET_FIELD_OBJECT);
		createEAttribute(facetFieldObjectEClass, FACET_FIELD_OBJECT__VALUE);
		createEReference(facetFieldObjectEClass, FACET_FIELD_OBJECT__FIELD);

		searchableFacetDocumentObjectEClass = createEClass(SEARCHABLE_FACET_DOCUMENT_OBJECT);
		createEAttribute(searchableFacetDocumentObjectEClass, SEARCHABLE_FACET_DOCUMENT_OBJECT__ID);
		createEAttribute(searchableFacetDocumentObjectEClass, SEARCHABLE_FACET_DOCUMENT_OBJECT__SYSTEM_NAME);
		createEAttribute(searchableFacetDocumentObjectEClass, SEARCHABLE_FACET_DOCUMENT_OBJECT__LANGUAGE);
		createEAttribute(searchableFacetDocumentObjectEClass, SEARCHABLE_FACET_DOCUMENT_OBJECT__TRANSLATION);
		createEAttribute(searchableFacetDocumentObjectEClass, SEARCHABLE_FACET_DOCUMENT_OBJECT__FACET);
		createEAttribute(searchableFacetDocumentObjectEClass, SEARCHABLE_FACET_DOCUMENT_OBJECT__TRANSLATION_FIELD_KEY);

		// Create enums
		storeTypeEEnum = createEEnum(STORE_TYPE);
		termVectorTypeEEnum = createEEnum(TERM_VECTOR_TYPE);
		indexTypeEEnum = createEEnum(INDEX_TYPE);
		indexFieldTypeEEnum = createEEnum(INDEX_FIELD_TYPE);
		facetIndexWriterTypeEEnum = createEEnum(FACET_INDEX_WRITER_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		UtilPackage theUtilPackage = (UtilPackage)EPackage.Registry.INSTANCE.getEPackage(UtilPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		spatialFieldEClass.getESuperTypes().add(this.getIndexField());
		aggregatedMultiIndexFieldEClass.getESuperTypes().add(this.getIndexField());

		// Initialize classes, features, and operations; add parameters
		initEClass(indexDescriptorEClass, IndexDescriptor.class, "IndexDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIndexDescriptor_Id(), ecorePackage.getEString(), "id", null, 1, 1, IndexDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIndexDescriptor_Fields(), this.getIndexField(), null, "fields", null, 0, -1, IndexDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIndexDescriptor_Boost(), ecorePackage.getEFloat(), "boost", "1.0", 0, 1, IndexDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIndexDescriptor_ReferencedDescriptors(), this.getIndexDescriptor(), null, "referencedDescriptors", null, 0, -1, IndexDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getIndexDescriptor_ReferencedDescriptors().getEKeys().add(this.getIndexDescriptor_Id());
		initEReference(getIndexDescriptor_Classes(), ecorePackage.getEClass(), null, "classes", null, 0, -1, IndexDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIndexDescriptor_Description(), ecorePackage.getEString(), "description", null, 0, 1, IndexDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIndexDescriptor_Active(), ecorePackage.getEBoolean(), "active", "false", 1, 1, IndexDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIndexDescriptor_FacetContext(), this.getFacetContext(), null, "facetContext", null, 0, 1, IndexDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIndexDescriptor_UseDynamicPerFieldAnalyizer(), ecorePackage.getEBoolean(), "useDynamicPerFieldAnalyizer", null, 0, 1, IndexDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getIndexDescriptor__GetIndexField__EStructuralFeature(), this.getIndexField(), "getIndexField", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEStructuralFeature(), "feature", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(indexDescriptorContainerEClass, IndexDescriptorContainer.class, "IndexDescriptorContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIndexDescriptorContainer_Descriptors(), this.getIndexDescriptor(), null, "descriptors", null, 0, -1, IndexDescriptorContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getIndexDescriptorContainer_Descriptors().getEKeys().add(this.getIndexDescriptor_Id());
		initEReference(getIndexDescriptorContainer_ActiveDescriptors(), this.getIndexDescriptor(), null, "activeDescriptors", null, 0, -1, IndexDescriptorContainer.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(indexFieldEClass, IndexField.class, "IndexField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIndexField_TermVector(), this.getTermVectorType(), "termVector", null, 1, 1, IndexField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIndexField_Store(), this.getStoreType(), "store", null, 1, 1, IndexField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIndexField_Boost(), ecorePackage.getEFloat(), "boost", "1.0", 0, 1, IndexField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIndexField_Type(), this.getIndexFieldType(), "type", "STRING", 1, 1, IndexField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIndexField_Key(), ecorePackage.getEString(), "key", null, 0, 1, IndexField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIndexField_Feature(), theUtilPackage.getFeaturePath(), null, "feature", null, 1, 1, IndexField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIndexField_Converter(), theUtilPackage.getConverter(), null, "converter", null, 0, 1, IndexField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIndexField_OmitNorms(), ecorePackage.getEBoolean(), "omitNorms", "false", 0, 1, IndexField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIndexField_IdField(), ecorePackage.getEBoolean(), "idField", "false", 1, 1, IndexField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIndexField_Index(), this.getIndexType(), "index", null, 0, 1, IndexField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIndexField_PkField(), ecorePackage.getEBoolean(), "pkField", "false", 0, 1, IndexField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(indexObjectEClass, IndexObject.class, "IndexObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIndexObject_Object(), ecorePackage.getEJavaObject(), "object", null, 1, -1, IndexObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIndexObject_Descriptor(), this.getIndexDescriptor(), null, "descriptor", null, 1, 1, IndexObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIndexObject_FieldObjects(), this.getIndexFieldObject(), null, "fieldObjects", null, 0, -1, IndexObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIndexObject_IdField(), this.getIndexFieldObject(), null, "idField", null, 1, 1, IndexObject.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getIndexObject_FacetObjects(), this.getFacetFieldObject(), null, "facetObjects", null, 0, -1, IndexObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIndexObject_SearchableFacetDocumentObjects(), this.getSearchableFacetDocumentObject(), null, "searchableFacetDocumentObjects", null, 0, -1, IndexObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(indexFieldObjectEClass, IndexFieldObject.class, "IndexFieldObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIndexFieldObject_Value(), ecorePackage.getEJavaObject(), "value", null, 0, 1, IndexFieldObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIndexFieldObject_Field(), this.getIndexField(), null, "field", null, 1, 1, IndexFieldObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(spatialFieldEClass, SpatialField.class, "SpatialField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSpatialField_Longitude(), theUtilPackage.getFeaturePath(), null, "longitude", null, 1, 1, SpatialField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpatialField_Latitude(), theUtilPackage.getFeaturePath(), null, "latitude", null, 1, 1, SpatialField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(aggregatedMultiIndexFieldEClass, AggregatedMultiIndexField.class, "AggregatedMultiIndexField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAggregatedMultiIndexField_Features(), theUtilPackage.getFeaturePath(), null, "features", null, 0, -1, AggregatedMultiIndexField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAggregatedMultiIndexField_IndexFields(), this.getIndexField(), null, "indexFields", null, 0, -1, AggregatedMultiIndexField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(facetFieldEClass, FacetField.class, "FacetField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFacetField_Key(), ecorePackage.getEString(), "key", null, 0, 1, FacetField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFacetField_Feature(), theUtilPackage.getFeaturePath(), null, "feature", null, 1, 1, FacetField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFacetField_MultiValued(), ecorePackage.getEBoolean(), "multiValued", null, 0, 1, FacetField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFacetField_Hirachical(), ecorePackage.getEBoolean(), "hirachical", null, 0, 1, FacetField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFacetField_RequireCount(), ecorePackage.getEBoolean(), "requireCount", null, 0, 1, FacetField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFacetField_ReferencedIndexField(), this.getIndexField(), null, "referencedIndexField", null, 0, 1, FacetField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFacetField_FacetContext(), this.getFacetContext(), this.getFacetContext_FacetFields(), "facetContext", null, 0, 1, FacetField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(facetContextEClass, FacetContext.class, "FacetContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFacetContext_FacetWriter(), this.getFacetIndexWriterType(), "facetWriter", null, 0, 1, FacetContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFacetContext_FacetFields(), this.getFacetField(), this.getFacetField_FacetContext(), "facetFields", null, 0, -1, FacetContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(facetFieldObjectEClass, FacetFieldObject.class, "FacetFieldObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFacetFieldObject_Value(), ecorePackage.getEJavaObject(), "value", null, 0, 1, FacetFieldObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFacetFieldObject_Field(), this.getFacetField(), null, "field", null, 1, 1, FacetFieldObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(searchableFacetDocumentObjectEClass, SearchableFacetDocumentObject.class, "SearchableFacetDocumentObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSearchableFacetDocumentObject_Id(), ecorePackage.getEString(), "id", null, 1, 1, SearchableFacetDocumentObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSearchableFacetDocumentObject_SystemName(), ecorePackage.getEString(), "systemName", null, 1, 1, SearchableFacetDocumentObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSearchableFacetDocumentObject_Language(), ecorePackage.getEString(), "language", null, 0, 1, SearchableFacetDocumentObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSearchableFacetDocumentObject_Translation(), ecorePackage.getEString(), "translation", null, 1, 1, SearchableFacetDocumentObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSearchableFacetDocumentObject_Facet(), ecorePackage.getEString(), "facet", null, 1, 1, SearchableFacetDocumentObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSearchableFacetDocumentObject_TranslationFieldKey(), ecorePackage.getEString(), "translationFieldKey", null, 0, 1, SearchableFacetDocumentObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(storeTypeEEnum, StoreType.class, "StoreType");
		addEEnumLiteral(storeTypeEEnum, StoreType.NO);
		addEEnumLiteral(storeTypeEEnum, StoreType.YES);

		initEEnum(termVectorTypeEEnum, TermVectorType.class, "TermVectorType");
		addEEnumLiteral(termVectorTypeEEnum, TermVectorType.YES);
		addEEnumLiteral(termVectorTypeEEnum, TermVectorType.WITH_POSITIONS);
		addEEnumLiteral(termVectorTypeEEnum, TermVectorType.WITH_OFFSETS);
		addEEnumLiteral(termVectorTypeEEnum, TermVectorType.WITH_POSTION_OFFSETS);
		addEEnumLiteral(termVectorTypeEEnum, TermVectorType.NO);

		initEEnum(indexTypeEEnum, IndexType.class, "IndexType");
		addEEnumLiteral(indexTypeEEnum, IndexType.ANALYZED);
		addEEnumLiteral(indexTypeEEnum, IndexType.NOT_ANALYZED);
		addEEnumLiteral(indexTypeEEnum, IndexType.ANALYZED_NO_NORMS);
		addEEnumLiteral(indexTypeEEnum, IndexType.NOT_ANALYZED_NO_NORMS);
		addEEnumLiteral(indexTypeEEnum, IndexType.NO);

		initEEnum(indexFieldTypeEEnum, IndexFieldType.class, "IndexFieldType");
		addEEnumLiteral(indexFieldTypeEEnum, IndexFieldType.STRING);
		addEEnumLiteral(indexFieldTypeEEnum, IndexFieldType.TEXT);
		addEEnumLiteral(indexFieldTypeEEnum, IndexFieldType.DOUBLE);
		addEEnumLiteral(indexFieldTypeEEnum, IndexFieldType.FLOAT);
		addEEnumLiteral(indexFieldTypeEEnum, IndexFieldType.INT);
		addEEnumLiteral(indexFieldTypeEEnum, IndexFieldType.LONG);
		addEEnumLiteral(indexFieldTypeEEnum, IndexFieldType.SHORT);
		addEEnumLiteral(indexFieldTypeEEnum, IndexFieldType.BOOST);
		addEEnumLiteral(indexFieldTypeEEnum, IndexFieldType.ENUM);
		addEEnumLiteral(indexFieldTypeEEnum, IndexFieldType.WHITESPACE);
		addEEnumLiteral(indexFieldTypeEEnum, IndexFieldType.STANDARD);
		addEEnumLiteral(indexFieldTypeEEnum, IndexFieldType.SHINGLE);
		addEEnumLiteral(indexFieldTypeEEnum, IndexFieldType.SORTED_DOC_VALUE);
		addEEnumLiteral(indexFieldTypeEEnum, IndexFieldType.SORTED_NUMERIC_DOC_VALUE);
		addEEnumLiteral(indexFieldTypeEEnum, IndexFieldType.BINARY_DOC_VALUE);

		initEEnum(facetIndexWriterTypeEEnum, FacetIndexWriterType.class, "FacetIndexWriterType");
		addEEnumLiteral(facetIndexWriterTypeEEnum, FacetIndexWriterType.TAXONOMY_WRITER);

		// Create resource
		createResource(eNS_URI);
	}

} //SearchIndexPackageImpl
