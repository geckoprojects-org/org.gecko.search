/**
 * Copyright (c) 2012 - 2018 Data In Motion and others.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Data In Motion - initial API and implementation
 */
package org.gecko.search.suggest.api;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.gecko.search.api.IndexActionType;

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
 * @author ilenia
 * @since Nov 9, 2018
 */
public class SimpleSuggestionContext implements org.gecko.search.suggest.api.SuggestionContext{
	
		private final String payload;
		private final String content;
		private final long weight;
		private final String[] labels;
		private final IndexActionType action;
		private final Map<String, Object> properties = new HashMap<String, Object>();
		
		public SimpleSuggestionContext(IndexActionType action, String payload, String content, String[] labels, long weight) {
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
		public EObject getObject() {
			return null;
		}

	}

