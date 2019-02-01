/**
 * Copyright (c) 2012 - 2019 Data In Motion and others.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
 * 
 * @author jalbert
 * @since 30 Jan 2019
 */
public interface DocumentIndexContextObject extends IndexContextObject{
	
	List<Document> getDocuments();
	
	Term getIdentifyingTerm();
	
	CommitCallback getCommitCallback();

}
