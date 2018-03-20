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

import java.io.File;
import java.util.Map;

import org.gecko.search.core.provider.ISearchWorkspaceProvider;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Deactivate;

/**
 * This workspace provider uses the java.io.tmp folder to store the index and descriptors 
 * @author Mark Hoffmann
 * @since 05.08.2014
 */
@Component(name="FileWorkspaceProvider", immediate = true, configurationPolicy = ConfigurationPolicy.REQUIRE, property = "type=file")
public class FileWorkspaceProvider implements ISearchWorkspaceProvider {
	
	private String basePath; 
	private String baseDir; 
	private File registryDir;
	private File workspaceDir;
	
	@Activate
	public void initialize(Map<String, String> parameters) {
		baseDir = parameters.get("baseDir");
		String tempDir = baseDir;
		tempDir = tempDir.replace('\\', '/');
		if(tempDir.endsWith("/")){
			tempDir = tempDir.substring(0, tempDir.length() - 1);
		}
		basePath =  tempDir + "/geckosearch";
		String registryPath = basePath + "/registry/descriptors";
		registryDir = new File(registryPath);
		if (!registryDir.exists()) {
			registryDir.mkdirs();
		}
		String workspacePath = basePath + "/workspace";
		workspaceDir = new File(workspacePath);
		if (!workspaceDir.exists()) {
			workspaceDir.mkdirs();
		}
	}
	
	/**
	 * @throws Exception
	 */
	@Deactivate
	public void dispose() throws Exception {
		if (registryDir != null && registryDir.exists()) {
			for (File child : registryDir.listFiles()) {
				if (child.exists()) {
					child.delete();
				}
			}
			registryDir.delete();
		}
		if (workspaceDir != null && workspaceDir.exists()) {
			for (File child : workspaceDir.listFiles()) {
				if (child.exists()) {
					child.delete();
				}
			}
			workspaceDir.delete();
		}
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.index.core.IIndexWorkspaceProvider#getIndexWorkspaceLocation()
	 */
	@Override
	public String getIndexWorkspaceLocation() {
		return basePath + "/data";
	}

	@Override
	public String getResultDescriptorRegistryLocation() {
		return getIndexDescriptorRegistryLocation();
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.index.core.IIndexWorkspaceProvider#getIndexDescriptorRegistryLocation()
	 */
	@Override
	public String getIndexDescriptorRegistryLocation() {
		return "file:/" + basePath + "/registry/descriptors";
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.index.core.provider.IIndexWorkspaceProvider#getQueryRegistryLocation()
	 */
	@Override
	public String getQueryRegistryLocation() {
		return "file:/" + basePath + "/registry/queries";
	}

}
