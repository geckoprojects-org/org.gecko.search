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
package org.gecko.search.suggest.context;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

import org.apache.lucene.util.BytesRef;

/**
 * Index context that wraps a suggest context into the Lucene special data
 * @author Mark Hoffmann
 * @since 24.11.2018
 */
public class IndexContext<O, F> {

	private final SuggestionContext<O, F> context;

	/**
	 * Creates a new instance.
	 */
	public IndexContext(SuggestionContext<O, F> context) {
		this.context = context;
	}
	
	/**
	 * Returns the original context
	 * @return the original context
	 */
	public SuggestionContext <O, F>getContext() {
		return context;
	}

	/**
	 * Returns the text context to be indexed
	 * @return the text context to be indexed
	 */
	public BytesRef content() {
		return new BytesRef(context.getContent().getBytes(StandardCharsets.UTF_8)); 
	}

	/**
	 * Returns the payload / key of instance
	 * @return the payload / key of instance
	 */
	public BytesRef payload() {
		return new BytesRef(context.getPayload().getBytes(StandardCharsets.UTF_8));
	}

	/**
	 * Returns the tags for that this element belongs to
	 * @return the tags for that this element belongs to
	 */
	public Set<BytesRef> labels() {           	
		Set<BytesRef> labels = new HashSet<>();
		for (String label : context.getLabels()) {
			labels.add(new BytesRef(label.getBytes(StandardCharsets.UTF_8)));
		}
		return labels;
	}

	/**
	 * Returns the index weight
	 * @return the index weight
	 */
	public long weight() {
		return context.getWeight();
	}

}
