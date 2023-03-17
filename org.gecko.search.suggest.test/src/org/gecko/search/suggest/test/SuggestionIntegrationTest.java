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
package org.gecko.search.suggest.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.gecko.search.suggest.api.SuggestionDescriptor;
import org.gecko.search.suggest.api.SuggestionService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.osgi.test.common.annotation.InjectService;
import org.osgi.test.common.annotation.Property;
import org.osgi.test.common.annotation.Property.Scalar;
import org.osgi.test.common.annotation.config.WithFactoryConfiguration;
import org.osgi.test.common.service.ServiceAware;
import org.osgi.test.junit5.cm.ConfigurationExtension;
import org.osgi.test.junit5.context.BundleContextExtension;
import org.osgi.test.junit5.service.ServiceExtension;
import org.osgi.util.promise.Promise;

@ExtendWith(BundleContextExtension.class)
@ExtendWith(ServiceExtension.class)
@ExtendWith(ConfigurationExtension.class)
public class SuggestionIntegrationTest {

	
	@BeforeEach
	public void doBefore() throws InterruptedException, IOException {	
	}

	@AfterEach
	public void doAfter() {
	}

	@SuppressWarnings("rawtypes")
	@Test
	@WithFactoryConfiguration(
			factoryPid = "ObjectSuggestionDescriptor",
			location = "?", 
			name = "suggDescr",
			properties = {
					@Property(key = "suggestion.index", value = "true", scalar = Scalar.Boolean),
					@Property(key = "name", value = "dummy")
			})
	@WithFactoryConfiguration(
			factoryPid = "ObjectSuggestionService",
			location = "?", 
			name = "suggService",
			properties = {
					@Property(key = "descriptor.target", value = "(name=dummy)"),
					@Property(key = "directory.type", value = "ByteBuffer"),
					@Property(key = "suggestionName", value = "testIdxSug"),
					@Property(key = "suggestionNumberResults", value = "5", scalar = Scalar.Integer)
			})
	public void testSuggest(@InjectService ServiceAware<SuggestionDescriptor> suggDescAware,
			@InjectService() ServiceAware<SuggestionService> suggestionServiceAware) throws InterruptedException, InvocationTargetException {
		
		SuggestionDescriptor suggDescService = suggDescAware.waitForService(500L);
		assertThat(suggDescService).isNotNull();
		assertThat(suggDescService).isInstanceOf(DummySuggestionDescriptor.class);
				
		assertThat(suggestionServiceAware).isNotNull();
		SuggestionService suggestionService = suggestionServiceAware.getService();
		assertThat(suggestionService).isNotNull();
		
		Promise<Void> initializationPromise = suggestionService.getInitializationPromise();
		initializationPromise.getValue();
				
		Map<String, String> suggestResult = suggestionService.getAutoCompletion("Tester", new String[] {"person"});
		assertNotNull(suggestResult);
		assertEquals(5, suggestResult.size());
	}
	
}