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

import org.gecko.searchresult.QueryObject;

/**
 * Registry interface to register queries and get the by name. This registry is intended to provider
 * a named query support
 * @author mark
 * @since 10.08.2014
 */
public interface IQueryRegistry {
	
	/**
	 * Registers the auery and returns <code>true</code> on success
	 * otherwise <code>false</code>, if e.g. the query already exists or is <code>null</code>
	 * @param query the query to register
	 * @return <code>true</code> on success otherwise <code>false</code>
	 */
	public boolean registerQuery(QueryObject query);
	
	/**
	 * Unregisters the query and returns <code>true</code> on success
	 * otherwise <code>false</code>.
	 * @param query the query to un-register
	 * @return <code>true</code> on success otherwise <code>false</code>
	 */
	public boolean unregisterQuery(QueryObject query);
	
	/**
	 * Sets the given {@link QueryObject} to active. If there is already an {@link QueryObject} with the same id, this other query will be de-activated. 
	 * @param query the query to activate
	 */
	public void setActive(QueryObject query);
	
	/**
	 * Returns the query for the given id, if it is active.
	 * @param queryId the id to get the {@link QueryObject} from
	 * @return the active query or <code>null</code>;
	 */
	public QueryObject getActiveQuery(String queryId);
	
	/**
	 * Returns the query for the given id or <code>null</code>
	 * @param queryId the id to get the {@link QueryObject} from
	 * @return the query or <code>null</code>;
	 */
	public QueryObject getQuery(String queryId);
	
	/**
	 * Disposes all resources
	 */
	public void dispose();

}
