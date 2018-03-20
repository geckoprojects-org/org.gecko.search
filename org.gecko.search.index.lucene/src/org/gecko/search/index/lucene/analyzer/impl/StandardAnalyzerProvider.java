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
package org.gecko.search.index.lucene.analyzer.impl;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.gecko.search.index.lucene.analyzer.AnalyzerFieldProvider;
import org.gecko.search.index.lucene.analyzer.LuceneAnalyzerProvider;
import org.gecko.searchindex.IndexDescriptor;

/**
 * Implementation to provider the default {@link Analyzer}
 * @author Mark Hoffmann
 * @since 21.09.2014
 */
public class StandardAnalyzerProvider extends AnalyzerFieldProvider implements LuceneAnalyzerProvider {
	
	private Analyzer analyzer = null;
	
	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.lucene.LuceneAnalyzerProvider#getId()
	 */
	@Override
	public String getId() {
		return "default";
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.lucene.LuceneAnalyzerProvider#getAnalyzer()
	 */
	@Override
	public Analyzer getAnalyzer() {
		if (analyzer == null) {
			analyzer = new StandardAnalyzer();
		}
		return analyzer;
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.lucene.analyzer.LuceneAnalyzerProvider#getAnalyzerForDescriptor(de.dim.searchindex.IndexDescriptor)
	 */
	@Override
	public Analyzer getAnalyzerForDescriptor(IndexDescriptor descriptor) {
		return getWrappedAnalyzer(getAnalyzer(), descriptor);
	}
	
}
