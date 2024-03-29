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
package org.gecko.emf.search.document;

import org.eclipse.emf.ecore.EObject;
import org.gecko.search.ContextObjectFactory;

/**
 * Interface for {@link EObjectContextObjectFactory}
 * @author Mark Hoffmann
 * @since 08.03.2023
 */
public interface EObjectContextObjectFactory extends ContextObjectFactory<EObject, EObjectDocumentIndexObjectContext> {

}
