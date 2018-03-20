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

import org.gecko.searchindex.IndexDescriptor;

/**
 * Initialization callback that initializes the descriptors to the index descriptor registry
 * @author Mark Hoffmann
 * @since 07.08.2014
 */
public interface IIndexDescriptorInitializer {
	
	/**
	 * Registers the returned list of descriptors to the registry
	 * @return the descriptors to register or unregister
	 */
	public List<IndexDescriptor> initializeDescriptors();

}
