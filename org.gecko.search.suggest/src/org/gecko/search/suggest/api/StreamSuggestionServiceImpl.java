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
package org.gecko.search.suggest.api;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.lucene.search.suggest.analyzing.AnalyzingInfixSuggester;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.component.ComponentContext;
import org.osgi.util.pushstream.PushStream;

/**
 * Service implementation of the suggestion service, based on a push stream. To define the index location,
 * the {@link GeckoResourcesProvider} is used. For that a service property "suggestion.index=true" must be available.
 * That is for the push stream as well as for the resource provider
 * @author Mark Hoffmann
 * @since Nov 9, 2018
 */
public abstract class StreamSuggestionServiceImpl<O, F> extends BasicSuggestionService<O, F> {

	private static final Logger logger = Logger.getLogger(StreamSuggestionServiceImpl.class.getName());
	private PushStream<O> contextStream;

	/**
	 * Called on component activation
	 * @param ctx the component context
	 * @throws ConfigurationException
	 */
	@Override
	protected void activate(ComponentContext ctx , SuggestionConfiguration configuration) {
		super.activate(ctx, configuration);
		suggesterPromise.
			onFailure(t->logger.log(Level.SEVERE, String.format("[%s] Error creating the suggester instance", configuration.suggestionName()), t)).
			thenAccept(this::connectToPushStream);
	}
	
	/**
	 * Sets the contextStream.
	 * @param contextStream the contextStream to set
	 */
	protected void setContextStream(PushStream<O> contextStream) {
		this.contextStream = contextStream;
	}

	private void connectToPushStream(final AnalyzingInfixSuggester suggester) {
		contextStream.
			map(this::createContext).
			map(this::buildIndexContext).
			forEach(cl->indexContexts(cl, suggester));
	}

}
