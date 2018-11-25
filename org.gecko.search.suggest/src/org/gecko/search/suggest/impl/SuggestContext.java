/**
 * Copyright (c) 2012 - 2018 Data In Motion and others.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Data In Motion - initial API and implementation
 */
package org.gecko.search.suggest.impl;

/**
 * Context object for one element
 * @author ilenia
 * @since Nov 9, 2018
 */
public interface SuggestContext {	
	
	String getContent();
	
	String[] getLabels();
	
	String getPayload();
	
	long getWeight();

}
