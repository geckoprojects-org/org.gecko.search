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

import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.Term;
import org.gecko.search.api.IndexContextObject;

/**
 * {@link DocumentIndexContextObject} that represents one business object
 * @author jalbert
 * @since 30 Jan 2019
 */
public interface DocumentIndexContextObject extends IndexContextObject{
	
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
