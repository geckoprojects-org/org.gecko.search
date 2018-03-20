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
package org.gecko.search.core.exceptions;

/**
 * Base search runtime exception
 * @author Mark Hoffmanns
 * @since 10.08.2014
 */
public class SearchException extends RuntimeException {
	
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Creates a new instance.
	 * @param message the exception message
	 */
	public SearchException(String message) {
		super(message);
	}
	
	/**
	 * Creates a new instance.
	 * @param message the exception message
	 * @param t the throwable instance
	 */
	public SearchException(String message, Throwable t) {
		super(message, t);
	}

}
