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

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static java.util.Objects.requireNonNull;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.gecko.search.IndexContextObject;
import org.gecko.search.IndexListener;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.util.pushstream.PushEvent;
import org.osgi.util.pushstream.PushStream;
import org.osgi.util.pushstream.PushStreamProvider;
import org.osgi.util.pushstream.QueuePolicyOption;
import org.osgi.util.pushstream.SimplePushEventSource;

/**
 * IndexListener that connects to the index process to also create a suggestion index out of this data
 * @author Mark Hoffmann
 * @since 10.03.2023
 */
@Component(name = "SuggestionIndexListener", configurationPolicy = ConfigurationPolicy.REQUIRE)
public class SuggestIndexListener implements IndexListener {

	public static final String PROP_SUGGEST_LISTENER_NAME = "sl.name";
	public static final String PROP_SUGGEST_LISTENER_OBJ_TYPE = "sl.objType";
	private static final Logger LOGGER = Logger.getLogger(SuggestIndexListener.class.getName());
	private final PushStreamProvider psp = new PushStreamProvider();
	private SimplePushEventSource<Object> eventSource;
	private ServiceRegistration<?> serviceRegistration;

	@interface SuggestListenerConfig {
		String slName();
		String slObjectType() default "java.lang.Object";
	}

	@Activate
	public void activate(SuggestListenerConfig configuration, BundleContext context) throws ConfigurationException {
		try {
			requireNonNull(context);
			requireNonNull(configuration);
			requireNonNull(configuration.slName());
			eventSource = psp.buildSimpleEventSource(Object.class).withBuffer(new ArrayBlockingQueue<PushEvent<? extends Object>>(100)).withQueuePolicy(QueuePolicyOption.BLOCK).build();
			PushStream<Object> stream = psp.buildStream(eventSource)
					.withPushbackPolicy( q -> Math.max(0, q.size() - 50))
					.withQueuePolicy(QueuePolicyOption.BLOCK)
					.withBuffer(new ArrayBlockingQueue<PushEvent<? extends Object>>(50))
					.build();
			serviceRegistration = context.registerService(PushStream.class.getName(), stream, createProperties(configuration));
		} catch (Exception e) {
			throw new ConfigurationException("configuration", "Cannot activate component without propert configuration", e);
		}
	}

	/**
	 * Creates the service properties
	 * @param configuration the configuration
	 * @return the properties {@link Dictionary}
	 */
	private Dictionary<String, ?> createProperties(SuggestListenerConfig configuration) {
		Dictionary<String, Object> properties = new Hashtable<>();
		properties.put(PROP_SUGGEST_LISTENER_NAME, configuration.slName());
		properties.put(PROP_SUGGEST_LISTENER_OBJ_TYPE, configuration.slObjectType());
		return properties;
	}

	@Deactivate
	public void deactivate() {
		if (nonNull(serviceRegistration)) {
			serviceRegistration.unregister();
		}
		if (nonNull(eventSource)) {
			if (eventSource.isConnected()) {
				eventSource.close();
			}
			eventSource = null;
		}
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.api.IndexListener#canHandle(org.gecko.search.api.IndexContextObject)
	 */
	@Override
	public boolean canHandle(IndexContextObject<?> context) {
		if (isNull(context) || isNull(eventSource)) {
			return false;
		}
		return nonNull(context) && nonNull(context.getObject());
	}
	
	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.api.IndexListener#onIndex(org.gecko.search.api.IndexContextObject)
	 */
	@Override
	public void onIndex(IndexContextObject<?> context) {
		if (isNull(context) || isNull(eventSource)) {
			return;
		}
		if (nonNull(context.getObject())) {
			try {
				eventSource.publish(context.getObject());
			} catch (Exception e) {
				LOGGER.log(Level.SEVERE, e, ()->"Exception during publishing the object");
			}
		}
	}

}
