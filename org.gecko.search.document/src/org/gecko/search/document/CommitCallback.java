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
package org.gecko.search.document;

/**
 * Callback to get informed about commits
 * @author jalbert
 * @since 1 Feb 2019
 */
public interface CommitCallback {

	/**
	 * Called on commit
	 * @param ctx the context object
	 */
	public void commited(DocumentIndexContextObject<?> ctx);

	/**
	 * Called on errors
	 * @param ctx the context object
	 * @param t the error
	 */
	public void error(DocumentIndexContextObject<?> ctx, Throwable t);
}
