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
package org.gecko.search.result.lucene.highlight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.apache.lucene.search.highlight.Formatter;
import org.apache.lucene.search.highlight.TokenGroup;
import org.gecko.searchresult.MatchHighlight;
import org.gecko.searchresult.SearchResultFactory;

/**
 * Creates match highlight information using a formatter
 * @author Mark Hoffmann
 * @since 01.09.2014
 * @deprecated use {@link PositionPostingsHighlighter} with {@link PositionPassageFormatter} instead
 */
public class MatchHighlightFormatter implements Formatter {

	private final List<MatchHighlight> highlightInformationList = new LinkedList<MatchHighlight>();
	private final Formatter delegateFormatter;

	/**
	 * Constructor without formatter
	 */
	public MatchHighlightFormatter() {
		delegateFormatter = null;
	}

	/**
	 * Constructor with delgated formatter to additionally format the text strings
	 * @param formatter the delgate formatter
	 */
	public MatchHighlightFormatter(Formatter formatter) {
		delegateFormatter = formatter;
	}

	/* 
	 * (non-Javadoc)
	 * @see org.apache.lucene.search.highlight.Formatter#highlightTerm(java.lang.String, org.apache.lucene.search.highlight.TokenGroup)
	 */
	@Override
	public String highlightTerm(String originalText, TokenGroup tokenGroup) {
		if (tokenGroup.getTotalScore() <= 0) {
			return originalText;
		}
		String text = originalText;
		if (delegateFormatter != null) {
			text = delegateFormatter.highlightTerm(originalText, tokenGroup);
		}
		MatchHighlight hi = SearchResultFactory.eINSTANCE.createMatchHighlight();
		hi.setStartOffset(tokenGroup.getStartOffset());
		hi.setEndOffset(tokenGroup.getEndOffset());
		hi.setText(originalText);
		hi.setHighlightedText(text);
		highlightInformationList.add(hi);
		return text;
	}

	/**
	 * Returns all collected highlight information and resets the list
	 * @return all collected highlight information and resets the list
	 */
	public List<MatchHighlight> getHighlightInformation() {
		return Collections.unmodifiableList(highlightInformationList);
	}

	/**
	 * Returns all collected highlight information and resets the list
	 * @return all collected highlight information and resets the list
	 */
	public List<MatchHighlight> getHighlightInformationAndReset() {
		List<MatchHighlight> resultList = new ArrayList<MatchHighlight>(highlightInformationList);
		resetHighlightInformation();
		return Collections.unmodifiableList(resultList);
	}

	/**
	 * Resets all highlight information
	 */
	public void resetHighlightInformation() {
		highlightInformationList.clear();
	}

}
