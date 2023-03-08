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
import java.util.Map;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.Term;
import org.gecko.search.api.IndexActionType;

/**
 * Implementation for {@link DocumentIndexContextObject} for business objects's
 * @param <T> the business object type
 * @author Jürgen Albert, Mark Hoffmann
 * @since 08.03.2023
 */
public class DocumentIndexContextObjectImpl<T> implements DocumentIndexContextObject<T>{

	private final IndexActionType indexActionType;
	private final Map<String, Object> properties;
	private final T sourceObject;
	private final List<Document> documents;
	private final Term identifyingTerm;
	private final CommitCallback commitCallback;

	private DocumentIndexContextObjectImpl(AbstractContextObjectBuilder<T, ?> builder) {
		this.indexActionType = builder.indexActionType;
		this.properties = builder.properties;
		this.sourceObject = builder.sourceObject;
		this.documents = builder.documents;
		this.identifyingTerm = builder.identifyingTerm;
		this.commitCallback = builder.commitCallback;
	}


	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.api.IndexContextObject#getActionType()
	 */
	@Override
	public IndexActionType getActionType() {
		return indexActionType;
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.api.IndexContextObject#getProperties()
	 */
	@Override
	public Map<String, Object> getProperties() {
		return properties;
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.api.IndexContextObject#getObject()
	 */
	@Override
	public T getObject() {
		return sourceObject;
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.document.DocumentIndexContextObject#getDocuments()
	 */
	@Override
	public List<Document> getDocuments() {
		return documents;
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.document.DocumentIndexContextObject#getIdentifyingTerm()
	 */
	@Override
	public Term getIdentifyingTerm() {
		return identifyingTerm;
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.document.DocumentIndexContextObject#getCommitCallback()
	 */
	@Override
	public CommitCallback getCommitCallback() {
		return commitCallback;
	}

}
