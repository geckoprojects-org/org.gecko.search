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
package {{basePackageName}};

import java.util.Map;

import org.gecko.search.suggest.api.SuggestionService;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.util.promise.Promise;

/**
 * Example Component for suggestion
 */
@Component
public class PersonSuggestionComponent {

	@Reference
	private SuggestionService pss;

	@Activate
	public void activate(BundleContext ctx) {
		Promise<Void> initializationPromise = pss.getInitializationPromise();
		initializationPromise.
			onResolve(()->{
				System.out.println("Suggest for 'Test' in 'lastName': ");
				// Search for auto-completion for 'Test' in label 'lastName' 
				Map<String, String> suggestion = pss.getAutoCompletion("Test", new String[] {"lastName"});
				suggestion.entrySet().forEach(e->System.out.println("Suggest: " + e.getKey() + " for Person with id: " + e.getValue()));
				// Search for auto-completion for 'Em' in label 'lastName' 
				System.out.println("Suggest for 'Em' in 'firstName': ");
				suggestion = pss.getAutoCompletion("Em", new String[] {"firstName"});
				suggestion.entrySet().forEach(e->System.out.println("Suggest: " + e.getKey() + " for Person with id: " + e.getValue()));
				System.out.println("Suggest for 'Emi' in 'firstName' and 'lastName': ");
				suggestion = pss.getAutoCompletion("Emi", new String[] {"firstName", "lastName"});
				suggestion.entrySet().forEach(e->System.out.println("Suggest: " + e.getKey() + " for Person with id: " + e.getValue()));
			});
	}

}
