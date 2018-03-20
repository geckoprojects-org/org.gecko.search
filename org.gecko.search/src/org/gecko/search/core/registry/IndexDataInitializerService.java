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
package org.gecko.search.core.registry;

import org.gecko.emf.util.registry.RegistryIntializer;
import org.gecko.search.core.model.IndexData;

/**
 * An interface for an {@link IndexData} initializer
 * @author Mark Hoffmann
 * @since 01.09.2014
 */
public interface IndexDataInitializerService extends RegistryIntializer<IndexData> {

}
