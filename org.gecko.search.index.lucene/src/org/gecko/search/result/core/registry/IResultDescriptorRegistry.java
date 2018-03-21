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

import org.gecko.searchresult.ResultDescriptor;

public interface IResultDescriptorRegistry {
	
	/**
	 * Registers the result descriptor and returns <code>true</code> on success
	 * otherwise <code>false</code>, if e.g. the descriptor already exists or is <code>null</code>
	 * @param descriptor the descriptor to register
	 * @return <code>true</code> on success otherwise <code>false</code>
	 */
	public boolean registerDescriptor(ResultDescriptor descriptor);
	
	/**
	 * Unregisters the result descriptor and returns <code>true</code> on success
	 * otherwise <code>false</code>.
	 * @param descriptor the descriptor to un-register
	 * @return <code>true</code> on success otherwise <code>false</code>
	 */
	public boolean unregisterDescriptor(ResultDescriptor descriptor);
	
	/**
	 * Sets the given {@link ResultDescriptor} to active. If there is already an {@link ResultDescriptor} with the same index id
	 * combination, this other descriptor will be de-activated. 
	 * @param descriptor the descriptor to activate
	 */
	public void setActive(ResultDescriptor descriptor);
	
	/**
	 * Returns the result descriptor for the given index id combination from the given objects, if it is active
	 * @param indexId the index id to get the active descriptor for
	 * @return the index descriptor or <code>null</code>;
	 */
	public ResultDescriptor getActiveIndexDescriptor(String indexId);
	
	/**
	 * Disposes all resources
	 */
	public void dispose();

}
