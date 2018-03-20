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
package org.gecko.search.index.core.builder;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.gecko.search.index.core.SearchIndexException;
import org.gecko.searchindex.IndexDescriptor;
import org.gecko.searchindex.IndexField;

/**
 * Interface for a builder that creates an index model from a given {@link EObject}
 * @author Mark Hoffmann
 * @since 11.07.2014
 */
public interface IIndexDescriptorBuilder {
	
	/**
	 * Creates an {@link IndexDescriptor} from a given {@link EClass}'es
	 * @param eclasses the {@link EClass} array to create the {@link IndexDescriptor} from
	 * @return the {@link IndexDescriptor} instance
	 * @throws SearchIndexException thrown if an error during creation of the descriptor occurs
	 */
	public IndexDescriptor createIndexDescriptor(EClass... eclasses) throws SearchIndexException;
	
	/**
	 * Set this value to <code>true</code>, if the builder should follow
	 * containment references in the {@link EClass} to create {@link IndexField}'s
	 * @param follow <code>true</code>, if the builder should follow containment references to create {@link IndexField}'s
	 * @param depth number of hierarchies to follow, default is 1 step from the source {@link EClass}
	 */
	public void setFollowContainment(boolean follow, int depth);
	
	/**
	 * Set this value to <code>true</code>, if the builder should follow
	 * containment references in the {@link EClass} to create {@link IndexField}'s with a default hierarchy depth
	 * @param follow <code>true</code>, if the builder should follow containment references to create {@link IndexField}'s
	 */
	public void setFollowContainment(boolean follow);
	
	/**
	 * Returns <code>true</code>, if the containment references should be followed to create {@link IndexField}'s
	 * @return <code>true</code>, if the containment references should be followed to create {@link IndexField}'s
	 */
	public boolean isFollowContainment();
	
	
}
