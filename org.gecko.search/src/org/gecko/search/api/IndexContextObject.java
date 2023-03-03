/**
 * Copyright (c) 2012 - 2023 Data In Motion and others.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made available under the terms of the 
 * Eclipse Public License v2.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *     Data In Motion - initial API and implementation
 */
package org.gecko.search.api;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;

/**
 * A basic index context object.
 * @author Mark Hoffmann
 * @since 29.11.2018
 */
public interface IndexContextObject {
	
	/**
	 * Returns the action type that is published over the stream
	 * @return the action type
	 */
	public IndexActionType getActionType();
	
	/**
	 * Returns context properties
	 * @return context properties
	 */
	public Map<String, Object> getProperties();
	
	/**
	 * Returns the original {@link EObject}.
	 * @return the original {@link EObject}.
	 */
	public EObject getObject();

}
