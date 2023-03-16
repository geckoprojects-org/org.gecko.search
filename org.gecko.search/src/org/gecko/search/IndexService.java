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

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.util.promise.Promise;

/**
 * Basic service for indexing data
 * @param <D> the typed {@link IndexContextObject} type
 * @author Mark Hoffmann
 * @since 08.03.2023
 */
@ProviderType
public interface IndexService<D extends IndexContextObject<?>> {
	
	/**
	 * Adds the given {@link IndexContextObject} to the queue to be indexed according to the configuration
	 * @param context the {@link IndexContextObject}
	 * @return a {@link Promise} that resolves, when the indexing finished or when an error occurs 
	 */
	Promise<Void> handleContext(D context);

	/**
	 * Immediately handles the given the given {@link Collection} of DocumentIndexContextObject}s and 
	 * commits the index.
	 * @param context the {@link IndexContextObject}
	 */
	void handleContextSync(D context);
	
	/**
	 * Adds the given {@link Collection} of {@link IndexContextObject}'s to the queue to be indexed according to the configuration
	 * @param context the {@link IndexContextObject}
	 * @return a {@link Promise} that resolves, when the indexing finished or when an error occurs 
	 */
	Promise<Void> handleContexts(Collection<D> contexts);

	/**
	 * Immediately handles the given the given {@link Collection} of {@link IndexContextObject}'s and commits the index.
	 * @param context the {@link IndexContextObject}
	 */
	void handleContextsSync(Collection<D> contexts);


}
