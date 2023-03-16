/**
 * Copyright (c) 2012 - 2023 Data In Motion and others.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *     Data In Motion - initial API and implementation
 */
package org.gecko.search.document;

import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.SearcherManager;
import org.gecko.search.IndexService;
import org.gecko.search.document.context.DocumentIndexContextObject;
import org.osgi.annotation.versioning.ProviderType;
import org.osgi.util.promise.Promise;

/**
 * Index service for Lucene
 * @param <T> the business object type
 * @author Juergen Albert, Mark Hoffmann
 * @since 08.03.2023
 */
@ProviderType
public interface LuceneIndexService<D extends DocumentIndexContextObject<?>> extends IndexService<D> {

	/**
	 * Returns the {@link IndexWriter}
	 * @return the wrapped {@link IndexWriter}
	 */
	IndexWriter getIndexWriter();

	/**
	 * Returns a {@link IndexSearcher} usually acquired from the underlying {@link SearcherManager}
	 * @return acquires a {@link IndexSearcher}
	 */
	IndexSearcher aquireSearcher();

	/**
	 * Hands over the given {@link IndexSearcher} to the underlying {@link SearcherManager} for release 
	 * @param searcher the {@link IndexSearcher} to release
	 */
	void releaseSearcher(IndexSearcher searcher);

	/**
	 * Commits the underlying {@link IndexWriter} and refreshes the {@link SearcherManager}.
	 * Note that commits directly on the obtained {@link IndexWriter} will not be reflected to the {@link SearcherManager}  
	 * @return the {@link Promise} that resolves, when the commit is done or an error occurred
	 */
	Promise<Void> commit();

}
