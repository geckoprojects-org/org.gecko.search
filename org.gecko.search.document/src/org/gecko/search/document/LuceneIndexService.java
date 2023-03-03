/**
 * Copyright (c) 2012 - 2023 Data In Motion and others.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made available under the terms of the 
 * Eclipse Public License v2.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *     Data In Motion - initial API and implementation
 */
package org.gecko.search.document;

import java.util.Collection;

import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.SearcherManager;
import org.osgi.annotation.versioning.ProviderType;

/**
 * Index service for Lucene
 * @author Juergen Albert
 * @since 30 Jan 2019
 */
@ProviderType
public interface LuceneIndexService {

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
	 */
	void commit();

	/**
	 * Adds the given {@link DocumentIndexContextObject} to the queue to be indexed according to the configuration
	 * @param context
	 */
	void handleContext(DocumentIndexContextObject context);

	/**
	 * Adds the given {@link Collection} of DocumentIndexContextObject}s to the queue to be indexed according to the configuration
	 * @param contexts
	 */
	void handleContexts(Collection<? extends DocumentIndexContextObject> contexts);

	/**
	 * Immediately handles the given the given {@link Collection} of DocumentIndexContextObject}s and commits the index.
	 * @param contexts
	 */
	void handleContextsSync(Collection<? extends DocumentIndexContextObject> contexts);

	/**
	 * Immediately handles the given the given {@link Collection} of DocumentIndexContextObject}s and commits the index.
	 * @param contexts
	 */
	void handleContextSync(DocumentIndexContextObject context);

}
