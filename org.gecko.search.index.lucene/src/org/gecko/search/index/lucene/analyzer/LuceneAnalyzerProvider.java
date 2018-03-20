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
import org.apache.lucene.analysis.miscellaneous.PerFieldAnalyzerWrapper;
import org.gecko.searchindex.IndexDescriptor;

/**
 * Interface to register a {@link Analyzer} as OSGi service that is injected into the {@link LuceneAnalyzerRegistry}
 * @author Mark Hoffmann
 * @since 21.09.2014
 */
public interface LuceneAnalyzerProvider {
	
	/**
	 * Returns the id of the registered analyzer
	 * @return the id of the registered analyzer
	 */
	public String getId();
	
	/**
	 * Returns the analyzer
	 * @return the analyzer
	 */
	public Analyzer getAnalyzer();
	
	/**
	 * Returns a {@link PerFieldAnalyzerWrapper} with the provided analyzer as default
	 * @param descriptor the index descriptor to get the information about other analyzers
	 * @return the default analyzer or a {@link PerFieldAnalyzerWrapper}
	 */
	public Analyzer getAnalyzerForDescriptor(IndexDescriptor descriptor);

}
