/**
 * Copyright (c) 2012 - 2023 Data In Motion and others.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made available under the terms of the 
 * Eclipse Public License v2.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *     Data In Motion - initial API and implementation
 */
package org.gecko.search.suggest.impl;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.gecko.search.suggest.api.SuggestionConfiguration;
import org.gecko.search.suggest.api.SuggestionContext;
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
import org.osgi.util.pushstream.PushStream;

/**
 * Service implementation of the suggestion service, based on a push stream. To define the index location,
 * the {@link GeckoResourcesProvider} is used. For that a service property "suggestion.index=true" must be available.
 * That is for the push stream as well as for the resource provider
 * @author Mark Hoffmann
 * @since Nov 9, 2018
 */
@Component(configurationPolicy=ConfigurationPolicy.REQUIRE, configurationPid=SuggestionService.SUGGESTION_FACTORY)
public class SuggestionPushStreamServiceImpl implements SuggestionService {

	private static final Logger logger = Logger.getLogger(SuggestionPushStreamServiceImpl.class.getName());
	@Reference(target="(" + PROP_SUGGESTION_INDEX + "=true)")
	private PushStream<SuggestionContext> contextStream;

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
		suggesterPromise = pf.submit(this::initializeIndex);
		suggesterPromise.
			onFailure(t->logger.log(Level.SEVERE, "[{0}] Error creating the suggester instance", new Object[] {configuration.suggestionName(), t})).
			thenAccept(this::connectToPushStream);
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
				logger.severe("Error closing index directory");
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
				logger.log(Level.SEVERE, "[{0}] Error providing a suggestion for {1}", new Object[] {configuration.suggestionName(), string, e});
				return Collections.emptyMap();
			}
			for (Lookup.LookupResult result : results) {
				BytesRef payload = result.payload;
				String id = new String(payload.bytes);
				String proposal = result.key.toString();
				displayRes.put(proposal, id);
			}		
		} catch (Exception e) {
			logger.log(Level.SEVERE, "[{0}] Error creating a suggestion proposal for query {1}", new Object[] {configuration.suggestionName(), string});
		}
		return displayRes;
	}

	/**
	 * This method opens a FSDirectory and creates a StandardAnalyzer and a Suggester which are then needed
	 * for the data indexing and searching.
	 * @return suggester
	 * @throws IOException 
	 */
	private AnalyzingInfixSuggester initializeIndex() throws IOException {
		URI indexPath = URI.create(configuration.base_path());
		Path path = Paths.get(indexPath);
		AnalyzingInfixSuggester suggester = null;
		indexDir = FSDirectory.open(path);
		StandardAnalyzer analyzer = new StandardAnalyzer();
		suggester = new AnalyzingInfixSuggester(indexDir, analyzer);
		return suggester;
	}

	private void connectToPushStream(final AnalyzingInfixSuggester suggester) {
		contextStream.
			map(IndexContext::new).
			forEach(c->indexContext(c, suggester));
	}

	/**
	 * Indexes an context object, with the given suggester
	 * @param context the context to be indexed
	 * @param suggester the suggester to be used
	 */
	private void indexContext(IndexContext context, AnalyzingInfixSuggester suggester) {
		try {
			switch (context.getContext().getActionType()) {
			case ADD:
				suggester.add(context.content(), context.labels(), context.weight(), context.payload());
				break;
			case MODIFY:
				suggester.update(context.content(), context.labels(), context.weight(), context.payload());
				break;
			default:
				suggester.update(new BytesRef(BytesRef.EMPTY_BYTES), Collections.emptySet(), context.weight(), context.payload());
				break;
			}
			suggester.commit();
			suggester.refresh();
		} catch (IOException e) {
			logger.log(Level.SEVERE, "[{0}] Error handling context for payload {1}", new Object[] {configuration.suggestionName(), context.getContext().getPayload(), e});
		}
	}

}
