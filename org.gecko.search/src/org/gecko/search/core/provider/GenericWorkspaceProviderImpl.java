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
package org.gecko.search.core.provider;

import java.util.Map;

/**
 * A WorkspaceProvider that can be used to serve {@link IndexDescriptor}s by a URI configured as component parameter
 * @author Juergen Albert
 * @since 07.08.2014 
 */
public class GenericWorkspaceProviderImpl implements ISearchWorkspaceProvider {

	public static final String BASE_URI_PARAM = "baseUri";
	
	private String baseUri = null;
	
	/* (non-Javadoc)
	 * @see de.dim.search.index.core.provider.IIndexWorkspaceProvider#getIndexWorkspaceLocation()
	 */
	@Override
	public String getIndexWorkspaceLocation() {
		throw new UnsupportedOperationException("getIndexWorkspaceLocation is not supported by this MongoWorkspaceProviderImpl");
	}

	/* (non-Javadoc)
	 * @see de.dim.search.index.core.provider.IIndexWorkspaceProvider#getIndexDescriptorRegistryLocation()
	 */
	@Override
	public String getIndexDescriptorRegistryLocation() {
		return baseUri;
	}
	
	@Override
	public String getResultDescriptorRegistryLocation() {
		return baseUri;
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.index.core.provider.IIndexWorkspaceProvider#getQueryRegistryLocation()
	 */
	@Override
	public String getQueryRegistryLocation() {
		return baseUri;
	}

	/**
	 * @param parameters
	 */
	public void activate(Map<String, Object> parameters) {
		baseUri = (String) parameters.get(BASE_URI_PARAM);
	}

}
