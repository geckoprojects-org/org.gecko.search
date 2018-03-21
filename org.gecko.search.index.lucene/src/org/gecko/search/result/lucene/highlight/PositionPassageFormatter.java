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
import java.util.List;

import org.apache.lucene.search.postingshighlight.Passage;
import org.apache.lucene.search.postingshighlight.PassageFormatter;
import org.gecko.search.result.core.SearchResultException;
import org.gecko.searchresult.MatchHighlight;
import org.gecko.searchresult.SearchResultFactory;

/**
 * Passage formatter that stores positions 
 * @author Mark Hoffmann
 * @since 15.10.2014
 */
public class PositionPassageFormatter extends PassageFormatter {

	/**
	 * Creates the match highlight for the given parameters
	 * @param start the start offset must be larger than -1
	 * @param end the end offset must be larger than the start offset
	 * @param content the full content
	 * @return the match highlight instance
	 */
	private MatchHighlight createMatchHighlight(int start, int end, String content) {
		if (start < 0 || end <= start || content == null) {
			throw new SearchResultException("Error create MatchHighlight for content " + content + " (" + start + ":" + end + ")");
		}
		String highlightText = content.substring(start, end);
		MatchHighlight highlight = SearchResultFactory.eINSTANCE.createMatchHighlight();
		highlight.setEndOffset(end);
		highlight.setStartOffset(start);
		highlight.setHighlightedText(highlightText);
		highlight.setText(content);
		return highlight;
	}

	/* 
	 * (non-Javadoc)
	 * @see org.apache.lucene.search.postingshighlight.PassageFormatter#format(org.apache.lucene.search.postingshighlight.Passage[], java.lang.String)
	 */
	@Override
	public Object format(Passage[] passages, String content) {
		if (content == null || passages == null || passages.length == 0) {
			return null;
		}
		int pos = 0;
		List<MatchHighlight> highlights = new ArrayList<>(passages.length);
		for (Passage passage : passages) {
			pos = passage.getStartOffset();
			for (int i = 0; i < passage.getNumMatches(); i++) {
				int start = passage.getMatchStarts()[i];
				int end = passage.getMatchEnds()[i];
				// its possible to have overlapping terms
				if (end > pos) {
					MatchHighlight h = createMatchHighlight(Math.max(pos, start), end, content);
					highlights.add(h);
					pos = end;
				}
			}
			pos = passage.getEndOffset();
		}
		return highlights;
	}

}
