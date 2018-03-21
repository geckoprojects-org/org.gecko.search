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
package org.gecko.search.result.core.registry;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.gecko.search.core.provider.ISearchWorkspaceProvider;
import org.gecko.searchresult.QueryObject;
import org.gecko.searchresult.QueryObjectContainer;
import org.gecko.searchresult.SearchResultFactory;
import org.gecko.searchresult.SearchResultPackage;
import org.gecko.searchresult.util.SearchResultResourceFactoryImpl;

/**
 * Implementation of the query registry
 * @author Mark Hoffmann
 * @since 10.08.2014
 */
public class QueryRegistry implements IQueryRegistry {
	
	private ISearchWorkspaceProvider workspaceProvider;
	private final ResourceSet resourceSet = new ResourceSetImpl();
	private QueryObjectContainer registry = null;
	private List<IQueryInitializer> initializer = new LinkedList<IQueryInitializer>(); 
	
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
			String registryPath = getWorkspaceProvider().getQueryRegistryLocation();
			if(!registryPath.endsWith("/")){
				registryPath += "/";
			}
			URI uri = URI.createURI(registryPath + "queries.searchresult");
			registryResource = resourceSet.createResource(uri);
			if (registryResource == null) {
				throw new IllegalStateException("Error creating resource, maybe we are not in an OSGi environment an the factories are not registered");
			}
			registryResource.load(null);
			if (registryResource.getContents().size() > 0 && 
					registryResource.getContents().get(0) instanceof QueryObjectContainer) {
				registry = (QueryObjectContainer) registryResource.getContents().get(0);
			} else {
				throw new IllegalStateException("There is no content in the registry resource");
			}
		} catch (IOException e) {
			registry = SearchResultFactory.eINSTANCE.createQueryObjectContainer();
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

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.result.core.registry.IQueryRegistry#registerQuery(de.dim.searchresult.QueryObject)
	 */
	@Override
	public boolean registerQuery(QueryObject query) {
		initRegistry();
		if (query == null || registry.getQueries().contains(query)) {
			return false;
		}
		boolean result = registry.getQueries().add(query);
		saveRegistry();
		return result;
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.result.core.registry.IQueryRegistry#unregisterQuery(de.dim.searchresult.QueryObject)
	 */
	@Override
	public boolean unregisterQuery(QueryObject query) {
		initRegistry();
		if (query == null || !registry.getQueries().contains(query)) {
			return false;
		}
		boolean result = registry.getQueries().remove(query);
		saveRegistry();
		return result;
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.result.core.registry.IQueryRegistry#setActive(de.dim.searchresult.QueryObject)
	 */
	@Override
	public void setActive(QueryObject query) {
		initRegistry();
		List<QueryObject> activeDescriptors = registry.getActiveQueries();
		if (query == null || activeDescriptors.contains(query)) {
			return; 
		}
		// register, if it is not already registered
		if (!registry.getQueries().contains(query)) {
			registerQuery(query);
		}
		// desctivate existing descriptor
		QueryObject active = getActiveQuery(query.getId());
		if (active != null) {
			active.setActive(false);
		}
		// activate the new one
		query.setActive(true);
		saveRegistry();
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.result.core.registry.IQueryRegistry#getActiveQuery(java.lang.String)
	 */
	@Override
	public QueryObject getActiveQuery(String queryId) {
		if (queryId == null ) {
			return null;
		}
		initRegistry();
		for (QueryObject qo : registry.getActiveQueries()) {
			if (queryId.equals(qo.getId())) {
				return qo;
			}
		}
		return null;
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.result.core.registry.IQueryRegistry#getQuery(java.lang.String)
	 */
	@Override
	public QueryObject getQuery(String queryId) {
		if (queryId == null ) {
			return null;
		}
		initRegistry();
		for (QueryObject qo : registry.getQueries()) {
			if (queryId.equals(qo.getId())) {
				return qo;
			}
		}
		return null;
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
	 * Adds a new {@link IQueryInitializer} to the registry
	 * @param initializer the initializer to add
	 */
	public void addInitializer(IQueryInitializer initializer) {
		if (initializer == null) {
			return;
		}
		this.initializer.add(initializer);
		List<QueryObject> queries = initializer.registerQueries();
		for (QueryObject query : queries) {
			registerQuery(query);
		}
	}
	
	/**
	 * Removes a new {@link IQueryInitializer} from the registry
	 * @param initializer the initializer to remove
	 */
	public void removeInitializer(IQueryInitializer initializer) {
		if (initializer == null) {
			return;
		}
		this.initializer.remove(initializer);
		List<QueryObject> queries = initializer.registerQueries();
		for (QueryObject query : queries) {
			unregisterQuery(query);
		}
	}

}
