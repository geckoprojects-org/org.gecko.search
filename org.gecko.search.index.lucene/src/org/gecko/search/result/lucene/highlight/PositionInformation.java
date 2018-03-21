package org.gecko.search.result.lucene.highlight;

/**
 * 
 * @author mark
 * @since 15.10.2014
 * @deprecated use {@link PositionPostingsHighlighter} instead
 */
public class PositionInformation {
		final String text;
		final int start;
		final int end;
		
		/**
		 * Creates a new instance.
		 */
		public PositionInformation(String text, int start, int end) {
			this.text = text;
			this.start = start;
			this.end = end;
		}

		/**
		 * Returns the text.
		 * @return the text
		 */
		public String getText() {
			return text;
		}

		/**
		 * Returns the start.
		 * @return the start
		 */
		public int getStart() {
			return start;
		}

		/**
		 * Returns the end.
		 * @return the end
		 */
		public int getEnd() {
			return end;
		}
	}