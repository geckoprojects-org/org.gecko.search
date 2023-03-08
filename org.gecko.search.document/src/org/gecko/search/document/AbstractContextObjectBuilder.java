/**
 * Copyright (c) 2012 - 2023 Data In Motion and others.
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

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.Term;
import org.gecko.search.api.IndexActionType;

/**
 * Abstract builder for {@link DocumentIndexContextObject}
 * @author Mark Hoffmann
 * @since 08.03.2023
 */
public abstract class AbstractContextObjectBuilder<T, DICO extends DocumentIndexContextObject<?>> {
	protected IndexActionType indexActionType;
	protected Map<String, Object> properties = Collections.emptyMap();
	protected T sourceObject;
	protected List<Document> documents = Collections.emptyList();
	protected Term identifyingTerm;
	protected CommitCallback commitCallback;

	protected AbstractContextObjectBuilder() {
	}

	public AbstractContextObjectBuilder<T, DICO> withIndexActionType(IndexActionType indexActionType) {
		this.indexActionType = indexActionType;
		return this;
	}

	public AbstractContextObjectBuilder<T, DICO> withProperties(Map<String, Object> properties) {
		this.properties = properties;
		return this;
	}

	public AbstractContextObjectBuilder<T, DICO> withSourceObject(T sourceObject) {
		this.sourceObject = sourceObject;
		return this;
	}

	public AbstractContextObjectBuilder<T, DICO> withDocuments(List<Document> documents) {
		this.documents = documents;
		return this;
	}

	public AbstractContextObjectBuilder<T, DICO> withIdentifyingTerm(Term identifyingTerm) {
		this.identifyingTerm = identifyingTerm;
		return this;
	}

	public AbstractContextObjectBuilder<T, DICO> withCommitCallback(CommitCallback commitCallback) {
		this.commitCallback = commitCallback;
		return this;
	}

	public abstract DICO build();
}
