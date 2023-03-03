/**
 * Copyright (c) 2012 - 2023 Data In Motion and others.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made available under the terms of the 
 * Eclipse Public License v2.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *     Data In Motion - initial API and implementation
 */
package org.gecko.search.api;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Marker interface for an index descriptor
 * @author Mark Hoffmann
 * @since 08.12.2018
 */
@ProviderType
public interface IndexDescriptor {
	
	/**
	 * Returns the descriptor name
	 * @return the descriptor name
	 */
	public String getName();
	
	/**
	 * Returns the index type, for this descriptor
	 * @return the index type, for this descriptor
	 */
	public IndexType getIndexType(); 

}
