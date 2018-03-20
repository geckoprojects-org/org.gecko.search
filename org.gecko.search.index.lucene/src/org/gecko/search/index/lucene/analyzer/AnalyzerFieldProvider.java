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

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.LowerCaseFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.core.KeywordAnalyzer;
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.analysis.miscellaneous.PerFieldAnalyzerWrapper;
import org.apache.lucene.analysis.shingle.ShingleFilter;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.gecko.searchindex.IndexDescriptor;
import org.gecko.searchindex.IndexField;

/**
 * Class provides special analyzers for a given {@link IndexField}
 * @author Mark Hoffmann
 * @since 16.10.2014
 */
public class AnalyzerFieldProvider {
	
	/**
	 * Returns a wrapped {@link PerFieldAnalyzerWrapper} or the default analyzer depending on the index descriptor configuration
	 * @param defaultAnalyzer the default analyzer
	 * @param descriptor the index descriptor
	 * @return a wrapped {@link PerFieldAnalyzerWrapper} or the default analyzer depending on the index descriptor configuration
	 */
	public Analyzer getWrappedAnalyzer(Analyzer defaultAnalyzer, IndexDescriptor descriptor) {
		if (defaultAnalyzer == null || descriptor == null) {
			return null;
		}
		Map<String, Analyzer> fieldAnalyzerMap = getFieldAnalyzerMap(descriptor);
		if (fieldAnalyzerMap.isEmpty()) {
			return defaultAnalyzer;
		} else {
			return new PerFieldAnalyzerWrapper(defaultAnalyzer, fieldAnalyzerMap);
		}
	}
	
	/**
	 * Creates a field to analyzer map for the given descriptor
	 * @param descriptor the index descriptor
	 * @return the map with field name and analyzer or an empty map
	 */
	protected Map<String, Analyzer> getFieldAnalyzerMap(IndexDescriptor descriptor) {
		if (descriptor == null) {
			return Collections.emptyMap();
		}
		Map<String, Analyzer> fieldAnalyzerMap = new HashMap<String, Analyzer>();
		for (IndexField field : descriptor.getFields()) {
			Analyzer a = getAnalyzerForField(field);
			if (a != null) {
				fieldAnalyzerMap.put(field.getKey(), a);
			}
		}
		return fieldAnalyzerMap;
	}
	
	/**
	 * Returns the {@link Analyzer} for the given field or <code>null</code>
	 * @param field the index field
	 * @return the analyzer or <code>null</code>
	 */
	protected Analyzer getAnalyzerForField(IndexField field) {
		if (field == null) {
			return null;
		}
		switch (field.getType()) {
			case STANDARD:
				return new StandardAnalyzer();
			case ENUM:
				return new KeywordAnalyzer();
			case WHITESPACE:
				return new WhitespaceAnalyzer();
			case SHINGLE:
				return new Analyzer() {

					@Override
					protected TokenStreamComponents createComponents(String fieldName) {
						 final StandardTokenizer src = new StandardTokenizer();
						 TokenStream tok = new LowerCaseFilter(src);
						     tok = new ShingleFilter(tok, 6);
						    return new TokenStreamComponents(src, tok) ;
					}
		        };
			default:
				break;
		}
		return null;
	}
}
