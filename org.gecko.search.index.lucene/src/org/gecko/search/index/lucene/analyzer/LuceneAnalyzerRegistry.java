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
package org.gecko.search.index.lucene.analyzer;

import org.apache.lucene.analysis.Analyzer;

/**
 * Interface for a analyzer providers
 * @author Mark Hoffmann
 * @since 21.09.2014
 */
public interface LuceneAnalyzerRegistry {
	
	/**
	 * Returns the {@link Analyzer} for the given id or <code>null</code>
	 * @param id the id the {@link Analyzer} is registered upon
	 * @return the {@link Analyzer} or <code>null</code>
	 */
	public Analyzer getAnalyzer(String id);
	
	/**
	 * Returns <code>true</code> if a {@link Analyzer} for the given id exists
	 * @param id the id the {@link Analyzer} is registered upon
	 * @return <code>true</code> if a {@link Analyzer} for the given id exists
	 */
	public boolean isAnalyzerRegistered(String id);
	
	/**
	 * Cleans up the registry
	 */
	public void dispose();

}
