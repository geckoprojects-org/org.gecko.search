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
package org.gecko.search.core.registry.impl;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.gecko.emf.util.registry.DefaultRegistry;
import org.gecko.emf.util.registry.RegistryIntializer;
import org.gecko.search.core.model.IndexData;
import org.gecko.search.core.model.IndexDataContainer;
import org.gecko.search.core.model.SearchFactory;
import org.gecko.search.core.model.SearchPackage;
import org.gecko.search.core.model.util.SearchResourceFactoryImpl;
import org.gecko.search.core.registry.IndexDataRegistry;
import org.gecko.util.uriprovider.LocationUriProvider;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;


/**
 * Registry for the index data 
 * @author Mark Hoffmann
 * @since 08.09.2014
 */
@Component
public class DefaultIndexDataRegistry extends DefaultRegistry<IndexData, IndexDataContainer> implements IndexDataRegistry {

	/**
	 * Sets the {@link LocationUriProvider} instance
	 * @param uriProvider the instance to set
	 */
	@Reference(cardinality = ReferenceCardinality.MANDATORY, policy = ReferencePolicy.STATIC)
	public void setLocationUriProvider(LocationUriProvider uriProvider) {
		super.setLocationUriProvider(uriProvider);
	}
	
	/**
	 * Adds a new {@link RegistryIntializer} to the registry
	 * @param initializer the initializer to add
	 */
	@Reference(cardinality=ReferenceCardinality.MULTIPLE, unbind = "removeInitializer")
	public void addInitializer(RegistryIntializer<IndexData> initializer) {
		super.addInitializer(initializer);
	}
	
	/* (non-Javadoc)
	 * @see de.dim.search.core.registry.IndexDataRegistry#registerIndexData(de.dim.search.IndexData)
	 */
	@Override
	public boolean registerIndexData(IndexData indexData) {
		return registerObject(indexData);
	}

	/* (non-Javadoc)
	 * @see de.dim.search.core.registry.IndexDataRegistry#unregisterIndexData(de.dim.search.IndexData)
	 */
	@Override
	public boolean unregisterIndexData(IndexData indexData) {
		return unregisterObject(indexData);
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.core.registry.IndexDataRegistry#unregisterIndexDataById(java.lang.String)
	 */
	@Override
	public boolean unregisterIndexDataById(String id) {
		IndexData indexData = getIndexDataById(id);
		return unregisterIndexData(indexData);
	}

	/* (non-Javadoc)
	 * @see de.dim.search.core.registry.IndexDataRegistry#getIndexDataById(java.lang.String)
	 */
	@Override
	public IndexData getIndexDataById(String id) {
		if (id == null) {
			return null;
		}
		for (IndexData indexData : getRegistry().getIndexData()) {
			if (id.equals(indexData.getId())) {
				return indexData;
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see de.dim.search.core.registry.IndexDataRegistry#getIndexDataByName(java.lang.String)
	 */
	@Override
	public List<IndexData> getIndexDataByName(String name) {
		List<IndexData> resultList = new LinkedList<IndexData>();
		if (name == null) {
			return resultList;
		}
		initRegistry();
		for (IndexData indexData : getRegistry().getIndexData()) {
			if (name.equals(indexData.getName())) {
				resultList.add(indexData);
			}
		}
		return resultList;
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.utilities.registry.DefaultRegistry#addToRegistry(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public boolean addToRegistry(IndexDataContainer registry, IndexData object) {
		if (object == null || 
				object.getId() == null || 
						object.getUri() == null) {
			return false;
		}
		boolean needAdd = needsAddedToRegistry(object);
		if (needAdd) {
			return registry.getIndexData().add(object);
		} else {
			return needAdd;
		}
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.utilities.registry.DefaultRegistry#removeFromRegistry(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public boolean removeFromRegistry(IndexDataContainer registry, IndexData object) {
		if (object == null) {
			return false;
		}
		EObject eObject = getRegistry().eResource().getEObject(object.getId());
		return registry.getIndexData().remove(eObject);
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.utilities.registry.DefaultRegistry#getAllObject(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	protected List<IndexData> getAllObject(IndexDataContainer registry) {
		return registry == null ? null : registry.getIndexData();
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.utilities.registry.DefaultRegistry#initializeResourceSet(org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	@Override
	protected void initializeResourceSet(ResourceSet resourceSet) {
		// we have no OSGi environment
		if (System.getProperty("osgi.os") == null) {
			resourceSet.getPackageRegistry().put(SearchPackage.eNS_URI, SearchPackage.eINSTANCE);
			resourceSet.getResourceFactoryRegistry().getContentTypeToFactoryMap().put(SearchPackage.eCONTENT_TYPE, new SearchResourceFactoryImpl());
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("search", new SearchResourceFactoryImpl());
		}
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.utilities.registry.DefaultRegistry#createEmptyRegistryInstance()
	 */
	@Override
	protected IndexDataContainer createEmptyRegistryInstance() {
		return SearchFactory.eINSTANCE.createIndexDataContainer();
	}

	/**
	 * Because we have different {@link ResourceSet}s, the {@link EObject}s are not of the same instance.
	 * Therefore we have to remove any old {@link IndexDescriptor} with the given ID, but only if it has changed
	 * @param descriptor the Descriptor that will be replaced, if it has changed
	 * @return the object that was returned
	 */
	private boolean needsAddedToRegistry(IndexData descriptor) {
		if (descriptor == null || descriptor.getId() == null) {
			return false;
		}
		EObject eObject = getRegistry().eResource().getEObject(descriptor.getId());
		if (EcoreUtil.equals(eObject, descriptor)) {
			return false;
		} else {
			return eObject == null ? true : getRegistry().getIndexData().remove(eObject);
		}
	}

}
