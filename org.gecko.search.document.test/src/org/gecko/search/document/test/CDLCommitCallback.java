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
package org.gecko.search.document.test;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.concurrent.CountDownLatch;

import org.gecko.search.document.CommitCallback;
import org.gecko.search.document.context.DocumentIndexContextObject;

/**
 * 
 * @author mark
 * @since 10.03.2023
 */
public class CDLCommitCallback implements CommitCallback {
	
	private final CountDownLatch latch;
	
	public static CDLCommitCallback create(int count) {
		return new CDLCommitCallback(count);
	}

	private CDLCommitCallback(int count) {
		latch = new CountDownLatch(count);
	}
	
	/**
	 * Returns the latch.
	 * @return the latch
	 */
	public CountDownLatch getLatch() {
		return latch;
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.document.CommitCallback#commited(org.gecko.search.document.context.DocumentIndexContextObject)
	 */
	@Override
	public void commited(DocumentIndexContextObject<?> ctx) {
		latch.countDown();
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.document.CommitCallback#error(org.gecko.search.document.context.DocumentIndexContextObject, java.lang.Throwable)
	 */
	@Override
	public void error(DocumentIndexContextObject<?> ctx, Throwable t) {
		fail("Error commiting " + ctx.getObject().toString());
	}

}
