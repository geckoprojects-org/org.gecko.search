package org.gecko.search.converter.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.gecko.search.converter.IIndexConverter;
import org.gecko.search.converter.registry.impl.IndexConverterRegistry;
import org.junit.Test;

public class IndexConverterRegistryTests {
	
	private IIndexConverter c01 = new IIndexConverter() {
		
		@Override
		public Class<?> getToType() {
			return String.class;
		}
		
		@Override
		public Class<?> getFromType() {
			return Date.class;
		}
		
		@Override
		public String getConverterId() {
			return "dateToString";
		}
		
		@Override
		public Object convert(Object fromObject) {
			return null;
		}
	};
	private IIndexConverter c02 = new IIndexConverter() {
		
		@Override
		public Class<?> getToType() {
			return Date.class;
		}
		
		@Override
		public Class<?> getFromType() {
			return String.class;
		}
		
		@Override
		public String getConverterId() {
			return "stringToDate";
		}
		
		@Override
		public Object convert(Object fromObject) {
			return null;
		}
	};

	@Test
	public void testGetConverter() {
		IndexConverterRegistry registry = new IndexConverterRegistry();
		registry.registerConverter(c01);
		assertNotNull(registry.getConverter("dateToString"));
		assertEquals(c01, registry.getConverter("dateToString"));
		registry.unregisterConverter(c01);
		assertNull(registry.getConverter("dateToString"));
		registry.registerConverter(c01);
		registry.registerConverter(c02);
		assertNotNull(registry.getConverter("dateToString"));
		assertEquals(c01, registry.getConverter("dateToString"));
		assertNotNull(registry.getConverter("stringToDate"));
		assertEquals(c02, registry.getConverter("stringToDate"));
	}

	@Test
	public void testHasConverter() {
		IndexConverterRegistry registry = new IndexConverterRegistry();
		registry.registerConverter(c01);
		assertTrue(registry.hasConverter("dateToString"));
		assertEquals(c01, registry.getConverter("dateToString"));
		registry.unregisterConverter(c01);
		assertFalse(registry.hasConverter("dateToString"));
		registry.registerConverter(c01);
		registry.registerConverter(c02);
		assertTrue(registry.hasConverter("dateToString"));
		assertTrue(registry.hasConverter("stringToDate"));
		registry.unregisterConverter(c01);
		assertFalse(registry.hasConverter("dateToString"));
		assertTrue(registry.hasConverter("stringToDate"));
	}

}
