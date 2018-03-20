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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.gecko.search.index.core.IIndexer;
import org.gecko.search.index.core.SearchIndexException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementation of the {@link IndexMaintenanceService} using Lucene
 * @author Mark Hoffmann
 * @since 17.10.2014
 */
public abstract class AbstractIndexMaintenanceService implements IndexMaintenanceService {
	
	private static final Logger LOG = LoggerFactory.getLogger(AbstractIndexMaintenanceService.class);
	private static IIndexer indexer;
	
	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.index.core.maintenance.IndexMaintenanceService#fetchIndexData(org.eclipse.emf.ecore.EClass)
	 */
	@Override
	public List<EObject> fetchIndexData(EClass indexClass) throws SearchIndexException {
		return fetchIndexDataById(indexClass, null);
	}
	
	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.index.core.maintenance.IndexMaintenanceService#fetchIndexDataById(org.eclipse.emf.ecore.EClass, java.util.Set)
	 */
	@Override
	public List<EObject> fetchIndexDataById(EClass indexClass, Set<String> idsToFetch) throws SearchIndexException {
		if (indexClass == null) {
			throw new SearchIndexException("Provide the EClass type to fetch the index data by id");
		}
		boolean byId = idsToFetch != null;
		long start = System.currentTimeMillis();
		if (byId) {
			LOG.info("Start fetching objects of type for the given ids: '" + indexClass.getName() + "'");
		} else {
			LOG.info("Start fetching all objects of type: '" + indexClass.getName() + "'");
		}
		List<EObject> updateObjects = Collections.emptyList();
		if (idsToFetch == null){
			updateObjects = fetchAllObjects(indexClass);
		} else {
			updateObjects = fetchObjectsById(indexClass, idsToFetch);
		}
		if (updateObjects == null || updateObjects.size() == 0) {
			LOG.debug("No objects were fetched");
			return Collections.emptyList();
		}
		int countProxies = 0;
//		List<EObject> proxies = new LinkedList<EObject>();
//		for (EObject eo : updateObjects) {
//			if (eo.eIsProxy()) {
//				++countProxies;
//				proxies.add(eo);
//				LOG.debug(eo.toString());
//			} 
//		}
//		updateObjects.removeAll(proxies);
		if (byId) {
			LOG.info("Finished fetching objects of type for given ids: '" + indexClass.getName() + "' (size=" + updateObjects.size() + "), reading took " + (System.currentTimeMillis() - start) + "ms number of extracted proxies: " + countProxies);
		} else {
			LOG.info("Finished fetching all objects of type: '" + indexClass.getName() + "' (size=" + updateObjects.size() + "), reading took " + (System.currentTimeMillis() - start) + "ms number of extracted proxies: " + countProxies);
		}
		return Collections.unmodifiableList(updateObjects);
	}
	
	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.index.core.maintenance.IndexMaintenanceService#rebuildIndex(java.util.List)
	 */
	@Override
	public boolean rebuildIndex(List<? extends EObject> objectsToIndex) throws SearchIndexException {
		return doBatchedIndex(objectsToIndex, false);
	}
	
	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.index.core.maintenance.IndexMaintenanceService#updateIndex(java.util.List)
	 */
	@Override
	public boolean updateIndex(List<? extends EObject> objectsToUpdate) throws SearchIndexException {
		return doBatchedIndex(objectsToUpdate, true);
	}
	
	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.index.core.maintenance.IndexMaintenanceService#removeFromIndex(org.eclipse.emf.ecore.EClass, java.util.List)
	 */
	@Override
	public boolean removeFromIndex(EClass indexClass, List<String> idsToRemove) throws SearchIndexException {
		return false;
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.index.core.maintenance.IndexMaintenanceService#dropIndex(org.eclipse.emf.ecore.EClass)
	 */
	@Override
	public boolean dropIndex(EClass indexClass) throws SearchIndexException {
		if (indexClass == null) {
			throw new SearchIndexException("Provide the EClass type to drop the index data");
		}
		indexer.dropIndex(indexClass);
		return true;
	}



	/**
	 * Returns the indexer.
	 * @return the indexer
	 */
	public IIndexer getIndexer() {
		return AbstractIndexMaintenanceService.indexer;
	}

	/**
	 * Sets the indexer.
	 * @param indexer the indexer to set
	 */
	public static void setIndexer(IIndexer indexer) {
		AbstractIndexMaintenanceService.indexer = indexer;
	}
	
	/**
	 * Sets the indexer.
	 * @param indexer the indexer to set
	 */
	public static void unsetIndexer(IIndexer indexer) {
		AbstractIndexMaintenanceService.indexer = null;
	}
	
	/**
	 * Method that provides a stub to fetch all objects of the given type
	 * @param eclass the {@link EClass} to get all objects for from the store
	 * @return a list of all objects or an empty list
	 */
	protected abstract List<EObject> fetchAllObjects(EClass eclass);
	
	/**
	 * Method that provides a stub to fetch all {@link EObject}'s of the given type and the given ids 
	 * @param eclass the object type to fetch
	 * @param listOfIds the {@link Set} of ids to fetch
	 * @return a list of {@link EObject} or an empty list
	 */
	protected abstract List<EObject> fetchObjectsById(EClass eclass, Set<String> listOfIds);
	
	/**
	 * Executes a batch indexing or updating
	 * @param batch the list of objects 
	 * @param update <code>true</code>, if an update will be executed instead of an creation
	 * @param forceMerge if true forceMerge will be called on the index writer, will only considered for update == false
	 */
	private void doIndexBatch(List<EObject[]> batch, boolean update, boolean forceMerge) {
		IIndexer indexer = getIndexer();
		if (update) {
			indexer.batchUpdateMany(batch);
		} else {
			indexer.batchIndexMany(batch, forceMerge);
		}
	}
	
	/**
	 * Executes a batched indexing for all given objects
	 * @param objectToBatch the objects to index
	 * @param update <code>true</code>, if an update should be executed instead of index
	 * @return <code>true</code> on success, otherwise false
	 */
	private boolean doBatchedIndex(List<? extends EObject> objectToBatch, boolean update) {
		if (objectToBatch == null || objectToBatch.size() == 0) { 
			LOG.debug("There are no objects to rebuild/update an index from");
			return true;
		}
		String mode = update ? "UPDATE" : "INDEX";
		EClass indexClass = objectToBatch.get(0).eClass();
		try {
			List<EObject[]> batch = new ArrayList<EObject[]> (100);
			long start = System.currentTimeMillis();
			LOG.info("Start rebuilding index in mode: {} for all given objects of type: '{}'",  mode , indexClass.getName());
			int count = 1;
			for(EObject toIndex : objectToBatch){
				batch.add(new EObject[]{toIndex});
				
				if(count++ == 200){
					doIndexBatch(batch, update, false);
					count = 1;
					batch.clear();
					LOG.debug("Current index {}", objectToBatch.indexOf(toIndex));
				}
			}
			doIndexBatch(batch, update, false);
			LOG.info("Reindexing of all objects in mode: {} of type: '{}' finished and took: {} ms", mode, indexClass.getName(), (System.currentTimeMillis() - start));
			return true;
		} catch (Exception e) {
			throw new SearchIndexException("Error update index in mode: " + mode + " for type " + indexClass.getName(), e);
		}
	}

}
