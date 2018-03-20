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

import org.gecko.search.core.provider.ISearchWorkspaceProvider;
import org.osgi.service.component.annotations.Component;

/**
 * This workspace provider uses the java.io.tmp folder to store the index and descriptors 
 * @author Mark Hoffmann
 * @since 05.08.2014
 */
@Component(enabled = true, property = "type=temp")
public class TempWorkspaceProvider implements ISearchWorkspaceProvider {
	
	private String tmpPath; 
	private File registryDir;
	private File workspaceDir;
	
	public TempWorkspaceProvider() {
	}
	
	public void initialize() {
		String tempDir = System.getProperty("java.io.tmpdir");
		tempDir = tempDir.replace('\\', '/');
		if(tempDir.endsWith("/")){
			tempDir = tempDir.substring(0, tempDir.length() - 1);
		}
		tmpPath =  tempDir + "/dimsearch";
		String registryPath = tmpPath + "/registry/descriptors";
		registryDir = new File(registryPath);
		if (!registryDir.exists()) {
			registryDir.mkdirs();
		}
		String workspacePath = tmpPath + "/workspace";
		workspaceDir = new File(workspacePath);
		if (!workspaceDir.exists()) {
			workspaceDir.mkdirs();
		}
	}
	
	/**
	 * @throws Exception
	 */
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
		return tmpPath + "/data";
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
		return "file:/" + tmpPath + "/registry/descriptors";
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.index.core.provider.IIndexWorkspaceProvider#getQueryRegistryLocation()
	 */
	@Override
	public String getQueryRegistryLocation() {
		return "file:/" + tmpPath + "/registry/queries";
	}

}
