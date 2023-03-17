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
package org.gecko.search.suggest.context;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;

import org.apache.lucene.util.BytesRef;
import org.gecko.search.IndexActionType;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author mark
 * @since 16.03.2023
 */
public class SuggestionContextTest {
	
	@Test
	public void testSuggestionContextCreate() {
		assertThrows(NullPointerException.class, ()->SuggestionContext.createAddContext("foo", "bar", IndexActionType.ADD, "payload", "content", null, 0));
		assertThrows(NullPointerException.class, ()->SuggestionContext.createAddContext("foo", "bar", IndexActionType.ADD, "payload", null, new String[0], 0));
		assertThrows(NullPointerException.class, ()->SuggestionContext.createAddContext("foo", "bar", null, "payload", "content", new String[0], 0));
		assertThrows(NullPointerException.class, ()->SuggestionContext.createAddContext("foo", null, IndexActionType.ADD, "payload", "content", new String[0], 0));
		assertThrows(NullPointerException.class, ()->SuggestionContext.createAddContext(null, "bar", IndexActionType.ADD, "payload", "content", new String[0], 0));
		SuggestionContext<String,String> context = SuggestionContext.createAddContext("foo", "bar", IndexActionType.ADD, "payload", "content", new String[0], 42);
		assertNotNull(context);
		assertEquals("foo", context.getObject());
		assertEquals("bar", context.getField());
		assertEquals(IndexActionType.ADD, context.getActionType());
		assertEquals("payload", context.getPayload());
		assertEquals("content", context.getContent());
		assertEquals(0, context.getLabels().length);
		assertEquals(42, context.getWeight());
		
		context = SuggestionContext.createAddContext("foo", "bar", IndexActionType.ADD, null, "content", new String[0], 42);
		assertNotNull(context);
		assertEquals("foo", context.getObject());
		assertEquals("bar", context.getField());
		assertEquals(IndexActionType.ADD, context.getActionType());
		assertNull(context.getPayload());
		assertEquals("content", context.getContent());
		assertEquals(0, context.getLabels().length);
		assertEquals(42, context.getWeight());
		
		context = SuggestionContext.createAddContext("foo", "bar", IndexActionType.ADD, "payload", "content", new String[] {"fizz", "buzz"}, 42);
		assertNotNull(context);
		assertEquals("foo", context.getObject());
		assertEquals("bar", context.getField());
		assertEquals(IndexActionType.ADD, context.getActionType());
		assertEquals("payload", context.getPayload());
		assertEquals("content", context.getContent());
		assertEquals(2, context.getLabels().length);
		assertEquals("fizz", context.getLabels()[0]);
		assertEquals("buzz", context.getLabels()[1]);
		assertEquals(42, context.getWeight());
		
	}
	
	@Test
	public void testSuggestionContextWrapperCreate() {
		assertThrows(NullPointerException.class, ()->SuggestionContext.toIndexContext(null));
		SuggestionContext<String,String> context = SuggestionContext.createAddContext("foo", "bar", IndexActionType.ADD, "payload", "content", new String[] {"fizz", "buzz"}, 42);
		assertNotNull(context);
		SuggestionContextWrapper<String,String> indexContext = SuggestionContext.toIndexContext(context);
		assertNotNull(indexContext);
		
		assertEquals(context, indexContext.getContext());
		assertEquals("payload", new String(indexContext.payload().bytes, StandardCharsets.UTF_8));
		assertEquals("content", new String(indexContext.content().bytes, StandardCharsets.UTF_8));
		assertEquals(2, indexContext.labels().size());
		Iterator<BytesRef> iterator = indexContext.labels().iterator();
		assertTrue(List.of("fizz", "buzz").contains(new String(iterator.next().bytes, StandardCharsets.UTF_8)));
		assertTrue(List.of("fizz", "buzz").contains(new String(iterator.next().bytes, StandardCharsets.UTF_8)));
		assertEquals(42, indexContext.weight());
		
	}

}
