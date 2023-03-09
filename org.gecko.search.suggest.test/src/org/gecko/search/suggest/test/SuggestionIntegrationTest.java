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

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import org.gecko.search.suggest.api.SuggestionDescriptor;
import org.gecko.search.suggest.api.SuggestionService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Reference;
import org.osgi.test.common.annotation.InjectService;
import org.osgi.test.common.annotation.Property;
import org.osgi.test.common.annotation.Property.Scalar;
import org.osgi.test.common.annotation.config.WithFactoryConfiguration;
import org.osgi.test.common.service.ServiceAware;
import org.osgi.test.junit5.cm.ConfigurationExtension;
import org.osgi.test.junit5.context.BundleContextExtension;
import org.osgi.test.junit5.service.ServiceExtension;

@ExtendWith(BundleContextExtension.class)
@ExtendWith(ServiceExtension.class)
@ExtendWith(ConfigurationExtension.class)
public class SuggestionIntegrationTest {
	
	@Reference
	BundleContext bundleContext;

	File indexPath;
	
	@BeforeEach
	public void doBefore() throws InterruptedException, IOException {	
			
		indexPath = new File("/tmp/suggestIdx");
		if (!indexPath.exists()) {
			indexPath.mkdirs();
		}
	}

	@AfterEach
	public void doAfter() {
		delete(indexPath);
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
					@Property(key = "base.path", value = "/tmp/suggestIdx"),
					@Property(key = "descriptor.target", value = "(name=dummy)"),
					@Property(key = "suggestionName", value = "testIdxSug"),
					@Property(key = "suggestionNumberResults", value = "5", scalar = Scalar.Integer)
			})
	public void testSuggest(@InjectService(timeout = 2000) ServiceAware<SuggestionDescriptor> suggDescAware,
			@InjectService() ServiceAware<SuggestionService> suggestionServiceAware) throws InterruptedException {
		
		SuggestionDescriptor suggDescService = suggDescAware.waitForService(500L);
		assertThat(suggDescService).isNotNull();
		assertThat(suggDescService).isInstanceOf(DummySuggestionDescriptor.class);
				
		assertThat(suggestionServiceAware).isNotNull();
		SuggestionService suggestionService = suggestionServiceAware.getService();
		assertThat(suggestionService).isNotNull();
				
		Map<String, String> suggestResult = suggestionService.getAutoCompletion("Tester", new String[] {"person"});
		assertNotNull(suggestResult);
		assertEquals(5, suggestResult.size());
	}
	
	private void delete(File file) {
		if(file.exists()) {
			if(!file.isFile()) {
				Arrays.asList(file.listFiles()).forEach(this::delete);
			}
			file.delete();
		}
	}
}