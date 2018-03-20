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
package org.gecko.search.core.model.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.gecko.search.core.model.DescriptorContainer;
import org.gecko.search.core.model.DescriptorType;
import org.gecko.search.core.model.IndexConfiguration;
import org.gecko.search.core.model.IndexData;
import org.gecko.search.core.model.IndexDataContainer;
import org.gecko.search.core.model.IndexDataType;
import org.gecko.search.core.model.SearchFactory;
import org.gecko.search.core.model.SearchPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SearchPackageImpl extends EPackageImpl implements SearchPackage {
	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass indexDataContainerEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass indexDataEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass descriptorEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass descriptorContainerEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass indexConfigurationEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EEnum indexDataTypeEEnum = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EEnum descriptorTypeEEnum = null;

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
   * @see org.gecko.search.core.model.SearchPackage#eNS_URI
   * @see #init()
   * @generated
   */
	private SearchPackageImpl() {
    super(eNS_URI, SearchFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link SearchPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
	public static SearchPackage init() {
    if (isInited) return (SearchPackage)EPackage.Registry.INSTANCE.getEPackage(SearchPackage.eNS_URI);

    // Obtain or create and register package
    SearchPackageImpl theSearchPackage = (SearchPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SearchPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SearchPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theSearchPackage.createPackageContents();

    // Initialize created meta-data
    theSearchPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theSearchPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(SearchPackage.eNS_URI, theSearchPackage);
    return theSearchPackage;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getIndexDataContainer() {
    return indexDataContainerEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getIndexDataContainer_IndexData() {
    return (EReference)indexDataContainerEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getIndexData() {
    return indexDataEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getIndexData_Id() {
    return (EAttribute)indexDataEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getIndexData_Name() {
    return (EAttribute)indexDataEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getIndexData_Description() {
    return (EAttribute)indexDataEClass.getEStructuralFeatures().get(2);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getIndexData_Type() {
    return (EAttribute)indexDataEClass.getEStructuralFeatures().get(3);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getIndexData_Uri() {
    return (EAttribute)indexDataEClass.getEStructuralFeatures().get(4);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getIndexData_WorkspaceProviderId() {
    return (EAttribute)indexDataEClass.getEStructuralFeatures().get(5);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getDescriptor() {
    return descriptorEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getDescriptor_Id() {
    return (EAttribute)descriptorEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getDescriptor_Name() {
    return (EAttribute)descriptorEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getDescriptor_Description() {
    return (EAttribute)descriptorEClass.getEStructuralFeatures().get(2);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getDescriptor_Active() {
    return (EAttribute)descriptorEClass.getEStructuralFeatures().get(3);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getDescriptor_Type() {
    return (EAttribute)descriptorEClass.getEStructuralFeatures().get(4);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getDescriptorContainer() {
    return descriptorContainerEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getDescriptorContainer_Descriptors() {
    return (EAttribute)descriptorContainerEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getDescriptorContainer_QueryDescriptors() {
    return (EReference)descriptorContainerEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getDescriptorContainer_IndexDescriptors() {
    return (EReference)descriptorContainerEClass.getEStructuralFeatures().get(2);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getDescriptorContainer_ResultDescriptors() {
    return (EReference)descriptorContainerEClass.getEStructuralFeatures().get(3);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getIndexConfiguration() {
    return indexConfigurationEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getIndexConfiguration_Id() {
    return (EAttribute)indexConfigurationEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getIndexConfiguration_Name() {
    return (EAttribute)indexConfigurationEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getIndexConfiguration_Description() {
    return (EAttribute)indexConfigurationEClass.getEStructuralFeatures().get(2);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getIndexConfiguration_Active() {
    return (EAttribute)indexConfigurationEClass.getEStructuralFeatures().get(3);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getIndexConfiguration_IndexData() {
    return (EReference)indexConfigurationEClass.getEStructuralFeatures().get(4);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getIndexConfiguration_IndexDescriptors() {
    return (EReference)indexConfigurationEClass.getEStructuralFeatures().get(5);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getIndexConfiguration_QueryDescriptors() {
    return (EReference)indexConfigurationEClass.getEStructuralFeatures().get(6);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EReference getIndexConfiguration_ResultDescriptors() {
    return (EReference)indexConfigurationEClass.getEStructuralFeatures().get(7);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EEnum getIndexDataType() {
    return indexDataTypeEEnum;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EEnum getDescriptorType() {
    return descriptorTypeEEnum;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public SearchFactory getSearchFactory() {
    return (SearchFactory)getEFactoryInstance();
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
    indexDataContainerEClass = createEClass(INDEX_DATA_CONTAINER);
    createEReference(indexDataContainerEClass, INDEX_DATA_CONTAINER__INDEX_DATA);

    indexDataEClass = createEClass(INDEX_DATA);
    createEAttribute(indexDataEClass, INDEX_DATA__ID);
    createEAttribute(indexDataEClass, INDEX_DATA__NAME);
    createEAttribute(indexDataEClass, INDEX_DATA__DESCRIPTION);
    createEAttribute(indexDataEClass, INDEX_DATA__TYPE);
    createEAttribute(indexDataEClass, INDEX_DATA__URI);
    createEAttribute(indexDataEClass, INDEX_DATA__WORKSPACE_PROVIDER_ID);

    descriptorEClass = createEClass(DESCRIPTOR);
    createEAttribute(descriptorEClass, DESCRIPTOR__ID);
    createEAttribute(descriptorEClass, DESCRIPTOR__NAME);
    createEAttribute(descriptorEClass, DESCRIPTOR__DESCRIPTION);
    createEAttribute(descriptorEClass, DESCRIPTOR__ACTIVE);
    createEAttribute(descriptorEClass, DESCRIPTOR__TYPE);

    descriptorContainerEClass = createEClass(DESCRIPTOR_CONTAINER);
    createEAttribute(descriptorContainerEClass, DESCRIPTOR_CONTAINER__DESCRIPTORS);
    createEReference(descriptorContainerEClass, DESCRIPTOR_CONTAINER__QUERY_DESCRIPTORS);
    createEReference(descriptorContainerEClass, DESCRIPTOR_CONTAINER__INDEX_DESCRIPTORS);
    createEReference(descriptorContainerEClass, DESCRIPTOR_CONTAINER__RESULT_DESCRIPTORS);

    indexConfigurationEClass = createEClass(INDEX_CONFIGURATION);
    createEAttribute(indexConfigurationEClass, INDEX_CONFIGURATION__ID);
    createEAttribute(indexConfigurationEClass, INDEX_CONFIGURATION__NAME);
    createEAttribute(indexConfigurationEClass, INDEX_CONFIGURATION__DESCRIPTION);
    createEAttribute(indexConfigurationEClass, INDEX_CONFIGURATION__ACTIVE);
    createEReference(indexConfigurationEClass, INDEX_CONFIGURATION__INDEX_DATA);
    createEReference(indexConfigurationEClass, INDEX_CONFIGURATION__INDEX_DESCRIPTORS);
    createEReference(indexConfigurationEClass, INDEX_CONFIGURATION__QUERY_DESCRIPTORS);
    createEReference(indexConfigurationEClass, INDEX_CONFIGURATION__RESULT_DESCRIPTORS);

    // Create enums
    indexDataTypeEEnum = createEEnum(INDEX_DATA_TYPE);
    descriptorTypeEEnum = createEEnum(DESCRIPTOR_TYPE);
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

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes

    // Initialize classes, features, and operations; add parameters
    initEClass(indexDataContainerEClass, IndexDataContainer.class, "IndexDataContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getIndexDataContainer_IndexData(), this.getIndexData(), null, "indexData", null, 0, -1, IndexDataContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    getIndexDataContainer_IndexData().getEKeys().add(this.getIndexData_Id());

    initEClass(indexDataEClass, IndexData.class, "IndexData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getIndexData_Id(), ecorePackage.getEString(), "id", null, 1, 1, IndexData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getIndexData_Name(), ecorePackage.getEString(), "name", null, 1, 1, IndexData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getIndexData_Description(), ecorePackage.getEString(), "description", null, 0, 1, IndexData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getIndexData_Type(), this.getIndexDataType(), "type", null, 1, 1, IndexData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getIndexData_Uri(), ecorePackage.getEString(), "uri", null, 1, 1, IndexData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getIndexData_WorkspaceProviderId(), ecorePackage.getEString(), "workspaceProviderId", null, 1, 1, IndexData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(descriptorEClass, org.gecko.search.core.model.Descriptor.class, "Descriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDescriptor_Id(), ecorePackage.getEString(), "id", null, 1, 1, org.gecko.search.core.model.Descriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getDescriptor_Name(), ecorePackage.getEString(), "name", null, 1, 1, org.gecko.search.core.model.Descriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getDescriptor_Description(), ecorePackage.getEString(), "description", null, 0, 1, org.gecko.search.core.model.Descriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getDescriptor_Active(), ecorePackage.getEBoolean(), "active", "true", 1, 1, org.gecko.search.core.model.Descriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getDescriptor_Type(), this.getDescriptorType(), "type", null, 1, 1, org.gecko.search.core.model.Descriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(descriptorContainerEClass, DescriptorContainer.class, "DescriptorContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDescriptorContainer_Descriptors(), ecorePackage.getEFeatureMapEntry(), "descriptors", null, 0, -1, DescriptorContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDescriptorContainer_QueryDescriptors(), this.getDescriptor(), null, "queryDescriptors", null, 0, -1, DescriptorContainer.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
    initEReference(getDescriptorContainer_IndexDescriptors(), this.getDescriptor(), null, "indexDescriptors", null, 0, -1, DescriptorContainer.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
    initEReference(getDescriptorContainer_ResultDescriptors(), this.getDescriptor(), null, "resultDescriptors", null, 0, -1, DescriptorContainer.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

    initEClass(indexConfigurationEClass, IndexConfiguration.class, "IndexConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getIndexConfiguration_Id(), ecorePackage.getEString(), "id", null, 1, 1, IndexConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getIndexConfiguration_Name(), ecorePackage.getEString(), "name", null, 1, 1, IndexConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getIndexConfiguration_Description(), ecorePackage.getEString(), "description", null, 0, 1, IndexConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getIndexConfiguration_Active(), ecorePackage.getEBoolean(), "active", "true", 1, 1, IndexConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIndexConfiguration_IndexData(), this.getIndexData(), null, "indexData", null, 1, 1, IndexConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIndexConfiguration_IndexDescriptors(), this.getDescriptor(), null, "indexDescriptors", null, 0, -1, IndexConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    getIndexConfiguration_IndexDescriptors().getEKeys().add(this.getDescriptor_Id());
    initEReference(getIndexConfiguration_QueryDescriptors(), this.getDescriptor(), null, "queryDescriptors", null, 0, -1, IndexConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    getIndexConfiguration_QueryDescriptors().getEKeys().add(this.getDescriptor_Id());
    initEReference(getIndexConfiguration_ResultDescriptors(), this.getDescriptor(), null, "resultDescriptors", null, 0, -1, IndexConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    getIndexConfiguration_ResultDescriptors().getEKeys().add(this.getDescriptor_Id());

    // Initialize enums and add enum literals
    initEEnum(indexDataTypeEEnum, IndexDataType.class, "IndexDataType");
    addEEnumLiteral(indexDataTypeEEnum, IndexDataType.FILE_SYSTEM);
    addEEnumLiteral(indexDataTypeEEnum, IndexDataType.MMAP);
    addEEnumLiteral(indexDataTypeEEnum, IndexDataType.RAM);
    addEEnumLiteral(indexDataTypeEEnum, IndexDataType.MONGO_DB);

    initEEnum(descriptorTypeEEnum, DescriptorType.class, "DescriptorType");
    addEEnumLiteral(descriptorTypeEEnum, DescriptorType.INDEX);
    addEEnumLiteral(descriptorTypeEEnum, DescriptorType.RESULT);
    addEEnumLiteral(descriptorTypeEEnum, DescriptorType.QUERY);

    // Create resource
    createResource(eNS_URI);

    // Create annotations
    // http:///org/eclipse/emf/ecore/util/ExtendedMetaData
    createExtendedMetaDataAnnotations();
  }

	/**
   * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected void createExtendedMetaDataAnnotations() {
    String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";	
    addAnnotation
      (getDescriptorContainer_Descriptors(), 
       source, 
       new String[] {
       "kind", "group"
       });	
    addAnnotation
      (getDescriptorContainer_QueryDescriptors(), 
       source, 
       new String[] {
       "group", "#descriptors",
       "kind", "QUERY"
       });	
    addAnnotation
      (getDescriptorContainer_IndexDescriptors(), 
       source, 
       new String[] {
       "group", "#descriptors",
       "kind", "INDEX"
       });	
    addAnnotation
      (getDescriptorContainer_ResultDescriptors(), 
       source, 
       new String[] {
       "group", "#descriptors",
       "kind", "RESULT"
       });
  }

} //SearchPackageImpl
