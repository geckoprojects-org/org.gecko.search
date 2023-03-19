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

import static java.util.Objects.requireNonNull;

import org.apache.lucene.search.IndexSearcher;
import org.gecko.search.document.LuceneIndexService;
import org.gecko.search.document.context.DocumentIndexContextObject;
import org.osgi.framework.Bundle;
import org.osgi.framework.PrototypeServiceFactory;
import org.osgi.framework.ServiceRegistration;

/**
 * {@link PrototypeServiceFactory} to create index searchers. We created an own class to avoid circular
 * refernce problems in Felix SCR
 * @author Mark Hoffmann
 * @since 19.03.2023
 */
public class SearcherPrototypeServiceFactory<D extends DocumentIndexContextObject<?>> implements PrototypeServiceFactory<IndexSearcher> {
	
	private final LuceneIndexService<D> indexService;

	public SearcherPrototypeServiceFactory(LuceneIndexService<D> indexService) {
		requireNonNull(indexService);
		this.indexService = indexService;
	}

	/* 
	 * (non-Javadoc)
	 * @see org.osgi.framework.PrototypeServiceFactory#getService(org.osgi.framework.Bundle, org.osgi.framework.ServiceRegistration)
	 */
	@Override
	public IndexSearcher getService(Bundle bundle, ServiceRegistration<IndexSearcher> registration) {
		return indexService.aquireSearcher();
	}

	/* 
	 * (non-Javadoc)
	 * @see org.osgi.framework.PrototypeServiceFactory#ungetService(org.osgi.framework.Bundle, org.osgi.framework.ServiceRegistration, java.lang.Object)
	 */
	@Override
	public void ungetService(Bundle bundle, ServiceRegistration<IndexSearcher> registration, IndexSearcher service) {
		indexService.releaseSearcher(service);
	}

}
