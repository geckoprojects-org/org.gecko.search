/**
 * Copyright (c) 2012 - 2018 Data In Motion and others.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Data In Motion - initial API and implementation
 */
package org.gecko.search.suggest.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.gecko.core.tests.AbstractOSGiTest;
import org.gecko.core.tests.ServiceChecker;
import org.gecko.emf.osgi.model.test.Person;
import org.gecko.emf.osgi.model.test.TestFactory;
import org.gecko.runtime.resources.GeckoResourcesConstants;
import org.gecko.runtime.resources.GeckoResourcesProvider;
import org.gecko.search.suggest.api.SuggestionObjectProvider;
import org.gecko.search.suggest.api.SuggestionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.osgi.framework.FrameworkUtil;

@RunWith(MockitoJUnitRunner.class)
public class ProviderIntegrationTest extends AbstractOSGiTest {

	/**
	 * Creates a new instance.
	 * @param bundleContext
	 */
	public ProviderIntegrationTest() {
		super(FrameworkUtil.getBundle(ProviderIntegrationTest.class).getBundleContext());
	}

	private List<Person> persons = new ArrayList<Person>(10);
	private File indexPath;

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.util.test.common.test.AbstractOSGiTest#doBefore()
	 */
	@Override
	public void doBefore() {
		for (int i = 0; i < 10; i++) {
			Person p = TestFactory.eINSTANCE.createPerson();
			p.setFirstName("Emil-" + i);
			p.setLastName("Tester-" + i);
			p.setId("et-" + i);
			persons.add(p);
		}
		indexPath = new File("/tmp/suggestIdx");
		if (!indexPath.exists()) {
			indexPath.mkdirs();
		}
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.util.test.common.test.AbstractOSGiTest#doAfter()
	 */
	@Override
	public void doAfter() {
		persons.clear();
		if (indexPath.exists()) {
			for (File f : indexPath.listFiles()) {
				f.delete();
			}
		}
	}

	@Test
	public void testSuggest() throws IOException {
		ServiceChecker<SuggestionService> suggestChecker = createTrackedChecker(SuggestionService.class);
		suggestChecker.start();
		ServiceChecker<GeckoResourcesProvider> resourceChecker = createTrackedChecker(GeckoResourcesProvider.class);
		resourceChecker.start();
		ServiceChecker<SuggestionObjectProvider> opChecker = createTrackedChecker(SuggestionObjectProvider.class);
		opChecker.start();
		resourceChecker.assertCreations(0, false);
		
		Dictionary<String, Object> resourceProperties = new Hashtable<String, Object>();
		resourceProperties.put(GeckoResourcesConstants.RESOURCE_NAME, "testIdx");
		resourceProperties.put(GeckoResourcesConstants.RESOURCE_PATH, "/tmp/suggestIdx");
		resourceProperties.put(SuggestionService.PROP_SUGGESTION_INDEX, Boolean.TRUE);
		createConfigForCleanup(GeckoResourcesConstants.RESOURCES_FACTORY_ID, "?", resourceProperties);
		
		resourceChecker.assertCreations(1, true);

		opChecker.assertCreations(0, false);
		
		Dictionary<String, Object> opProperties = new Hashtable<String, Object>();
		opProperties.put(SuggestionService.PROP_SUGGESTION_INDEX, Boolean.TRUE);
		SuggestionObjectProvider sop = new DummyObjectProvider(persons);
		
		registerServiceForCleanup(SuggestionObjectProvider.class, sop, opProperties);
		
		opChecker.assertCreations(1, true).assertRemovals(0, false);
		suggestChecker.assertCreations(0, false).assertRemovals(0, false);
		
		Dictionary<String, Object> suggestProperties = new Hashtable<String, Object>();
		suggestProperties.put("suggestionName", "testIdxSug");
		suggestProperties.put("suggestionNumberResults", 5);
		createConfigForCleanup(SuggestionService.SUGGESTION_FACTORY, "?", suggestProperties);
		
		suggestChecker.assertCreations(1, true).assertRemovals(0, false);
		
		SuggestionService service = getService(SuggestionService.class);
		Map<String, String> suggestResult = service.getAutoCompletion("Tester", new String[] {"person"});
		assertNotNull(suggestResult);
		assertEquals(5, suggestResult.size());
		
	}

}