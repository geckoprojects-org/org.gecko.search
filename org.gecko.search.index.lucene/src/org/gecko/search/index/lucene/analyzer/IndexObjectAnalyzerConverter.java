package org.gecko.search.index.lucene.analyzer;


/**
 * Converter interface to provide a analyzer id for a given document
 * @author Mark Hoffmann
 * @since 21.09.2014
 */
public interface IndexObjectAnalyzerConverter {
	
	/**
	 * Returns the field name that holds the analyzer information
	 * @return the field name that holds the analyzer information
	 */
	public String getAnalyzerFieldName();
	
	/**
	 * Returns the analyzer id for a given document
	 * @param indexObject the document to get the analyzer for
	 * @return the analyzer id for a given document
	 */
	public String convertToAnalyzerId(String analyzerFieldValue);

}