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

import java.util.Map;

/**
 * Service that provides auto completion proposals
 * @author ilenia
 * @since Nov 9, 2018
 */
public interface SuggestionService {
	
	public static final String SUGGESTION_PS_FACTORY = "PushstreamSuggestionServiceFactory";
	public static final String SUGGESTION_FACTORY = "SuggestionServiceFactory";
	public static final String PROP_SUGGESTION_NAME = "suggestion.name";
	public static final String PROP_SUGGESTION_INDEX = "suggestion.index";
	public static final String PROP_SUGGESTION_RESULT_SIZE = "suggestion.resultSize";
	
	/**
	 * This method is the one which computes the actual auto completion. It takes as input parameter the 
	 * string we want to auto complete and an array of strings in which we can specify whether we want to look
	 * only among data of some particular category. 
	 * It returns a map with the proposed auto-completed string as key and the payload as value. 
	 * 
	 */
	public Map<String, String> getAutoCompletion(String string, String[] label);

}
