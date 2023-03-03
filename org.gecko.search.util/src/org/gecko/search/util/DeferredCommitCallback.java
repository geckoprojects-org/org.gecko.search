/**
 * Copyright (c) 2012 - 2023 Data In Motion and others.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made available under the terms of the 
 * Eclipse Public License v2.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *     Data In Motion - initial API and implementation
 */
package org.gecko.search.util;

import org.gecko.search.document.CommitCallback;
import org.gecko.search.document.DocumentIndexContextObject;
import org.osgi.util.promise.Deferred;

/**
 * Commit callback implementation that keeps a {@link Deferred}. This can be used with Promises
 * @author ilenia
 * @since Mar 19, 2021
 */
public class DeferredCommitCallback implements CommitCallback {

	private Deferred<Boolean> deferred;

	/**
	 * Creates a new instance.
	 * @param deferred
	 */
	public DeferredCommitCallback(Deferred<Boolean> deferred) {
		this.deferred = deferred;
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.document.CommitCallback#commited(org.gecko.search.document.DocumentIndexContextObject)
	 */
	@Override
	public void commited(DocumentIndexContextObject ctx) {
		deferred.resolve(true);
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.document.CommitCallback#error(org.gecko.search.document.DocumentIndexContextObject, java.lang.Throwable)
	 */
	@Override
	public void error(DocumentIndexContextObject ctx, Throwable t) {
		deferred.fail(t);
	}

	
}
