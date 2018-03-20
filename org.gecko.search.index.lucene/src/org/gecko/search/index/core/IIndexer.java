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
package org.gecko.search.index.core;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * Interface for indexing
 * @author Mark Hoffmann
 * @since 29.07.2014
 */
public interface IIndexer {
	
	/**
	 * Returns <code>true</code>, if an index descriptor exists for the given objects, 
	 * respectively their {@link EClass} combination 
	 * @param objects the objects to check
	 * @return <code>true</code>, if there is an index descriptor otherwise <code>false</code> will returned
	 */
	public boolean canIndex(EObject... objects);
	
	/**
	 * Indexes many instances, where each object is of a different type.
	 * @param objects the {@link EObject}'s to index
	 * @throws SearchIndexException thrown if an error during indexing occurs
	 */
	public void index(EObject...objects) throws SearchIndexException;
	
	/**
	 * Updates many instances , where each object is of a different type.
	 * @param objects the {@link EObject}'s to index
	 * @throws SearchIndexException thrown if an error during indexing occurs
	 */
	public void update(EObject...objects) throws SearchIndexException;
	
	/**
	 * Removes many difference instances, where each object is of a different type.
	 * @param objects the {@link EObject}'s to index
	 * @throws SearchIndexException thrown if an error during indexing occurs
	 */
	public void remove(EObject...objects) throws SearchIndexException;
	
	/**
	 * Executes a batch indexing for the given objects lists. The first element in the list is the leading object.
	 * Each array in the list is interpreted as one data set.
	 * @param objectLists the objects lists to index
	 * @param forceMerge if true forceMerge will be called on the IndexWriter
	 * @throws SearchIndexException
	 */
	public void batchIndexMany(List<EObject[]> objectLists, @Deprecated boolean forceMerge) throws SearchIndexException;
	
	/**
	 * Executes a batch indexing for the given objects lists. 
	 * @param objectLists the objects lists to index
	 * @param forceMerge if true forceMerge will be called on the IndexWriter
	 * @throws SearchIndexException
	 */
	public void batchIndex(List<EObject> objectLists, @Deprecated boolean forceMerge) throws SearchIndexException;
	
	/**
	 * Executes a batch update for the given objects lists. The first element in the list is the leading object.
	 * Each array in the list is interpreted as one data set.
	 * @param objectLists the objects lists to index
	 * @throws SearchIndexException
	 */
	public void batchUpdateMany(List<EObject[]> objectLists) throws SearchIndexException;
	
	/**
	 * Executes a batch remove for the given objects lists. The first element in the list is the leading object.
	 * Each array in the list is interpreted as one data set.
	 * @param objectLists the objects lists to index
	 * @throws SearchIndexException
	 */
	public void batchRemoveMany(List<EObject[]> objectLists) throws SearchIndexException;
	
	/**
	 * Drops the index for the given {@link EClass} combination
	 * @param eClasses the {@link EClass} to drop the index for
	 * @throws SearchIndexException thrown on any error during dropping
	 */
	public void dropIndex(EClass...eClasses) throws SearchIndexException;
	
	/**
	 * Drops the index for the given index names
	 * @param indexName the name of the index to drop
	 * @throws SearchIndexException thrown on any error during dropping
	 */
	public void dropIndex(String indexName) throws SearchIndexException;
	
	/**
	 * Calls forceMerge on the IndexWriter belonging to the given {@link EClass}es
	 * @param eClass the {@link EClass}es to indentify the IndexWriter by
	 * @throws SearchIndexException
	 */
	public void forceMergeIndex(EClass... eClass) throws SearchIndexException;
}
