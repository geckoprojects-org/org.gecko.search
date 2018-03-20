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

import java.util.HashMap;
import java.util.Map;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.da.DanishAnalyzer;
import org.apache.lucene.analysis.de.GermanAnalyzer;
import org.apache.lucene.analysis.es.SpanishAnalyzer;
import org.apache.lucene.analysis.fi.FinnishAnalyzer;
import org.apache.lucene.analysis.fr.FrenchAnalyzer;
import org.apache.lucene.analysis.it.ItalianAnalyzer;
import org.apache.lucene.analysis.nl.DutchAnalyzer;
import org.apache.lucene.analysis.ru.RussianAnalyzer;
import org.apache.lucene.analysis.sv.SwedishAnalyzer;
import org.gecko.search.core.exceptions.SearchException;
import org.gecko.search.index.lucene.analyzer.AnalyzerFieldProvider;
import org.gecko.search.index.lucene.analyzer.LuceneAnalyzerProvider;
import org.gecko.searchindex.IndexDescriptor;

/**
 * 
 * @author mark
 * @since 16.10.2014
 */
public class LanguageAnalyzerProvider extends AnalyzerFieldProvider implements LuceneAnalyzerProvider {
	
	/** LANGUAGE_PROPERTY */
	public static final String LANGUAGE_PROPERTY = "languageCode";
	private final Map<String, Analyzer> analyzerMap = new HashMap<String, Analyzer>();
	private String currentLanguage = null;
	private Analyzer currentAnalyzer = null;
	
	/**
	 * Initializes the registry
	 */
	private void doInitialize() {
		analyzerMap.clear();
		analyzerMap.put("de", new GermanAnalyzer());
		analyzerMap.put("fr", new FrenchAnalyzer());
		analyzerMap.put("es", new SpanishAnalyzer());
		analyzerMap.put("it", new ItalianAnalyzer());
		analyzerMap.put("ru", new RussianAnalyzer());
		analyzerMap.put("fi", new FinnishAnalyzer());
		analyzerMap.put("sv", new SwedishAnalyzer());
		analyzerMap.put("sv", new SwedishAnalyzer());
		analyzerMap.put("nl", new DutchAnalyzer());
		analyzerMap.put("da", new DanishAnalyzer());
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.lucene.analyzer.LuceneAnalyzerProvider#getId()
	 */
	@Override
	public String getId() {
		return currentLanguage;
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.lucene.analyzer.LuceneAnalyzerProvider#getAnalyzer()
	 */
	@Override
	public Analyzer getAnalyzer() {
		return currentAnalyzer;
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.lucene.analyzer.LuceneAnalyzerProvider#getAnalyzerForDescriptor(de.dim.searchindex.IndexDescriptor)
	 */
	@Override
	public Analyzer getAnalyzerForDescriptor(IndexDescriptor descriptor) {
		return getWrappedAnalyzer(currentAnalyzer, descriptor);
	}
	
	/**
	 * Initializes the service
	 * @param properties the map with properties that expects the property 'languageCode'
	 */
	public void initialize(Map<String, ? extends Object> properties) {
		doInitialize();
		String language = (String) properties.get(LANGUAGE_PROPERTY);
		if (language == null || !analyzerMap.containsKey(language.toLowerCase())) {
			throw new SearchException("Error initializing LanguageAnaylzerProvider with invalid language code: " + language + " (expected: e.g. de, fr, en)");
		}
		currentLanguage = language;
		currentAnalyzer = analyzerMap.get(language);
	}

}
