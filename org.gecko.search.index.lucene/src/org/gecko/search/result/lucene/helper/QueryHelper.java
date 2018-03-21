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
package org.gecko.search.result.lucene.helper;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.Query;
import org.gecko.search.result.core.SearchResultException;
import org.gecko.search.result.core.queries.QueryBuilder;


/**
 * Helper for lucene queries
 * @author Juergen Albert
 * @since 21.11.2014
 */
public class QueryHelper{
	
	/**
	 * Creates a native query from the given Object. If it already is a {@link Query} it will simply return it. If it is a {@link QueryBuilder}, a query will be build with the given analyser
	 * @param nativeQuery the native query Object
	 * @param analyzer the analyser to use (can be null)
	 * @return a {@link Query}
	 */
	public static Query getFromNativQuery(Object nativeQuery, Analyzer analyzer) {
		if(nativeQuery instanceof Query){
			return (Query) nativeQuery;
		} else if(nativeQuery instanceof QueryBuilder && analyzer != null){
			QueryBuilder queryBuilder = (QueryBuilder) nativeQuery;
			String queryString = queryBuilder.createQueryString();
			QueryParser queryParser = new QueryParser(queryBuilder.getDefaultField(), analyzer);
			queryParser.setAllowLeadingWildcard(true);
			try {
				return queryParser.parse(queryString);
			} catch (ParseException e) {
				throw new SearchResultException("Cannot parse query string: (" + queryString + ")", e);
			}
		} else {
			throw new SearchResultException("The provided native query object is of type " + nativeQuery.getClass().getName() + " but should be " + Query.class.getName());
		}
	}
}

