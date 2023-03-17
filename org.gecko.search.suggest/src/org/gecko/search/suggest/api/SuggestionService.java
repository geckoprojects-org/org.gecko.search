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
package org.gecko.search.suggest.api;

import java.util.Map;

import org.osgi.util.promise.Promise;

/**
 * Service that provides auto completion proposals
 * @author Ilenia Salvadori
 * @since 09.11.2018
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
	 * @param string the string to be completed
	 * @param label the labels to look into
	 * @return a {@link Map} with proposed values and the payload as value
	 */
	public Map<String, String> getAutoCompletion(String string, String[] label);
	
	
	/**
	 * Resolves, when the initialization is done or otherwise with an error
	 * @return Promise that resolves when the initialization is done or otherwise with an error
	 */
	public Promise<Void> getInitializationPromise();
	
}
