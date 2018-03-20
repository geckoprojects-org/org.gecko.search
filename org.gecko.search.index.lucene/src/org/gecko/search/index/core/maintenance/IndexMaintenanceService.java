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
package org.gecko.search.index.core.maintenance;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.gecko.search.index.core.SearchIndexException;

/**
 * Service for index maintenance like dropping, indexing, updating.
 * Usually this service is called on startup of a node with the following order:
 * - dropIndex - remove old index
 * - fetchIndexData - get all data from the data store. 
 *   In the meantime the node accepts notification with ids from objects to insert or update from other nodes.
 * - rebuildIndex - create index with loaded data
 * - updateIndex - update the objects we received from other nodes since stating fetching the data
 * @author Mark Hoffmann
 * @since 17.10.2014
 */
public interface IndexMaintenanceService {
	
	/**
	 * Fetches all index data for the descriptor {@link EClass} type and returns a list of objects or an empty list.
	 * @param indexClass the {@link EClass} of the index type to fetch the data
	 * @return {@link List} of {@link EObject} or an empty list
	 * @throws SearchIndexException on errors during fetching
	 */
	public List<EObject> fetchIndexData(EClass indexClass) throws SearchIndexException;
	
	/**
	 * Fetches all index data for the descriptor {@link EClass} type and returns returns a list of objects or an empty list.
	 * success.
	 * @param indexClass the {@link EClass} of the index type to fetch the data
	 * @param idsToFetch the id of the objects to fetch
	 * @return {@link List} of {@link EObject} or an empty list
	 * @throws SearchIndexException on errors during fetching
	 */
	public List<EObject> fetchIndexDataById(EClass indexClass, Set<String> idsToFetch) throws SearchIndexException;
	
	/**
	 * Rebuilds the index for the given descriptor type and returns <code>true</code> on 
	 * success.
	 * @param objectsToIndex the object to be indexed
	 * @return <code>true</code> on success otherwise <code>false</code>
	 * @throws SearchIndexException on errors during fetching
	 */
	public boolean rebuildIndex(List<? extends EObject> objectsToIndex) throws SearchIndexException;

	/**
	 * Updates the index for the given objects and returns <code>true</code> on 
	 * success.
	 * @param objectsToUpdate the objects to update the index for
	 * @return <code>true</code> on success otherwise <code>false</code>
	 * @throws SearchIndexException on errors during fetching
	 */
	public boolean updateIndex(List<? extends EObject> objectsToUpdate) throws SearchIndexException;
	
	/**
	 * Removes the index documents for the given objects and returns <code>true</code> on 
	 * success.
	 * @param indexClass the index descriptor type of the index documents
	 * @param idsToRemove the object ids to be removed from the index
	 * @return <code>true</code> on success otherwise <code>false</code>
	 * @throws SearchIndexException on errors during fetching
	 */
	public boolean removeFromIndex(EClass indexClass, List<String> idsToRemove) throws SearchIndexException;

	/**
	 * Drops the indexes for the given descriptor type and returns <code>true</code> on 
	 * success.
	 * @param indexClass the descriptor type to drop the indexes for
	 * @return <code>true</code> on success otherwise <code>false</code>
	 * @throws SearchIndexException on errors during fetching
	 */
	public boolean dropIndex(EClass indexClass) throws SearchIndexException;

}
