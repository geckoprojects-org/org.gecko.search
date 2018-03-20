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
package org.gecko.search.converter;

/**
 * Converter that converts the original value into the index field values
 * @author Mark Hoffmann
 * @since 04.08.2014
 */
public interface IIndexConverter {
	
	/**
	 * Returns the id that identifies the converter
	 * @return the id that identifies the converter
	 */
	public String getConverterId();
	
	/**
	 * Returns the from type
	 * @return the from type
	 */
	public Class<?> getFromType();
	
	/**
	 * Returns the to type
	 * @return the to type
	 */
	public Class<?> getToType();
	
	/**
	 * Converts the from object
	 * @param fromObject the object to convert into the to type
	 * @return the converted objects
	 */
	public Object convert(Object fromObject);

}
