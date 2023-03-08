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

import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.Term;
import org.gecko.search.api.IndexContextObject;

/**
 * {@link DocumentIndexContextObject} that represents one business object
 * @param <T> business object type
 * @author Jürgen Albert, Mark Hoffmann
 * @since 08.03.2023
 */
public interface DocumentIndexContextObject<T> extends IndexContextObject<T>{
	
	/**
	 * Get all Lucene {@link Document} representations for the business object (because of different languages)
	 * @return
	 */
	List<Document> getDocuments();
	
	/**
	 * Returns the identifying term for the business object
	 * @return the identifying term for the business object
	 */
	Term getIdentifyingTerm();
	
	/**
	 * Returns a commit callback, if set
	 * @return the commit callbacl or <code>null</code>
	 */
	CommitCallback getCommitCallback();

}
