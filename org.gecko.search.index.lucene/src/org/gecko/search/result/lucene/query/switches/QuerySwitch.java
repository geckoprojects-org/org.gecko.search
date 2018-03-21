/**
 * 
 */
package org.gecko.search.result.lucene.query.switches;

import java.util.LinkedList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.TermToBytesRefAttribute;
import org.apache.lucene.document.DoublePoint;
import org.apache.lucene.document.LatLonPoint;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.BoostQuery;
import org.apache.lucene.search.FuzzyQuery;
import org.apache.lucene.search.MultiTermQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.WildcardQuery;
import org.apache.lucene.search.spans.SpanFirstQuery;
import org.apache.lucene.search.spans.SpanMultiTermQueryWrapper;
import org.apache.lucene.search.spans.SpanNearQuery;
import org.apache.lucene.search.spans.SpanQuery;
import org.apache.lucene.search.spans.SpanTermQuery;
import org.apache.lucene.util.BytesRef;
import org.gecko.searchresult.BooleanClause;
import org.gecko.searchresult.BooleanQuery;
import org.gecko.searchresult.BoostableField;
import org.gecko.searchresult.DoubleRangeQuery;
import org.gecko.searchresult.LuceneQueryField;
import org.gecko.searchresult.MultiPhraseQuery;
import org.gecko.searchresult.MultiTokenFuzzyField;
import org.gecko.searchresult.MultiTokenTermQuery;
import org.gecko.searchresult.PhraseQuery;
import org.gecko.searchresult.SearchResultPackage;
import org.gecko.searchresult.SingleTokenFuzzyField;
import org.gecko.searchresult.SingleTokenTermQuery;
import org.gecko.searchresult.SpanQueryField;
import org.gecko.searchresult.SpanTermField;
import org.gecko.searchresult.SpatialField;
import org.gecko.searchresult.WildcardField;
import org.gecko.searchresult.util.SearchResultSwitch;

/**
 * @author Juergen Albert
 *
 */
public class QuerySwitch extends SearchResultSwitch<Query> {

	//The first case called will store its query here. It might be used for a spatial query, to create a CustomScoreQuery
	private Query mainQuery = null;
	private Analyzer analyzer;
	private Boolean second = false;
	
	public QuerySwitch(Analyzer analyzer) {
		this.analyzer = analyzer;
	}

	/* (non-Javadoc)
	 * @see de.dim.searchresult.util.SearchResultSwitch#caseBooleanQuery(de.dim.searchresult.BooleanQuery)
	 */
	@Override
	public Query caseBooleanQuery(BooleanQuery object) {
		boolean first = !second;
		if(first) {
			second = true;
		}
		org.apache.lucene.search.BooleanQuery.Builder bqBuilder = new org.apache.lucene.search.BooleanQuery.Builder();
		for (BooleanClause clause : object.getClauses()) {
			if(clause.getQuery() instanceof BoostableField){
				Query q = doSwitch(clause.getQuery());
				if(q != null){
					bqBuilder.add(q, getLuceneOccur(clause.getOccur()));
				}
			}
		}
		Query bq = bqBuilder.build();
		setMainQuery(bq, first);
		if(first){
			return mainQuery;
		}
		return bq;
	}

	/**
	 * Sets the mainQuery if it is not already set
	 * @param query the {@link Query} to set
	 */
	private void setMainQuery(org.apache.lucene.search.Query query, boolean force) {
		if(mainQuery == null && force){
			mainQuery = query;
		}
	}



	/* (non-Javadoc)
	 * @see de.dim.searchresult.util.SearchResultSwitch#caseMultiTokenTermQuery(de.dim.searchresult.MultiTokenTermQuery)
	 */
	@Override
	public Query caseMultiTokenTermQuery(MultiTokenTermQuery field) {
		boolean first = !second;
		if(first) {
			second = true;
		}
		org.apache.lucene.search.BooleanQuery.Builder bqBuilder = new org.apache.lucene.search.BooleanQuery.Builder();
		Occur occur = getLuceneOccur(field.getTokensOccur());
		int numberTerms = 0;
		for (String token : field.getTokens()) {
			if (token == null) {
				continue;
			}
			List<Term> terms = createTerms(token, field);
			if(terms.isEmpty()){
				continue;
			} else if(terms.size() == 1){
				TermQuery tq = new TermQuery(terms.get(0));
				bqBuilder.add(tq, occur);
				numberTerms++;
			} else {
				org.apache.lucene.search.BooleanQuery.Builder multiTokenTerm = new org.apache.lucene.search.BooleanQuery.Builder(); 
				for(Term term : createTerms(token, field)){
					TermQuery tq = new TermQuery(term);
					multiTokenTerm.add(tq, Occur.MUST);
				}
				bqBuilder.add(multiTokenTerm.build(), occur);
				numberTerms++;
			}
		}
		if(numberTerms <= 0) {
			return null;
		}
		Query booleanQuery = bqBuilder.build();
		if(field.eIsSet(SearchResultPackage.Literals.BOOSTABLE_FIELD__BOOST)){
			booleanQuery = createBoostQuery(booleanQuery, field.getBoost());
		}
		setMainQuery(booleanQuery, first);
		return booleanQuery;
	}
	
	/* (non-Javadoc)
	 * @see de.dim.searchresult.util.SearchResultSwitch#casePhraseQuery(de.dim.searchresult.PhraseQuery)
	 */
	@Override
	public Query casePhraseQuery(PhraseQuery query) {
		boolean first = !second;
		if(first) {
			second = true;
		}
		List<Term> terms = new LinkedList<Term>();
		query.getTerms().forEach((t) -> terms.addAll(createTerms(t, query)));
		org.apache.lucene.search.PhraseQuery.Builder phraseBuilder = new org.apache.lucene.search.PhraseQuery.Builder();
		phraseBuilder.setSlop(query.getSlop());
		terms.forEach((t) -> phraseBuilder.add(t));
		org.apache.lucene.search.PhraseQuery phraseQuery = phraseBuilder.build();
		setMainQuery(phraseQuery, first);
		return phraseQuery;
	}
	
	@Override
	public Query caseMultiPhraseQuery(MultiPhraseQuery query) {
		boolean first = !second;
		if(first) {
			second = true;
		}
		List<Term> terms = new LinkedList<Term>();
		query.getTerms().forEach((t) -> terms.addAll(createTerms(t, query)));
		org.apache.lucene.search.MultiPhraseQuery.Builder phraseBuilder = new org.apache.lucene.search.MultiPhraseQuery.Builder();
		phraseBuilder.setSlop(query.getSlop());
		terms.forEach((t) -> phraseBuilder.add(t));
		org.apache.lucene.search.MultiPhraseQuery phraseQuery = phraseBuilder.build();
		setMainQuery(phraseQuery, first);
		return phraseQuery;
	}

	/* (non-Javadoc)
	 * @see de.dim.searchresult.util.SearchResultSwitch#caseSingleTokenTermQuery(de.dim.searchresult.SingleTokenTermQuery)
	 */
	@Override
	public Query caseSingleTokenTermQuery(SingleTokenTermQuery query) {
		boolean first = !second;
		if(first) {
			second = true;
		}
		List<Term> terms = createTerms(query.getToken(), query);
		Query q = null;
		if(terms.isEmpty()){
			return null;
		} else if (terms.size() == 1){
			q = new TermQuery(terms.get(0));
		} else {
			org.apache.lucene.search.BooleanQuery.Builder bqBuilder = new org.apache.lucene.search.BooleanQuery.Builder();
			for(Term term : terms){
				TermQuery tq = new TermQuery(term);
				bqBuilder.add(tq, Occur.MUST);
			}
			q = bqBuilder.build();
		}
		if(query.eIsSet(SearchResultPackage.Literals.BOOSTABLE_FIELD__BOOST)){
			q = createBoostQuery(q, query.getBoost());
		}
		setMainQuery(q, first);
		return q;
	}

	/**
	 * Creates a Term for the given field and analyses it if necessary 
	 * @param term the Terms {@link String}
	 * @param field the {@link LuceneQueryField} to create it for
	 * @return the {@link Term}
	 */
	private List<Term> createTerms(final String term, final LuceneQueryField field){
		List<Term> terms = new LinkedList<Term>();
		if(field.isAnalyzed()){
			try{
				TokenStream tokenStream = analyzer.tokenStream(field.getKey(), term);
				try{
					//Reset it first, because else it would not work 
					final TermToBytesRefAttribute termAtt = tokenStream.getAttribute(TermToBytesRefAttribute.class);
					BytesRef bytes;
					tokenStream.reset();
					while(tokenStream.incrementToken()){
						// you must call termAtt.fillBytesRef() before doing something with the bytes.
						// this encodes the term value (internally it might be a char[], etc) into the bytes
//						termAtt.fillBytesRef();
						bytes = termAtt.getBytesRef();
						BytesRef newByteRef = BytesRef.deepCopyOf(bytes);

						terms.add(new Term(field.getKey(),newByteRef));
					} 
					tokenStream.end();
				} finally {
					tokenStream.close();
				}
			} catch (Exception e ){
				throw new RuntimeException(e);
			}
		} else {
			terms.add(new Term(field.getKey(), new BytesRef(term)));
		}
		return terms;
	}

	/* (non-Javadoc)
	 * @see de.dim.searchresult.util.SearchResultSwitch#caseSingleTokenFuzzyField(de.dim.searchresult.SingleTokenFuzzyField)
	 */
	@Override
	public Query caseSingleTokenFuzzyField(SingleTokenFuzzyField query) {
		boolean first = !second;
		if(first) {
			second = true;
		}
		List<Term> terms = createTerms(query.getToken(), query);
		Query q = null;
		if(terms.isEmpty()){
			return null;
		} else if (terms.size() == 1){
			q = new FuzzyQuery(terms.get(0), query.getMaxEdits());
		} else {
			org.apache.lucene.search.BooleanQuery.Builder bqBuilder = new org.apache.lucene.search.BooleanQuery.Builder();
			for(Term term : terms){
				FuzzyQuery tq = new FuzzyQuery(term, query.getMaxEdits());
				bqBuilder.add(tq, Occur.MUST);
			}
			q = bqBuilder.build();
		}
		if(query.eIsSet(SearchResultPackage.Literals.BOOSTABLE_FIELD__BOOST)){
			q = createBoostQuery(q, query.getBoost());
		}
		setMainQuery(q, first);
		return q;
	}

	/* (non-Javadoc)
	 * @see de.dim.searchresult.util.SearchResultSwitch#caseMultiTokenFuzzyField(de.dim.searchresult.MultiTokenFuzzyField)
	 */
	@Override
	public Query caseMultiTokenFuzzyField(MultiTokenFuzzyField field) {
		boolean first = !second;
		if(first) {
			second = true;
		}
		org.apache.lucene.search.BooleanQuery.Builder bqBuilder = new org.apache.lucene.search.BooleanQuery.Builder();
		Occur occur = getLuceneOccur(field.getTokensOccur());
		for (String token : field.getTokens()) {
			if (token == null) {
				continue;
			}
			List<Term> terms = createTerms(token, field);
			if(terms.isEmpty()){
				continue;
			} else if(terms.size() == 1){
				FuzzyQuery tq = new FuzzyQuery(terms.get(0), field.getMaxEdits());
				bqBuilder.add(tq, occur);
			} else {
				org.apache.lucene.search.BooleanQuery.Builder multiTokenTerm = new org.apache.lucene.search.BooleanQuery.Builder(); 
				for(Term term : createTerms(token, field)){
					FuzzyQuery tq = new FuzzyQuery(term, field.getMaxEdits());
					multiTokenTerm.add(tq, Occur.MUST);
				}
				bqBuilder.add(multiTokenTerm.build(), occur);
			}
		}
		Query booleanQuery = bqBuilder.build();
		if(field.eIsSet(SearchResultPackage.Literals.BOOSTABLE_FIELD__BOOST)){
			booleanQuery = createBoostQuery(booleanQuery, field.getBoost());
		}
		setMainQuery(booleanQuery, first);
		return booleanQuery;
	}

	/* (non-Javadoc)
	 * @see de.dim.searchresult.util.SearchResultSwitch#caseSpanTermField(de.dim.searchresult.SpanTermField)
	 */
	@Override
	public Query caseSpanTermField(SpanTermField f) {
		boolean first = !second;
		if(first) {
			second = true;
		}
		LinkedList<SpanTermQuery> spanTermQueriesList = new LinkedList<>();
		for (String token : f.getTokens()) {
			List<Term> terms = createTerms(token.toLowerCase(), f);
			for(Term term : terms){
				spanTermQueriesList.add(new SpanTermQuery(term));
			}
		}
		SpanNearQuery spanNearQuery = new SpanNearQuery(spanTermQueriesList.toArray(new SpanTermQuery[0]), 2, true);
		Query spanFirstQuery = new SpanFirstQuery(spanNearQuery, f.getSpan() != Integer.MAX_VALUE ?  f.getSpan() * f.getTokens().size() : f.getSpan());
		if(f.eIsSet(SearchResultPackage.Literals.BOOSTABLE_FIELD__BOOST)){
			spanFirstQuery = createBoostQuery(spanFirstQuery, f.getBoost());
		}
		setMainQuery(spanFirstQuery, first);
		return spanFirstQuery;
	}

	@Override
	public Query caseSpanQueryField(SpanQueryField f) {
		boolean first = !second;
		if(first) {
			second = true;
		}
		LinkedList<SpanQuery> spanTermQueriesList = new LinkedList<>();
		for (LuceneQueryField queryField : f.getQueryFields()) {
			org.apache.lucene.search.Query q = this.doSwitch(queryField);
			if(q != null){
				if(q instanceof MultiTermQuery){
					SpanMultiTermQueryWrapper<MultiTermQuery> wrapper = new SpanMultiTermQueryWrapper<MultiTermQuery>((MultiTermQuery) q);
					spanTermQueriesList.add(wrapper);
				} else if(q instanceof org.apache.lucene.search.TermQuery){
					spanTermQueriesList.add(new SpanTermQuery(((org.apache.lucene.search.TermQuery) q).getTerm()));
					
				} else if(q instanceof org.apache.lucene.search.BooleanQuery){
					org.apache.lucene.search.BooleanQuery bq = (org.apache.lucene.search.BooleanQuery)q;
					for (org.apache.lucene.search.BooleanClause booleanClause : bq.clauses()) {
						if(booleanClause.getQuery() instanceof MultiTermQuery) {
							SpanMultiTermQueryWrapper<MultiTermQuery> wrapper = new SpanMultiTermQueryWrapper<MultiTermQuery>((MultiTermQuery) booleanClause.getQuery());
							spanTermQueriesList.add(wrapper);
						} else if(booleanClause.getQuery() instanceof TermQuery) {
							spanTermQueriesList.add(new SpanTermQuery(((org.apache.lucene.search.TermQuery) booleanClause.getQuery()).getTerm()));
						}
					}
				} else {
					throw new IllegalArgumentException(q.getClass().getName() + " is no " + MultiTermQuery.class.getName() + " and can not be used in a SpanQueryField");
				}
			}
		}if(spanTermQueriesList.size() < 2) {
			return null;
		}
		SpanNearQuery spanNearQuery = new SpanNearQuery(spanTermQueriesList.toArray(new SpanQuery[0]), 2, true);
		Query spanFirstQuery = new SpanFirstQuery(spanNearQuery, f.getSpan() != Integer.MAX_VALUE ?  f.getSpan() * f.getQueryFields().size() : f.getSpan());
		if(f.eIsSet(SearchResultPackage.Literals.BOOSTABLE_FIELD__BOOST)){
			spanFirstQuery = createBoostQuery(spanFirstQuery, f.getBoost());
		}
		setMainQuery(spanFirstQuery, first);
		return spanFirstQuery;
	}

	/* (non-Javadoc)
	 * @see de.dim.searchresult.util.SearchResultSwitch#caseSpatialField(de.dim.searchresult.SpatialField)
	 */
	@Override
	public Query caseSpatialField(SpatialField spatialField) {
		
		boolean first = !second;
		if(first) {
			second = true;
		}
		
		Query newDistanceQuery = LatLonPoint.newDistanceQuery(spatialField.getKey(), spatialField.getLatLng().getLatitude(), spatialField.getLatLng().getLongitude(), spatialField.getDistance() * 1000);
		return newDistanceQuery;
//		ShapeFactoryImpl sf = new ShapeFactoryImpl(SpatialContext.GEO, new SpatialContextFactory());
//		Circle point = sf.circle(spatialField.getLatLng().getLongitude(), spatialField.getLatLng().getLatitude() , DistanceUtils.dist2Degrees(spatialField.getDistance(), DistanceUtils.EARTH_MEAN_RADIUS_KM));
//		PointVectorStrategy strategy = PointVectorStrategy.newInstance(SpatialContext.GEO, spatialField.getKey());
//		ValueSource distValueSource = strategy.makeRecipDistanceValueSource(point);
//		Query spatialScoreQuery = new FunctionQuery(distValueSource);
//		if(spatialField.eIsSet(SearchResultPackage.Literals.BOOSTABLE_FIELD__BOOST)){
//			spatialScoreQuery = createBoostQuery(spatialScoreQuery, spatialField.getBoost());
//		}
//		if(mainQuery == null){
//			setMainQuery(spatialScoreQuery, true);
//			return spatialScoreQuery;
//		}
//		CustomScoreQuery csq = new CustomScoreQuery(mainQuery, (FunctionQuery) spatialScoreQuery);
//		mainQuery = csq;
//		return null;
	}

	/* (non-Javadoc)
	 * @see de.dim.searchresult.util.SearchResultSwitch#caseDoubleRangeQuery(de.dim.searchresult.DoubleRangeQuery)
	 */
	@Override
	public Query caseDoubleRangeQuery(DoubleRangeQuery query) {
		double minValue = query.getMinValue();
		double maxValue = query.getMaxValue();
		if (!query.isMinInclusive()) {
			minValue = Math.nextUp(minValue);
		}
		if (!query.isMaxInclusive()) {
			maxValue = Math.nextDown(maxValue);
		}
		Query rangeQuery = DoublePoint.newRangeQuery(query.getKey(), query.getMinValue(), query.getMaxValue());
		return rangeQuery;
	}

	/* (non-Javadoc)
	 * @see de.dim.searchresult.util.SearchResultSwitch#caseWildcardField(de.dim.searchresult.WildcardField)
	 */
	@Override
	public Query caseWildcardField(WildcardField field) {
		boolean first = !second;
		if(first) {
			second = true;
		}
		List<Term> terms = new LinkedList<>();
		for(String token : field.getTokens()){
			terms.addAll(createTerms(token, field));
		}
		if(terms.isEmpty()) {
			return null;
		}
		
		org.apache.lucene.search.BooleanQuery.Builder bqBuilder = new org.apache.lucene.search.BooleanQuery.Builder();
		for (Term string : terms) {
			if (string == null) {
				continue;
			}
			WildcardQuery fq = new WildcardQuery(new Term(field.getKey() , (field.isStartWithWildcard() ? "*" : "") + Term.toString(string.bytes()) + (field.isEndWithWildcard() ? "*" : "")));
			bqBuilder.add(fq, getLuceneOccur(field.getTokensOccur()));

		}
		Query booleanQuery = bqBuilder.build();
		setMainQuery(booleanQuery, first);
		return booleanQuery;
	}

	/**
	 * Switches the model {@link de.dim.searchresult.Occur} to the corresponding lucene {@link Occur}
	 * @param occur the {@link de.dim.searchresult.Occur} from the model
	 * @return the corresponding {@link Occur} of lucene
	 */
	private Occur getLuceneOccur(org.gecko.searchresult.Occur occur) {
		switch (occur.getValue()){
		case org.gecko.searchresult.Occur.SHOULD_VALUE:
			return Occur.SHOULD;
		case org.gecko.searchresult.Occur.MUST_VALUE:
			return Occur.MUST;
		default:
			return Occur.MUST_NOT;
		}
	}

	/**
	 * Creates a boost query
	 * @param query the query to be boosted
	 * @param boost the boost
	 * @return the {@link BoostQuery} instance
	 */
	private Query createBoostQuery(Query query, float boost) {
		if (query == null) {
			return null;
		}
		return new BoostQuery(query, boost);
	}

}
