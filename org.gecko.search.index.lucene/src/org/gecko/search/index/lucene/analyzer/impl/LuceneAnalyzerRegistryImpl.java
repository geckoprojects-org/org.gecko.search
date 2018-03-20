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

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.lucene.analysis.Analyzer;
import org.gecko.search.index.lucene.analyzer.LuceneAnalyzerProvider;
import org.gecko.search.index.lucene.analyzer.LuceneAnalyzerRegistry;

/**
 * Implementation of the {@link LuceneAnalyzerRegistry}
 * @author Mark Hoffmann
 * @since 21.09.2014
 */
public class LuceneAnalyzerRegistryImpl implements LuceneAnalyzerRegistry {
	
	private final Map<String, Analyzer> analyzerMap = new ConcurrentHashMap<String, Analyzer>();
	private final List<LuceneAnalyzerProvider> providerList = new LinkedList<LuceneAnalyzerProvider>();
	
	/**
	 * Creates a new instance.
	 */
	public LuceneAnalyzerRegistryImpl() {
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.lucene.LuceneAnalyzerRegistry#getAnalyzer(java.lang.String)
	 */
	@Override
	public Analyzer getAnalyzer(String id) {
		return analyzerMap.get(id);
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.lucene.LuceneAnalyzerRegistry#isAnalyzerRegistered(java.lang.String)
	 */
	@Override
	public boolean isAnalyzerRegistered(String id) {
		return analyzerMap.containsKey(id);
	}
	
	/**
	 * Adds a {@link LuceneAnalyzerProvider}
	 * @param provider the provider to add
	 */
	public void addAnalyzerProvider(LuceneAnalyzerProvider provider) {
		if (provider == null || provider.getId() == null || provider.getAnalyzer() == null) {
			return;
		}
		providerList.add(provider);
		analyzerMap.put(provider.getId(), provider.getAnalyzer());
	}
	
	
	/**
	 * Removes a {@link LuceneAnalyzerProvider}
	 * @param provider the provider to remove
	 */
	public void removeAnalyzerProvider(LuceneAnalyzerProvider provider) {
		if (provider == null || provider.getId() == null) {
			return;
		}
		providerList.remove(provider);
		analyzerMap.remove(provider.getId());
	}
	
	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.lucene.analyzer.LuceneAnalyzerRegistry#dispose()
	 */
	public void dispose() {
		providerList.clear();
		analyzerMap.clear();
	}
	
}
