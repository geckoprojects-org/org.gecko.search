/**
 * Copyright (c) 2012 - 2021 Data In Motion and others.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Data In Motion - initial API and implementation
 */
package org.gecko.search.util;

import java.util.HashMap;
import java.util.Map;

import org.gecko.emf.mongo.Options;
import org.gecko.emf.mongo.pushstream.constants.MongoPushStreamConstants;
import org.osgi.annotation.versioning.ProviderType;
import org.osgi.util.promise.Promise;

/**
 * 
 * @author ilenia
 * @since Mar 19, 2021
 */
@ProviderType
public interface CommonIndexService {
	
	public Promise<Void> initializeIndex();
	
	public void resetIndex();
	

	public static Map<Object, Object> getLoadOptions(){
		Map<Object, Object> loadOptions = new HashMap<>();
		loadOptions.put(Options.OPTION_BATCH_SIZE, Integer.valueOf(600));
		loadOptions.put(MongoPushStreamConstants.OPTION_QUERY_PUSHSTREAM, Boolean.TRUE);
		return loadOptions;
	}

}
