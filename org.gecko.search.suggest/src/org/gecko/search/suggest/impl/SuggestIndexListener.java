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

import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

import org.gecko.search.api.IndexContextObject;
import org.gecko.search.api.IndexListener;
import org.gecko.search.document.context.ObjectContextObject;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
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
	
	private final PushStreamProvider psp = new PushStreamProvider();
	private SimplePushEventSource<ObjectContextObject> eventSource;
	@SuppressWarnings("rawtypes")
	private ServiceRegistration<PushStream> serviceRegistration;

	@Activate
	public void activate(Map<String, Object> properties, BundleContext context) {
		eventSource = psp.buildSimpleEventSource(ObjectContextObject.class).withBuffer(new ArrayBlockingQueue<PushEvent<? extends ObjectContextObject>>(100)).withQueuePolicy(QueuePolicyOption.BLOCK).build();
		PushStream<ObjectContextObject> stream = psp.buildStream(eventSource)
				.withPushbackPolicy( q -> Math.max(0, q.size() - 50))
				.withQueuePolicy(QueuePolicyOption.BLOCK)
				.withBuffer(new ArrayBlockingQueue<PushEvent<? extends ObjectContextObject>>(50))
				.build();
		serviceRegistration = context.registerService(PushStream.class, stream, new Hashtable<>(properties));
	}
	
	@Deactivate
	public void deactivate() {
		if (serviceRegistration != null) {
			serviceRegistration.unregister();
		}
		if (eventSource != null && eventSource.isConnected()) {
			eventSource.close();
		}
	}
	
	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.api.IndexListener#canHandle(org.gecko.search.api.IndexContextObject)
	 */
	@Override
	public boolean canHandle(IndexContextObject<?> context) {
		return context instanceof ObjectContextObject;
	}
	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.api.IndexListener#onIndex(org.gecko.search.api.IndexContextObject)
	 */
	@Override
	public void onIndex(IndexContextObject<?> context) {
		if (eventSource != null && context instanceof ObjectContextObject) {
			eventSource.publish((ObjectContextObject) context);
		}
	}

}
