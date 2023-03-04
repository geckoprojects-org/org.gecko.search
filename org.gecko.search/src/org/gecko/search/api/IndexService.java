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

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.osgi.annotation.versioning.ProviderType;

/**
 * Basic service for indexing data
 * @author Mark Hoffmann
 * @since 29.11.2018
 */
@ProviderType
public interface IndexService {
	
	/**
	 * Add the given element to the index
	 * @param properties the additional index properties
	 * @param object the object to be indexed
	 */
	public void indexAdd(Map<String, Object> properties, EObject object);
	
	/**
	 * Add the given elements to the index
	 * @param properties the additional index properties
	 * @param objects the objects to be indexed
	 */
	public void indexAdd(Map<String, Object> properties, EObject...objects);
	
	/**
	 * Add the given elements to the index
	 * @param properties the additional index properties
	 * @param objects the objects to be indexed
	 */
	public void indexAdd(Map<String, Object> properties, Collection<EObject> objects);
	
	/**
	 * Updates the given element in the index
	 * @param properties the additional index properties
	 * @param object the object to be updated
	 */
	public void indexUpdate(Map<String, Object> properties, EObject object);
	
	/**
	 * Updates the given elements in the index
	 * @param properties the additional index properties
	 * @param objects the objects to be updated
	 */
	public void indexUpdate(Map<String, Object> properties, EObject...objects);
	
	/**
	 * Updates the given elements in the index
	 * @param properties the additional index properties
	 * @param objects the objects to be updated
	 */
	public void indexUpdate(Map<String, Object> properties, Collection<EObject> objects);
	
	/**
	 * Removes the given element from the updated
	 * @param properties the additional index properties
	 * @param object the object to be removed
	 */
	public void indexRemove(Map<String, Object> properties, EObject object);
	
	/**
	 * Removes the given elements from the updated
	 * @param properties the additional index properties
	 * @param objects the objects to be removed
	 */
	public void indexRemove(Map<String, Object> properties, EObject...objects);
	
	/**
	 * Removes the given elements from the updated
	 * @param properties the additional index properties
	 * @param objects the objects to be removed
	 */
	public void indexRemove(Map<String, Object> properties, Collection<EObject> objects);

}
