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
package org.gecko.searchresult;

import org.eclipse.emf.common.util.EList;

import org.gecko.utilities.query.Query;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Query Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchresult.QueryObject#getNativeQuery <em>Native Query</em>}</li>
 *   <li>{@link org.gecko.searchresult.QueryObject#getIndexPath <em>Index Path</em>}</li>
 *   <li>{@link org.gecko.searchresult.QueryObject#getMaxResults <em>Max Results</em>}</li>
 *   <li>{@link org.gecko.searchresult.QueryObject#getFilterFields <em>Filter Fields</em>}</li>
 *   <li>{@link org.gecko.searchresult.QueryObject#getSortFields <em>Sort Fields</em>}</li>
 *   <li>{@link org.gecko.searchresult.QueryObject#getNativeObject <em>Native Object</em>}</li>
 *   <li>{@link org.gecko.searchresult.QueryObject#getSpatialFilterField <em>Spatial Filter Field</em>}</li>
 *   <li>{@link org.gecko.searchresult.QueryObject#getHighlightFields <em>Highlight Fields</em>}</li>
 *   <li>{@link org.gecko.searchresult.QueryObject#getLikeThisObject <em>Like This Object</em>}</li>
 *   <li>{@link org.gecko.searchresult.QueryObject#getAnalyzerId <em>Analyzer Id</em>}</li>
 *   <li>{@link org.gecko.searchresult.QueryObject#getFacetQueryContext <em>Facet Query Context</em>}</li>
 *   <li>{@link org.gecko.searchresult.QueryObject#getNativeCollectors <em>Native Collectors</em>}</li>
 *   <li>{@link org.gecko.searchresult.QueryObject#isRunCollectorExclusive <em>Run Collector Exclusive</em>}</li>
 *   <li>{@link org.gecko.searchresult.QueryObject#getJoinQuery <em>Join Query</em>}</li>
 *   <li>{@link org.gecko.searchresult.QueryObject#getGroupingContext <em>Grouping Context</em>}</li>
 *   <li>{@link org.gecko.searchresult.QueryObject#getNativeQueryOccur <em>Native Query Occur</em>}</li>
 *   <li>{@link org.gecko.searchresult.QueryObject#isExplain <em>Explain</em>}</li>
 *   <li>{@link org.gecko.searchresult.QueryObject#getPageIndex <em>Page Index</em>}</li>
 *   <li>{@link org.gecko.searchresult.QueryObject#getPageResultSize <em>Page Result Size</em>}</li>
 * </ul>
 *
 * @see org.gecko.searchresult.SearchResultPackage#getQueryObject()
 * @model
 * @generated
 */
public interface QueryObject extends Query {
	/**
	 * Returns the value of the '<em><b>Native Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Native Query</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Native Query</em>' attribute.
	 * @see #setNativeQuery(Object)
	 * @see org.gecko.searchresult.SearchResultPackage#getQueryObject_NativeQuery()
	 * @model
	 * @generated
	 */
	Object getNativeQuery();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.QueryObject#getNativeQuery <em>Native Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Native Query</em>' attribute.
	 * @see #getNativeQuery()
	 * @generated
	 */
	void setNativeQuery(Object value);

	/**
	 * Returns the value of the '<em><b>Index Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index Path</em>' attribute.
	 * @see #setIndexPath(String)
	 * @see org.gecko.searchresult.SearchResultPackage#getQueryObject_IndexPath()
	 * @model required="true"
	 * @generated
	 */
	String getIndexPath();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.QueryObject#getIndexPath <em>Index Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index Path</em>' attribute.
	 * @see #getIndexPath()
	 * @generated
	 */
	void setIndexPath(String value);

	/**
	 * Returns the value of the '<em><b>Max Results</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Results</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Results</em>' attribute.
	 * @see #setMaxResults(int)
	 * @see org.gecko.searchresult.SearchResultPackage#getQueryObject_MaxResults()
	 * @model
	 * @generated
	 */
	int getMaxResults();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.QueryObject#getMaxResults <em>Max Results</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Results</em>' attribute.
	 * @see #getMaxResults()
	 * @generated
	 */
	void setMaxResults(int value);

	/**
	 * Returns the value of the '<em><b>Filter Fields</b></em>' containment reference list.
	 * The list contents are of type {@link org.gecko.searchresult.FilterField}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filter Fields</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filter Fields</em>' containment reference list.
	 * @see org.gecko.searchresult.SearchResultPackage#getQueryObject_FilterFields()
	 * @model containment="true"
	 * @generated
	 */
	EList<FilterField> getFilterFields();

	/**
	 * Returns the value of the '<em><b>Sort Fields</b></em>' containment reference list.
	 * The list contents are of type {@link org.gecko.searchresult.SortField}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sort Fields</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sort Fields</em>' containment reference list.
	 * @see org.gecko.searchresult.SearchResultPackage#getQueryObject_SortFields()
	 * @model containment="true"
	 * @generated
	 */
	EList<SortField> getSortFields();

	/**
	 * Returns the value of the '<em><b>Native Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Native Object</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Native Object</em>' attribute.
	 * @see #setNativeObject(Object)
	 * @see org.gecko.searchresult.SearchResultPackage#getQueryObject_NativeObject()
	 * @model transient="true"
	 * @generated
	 */
	Object getNativeObject();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.QueryObject#getNativeObject <em>Native Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Native Object</em>' attribute.
	 * @see #getNativeObject()
	 * @generated
	 */
	void setNativeObject(Object value);

	/**
	 * Returns the value of the '<em><b>Spatial Filter Field</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Spatial Filter Field</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Spatial Filter Field</em>' reference.
	 * @see #setSpatialFilterField(SpatialFilterField)
	 * @see org.gecko.searchresult.SearchResultPackage#getQueryObject_SpatialFilterField()
	 * @model
	 * @generated
	 */
	SpatialFilterField getSpatialFilterField();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.QueryObject#getSpatialFilterField <em>Spatial Filter Field</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Spatial Filter Field</em>' reference.
	 * @see #getSpatialFilterField()
	 * @generated
	 */
	void setSpatialFilterField(SpatialFilterField value);

	/**
	 * Returns the value of the '<em><b>Highlight Fields</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Highlight Fields</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Highlight Fields</em>' attribute list.
	 * @see org.gecko.searchresult.SearchResultPackage#getQueryObject_HighlightFields()
	 * @model
	 * @generated
	 */
	EList<String> getHighlightFields();

	/**
	 * Returns the value of the '<em><b>Like This Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Like This Object</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Like This Object</em>' containment reference.
	 * @see #setLikeThisObject(LikeThisObject)
	 * @see org.gecko.searchresult.SearchResultPackage#getQueryObject_LikeThisObject()
	 * @model containment="true"
	 * @generated
	 */
	LikeThisObject getLikeThisObject();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.QueryObject#getLikeThisObject <em>Like This Object</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Like This Object</em>' containment reference.
	 * @see #getLikeThisObject()
	 * @generated
	 */
	void setLikeThisObject(LikeThisObject value);

	/**
	 * Returns the value of the '<em><b>Analyzer Id</b></em>' attribute.
	 * The default value is <code>"default"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Analyzer Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Analyzer Id</em>' attribute.
	 * @see #setAnalyzerId(String)
	 * @see org.gecko.searchresult.SearchResultPackage#getQueryObject_AnalyzerId()
	 * @model default="default"
	 * @generated
	 */
	String getAnalyzerId();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.QueryObject#getAnalyzerId <em>Analyzer Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Analyzer Id</em>' attribute.
	 * @see #getAnalyzerId()
	 * @generated
	 */
	void setAnalyzerId(String value);

	/**
	 * Returns the value of the '<em><b>Facet Query Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facet Query Context</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Facet Query Context</em>' containment reference.
	 * @see #setFacetQueryContext(FacetQueryContext)
	 * @see org.gecko.searchresult.SearchResultPackage#getQueryObject_FacetQueryContext()
	 * @model containment="true"
	 * @generated
	 */
	FacetQueryContext getFacetQueryContext();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.QueryObject#getFacetQueryContext <em>Facet Query Context</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Facet Query Context</em>' containment reference.
	 * @see #getFacetQueryContext()
	 * @generated
	 */
	void setFacetQueryContext(FacetQueryContext value);

	/**
	 * Returns the value of the '<em><b>Native Collectors</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Object}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Native Collectors</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Native Collectors</em>' attribute list.
	 * @see org.gecko.searchresult.SearchResultPackage#getQueryObject_NativeCollectors()
	 * @model
	 * @generated
	 */
	EList<Object> getNativeCollectors();

	/**
	 * Returns the value of the '<em><b>Run Collector Exclusive</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Run Collector Exclusive</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Run Collector Exclusive</em>' attribute.
	 * @see #setRunCollectorExclusive(boolean)
	 * @see org.gecko.searchresult.SearchResultPackage#getQueryObject_RunCollectorExclusive()
	 * @model default="true"
	 * @generated
	 */
	boolean isRunCollectorExclusive();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.QueryObject#isRunCollectorExclusive <em>Run Collector Exclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Run Collector Exclusive</em>' attribute.
	 * @see #isRunCollectorExclusive()
	 * @generated
	 */
	void setRunCollectorExclusive(boolean value);

	/**
	 * Returns the value of the '<em><b>Join Query</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Join Query</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Join Query</em>' containment reference.
	 * @see #setJoinQuery(JoinQuery)
	 * @see org.gecko.searchresult.SearchResultPackage#getQueryObject_JoinQuery()
	 * @model containment="true"
	 * @generated
	 */
	JoinQuery getJoinQuery();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.QueryObject#getJoinQuery <em>Join Query</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Join Query</em>' containment reference.
	 * @see #getJoinQuery()
	 * @generated
	 */
	void setJoinQuery(JoinQuery value);

	/**
	 * Returns the value of the '<em><b>Grouping Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Grouping Context</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Grouping Context</em>' reference.
	 * @see #setGroupingContext(GroupingContext)
	 * @see org.gecko.searchresult.SearchResultPackage#getQueryObject_GroupingContext()
	 * @model
	 * @generated
	 */
	GroupingContext getGroupingContext();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.QueryObject#getGroupingContext <em>Grouping Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Grouping Context</em>' reference.
	 * @see #getGroupingContext()
	 * @generated
	 */
	void setGroupingContext(GroupingContext value);

	/**
	 * Returns the value of the '<em><b>Native Query Occur</b></em>' attribute.
	 * The default value is <code>"MUST"</code>.
	 * The literals are from the enumeration {@link org.gecko.searchresult.Occur}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Native Query Occur</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Native Query Occur</em>' attribute.
	 * @see org.gecko.searchresult.Occur
	 * @see #setNativeQueryOccur(Occur)
	 * @see org.gecko.searchresult.SearchResultPackage#getQueryObject_NativeQueryOccur()
	 * @model default="MUST"
	 * @generated
	 */
	Occur getNativeQueryOccur();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.QueryObject#getNativeQueryOccur <em>Native Query Occur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Native Query Occur</em>' attribute.
	 * @see org.gecko.searchresult.Occur
	 * @see #getNativeQueryOccur()
	 * @generated
	 */
	void setNativeQueryOccur(Occur value);

	/**
	 * Returns the value of the '<em><b>Explain</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Explain</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Explain</em>' attribute.
	 * @see #setExplain(boolean)
	 * @see org.gecko.searchresult.SearchResultPackage#getQueryObject_Explain()
	 * @model default="false"
	 * @generated
	 */
	boolean isExplain();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.QueryObject#isExplain <em>Explain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Explain</em>' attribute.
	 * @see #isExplain()
	 * @generated
	 */
	void setExplain(boolean value);

	/**
	 * Returns the value of the '<em><b>Page Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Page Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Page Index</em>' attribute.
	 * @see #setPageIndex(Integer)
	 * @see org.gecko.searchresult.SearchResultPackage#getQueryObject_PageIndex()
	 * @model
	 * @generated
	 */
	Integer getPageIndex();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.QueryObject#getPageIndex <em>Page Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Page Index</em>' attribute.
	 * @see #getPageIndex()
	 * @generated
	 */
	void setPageIndex(Integer value);

	/**
	 * Returns the value of the '<em><b>Page Result Size</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Page Result Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Page Result Size</em>' attribute.
	 * @see #setPageResultSize(Integer)
	 * @see org.gecko.searchresult.SearchResultPackage#getQueryObject_PageResultSize()
	 * @model default="-1"
	 * @generated
	 */
	Integer getPageResultSize();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.QueryObject#getPageResultSize <em>Page Result Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Page Result Size</em>' attribute.
	 * @see #getPageResultSize()
	 * @generated
	 */
	void setPageResultSize(Integer value);

} // QueryObject
