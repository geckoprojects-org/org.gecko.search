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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.gecko.search.suggest.api.SuggestionConfiguration;
import org.gecko.search.suggest.api.SuggestionDescriptor;
import org.gecko.search.suggest.api.SuggestionService;
import org.gecko.search.suggest.api.SuggestionServiceImpl;
import org.osgi.service.component.ComponentContext;
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
@Component(name = "EObjectSuggestionService", service = SuggestionService.class, configurationPolicy=ConfigurationPolicy.REQUIRE)
public class EObjectSuggestionServiceImpl extends SuggestionServiceImpl<EObject, EStructuralFeature> {

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.suggest.api.SuggestionServiceImpl#activate(org.osgi.service.component.ComponentContext, org.gecko.search.suggest.api.SuggestionConfiguration)
	 */
	@Override
	@Activate
	protected void activate(ComponentContext ctx, SuggestionConfiguration configuration) {
		super.activate(ctx, configuration);
	}
	
	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.suggest.api.SuggestionServiceImpl#deactivate()
	 */
	@Override
	@Deactivate
	protected void deactivate() {
		super.deactivate();
	}
	
	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.suggest.api.SuggestionServiceImpl#setSuggestionDescriptor(org.gecko.search.suggest.api.SuggestionDescriptor)
	 */
	@Override
	@Reference(name="descriptor")
	protected void setSuggestionDescriptor(SuggestionDescriptor<EObject, EStructuralFeature> suggestionDescriptor) {
		super.setSuggestionDescriptor(suggestionDescriptor);
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
		return object.eGet(field);
	}

}
