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

import java.util.HashMap;
import java.util.Map;

import org.gecko.search.IndexActionType;

/**
 * This class defines the main parameters for the auto completion search, namely:
 * payload : this is the parameter associated with each search result that we want to get back
 * content : this is the parameter we want to make the auto completion against
 * action : this is the parameter that tells us, whether to update, add or remove the element from the index
 * weight  : this is currently equal to a constant but could be modify to list the search results 
 *           accordingly to some particular order
 * labels  : this is an array of strings which are used to filter the results belonging to some particular 
 *           category
 * 
 * @param <O> the business object type
 * @param <F> the business object field type
 * @author Ilenia Salvadori, Mark Hoffmann
 * @since 09.03.2023
 */
public class SuggestionContextImpl<O, F> implements SuggestionContext<O, F>{
	
		private final String payload;
		private final String content;
		private final long weight;
		private final String[] labels;
		private final IndexActionType action;
		private final Map<String, Object> properties = new HashMap<>();
		private O sourceObject;
		private F field;
		
		SuggestionContextImpl(IndexActionType action, String payload, String content, String[] labels, long weight) {
			this.payload = payload;
			this.content = content;
			this.action = action;
			this.labels = labels;
			this.weight = weight;
		}
		
		/* 
		 * (non-Javadoc)
		 * @see org.gecko.search.suggest.api.SuggestionContext#getContent()
		 */
		public String getContent() {
			return content;
		}
		
		/* 
		 * (non-Javadoc)
		 * @see org.gecko.search.suggest.api.SuggestionContext#getLabels()
		 */
		public String[] getLabels() {
			return labels;
		}
		
		/* 
		 * (non-Javadoc)
		 * @see org.gecko.search.suggest.api.SuggestionContext#getPayload()
		 */
		public String getPayload() {
			return payload;
		}
		
		/* 
		 * (non-Javadoc)
		 * @see org.gecko.search.suggest.api.SuggestionContext#getWeight()
		 */
		public long getWeight() {
			return weight;
		}

		/* 
		 * (non-Javadoc)
		 * @see org.gecko.search.api.IndexContextObject#getActionType()
		 */
		@Override
		public IndexActionType getActionType() {
			return action;
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
		public O getObject() {
			return sourceObject;
		}
		
		public void setObject(O sourceObject) {
			this.sourceObject = sourceObject;
			
		}

		/* 
		 * (non-Javadoc)
		 * @see org.gecko.search.suggest.api.SuggestionContext#getField()
		 */
		@Override
		public F getField() {
			return field;
		}
		
		public void setField(F field) {
			this.field = field;
		}

	}

