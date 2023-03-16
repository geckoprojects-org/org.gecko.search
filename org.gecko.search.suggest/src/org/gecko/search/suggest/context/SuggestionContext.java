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

import java.util.Objects;

import org.gecko.search.IndexActionType;
import org.gecko.search.IndexContextObject;

/**
 * Context object for one suggest element to be indexed
 * @author ilenia
 * @since Nov 9, 2018
 */
public interface SuggestionContext<O, F> extends IndexContextObject<O> {	
	
	/**
	 * The content to be indexed
	 * @return the content to be indexed
	 */
	String getContent();
	
	/**
	 * The categories to put the index content in
	 * @return the categories to put the index content in
	 */
	String[] getLabels();
	
	/**
	 * The key or other payload for the underlying model 
	 * @return the key or other payload for the underlying model 
	 */
	String getPayload();
	
	/**
	 * The weight or boost of this element when indexing
	 * @return the weight or boost of this element when indexing
	 */
	long getWeight();
	
	/**
	 * Returns the source object's field
	 * @return the source object's field
	 */
	F getField();
	
	static <O, F> SuggestionContext<O, F> createAddContext(O object, F field, IndexActionType indexType, String payload, String content, String[] labels, long weight) {
		Objects.requireNonNull(object);
		Objects.requireNonNull(field);
		Objects.requireNonNull(indexType);
		Objects.requireNonNull(content);
		Objects.requireNonNull(labels);
		SuggestionContextImpl<O, F> sci = new SuggestionContextImpl<>(indexType, payload, content, labels, weight);
		sci.setField(field);
		sci.setObject(object);
		return sci;
	}
	
	static <O, F> SuggestionContextWrapper<O, F> toIndexContext(SuggestionContext<O, F> context) {
		Objects.requireNonNull(context);
		return new SuggestionContextWrapper<>(context);
	}

}
