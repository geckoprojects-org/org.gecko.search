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

import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Sort;
import org.gecko.searchresult.FilterField;
import org.gecko.searchresult.QueryObject;
import org.gecko.searchresult.SortField;

/**
 * Interface that provides Lucene queries for given model queries
 * @author Mark Hoffmann
 * @since 08.08.2014
 */
public interface ILuceneQueryProvider {
	
	/**
	 * Creates a Lucene query from the result model query
	 * @param queryObject the query model
	 * @return the Lucene query object
	 */
	public Query createQuery(QueryObject queryObject);
	/**
	 * Creates a Lucene query from the result model query
	 * @param queryObject the query model
	 * @param analyzer the analyser to use. Can be null
	 * @return the Lucene query object
	 */
	public Query createQuery(QueryObject queryObject, Analyzer analyzer);

	/**
	 * Creates a Lucene filter from the result model query
	 * @param queryObject the query model
	 * @return the Lucene filter object
	 */
	public Query createFilter(QueryObject queryObject);
	
	/**
	 * Creates a Lucene filter from the given filter fields
	 * @param filterFields the filter fields
	 * @return the Lucene filter object
	 */
	public Query createFilter(List<FilterField> filterFields);
	
	/**
	 * Creates a Lucene sort from the result model query
	 * @param queryObject the query model
	 * @return the Lucene sort object
	 */
	public Sort createSort(QueryObject queryObject);
	
	/**
	 * Creates a Lucene sort from the given sort fields
	 * @param sortFields the list of sort fields
	 * @return the Lucene sort object
	 */
	public Sort createSort(List<SortField> sortFields);


}
