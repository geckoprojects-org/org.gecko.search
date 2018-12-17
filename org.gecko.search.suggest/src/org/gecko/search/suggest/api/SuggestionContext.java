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

import org.gecko.search.api.IndexContextObject;

/**
 * Context object for one suggest element to be indexed
 * @author ilenia
 * @since Nov 9, 2018
 */
public interface SuggestionContext extends IndexContextObject {	
	
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

}
