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
package org.gecko.search.document.impl;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
 * Service component that provides {@link Analyzer} instances
 * @author jalbert
 * @since 1 Feb 2019
 */
@Component(service=StandardAnalyzerComponent.class, immediate=true)
public class StandardAnalyzerComponent implements PrototypeServiceFactory<Analyzer>{

	private ServiceRegistration<Analyzer> registerService;
	private final  Map<Bundle, Analyzer> analyzerInUse = new ConcurrentHashMap<>();

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
		return analyzerInUse.computeIfAbsent(bundle, b->new StandardAnalyzer());
	}

	/* 
	 * (non-Javadoc)
	 * @see org.osgi.framework.PrototypeServiceFactory#ungetService(org.osgi.framework.Bundle, org.osgi.framework.ServiceRegistration, java.lang.Object)
	 */
	@Override
	public void ungetService(Bundle bundle, ServiceRegistration<Analyzer> registration, Analyzer service) {
		Analyzer analyzer = analyzerInUse.remove(bundle);
		if (analyzer != null) {
			analyzer.close();
		}
	}
	
}
