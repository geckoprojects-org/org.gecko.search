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
package org.gecko.search.core.registry;

import java.util.List;

import org.gecko.search.core.model.IndexData;

/**
 * Interface for a registry to register {@link IndexData}
 * @author Mark Hoffmann
 * @since 01.09.2014
 */
public interface IndexDataRegistry {
	
	/**
	 * Registers {@link IndexData} and return <code>true</code> on success
	 * @param indexData the object to register
	 * @return <code>true</code> on successful registration
	 */
	public boolean registerIndexData(IndexData indexData);
	
	/**
	 * De-Registers {@link IndexData} and return <code>true</code> on success
	 * @param indexData the object to un-register
	 * @return <code>true</code> on successful de-registration
	 */
	public boolean unregisterIndexData(IndexData indexData);
	
	/**
	 * De-Registers {@link IndexData} by its id and return <code>true</code> on success
	 * @param id the index data id to un-register
	 * @return <code>true</code> on successful de-registration
	 */
	public boolean unregisterIndexDataById(String id);
	
	/**
	 * Returns the {@link IndexData} instance by its id or <code>null</code>, if it doesn't exists
	 * @param id the index data id
	 * @return the {@link IndexData} instance by its id or <code>null</code>, if it doesn't exists
	 */
	public IndexData getIndexDataById(String id);
	
	/**
	 * Returns a {@link List} of the {@link IndexData} instances for the given name or an empty list
	 * @param name the index data name
	 * @return the {@link IndexData} instances as list or an empty list
	 */
	public List<IndexData> getIndexDataByName(String name);
	
	/**
	 * Cleans up all resources
	 */
	public void dispose();

}
