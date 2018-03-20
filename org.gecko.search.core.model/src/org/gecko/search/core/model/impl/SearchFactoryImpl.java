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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.gecko.search.core.model.Descriptor;
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
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SearchFactoryImpl extends EFactoryImpl implements SearchFactory {
	/**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public static SearchFactory init() {
    try {
      SearchFactory theSearchFactory = (SearchFactory)EPackage.Registry.INSTANCE.getEFactory(SearchPackage.eNS_URI);
      if (theSearchFactory != null) {
        return theSearchFactory;
      }
    }
    catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new SearchFactoryImpl();
  }

	/**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public SearchFactoryImpl() {
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
      case SearchPackage.INDEX_DATA_CONTAINER: return createIndexDataContainer();
      case SearchPackage.INDEX_DATA: return createIndexData();
      case SearchPackage.DESCRIPTOR: return createDescriptor();
      case SearchPackage.DESCRIPTOR_CONTAINER: return createDescriptorContainer();
      case SearchPackage.INDEX_CONFIGURATION: return createIndexConfiguration();
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
      case SearchPackage.INDEX_DATA_TYPE:
        return createIndexDataTypeFromString(eDataType, initialValue);
      case SearchPackage.DESCRIPTOR_TYPE:
        return createDescriptorTypeFromString(eDataType, initialValue);
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
      case SearchPackage.INDEX_DATA_TYPE:
        return convertIndexDataTypeToString(eDataType, instanceValue);
      case SearchPackage.DESCRIPTOR_TYPE:
        return convertDescriptorTypeToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public IndexDataContainer createIndexDataContainer() {
    IndexDataContainerImpl indexDataContainer = new IndexDataContainerImpl();
    return indexDataContainer;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public IndexData createIndexData() {
    IndexDataImpl indexData = new IndexDataImpl();
    return indexData;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Descriptor createDescriptor() {
    DescriptorImpl descriptor = new DescriptorImpl();
    return descriptor;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public DescriptorContainer createDescriptorContainer() {
    DescriptorContainerImpl descriptorContainer = new DescriptorContainerImpl();
    return descriptorContainer;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public IndexConfiguration createIndexConfiguration() {
    IndexConfigurationImpl indexConfiguration = new IndexConfigurationImpl();
    return indexConfiguration;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public IndexDataType createIndexDataTypeFromString(EDataType eDataType, String initialValue) {
    IndexDataType result = IndexDataType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String convertIndexDataTypeToString(EDataType eDataType, Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public DescriptorType createDescriptorTypeFromString(EDataType eDataType, String initialValue) {
    DescriptorType result = DescriptorType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String convertDescriptorTypeToString(EDataType eDataType, Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public SearchPackage getSearchPackage() {
    return (SearchPackage)getEPackage();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
	@Deprecated
	public static SearchPackage getPackage() {
    return SearchPackage.eINSTANCE;
  }

} //SearchFactoryImpl
