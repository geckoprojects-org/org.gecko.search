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
 * Factory that creates {@link IndexContextObject} instances out of the {@link EObject}. It can be possible
 * that many context objects arise from one {@link EObject}. Therefore all factory methods return a collection.
 * @author Mark Hoffmann
 * @since 08.12.2018
 */
@ProviderType
public interface ContextObjectFactory<T extends IndexContextObject> {
	
	/**
	 * Creates a single index context object
	 * @param object the {@link EObject} to create the context object from
	 * @param properties additional properties, can be <code>null</code>
	 * @return the {@link IndexContextObject} collection for the object
	 */
	public Collection<T> createObject(EObject object, Map<String, Object> properties);
	
	/**
	 * Creates a collection of index context objects
	 * @param objects the {@link EObject}s to create the context objects from
	 * @param properties additional properties, can be <code>null</code>
	 * @return the {@link IndexContextObject} collections for the objects
	 */
	public Collection<T> createObjects(Collection<EObject> objects, Map<String, Object> properties);

}
