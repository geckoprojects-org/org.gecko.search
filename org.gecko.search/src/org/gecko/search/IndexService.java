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
package org.gecko.search;

import java.util.Collection;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Basic service for indexing data
 * @param <T> the business object type
 * @author Mark Hoffmann
 * @since 08.03.2023
 */
@ProviderType
public interface IndexService<T> {
	
	/**
	 * Add the given element to the index
	 * @param properties the additional index properties
	 * @param object the object to be indexed
	 */
	public void indexAdd(Map<String, Object> properties, T object);
	
	/**
	 * Add the given elements to the index
	 * @param properties the additional index properties
	 * @param objects the objects to be indexed
	 */
	public void indexAdd(Map<String, Object> properties, Collection<T> objects);
	
	/**
	 * Updates the given element in the index
	 * @param properties the additional index properties
	 * @param object the object to be updated
	 */
	public void indexUpdate(Map<String, Object> properties, T object);
	
	/**
	 * Updates the given elements in the index
	 * @param properties the additional index properties
	 * @param objects the objects to be updated
	 */
	public void indexUpdate(Map<String, Object> properties, Collection<T> objects);
	
	/**
	 * Removes the given element from the updated
	 * @param properties the additional index properties
	 * @param object the object to be removed
	 */
	public void indexRemove(Map<String, Object> properties, T object);
	
	/**
	 * Removes the given elements from the updated
	 * @param properties the additional index properties
	 * @param objects the objects to be removed
	 */
	public void indexRemove(Map<String, Object> properties, Collection<T> objects);

}
