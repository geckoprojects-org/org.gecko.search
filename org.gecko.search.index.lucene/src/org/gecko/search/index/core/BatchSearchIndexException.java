/**
 * Copyright (c) 2014 Data In Motion and others.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Data In Motion - initial API and implementation
 */
package org.gecko.search.index.core;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Exception for the indexing part, that can contain multiple expetions if parts of the batche failed
 * @author Mark Hoffmann
 * @since 11.07.2014
 */
public class BatchSearchIndexException extends SearchIndexException {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	private List<? extends SearchIndexException> exceptions;
	
	/**
	 * Creates a new instance.
	 * @param message the exception message
	 * @param t the throwable instance
	 */
	public BatchSearchIndexException(String message, List<? extends SearchIndexException> exceptions) {
		super(message);
		this.exceptions = exceptions;
	}

	/**
	 * @return the exceptions the list of exceptions wrapped here
	 */
	public List<? extends SearchIndexException> getExceptions() {
		return exceptions;
	}

	/**
	 * Prints the Content of this wrapper as error to the log file
	 * @param log the {@link Logger} to use
	 */
	public void logContent(Logger log){
		logContent("", log);
	}
	
	/**
	 * Prints the Content of this wrapper as error to the log file with the given prefix. The prefix should be used as a line intend
	 * @param prefix the prefix or lineintend to use
	 * @param log the {@link Logger}
	 */
	private void logContent(String prefix, Logger log){
		log.severe(prefix + getMessage());
		String internalPrefix = prefix + "  "; 
		for (SearchIndexException searchIndexException : exceptions) {
			if(searchIndexException instanceof BatchSearchIndexException){
				((BatchSearchIndexException) searchIndexException).logContent(internalPrefix, log);
			} else {
				log.log(Level.SEVERE, internalPrefix + getMessage(), searchIndexException);
			}
		}
	}
}
