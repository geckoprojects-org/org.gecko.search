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
package org.gecko.emf.search.suggest.impl;

import static java.util.Objects.requireNonNull;

import org.apache.lucene.analysis.Analyzer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
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
 * the configuration is used. 
 * That is for the push stream as well as for the resource provider
 * @author Mark Hoffmann
 * @since Nov 9, 2018
 */
@Component(name = "EObjectStreamSuggestionService", service = SuggestionService.class, configurationPolicy=ConfigurationPolicy.REQUIRE)
public class EObjectStreamSuggestionService extends StreamSuggestionServiceImpl<EObject, EStructuralFeature> {

	/**
	 * Called on component activation
	 * @param ctx the component context
	 * @throws ConfigurationException
	 */
	@Activate
	@Override
	public void activate(SuggestionConfiguration configuration) throws ConfigurationException {
		super.activate(configuration);
	}

	/**
	 * Called on component de-activation
	 */
	@Deactivate
	@Override
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
	 * @see org.gecko.search.suggest.impl.BasicSuggestionService#setSuggestionDescriptor(org.gecko.search.suggest.api.SuggestionDescriptor)
	 */
	@Override
	@Reference(name = "descriptor")
	protected void setDescriptor(SuggestionDescriptor<EObject, EStructuralFeature> suggestionDescriptor) {
		super.setDescriptor(suggestionDescriptor);
	}
	
	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.suggest.api.StreamSuggestionServiceImpl#setContextStream(org.osgi.util.pushstream.PushStream)
	 */
	@Override
	@Reference(name = "contextStream")
	protected void setContextStream(PushStream<EObject> contextStream) {
		super.setContextStream(contextStream);
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.suggest.api.SuggestionServiceImpl#getPayload(java.lang.Object, java.lang.Object)
	 */
	@Override
	protected Object getPayload(EObject object, EStructuralFeature payloadField) {
		return getFieldValue(object, payloadField);
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.suggest.api.SuggestionServiceImpl#getFieldValue(java.lang.Object, java.lang.Object)
	 */
	@Override
	protected Object getFieldValue(EObject object, EStructuralFeature field) {
		requireNonNull(object);
		requireNonNull(field);
		return object.eGet(field);
	}

}
