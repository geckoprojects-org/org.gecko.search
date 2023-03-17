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
package org.gecko.search.suggest.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

import java.lang.reflect.Field;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * 
 * @author mark
 * @since 17.03.2023
 */
public class ObjectSuggestionServiceImplTest {
	
	private ObjectSuggestionServiceImpl suggestionService;

	@BeforeEach
	public void beforeEach() {
		suggestionService = createAbstractMock(ObjectSuggestionServiceImpl.class);
	}

	@AfterEach
	public void afterEach() {
	}
	
	@SuppressWarnings("unused")
	private class TestMe {
		public String id = "1234";
		String foo = "foo";
		int bar = 42;
	}
	
	@SuppressWarnings("unused")
	private class Other {
		public String fizz = "buzz";
	}
	
	@Test
	public void testGetPayload() throws NoSuchFieldException, SecurityException {
		TestMe testMe = new TestMe();
		Field idField = TestMe.class.getField("id");
		Field fizzField = Other.class.getField("fizz");
		assertThrows(NullPointerException.class, ()->suggestionService.getPayload(null, null));
		assertThrows(NullPointerException.class, ()->suggestionService.getPayload(testMe, null));
		assertThrows(NullPointerException.class, ()->suggestionService.getPayload(null, idField));
		assertThrows(IllegalStateException.class, ()->suggestionService.getPayload(testMe, fizzField));
		
		assertEquals("1234", suggestionService.getPayload(testMe, idField));
	}
	
	@Test
	public void testGetField() throws NoSuchFieldException, SecurityException {
		TestMe testMe = new TestMe();
		Field idField = TestMe.class.getField("id");
		Field fizzField = Other.class.getField("fizz");
		assertThrows(NullPointerException.class, ()->suggestionService.getFieldValue(null, null));
		assertThrows(NullPointerException.class, ()->suggestionService.getFieldValue(testMe, null));
		assertThrows(NullPointerException.class, ()->suggestionService.getFieldValue(null, idField));
		assertThrows(IllegalStateException.class, ()->suggestionService.getFieldValue(testMe, fizzField));
		
		assertEquals("1234", suggestionService.getFieldValue(testMe, idField));
	}
	
	public <T> T createAbstractMock(Class<T> mockClass) {
		return mock(mockClass, 
				Mockito.withSettings().
				useConstructor().
				defaultAnswer(Mockito.CALLS_REAL_METHODS));
	}
}
