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
package org.gecko.search.index.core.provider;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.gecko.searchindex.IndexDescriptor;
import org.gecko.searchindex.IndexFieldObject;
import org.gecko.searchindex.IndexObject;

/**
 * Interface that provides {@link IndexObject}'s from a given set of {@link EObject}'s
 * @author Mark Hoffmann
 * @since 05.08.2014
 */
public interface IIndexObjectProvider {
	
	/**
	 * Creates index objects for the given objects
	 * @param objects the object to create {@link IndexObject}'s from
	 * @return the index objects or an empty list
	 */
	public List<IndexObject> createIndexObjects(EObject... objects);
	
	/**
	 * Returns the Id fields of the given objects
	 * @param objects the object to get the id field for
	 * @return the list of id fields
	 */
	public List<IndexFieldObject> getIdFieldObjects(EObject... objects);
	
	/**
	 * Returns the path for the index 
	 * @param eClasses the {@link EClass} combination
	 * @return the path as String or <code>null</code>
	 */
	public String getIndexPath(EClass...eClasses);

	/**
	 * Returns the Analyizer Id that should be used for the given EObjects. 
	 * If nothing is specified in there descriptor it will return null;
	 * @param objects the Objects to look for
	 * @return the analizerId or null
	 */
	public String getAnalyizerid(EObject... objects);

	/**
	 * Returns the Analyizer Id that should be used for the given EObjects. 
	 * If nothing is specified in there descriptor it will return null;
	 * @param descriptor the {@link IndexDescriptor} to use
	 * @return the analizerId or null
	 */
	public String getAnalyizerid(IndexDescriptor descriptor);
}
