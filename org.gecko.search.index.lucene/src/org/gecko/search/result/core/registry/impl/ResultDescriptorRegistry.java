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
package org.gecko.search.result.core.registry.impl;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.gecko.search.core.provider.ISearchWorkspaceProvider;
import org.gecko.search.result.core.registry.IResultDescriptorInitializer;
import org.gecko.search.result.core.registry.IResultDescriptorRegistry;
import org.gecko.searchindex.IndexDescriptor;
import org.gecko.searchresult.ResultDescriptor;
import org.gecko.searchresult.ResultDescriptorContainer;
import org.gecko.searchresult.SearchResultFactory;
import org.gecko.searchresult.SearchResultPackage;
import org.gecko.searchresult.util.SearchResultResourceFactoryImpl;

/**
 * Implementation for result descriptor registry
 * @author Mark Hoffmann
 * @since 01.09.2014
 */
public class ResultDescriptorRegistry implements IResultDescriptorRegistry {
	
	private ISearchWorkspaceProvider workspaceProvider;
	private final ResourceSet resourceSet = new ResourceSetImpl();
	private ResultDescriptorContainer registry = null;
	private List<IResultDescriptorInitializer> initializer = new LinkedList<IResultDescriptorInitializer>(); 
	
	/**
	 * Initializes the registry
	 */
	private void initRegistry() {
		if (registry != null) {
			return;
		}
		Resource registryResource = null;
		// we have no OSGi environment
		if (System.getProperty("osgi.os") == null) {
			resourceSet.getPackageRegistry().put(SearchResultPackage.eNS_URI, SearchResultPackage.eINSTANCE);
			resourceSet.getResourceFactoryRegistry().getContentTypeToFactoryMap().put(SearchResultPackage.eCONTENT_TYPE, new SearchResultResourceFactoryImpl());
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("searchresult", new SearchResultResourceFactoryImpl());
		}
		try {
			String registryPath = getWorkspaceProvider().getResultDescriptorRegistryLocation();
			if(!registryPath.endsWith("/")){
				registryPath += "/";
			}
			URI uri = URI.createURI(registryPath + "descriptors.searchresult");
			registryResource = resourceSet.createResource(uri);
			if (registryResource == null) {
				throw new IllegalStateException("Error creating resource, maybe we are not in an OSGi environment an the factories are not registered");
			}
			registryResource.load(null);
			if (registryResource.getContents().size() > 0 && 
					registryResource.getContents().get(0) instanceof ResultDescriptorContainer) {
				registry = (ResultDescriptorContainer) registryResource.getContents().get(0);
			} else {
				throw new IllegalStateException("There is no content in the registry resource");
			}
		} catch (IOException e) {
			registry = SearchResultFactory.eINSTANCE.createResultDescriptorContainer();
			registryResource.getContents().add(registry);
			saveRegistry();
		} catch (Exception e) {
			throw new IllegalStateException("Error initializing index registry", e);
		}
		
	}
	
	/**
	 * Saves the registry
	 */
	private void saveRegistry() {
		initRegistry();
		if (registry.eResource() != null) {
			try {
				registry.eResource().save(null);
			} catch (IOException e) {
				throw new IllegalStateException("Error saving registry", e);
			}
		} else {
			throw new IllegalStateException("Descriptor registry doesn't have a resource to save");
		}
	}

	/**
	 * Returns the index descriptor for the given index id or <code>null</code>
	 * @param descriptors the list of {@link IndexDescriptor} zu check
	 * @param indexId the id of the index
	 * @return the index descriptor or <code>null</code>
	 */
	private ResultDescriptor getIndexDescriptor(List<ResultDescriptor> descriptors, String indexId) {
		if (descriptors == null || indexId == null) {
			return null;
		}
		initRegistry();
		for (ResultDescriptor active : descriptors) {
			if (active.getIndexId().equals(indexId)) {
				return active;
			}
		}
		return null;
	}

	/**
	 * Because we have different {@link ResourceSet}s, the {@link EObject}s are not of the same instance. Therefore we have to remove any old {@link IndexDescriptor} with the given ID.
	 * @param descriptor the Descriptor that will be replaced
	 */
	private void removeDesciptorFromRegistry(ResultDescriptor descriptor) {
		EObject eObject = registry.eResource().getEObject(descriptor.getId());
		if(eObject != null){
			registry.getDescriptors().remove(eObject);
			removeDesciptorFromRegistry(descriptor);
		}
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.index.core.registry.IIndexDescriptorRegistry#dispose()
	 */
	@Override
	public void dispose() {
		saveRegistry();
		registry.eResource().unload();
		resourceSet.getResources().remove(registry.eResource());
	}

	/**
	 * Returns the workspace provider instance
	 * @return the workspace provider instance
	 */
	public ISearchWorkspaceProvider getWorkspaceProvider() {
		return workspaceProvider;
	}

	/**
	 * Sets the {@link ISearchWorkspaceProvider} instance
	 * @param workspaceProvider the instance to set
	 */
	public void setWorkspaceProvider(ISearchWorkspaceProvider workspaceProvider) {
		this.workspaceProvider = workspaceProvider;
	}
	
	/**
	 * Adds a new {@link IResultDescriptorInitializer} to the registry
	 * @param initializer the initializer to add
	 */
	public void addInitializer(IResultDescriptorInitializer initializer) {
		if (initializer == null) {
			return;
		}
		this.initializer.add(initializer);
		List<ResultDescriptor> descriptors = initializer.initializeResultDescriptors();
		for (ResultDescriptor descriptor : descriptors) {
			registerDescriptor(descriptor);
		}
	}
	
	/**
	 * Removes a new {@link IResultDescriptorInitializer} from the registry
	 * @param initializer the initializer to remove
	 */
	public void removeInitializer(IResultDescriptorInitializer initializer) {
		if (initializer == null) {
			return;
		}
		this.initializer.remove(initializer);
		List<ResultDescriptor> descriptors = initializer.initializeResultDescriptors();
		for (ResultDescriptor descriptor : descriptors) {
			unregisterDescriptor(descriptor);
		}
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.result.core.registry.IResultDescriptorRegistry#registerDescriptor(de.dim.searchresult.ResultDescriptor)
	 */
	@Override
	public boolean registerDescriptor(ResultDescriptor descriptor) {
		initRegistry();
		if (descriptor == null) {
			return false;
		}
		
		removeDesciptorFromRegistry(descriptor);
		
		boolean result = registry.getDescriptors().add(descriptor);
		saveRegistry();
		return result;
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.result.core.registry.IResultDescriptorRegistry#unregisterDescriptor(de.dim.searchresult.ResultDescriptor)
	 */
	@Override
	public boolean unregisterDescriptor(ResultDescriptor descriptor) {
		initRegistry();
		if (descriptor == null || !registry.getDescriptors().contains(descriptor)) {
			return false;
		}
		boolean result = registry.getDescriptors().remove(descriptor);
		saveRegistry();
		return result;
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.result.core.registry.IResultDescriptorRegistry#setActive(de.dim.searchresult.ResultDescriptor)
	 */
	@Override
	public void setActive(ResultDescriptor descriptor) {
		initRegistry();
		List<ResultDescriptor> activeDescriptors = registry.getActiveDescriptors();
		if (descriptor == null || activeDescriptors.contains(descriptor)) {
			return; 
		}
		// register, if it is not already registered
		if (!registry.getDescriptors().contains(descriptor)) {
			registerDescriptor(descriptor);
		}
		String indexId = descriptor.getIndexId();
		// desctivate existing descriptor
		ResultDescriptor active = getActiveIndexDescriptor(indexId);
		if (active != null) {
			active.setActive(false);
		}
		// activate the new one
		descriptor.setActive(true);
		saveRegistry();
	}

	@Override
	public ResultDescriptor getActiveIndexDescriptor(String indexId) {
		if (indexId == null) {
			return null;
		}
		initRegistry();
		return getIndexDescriptor(registry.getDescriptors(), indexId);
	}

}
