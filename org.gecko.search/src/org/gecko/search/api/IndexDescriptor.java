/**
 * Copyright (c) 2012 - 2023 Data In Motion and others.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
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
