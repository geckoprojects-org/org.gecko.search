/**
 * Copyright (c) 2012 - 2019 Data In Motion and others.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Data In Motion - initial API and implementation
 */
package org.gecko.search.document.impl;

import java.util.Dictionary;
import java.util.Hashtable;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.osgi.framework.Bundle;
import org.osgi.framework.PrototypeServiceFactory;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

/**
 * 
 * @author jalbert
 * @since 1 Feb 2019
 */
@Component(service=StandardAnalyzerComponent.class, immediate=true)
public class StandardAnalyzerComponent implements PrototypeServiceFactory<Analyzer>{

	private ServiceRegistration<Analyzer> registerService;

	@Activate
	public void activate(ComponentContext ctx) {
		Dictionary<String, Object> props = new Hashtable<>();
		props.put("type", "standard");
		registerService = ctx.getBundleContext().registerService(Analyzer.class, this, props);
	}
	
	@Deactivate
	public void deactivate() {
		registerService.unregister();
		registerService = null;
	}
	
	
	/* 
	 * (non-Javadoc)
	 * @see org.osgi.framework.PrototypeServiceFactory#getService(org.osgi.framework.Bundle, org.osgi.framework.ServiceRegistration)
	 */
	@Override
	public Analyzer getService(Bundle bundle, ServiceRegistration<Analyzer> registration) {
		return new StandardAnalyzer();
	}

	/* 
	 * (non-Javadoc)
	 * @see org.osgi.framework.PrototypeServiceFactory#ungetService(org.osgi.framework.Bundle, org.osgi.framework.ServiceRegistration, java.lang.Object)
	 */
	@Override
	public void ungetService(Bundle bundle, ServiceRegistration<Analyzer> registration, Analyzer service) {
		
	}
	
	

}
