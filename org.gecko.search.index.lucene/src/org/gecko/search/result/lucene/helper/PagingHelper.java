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

/**
 * Helper for calculating paging
 * @author Juergen Albert
 * @since 03.11.2015
 */
public class PagingHelper {

	/**
	 * Calculates the start index for the results from the input parameters.
	 * @param parameters the input objects
	 * @return the max result value
	 */
	public static int calculateResultStartIndex(Integer pageNumberObject, Integer pageSizeObject) {
		int pageNumber = -1;
		int pageSize = -1;
		int startIndex = 0;
		if (pageNumberObject != null && pageNumberObject > 0 &&
				pageSizeObject != null && pageSizeObject > 0) {
			pageNumber = pageNumberObject;
			pageSize = pageSizeObject;
			startIndex = pageNumber * pageSize - pageSize;
		}
		return startIndex < 0 ? 0 : startIndex;
	}
	
	/**
	 * Calculates the page size from the result size and the size per page. 
	 * @param results all results
	 * @param resultsPerPage results per page
	 * @return the page size or 0
	 */
	public static int getPageSize(int results, int resultsPerPage) {
		if (results < 0 || resultsPerPage <= 0) {
			return 0;
		}
		int rest = results % resultsPerPage;
		int pages = results/resultsPerPage;
		return rest == 0 ? pages : pages + 1;
	}
	
}
