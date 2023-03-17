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

import org.apache.lucene.analysis.Analyzer;
import org.gecko.search.suggest.api.SuggestionConfiguration;
import org.gecko.search.suggest.api.SuggestionDescriptor;
import org.gecko.search.suggest.api.SuggestionService;
import org.gecko.search.suggest.api.SuggestionServiceImpl;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Service implementation of the suggestion service. To define the index location,
 * the corresponding configuration property must be provided
 * @author Ilenia Salvadori, Mark Hoffmann
 * @since 03.03.2023
 */
@Component(name = "ObjectSuggestionService", service = SuggestionService.class, configurationPolicy=ConfigurationPolicy.REQUIRE)
public class ObjectSuggestionServiceImpl extends SuggestionServiceImpl<Object, Field> {

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.suggest.api.SuggestionServiceImpl#activate(org.osgi.service.component.ComponentContext, org.gecko.search.suggest.api.SuggestionConfiguration)
	 */
	@Override
	@Activate
	public void activate(SuggestionConfiguration configuration) throws ConfigurationException {
		super.activate(configuration);
	}
	
	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.suggest.api.SuggestionServiceImpl#deactivate()
	 */
	@Override
	@Deactivate
	public void deactivate() {
		super.deactivate();
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.document.impl.LuceneIndexImpl#setAnalyzer(org.apache.lucene.analysis.Analyzer)
	 */
	@Override
	@Reference(name="analyzer", target="(type=standard)")
	public void setAnalyzer(Analyzer analyzer) {
		super.setAnalyzer(analyzer);
	}
	
	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.suggest.api.SuggestionServiceImpl#setSuggestionDescriptor(org.gecko.search.suggest.api.SuggestionDescriptor)
	 */
	@Override
	@Reference(name="descriptor")
	protected void setDescriptor(SuggestionDescriptor<Object, Field> suggestionDescriptor) {
		super.setDescriptor(suggestionDescriptor);
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
