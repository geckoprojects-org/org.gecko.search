/**
 * Copyright (c) 2012 - 2018 Data In Motion and others.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *     Data In Motion - initial API and implementation
 */
package org.gecko.searchresult.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.gecko.searchresult.FacetQueryContext;
import org.gecko.searchresult.FilterField;
import org.gecko.searchresult.GroupingContext;
import org.gecko.searchresult.JoinQuery;
import org.gecko.searchresult.LikeThisObject;
import org.gecko.searchresult.Occur;
import org.gecko.searchresult.QueryObject;
import org.gecko.searchresult.SearchResultPackage;
import org.gecko.searchresult.SortField;
import org.gecko.searchresult.SpatialFilterField;

import org.gecko.utilities.query.impl.QueryImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Query Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchresult.impl.QueryObjectImpl#getNativeQuery <em>Native Query</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.QueryObjectImpl#getIndexPath <em>Index Path</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.QueryObjectImpl#getMaxResults <em>Max Results</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.QueryObjectImpl#getFilterFields <em>Filter Fields</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.QueryObjectImpl#getSortFields <em>Sort Fields</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.QueryObjectImpl#getNativeObject <em>Native Object</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.QueryObjectImpl#getSpatialFilterField <em>Spatial Filter Field</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.QueryObjectImpl#getHighlightFields <em>Highlight Fields</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.QueryObjectImpl#getLikeThisObject <em>Like This Object</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.QueryObjectImpl#getAnalyzerId <em>Analyzer Id</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.QueryObjectImpl#getFacetQueryContext <em>Facet Query Context</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.QueryObjectImpl#getNativeCollectors <em>Native Collectors</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.QueryObjectImpl#isRunCollectorExclusive <em>Run Collector Exclusive</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.QueryObjectImpl#getJoinQuery <em>Join Query</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.QueryObjectImpl#getGroupingContext <em>Grouping Context</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.QueryObjectImpl#getNativeQueryOccur <em>Native Query Occur</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.QueryObjectImpl#isExplain <em>Explain</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.QueryObjectImpl#getPageIndex <em>Page Index</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.QueryObjectImpl#getPageResultSize <em>Page Result Size</em>}</li>
 * </ul>
 *
 * @generated
 */
public class QueryObjectImpl extends QueryImpl implements QueryObject {
	/**
	 * The default value of the '{@link #getNativeQuery() <em>Native Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNativeQuery()
	 * @generated
	 * @ordered
	 */
	protected static final Object NATIVE_QUERY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNativeQuery() <em>Native Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNativeQuery()
	 * @generated
	 * @ordered
	 */
	protected Object nativeQuery = NATIVE_QUERY_EDEFAULT;

	/**
	 * The default value of the '{@link #getIndexPath() <em>Index Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexPath()
	 * @generated
	 * @ordered
	 */
	protected static final String INDEX_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIndexPath() <em>Index Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexPath()
	 * @generated
	 * @ordered
	 */
	protected String indexPath = INDEX_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxResults() <em>Max Results</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxResults()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_RESULTS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxResults() <em>Max Results</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxResults()
	 * @generated
	 * @ordered
	 */
	protected int maxResults = MAX_RESULTS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFilterFields() <em>Filter Fields</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilterFields()
	 * @generated
	 * @ordered
	 */
	protected EList<FilterField> filterFields;

	/**
	 * The cached value of the '{@link #getSortFields() <em>Sort Fields</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSortFields()
	 * @generated
	 * @ordered
	 */
	protected EList<SortField> sortFields;

	/**
	 * The default value of the '{@link #getNativeObject() <em>Native Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNativeObject()
	 * @generated
	 * @ordered
	 */
	protected static final Object NATIVE_OBJECT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNativeObject() <em>Native Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNativeObject()
	 * @generated
	 * @ordered
	 */
	protected Object nativeObject = NATIVE_OBJECT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSpatialFilterField() <em>Spatial Filter Field</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpatialFilterField()
	 * @generated
	 * @ordered
	 */
	protected SpatialFilterField spatialFilterField;

	/**
	 * The cached value of the '{@link #getHighlightFields() <em>Highlight Fields</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHighlightFields()
	 * @generated
	 * @ordered
	 */
	protected EList<String> highlightFields;

	/**
	 * The cached value of the '{@link #getLikeThisObject() <em>Like This Object</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLikeThisObject()
	 * @generated
	 * @ordered
	 */
	protected LikeThisObject likeThisObject;

	/**
	 * The default value of the '{@link #getAnalyzerId() <em>Analyzer Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnalyzerId()
	 * @generated
	 * @ordered
	 */
	protected static final String ANALYZER_ID_EDEFAULT = "default";

	/**
	 * The cached value of the '{@link #getAnalyzerId() <em>Analyzer Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnalyzerId()
	 * @generated
	 * @ordered
	 */
	protected String analyzerId = ANALYZER_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFacetQueryContext() <em>Facet Query Context</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacetQueryContext()
	 * @generated
	 * @ordered
	 */
	protected FacetQueryContext facetQueryContext;

	/**
	 * The cached value of the '{@link #getNativeCollectors() <em>Native Collectors</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNativeCollectors()
	 * @generated
	 * @ordered
	 */
	protected EList<Object> nativeCollectors;

	/**
	 * The default value of the '{@link #isRunCollectorExclusive() <em>Run Collector Exclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRunCollectorExclusive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RUN_COLLECTOR_EXCLUSIVE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isRunCollectorExclusive() <em>Run Collector Exclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRunCollectorExclusive()
	 * @generated
	 * @ordered
	 */
	protected boolean runCollectorExclusive = RUN_COLLECTOR_EXCLUSIVE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getJoinQuery() <em>Join Query</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJoinQuery()
	 * @generated
	 * @ordered
	 */
	protected JoinQuery joinQuery;

	/**
	 * The cached value of the '{@link #getGroupingContext() <em>Grouping Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroupingContext()
	 * @generated
	 * @ordered
	 */
	protected GroupingContext groupingContext;

	/**
	 * The default value of the '{@link #getNativeQueryOccur() <em>Native Query Occur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNativeQueryOccur()
	 * @generated
	 * @ordered
	 */
	protected static final Occur NATIVE_QUERY_OCCUR_EDEFAULT = Occur.MUST;

	/**
	 * The cached value of the '{@link #getNativeQueryOccur() <em>Native Query Occur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNativeQueryOccur()
	 * @generated
	 * @ordered
	 */
	protected Occur nativeQueryOccur = NATIVE_QUERY_OCCUR_EDEFAULT;

	/**
	 * The default value of the '{@link #isExplain() <em>Explain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExplain()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXPLAIN_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExplain() <em>Explain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExplain()
	 * @generated
	 * @ordered
	 */
	protected boolean explain = EXPLAIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getPageIndex() <em>Page Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPageIndex()
	 * @generated
	 * @ordered
	 */
	protected static final Integer PAGE_INDEX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPageIndex() <em>Page Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPageIndex()
	 * @generated
	 * @ordered
	 */
	protected Integer pageIndex = PAGE_INDEX_EDEFAULT;

	/**
	 * The default value of the '{@link #getPageResultSize() <em>Page Result Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPageResultSize()
	 * @generated
	 * @ordered
	 */
	protected static final Integer PAGE_RESULT_SIZE_EDEFAULT = new Integer(-1);

	/**
	 * The cached value of the '{@link #getPageResultSize() <em>Page Result Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPageResultSize()
	 * @generated
	 * @ordered
	 */
	protected Integer pageResultSize = PAGE_RESULT_SIZE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QueryObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SearchResultPackage.Literals.QUERY_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getNativeQuery() {
		return nativeQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNativeQuery(Object newNativeQuery) {
		Object oldNativeQuery = nativeQuery;
		nativeQuery = newNativeQuery;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.QUERY_OBJECT__NATIVE_QUERY, oldNativeQuery, nativeQuery));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIndexPath() {
		return indexPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndexPath(String newIndexPath) {
		String oldIndexPath = indexPath;
		indexPath = newIndexPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.QUERY_OBJECT__INDEX_PATH, oldIndexPath, indexPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxResults() {
		return maxResults;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxResults(int newMaxResults) {
		int oldMaxResults = maxResults;
		maxResults = newMaxResults;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.QUERY_OBJECT__MAX_RESULTS, oldMaxResults, maxResults));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FilterField> getFilterFields() {
		if (filterFields == null) {
			filterFields = new EObjectContainmentEList<FilterField>(FilterField.class, this, SearchResultPackage.QUERY_OBJECT__FILTER_FIELDS);
		}
		return filterFields;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SortField> getSortFields() {
		if (sortFields == null) {
			sortFields = new EObjectContainmentEList<SortField>(SortField.class, this, SearchResultPackage.QUERY_OBJECT__SORT_FIELDS);
		}
		return sortFields;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getNativeObject() {
		return nativeObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNativeObject(Object newNativeObject) {
		Object oldNativeObject = nativeObject;
		nativeObject = newNativeObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.QUERY_OBJECT__NATIVE_OBJECT, oldNativeObject, nativeObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpatialFilterField getSpatialFilterField() {
		if (spatialFilterField != null && spatialFilterField.eIsProxy()) {
			InternalEObject oldSpatialFilterField = (InternalEObject)spatialFilterField;
			spatialFilterField = (SpatialFilterField)eResolveProxy(oldSpatialFilterField);
			if (spatialFilterField != oldSpatialFilterField) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SearchResultPackage.QUERY_OBJECT__SPATIAL_FILTER_FIELD, oldSpatialFilterField, spatialFilterField));
			}
		}
		return spatialFilterField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpatialFilterField basicGetSpatialFilterField() {
		return spatialFilterField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpatialFilterField(SpatialFilterField newSpatialFilterField) {
		SpatialFilterField oldSpatialFilterField = spatialFilterField;
		spatialFilterField = newSpatialFilterField;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.QUERY_OBJECT__SPATIAL_FILTER_FIELD, oldSpatialFilterField, spatialFilterField));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getHighlightFields() {
		if (highlightFields == null) {
			highlightFields = new EDataTypeUniqueEList<String>(String.class, this, SearchResultPackage.QUERY_OBJECT__HIGHLIGHT_FIELDS);
		}
		return highlightFields;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LikeThisObject getLikeThisObject() {
		return likeThisObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLikeThisObject(LikeThisObject newLikeThisObject, NotificationChain msgs) {
		LikeThisObject oldLikeThisObject = likeThisObject;
		likeThisObject = newLikeThisObject;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SearchResultPackage.QUERY_OBJECT__LIKE_THIS_OBJECT, oldLikeThisObject, newLikeThisObject);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLikeThisObject(LikeThisObject newLikeThisObject) {
		if (newLikeThisObject != likeThisObject) {
			NotificationChain msgs = null;
			if (likeThisObject != null)
				msgs = ((InternalEObject)likeThisObject).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SearchResultPackage.QUERY_OBJECT__LIKE_THIS_OBJECT, null, msgs);
			if (newLikeThisObject != null)
				msgs = ((InternalEObject)newLikeThisObject).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SearchResultPackage.QUERY_OBJECT__LIKE_THIS_OBJECT, null, msgs);
			msgs = basicSetLikeThisObject(newLikeThisObject, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.QUERY_OBJECT__LIKE_THIS_OBJECT, newLikeThisObject, newLikeThisObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAnalyzerId() {
		return analyzerId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnalyzerId(String newAnalyzerId) {
		String oldAnalyzerId = analyzerId;
		analyzerId = newAnalyzerId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.QUERY_OBJECT__ANALYZER_ID, oldAnalyzerId, analyzerId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FacetQueryContext getFacetQueryContext() {
		return facetQueryContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFacetQueryContext(FacetQueryContext newFacetQueryContext, NotificationChain msgs) {
		FacetQueryContext oldFacetQueryContext = facetQueryContext;
		facetQueryContext = newFacetQueryContext;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SearchResultPackage.QUERY_OBJECT__FACET_QUERY_CONTEXT, oldFacetQueryContext, newFacetQueryContext);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFacetQueryContext(FacetQueryContext newFacetQueryContext) {
		if (newFacetQueryContext != facetQueryContext) {
			NotificationChain msgs = null;
			if (facetQueryContext != null)
				msgs = ((InternalEObject)facetQueryContext).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SearchResultPackage.QUERY_OBJECT__FACET_QUERY_CONTEXT, null, msgs);
			if (newFacetQueryContext != null)
				msgs = ((InternalEObject)newFacetQueryContext).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SearchResultPackage.QUERY_OBJECT__FACET_QUERY_CONTEXT, null, msgs);
			msgs = basicSetFacetQueryContext(newFacetQueryContext, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.QUERY_OBJECT__FACET_QUERY_CONTEXT, newFacetQueryContext, newFacetQueryContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Object> getNativeCollectors() {
		if (nativeCollectors == null) {
			nativeCollectors = new EDataTypeUniqueEList<Object>(Object.class, this, SearchResultPackage.QUERY_OBJECT__NATIVE_COLLECTORS);
		}
		return nativeCollectors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRunCollectorExclusive() {
		return runCollectorExclusive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRunCollectorExclusive(boolean newRunCollectorExclusive) {
		boolean oldRunCollectorExclusive = runCollectorExclusive;
		runCollectorExclusive = newRunCollectorExclusive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.QUERY_OBJECT__RUN_COLLECTOR_EXCLUSIVE, oldRunCollectorExclusive, runCollectorExclusive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JoinQuery getJoinQuery() {
		return joinQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetJoinQuery(JoinQuery newJoinQuery, NotificationChain msgs) {
		JoinQuery oldJoinQuery = joinQuery;
		joinQuery = newJoinQuery;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SearchResultPackage.QUERY_OBJECT__JOIN_QUERY, oldJoinQuery, newJoinQuery);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJoinQuery(JoinQuery newJoinQuery) {
		if (newJoinQuery != joinQuery) {
			NotificationChain msgs = null;
			if (joinQuery != null)
				msgs = ((InternalEObject)joinQuery).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SearchResultPackage.QUERY_OBJECT__JOIN_QUERY, null, msgs);
			if (newJoinQuery != null)
				msgs = ((InternalEObject)newJoinQuery).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SearchResultPackage.QUERY_OBJECT__JOIN_QUERY, null, msgs);
			msgs = basicSetJoinQuery(newJoinQuery, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.QUERY_OBJECT__JOIN_QUERY, newJoinQuery, newJoinQuery));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GroupingContext getGroupingContext() {
		if (groupingContext != null && groupingContext.eIsProxy()) {
			InternalEObject oldGroupingContext = (InternalEObject)groupingContext;
			groupingContext = (GroupingContext)eResolveProxy(oldGroupingContext);
			if (groupingContext != oldGroupingContext) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SearchResultPackage.QUERY_OBJECT__GROUPING_CONTEXT, oldGroupingContext, groupingContext));
			}
		}
		return groupingContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GroupingContext basicGetGroupingContext() {
		return groupingContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGroupingContext(GroupingContext newGroupingContext) {
		GroupingContext oldGroupingContext = groupingContext;
		groupingContext = newGroupingContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.QUERY_OBJECT__GROUPING_CONTEXT, oldGroupingContext, groupingContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Occur getNativeQueryOccur() {
		return nativeQueryOccur;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNativeQueryOccur(Occur newNativeQueryOccur) {
		Occur oldNativeQueryOccur = nativeQueryOccur;
		nativeQueryOccur = newNativeQueryOccur == null ? NATIVE_QUERY_OCCUR_EDEFAULT : newNativeQueryOccur;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.QUERY_OBJECT__NATIVE_QUERY_OCCUR, oldNativeQueryOccur, nativeQueryOccur));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExplain() {
		return explain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExplain(boolean newExplain) {
		boolean oldExplain = explain;
		explain = newExplain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.QUERY_OBJECT__EXPLAIN, oldExplain, explain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getPageIndex() {
		return pageIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPageIndex(Integer newPageIndex) {
		Integer oldPageIndex = pageIndex;
		pageIndex = newPageIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.QUERY_OBJECT__PAGE_INDEX, oldPageIndex, pageIndex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getPageResultSize() {
		return pageResultSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPageResultSize(Integer newPageResultSize) {
		Integer oldPageResultSize = pageResultSize;
		pageResultSize = newPageResultSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.QUERY_OBJECT__PAGE_RESULT_SIZE, oldPageResultSize, pageResultSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SearchResultPackage.QUERY_OBJECT__FILTER_FIELDS:
				return ((InternalEList<?>)getFilterFields()).basicRemove(otherEnd, msgs);
			case SearchResultPackage.QUERY_OBJECT__SORT_FIELDS:
				return ((InternalEList<?>)getSortFields()).basicRemove(otherEnd, msgs);
			case SearchResultPackage.QUERY_OBJECT__LIKE_THIS_OBJECT:
				return basicSetLikeThisObject(null, msgs);
			case SearchResultPackage.QUERY_OBJECT__FACET_QUERY_CONTEXT:
				return basicSetFacetQueryContext(null, msgs);
			case SearchResultPackage.QUERY_OBJECT__JOIN_QUERY:
				return basicSetJoinQuery(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SearchResultPackage.QUERY_OBJECT__NATIVE_QUERY:
				return getNativeQuery();
			case SearchResultPackage.QUERY_OBJECT__INDEX_PATH:
				return getIndexPath();
			case SearchResultPackage.QUERY_OBJECT__MAX_RESULTS:
				return getMaxResults();
			case SearchResultPackage.QUERY_OBJECT__FILTER_FIELDS:
				return getFilterFields();
			case SearchResultPackage.QUERY_OBJECT__SORT_FIELDS:
				return getSortFields();
			case SearchResultPackage.QUERY_OBJECT__NATIVE_OBJECT:
				return getNativeObject();
			case SearchResultPackage.QUERY_OBJECT__SPATIAL_FILTER_FIELD:
				if (resolve) return getSpatialFilterField();
				return basicGetSpatialFilterField();
			case SearchResultPackage.QUERY_OBJECT__HIGHLIGHT_FIELDS:
				return getHighlightFields();
			case SearchResultPackage.QUERY_OBJECT__LIKE_THIS_OBJECT:
				return getLikeThisObject();
			case SearchResultPackage.QUERY_OBJECT__ANALYZER_ID:
				return getAnalyzerId();
			case SearchResultPackage.QUERY_OBJECT__FACET_QUERY_CONTEXT:
				return getFacetQueryContext();
			case SearchResultPackage.QUERY_OBJECT__NATIVE_COLLECTORS:
				return getNativeCollectors();
			case SearchResultPackage.QUERY_OBJECT__RUN_COLLECTOR_EXCLUSIVE:
				return isRunCollectorExclusive();
			case SearchResultPackage.QUERY_OBJECT__JOIN_QUERY:
				return getJoinQuery();
			case SearchResultPackage.QUERY_OBJECT__GROUPING_CONTEXT:
				if (resolve) return getGroupingContext();
				return basicGetGroupingContext();
			case SearchResultPackage.QUERY_OBJECT__NATIVE_QUERY_OCCUR:
				return getNativeQueryOccur();
			case SearchResultPackage.QUERY_OBJECT__EXPLAIN:
				return isExplain();
			case SearchResultPackage.QUERY_OBJECT__PAGE_INDEX:
				return getPageIndex();
			case SearchResultPackage.QUERY_OBJECT__PAGE_RESULT_SIZE:
				return getPageResultSize();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SearchResultPackage.QUERY_OBJECT__NATIVE_QUERY:
				setNativeQuery(newValue);
				return;
			case SearchResultPackage.QUERY_OBJECT__INDEX_PATH:
				setIndexPath((String)newValue);
				return;
			case SearchResultPackage.QUERY_OBJECT__MAX_RESULTS:
				setMaxResults((Integer)newValue);
				return;
			case SearchResultPackage.QUERY_OBJECT__FILTER_FIELDS:
				getFilterFields().clear();
				getFilterFields().addAll((Collection<? extends FilterField>)newValue);
				return;
			case SearchResultPackage.QUERY_OBJECT__SORT_FIELDS:
				getSortFields().clear();
				getSortFields().addAll((Collection<? extends SortField>)newValue);
				return;
			case SearchResultPackage.QUERY_OBJECT__NATIVE_OBJECT:
				setNativeObject(newValue);
				return;
			case SearchResultPackage.QUERY_OBJECT__SPATIAL_FILTER_FIELD:
				setSpatialFilterField((SpatialFilterField)newValue);
				return;
			case SearchResultPackage.QUERY_OBJECT__HIGHLIGHT_FIELDS:
				getHighlightFields().clear();
				getHighlightFields().addAll((Collection<? extends String>)newValue);
				return;
			case SearchResultPackage.QUERY_OBJECT__LIKE_THIS_OBJECT:
				setLikeThisObject((LikeThisObject)newValue);
				return;
			case SearchResultPackage.QUERY_OBJECT__ANALYZER_ID:
				setAnalyzerId((String)newValue);
				return;
			case SearchResultPackage.QUERY_OBJECT__FACET_QUERY_CONTEXT:
				setFacetQueryContext((FacetQueryContext)newValue);
				return;
			case SearchResultPackage.QUERY_OBJECT__NATIVE_COLLECTORS:
				getNativeCollectors().clear();
				getNativeCollectors().addAll((Collection<? extends Object>)newValue);
				return;
			case SearchResultPackage.QUERY_OBJECT__RUN_COLLECTOR_EXCLUSIVE:
				setRunCollectorExclusive((Boolean)newValue);
				return;
			case SearchResultPackage.QUERY_OBJECT__JOIN_QUERY:
				setJoinQuery((JoinQuery)newValue);
				return;
			case SearchResultPackage.QUERY_OBJECT__GROUPING_CONTEXT:
				setGroupingContext((GroupingContext)newValue);
				return;
			case SearchResultPackage.QUERY_OBJECT__NATIVE_QUERY_OCCUR:
				setNativeQueryOccur((Occur)newValue);
				return;
			case SearchResultPackage.QUERY_OBJECT__EXPLAIN:
				setExplain((Boolean)newValue);
				return;
			case SearchResultPackage.QUERY_OBJECT__PAGE_INDEX:
				setPageIndex((Integer)newValue);
				return;
			case SearchResultPackage.QUERY_OBJECT__PAGE_RESULT_SIZE:
				setPageResultSize((Integer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SearchResultPackage.QUERY_OBJECT__NATIVE_QUERY:
				setNativeQuery(NATIVE_QUERY_EDEFAULT);
				return;
			case SearchResultPackage.QUERY_OBJECT__INDEX_PATH:
				setIndexPath(INDEX_PATH_EDEFAULT);
				return;
			case SearchResultPackage.QUERY_OBJECT__MAX_RESULTS:
				setMaxResults(MAX_RESULTS_EDEFAULT);
				return;
			case SearchResultPackage.QUERY_OBJECT__FILTER_FIELDS:
				getFilterFields().clear();
				return;
			case SearchResultPackage.QUERY_OBJECT__SORT_FIELDS:
				getSortFields().clear();
				return;
			case SearchResultPackage.QUERY_OBJECT__NATIVE_OBJECT:
				setNativeObject(NATIVE_OBJECT_EDEFAULT);
				return;
			case SearchResultPackage.QUERY_OBJECT__SPATIAL_FILTER_FIELD:
				setSpatialFilterField((SpatialFilterField)null);
				return;
			case SearchResultPackage.QUERY_OBJECT__HIGHLIGHT_FIELDS:
				getHighlightFields().clear();
				return;
			case SearchResultPackage.QUERY_OBJECT__LIKE_THIS_OBJECT:
				setLikeThisObject((LikeThisObject)null);
				return;
			case SearchResultPackage.QUERY_OBJECT__ANALYZER_ID:
				setAnalyzerId(ANALYZER_ID_EDEFAULT);
				return;
			case SearchResultPackage.QUERY_OBJECT__FACET_QUERY_CONTEXT:
				setFacetQueryContext((FacetQueryContext)null);
				return;
			case SearchResultPackage.QUERY_OBJECT__NATIVE_COLLECTORS:
				getNativeCollectors().clear();
				return;
			case SearchResultPackage.QUERY_OBJECT__RUN_COLLECTOR_EXCLUSIVE:
				setRunCollectorExclusive(RUN_COLLECTOR_EXCLUSIVE_EDEFAULT);
				return;
			case SearchResultPackage.QUERY_OBJECT__JOIN_QUERY:
				setJoinQuery((JoinQuery)null);
				return;
			case SearchResultPackage.QUERY_OBJECT__GROUPING_CONTEXT:
				setGroupingContext((GroupingContext)null);
				return;
			case SearchResultPackage.QUERY_OBJECT__NATIVE_QUERY_OCCUR:
				setNativeQueryOccur(NATIVE_QUERY_OCCUR_EDEFAULT);
				return;
			case SearchResultPackage.QUERY_OBJECT__EXPLAIN:
				setExplain(EXPLAIN_EDEFAULT);
				return;
			case SearchResultPackage.QUERY_OBJECT__PAGE_INDEX:
				setPageIndex(PAGE_INDEX_EDEFAULT);
				return;
			case SearchResultPackage.QUERY_OBJECT__PAGE_RESULT_SIZE:
				setPageResultSize(PAGE_RESULT_SIZE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SearchResultPackage.QUERY_OBJECT__NATIVE_QUERY:
				return NATIVE_QUERY_EDEFAULT == null ? nativeQuery != null : !NATIVE_QUERY_EDEFAULT.equals(nativeQuery);
			case SearchResultPackage.QUERY_OBJECT__INDEX_PATH:
				return INDEX_PATH_EDEFAULT == null ? indexPath != null : !INDEX_PATH_EDEFAULT.equals(indexPath);
			case SearchResultPackage.QUERY_OBJECT__MAX_RESULTS:
				return maxResults != MAX_RESULTS_EDEFAULT;
			case SearchResultPackage.QUERY_OBJECT__FILTER_FIELDS:
				return filterFields != null && !filterFields.isEmpty();
			case SearchResultPackage.QUERY_OBJECT__SORT_FIELDS:
				return sortFields != null && !sortFields.isEmpty();
			case SearchResultPackage.QUERY_OBJECT__NATIVE_OBJECT:
				return NATIVE_OBJECT_EDEFAULT == null ? nativeObject != null : !NATIVE_OBJECT_EDEFAULT.equals(nativeObject);
			case SearchResultPackage.QUERY_OBJECT__SPATIAL_FILTER_FIELD:
				return spatialFilterField != null;
			case SearchResultPackage.QUERY_OBJECT__HIGHLIGHT_FIELDS:
				return highlightFields != null && !highlightFields.isEmpty();
			case SearchResultPackage.QUERY_OBJECT__LIKE_THIS_OBJECT:
				return likeThisObject != null;
			case SearchResultPackage.QUERY_OBJECT__ANALYZER_ID:
				return ANALYZER_ID_EDEFAULT == null ? analyzerId != null : !ANALYZER_ID_EDEFAULT.equals(analyzerId);
			case SearchResultPackage.QUERY_OBJECT__FACET_QUERY_CONTEXT:
				return facetQueryContext != null;
			case SearchResultPackage.QUERY_OBJECT__NATIVE_COLLECTORS:
				return nativeCollectors != null && !nativeCollectors.isEmpty();
			case SearchResultPackage.QUERY_OBJECT__RUN_COLLECTOR_EXCLUSIVE:
				return runCollectorExclusive != RUN_COLLECTOR_EXCLUSIVE_EDEFAULT;
			case SearchResultPackage.QUERY_OBJECT__JOIN_QUERY:
				return joinQuery != null;
			case SearchResultPackage.QUERY_OBJECT__GROUPING_CONTEXT:
				return groupingContext != null;
			case SearchResultPackage.QUERY_OBJECT__NATIVE_QUERY_OCCUR:
				return nativeQueryOccur != NATIVE_QUERY_OCCUR_EDEFAULT;
			case SearchResultPackage.QUERY_OBJECT__EXPLAIN:
				return explain != EXPLAIN_EDEFAULT;
			case SearchResultPackage.QUERY_OBJECT__PAGE_INDEX:
				return PAGE_INDEX_EDEFAULT == null ? pageIndex != null : !PAGE_INDEX_EDEFAULT.equals(pageIndex);
			case SearchResultPackage.QUERY_OBJECT__PAGE_RESULT_SIZE:
				return PAGE_RESULT_SIZE_EDEFAULT == null ? pageResultSize != null : !PAGE_RESULT_SIZE_EDEFAULT.equals(pageResultSize);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (nativeQuery: ");
		result.append(nativeQuery);
		result.append(", indexPath: ");
		result.append(indexPath);
		result.append(", maxResults: ");
		result.append(maxResults);
		result.append(", nativeObject: ");
		result.append(nativeObject);
		result.append(", highlightFields: ");
		result.append(highlightFields);
		result.append(", analyzerId: ");
		result.append(analyzerId);
		result.append(", nativeCollectors: ");
		result.append(nativeCollectors);
		result.append(", runCollectorExclusive: ");
		result.append(runCollectorExclusive);
		result.append(", nativeQueryOccur: ");
		result.append(nativeQueryOccur);
		result.append(", explain: ");
		result.append(explain);
		result.append(", pageIndex: ");
		result.append(pageIndex);
		result.append(", pageResultSize: ");
		result.append(pageResultSize);
		result.append(')');
		return result.toString();
	}

} //QueryObjectImpl
