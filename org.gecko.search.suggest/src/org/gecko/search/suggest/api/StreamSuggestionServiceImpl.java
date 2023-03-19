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

import static java.util.Objects.requireNonNull;

import org.osgi.service.cm.ConfigurationException;
import org.osgi.util.promise.Deferred;
import org.osgi.util.promise.Promise;
import org.osgi.util.pushstream.PushStream;

/**
 * Service implementation of the suggestion service, based on a push stream. To define the index location,
 * the {@link GeckoResourcesProvider} is used. For that a service property "suggestion.index=true" must be available.
 * That is for the push stream as well as for the resource provider
 * @author Mark Hoffmann
 * @since Nov 9, 2018
 */
public abstract class StreamSuggestionServiceImpl<O, F> extends BasicSuggestionImpl<O, F> {

	private PushStream<O> contextStream;
	private Deferred<Void> initDeferred;

	/**
	 * Called on component activation
	 * @param ctx the bundle context
	 * @throws ConfigurationException
	 */
	@Override
	protected void activate(SuggestionConfiguration configuration) throws ConfigurationException {
		try {
			super.activate(configuration);
			requireNonNull(getPromiseFactory());
			requireNonNull(contextStream);
			connectToPushStream();
		} catch (ConfigurationException e) {
			throw e;
		} catch (Exception e) {
			throw new ConfigurationException("configuration", "Error activating StreamSuggestionServiceimpl", e);
		}
	}
	
	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.suggest.api.BasicSuggestionImpl#initializeSuggestionIndex()
	 */
	@Override
	protected Promise<Void> initializeSuggestionIndex() {
		requireNonNull(getPromiseFactory());
		initDeferred = getPromiseFactory().deferred();
		return initDeferred.getPromise();
	}

	/**
	 * Sets the contextStream.
	 * @param contextStream the contextStream to set
	 */
	protected void setContextStream(PushStream<O> contextStream) {
		this.contextStream = contextStream;
	}
	
	private void connectToPushStream() {
		requireNonNull(getLookup());
		requireNonNull(getDescriptor());
		contextStream.
			map(this::createContext).
			map(this::buildIndexContext).
			onClose(this::resolve).
			forEach(cl->indexContexts(cl)).
			onFailure(this::fail).
			onResolve(this::resolve);
	}
	
	private void resolve() {
		if (getInitializationPromise() != null 
				&& !getInitializationPromise().isDone()) {
			initDeferred.resolve(null);
		}
	}
	
	private void fail(Throwable t) {
		if (getInitializationPromise() != null 
				&& !getInitializationPromise().isDone()) {
			t.printStackTrace();
			initDeferred.fail(t);
		}
	}

}
