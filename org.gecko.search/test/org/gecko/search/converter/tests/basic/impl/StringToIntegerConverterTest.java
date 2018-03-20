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
package org.gecko.search.converter.tests.basic.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Random;

import org.gecko.search.converter.impls.StringToIntegerConverter;
import org.junit.Test;

/**
 * A Simple Test for {@link StringToIntegerConverter#}
 * @author Jürgen Albert
 * @since 21.08.2014
 *
 */
public class StringToIntegerConverterTest {

	private static final String CONVERTER_ID = "stringToInteger";
	
	@Test
	public void testGetConverterId() {
		StringToIntegerConverter converter = new StringToIntegerConverter();
		assertEquals(converter.getConverterId(), CONVERTER_ID);
	}

	@Test
	public void testGetFromType() {
		StringToIntegerConverter converter = new StringToIntegerConverter();
		assertEquals(String.class, converter.getFromType());
	}

	@Test
	public void testGetToType() {
		StringToIntegerConverter converter = new StringToIntegerConverter();
		assertEquals(Integer.class, converter.getToType());
	}
	
	@Test
	public void testConvert() {
		StringToIntegerConverter converter = new StringToIntegerConverter();
		Integer expect = new Random().nextInt();
		
		Integer result = (Integer) converter.convert(expect.toString());
		
		assertEquals(expect, result);
	}
	
	@Test
	public void testConvertFailSafe() {
		StringToIntegerConverter converter = new StringToIntegerConverter();
		assertNull(converter.convert(new Double(12.2)));
	}
}
