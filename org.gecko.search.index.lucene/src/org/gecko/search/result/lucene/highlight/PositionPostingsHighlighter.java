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

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.lucene.index.IndexOptions;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.postingshighlight.PassageFormatter;
import org.apache.lucene.search.postingshighlight.PostingsHighlighter;
import org.gecko.searchresult.MatchHighlight;
import org.gecko.searchresult.MatchResult;

/**
 * Position postings highlighter that provides {@link MatchHighlight} instances for the {@link MatchResult}
 * @author Mark Hoffmann
 * @since 15.10.2014
 */
public class PositionPostingsHighlighter extends PostingsHighlighter {

	private PassageFormatter formatter = null;

	/* 
	 * (non-Javadoc)
	 * @see org.apache.lucene.search.postingshighlight.PostingsHighlighter#getFormatter(java.lang.String)
	 */
	protected PassageFormatter getFormatter(String field) {
		if (formatter == null) {
			formatter = new PositionPassageFormatter();
		}
		return formatter;
	};

	/**
	 * @param fields
	 * @param query
	 * @param searcher
	 * @param topDocs
	 * @return
	 * @throws IOException
	 */
	public Map<String,List<MatchHighlight>[]> highlightFieldsAsMatchHighlight(String fields[], Query query, IndexSearcher searcher, TopDocs topDocs) throws IOException {
		int maxPassages[] = new int[fields.length];
		Arrays.fill(maxPassages, 1);
		return highlightFieldsAsMatchHighlight(fields, query, searcher, topDocs, maxPassages);
	}

	public Map<String,List<MatchHighlight>[]> highlightFieldsAsMatchHighlight(String fields[], Query query, IndexSearcher searcher, TopDocs topDocs, int maxPassages[]) throws IOException {
		final ScoreDoc scoreDocs[] = topDocs.scoreDocs;
		int docids[] = new int[scoreDocs.length];
		for (int i = 0; i < docids.length; i++) {
			docids[i] = scoreDocs[i].doc;
		}

		return highlightFieldsAsMatchHighlight(fields, query, searcher, docids, maxPassages);
	}

	/**
	 * Highlights the top-N passages from multiple fields,
	 * for the provided int[] docids.
	 * 
	 * @param fieldsIn field names to highlight. 
	 *        Must have a stored string value and also be indexed with offsets.
	 * @param query query to highlight.
	 * @param searcher searcher that was previously used to execute the query.
	 * @param docidsIn containing the document IDs to highlight.
	 * @param maxPassagesIn The maximum number of top-N ranked passages per-field used to 
	 *        form the highlighted snippets.
	 * @return Map keyed on field name, containing the array of {@link MatchHighlight} instance 
	 *         corresponding to the documents in <code>docidsIn</code>. 
	 *         If no highlights were found for a document, the
	 *         first {@code maxPassages} from the field will
	 *         be returned.
	 * @throws IOException if an I/O error occurred during processing
	 * @throws IllegalArgumentException if <code>field</code> was indexed without 
	 *         {@link IndexOptions#DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS}
	 */
	@SuppressWarnings("unchecked")
	public Map<String,List<MatchHighlight>[]> highlightFieldsAsMatchHighlight(String fieldsIn[], Query query, IndexSearcher searcher, int[] docidsIn, int maxPassagesIn[]) throws IOException {
		Map<String,List<MatchHighlight>[]> snippets = new HashMap<>();
		for(Map.Entry<String,Object[]> ent : highlightFieldsAsObjects(fieldsIn, query, searcher, docidsIn, maxPassagesIn).entrySet()) {
			Object[] snippetObjects = ent.getValue();
			List<MatchHighlight>[] snippetMatchHighlights = new List[snippetObjects.length];
			snippets.put(ent.getKey(), snippetMatchHighlights);
			for(int i = 0; i < snippetObjects.length; i++) {
				Object snippet = snippetObjects[i];
				if (snippet != null) {
					snippetMatchHighlights[i] = (List<MatchHighlight>)snippet;
				}
			}
		}

		return snippets;
	}

}
