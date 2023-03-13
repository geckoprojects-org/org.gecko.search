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
package org.gecko.emf.search.suggest.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.gecko.emf.osgi.example.model.basic.BasicPackage;
import org.gecko.search.suggest.api.SuggestionDescriptor;
import org.gecko.search.suggest.api.SuggestionService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.test.common.annotation.InjectBundleContext;
import org.osgi.test.common.annotation.InjectService;
import org.osgi.test.common.annotation.Property;
import org.osgi.test.common.annotation.Property.Scalar;
import org.osgi.test.common.annotation.config.WithFactoryConfiguration;
import org.osgi.test.common.dictionary.Dictionaries;
import org.osgi.test.common.service.ServiceAware;
import org.osgi.test.junit5.cm.ConfigurationExtension;
import org.osgi.test.junit5.context.BundleContextExtension;
import org.osgi.test.junit5.service.ServiceExtension;
import org.osgi.util.pushstream.PushStream;
import org.osgi.util.pushstream.PushStreamProvider;

@ExtendWith(BundleContextExtension.class)
@ExtendWith(ServiceExtension.class)
@ExtendWith(ConfigurationExtension.class)
public class SuggestionStreamIntegrationTest {
	
	private static final String INDEX_PATH = "/tmp/indexEMFSuggestStreamTest/"; 

	@InjectBundleContext
	BundleContext ctx;
	
	File indexPath;
	
	@BeforeEach
	public void doBefore() throws InterruptedException, IOException {	
		indexPath = new File(INDEX_PATH);
		if (!indexPath.exists()) {
			indexPath.mkdirs();
		}
	}

	@AfterEach
	public void doAfter() {
		delete(indexPath);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	@WithFactoryConfiguration(
			factoryPid = "EObjectSuggestionDescriptor",
			location = "?", 
			name = "suggDescr",
			properties = {
					@Property(key = "suggestion.index", value = "true", scalar = Scalar.Boolean),
					@Property(key = "name", value = "dummy")
			})
	@WithFactoryConfiguration(
			factoryPid = "EObjectStreamSuggestionService",
			location = "?", 
			name = "suggService",
			properties = {
					@Property(key = "base.path", value = INDEX_PATH),
					@Property(key = "descriptor.target", value = "(name=dummy)"),
					@Property(key = "suggestionName", value = "testIdxSug"),
					@Property(key = "directory.type", value = "ByteBuffer"),
					@Property(key = "suggestionNumberResults", value = "5", scalar = Scalar.Integer)
			})
	public void testSuggestStream(@InjectService ServiceAware<BasicPackage> basicPackageAware,
			@InjectService ServiceAware<SuggestionDescriptor> suggDescAware,
			@InjectService(cardinality = 0) ServiceAware<SuggestionService> suggestionServiceAware,
			@InjectService(cardinality = 0) ServiceAware<PushStream> psAware) throws InterruptedException {
		
		assertThat(basicPackageAware).isNotNull();
		BasicPackage basicPackage = basicPackageAware.getService();
		assertThat(basicPackage).isNotNull();
		
		assertThat(psAware).isNotNull();
		assertThat(psAware.getService()).isNull();
		assertThat(suggestionServiceAware).isNotNull();
		assertThat(suggestionServiceAware.getService()).isNull();
		
		SuggestionDescriptor<EObject, EStructuralFeature> suggDescService = suggDescAware.waitForService(500L);
		assertThat(suggDescService).isNotNull();
		assertThat(suggDescService).isInstanceOf(DummySuggestionDescriptor.class);
		
		Stream<EObject> objectStream = suggDescService.getObjectStream();
		PushStreamProvider psp = new PushStreamProvider();
		PushStream<EObject> pushStream = psp.streamOf(objectStream);
		ctx.registerService(PushStream.class, pushStream, null);
		
		PushStream<EObject> ps = psAware.waitForService(500l);
		assertThat(ps).isNotNull();
		SuggestionService suggestionService = suggestionServiceAware.waitForService(500l);
		assertThat(suggestionService).isNotNull();
		
		Thread.sleep(5000l);
				
		Map<String, String> suggestResult = suggestionService.getAutoCompletion("Tester", new String[] {"person"});
		assertNotNull(suggestResult);
		assertEquals(5, suggestResult.size());
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	@WithFactoryConfiguration(
			factoryPid = "EObjectSuggestionDescriptor",
			location = "?", 
			name = "suggDescr",
			properties = {
					@Property(key = "suggestion.index", value = "true", scalar = Scalar.Boolean),
					@Property(key = "name", value = "dummy")
			})
	@WithFactoryConfiguration(
			factoryPid = "EObjectStreamSuggestionService",
			location = "?", 
			name = "suggService2",
			properties = {
					@Property(key = "base.path", value = INDEX_PATH),
					@Property(key = "descriptor.target", value = "(name=dummy)"),
					@Property(key = "contextStream.target", value = "(name=myStream)"),
					@Property(key = "directory.type", value = "ByteBuffer"),
					@Property(key = "suggestionName", value = "testIdxSug"),
					@Property(key = "suggestionNumberResults", value = "5", scalar = Scalar.Integer)
			})
	public void testSuggestBinding(@InjectService ServiceAware<BasicPackage> basicPackageAware,
			@InjectService ServiceAware<SuggestionDescriptor> suggDescAware,
			@InjectService(cardinality = 0) ServiceAware<SuggestionService> suggestionServiceAware,
			@InjectService(cardinality = 0) ServiceAware<PushStream> psAware) throws InterruptedException {
		
		assertThat(basicPackageAware).isNotNull();
		BasicPackage basicPackage = basicPackageAware.getService();
		assertThat(basicPackage).isNotNull();
		
		assertThat(psAware).isNotNull();
		assertThat(psAware.getService()).isNull();
		assertThat(suggestionServiceAware).isNotNull();
		assertThat(suggestionServiceAware.getService()).isNull();
		
		SuggestionDescriptor<EObject, EStructuralFeature> suggDescService = suggDescAware.waitForService(500L);
		assertThat(suggDescService).isNotNull();
		assertThat(suggDescService).isInstanceOf(DummySuggestionDescriptor.class);
		
		Stream<EObject> objectStream = suggDescService.getObjectStream();
		PushStreamProvider psp = new PushStreamProvider();
		PushStream<EObject> pushStream = psp.streamOf(objectStream);
		ServiceRegistration<PushStream> psRegistration = ctx.registerService(PushStream.class, pushStream, null);
		
		PushStream<EObject> ps = psAware.waitForService(500l);
		assertThat(ps).isNotNull();
		SuggestionService suggestionService = suggestionServiceAware.waitForService(500l);
		assertThat(suggestionService).isNull();
		
		psRegistration.setProperties(Dictionaries.dictionaryOf("name", "myStream"));
		suggestionService = suggestionServiceAware.waitForService(500l);
		assertThat(suggestionService).isNotNull();
		
		Thread.sleep(5000l);
		
		Map<String, String> suggestResult = suggestionService.getAutoCompletion("Tester", new String[] {"person"});
		assertNotNull(suggestResult);
		assertEquals(5, suggestResult.size());
		
		psRegistration.setProperties(Dictionaries.dictionaryOf("name", "foo"));
		suggestionService = suggestionServiceAware.waitForService(500l);
		assertThat(suggestionService).isNull();
		psRegistration.unregister();
		ps = psAware.waitForService(500l);
		assertThat(ps).isNull();
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