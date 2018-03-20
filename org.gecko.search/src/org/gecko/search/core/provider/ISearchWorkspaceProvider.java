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

/**
 * Interface that provides the descriptor location and index location
 * @author Mark Hoffmann
 * @since 05.08.2014
 */
public interface ISearchWorkspaceProvider {
	
	/**
	 * Returns the base index workspace location (not as an uri)
	 * @return the base index workspace location
	 */
	public String getIndexWorkspaceLocation();
	
	/**
	 * Returns the location uri of the stored index descriptor registry data
	 * @return the location uri of the stored index descriptor registry data
	 */
	public String getIndexDescriptorRegistryLocation();
	
	/**
	 * Returns the location uri of the stored result descriptor registry data
	 * @return the location uri of the stored result descriptor registry data
	 */
	public String getResultDescriptorRegistryLocation();
	
	/**
	 * Returns the location uri of the stored query registry data
	 * @return the location uri of the stored query registry data
	 */
	public String getQueryRegistryLocation();

}
