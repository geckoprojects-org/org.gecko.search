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
package org.gecko.search.suggest.impl;

import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Set;

import org.apache.lucene.util.BytesRef;
import org.gecko.search.suggest.api.SuggestionContext;

/**
 * Index context that wraps a suggest context into the Lucene special data
 * @author Mark Hoffmann
 * @since 24.11.2018
 */
public class IndexContext {

	private final SuggestionContext<?> context;

	/**
	 * Creates a new instance.
	 */
	public IndexContext(SuggestionContext<?> context) {
		this.context = context;
	}
	
	/**
	 * Returns the original context
	 * @return the original context
	 */
	public SuggestionContext <?>getContext() {
		return context;
	}

	/**
	 * Returns the text context to be indexed
	 * @return the text context to be indexed
	 */
	public BytesRef content() {
		try {
			return new BytesRef(context.getContent().getBytes("UTF8")); 
		} catch (UnsupportedEncodingException e) {
			throw new IllegalStateException("Couldn't convert content to UTF-8", e);
		}
	}

	/**
	 * Returns the payload / key of instance
	 * @return the payload / key of instance
	 */
	public BytesRef payload() {
		try {
			return new BytesRef(context.getPayload().getBytes("UTF8"));
		} catch (UnsupportedEncodingException e) {
			throw new IllegalStateException("Couldn't convert payload to UTF-8", e);
		}
	}

	/**
	 * Returns the tags for that this element belongs to
	 * @return the tags for that this element belongs to
	 */
	public Set<BytesRef> labels() {           	
		try {
			Set<BytesRef> labels = new HashSet<BytesRef>();
			for (String label : context.getLabels()) {
				labels.add(new BytesRef(label.getBytes("UTF8")));
			}
			return labels;
		} catch (UnsupportedEncodingException e) {
			throw new IllegalStateException("Couldn't convert labels to UTF-8", e);
		}
	}

	/**
	 * Returns the index weight
	 * @return the index weight
	 */
	public long weight() {
		return context.getWeight();
	}

}
