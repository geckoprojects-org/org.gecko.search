/**
 * 
 */
package org.gecko.search.core.provider.impl;

import java.io.File;

import org.gecko.search.core.provider.ISearchWorkspaceProvider;

/**
 * @author mark.hoffmann
 *
 */
public class WorkspaceProviderMock implements ISearchWorkspaceProvider {
	
	private String tmpPath; 
	private File searchDir;
	
	public WorkspaceProviderMock() {
	}
	
	public void initialize() {
		String tempDir = System.getProperty("java.io.tmpdir");
		tempDir = tempDir.replace('\\', '/');
		if(tempDir.endsWith("/")){
			tempDir = tempDir.substring(0, tempDir.length() - 1);
		}
		tmpPath = tempDir + "/ds";
		String searchPath = tmpPath + "/registry";
		searchDir = new File(searchPath);
		if (!searchDir.exists()) {
			searchDir.mkdirs();
		}
	}
	
	public void dispose() throws Exception {
		if (searchDir != null && searchDir.exists()) {
			for (File child : searchDir.listFiles()) {
				if (child.exists()) {
					child.delete();
				}
			}
			searchDir.delete();
		}
	}

	/* (non-Javadoc)
	 * @see de.dim.search.index.core.IIndexWorkspaceProvider#getIndexWorkspaceLocation()
	 */
	@Override
	public String getIndexWorkspaceLocation() {
		return getIndexDescriptorRegistryLocation();
	}

	/* (non-Javadoc)
	 * @see de.dim.search.index.core.IIndexWorkspaceProvider#getIndexDescriptorRegistryLocation()
	 */
	@Override
	public String getIndexDescriptorRegistryLocation() {
		return "file:///" +  tmpPath + "/registry";
	}

	@Override
	public String getResultDescriptorRegistryLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.index.core.provider.IIndexWorkspaceProvider#getQueryRegistryLocation()
	 */
	@Override
	public String getQueryRegistryLocation() {
		return "file:///" + tmpPath + "/registry";
	}

}
