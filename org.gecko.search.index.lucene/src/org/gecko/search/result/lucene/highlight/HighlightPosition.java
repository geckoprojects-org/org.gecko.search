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
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.search.highlight.DefaultEncoder;
import org.apache.lucene.search.highlight.Encoder;
import org.apache.lucene.search.highlight.Fragmenter;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.Scorer;
import org.apache.lucene.search.highlight.SimpleFragmenter;
import org.apache.lucene.util.PriorityQueue;

/**
 * Custom highlight position implementation
 * @author Mark Hoffmann
 * @since 31.08.2014
 */
public class HighlightPosition {

	public static final int DEFAULT_MAX_CHARS_TO_ANALYZE = 50*1024;

	private int maxDocCharsToAnalyze = DEFAULT_MAX_CHARS_TO_ANALYZE;
	private Encoder encoder;
	private Fragmenter textFragmenter = new SimpleFragmenter();
	private Scorer fragmentScorer=null;

	public HighlightPosition(Scorer fragmentScorer) {
		this(new DefaultEncoder(),fragmentScorer);
	}

	public HighlightPosition(Encoder encoder, Scorer fragmentScorer) {
		this.encoder = encoder;
		this.fragmentScorer = fragmentScorer;
	}
	
	  /**
	   * Low level api to get the most relevant (formatted) sections of the document.
	   * This method has been made public to allow visibility of score information held in TextFragment objects.
	   * Thanks to Jason Calabrese for help in redefining the interface.
	   * @throws IOException If there is a low-level I/O error
	   * @throws InvalidTokenOffsetsException thrown if any token's endOffset exceeds the provided text's length
	   */
	  public final PositionFragment[] getBestTextFragments(TokenStream tokenStream, String text, boolean mergeContiguousFragments, int maxNumFragments) throws IOException, InvalidTokenOffsetsException {
	    ArrayList<PositionFragment> docFrags = new ArrayList<>();
	    StringBuilder newText=new StringBuilder();

	    CharTermAttribute termAtt = tokenStream.addAttribute(CharTermAttribute.class);
	    OffsetAttribute offsetAtt = tokenStream.addAttribute(OffsetAttribute.class);
	    tokenStream.reset();
	    PositionFragment currentFrag =  new PositionFragment(newText,newText.length(), docFrags.size());

	    if (fragmentScorer instanceof QueryScorer) {
	      ((QueryScorer) fragmentScorer).setMaxDocCharsToAnalyze(maxDocCharsToAnalyze);
	    }
	    
	    TokenStream newStream = fragmentScorer.init(tokenStream);
	    if(newStream != null) {
	      tokenStream = newStream;
	    }
	    
	    fragmentScorer.startFragment(null);
	    docFrags.add(currentFrag);
	    FragmentQueue fragQueue = new FragmentQueue(maxNumFragments);

	    try {

	      String tokenText;
	      int startOffset;
	      int endOffset;
	      int lastEndOffset = 0;
	      textFragmenter.start(text, tokenStream);

	      TokenGroup tokenGroup = new TokenGroup(tokenStream);

	      for (boolean next = tokenStream.incrementToken(); next && (offsetAtt.startOffset() < maxDocCharsToAnalyze);
	            next = tokenStream.incrementToken())  {
	        if(  (offsetAtt.endOffset() > text.length()) || (offsetAtt.startOffset() > text.length()) ) {
	          throw new InvalidTokenOffsetsException("Token "+ termAtt.toString()
	              +" exceeds length of provided text sized "+text.length());
	        }
	        if((tokenGroup.getNumTokens() > 0) && (tokenGroup.getStartOffset() >= tokenGroup.getEndOffset())) {
	          //the current token is distinct from previous tokens -
	          // markup the cached token group info
	          startOffset = tokenGroup.matchStartOffset;
	          endOffset = tokenGroup.matchEndOffset;
	          tokenText = text.substring(startOffset, endOffset);
	          PositionInformation pi = new PositionInformation(tokenText, startOffset, endOffset);
	          
	          String markedUpText = "+" + encoder.encodeText(tokenText) + "+";
	          //store any whitespace etc from between this and last group
	          if (startOffset > lastEndOffset)
	            newText.append(encoder.encodeText(text.substring(lastEndOffset, startOffset)));
	          newText.append(markedUpText);
	          lastEndOffset=Math.max(endOffset, lastEndOffset);
	          tokenGroup.clear();

	          //check if current token marks the start of a new fragment
	          if(textFragmenter.isNewFragment())
	          {
	            currentFrag.setScore(fragmentScorer.getFragmentScore());
	            //record stats for a new fragment
	            currentFrag.setTextEndPos(newText.length());
	            currentFrag =new PositionFragment(newText, newText.length(), docFrags.size());
	            currentFrag.addPositionInfo(pi);
	            fragmentScorer.startFragment(null);
	            docFrags.add(currentFrag);
	          }
	        }

	        tokenGroup.addToken(fragmentScorer.getTokenScore());

//	        if(lastEndOffset>maxDocBytesToAnalyze)
//	        {
//	          break;
//	        }
	      }
	      currentFrag.setScore(fragmentScorer.getFragmentScore());

	      if(tokenGroup.numTokens>0)
	      {
	        //flush the accumulated text (same code as in above loop)
	        startOffset = tokenGroup.matchStartOffset;
	        endOffset = tokenGroup.matchEndOffset;
	        tokenText = text.substring(startOffset, endOffset);
	        PositionInformation pi = new PositionInformation(tokenText, startOffset, endOffset);
	        currentFrag.addPositionInfo(pi);
	        String markedUpText = "+" + encoder.encodeText(tokenText) + "+";
	        //store any whitespace etc from between this and last group
	        if (startOffset > lastEndOffset)
	          newText.append(encoder.encodeText(text.substring(lastEndOffset, startOffset)));
	        newText.append(markedUpText);
	        lastEndOffset=Math.max(lastEndOffset,endOffset);
	      }

	      //Test what remains of the original text beyond the point where we stopped analyzing
	      if (
//	          if there is text beyond the last token considered..
	          (lastEndOffset < text.length())
	          &&
//	          and that text is not too large...
	          (text.length()<= maxDocCharsToAnalyze)
	        )
	      {
	        //append it to the last fragment
	        newText.append(encoder.encodeText(text.substring(lastEndOffset)));
	      }

	      currentFrag.setTextEndPos(newText.length());

	      //sort the most relevant sections of the text
	      for (Iterator<PositionFragment> i = docFrags.iterator(); i.hasNext();)
	      {
	        currentFrag = i.next();

	        //If you are running with a version of Lucene before 11th Sept 03
	        // you do not have PriorityQueue.insert() - so uncomment the code below
	        /*
	                  if (currentFrag.getScore() >= minScore)
	                  {
	                    fragQueue.put(currentFrag);
	                    if (fragQueue.size() > maxNumFragments)
	                    { // if hit queue overfull
	                      fragQueue.pop(); // remove lowest in hit queue
	                      minScore = ((TextFragment) fragQueue.top()).getScore(); // reset minScore
	                    }


	                  }
	        */
	        //The above code caused a problem as a result of Christoph Goller's 11th Sept 03
	        //fix to PriorityQueue. The correct method to use here is the new "insert" method
	        // USE ABOVE CODE IF THIS DOES NOT COMPILE!
	        fragQueue.insertWithOverflow(currentFrag);
	      }

	      //return the most relevant fragments
	      PositionFragment frag[] = new PositionFragment[fragQueue.size()];
	      for (int i = frag.length - 1; i >= 0; i--)
	      {
	        frag[i] = fragQueue.pop();
	      }

	      //merge any contiguous fragments to improve readability
	      if(mergeContiguousFragments)
	      {
	        mergeContiguousFragments(frag);
	        ArrayList<PositionFragment> fragTexts = new ArrayList<>();
	        for (int i = 0; i < frag.length; i++)
	        {
	          if ((frag[i] != null) && (frag[i].getScore() > 0))
	          {
	            fragTexts.add(frag[i]);
	          }
	        }
	        frag= fragTexts.toArray(new PositionFragment[0]);
	      }

	      return frag;

	    }
	    finally
	    {
	      if (tokenStream != null)
	      {
	        try
	        {
	          tokenStream.end();
	          tokenStream.close();
	        }
	        catch (Exception e)
	        {
	        }
	      }
	    }
	  }
	  
	  /** Improves readability of a score-sorted list of TextFragments by merging any fragments
	   * that were contiguous in the original text into one larger fragment with the correct order.
	   * This will leave a "null" in the array entry for the lesser scored fragment.
	   *
	   * @param frag An array of document fragments in descending score
	   */
	  private void mergeContiguousFragments(PositionFragment[] frag)
	  {
	    boolean mergingStillBeingDone;
	    if (frag.length > 1)
	      do
	      {
	        mergingStillBeingDone = false; //initialise loop control flag
	        //for each fragment, scan other frags looking for contiguous blocks
	        for (int i = 0; i < frag.length; i++)
	        {
	          if (frag[i] == null)
	          {
	            continue;
	          }
	          //merge any contiguous blocks
	          for (int x = 0; x < frag.length; x++)
	          {
	            if (frag[x] == null)
	            {
	              continue;
	            }
	            if (frag[i] == null)
	            {
	              break;
	            }
	            PositionFragment frag1 = null;
	            PositionFragment frag2 = null;
	            int frag1Num = 0;
	            int frag2Num = 0;
	            int bestScoringFragNum;
	            int worstScoringFragNum;
	            //if blocks are contiguous....
	            if (frag[i].follows(frag[x]))
	            {
	              frag1 = frag[x];
	              frag1Num = x;
	              frag2 = frag[i];
	              frag2Num = i;
	            }
	            else
	              if (frag[x].follows(frag[i]))
	              {
	                frag1 = frag[i];
	                frag1Num = i;
	                frag2 = frag[x];
	                frag2Num = x;
	              }
	            //merging required..
	            if (frag1 != null)
	            {
	              if (frag1.getScore() > frag2.getScore())
	              {
	                bestScoringFragNum = frag1Num;
	                worstScoringFragNum = frag2Num;
	              }
	              else
	              {
	                bestScoringFragNum = frag2Num;
	                worstScoringFragNum = frag1Num;
	              }
	              frag1.merge(frag2);
	              frag[worstScoringFragNum] = null;
	              mergingStillBeingDone = true;
	              frag[bestScoringFragNum] = frag1;
	            }
	          }
	        }
	      }
	      while (mergingStillBeingDone);
	  }


}
class FragmentQueue extends PriorityQueue<PositionFragment>
{
  public FragmentQueue(int size)
  {
    super(size);
  }

  @Override
  public final boolean lessThan(PositionFragment fragA, PositionFragment fragB)
  {
    if (fragA.getScore() == fragB.getScore())
      return fragA.fragNum > fragB.fragNum;
    else
      return fragA.getScore() < fragB.getScore();
  }
}

