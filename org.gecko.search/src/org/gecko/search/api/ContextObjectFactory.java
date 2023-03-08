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

import org.osgi.annotation.versioning.ProviderType;

/**
 * Factory that creates {@link IndexContextObject} instances out of the business object. It can be possible
 * that many context objects arise from one {@link EObject}. Therefore all factory methods return a collection.
 * @param <O> the business object type
 * @param <T> the {@link IndexContextObject}
 * @author Mark Hoffmann
 * @since 08.03.2023
 */
@ProviderType
public interface ContextObjectFactory<O, T extends IndexContextObject<?>> {
	
	/**
	 * Creates a single index context object
	 * @param object the business objects to create the context object from
	 * @param properties additional properties, can be <code>null</code>
	 * @return the {@link IndexContextObject} collection for the object
	 */
	public Collection<T> createObject(O object, Map<String, Object> properties);
	
	/**
	 * Creates a collection of index context objects
	 * @param objects the business objects to create the context objects from
	 * @param properties additional properties, can be <code>null</code>
	 * @return the {@link IndexContextObject} collections for the objects
	 */
	public Collection<T> createObjects(Collection<O> objects, Map<String, Object> properties);

}
