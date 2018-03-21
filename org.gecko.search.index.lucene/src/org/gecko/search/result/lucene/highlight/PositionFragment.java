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

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


/**
 * 
 * @author mark
 * @since 31.08.2014
 * @deprecated use {@link PositionPostingsHighlighter} instead
 */
public class PositionFragment {
	
	CharSequence markedUpText;
	int fragNum;
	private int textStartPos;
	private int textEndPos;
	float score;
	private final List<PositionInformation> posInfoList = new LinkedList<>();

	public PositionFragment(CharSequence markedUpText,int textStartPos, int fragNum) {
		this.markedUpText=markedUpText;
		this.setTextStartPos(textStartPos);
		this.fragNum = fragNum;
	}
	
	public void addPositionInfo(PositionInformation info) {
		posInfoList.add(info);
	}
	
	public List<PositionInformation> getPositionInfos() {
		return Collections.unmodifiableList(posInfoList);
	}

	void setScore(float score) {
		this.score=score;
	}
	
	public float getScore()
	{
		return score;
	}
	/**
	 * @param frag2 Fragment to be merged into this one
	 */
	public void merge(PositionFragment frag2) {
		setTextEndPos(frag2.getTextEndPos());
		score=Math.max(score,frag2.score);
	}
	
	/**
	 * @return true if this fragment follows the one passed
	 */
	public boolean follows(PositionFragment fragment) {
		return getTextStartPos() == fragment.getTextEndPos();
	}

	/**
	 * @return the fragment sequence number
	 */
	public int getFragNum()  {
		return fragNum;
	}

	/* Returns the marked-up text for this text fragment
	 */
	@Override
	public String toString() {
		return markedUpText.subSequence(getTextStartPos(), getTextEndPos()).toString();
	}

	/**
	 * Returns the textStartPos.
	 * @return the textStartPos
	 */
	public int getTextStartPos() {
		return textStartPos;
	}

	/**
	 * Sets the textStartPos.
	 * @param textStartPos the textStartPos to set
	 */
	public void setTextStartPos(int textStartPos) {
		this.textStartPos = textStartPos;
	}

	/**
	 * Returns the textEndPos.
	 * @return the textEndPos
	 */
	public int getTextEndPos() {
		return textEndPos;
	}

	/**
	 * Sets the textEndPos.
	 * @param textEndPos the textEndPos to set
	 */
	public void setTextEndPos(int textEndPos) {
		this.textEndPos = textEndPos;
	}

}
