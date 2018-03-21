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
package org.gecko.search.result.lucene.query.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.index.Term;
import org.apache.lucene.queries.function.ValueSource;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.MatchAllDocsQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.apache.lucene.search.SortField.Type;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.spatial.query.SpatialArgs;
import org.apache.lucene.spatial.query.SpatialOperation;
import org.apache.lucene.spatial.vector.PointVectorStrategy;
import org.gecko.search.result.lucene.helper.QueryHelper;
import org.gecko.search.result.lucene.query.ILuceneQueryProvider;
import org.gecko.search.result.lucene.query.switches.QuerySwitch;
import org.gecko.searchresult.FilterField;
import org.gecko.searchresult.QueryObject;
import org.gecko.searchresult.SortDirectionType;
import org.gecko.searchresult.SpatialFilterField;
import org.gecko.searchresult.SpatialSortField;
import org.locationtech.spatial4j.context.SpatialContext;
import org.locationtech.spatial4j.context.SpatialContextFactory;
import org.locationtech.spatial4j.distance.DistanceUtils;
import org.locationtech.spatial4j.shape.Circle;
import org.locationtech.spatial4j.shape.Point;
import org.locationtech.spatial4j.shape.impl.ShapeFactoryImpl;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementation of {@link ILuceneQueryProvider}, that produces the corresponding queries
 * @author Mark Hoffmann
 * @since 10.08.2014
 */
@Component(property = {"type=DEFAULT"}, factory = "defaultQueryProvider")
public class LuceneQueryProvider implements ILuceneQueryProvider {

	private static final Logger LOG = LoggerFactory.getLogger(LuceneQueryProvider.class);

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.result.lucene.query.IQueryProvider#createQuery(de.dim.searchresult.QueryObject)
	 */
	@Override
	public Query createQuery(QueryObject queryObject) {
		return createQuery(queryObject, null);
	}

	/* (non-Javadoc)
	 * @see de.dim.search.result.lucene.query.ILuceneQueryProvider#createQuery(de.dim.searchresult.QueryObject, org.apache.lucene.analysis.Analyzer)
	 */
	@Override
	public Query createQuery(QueryObject queryObject, Analyzer analyzer) {


		if(queryObject.getCondition() != null){
			QuerySwitch querySwitch = new QuerySwitch(analyzer);
			Query query = querySwitch.doSwitch(queryObject.getCondition());
			if(queryObject.isExplain()){
				LOG.info("Query: [{}]", query.toString());
			}
			return query;
		} else if(queryObject.getNativeQuery() != null){
			BooleanQuery.Builder queryBuilder = new BooleanQuery.Builder();
			Query nativeQuery = QueryHelper.getFromNativQuery(queryObject.getNativeQuery(), analyzer);
			queryBuilder.add(nativeQuery, getLuceneOccur(queryObject.getNativeQueryOccur()));
			return queryBuilder.build();
		} else {
			return new MatchAllDocsQuery();
		}

	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.result.lucene.query.IQueryProvider#createFilter(de.dim.searchresult.QueryObject)
	 */
	@Override
	public Query createFilter(QueryObject query) {
		return createFilter(query.getFilterFields(), query.getSpatialFilterField());
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.result.lucene.query.ILuceneQueryProvider#createFilter(java.util.List)
	 */
	@Override
	public Query createFilter(List<FilterField> filterFields) {
		return createFilter(filterFields, null);
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.result.lucene.query.ILuceneQueryProvider#createSort(de.dim.searchresult.QueryObject)
	 */
	@Override
	public Sort createSort(QueryObject queryObject) {
		return createSort(queryObject.getSortFields());
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.result.lucene.query.ILuceneQueryProvider#createSort(java.util.List)
	 */
	@Override
	public Sort createSort(List<org.gecko.searchresult.SortField> sortFields) {
		if (sortFields == null || sortFields.size() == 0) {
			return null;
		}
		List<SortField> luceneSortFields = new ArrayList<SortField>(sortFields.size());
		for (org.gecko.searchresult.SortField  qsf : sortFields) {
			if(qsf instanceof SpatialSortField){
				SpatialSortField ssf = (SpatialSortField) qsf;
				PointVectorStrategy strategy = PointVectorStrategy.newInstance(SpatialContext.GEO, qsf.getKey());
				ShapeFactoryImpl sf = new ShapeFactoryImpl(SpatialContext.GEO, new SpatialContextFactory());
				Point point = sf.pointXY(ssf.getLatLng().getLongitude(), ssf.getLatLng().getLatitude());
				ValueSource valueSource = strategy.makeDistanceValueSource(point, DistanceUtils.DEG_TO_KM);
				SortField spatialSortField = valueSource.getSortField(ssf.getDirection() == SortDirectionType.DESCENDING);
				luceneSortFields.add(spatialSortField);
			} else {
				Type type = null;
				switch (qsf.getType()) {
				case CUSTOM:
					type = Type.CUSTOM;
					break;
				case DOC:
					type = Type.DOC;
					break;
				case DOUBLE:
					type = Type.DOUBLE;
					break;
				case FLOAT:
					type = Type.FLOAT;
					break;
				case INT:
					type = Type.INT;
					break;
				case LONG:
					type = Type.LONG;
					break;
				case REWRITABLE:
					type = Type.REWRITEABLE;
					break;
				case SCORE:
					type = Type.SCORE;
					break;
				case STRING_VAL:
					type = Type.STRING_VAL;
					break;
				default:
					type = Type.STRING;
				}
				SortField sf = new SortField(qsf.getKey(), type, qsf.getDirection().equals(SortDirectionType.DESCENDING));
				luceneSortFields.add(sf);
			}

		}
		Sort sort = new Sort(luceneSortFields.toArray(new SortField[luceneSortFields.size()]));
		return sort;
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
	 * Creates the filter from a list of filter fields
	 * @param filterFields
	 * @param spatialFilterField
	 * @return The Lucene filter {@link Query}
	 */
	private Query createFilter(List<FilterField> filterFields, SpatialFilterField spatialFilterField) {
		Query spatialFilter = null;
		if(spatialFilterField != null){
			spatialFilter = createSpatialFilter(spatialFilterField);
		}

		if (filterFields.size() == 0) {
			return spatialFilter;
		}
		// we have one filter with one token
		//		if (filterFields.size() == 1 && 
		//				filterFields.get(0).getTokens().size() == 1) {
		//			FilterField ff = filterFields.get(0);
		//			FieldCacheTermsFilter termsFilter = new FieldCacheTermsFilter(ff.getKey(), ff.getTokens().get(0));
		//			if(spatialFilter != null){
		//			  BooleanQuery.Builder sq = new BooleanQuery.Builder();
		//				sq.add(spatialFilter, Occur.MUST);
		//				sq.add(termsFilter, getLuceneOccur(filterFields.get(0).getOccur()));
		//				return sq.build();
		//			}
		//			return termsFilter;
		//		}
		BooleanQuery.Builder filter = new BooleanQuery.Builder();
		for (FilterField ff : filterFields) {
			BooleanQuery.Builder fieldFilter = new BooleanQuery.Builder();
			for (String value : ff.getTokens()) {
				if (value == null) {
					continue;
				}
				fieldFilter.add(new TermQuery(new Term(ff.getKey(), value)), getLuceneOccur(ff.getTokensOccur()));
			}
			filter.add(fieldFilter.build(), getLuceneOccur(ff.getOccur()));
		}
		if(spatialFilter != null) {
			filter.add(spatialFilter, Occur.MUST);
		}
		return filter.build();
	}

	/**
	 * Creates a spatial filter
	 * @param spatialFilterField the filter field
	 * @return the spatial filter
	 */
	private Query createSpatialFilter(SpatialFilterField spatialFilterField) {
		Query spatialFilter;
		ShapeFactoryImpl sf = new ShapeFactoryImpl(SpatialContext.GEO, new SpatialContextFactory());
		Circle point = sf.circle(spatialFilterField.getLatLng().getLongitude(), spatialFilterField.getLatLng().getLatitude() , DistanceUtils.dist2Degrees(spatialFilterField.getDistance(), DistanceUtils.EARTH_MEAN_RADIUS_KM));
		SpatialArgs args = new SpatialArgs(SpatialOperation.Intersects, point);
		PointVectorStrategy strategy = PointVectorStrategy.newInstance(SpatialContext.GEO, spatialFilterField.getKey());
		spatialFilter = strategy.makeQuery(args);
		return spatialFilter;
	}

}
