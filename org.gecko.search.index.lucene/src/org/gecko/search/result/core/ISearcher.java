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
package org.gecko.search.result.core;


import org.gecko.searchresult.QueryObject;
import org.gecko.searchresult.SearchResult;

/**
 * Interface to execute a search
 * @author Mark Hoffmann
 * @since 08.08.2014
 */
public interface ISearcher {
	
	/**
	 * Executes the query and returns the mapped search result
	 * @param query the search query
	 * @return the mapped search result
	 * @throws SearchResultException if there is any problem during execution of the query
	 */
	public SearchResult search(QueryObject query) throws SearchResultException;
	
}
