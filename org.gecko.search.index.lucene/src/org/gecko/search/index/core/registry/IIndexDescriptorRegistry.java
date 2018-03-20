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
package org.gecko.search.index.core.registry;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.gecko.searchindex.IndexDescriptor;

/**
 * Interface for the descriptor registry
 * @author Mark Hoffmann
 * @since 05.08.2014
 */
public interface IIndexDescriptorRegistry {
	
	/**
	 * Registers the index descriptor and returns <code>true</code> on success
	 * otherwise <code>false</code>, if e.g. the descriptor already exists or is <code>null</code>
	 * @param descriptor the descriptor to register
	 * @return <code>true</code> on success otherwise <code>false</code>
	 */
	public boolean registerDescriptor(IndexDescriptor descriptor);
	
	/**
	 * Unregisters the index descriptor and returns <code>true</code> on success
	 * otherwise <code>false</code>.
	 * @param descriptor the descriptor to un-register
	 * @return <code>true</code> on success otherwise <code>false</code>
	 */
	public boolean unregisterDescriptor(IndexDescriptor descriptor);
	
	/**
	 * Sets the given {@link IndexDescriptor} to active. If there is already an {@link IndexDescriptor} with the same {@link EClass}
	 * combination, this other descriptor will be de-activated. 
	 * @param descriptor the descriptor to activate
	 */
	public void setActive(IndexDescriptor descriptor);
	
	/**
	 * Returns the index descriptor for the given {@link EClass} combination from the given objects, if it is active
	 * @param objects the objects to get the {@link EClass}'es from
	 * @return the index descriptor or <code>null</code>;
	 */
	public IndexDescriptor getActiveIndexDescriptor(EObject...objects);
	
	/**
	 * Returns the index descriptor for the given {@link EClass} combination from the given objects
	 * @param objects the objects to get the {@link EClass}'es from
	 * @return the index descriptor or <code>null</code>;
	 */
	public IndexDescriptor getIndexDescriptor(EObject...objects);
	
	/**
	 * Returns the index descriptor for the given {@link EClass} combination from the given objects, if it is active
	 * @param classes the {@link EClass}'es combination
	 * @return the index descriptor or <code>null</code>;
	 */
	public IndexDescriptor getActiveIndexDescriptor(EClass...classes);
	
	/**
	 * Returns the index descriptor for the given {@link EClass} combination from the given objects
	 * @param classes the {@link EClass}'es combination
	 * @return the index descriptor or <code>null</code>;
	 */
	public IndexDescriptor getIndexDescriptor(EClass...classes);
	
	/**
	 * Disposes all resources
	 */
	public void dispose();

	/**
	 * Returns a List of all active {@link IndexDescriptor}s that are available for the given {@link EClass} combination
	 * @param classes the {@link EClass}'es combination
	 * @return an unmodifiable {@link List} of {@link IndexDescriptor}s
	 */
	public List<IndexDescriptor> getActiveIndexDescriptors(EClass... classes);
	
	/**
	 * Returns a List of all active {@link IndexDescriptor}s that are available for the given {@link EClass} combination
	 * @param objects the objects to get the {@link EClass}'es from
	 * @return an unmodifiable {@link List} of {@link IndexDescriptor}s
	 */
	public List<IndexDescriptor> getActiveIndexDescriptors(EObject... classes);

}
