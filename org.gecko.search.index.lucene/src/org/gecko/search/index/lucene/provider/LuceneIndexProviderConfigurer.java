/**
 * Copyright (c) 2014 Data In Motion and others.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Data In Motion - initial API and implementation
 */
package org.gecko.search.index.lucene.provider;

import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;

/**
 * Interface to configure the index writer
 * @author Mark Hoffmann
 * @since 04.08.2014
 */
@Deprecated
public interface LuceneIndexProviderConfigurer {
	
	/**
	 * Returns the id of the {@link IndexWriter} service to can be configured
	 * @return the id of the {@link IndexWriter} service to can be configured
	 */
	public String getWriterId();
	
	/**
	 * Configures the {@link IndexWriter}
	 * @param config the configuration instance
	 */
	public void configureIndexWriter(IndexWriterConfig config);

}
