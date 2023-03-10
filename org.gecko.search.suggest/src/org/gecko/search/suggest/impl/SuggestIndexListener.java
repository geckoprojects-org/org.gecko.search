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

import java.util.Map;

import org.gecko.search.api.IndexContextObject;
import org.gecko.search.api.IndexListener;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

/**
 * IndexListener that connects to the index process to also create a suggestion index out of this data
 * @author Mark Hoffmann
 * @since 10.03.2023
 */
@Component(name = "SuggestionIndexListener")
public class SuggestIndexListener<T> implements IndexListener {

	@Activate
	public void activate(Map<String, Object> properties) {
		
	}
	
	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.api.IndexListener#canHandle(org.gecko.search.api.IndexContextObject)
	 */
	@Override
	public boolean canHandle(IndexContextObject<?> context) {
		// TODO Auto-generated method stub
		return false;
	}
	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.api.IndexListener#onIndex(org.gecko.search.api.IndexContextObject)
	 */
	@Override
	public void onIndex(IndexContextObject<?> context) {
		// TODO Auto-generated method stub
		
	}

}
