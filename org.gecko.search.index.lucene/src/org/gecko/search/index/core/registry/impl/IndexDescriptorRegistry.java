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
package org.gecko.search.index.core.registry.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.gecko.search.core.provider.ISearchWorkspaceProvider;
import org.gecko.search.index.core.registry.IIndexDescriptorInitializer;
import org.gecko.search.index.core.registry.IIndexDescriptorRegistry;
import org.gecko.searchindex.IndexDescriptor;
import org.gecko.searchindex.IndexDescriptorContainer;
import org.gecko.searchindex.SearchIndexFactory;
import org.gecko.searchindex.SearchIndexPackage;
import org.gecko.searchindex.util.SearchIndexResourceFactoryImpl;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;

/**
 * Implementation for index descriptor registry
 * @author Mark Hoffmann
 * @since 05.08.2014
 */
@Component(property = {"type=workspace"})
public class IndexDescriptorRegistry implements IIndexDescriptorRegistry {
	
	private ISearchWorkspaceProvider workspaceProvider;
	protected ResourceSet resourceSet = new ResourceSetImpl();
	protected IndexDescriptorContainer registry = null;
	private List<IIndexDescriptorInitializer> initializer = new LinkedList<IIndexDescriptorInitializer>(); 
	
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
			resourceSet.getPackageRegistry().put(SearchIndexPackage.eNS_URI, SearchIndexPackage.eINSTANCE);
			resourceSet.getResourceFactoryRegistry().getContentTypeToFactoryMap().put(SearchIndexPackage.eCONTENT_TYPE, new SearchIndexResourceFactoryImpl());
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("searchindex", new SearchIndexResourceFactoryImpl());
		}
		try {
			String registryPath = getWorkspaceProvider().getIndexDescriptorRegistryLocation();
			if(!registryPath.endsWith("/")){
				registryPath += "/";
			}
			URI uri = URI.createURI(registryPath + "descriptors.searchindex");
			registryResource = resourceSet.createResource(uri);
			if (registryResource == null) {
				throw new IllegalStateException("Error creating resource, maybe we are not in an OSGi environment an the factories are not registered");
			}
			registryResource.load(null);
			if (registryResource.getContents().size() > 0 && 
					registryResource.getContents().get(0) instanceof IndexDescriptorContainer) {
				registry = (IndexDescriptorContainer) registryResource.getContents().get(0);
			} else {
				throw new IllegalStateException("There is no content in the registry resource");
			}
		} catch (IOException e) {
			registry = SearchIndexFactory.eINSTANCE.createIndexDescriptorContainer();
			registryResource.getContents().add(registry);
			saveRegistry();
		} catch (Exception e) {
			throw new IllegalStateException("Error initializing index registry", e);
		}
		
	}
	
	/**
	 * Saves the registry
	 */
	protected void saveRegistry() {
		initRegistry();
		if (registry.eResource() != null) {
			try {
				//In case we store to mongoDB we have to set this option to prevent an error
				registry.eResource().save(Collections.singletonMap("USE_ID_ATTRIBUTE_AS_PRIMARY_KEY", Boolean.FALSE));
			} catch (IOException e) {
				throw new IllegalStateException("Error saving registry", e);
			}
		} else {
			throw new IllegalStateException("Descriptor registry doesn't have a resource to save");
		}
	}

	/**
	 * Returns the index descriptor for the given {@link EClass} combination or <code>null</code>
	 * @param eclasses the {@link EClass} combination of the index descriptor
	 * @param descriptors the list of {@link IndexDescriptor} zu check
	 * @return the index descriptor or <code>null</code>
	 */
	protected IndexDescriptor getIndexDescriptor(List<IndexDescriptor> descriptors, EClass...eclasses) {
		if (descriptors == null || eclasses == null || eclasses.length == 0) {
			return null;
		}
		initRegistry();
		for (IndexDescriptor active : descriptors) {
			boolean sameClasses = true;
			for (EClass eclass : eclasses) {
				sameClasses = active.getClasses().contains(eclass) && sameClasses;
			}
			if (sameClasses) {
				return active;
			}
		}
		return null;
	}
	
	/**
	 * Returns all the index descriptors for the given {@link EClass} combination or <code>null</code>
	 * @param eclasses the {@link EClass} combination of the index descriptor
	 * @param descriptors the list of {@link IndexDescriptor} zu check
	 * @return the {@link IndexDescriptor}s as unmodifiable {@link List}
	 */
	private List<IndexDescriptor> getIndexDescriptors(List<IndexDescriptor> descriptors, EClass...eclasses) {
		if (descriptors == null || eclasses == null || eclasses.length == 0) {
			return null;
		}
		initRegistry();
		List<IndexDescriptor> result = new LinkedList<IndexDescriptor>();
		for (IndexDescriptor active : descriptors) {
			boolean sameClasses = true;
			for (EClass eclass : eclasses) {
				sameClasses = active.getClasses().contains(eclass) && sameClasses;
			}
			if (sameClasses) {
				result.add(active);
			}
		}
		return Collections.unmodifiableList(result);
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.index.core.registry.IIndexDescriptorRegistry#registerDescriptor(de.dim.searchindex.IndexDescriptor)
	 */
	@Override
	public boolean registerDescriptor(IndexDescriptor descriptor) {
		initRegistry();
		if (descriptor == null) {
			return false;
		}
		
		removeDesciptorFromRegistry(descriptor);
		
		boolean result = registry.getDescriptors().add(descriptor);
		saveRegistry();
		return result;
	}

	/**
	 * Because we have different {@link ResourceSet}s, the {@link EObject}s are not of the same instance. Therefore we have to remove any old {@link IndexDescriptor} with the given ID.
	 * @param descriptor the Descriptor that will be replaced
	 */
	private void removeDesciptorFromRegistry(IndexDescriptor descriptor) {
		EObject eObject = registry.eResource().getEObject(descriptor.getId());
		if(eObject != null){
			registry.getDescriptors().remove(eObject);
		}
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.index.core.registry.IIndexDescriptorRegistry#unregisterDescriptor(de.dim.searchindex.IndexDescriptor)
	 */
	@Override
	public boolean unregisterDescriptor(IndexDescriptor descriptor) {
		initRegistry();
		if (descriptor == null || !registry.getDescriptors().contains(descriptor)) {
			return false;
		}
		boolean result = registry.getDescriptors().remove(descriptor);
		saveRegistry();
		return result;
	}

	/* (non-Javadoc)
	 * @see de.dim.search.index.core.registry.IIndexDescriptorRegistry#setActive(de.dim.searchindex.IndexDescriptor)
	 */
	@Override
	public void setActive(IndexDescriptor descriptor) {
		initRegistry();
		List<IndexDescriptor> activeDescriptors = registry.getActiveDescriptors();
		if (descriptor == null || activeDescriptors.contains(descriptor)) {
			return; 
		}
		// register, if it is not already registered
		if (!registry.getDescriptors().contains(descriptor)) {
			registerDescriptor(descriptor);
		}
		List<EClass> eclasses = descriptor.getClasses();
		// desctivate existing descriptor
		IndexDescriptor active = getActiveIndexDescriptor(eclasses.toArray(new EClass[eclasses.size()]));
		if (active != null) {
			active.setActive(false);
		}
		// activate the new one
		descriptor.setActive(true);
		saveRegistry();
	}

	/* (non-Javadoc)
	 * @see de.dim.search.index.core.registry.IIndexDescriptorRegistry#getIndexDescriptor(org.eclipse.emf.ecore.EObject[])
	 */
	@Override
	public IndexDescriptor getIndexDescriptor(EObject... objects) {
		if (objects == null || objects.length == 0) {
			return null;
		}
		initRegistry();
		List<EClass> eclasses = new ArrayList<EClass>(objects.length);
		for (EObject eobject : objects) {
			eclasses.add(eobject.eClass());
		}
		return getIndexDescriptor(registry.getDescriptors(), eclasses.toArray(new EClass[eclasses.size()]));
	}
	
	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.index.core.registry.IIndexDescriptorRegistry#getActiveIndexDescriptor(org.eclipse.emf.ecore.EObject[])
	 */
	@Override
	public IndexDescriptor getActiveIndexDescriptor(EObject... objects) {
		if (objects == null || objects.length == 0) {
			return null;
		}
		initRegistry();
		List<EClass> eclasses = new ArrayList<EClass>(objects.length);
		for (EObject eobject : objects) {
			eclasses.add(eobject.eClass());
		}
		return getIndexDescriptor(registry.getActiveDescriptors(), eclasses.toArray(new EClass[eclasses.size()]));
	}

	/* (non-Javadoc)
	 * @see de.dim.search.index.core.registry.IIndexDescriptorRegistry#getActiveIndexDescriptors(org.eclipse.emf.ecore.EClass[])
	 */
	@Override
	public List<IndexDescriptor> getActiveIndexDescriptors(EClass... classes) {
		if (classes == null || classes.length == 0) {
			return null;
		}
		initRegistry();
		return getIndexDescriptors(registry.getActiveDescriptors(), classes);
	}
	
	/* (non-Javadoc)
	 * @see de.dim.search.index.core.registry.IIndexDescriptorRegistry#getActiveIndexDescriptors(org.eclipse.emf.ecore.EObject[])
	 */
	@Override
	public List<IndexDescriptor> getActiveIndexDescriptors(EObject... objects) {
		if (objects == null || objects.length == 0) {
			return null;
		}
		initRegistry();
		List<EClass> eclasses = new ArrayList<EClass>(objects.length);
		for (EObject eobject : objects) {
			eclasses.add(eobject.eClass());
		}
		return getIndexDescriptors(registry.getActiveDescriptors(), eclasses.toArray(new EClass[eclasses.size()]));
	}
	
	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.index.core.registry.IIndexDescriptorRegistry#getActiveIndexDescriptor(org.eclipse.emf.ecore.EClass[])
	 */
	@Override
	public IndexDescriptor getActiveIndexDescriptor(EClass... classes) {
		if (classes == null || classes.length == 0) {
			return null;
		}
		initRegistry();
		return getIndexDescriptor(registry.getActiveDescriptors(), classes);
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.index.core.registry.IIndexDescriptorRegistry#getIndexDescriptor(org.eclipse.emf.ecore.EClass[])
	 */
	@Override
	public IndexDescriptor getIndexDescriptor(EClass... classes) {
		if (classes == null || classes.length == 0) {
			return null;
		}
		initRegistry();
		return getIndexDescriptor(registry.getDescriptors(), classes);
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
	@Reference(cardinality = ReferenceCardinality.MANDATORY, target = "(type=workspace)", policy = ReferencePolicy.STATIC)
	public void setWorkspaceProvider(ISearchWorkspaceProvider workspaceProvider) {
		this.workspaceProvider = workspaceProvider;
	}
	
	/**
	 * Adds a new {@link IIndexDescriptorInitializer} to the registry
	 * @param initializer the initializer to add
	 */
	@Reference(cardinality = ReferenceCardinality.MULTIPLE, policy = ReferencePolicy.DYNAMIC)
	public void addInitializer(IIndexDescriptorInitializer initializer) {
		if (initializer == null) {
			return;
		}
		this.initializer.add(initializer);
		List<IndexDescriptor> descriptors = initializer.initializeDescriptors();
		for (IndexDescriptor descriptor : descriptors) {
			registerDescriptor(descriptor);
		}
	}
	
	/**
	 * Removes a new {@link IIndexDescriptorInitializer} from the registry
	 * @param initializer the initializer to remove
	 */
	public void removeInitializer(IIndexDescriptorInitializer initializer) {
		if (initializer == null) {
			return;
		}
		this.initializer.remove(initializer);
		List<IndexDescriptor> descriptors = initializer.initializeDescriptors();
		for (IndexDescriptor descriptor : descriptors) {
			unregisterDescriptor(descriptor);
		}
	}

}
