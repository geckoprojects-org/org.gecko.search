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

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.gecko.search.api.IndexService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;

/**
 * Component that provides 
 * @author mark
 * @since 08.12.2018
 */
@Component(configurationPolicy=ConfigurationPolicy.REQUIRE)
public class SuggestionDataProvider implements IndexService {

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.api.IndexService#indexAdd(java.util.Map, org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public void indexAdd(Map<String, Object> properties, EObject object) {
		// TODO Auto-generated method stub
		
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.api.IndexService#indexAdd(java.util.Map, org.eclipse.emf.ecore.EObject[])
	 */
	@Override
	public void indexAdd(Map<String, Object> properties, EObject... objects) {
		// TODO Auto-generated method stub
		
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.api.IndexService#indexAdd(java.util.Map, java.util.Collection)
	 */
	@Override
	public void indexAdd(Map<String, Object> properties, Collection<EObject> objects) {
		// TODO Auto-generated method stub
		
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.api.IndexService#indexUpdate(java.util.Map, org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public void indexUpdate(Map<String, Object> properties, EObject object) {
		// TODO Auto-generated method stub
		
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.api.IndexService#indexUpdate(java.util.Map, org.eclipse.emf.ecore.EObject[])
	 */
	@Override
	public void indexUpdate(Map<String, Object> properties, EObject... objects) {
		// TODO Auto-generated method stub
		
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.api.IndexService#indexUpdate(java.util.Map, java.util.Collection)
	 */
	@Override
	public void indexUpdate(Map<String, Object> properties, Collection<EObject> objects) {
		// TODO Auto-generated method stub
		
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.api.IndexService#indexRemove(java.util.Map, org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public void indexRemove(Map<String, Object> properties, EObject object) {
		// TODO Auto-generated method stub
		
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.api.IndexService#indexRemove(java.util.Map, org.eclipse.emf.ecore.EObject[])
	 */
	@Override
	public void indexRemove(Map<String, Object> properties, EObject... objects) {
		// TODO Auto-generated method stub
		
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.api.IndexService#indexRemove(java.util.Map, java.util.Collection)
	 */
	@Override
	public void indexRemove(Map<String, Object> properties, Collection<EObject> objects) {
		// TODO Auto-generated method stub
		
	}

}
