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
package org.gecko.search.converter.impls;

import org.gecko.search.converter.IIndexConverter;
import org.osgi.service.component.annotations.Component;

/**
 * A Simple Provider hat converts a String to an Integer
 * @author Jürgen Albert
 * @since 21.08.2014
 *
 */
@Component(enabled = true)
public class StringToIntegerConverter implements IIndexConverter {

	private static final String CONVERTER_ID = "stringToInteger";
	
	/* (non-Javadoc)
	 * @see de.dim.search.converter.IIndexConverter#getConverterId()
	 */
	@Override
	public String getConverterId() {
		return CONVERTER_ID;
	}

	/* (non-Javadoc)
	 * @see de.dim.search.converter.IIndexConverter#getFromType()
	 */
	@Override
	public Class<?> getFromType() {
		return String.class;
	}

	/* (non-Javadoc)
	 * @see de.dim.search.converter.IIndexConverter#getToType()
	 */
	@Override
	public Class<?> getToType() {
		return Integer.class;
	}

	/* (non-Javadoc)
	 * @see de.dim.search.converter.IIndexConverter#convert(java.lang.Object)
	 */
	@Override
	public Object convert(Object fromObject) {
		if(fromObject != null && fromObject instanceof String){
			return Integer.parseInt((String) fromObject);
		}
		return null;
	}

}
