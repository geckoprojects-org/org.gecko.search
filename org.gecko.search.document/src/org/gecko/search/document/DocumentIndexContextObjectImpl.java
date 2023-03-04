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

import java.util.Collections;
import java.util.List;
import java.util.Map;

import jakarta.annotation.Generated;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.Term;
import org.eclipse.emf.ecore.EObject;
import org.gecko.search.api.IndexActionType;

/**
 * Implementation for {@link DocumentIndexContextObject} for {@link EObject}'s
 * @author jalbert
 * @since 30 Jan 2019
 */
public class DocumentIndexContextObjectImpl implements DocumentIndexContextObject{

	private final IndexActionType indexActionType;
	private final Map<String, Object> properties;
	private final EObject sourceObject;
	private final List<Document> documents;
	private final Term identifyingTerm;
	private final CommitCallback commitCallback;


	@Generated("SparkTools")
	private DocumentIndexContextObjectImpl(Builder builder) {
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
	public EObject getObject() {
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

	/**
	 * Creates builder to build {@link DocumentIndexContextObjectImpl}.
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link DocumentIndexContextObjectImpl}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private IndexActionType indexActionType;
		private Map<String, Object> properties = Collections.emptyMap();
		private EObject sourceObject;
		private List<Document> documents = Collections.emptyList();
		private Term identifyingTerm;
		private CommitCallback commitCallback;

		private Builder() {
		}

		public Builder withIndexActionType(IndexActionType indexActionType) {
			this.indexActionType = indexActionType;
			return this;
		}

		public Builder withProperties(Map<String, Object> properties) {
			this.properties = properties;
			return this;
		}

		public Builder withSourceObject(EObject sourceObject) {
			this.sourceObject = sourceObject;
			return this;
		}

		public Builder withDocuments(List<Document> documents) {
			this.documents = documents;
			return this;
		}

		public Builder withIdentifyingTerm(Term identifyingTerm) {
			this.identifyingTerm = identifyingTerm;
			return this;
		}

		public Builder withCommitCallback(CommitCallback commitCallback) {
			this.commitCallback = commitCallback;
			return this;
		}

		public DocumentIndexContextObjectImpl build() {
			return new DocumentIndexContextObjectImpl(this);
		}
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
