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
package org.gecko.search.result.lucene.query;

import org.apache.lucene.search.IndexSearcher;


/**
 * can be used to get the {@link ISearchResultContext} in the collector
 * @author Juergen Albert
 */
public interface ICollectorConfigurator {

	/**
	 * @param ctx the {@link ISearchResultContext} of the last current search
	 */
	public void setISearchResultContext(ISearchResultContext ctx);
	
	/**
	 * @param searcher the {@link IndexSearcher} that might be used for Highlighting
	 */
	public void setIndexSearcher(IndexSearcher searcher);

	/**
	 * will be called after all setters are filed. Can be used to prepare something
	 */
	public void prepare();
}
