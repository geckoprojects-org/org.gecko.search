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
package org.gecko.search.document.context;

import java.util.List;
import java.util.Map;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.Term;
import org.gecko.search.IndexActionType;
import org.gecko.search.document.CommitCallback;

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
