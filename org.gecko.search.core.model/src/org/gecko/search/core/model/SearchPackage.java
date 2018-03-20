/**
 * Copyright (c) 2014 Data In Motion and others.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Data In Motion - initial API and implementation
 */
package org.gecko.search.core.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.gecko.search.core.model.SearchFactory
 * @model kind="package"
 * @generated
 */
public interface SearchPackage extends EPackage {
	/**
   * The package name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNAME = "search";

	/**
   * The package namespace URI.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNS_URI = "http://data-in-motion.biz/search/1.0";

	/**
   * The package namespace name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNS_PREFIX = "search";

	/**
   * The package content type ID.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eCONTENT_TYPE = "search#1.0";

	/**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	SearchPackage eINSTANCE = org.gecko.search.core.model.impl.SearchPackageImpl.init();

	/**
   * The meta object id for the '{@link org.gecko.search.core.model.impl.IndexDataContainerImpl <em>Index Data Container</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.gecko.search.core.model.impl.IndexDataContainerImpl
   * @see org.gecko.search.core.model.impl.SearchPackageImpl#getIndexDataContainer()
   * @generated
   */
	int INDEX_DATA_CONTAINER = 0;

	/**
   * The feature id for the '<em><b>Index Data</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int INDEX_DATA_CONTAINER__INDEX_DATA = 0;

	/**
   * The number of structural features of the '<em>Index Data Container</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int INDEX_DATA_CONTAINER_FEATURE_COUNT = 1;

	/**
   * The number of operations of the '<em>Index Data Container</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int INDEX_DATA_CONTAINER_OPERATION_COUNT = 0;

	/**
   * The meta object id for the '{@link org.gecko.search.core.model.impl.IndexDataImpl <em>Index Data</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.gecko.search.core.model.impl.IndexDataImpl
   * @see org.gecko.search.core.model.impl.SearchPackageImpl#getIndexData()
   * @generated
   */
	int INDEX_DATA = 1;

	/**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int INDEX_DATA__ID = 0;

	/**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int INDEX_DATA__NAME = 1;

	/**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int INDEX_DATA__DESCRIPTION = 2;

	/**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int INDEX_DATA__TYPE = 3;

	/**
   * The feature id for the '<em><b>Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int INDEX_DATA__URI = 4;

	/**
   * The feature id for the '<em><b>Workspace Provider Id</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int INDEX_DATA__WORKSPACE_PROVIDER_ID = 5;

	/**
   * The number of structural features of the '<em>Index Data</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int INDEX_DATA_FEATURE_COUNT = 6;

	/**
   * The number of operations of the '<em>Index Data</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int INDEX_DATA_OPERATION_COUNT = 0;

	/**
   * The meta object id for the '{@link org.gecko.search.core.model.impl.DescriptorImpl <em>Descriptor</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.gecko.search.core.model.impl.DescriptorImpl
   * @see org.gecko.search.core.model.impl.SearchPackageImpl#getDescriptor()
   * @generated
   */
	int DESCRIPTOR = 2;

	/**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int DESCRIPTOR__ID = 0;

	/**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int DESCRIPTOR__NAME = 1;

	/**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int DESCRIPTOR__DESCRIPTION = 2;

	/**
   * The feature id for the '<em><b>Active</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int DESCRIPTOR__ACTIVE = 3;

	/**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int DESCRIPTOR__TYPE = 4;

	/**
   * The number of structural features of the '<em>Descriptor</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int DESCRIPTOR_FEATURE_COUNT = 5;

	/**
   * The number of operations of the '<em>Descriptor</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int DESCRIPTOR_OPERATION_COUNT = 0;

	/**
   * The meta object id for the '{@link org.gecko.search.core.model.impl.DescriptorContainerImpl <em>Descriptor Container</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.gecko.search.core.model.impl.DescriptorContainerImpl
   * @see org.gecko.search.core.model.impl.SearchPackageImpl#getDescriptorContainer()
   * @generated
   */
	int DESCRIPTOR_CONTAINER = 3;

	/**
   * The feature id for the '<em><b>Descriptors</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int DESCRIPTOR_CONTAINER__DESCRIPTORS = 0;

	/**
   * The feature id for the '<em><b>Query Descriptors</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int DESCRIPTOR_CONTAINER__QUERY_DESCRIPTORS = 1;

	/**
   * The feature id for the '<em><b>Index Descriptors</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int DESCRIPTOR_CONTAINER__INDEX_DESCRIPTORS = 2;

	/**
   * The feature id for the '<em><b>Result Descriptors</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int DESCRIPTOR_CONTAINER__RESULT_DESCRIPTORS = 3;

	/**
   * The number of structural features of the '<em>Descriptor Container</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int DESCRIPTOR_CONTAINER_FEATURE_COUNT = 4;

	/**
   * The number of operations of the '<em>Descriptor Container</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int DESCRIPTOR_CONTAINER_OPERATION_COUNT = 0;

	/**
   * The meta object id for the '{@link org.gecko.search.core.model.impl.IndexConfigurationImpl <em>Index Configuration</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.gecko.search.core.model.impl.IndexConfigurationImpl
   * @see org.gecko.search.core.model.impl.SearchPackageImpl#getIndexConfiguration()
   * @generated
   */
	int INDEX_CONFIGURATION = 4;

	/**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int INDEX_CONFIGURATION__ID = 0;

	/**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int INDEX_CONFIGURATION__NAME = 1;

	/**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int INDEX_CONFIGURATION__DESCRIPTION = 2;

	/**
   * The feature id for the '<em><b>Active</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int INDEX_CONFIGURATION__ACTIVE = 3;

	/**
   * The feature id for the '<em><b>Index Data</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int INDEX_CONFIGURATION__INDEX_DATA = 4;

	/**
   * The feature id for the '<em><b>Index Descriptors</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int INDEX_CONFIGURATION__INDEX_DESCRIPTORS = 5;

	/**
   * The feature id for the '<em><b>Query Descriptors</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int INDEX_CONFIGURATION__QUERY_DESCRIPTORS = 6;

	/**
   * The feature id for the '<em><b>Result Descriptors</b></em>' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int INDEX_CONFIGURATION__RESULT_DESCRIPTORS = 7;

	/**
   * The number of structural features of the '<em>Index Configuration</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int INDEX_CONFIGURATION_FEATURE_COUNT = 8;

	/**
   * The number of operations of the '<em>Index Configuration</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int INDEX_CONFIGURATION_OPERATION_COUNT = 0;

	/**
   * The meta object id for the '{@link org.gecko.search.core.model.IndexDataType <em>Index Data Type</em>}' enum.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.gecko.search.core.model.IndexDataType
   * @see org.gecko.search.core.model.impl.SearchPackageImpl#getIndexDataType()
   * @generated
   */
	int INDEX_DATA_TYPE = 5;

	/**
   * The meta object id for the '{@link org.gecko.search.core.model.DescriptorType <em>Descriptor Type</em>}' enum.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.gecko.search.core.model.DescriptorType
   * @see org.gecko.search.core.model.impl.SearchPackageImpl#getDescriptorType()
   * @generated
   */
	int DESCRIPTOR_TYPE = 6;


	/**
   * Returns the meta object for class '{@link org.gecko.search.core.model.IndexDataContainer <em>Index Data Container</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Index Data Container</em>'.
   * @see org.gecko.search.core.model.IndexDataContainer
   * @generated
   */
	EClass getIndexDataContainer();

	/**
   * Returns the meta object for the containment reference list '{@link org.gecko.search.core.model.IndexDataContainer#getIndexData <em>Index Data</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Index Data</em>'.
   * @see org.gecko.search.core.model.IndexDataContainer#getIndexData()
   * @see #getIndexDataContainer()
   * @generated
   */
	EReference getIndexDataContainer_IndexData();

	/**
   * Returns the meta object for class '{@link org.gecko.search.core.model.IndexData <em>Index Data</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Index Data</em>'.
   * @see org.gecko.search.core.model.IndexData
   * @generated
   */
	EClass getIndexData();

	/**
   * Returns the meta object for the attribute '{@link org.gecko.search.core.model.IndexData#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see org.gecko.search.core.model.IndexData#getId()
   * @see #getIndexData()
   * @generated
   */
	EAttribute getIndexData_Id();

	/**
   * Returns the meta object for the attribute '{@link org.gecko.search.core.model.IndexData#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.gecko.search.core.model.IndexData#getName()
   * @see #getIndexData()
   * @generated
   */
	EAttribute getIndexData_Name();

	/**
   * Returns the meta object for the attribute '{@link org.gecko.search.core.model.IndexData#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see org.gecko.search.core.model.IndexData#getDescription()
   * @see #getIndexData()
   * @generated
   */
	EAttribute getIndexData_Description();

	/**
   * Returns the meta object for the attribute '{@link org.gecko.search.core.model.IndexData#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see org.gecko.search.core.model.IndexData#getType()
   * @see #getIndexData()
   * @generated
   */
	EAttribute getIndexData_Type();

	/**
   * Returns the meta object for the attribute '{@link org.gecko.search.core.model.IndexData#getUri <em>Uri</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Uri</em>'.
   * @see org.gecko.search.core.model.IndexData#getUri()
   * @see #getIndexData()
   * @generated
   */
	EAttribute getIndexData_Uri();

	/**
   * Returns the meta object for the attribute '{@link org.gecko.search.core.model.IndexData#getWorkspaceProviderId <em>Workspace Provider Id</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Workspace Provider Id</em>'.
   * @see org.gecko.search.core.model.IndexData#getWorkspaceProviderId()
   * @see #getIndexData()
   * @generated
   */
	EAttribute getIndexData_WorkspaceProviderId();

	/**
   * Returns the meta object for class '{@link org.gecko.search.core.model.Descriptor <em>Descriptor</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Descriptor</em>'.
   * @see org.gecko.search.core.model.Descriptor
   * @generated
   */
	EClass getDescriptor();

	/**
   * Returns the meta object for the attribute '{@link org.gecko.search.core.model.Descriptor#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see org.gecko.search.core.model.Descriptor#getId()
   * @see #getDescriptor()
   * @generated
   */
	EAttribute getDescriptor_Id();

	/**
   * Returns the meta object for the attribute '{@link org.gecko.search.core.model.Descriptor#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.gecko.search.core.model.Descriptor#getName()
   * @see #getDescriptor()
   * @generated
   */
	EAttribute getDescriptor_Name();

	/**
   * Returns the meta object for the attribute '{@link org.gecko.search.core.model.Descriptor#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see org.gecko.search.core.model.Descriptor#getDescription()
   * @see #getDescriptor()
   * @generated
   */
	EAttribute getDescriptor_Description();

	/**
   * Returns the meta object for the attribute '{@link org.gecko.search.core.model.Descriptor#isActive <em>Active</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Active</em>'.
   * @see org.gecko.search.core.model.Descriptor#isActive()
   * @see #getDescriptor()
   * @generated
   */
	EAttribute getDescriptor_Active();

	/**
   * Returns the meta object for the attribute '{@link org.gecko.search.core.model.Descriptor#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see org.gecko.search.core.model.Descriptor#getType()
   * @see #getDescriptor()
   * @generated
   */
	EAttribute getDescriptor_Type();

	/**
   * Returns the meta object for class '{@link org.gecko.search.core.model.DescriptorContainer <em>Descriptor Container</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Descriptor Container</em>'.
   * @see org.gecko.search.core.model.DescriptorContainer
   * @generated
   */
	EClass getDescriptorContainer();

	/**
   * Returns the meta object for the attribute list '{@link org.gecko.search.core.model.DescriptorContainer#getDescriptors <em>Descriptors</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Descriptors</em>'.
   * @see org.gecko.search.core.model.DescriptorContainer#getDescriptors()
   * @see #getDescriptorContainer()
   * @generated
   */
	EAttribute getDescriptorContainer_Descriptors();

	/**
   * Returns the meta object for the reference list '{@link org.gecko.search.core.model.DescriptorContainer#getQueryDescriptors <em>Query Descriptors</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Query Descriptors</em>'.
   * @see org.gecko.search.core.model.DescriptorContainer#getQueryDescriptors()
   * @see #getDescriptorContainer()
   * @generated
   */
	EReference getDescriptorContainer_QueryDescriptors();

	/**
   * Returns the meta object for the reference list '{@link org.gecko.search.core.model.DescriptorContainer#getIndexDescriptors <em>Index Descriptors</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Index Descriptors</em>'.
   * @see org.gecko.search.core.model.DescriptorContainer#getIndexDescriptors()
   * @see #getDescriptorContainer()
   * @generated
   */
	EReference getDescriptorContainer_IndexDescriptors();

	/**
   * Returns the meta object for the reference list '{@link org.gecko.search.core.model.DescriptorContainer#getResultDescriptors <em>Result Descriptors</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Result Descriptors</em>'.
   * @see org.gecko.search.core.model.DescriptorContainer#getResultDescriptors()
   * @see #getDescriptorContainer()
   * @generated
   */
	EReference getDescriptorContainer_ResultDescriptors();

	/**
   * Returns the meta object for class '{@link org.gecko.search.core.model.IndexConfiguration <em>Index Configuration</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Index Configuration</em>'.
   * @see org.gecko.search.core.model.IndexConfiguration
   * @generated
   */
	EClass getIndexConfiguration();

	/**
   * Returns the meta object for the attribute '{@link org.gecko.search.core.model.IndexConfiguration#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see org.gecko.search.core.model.IndexConfiguration#getId()
   * @see #getIndexConfiguration()
   * @generated
   */
	EAttribute getIndexConfiguration_Id();

	/**
   * Returns the meta object for the attribute '{@link org.gecko.search.core.model.IndexConfiguration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.gecko.search.core.model.IndexConfiguration#getName()
   * @see #getIndexConfiguration()
   * @generated
   */
	EAttribute getIndexConfiguration_Name();

	/**
   * Returns the meta object for the attribute '{@link org.gecko.search.core.model.IndexConfiguration#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see org.gecko.search.core.model.IndexConfiguration#getDescription()
   * @see #getIndexConfiguration()
   * @generated
   */
	EAttribute getIndexConfiguration_Description();

	/**
   * Returns the meta object for the attribute '{@link org.gecko.search.core.model.IndexConfiguration#isActive <em>Active</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Active</em>'.
   * @see org.gecko.search.core.model.IndexConfiguration#isActive()
   * @see #getIndexConfiguration()
   * @generated
   */
	EAttribute getIndexConfiguration_Active();

	/**
   * Returns the meta object for the reference '{@link org.gecko.search.core.model.IndexConfiguration#getIndexData <em>Index Data</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Index Data</em>'.
   * @see org.gecko.search.core.model.IndexConfiguration#getIndexData()
   * @see #getIndexConfiguration()
   * @generated
   */
	EReference getIndexConfiguration_IndexData();

	/**
   * Returns the meta object for the reference list '{@link org.gecko.search.core.model.IndexConfiguration#getIndexDescriptors <em>Index Descriptors</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Index Descriptors</em>'.
   * @see org.gecko.search.core.model.IndexConfiguration#getIndexDescriptors()
   * @see #getIndexConfiguration()
   * @generated
   */
	EReference getIndexConfiguration_IndexDescriptors();

	/**
   * Returns the meta object for the reference list '{@link org.gecko.search.core.model.IndexConfiguration#getQueryDescriptors <em>Query Descriptors</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Query Descriptors</em>'.
   * @see org.gecko.search.core.model.IndexConfiguration#getQueryDescriptors()
   * @see #getIndexConfiguration()
   * @generated
   */
	EReference getIndexConfiguration_QueryDescriptors();

	/**
   * Returns the meta object for the reference list '{@link org.gecko.search.core.model.IndexConfiguration#getResultDescriptors <em>Result Descriptors</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Result Descriptors</em>'.
   * @see org.gecko.search.core.model.IndexConfiguration#getResultDescriptors()
   * @see #getIndexConfiguration()
   * @generated
   */
	EReference getIndexConfiguration_ResultDescriptors();

	/**
   * Returns the meta object for enum '{@link org.gecko.search.core.model.IndexDataType <em>Index Data Type</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Index Data Type</em>'.
   * @see org.gecko.search.core.model.IndexDataType
   * @generated
   */
	EEnum getIndexDataType();

	/**
   * Returns the meta object for enum '{@link org.gecko.search.core.model.DescriptorType <em>Descriptor Type</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Descriptor Type</em>'.
   * @see org.gecko.search.core.model.DescriptorType
   * @generated
   */
	EEnum getDescriptorType();

	/**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
	SearchFactory getSearchFactory();

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
     * The meta object literal for the '{@link org.gecko.search.core.model.impl.IndexDataContainerImpl <em>Index Data Container</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.gecko.search.core.model.impl.IndexDataContainerImpl
     * @see org.gecko.search.core.model.impl.SearchPackageImpl#getIndexDataContainer()
     * @generated
     */
		EClass INDEX_DATA_CONTAINER = eINSTANCE.getIndexDataContainer();

		/**
     * The meta object literal for the '<em><b>Index Data</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference INDEX_DATA_CONTAINER__INDEX_DATA = eINSTANCE.getIndexDataContainer_IndexData();

		/**
     * The meta object literal for the '{@link org.gecko.search.core.model.impl.IndexDataImpl <em>Index Data</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.gecko.search.core.model.impl.IndexDataImpl
     * @see org.gecko.search.core.model.impl.SearchPackageImpl#getIndexData()
     * @generated
     */
		EClass INDEX_DATA = eINSTANCE.getIndexData();

		/**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute INDEX_DATA__ID = eINSTANCE.getIndexData_Id();

		/**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute INDEX_DATA__NAME = eINSTANCE.getIndexData_Name();

		/**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute INDEX_DATA__DESCRIPTION = eINSTANCE.getIndexData_Description();

		/**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute INDEX_DATA__TYPE = eINSTANCE.getIndexData_Type();

		/**
     * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute INDEX_DATA__URI = eINSTANCE.getIndexData_Uri();

		/**
     * The meta object literal for the '<em><b>Workspace Provider Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute INDEX_DATA__WORKSPACE_PROVIDER_ID = eINSTANCE.getIndexData_WorkspaceProviderId();

		/**
     * The meta object literal for the '{@link org.gecko.search.core.model.impl.DescriptorImpl <em>Descriptor</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.gecko.search.core.model.impl.DescriptorImpl
     * @see org.gecko.search.core.model.impl.SearchPackageImpl#getDescriptor()
     * @generated
     */
		EClass DESCRIPTOR = eINSTANCE.getDescriptor();

		/**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute DESCRIPTOR__ID = eINSTANCE.getDescriptor_Id();

		/**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute DESCRIPTOR__NAME = eINSTANCE.getDescriptor_Name();

		/**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute DESCRIPTOR__DESCRIPTION = eINSTANCE.getDescriptor_Description();

		/**
     * The meta object literal for the '<em><b>Active</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute DESCRIPTOR__ACTIVE = eINSTANCE.getDescriptor_Active();

		/**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute DESCRIPTOR__TYPE = eINSTANCE.getDescriptor_Type();

		/**
     * The meta object literal for the '{@link org.gecko.search.core.model.impl.DescriptorContainerImpl <em>Descriptor Container</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.gecko.search.core.model.impl.DescriptorContainerImpl
     * @see org.gecko.search.core.model.impl.SearchPackageImpl#getDescriptorContainer()
     * @generated
     */
		EClass DESCRIPTOR_CONTAINER = eINSTANCE.getDescriptorContainer();

		/**
     * The meta object literal for the '<em><b>Descriptors</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute DESCRIPTOR_CONTAINER__DESCRIPTORS = eINSTANCE.getDescriptorContainer_Descriptors();

		/**
     * The meta object literal for the '<em><b>Query Descriptors</b></em>' reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference DESCRIPTOR_CONTAINER__QUERY_DESCRIPTORS = eINSTANCE.getDescriptorContainer_QueryDescriptors();

		/**
     * The meta object literal for the '<em><b>Index Descriptors</b></em>' reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference DESCRIPTOR_CONTAINER__INDEX_DESCRIPTORS = eINSTANCE.getDescriptorContainer_IndexDescriptors();

		/**
     * The meta object literal for the '<em><b>Result Descriptors</b></em>' reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference DESCRIPTOR_CONTAINER__RESULT_DESCRIPTORS = eINSTANCE.getDescriptorContainer_ResultDescriptors();

		/**
     * The meta object literal for the '{@link org.gecko.search.core.model.impl.IndexConfigurationImpl <em>Index Configuration</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.gecko.search.core.model.impl.IndexConfigurationImpl
     * @see org.gecko.search.core.model.impl.SearchPackageImpl#getIndexConfiguration()
     * @generated
     */
		EClass INDEX_CONFIGURATION = eINSTANCE.getIndexConfiguration();

		/**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute INDEX_CONFIGURATION__ID = eINSTANCE.getIndexConfiguration_Id();

		/**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute INDEX_CONFIGURATION__NAME = eINSTANCE.getIndexConfiguration_Name();

		/**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute INDEX_CONFIGURATION__DESCRIPTION = eINSTANCE.getIndexConfiguration_Description();

		/**
     * The meta object literal for the '<em><b>Active</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute INDEX_CONFIGURATION__ACTIVE = eINSTANCE.getIndexConfiguration_Active();

		/**
     * The meta object literal for the '<em><b>Index Data</b></em>' reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference INDEX_CONFIGURATION__INDEX_DATA = eINSTANCE.getIndexConfiguration_IndexData();

		/**
     * The meta object literal for the '<em><b>Index Descriptors</b></em>' reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference INDEX_CONFIGURATION__INDEX_DESCRIPTORS = eINSTANCE.getIndexConfiguration_IndexDescriptors();

		/**
     * The meta object literal for the '<em><b>Query Descriptors</b></em>' reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference INDEX_CONFIGURATION__QUERY_DESCRIPTORS = eINSTANCE.getIndexConfiguration_QueryDescriptors();

		/**
     * The meta object literal for the '<em><b>Result Descriptors</b></em>' reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference INDEX_CONFIGURATION__RESULT_DESCRIPTORS = eINSTANCE.getIndexConfiguration_ResultDescriptors();

		/**
     * The meta object literal for the '{@link org.gecko.search.core.model.IndexDataType <em>Index Data Type</em>}' enum.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.gecko.search.core.model.IndexDataType
     * @see org.gecko.search.core.model.impl.SearchPackageImpl#getIndexDataType()
     * @generated
     */
		EEnum INDEX_DATA_TYPE = eINSTANCE.getIndexDataType();

		/**
     * The meta object literal for the '{@link org.gecko.search.core.model.DescriptorType <em>Descriptor Type</em>}' enum.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.gecko.search.core.model.DescriptorType
     * @see org.gecko.search.core.model.impl.SearchPackageImpl#getDescriptorType()
     * @generated
     */
		EEnum DESCRIPTOR_TYPE = eINSTANCE.getDescriptorType();

	}

} //SearchPackage
