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

import java.util.List;
import java.util.Map;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.Term;
import org.gecko.search.api.IndexActionType;

/**
 * Default implementation for Object types 
 * @author Mark Hoffmann
 * @since 08.03.2023
 */
public class ObjectContextBuilder extends AbstractContextObjectBuilder<Object, ObjectContextObject>{

	protected ObjectContextBuilder() {
	}
	
	public static ObjectContextBuilder create() {
		return new ObjectContextBuilder();
	}
	
	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.document.AbstractContextObjectBuilder#build()
	 */
	@Override
	public ObjectContextObject build() {
		return new ObjectContextObject() {
			
			@Override
			public Map<String, Object> getProperties() {
				return properties;
			}
			
			@Override
			public Object getObject() {
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
