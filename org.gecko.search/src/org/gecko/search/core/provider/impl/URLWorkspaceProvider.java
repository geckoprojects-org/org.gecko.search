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
package org.gecko.search.core.provider.impl;

import java.net.URL;

import org.gecko.runtime.boot.GeckoBootConstants;
import org.gecko.search.core.provider.ISearchWorkspaceProvider;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

/**
 * An implementation of a workspace provider that uses the Eclipse workspace
 * @author Mark Hoffmann
 * @since 04.08.2014
 */
@Component(property = {"type=workspace"})
public class URLWorkspaceProvider implements ISearchWorkspaceProvider {
	
	@Reference(cardinality=ReferenceCardinality.MANDATORY ,target="(" + GeckoBootConstants.PROP_GECKO_DATA_DIR  + "=true)")
	private URL workspaceUrl;
	
	private String projectName = "index"; //$NON-NLS-1$

	/* (non-Javadoc)
	 * @see de.dim.search.index.core.IIndexWorkspaceProvider#getIndexWorkspaceLocation()
	 */
	@Override
	public String getIndexWorkspaceLocation() {
		return getLocation("data");
	}

	/* (non-Javadoc)
	 * @see de.dim.search.index.core.IIndexWorkspaceProvider#getIndexDescriptorRegistryLocation()
	 */
	@Override
	public String getIndexDescriptorRegistryLocation() {
		return getLocation("descriptors");
	}
	
	@Override
	public String getResultDescriptorRegistryLocation() {
		return getIndexDescriptorRegistryLocation();
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.index.core.provider.IIndexWorkspaceProvider#getQueryRegistryLocation()
	 */
	@Override
	public String getQueryRegistryLocation() {
		return getLocation("queries");
	}

	private String getLocation(String folderName) {
		if (folderName == null || folderName.isEmpty()) {
			return null;
		}
		String dataDir = workspaceUrl.toString();
		if(dataDir.endsWith("/")) {
			return dataDir + projectName + "/" + folderName;
		} 
		return dataDir + "/" + projectName + "/" + folderName; 
	}

	
}
