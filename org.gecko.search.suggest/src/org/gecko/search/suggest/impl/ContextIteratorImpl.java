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

import java.io.UnsupportedEncodingException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.lucene.search.suggest.InputIterator;
import org.apache.lucene.util.BytesRef;
import org.gecko.search.suggest.api.SuggestionContext;

/**
 * Iterator for the {@link SuggestionContext}, that contains all relevant data for suggestion
 * @author ilenia
 * @since Nov 9, 2018
 */
public class ContextIteratorImpl implements InputIterator
	{
	    private Iterator<SuggestionContext> deviceIterator;
	    private SuggestionContext currentContext;

	    public ContextIteratorImpl(Iterator<SuggestionContext> deviceIterator) {
	        this.deviceIterator = deviceIterator;
	    }
	    
	    /* 
	     * (non-Javadoc)
	     * @see org.apache.lucene.search.suggest.InputIterator#hasContexts()
	     */
	    public boolean hasContexts() {
	        return true;
	    }
	    
	    /* 
	     * (non-Javadoc)
	     * @see org.apache.lucene.search.suggest.InputIterator#hasPayloads()
	     */
	    public boolean hasPayloads() {
	        return true;
	    }

	    /**
	     * @return
	     */
	    public Comparator<BytesRef> getComparator() {
	        return null;
	    }

	    /* 
	     * (non-Javadoc)
	     * @see org.apache.lucene.util.BytesRefIterator#next()
	     */
	    public BytesRef next() {
	        if (deviceIterator.hasNext()) {
	            currentContext = deviceIterator.next();
	            try {
	            	//we want completion against the device description
	                return new BytesRef(currentContext.getContent().getBytes("UTF8")); 
	            } catch (UnsupportedEncodingException e) {
	                throw new Error("Couldn't convert to UTF-8");
	            }
	        } else {
	            return null;
	        }
	    }

	    /* 
	     * (non-Javadoc)
	     * @see org.apache.lucene.search.suggest.InputIterator#payload()
	     */
	    public BytesRef payload() {
	            return new BytesRef(currentContext.getPayload().getBytes());
	    }

	    /* 
	     * (non-Javadoc)
	     * @see org.apache.lucene.search.suggest.InputIterator#contexts()
	     */
	    public Set<BytesRef> contexts() {           	
	    	try {
	            Set<BytesRef> labels = new HashSet<BytesRef>();
	            for (String label : currentContext.getLabels()) {
	            	labels.add(new BytesRef(label.getBytes("UTF8")));
	            }
	            return labels;
	        } catch (UnsupportedEncodingException e) {
	            throw new Error("Couldn't convert to UTF-8");
	        }
	    }

	    /* 
	     * (non-Javadoc)
	     * @see org.apache.lucene.search.suggest.InputIterator#weight()
	     */
	    public long weight() {
	        return currentContext.getWeight();
	    }
	}
