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
package org.gecko.emf.search.document;

import java.util.List;
import java.util.Map;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.Term;
import org.eclipse.emf.ecore.EObject;
import org.gecko.search.api.IndexActionType;
import org.gecko.search.document.AbstractContextObjectBuilder;
import org.gecko.search.document.CommitCallback;

/**
 * {@link EObject} typed context object builder
 * @author Mark Hoffmann
 * @since 08.03.2023
 */
public class EObjectContextObjectBuilder extends AbstractContextObjectBuilder<EObject, EObjectDocumentIndexObjectContext> {

	/**
	 * Creates a new instance.
	 */
	protected EObjectContextObjectBuilder() {
	}
	
	public static EObjectContextObjectBuilder create() {
		return new EObjectContextObjectBuilder();
	}
	
	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.document.AbstractContextObjectBuilder#build()
	 */
	@Override
	public EObjectDocumentIndexObjectContext build() {
		return new EObjectDocumentIndexObjectContext() {
			
			@Override
			public Map<String, Object> getProperties() {
				return properties;
			}
			
			@Override
			public EObject getObject() {
				return sourceObject;
			}
			
			@Override
			public IndexActionType getActionType() {
				return indexActionType;
			}
			
			@Override
			public Term getIdentifyingTerm() {
				return identifyingTerm;
			}
			
			@Override
			public List<Document> getDocuments() {
				return documents;
			}
			
			@Override
			public CommitCallback getCommitCallback() {
				return commitCallback;
			}
		};
	}
}
