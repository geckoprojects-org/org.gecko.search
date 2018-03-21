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
package org.gecko.search.result.core.registry;

import java.util.List;

import org.gecko.searchresult.QueryObject;

/**
 * Initializer interface which implementations can be registered a service. It is used by the {@link IQueryRegistry}
 * to initialize the registry on startup
 * @author Mark Hoffmann
 * @since 10.08.2014
 */
public interface IQueryInitializer {
	
	/**
	 * Returns the list of queries that should be registered
	 * @return the list of queries that should be registered
	 */
	public List<QueryObject> registerQueries();

}
