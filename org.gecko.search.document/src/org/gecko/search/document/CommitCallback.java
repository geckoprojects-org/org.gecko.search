/**
 * Copyright (c) 2012 - 2019 Data In Motion and others.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Data In Motion - initial API and implementation
 */
package org.gecko.search.document;

/**
 * 
 * @author jalbert
 * @since 1 Feb 2019
 */
public interface CommitCallback {

	public void commited(DocumentIndexContextObject ctx);

	public void error(DocumentIndexContextObject ctx, Throwable t);
}
