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

import java.util.Collection;

import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.SearcherManager;
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
public interface LuceneIndexService<D extends DocumentIndexContextObject<?>> {

	/**
	 * @return the wrapped {@link IndexWriter}
	 */
	IndexWriter getIndexWriter();

	/**
	 * @return aquires a {@link IndexSearcher} from the underlying {@link SearcherManager}
	 */
	IndexSearcher aquireSearch();

	/**
	 * Hands over the given {@link IndexSearcher} to the underlying {@link SearcherManager} for release 
	 * @param searcher the {@link IndexSearcher} to release
	 */
	void releaseSearcher(IndexSearcher searcher);

	/**
	 * Commits the underlying {@link IndexWriter} and refreshes the {@link SearcherManager}.
	 * Note that commits directly on the obtained {@link IndexWriter} will not be reflected to the {@link SearcherManager}  
	 * @return the {@link Promise} that resolves if commit succeeded or an error
	 */
	Promise<Void> commit();

	/**
	 * Adds the given {@link DocumentIndexContextObject} to the queue to be indexed according to the configuration
	 * @param context the {@link DocumentIndexContextObject}
	 * @return a {@link Promise} that resolves, if the indexing finished or with the error 
	 */
	Promise<Void> handleContext(D context);

	/**
	 * Adds the given {@link Collection} of DocumentIndexContextObject}s to the queue to be indexed according to the configuration
	 * @param context the {@link DocumentIndexContextObject}
	 * @return a {@link Promise} that resolves, if the indexing finished or with the error 
	 */
	Promise<Void> handleContexts(Collection<D> contexts);

	/**
	 * Immediately handles the given the given {@link Collection} of DocumentIndexContextObject}s and commits the index.
	 * @param contexts
	 */
	void handleContextsSync(Collection<D> contexts);

	/**
	 * Immediately handles the given the given {@link Collection} of DocumentIndexContextObject}s and commits the index.
	 * @param contexts
	 */
	void handleContextSync(D context);

}
