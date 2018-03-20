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
package org.gecko.search.converter.registry;

import org.gecko.search.converter.IIndexConverter;

/**
 * Registry for {@link IIndexConverter}
 * @author Mark Hoffmann
 * @since 04.08.2014
 */
public interface IIndexConverterRegistry {
	
	/**
	 * Returns the converter for the given id or <code>null</code>
	 * @param converterId the converter id
	 * @return the converter for the given id or <code>null</code>
	 */
	public IIndexConverter getConverter(String converterId); 
	
	/**
	 * Returns <code>true</code>, if there is a converter with the given id
	 * @param converterId the id of the converter to check for existence
	 * @return <code>true</code>, if there is a converter with the given id
	 */
	public boolean hasConverter(String converterId);

}
