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

import org.apache.lucene.analysis.Analyzer;
import org.gecko.search.IndexListener;
import org.gecko.search.document.LuceneIndexService;
import org.gecko.search.document.context.ObjectContextObject;
import org.gecko.search.document.index.LuceneIndexImpl;
import org.osgi.framework.BundleContext;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;

/**
 * Default implemenation of the Lucene index that can handle Object
 * @author Mark Hoffmann
 * @since 08.03.2023
 */
@Component(name = "DefaultLuceneIndex", service = LuceneIndexService.class, configurationPolicy = ConfigurationPolicy.REQUIRE)
public class DefaultLuceneIndex extends LuceneIndexImpl<ObjectContextObject> {

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.document.impl.LuceneIndexImpl#activate(org.gecko.search.document.impl.LuceneIndexImpl.Config, org.osgi.service.component.ComponentContext)
	 */
	@Override
	@Activate
	public void activate(IndexConfig serviceConfig, BundleContext context) throws ConfigurationException {
		super.activate(serviceConfig, context);
	}
	
	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.document.impl.LuceneIndexImpl#deactivate()
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
	 * @see org.gecko.search.document.LuceneIndexImpl#addIndexListener(org.gecko.search.api.IndexListener)
	 */
	@Override
	@Reference(name = "indexListener", cardinality = ReferenceCardinality.OPTIONAL, policy = ReferencePolicy.DYNAMIC)
	protected void addIndexListener(IndexListener listener) {
		super.addIndexListener(listener);
	}
	
	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.document.LuceneIndexImpl#removeIndexListener(org.gecko.search.api.IndexListener)
	 */
	@Override
	protected void removeIndexListener(IndexListener listener) {
		super.removeIndexListener(listener);
	}

}
