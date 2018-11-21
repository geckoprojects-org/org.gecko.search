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
package org.gecko.search.suggest.impl;

/**
 * This class defines the main parameters for the auto completion search, namely:
 * payload : this is the parameter associated with each search result that we want to get back
 * content : this is the parameter we want to make the auto completion against
 * weight  : this is currently equal to a constant but could be modify to list the search results 
 *           accordingly to some particular order
 * labels  : this is an array of strings which are used to filter the results belonging to some particular 
 *           category
 * 
 * @author ilenia
 * @since Nov 9, 2018
 */
public class SuggestContextImpl implements SuggestContext{
	
		private String payload;
		private String content;
		private long weight;
		private String[] labels;
		
		public SuggestContextImpl(String payload, String content, long weight, String[] labels) {
			this.payload = payload;
			this.content = content;
			this.weight = weight;
			this.labels = labels;
		}
		
		public String getContent() {
			return content;
		}
		
		public String[] getLabels() {
			return labels;
		}
		
		public String getPayload() {
			return payload;
		}
		
		public long getWeight() {
			return weight;
		}

	}

