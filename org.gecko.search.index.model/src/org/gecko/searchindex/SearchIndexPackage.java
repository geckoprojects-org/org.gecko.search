/**
 */
package org.gecko.searchindex;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.gecko.searchindex.SearchIndexFactory
 * @model kind="package"
 * @generated
 */
public interface SearchIndexPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "searchindex";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://data-in-motion.biz/search/index/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "searchindex";

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eCONTENT_TYPE = "search";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SearchIndexPackage eINSTANCE = org.gecko.searchindex.impl.SearchIndexPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.gecko.searchindex.impl.IndexDescriptorImpl <em>Index Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchindex.impl.IndexDescriptorImpl
	 * @see org.gecko.searchindex.impl.SearchIndexPackageImpl#getIndexDescriptor()
	 * @generated
	 */
	int INDEX_DESCRIPTOR = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_DESCRIPTOR__ID = 0;

	/**
	 * The feature id for the '<em><b>Fields</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_DESCRIPTOR__FIELDS = 1;

	/**
	 * The feature id for the '<em><b>Boost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_DESCRIPTOR__BOOST = 2;

	/**
	 * The feature id for the '<em><b>Referenced Descriptors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_DESCRIPTOR__REFERENCED_DESCRIPTORS = 3;

	/**
	 * The feature id for the '<em><b>Classes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_DESCRIPTOR__CLASSES = 4;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_DESCRIPTOR__DESCRIPTION = 5;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_DESCRIPTOR__ACTIVE = 6;

	/**
	 * The feature id for the '<em><b>Facet Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_DESCRIPTOR__FACET_CONTEXT = 7;

	/**
	 * The feature id for the '<em><b>Use Dynamic Per Field Analyizer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_DESCRIPTOR__USE_DYNAMIC_PER_FIELD_ANALYIZER = 8;

	/**
	 * The number of structural features of the '<em>Index Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_DESCRIPTOR_FEATURE_COUNT = 9;

	/**
	 * The operation id for the '<em>Get Index Field</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_DESCRIPTOR___GET_INDEX_FIELD__ESTRUCTURALFEATURE = 0;

	/**
	 * The number of operations of the '<em>Index Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_DESCRIPTOR_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.gecko.searchindex.impl.IndexDescriptorContainerImpl <em>Index Descriptor Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchindex.impl.IndexDescriptorContainerImpl
	 * @see org.gecko.searchindex.impl.SearchIndexPackageImpl#getIndexDescriptorContainer()
	 * @generated
	 */
	int INDEX_DESCRIPTOR_CONTAINER = 1;

	/**
	 * The feature id for the '<em><b>Descriptors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_DESCRIPTOR_CONTAINER__DESCRIPTORS = 0;

	/**
	 * The feature id for the '<em><b>Active Descriptors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_DESCRIPTOR_CONTAINER__ACTIVE_DESCRIPTORS = 1;

	/**
	 * The number of structural features of the '<em>Index Descriptor Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_DESCRIPTOR_CONTAINER_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Index Descriptor Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_DESCRIPTOR_CONTAINER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.gecko.searchindex.impl.IndexFieldImpl <em>Index Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchindex.impl.IndexFieldImpl
	 * @see org.gecko.searchindex.impl.SearchIndexPackageImpl#getIndexField()
	 * @generated
	 */
	int INDEX_FIELD = 2;

	/**
	 * The feature id for the '<em><b>Term Vector</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_FIELD__TERM_VECTOR = 0;

	/**
	 * The feature id for the '<em><b>Store</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_FIELD__STORE = 1;

	/**
	 * The feature id for the '<em><b>Boost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_FIELD__BOOST = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_FIELD__TYPE = 3;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_FIELD__KEY = 4;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_FIELD__FEATURE = 5;

	/**
	 * The feature id for the '<em><b>Converter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_FIELD__CONVERTER = 6;

	/**
	 * The feature id for the '<em><b>Omit Norms</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_FIELD__OMIT_NORMS = 7;

	/**
	 * The feature id for the '<em><b>Id Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_FIELD__ID_FIELD = 8;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_FIELD__INDEX = 9;

	/**
	 * The feature id for the '<em><b>Pk Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_FIELD__PK_FIELD = 10;

	/**
	 * The number of structural features of the '<em>Index Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_FIELD_FEATURE_COUNT = 11;

	/**
	 * The number of operations of the '<em>Index Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_FIELD_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.gecko.searchindex.impl.IndexObjectImpl <em>Index Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchindex.impl.IndexObjectImpl
	 * @see org.gecko.searchindex.impl.SearchIndexPackageImpl#getIndexObject()
	 * @generated
	 */
	int INDEX_OBJECT = 3;

	/**
	 * The feature id for the '<em><b>Object</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_OBJECT__OBJECT = 0;

	/**
	 * The feature id for the '<em><b>Descriptor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_OBJECT__DESCRIPTOR = 1;

	/**
	 * The feature id for the '<em><b>Field Objects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_OBJECT__FIELD_OBJECTS = 2;

	/**
	 * The feature id for the '<em><b>Id Field</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_OBJECT__ID_FIELD = 3;

	/**
	 * The feature id for the '<em><b>Facet Objects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_OBJECT__FACET_OBJECTS = 4;

	/**
	 * The feature id for the '<em><b>Searchable Facet Document Objects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_OBJECT__SEARCHABLE_FACET_DOCUMENT_OBJECTS = 5;

	/**
	 * The number of structural features of the '<em>Index Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_OBJECT_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Index Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_OBJECT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.gecko.searchindex.impl.IndexFieldObjectImpl <em>Index Field Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchindex.impl.IndexFieldObjectImpl
	 * @see org.gecko.searchindex.impl.SearchIndexPackageImpl#getIndexFieldObject()
	 * @generated
	 */
	int INDEX_FIELD_OBJECT = 4;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_FIELD_OBJECT__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Field</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_FIELD_OBJECT__FIELD = 1;

	/**
	 * The number of structural features of the '<em>Index Field Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_FIELD_OBJECT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Index Field Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_FIELD_OBJECT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.gecko.searchindex.impl.SpatialFieldImpl <em>Spatial Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchindex.impl.SpatialFieldImpl
	 * @see org.gecko.searchindex.impl.SearchIndexPackageImpl#getSpatialField()
	 * @generated
	 */
	int SPATIAL_FIELD = 5;

	/**
	 * The feature id for the '<em><b>Term Vector</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_FIELD__TERM_VECTOR = INDEX_FIELD__TERM_VECTOR;

	/**
	 * The feature id for the '<em><b>Store</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_FIELD__STORE = INDEX_FIELD__STORE;

	/**
	 * The feature id for the '<em><b>Boost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_FIELD__BOOST = INDEX_FIELD__BOOST;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_FIELD__TYPE = INDEX_FIELD__TYPE;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_FIELD__KEY = INDEX_FIELD__KEY;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_FIELD__FEATURE = INDEX_FIELD__FEATURE;

	/**
	 * The feature id for the '<em><b>Converter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_FIELD__CONVERTER = INDEX_FIELD__CONVERTER;

	/**
	 * The feature id for the '<em><b>Omit Norms</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_FIELD__OMIT_NORMS = INDEX_FIELD__OMIT_NORMS;

	/**
	 * The feature id for the '<em><b>Id Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_FIELD__ID_FIELD = INDEX_FIELD__ID_FIELD;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_FIELD__INDEX = INDEX_FIELD__INDEX;

	/**
	 * The feature id for the '<em><b>Pk Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_FIELD__PK_FIELD = INDEX_FIELD__PK_FIELD;

	/**
	 * The feature id for the '<em><b>Longitude</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_FIELD__LONGITUDE = INDEX_FIELD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Latitude</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_FIELD__LATITUDE = INDEX_FIELD_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Spatial Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_FIELD_FEATURE_COUNT = INDEX_FIELD_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Spatial Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_FIELD_OPERATION_COUNT = INDEX_FIELD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gecko.searchindex.impl.AggregatedMultiIndexFieldImpl <em>Aggregated Multi Index Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchindex.impl.AggregatedMultiIndexFieldImpl
	 * @see org.gecko.searchindex.impl.SearchIndexPackageImpl#getAggregatedMultiIndexField()
	 * @generated
	 */
	int AGGREGATED_MULTI_INDEX_FIELD = 6;

	/**
	 * The feature id for the '<em><b>Term Vector</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_MULTI_INDEX_FIELD__TERM_VECTOR = INDEX_FIELD__TERM_VECTOR;

	/**
	 * The feature id for the '<em><b>Store</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_MULTI_INDEX_FIELD__STORE = INDEX_FIELD__STORE;

	/**
	 * The feature id for the '<em><b>Boost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_MULTI_INDEX_FIELD__BOOST = INDEX_FIELD__BOOST;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_MULTI_INDEX_FIELD__TYPE = INDEX_FIELD__TYPE;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_MULTI_INDEX_FIELD__KEY = INDEX_FIELD__KEY;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_MULTI_INDEX_FIELD__FEATURE = INDEX_FIELD__FEATURE;

	/**
	 * The feature id for the '<em><b>Converter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_MULTI_INDEX_FIELD__CONVERTER = INDEX_FIELD__CONVERTER;

	/**
	 * The feature id for the '<em><b>Omit Norms</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_MULTI_INDEX_FIELD__OMIT_NORMS = INDEX_FIELD__OMIT_NORMS;

	/**
	 * The feature id for the '<em><b>Id Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_MULTI_INDEX_FIELD__ID_FIELD = INDEX_FIELD__ID_FIELD;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_MULTI_INDEX_FIELD__INDEX = INDEX_FIELD__INDEX;

	/**
	 * The feature id for the '<em><b>Pk Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_MULTI_INDEX_FIELD__PK_FIELD = INDEX_FIELD__PK_FIELD;

	/**
	 * The feature id for the '<em><b>Features</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_MULTI_INDEX_FIELD__FEATURES = INDEX_FIELD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Index Fields</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_MULTI_INDEX_FIELD__INDEX_FIELDS = INDEX_FIELD_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Aggregated Multi Index Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_MULTI_INDEX_FIELD_FEATURE_COUNT = INDEX_FIELD_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Aggregated Multi Index Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_MULTI_INDEX_FIELD_OPERATION_COUNT = INDEX_FIELD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gecko.searchindex.impl.FacetFieldImpl <em>Facet Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchindex.impl.FacetFieldImpl
	 * @see org.gecko.searchindex.impl.SearchIndexPackageImpl#getFacetField()
	 * @generated
	 */
	int FACET_FIELD = 7;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_FIELD__KEY = 0;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_FIELD__FEATURE = 1;

	/**
	 * The feature id for the '<em><b>Multi Valued</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_FIELD__MULTI_VALUED = 2;

	/**
	 * The feature id for the '<em><b>Hirachical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_FIELD__HIRACHICAL = 3;

	/**
	 * The feature id for the '<em><b>Require Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_FIELD__REQUIRE_COUNT = 4;

	/**
	 * The feature id for the '<em><b>Referenced Index Field</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_FIELD__REFERENCED_INDEX_FIELD = 5;

	/**
	 * The feature id for the '<em><b>Facet Context</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_FIELD__FACET_CONTEXT = 6;

	/**
	 * The number of structural features of the '<em>Facet Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_FIELD_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Facet Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_FIELD_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.gecko.searchindex.impl.FacetContextImpl <em>Facet Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchindex.impl.FacetContextImpl
	 * @see org.gecko.searchindex.impl.SearchIndexPackageImpl#getFacetContext()
	 * @generated
	 */
	int FACET_CONTEXT = 8;

	/**
	 * The feature id for the '<em><b>Facet Writer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_CONTEXT__FACET_WRITER = 0;

	/**
	 * The feature id for the '<em><b>Facet Fields</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_CONTEXT__FACET_FIELDS = 1;

	/**
	 * The number of structural features of the '<em>Facet Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_CONTEXT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Facet Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_CONTEXT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.gecko.searchindex.impl.FacetFieldObjectImpl <em>Facet Field Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchindex.impl.FacetFieldObjectImpl
	 * @see org.gecko.searchindex.impl.SearchIndexPackageImpl#getFacetFieldObject()
	 * @generated
	 */
	int FACET_FIELD_OBJECT = 9;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_FIELD_OBJECT__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Field</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_FIELD_OBJECT__FIELD = 1;

	/**
	 * The number of structural features of the '<em>Facet Field Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_FIELD_OBJECT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Facet Field Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACET_FIELD_OBJECT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.gecko.searchindex.impl.SearchableFacetDocumentObjectImpl <em>Searchable Facet Document Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchindex.impl.SearchableFacetDocumentObjectImpl
	 * @see org.gecko.searchindex.impl.SearchIndexPackageImpl#getSearchableFacetDocumentObject()
	 * @generated
	 */
	int SEARCHABLE_FACET_DOCUMENT_OBJECT = 10;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCHABLE_FACET_DOCUMENT_OBJECT__ID = 0;

	/**
	 * The feature id for the '<em><b>System Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCHABLE_FACET_DOCUMENT_OBJECT__SYSTEM_NAME = 1;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCHABLE_FACET_DOCUMENT_OBJECT__LANGUAGE = 2;

	/**
	 * The feature id for the '<em><b>Translation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCHABLE_FACET_DOCUMENT_OBJECT__TRANSLATION = 3;

	/**
	 * The feature id for the '<em><b>Facet</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCHABLE_FACET_DOCUMENT_OBJECT__FACET = 4;

	/**
	 * The feature id for the '<em><b>Translation Field Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCHABLE_FACET_DOCUMENT_OBJECT__TRANSLATION_FIELD_KEY = 5;

	/**
	 * The number of structural features of the '<em>Searchable Facet Document Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCHABLE_FACET_DOCUMENT_OBJECT_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Searchable Facet Document Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCHABLE_FACET_DOCUMENT_OBJECT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.gecko.searchindex.StoreType <em>Store Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchindex.StoreType
	 * @see org.gecko.searchindex.impl.SearchIndexPackageImpl#getStoreType()
	 * @generated
	 */
	int STORE_TYPE = 11;

	/**
	 * The meta object id for the '{@link org.gecko.searchindex.TermVectorType <em>Term Vector Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchindex.TermVectorType
	 * @see org.gecko.searchindex.impl.SearchIndexPackageImpl#getTermVectorType()
	 * @generated
	 */
	int TERM_VECTOR_TYPE = 12;

	/**
	 * The meta object id for the '{@link org.gecko.searchindex.IndexType <em>Index Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchindex.IndexType
	 * @see org.gecko.searchindex.impl.SearchIndexPackageImpl#getIndexType()
	 * @generated
	 */
	int INDEX_TYPE = 13;

	/**
	 * The meta object id for the '{@link org.gecko.searchindex.IndexFieldType <em>Index Field Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchindex.IndexFieldType
	 * @see org.gecko.searchindex.impl.SearchIndexPackageImpl#getIndexFieldType()
	 * @generated
	 */
	int INDEX_FIELD_TYPE = 14;

	/**
	 * The meta object id for the '{@link org.gecko.searchindex.FacetIndexWriterType <em>Facet Index Writer Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.searchindex.FacetIndexWriterType
	 * @see org.gecko.searchindex.impl.SearchIndexPackageImpl#getFacetIndexWriterType()
	 * @generated
	 */
	int FACET_INDEX_WRITER_TYPE = 15;


	/**
	 * Returns the meta object for class '{@link org.gecko.searchindex.IndexDescriptor <em>Index Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Index Descriptor</em>'.
	 * @see org.gecko.searchindex.IndexDescriptor
	 * @generated
	 */
	EClass getIndexDescriptor();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchindex.IndexDescriptor#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.gecko.searchindex.IndexDescriptor#getId()
	 * @see #getIndexDescriptor()
	 * @generated
	 */
	EAttribute getIndexDescriptor_Id();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gecko.searchindex.IndexDescriptor#getFields <em>Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fields</em>'.
	 * @see org.gecko.searchindex.IndexDescriptor#getFields()
	 * @see #getIndexDescriptor()
	 * @generated
	 */
	EReference getIndexDescriptor_Fields();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchindex.IndexDescriptor#getBoost <em>Boost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Boost</em>'.
	 * @see org.gecko.searchindex.IndexDescriptor#getBoost()
	 * @see #getIndexDescriptor()
	 * @generated
	 */
	EAttribute getIndexDescriptor_Boost();

	/**
	 * Returns the meta object for the reference list '{@link org.gecko.searchindex.IndexDescriptor#getReferencedDescriptors <em>Referenced Descriptors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Referenced Descriptors</em>'.
	 * @see org.gecko.searchindex.IndexDescriptor#getReferencedDescriptors()
	 * @see #getIndexDescriptor()
	 * @generated
	 */
	EReference getIndexDescriptor_ReferencedDescriptors();

	/**
	 * Returns the meta object for the reference list '{@link org.gecko.searchindex.IndexDescriptor#getClasses <em>Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Classes</em>'.
	 * @see org.gecko.searchindex.IndexDescriptor#getClasses()
	 * @see #getIndexDescriptor()
	 * @generated
	 */
	EReference getIndexDescriptor_Classes();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchindex.IndexDescriptor#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.gecko.searchindex.IndexDescriptor#getDescription()
	 * @see #getIndexDescriptor()
	 * @generated
	 */
	EAttribute getIndexDescriptor_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchindex.IndexDescriptor#isActive <em>Active</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Active</em>'.
	 * @see org.gecko.searchindex.IndexDescriptor#isActive()
	 * @see #getIndexDescriptor()
	 * @generated
	 */
	EAttribute getIndexDescriptor_Active();

	/**
	 * Returns the meta object for the containment reference '{@link org.gecko.searchindex.IndexDescriptor#getFacetContext <em>Facet Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Facet Context</em>'.
	 * @see org.gecko.searchindex.IndexDescriptor#getFacetContext()
	 * @see #getIndexDescriptor()
	 * @generated
	 */
	EReference getIndexDescriptor_FacetContext();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchindex.IndexDescriptor#isUseDynamicPerFieldAnalyizer <em>Use Dynamic Per Field Analyizer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Use Dynamic Per Field Analyizer</em>'.
	 * @see org.gecko.searchindex.IndexDescriptor#isUseDynamicPerFieldAnalyizer()
	 * @see #getIndexDescriptor()
	 * @generated
	 */
	EAttribute getIndexDescriptor_UseDynamicPerFieldAnalyizer();

	/**
	 * Returns the meta object for the '{@link org.gecko.searchindex.IndexDescriptor#getIndexField(org.eclipse.emf.ecore.EStructuralFeature) <em>Get Index Field</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Index Field</em>' operation.
	 * @see org.gecko.searchindex.IndexDescriptor#getIndexField(org.eclipse.emf.ecore.EStructuralFeature)
	 * @generated
	 */
	EOperation getIndexDescriptor__GetIndexField__EStructuralFeature();

	/**
	 * Returns the meta object for class '{@link org.gecko.searchindex.IndexDescriptorContainer <em>Index Descriptor Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Index Descriptor Container</em>'.
	 * @see org.gecko.searchindex.IndexDescriptorContainer
	 * @generated
	 */
	EClass getIndexDescriptorContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gecko.searchindex.IndexDescriptorContainer#getDescriptors <em>Descriptors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Descriptors</em>'.
	 * @see org.gecko.searchindex.IndexDescriptorContainer#getDescriptors()
	 * @see #getIndexDescriptorContainer()
	 * @generated
	 */
	EReference getIndexDescriptorContainer_Descriptors();

	/**
	 * Returns the meta object for the reference list '{@link org.gecko.searchindex.IndexDescriptorContainer#getActiveDescriptors <em>Active Descriptors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Active Descriptors</em>'.
	 * @see org.gecko.searchindex.IndexDescriptorContainer#getActiveDescriptors()
	 * @see #getIndexDescriptorContainer()
	 * @generated
	 */
	EReference getIndexDescriptorContainer_ActiveDescriptors();

	/**
	 * Returns the meta object for class '{@link org.gecko.searchindex.IndexField <em>Index Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Index Field</em>'.
	 * @see org.gecko.searchindex.IndexField
	 * @generated
	 */
	EClass getIndexField();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchindex.IndexField#getTermVector <em>Term Vector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Term Vector</em>'.
	 * @see org.gecko.searchindex.IndexField#getTermVector()
	 * @see #getIndexField()
	 * @generated
	 */
	EAttribute getIndexField_TermVector();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchindex.IndexField#getStore <em>Store</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Store</em>'.
	 * @see org.gecko.searchindex.IndexField#getStore()
	 * @see #getIndexField()
	 * @generated
	 */
	EAttribute getIndexField_Store();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchindex.IndexField#getBoost <em>Boost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Boost</em>'.
	 * @see org.gecko.searchindex.IndexField#getBoost()
	 * @see #getIndexField()
	 * @generated
	 */
	EAttribute getIndexField_Boost();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchindex.IndexField#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.gecko.searchindex.IndexField#getType()
	 * @see #getIndexField()
	 * @generated
	 */
	EAttribute getIndexField_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchindex.IndexField#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see org.gecko.searchindex.IndexField#getKey()
	 * @see #getIndexField()
	 * @generated
	 */
	EAttribute getIndexField_Key();

	/**
	 * Returns the meta object for the containment reference '{@link org.gecko.searchindex.IndexField#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Feature</em>'.
	 * @see org.gecko.searchindex.IndexField#getFeature()
	 * @see #getIndexField()
	 * @generated
	 */
	EReference getIndexField_Feature();

	/**
	 * Returns the meta object for the containment reference '{@link org.gecko.searchindex.IndexField#getConverter <em>Converter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Converter</em>'.
	 * @see org.gecko.searchindex.IndexField#getConverter()
	 * @see #getIndexField()
	 * @generated
	 */
	EReference getIndexField_Converter();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchindex.IndexField#isOmitNorms <em>Omit Norms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Omit Norms</em>'.
	 * @see org.gecko.searchindex.IndexField#isOmitNorms()
	 * @see #getIndexField()
	 * @generated
	 */
	EAttribute getIndexField_OmitNorms();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchindex.IndexField#isIdField <em>Id Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id Field</em>'.
	 * @see org.gecko.searchindex.IndexField#isIdField()
	 * @see #getIndexField()
	 * @generated
	 */
	EAttribute getIndexField_IdField();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchindex.IndexField#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see org.gecko.searchindex.IndexField#getIndex()
	 * @see #getIndexField()
	 * @generated
	 */
	EAttribute getIndexField_Index();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchindex.IndexField#isPkField <em>Pk Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pk Field</em>'.
	 * @see org.gecko.searchindex.IndexField#isPkField()
	 * @see #getIndexField()
	 * @generated
	 */
	EAttribute getIndexField_PkField();

	/**
	 * Returns the meta object for class '{@link org.gecko.searchindex.IndexObject <em>Index Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Index Object</em>'.
	 * @see org.gecko.searchindex.IndexObject
	 * @generated
	 */
	EClass getIndexObject();

	/**
	 * Returns the meta object for the attribute list '{@link org.gecko.searchindex.IndexObject#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Object</em>'.
	 * @see org.gecko.searchindex.IndexObject#getObject()
	 * @see #getIndexObject()
	 * @generated
	 */
	EAttribute getIndexObject_Object();

	/**
	 * Returns the meta object for the reference '{@link org.gecko.searchindex.IndexObject#getDescriptor <em>Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Descriptor</em>'.
	 * @see org.gecko.searchindex.IndexObject#getDescriptor()
	 * @see #getIndexObject()
	 * @generated
	 */
	EReference getIndexObject_Descriptor();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gecko.searchindex.IndexObject#getFieldObjects <em>Field Objects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Field Objects</em>'.
	 * @see org.gecko.searchindex.IndexObject#getFieldObjects()
	 * @see #getIndexObject()
	 * @generated
	 */
	EReference getIndexObject_FieldObjects();

	/**
	 * Returns the meta object for the reference '{@link org.gecko.searchindex.IndexObject#getIdField <em>Id Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Id Field</em>'.
	 * @see org.gecko.searchindex.IndexObject#getIdField()
	 * @see #getIndexObject()
	 * @generated
	 */
	EReference getIndexObject_IdField();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gecko.searchindex.IndexObject#getFacetObjects <em>Facet Objects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Facet Objects</em>'.
	 * @see org.gecko.searchindex.IndexObject#getFacetObjects()
	 * @see #getIndexObject()
	 * @generated
	 */
	EReference getIndexObject_FacetObjects();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gecko.searchindex.IndexObject#getSearchableFacetDocumentObjects <em>Searchable Facet Document Objects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Searchable Facet Document Objects</em>'.
	 * @see org.gecko.searchindex.IndexObject#getSearchableFacetDocumentObjects()
	 * @see #getIndexObject()
	 * @generated
	 */
	EReference getIndexObject_SearchableFacetDocumentObjects();

	/**
	 * Returns the meta object for class '{@link org.gecko.searchindex.IndexFieldObject <em>Index Field Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Index Field Object</em>'.
	 * @see org.gecko.searchindex.IndexFieldObject
	 * @generated
	 */
	EClass getIndexFieldObject();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchindex.IndexFieldObject#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.gecko.searchindex.IndexFieldObject#getValue()
	 * @see #getIndexFieldObject()
	 * @generated
	 */
	EAttribute getIndexFieldObject_Value();

	/**
	 * Returns the meta object for the reference '{@link org.gecko.searchindex.IndexFieldObject#getField <em>Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Field</em>'.
	 * @see org.gecko.searchindex.IndexFieldObject#getField()
	 * @see #getIndexFieldObject()
	 * @generated
	 */
	EReference getIndexFieldObject_Field();

	/**
	 * Returns the meta object for class '{@link org.gecko.searchindex.SpatialField <em>Spatial Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Spatial Field</em>'.
	 * @see org.gecko.searchindex.SpatialField
	 * @generated
	 */
	EClass getSpatialField();

	/**
	 * Returns the meta object for the containment reference '{@link org.gecko.searchindex.SpatialField#getLongitude <em>Longitude</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Longitude</em>'.
	 * @see org.gecko.searchindex.SpatialField#getLongitude()
	 * @see #getSpatialField()
	 * @generated
	 */
	EReference getSpatialField_Longitude();

	/**
	 * Returns the meta object for the containment reference '{@link org.gecko.searchindex.SpatialField#getLatitude <em>Latitude</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Latitude</em>'.
	 * @see org.gecko.searchindex.SpatialField#getLatitude()
	 * @see #getSpatialField()
	 * @generated
	 */
	EReference getSpatialField_Latitude();

	/**
	 * Returns the meta object for class '{@link org.gecko.searchindex.AggregatedMultiIndexField <em>Aggregated Multi Index Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aggregated Multi Index Field</em>'.
	 * @see org.gecko.searchindex.AggregatedMultiIndexField
	 * @generated
	 */
	EClass getAggregatedMultiIndexField();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gecko.searchindex.AggregatedMultiIndexField#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Features</em>'.
	 * @see org.gecko.searchindex.AggregatedMultiIndexField#getFeatures()
	 * @see #getAggregatedMultiIndexField()
	 * @generated
	 */
	EReference getAggregatedMultiIndexField_Features();

	/**
	 * Returns the meta object for the reference list '{@link org.gecko.searchindex.AggregatedMultiIndexField#getIndexFields <em>Index Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Index Fields</em>'.
	 * @see org.gecko.searchindex.AggregatedMultiIndexField#getIndexFields()
	 * @see #getAggregatedMultiIndexField()
	 * @generated
	 */
	EReference getAggregatedMultiIndexField_IndexFields();

	/**
	 * Returns the meta object for class '{@link org.gecko.searchindex.FacetField <em>Facet Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Facet Field</em>'.
	 * @see org.gecko.searchindex.FacetField
	 * @generated
	 */
	EClass getFacetField();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchindex.FacetField#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see org.gecko.searchindex.FacetField#getKey()
	 * @see #getFacetField()
	 * @generated
	 */
	EAttribute getFacetField_Key();

	/**
	 * Returns the meta object for the containment reference '{@link org.gecko.searchindex.FacetField#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Feature</em>'.
	 * @see org.gecko.searchindex.FacetField#getFeature()
	 * @see #getFacetField()
	 * @generated
	 */
	EReference getFacetField_Feature();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchindex.FacetField#isMultiValued <em>Multi Valued</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Multi Valued</em>'.
	 * @see org.gecko.searchindex.FacetField#isMultiValued()
	 * @see #getFacetField()
	 * @generated
	 */
	EAttribute getFacetField_MultiValued();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchindex.FacetField#isHirachical <em>Hirachical</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hirachical</em>'.
	 * @see org.gecko.searchindex.FacetField#isHirachical()
	 * @see #getFacetField()
	 * @generated
	 */
	EAttribute getFacetField_Hirachical();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchindex.FacetField#isRequireCount <em>Require Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Require Count</em>'.
	 * @see org.gecko.searchindex.FacetField#isRequireCount()
	 * @see #getFacetField()
	 * @generated
	 */
	EAttribute getFacetField_RequireCount();

	/**
	 * Returns the meta object for the reference '{@link org.gecko.searchindex.FacetField#getReferencedIndexField <em>Referenced Index Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referenced Index Field</em>'.
	 * @see org.gecko.searchindex.FacetField#getReferencedIndexField()
	 * @see #getFacetField()
	 * @generated
	 */
	EReference getFacetField_ReferencedIndexField();

	/**
	 * Returns the meta object for the container reference '{@link org.gecko.searchindex.FacetField#getFacetContext <em>Facet Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Facet Context</em>'.
	 * @see org.gecko.searchindex.FacetField#getFacetContext()
	 * @see #getFacetField()
	 * @generated
	 */
	EReference getFacetField_FacetContext();

	/**
	 * Returns the meta object for class '{@link org.gecko.searchindex.FacetContext <em>Facet Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Facet Context</em>'.
	 * @see org.gecko.searchindex.FacetContext
	 * @generated
	 */
	EClass getFacetContext();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchindex.FacetContext#getFacetWriter <em>Facet Writer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Facet Writer</em>'.
	 * @see org.gecko.searchindex.FacetContext#getFacetWriter()
	 * @see #getFacetContext()
	 * @generated
	 */
	EAttribute getFacetContext_FacetWriter();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gecko.searchindex.FacetContext#getFacetFields <em>Facet Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Facet Fields</em>'.
	 * @see org.gecko.searchindex.FacetContext#getFacetFields()
	 * @see #getFacetContext()
	 * @generated
	 */
	EReference getFacetContext_FacetFields();

	/**
	 * Returns the meta object for class '{@link org.gecko.searchindex.FacetFieldObject <em>Facet Field Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Facet Field Object</em>'.
	 * @see org.gecko.searchindex.FacetFieldObject
	 * @generated
	 */
	EClass getFacetFieldObject();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchindex.FacetFieldObject#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.gecko.searchindex.FacetFieldObject#getValue()
	 * @see #getFacetFieldObject()
	 * @generated
	 */
	EAttribute getFacetFieldObject_Value();

	/**
	 * Returns the meta object for the reference '{@link org.gecko.searchindex.FacetFieldObject#getField <em>Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Field</em>'.
	 * @see org.gecko.searchindex.FacetFieldObject#getField()
	 * @see #getFacetFieldObject()
	 * @generated
	 */
	EReference getFacetFieldObject_Field();

	/**
	 * Returns the meta object for class '{@link org.gecko.searchindex.SearchableFacetDocumentObject <em>Searchable Facet Document Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Searchable Facet Document Object</em>'.
	 * @see org.gecko.searchindex.SearchableFacetDocumentObject
	 * @generated
	 */
	EClass getSearchableFacetDocumentObject();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchindex.SearchableFacetDocumentObject#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.gecko.searchindex.SearchableFacetDocumentObject#getId()
	 * @see #getSearchableFacetDocumentObject()
	 * @generated
	 */
	EAttribute getSearchableFacetDocumentObject_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchindex.SearchableFacetDocumentObject#getSystemName <em>System Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>System Name</em>'.
	 * @see org.gecko.searchindex.SearchableFacetDocumentObject#getSystemName()
	 * @see #getSearchableFacetDocumentObject()
	 * @generated
	 */
	EAttribute getSearchableFacetDocumentObject_SystemName();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchindex.SearchableFacetDocumentObject#getLanguage <em>Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Language</em>'.
	 * @see org.gecko.searchindex.SearchableFacetDocumentObject#getLanguage()
	 * @see #getSearchableFacetDocumentObject()
	 * @generated
	 */
	EAttribute getSearchableFacetDocumentObject_Language();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchindex.SearchableFacetDocumentObject#getTranslation <em>Translation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Translation</em>'.
	 * @see org.gecko.searchindex.SearchableFacetDocumentObject#getTranslation()
	 * @see #getSearchableFacetDocumentObject()
	 * @generated
	 */
	EAttribute getSearchableFacetDocumentObject_Translation();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchindex.SearchableFacetDocumentObject#getFacet <em>Facet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Facet</em>'.
	 * @see org.gecko.searchindex.SearchableFacetDocumentObject#getFacet()
	 * @see #getSearchableFacetDocumentObject()
	 * @generated
	 */
	EAttribute getSearchableFacetDocumentObject_Facet();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.searchindex.SearchableFacetDocumentObject#getTranslationFieldKey <em>Translation Field Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Translation Field Key</em>'.
	 * @see org.gecko.searchindex.SearchableFacetDocumentObject#getTranslationFieldKey()
	 * @see #getSearchableFacetDocumentObject()
	 * @generated
	 */
	EAttribute getSearchableFacetDocumentObject_TranslationFieldKey();

	/**
	 * Returns the meta object for enum '{@link org.gecko.searchindex.StoreType <em>Store Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Store Type</em>'.
	 * @see org.gecko.searchindex.StoreType
	 * @generated
	 */
	EEnum getStoreType();

	/**
	 * Returns the meta object for enum '{@link org.gecko.searchindex.TermVectorType <em>Term Vector Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Term Vector Type</em>'.
	 * @see org.gecko.searchindex.TermVectorType
	 * @generated
	 */
	EEnum getTermVectorType();

	/**
	 * Returns the meta object for enum '{@link org.gecko.searchindex.IndexType <em>Index Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Index Type</em>'.
	 * @see org.gecko.searchindex.IndexType
	 * @generated
	 */
	EEnum getIndexType();

	/**
	 * Returns the meta object for enum '{@link org.gecko.searchindex.IndexFieldType <em>Index Field Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Index Field Type</em>'.
	 * @see org.gecko.searchindex.IndexFieldType
	 * @generated
	 */
	EEnum getIndexFieldType();

	/**
	 * Returns the meta object for enum '{@link org.gecko.searchindex.FacetIndexWriterType <em>Facet Index Writer Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Facet Index Writer Type</em>'.
	 * @see org.gecko.searchindex.FacetIndexWriterType
	 * @generated
	 */
	EEnum getFacetIndexWriterType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SearchIndexFactory getSearchIndexFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.gecko.searchindex.impl.IndexDescriptorImpl <em>Index Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchindex.impl.IndexDescriptorImpl
		 * @see org.gecko.searchindex.impl.SearchIndexPackageImpl#getIndexDescriptor()
		 * @generated
		 */
		EClass INDEX_DESCRIPTOR = eINSTANCE.getIndexDescriptor();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INDEX_DESCRIPTOR__ID = eINSTANCE.getIndexDescriptor_Id();

		/**
		 * The meta object literal for the '<em><b>Fields</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INDEX_DESCRIPTOR__FIELDS = eINSTANCE.getIndexDescriptor_Fields();

		/**
		 * The meta object literal for the '<em><b>Boost</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INDEX_DESCRIPTOR__BOOST = eINSTANCE.getIndexDescriptor_Boost();

		/**
		 * The meta object literal for the '<em><b>Referenced Descriptors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INDEX_DESCRIPTOR__REFERENCED_DESCRIPTORS = eINSTANCE.getIndexDescriptor_ReferencedDescriptors();

		/**
		 * The meta object literal for the '<em><b>Classes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INDEX_DESCRIPTOR__CLASSES = eINSTANCE.getIndexDescriptor_Classes();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INDEX_DESCRIPTOR__DESCRIPTION = eINSTANCE.getIndexDescriptor_Description();

		/**
		 * The meta object literal for the '<em><b>Active</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INDEX_DESCRIPTOR__ACTIVE = eINSTANCE.getIndexDescriptor_Active();

		/**
		 * The meta object literal for the '<em><b>Facet Context</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INDEX_DESCRIPTOR__FACET_CONTEXT = eINSTANCE.getIndexDescriptor_FacetContext();

		/**
		 * The meta object literal for the '<em><b>Use Dynamic Per Field Analyizer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INDEX_DESCRIPTOR__USE_DYNAMIC_PER_FIELD_ANALYIZER = eINSTANCE.getIndexDescriptor_UseDynamicPerFieldAnalyizer();

		/**
		 * The meta object literal for the '<em><b>Get Index Field</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INDEX_DESCRIPTOR___GET_INDEX_FIELD__ESTRUCTURALFEATURE = eINSTANCE.getIndexDescriptor__GetIndexField__EStructuralFeature();

		/**
		 * The meta object literal for the '{@link org.gecko.searchindex.impl.IndexDescriptorContainerImpl <em>Index Descriptor Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchindex.impl.IndexDescriptorContainerImpl
		 * @see org.gecko.searchindex.impl.SearchIndexPackageImpl#getIndexDescriptorContainer()
		 * @generated
		 */
		EClass INDEX_DESCRIPTOR_CONTAINER = eINSTANCE.getIndexDescriptorContainer();

		/**
		 * The meta object literal for the '<em><b>Descriptors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INDEX_DESCRIPTOR_CONTAINER__DESCRIPTORS = eINSTANCE.getIndexDescriptorContainer_Descriptors();

		/**
		 * The meta object literal for the '<em><b>Active Descriptors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INDEX_DESCRIPTOR_CONTAINER__ACTIVE_DESCRIPTORS = eINSTANCE.getIndexDescriptorContainer_ActiveDescriptors();

		/**
		 * The meta object literal for the '{@link org.gecko.searchindex.impl.IndexFieldImpl <em>Index Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchindex.impl.IndexFieldImpl
		 * @see org.gecko.searchindex.impl.SearchIndexPackageImpl#getIndexField()
		 * @generated
		 */
		EClass INDEX_FIELD = eINSTANCE.getIndexField();

		/**
		 * The meta object literal for the '<em><b>Term Vector</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INDEX_FIELD__TERM_VECTOR = eINSTANCE.getIndexField_TermVector();

		/**
		 * The meta object literal for the '<em><b>Store</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INDEX_FIELD__STORE = eINSTANCE.getIndexField_Store();

		/**
		 * The meta object literal for the '<em><b>Boost</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INDEX_FIELD__BOOST = eINSTANCE.getIndexField_Boost();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INDEX_FIELD__TYPE = eINSTANCE.getIndexField_Type();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INDEX_FIELD__KEY = eINSTANCE.getIndexField_Key();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INDEX_FIELD__FEATURE = eINSTANCE.getIndexField_Feature();

		/**
		 * The meta object literal for the '<em><b>Converter</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INDEX_FIELD__CONVERTER = eINSTANCE.getIndexField_Converter();

		/**
		 * The meta object literal for the '<em><b>Omit Norms</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INDEX_FIELD__OMIT_NORMS = eINSTANCE.getIndexField_OmitNorms();

		/**
		 * The meta object literal for the '<em><b>Id Field</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INDEX_FIELD__ID_FIELD = eINSTANCE.getIndexField_IdField();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INDEX_FIELD__INDEX = eINSTANCE.getIndexField_Index();

		/**
		 * The meta object literal for the '<em><b>Pk Field</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INDEX_FIELD__PK_FIELD = eINSTANCE.getIndexField_PkField();

		/**
		 * The meta object literal for the '{@link org.gecko.searchindex.impl.IndexObjectImpl <em>Index Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchindex.impl.IndexObjectImpl
		 * @see org.gecko.searchindex.impl.SearchIndexPackageImpl#getIndexObject()
		 * @generated
		 */
		EClass INDEX_OBJECT = eINSTANCE.getIndexObject();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INDEX_OBJECT__OBJECT = eINSTANCE.getIndexObject_Object();

		/**
		 * The meta object literal for the '<em><b>Descriptor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INDEX_OBJECT__DESCRIPTOR = eINSTANCE.getIndexObject_Descriptor();

		/**
		 * The meta object literal for the '<em><b>Field Objects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INDEX_OBJECT__FIELD_OBJECTS = eINSTANCE.getIndexObject_FieldObjects();

		/**
		 * The meta object literal for the '<em><b>Id Field</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INDEX_OBJECT__ID_FIELD = eINSTANCE.getIndexObject_IdField();

		/**
		 * The meta object literal for the '<em><b>Facet Objects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INDEX_OBJECT__FACET_OBJECTS = eINSTANCE.getIndexObject_FacetObjects();

		/**
		 * The meta object literal for the '<em><b>Searchable Facet Document Objects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INDEX_OBJECT__SEARCHABLE_FACET_DOCUMENT_OBJECTS = eINSTANCE.getIndexObject_SearchableFacetDocumentObjects();

		/**
		 * The meta object literal for the '{@link org.gecko.searchindex.impl.IndexFieldObjectImpl <em>Index Field Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchindex.impl.IndexFieldObjectImpl
		 * @see org.gecko.searchindex.impl.SearchIndexPackageImpl#getIndexFieldObject()
		 * @generated
		 */
		EClass INDEX_FIELD_OBJECT = eINSTANCE.getIndexFieldObject();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INDEX_FIELD_OBJECT__VALUE = eINSTANCE.getIndexFieldObject_Value();

		/**
		 * The meta object literal for the '<em><b>Field</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INDEX_FIELD_OBJECT__FIELD = eINSTANCE.getIndexFieldObject_Field();

		/**
		 * The meta object literal for the '{@link org.gecko.searchindex.impl.SpatialFieldImpl <em>Spatial Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchindex.impl.SpatialFieldImpl
		 * @see org.gecko.searchindex.impl.SearchIndexPackageImpl#getSpatialField()
		 * @generated
		 */
		EClass SPATIAL_FIELD = eINSTANCE.getSpatialField();

		/**
		 * The meta object literal for the '<em><b>Longitude</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPATIAL_FIELD__LONGITUDE = eINSTANCE.getSpatialField_Longitude();

		/**
		 * The meta object literal for the '<em><b>Latitude</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPATIAL_FIELD__LATITUDE = eINSTANCE.getSpatialField_Latitude();

		/**
		 * The meta object literal for the '{@link org.gecko.searchindex.impl.AggregatedMultiIndexFieldImpl <em>Aggregated Multi Index Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchindex.impl.AggregatedMultiIndexFieldImpl
		 * @see org.gecko.searchindex.impl.SearchIndexPackageImpl#getAggregatedMultiIndexField()
		 * @generated
		 */
		EClass AGGREGATED_MULTI_INDEX_FIELD = eINSTANCE.getAggregatedMultiIndexField();

		/**
		 * The meta object literal for the '<em><b>Features</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGGREGATED_MULTI_INDEX_FIELD__FEATURES = eINSTANCE.getAggregatedMultiIndexField_Features();

		/**
		 * The meta object literal for the '<em><b>Index Fields</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGGREGATED_MULTI_INDEX_FIELD__INDEX_FIELDS = eINSTANCE.getAggregatedMultiIndexField_IndexFields();

		/**
		 * The meta object literal for the '{@link org.gecko.searchindex.impl.FacetFieldImpl <em>Facet Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchindex.impl.FacetFieldImpl
		 * @see org.gecko.searchindex.impl.SearchIndexPackageImpl#getFacetField()
		 * @generated
		 */
		EClass FACET_FIELD = eINSTANCE.getFacetField();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FACET_FIELD__KEY = eINSTANCE.getFacetField_Key();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FACET_FIELD__FEATURE = eINSTANCE.getFacetField_Feature();

		/**
		 * The meta object literal for the '<em><b>Multi Valued</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FACET_FIELD__MULTI_VALUED = eINSTANCE.getFacetField_MultiValued();

		/**
		 * The meta object literal for the '<em><b>Hirachical</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FACET_FIELD__HIRACHICAL = eINSTANCE.getFacetField_Hirachical();

		/**
		 * The meta object literal for the '<em><b>Require Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FACET_FIELD__REQUIRE_COUNT = eINSTANCE.getFacetField_RequireCount();

		/**
		 * The meta object literal for the '<em><b>Referenced Index Field</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FACET_FIELD__REFERENCED_INDEX_FIELD = eINSTANCE.getFacetField_ReferencedIndexField();

		/**
		 * The meta object literal for the '<em><b>Facet Context</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FACET_FIELD__FACET_CONTEXT = eINSTANCE.getFacetField_FacetContext();

		/**
		 * The meta object literal for the '{@link org.gecko.searchindex.impl.FacetContextImpl <em>Facet Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchindex.impl.FacetContextImpl
		 * @see org.gecko.searchindex.impl.SearchIndexPackageImpl#getFacetContext()
		 * @generated
		 */
		EClass FACET_CONTEXT = eINSTANCE.getFacetContext();

		/**
		 * The meta object literal for the '<em><b>Facet Writer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FACET_CONTEXT__FACET_WRITER = eINSTANCE.getFacetContext_FacetWriter();

		/**
		 * The meta object literal for the '<em><b>Facet Fields</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FACET_CONTEXT__FACET_FIELDS = eINSTANCE.getFacetContext_FacetFields();

		/**
		 * The meta object literal for the '{@link org.gecko.searchindex.impl.FacetFieldObjectImpl <em>Facet Field Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchindex.impl.FacetFieldObjectImpl
		 * @see org.gecko.searchindex.impl.SearchIndexPackageImpl#getFacetFieldObject()
		 * @generated
		 */
		EClass FACET_FIELD_OBJECT = eINSTANCE.getFacetFieldObject();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FACET_FIELD_OBJECT__VALUE = eINSTANCE.getFacetFieldObject_Value();

		/**
		 * The meta object literal for the '<em><b>Field</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FACET_FIELD_OBJECT__FIELD = eINSTANCE.getFacetFieldObject_Field();

		/**
		 * The meta object literal for the '{@link org.gecko.searchindex.impl.SearchableFacetDocumentObjectImpl <em>Searchable Facet Document Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchindex.impl.SearchableFacetDocumentObjectImpl
		 * @see org.gecko.searchindex.impl.SearchIndexPackageImpl#getSearchableFacetDocumentObject()
		 * @generated
		 */
		EClass SEARCHABLE_FACET_DOCUMENT_OBJECT = eINSTANCE.getSearchableFacetDocumentObject();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEARCHABLE_FACET_DOCUMENT_OBJECT__ID = eINSTANCE.getSearchableFacetDocumentObject_Id();

		/**
		 * The meta object literal for the '<em><b>System Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEARCHABLE_FACET_DOCUMENT_OBJECT__SYSTEM_NAME = eINSTANCE.getSearchableFacetDocumentObject_SystemName();

		/**
		 * The meta object literal for the '<em><b>Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEARCHABLE_FACET_DOCUMENT_OBJECT__LANGUAGE = eINSTANCE.getSearchableFacetDocumentObject_Language();

		/**
		 * The meta object literal for the '<em><b>Translation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEARCHABLE_FACET_DOCUMENT_OBJECT__TRANSLATION = eINSTANCE.getSearchableFacetDocumentObject_Translation();

		/**
		 * The meta object literal for the '<em><b>Facet</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEARCHABLE_FACET_DOCUMENT_OBJECT__FACET = eINSTANCE.getSearchableFacetDocumentObject_Facet();

		/**
		 * The meta object literal for the '<em><b>Translation Field Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEARCHABLE_FACET_DOCUMENT_OBJECT__TRANSLATION_FIELD_KEY = eINSTANCE.getSearchableFacetDocumentObject_TranslationFieldKey();

		/**
		 * The meta object literal for the '{@link org.gecko.searchindex.StoreType <em>Store Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchindex.StoreType
		 * @see org.gecko.searchindex.impl.SearchIndexPackageImpl#getStoreType()
		 * @generated
		 */
		EEnum STORE_TYPE = eINSTANCE.getStoreType();

		/**
		 * The meta object literal for the '{@link org.gecko.searchindex.TermVectorType <em>Term Vector Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchindex.TermVectorType
		 * @see org.gecko.searchindex.impl.SearchIndexPackageImpl#getTermVectorType()
		 * @generated
		 */
		EEnum TERM_VECTOR_TYPE = eINSTANCE.getTermVectorType();

		/**
		 * The meta object literal for the '{@link org.gecko.searchindex.IndexType <em>Index Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchindex.IndexType
		 * @see org.gecko.searchindex.impl.SearchIndexPackageImpl#getIndexType()
		 * @generated
		 */
		EEnum INDEX_TYPE = eINSTANCE.getIndexType();

		/**
		 * The meta object literal for the '{@link org.gecko.searchindex.IndexFieldType <em>Index Field Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchindex.IndexFieldType
		 * @see org.gecko.searchindex.impl.SearchIndexPackageImpl#getIndexFieldType()
		 * @generated
		 */
		EEnum INDEX_FIELD_TYPE = eINSTANCE.getIndexFieldType();

		/**
		 * The meta object literal for the '{@link org.gecko.searchindex.FacetIndexWriterType <em>Facet Index Writer Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gecko.searchindex.FacetIndexWriterType
		 * @see org.gecko.searchindex.impl.SearchIndexPackageImpl#getFacetIndexWriterType()
		 * @generated
		 */
		EEnum FACET_INDEX_WRITER_TYPE = eINSTANCE.getFacetIndexWriterType();

	}

} //SearchIndexPackage
