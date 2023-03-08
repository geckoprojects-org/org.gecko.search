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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.search.suggest.Lookup;
import org.apache.lucene.search.suggest.analyzing.AnalyzingInfixSuggester;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.BytesRef;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.gecko.search.api.IndexActionType;
import org.gecko.search.suggest.api.SimpleSuggestionContext;
import org.gecko.search.suggest.api.SuggestionConfiguration;
import org.gecko.search.suggest.api.SuggestionContext;
import org.gecko.search.suggest.api.SuggestionDescriptor;
import org.gecko.search.suggest.api.SuggestionService;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.util.promise.Promise;
import org.osgi.util.promise.PromiseFactory;

/**
 * Service implementation of the suggestion service. To define the index location,
 * the corresponding configuration property must be provided
 * @author Ilenia Salvadori, Mark Hoffmann
 * @since 03.03.2023
 */
@Component(configurationPolicy=ConfigurationPolicy.REQUIRE, configurationPid=SuggestionService.SUGGESTION_FACTORY)
public class SuggestionServiceImpl implements SuggestionService {

	@Reference(target="(" + PROP_SUGGESTION_INDEX + "=true)")
	private SuggestionDescriptor suggestionDescriptor;

	private static final Logger LOGGER = Logger.getLogger(SuggestionServiceImpl.class.getName());
	private List<SuggestionContext<?>> contexts;
	private Promise<AnalyzingInfixSuggester> suggesterPromise;
	private FSDirectory indexDir;
	private volatile SuggestionConfiguration configuration;
	
	/**
	 * Called on component activation
	 * @param ctx the component context
	 * @throws ConfigurationException
	 */
	@Activate
	public void activate(ComponentContext ctx , SuggestionConfiguration configuration) {
		this.configuration = configuration;
		PromiseFactory pf = new PromiseFactory(Executors.newSingleThreadExecutor());
		suggesterPromise = pf.submit(this::initializeSuggestionIndex);
	}

	/**
	 * Called on component de-activation
	 */
	@Deactivate
	public void deactivate() {
		if (indexDir != null) {
			try {
				indexDir.close();
			} catch (IOException e) {
				LOGGER.severe("Error closing index directory");
			}
		}
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.suggest.api.SuggestionService#getAutoCompletion(java.lang.String, java.lang.String[])
	 */
	@Override
	public Map<String, String> getAutoCompletion(String string, String[] label) {
		Map<String, String> displayRes = new HashMap<>();
		AnalyzingInfixSuggester suggester;
		try {
			suggester = suggesterPromise.getValue();
			List<Lookup.LookupResult> results = null;
			Set<BytesRef> contextSet = new HashSet<BytesRef>();        
			try {
				if (label != null && label.length > 0) {
					for (String l : label) {
						contextSet.add(new BytesRef(l.getBytes("UTF8")));
					}
				}
				results = suggester.lookup(string, contextSet, configuration.suggestionNumberResults(), configuration.suggestionAllTermsRequired(), false);
			} catch (IOException e) {
				LOGGER.log(Level.SEVERE, "[{0}] Error providing a suggestion for {1}", new Object[] {configuration.suggestionName(), string, e});
				return Collections.emptyMap();
			}
			for (Lookup.LookupResult result : results) {
				BytesRef payload = result.payload;
				String id = new String(payload.bytes);
				String proposal = result.key.toString();
				displayRes.put(proposal, id);
			}		
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "[{0}] Error creating a suggestion proposal for query {1}", new Object[] {configuration.suggestionName(), string});
		}
		return displayRes;
	}
	
	/**
	 * Creates the initial index with data
	 * @return the suggester;
	 * @throws ConfigurationException 
	 */
	private AnalyzingInfixSuggester initializeSuggestionIndex() throws ConfigurationException {
		//create data sample and context suggests (according to device Fqdn, Alias and Name)
		contexts = createContext();
	
		//Initialize path and analyzer
		AnalyzingInfixSuggester suggester = initializeIndex();
	
		//Indexing data according to the suggester		
		try {
			indexData(contexts, suggester);
		} catch (IOException e) {
			LOGGER.severe("Error indexing data ");
		}
		return suggester;
	}

	/**
	 * This method creates the list of content we want to make the auto completion against. 
	 * It loops over the list of input data and provides for each entry the payload, the filed against with we
	 * want to auto complete the search, the weight (for now set to 4), and the labels used to search only among
	 * data belonging to a particular category.
	 * @return the list with contexts
	 */
	private List<SuggestionContext<?>> createContext() {
		Set<EStructuralFeature> fields = suggestionDescriptor.getFields();
		List<String> labels = suggestionDescriptor.getLabels();
		String[] labelsArray = new String[labels.size()];
		labelsArray = labels.toArray(labelsArray);
		List<?extends EObject> objects = suggestionDescriptor.getObjectStream();
		List<SuggestionContext<?>> contexts = new ArrayList<SuggestionContext<?>>(objects.size());
		for (EObject eo : objects) {
			Object payloadObject = eo.eGet(suggestionDescriptor.getPayload());
			String payload = payloadObject == null ? null : payloadObject.toString();				
			for (EStructuralFeature feature : fields) {
				Object value = eo.eGet(feature);
				if (value != null) {
					SuggestionContext<?> ctx = new SimpleSuggestionContext(IndexActionType.ADD, payload, eo.eGet(feature).toString(), labelsArray, 4);
					contexts.add(ctx);
				}
			}			
		}
		return contexts;
	}

	/**
	 * This method opens a FSDirectory and creates a StandardAnalyzer and a Suggester which are then needed
	 * for the data indexing and searching.
	 * @throws ConfigurationException
	 */
	private AnalyzingInfixSuggester initializeIndex() throws ConfigurationException {
		File file = null;
		AnalyzingInfixSuggester suggester = null;
		if(configuration.base_path().length() > 0) {
			file = new File(configuration.base_path());
		}
		if(file == null) {
			throw new ConfigurationException("base.path", "The property is required for the suggester index");
		}

		try {
			indexDir = FSDirectory.open(file.toPath());
			StandardAnalyzer analyzer = new StandardAnalyzer();
			suggester = new AnalyzingInfixSuggester(indexDir, analyzer);
		} catch (IOException e) {
			throw new ConfigurationException("base.path", String.format("Error opening suggestion index for the given path '%s'"));
		} 
		return suggester;
	}

	/**
	 * This method indexes the data through the standardAnalyzer
	 * @param contexts
	 * @param suggester
	 * @throws IOException
	 */
	private void indexData(List<SuggestionContext<?>> contexts, AnalyzingInfixSuggester suggester) throws IOException {
		suggester.build(new ContextIteratorImpl(contexts.iterator()));
	}

}
