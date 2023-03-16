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

import static java.util.Objects.requireNonNull;

import java.lang.reflect.Field;

import org.gecko.search.suggest.api.StreamSuggestionServiceImpl;
import org.gecko.search.suggest.api.SuggestionConfiguration;
import org.gecko.search.suggest.api.SuggestionDescriptor;
import org.gecko.search.suggest.api.SuggestionService;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.util.pushstream.PushStream;

/**
 * Service implementation of the suggestion service, based on a push stream. To define the index location,
 * the {@link GeckoResourcesProvider} is used. For that a service property "suggestion.index=true" must be available.
 * That is for the push stream as well as for the resource provider
 * @author Mark Hoffmann
 * @since Nov 9, 2018
 */
@Component(name = "ObjectStreamSuggestionService", service = SuggestionService.class, configurationPolicy=ConfigurationPolicy.REQUIRE)
public class ObjectStreamSuggestionService extends StreamSuggestionServiceImpl<Object, Field> {

	/**
	 * Called on component activation
	 * @param ctx the bundle context
	 * @throws ConfigurationException
	 */
	@Override
	@Activate
	public void activate(SuggestionConfiguration configuration) throws ConfigurationException {
		super.activate(configuration);
	}

	/**
	 * Called on component de-activation
	 */
	@Override
	@Deactivate
	public void deactivate() {
		super.deactivate();
	}
	
	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.suggest.impl.BasicSuggestionService#setSuggestionDescriptor(org.gecko.search.suggest.api.SuggestionDescriptor)
	 */
	@Override
	@Reference(name = "descriptor")
	protected void setDescriptor(SuggestionDescriptor<Object, Field> suggestionDescriptor) {
		super.setDescriptor(suggestionDescriptor);
	}
	
	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.suggest.api.StreamSuggestionServiceImpl#setContextStream(org.osgi.util.pushstream.PushStream)
	 */
	@Override
	@Reference(name = "contextStream")
	protected void setContextStream(PushStream<Object> contextStream) {
		super.setContextStream(contextStream);
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.suggest.api.SuggestionServiceImpl#getPayload(java.lang.Object, java.lang.Object)
	 */
	@Override
	protected Object getPayload(Object object, Field payloadField) {
		return getFieldValue(object, payloadField);
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.suggest.api.SuggestionServiceImpl#getFieldValue(java.lang.Object, java.lang.Object)
	 */
	@Override
	protected Object getFieldValue(Object object, Field field) {
		requireNonNull(object);
		requireNonNull(field);
		try {
			return field.get(object);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			throw new IllegalStateException("Error getting field '" + field.getName() + "'", e);
		}
	}

}
