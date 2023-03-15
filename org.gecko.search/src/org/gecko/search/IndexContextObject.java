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
package org.gecko.search;

import java.util.Map;

/**
 * A basic index context object.
 * @param <T> the object type
 * @author Mark Hoffmann
 * @since 08.03.2023
 */
public interface IndexContextObject<T> {
	
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
	 * Returns the original business object.
	 * @return the original business object.
	 */
	public T getObject();

}
