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
package org.gecko.search.suggest.api;

import org.gecko.search.api.ContextObjectFactory;
import org.osgi.annotation.versioning.ProviderType;

/**
 * 
 * @author mark
 * @since 08.12.2018
 */
@ProviderType
public interface SuggestionContextFactory extends ContextObjectFactory<SuggestionContext> {

}
