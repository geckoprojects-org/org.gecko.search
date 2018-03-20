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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.gecko.searchresult.Category;
import org.gecko.searchresult.FacetResult;
import org.gecko.searchresult.SearchResult;
import org.gecko.searchresult.SearchResultPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Search Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchresult.impl.SearchResultImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.SearchResultImpl#getCategories <em>Categories</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.SearchResultImpl#getCategorySize <em>Category Size</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.SearchResultImpl#getAllMatchResultSize <em>All Match Result Size</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.SearchResultImpl#getNativeResult <em>Native Result</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.SearchResultImpl#getFacetResults <em>Facet Results</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.SearchResultImpl#getNativeCollectorResults <em>Native Collector Results</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.SearchResultImpl#getNativeJoinCollectorResults <em>Native Join Collector Results</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.SearchResultImpl#getNumberPages <em>Number Pages</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.SearchResultImpl#getPageSize <em>Page Size</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SearchResultImpl extends MinimalEObjectImpl.Container implements SearchResult {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCategories() <em>Categories</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategories()
	 * @generated
	 * @ordered
	 */
	protected EList<Category> categories;

	/**
	 * The default value of the '{@link #getCategorySize() <em>Category Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategorySize()
	 * @generated
	 * @ordered
	 */
	protected static final int CATEGORY_SIZE_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getAllMatchResultSize() <em>All Match Result Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllMatchResultSize()
	 * @generated
	 * @ordered
	 */
	protected static final int ALL_MATCH_RESULT_SIZE_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getNativeResult() <em>Native Result</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNativeResult()
	 * @generated
	 * @ordered
	 */
	protected static final Object NATIVE_RESULT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNativeResult() <em>Native Result</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNativeResult()
	 * @generated
	 * @ordered
	 */
	protected Object nativeResult = NATIVE_RESULT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFacetResults() <em>Facet Results</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacetResults()
	 * @generated
	 * @ordered
	 */
	protected EList<FacetResult> facetResults;

	/**
	 * The cached value of the '{@link #getNativeCollectorResults() <em>Native Collector Results</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNativeCollectorResults()
	 * @generated
	 * @ordered
	 */
	protected EList<Object> nativeCollectorResults;

	/**
	 * The cached value of the '{@link #getNativeJoinCollectorResults() <em>Native Join Collector Results</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNativeJoinCollectorResults()
	 * @generated
	 * @ordered
	 */
	protected EList<Object> nativeJoinCollectorResults;

	/**
	 * The default value of the '{@link #getNumberPages() <em>Number Pages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberPages()
	 * @generated
	 * @ordered
	 */
	protected static final Integer NUMBER_PAGES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNumberPages() <em>Number Pages</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberPages()
	 * @generated
	 * @ordered
	 */
	protected Integer numberPages = NUMBER_PAGES_EDEFAULT;

	/**
	 * The default value of the '{@link #getPageSize() <em>Page Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPageSize()
	 * @generated
	 * @ordered
	 */
	protected static final Integer PAGE_SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPageSize() <em>Page Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPageSize()
	 * @generated
	 * @ordered
	 */
	protected Integer pageSize = PAGE_SIZE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SearchResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SearchResultPackage.Literals.SEARCH_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.SEARCH_RESULT__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Category> getCategories() {
		if (categories == null) {
			categories = new EObjectContainmentEList<Category>(Category.class, this, SearchResultPackage.SEARCH_RESULT__CATEGORIES);
		}
		return categories;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCategorySize() {
		// TODO: implement this method to return the 'Category Size' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAllMatchResultSize() {
		// TODO: implement this method to return the 'All Match Result Size' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getNativeResult() {
		return nativeResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNativeResult(Object newNativeResult) {
		Object oldNativeResult = nativeResult;
		nativeResult = newNativeResult;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.SEARCH_RESULT__NATIVE_RESULT, oldNativeResult, nativeResult));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FacetResult> getFacetResults() {
		if (facetResults == null) {
			facetResults = new EObjectContainmentEList<FacetResult>(FacetResult.class, this, SearchResultPackage.SEARCH_RESULT__FACET_RESULTS);
		}
		return facetResults;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Object> getNativeCollectorResults() {
		if (nativeCollectorResults == null) {
			nativeCollectorResults = new EDataTypeUniqueEList<Object>(Object.class, this, SearchResultPackage.SEARCH_RESULT__NATIVE_COLLECTOR_RESULTS);
		}
		return nativeCollectorResults;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Object> getNativeJoinCollectorResults() {
		if (nativeJoinCollectorResults == null) {
			nativeJoinCollectorResults = new EDataTypeUniqueEList<Object>(Object.class, this, SearchResultPackage.SEARCH_RESULT__NATIVE_JOIN_COLLECTOR_RESULTS);
		}
		return nativeJoinCollectorResults;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getNumberPages() {
		return numberPages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberPages(Integer newNumberPages) {
		Integer oldNumberPages = numberPages;
		numberPages = newNumberPages;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.SEARCH_RESULT__NUMBER_PAGES, oldNumberPages, numberPages));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPageSize(Integer newPageSize) {
		Integer oldPageSize = pageSize;
		pageSize = newPageSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.SEARCH_RESULT__PAGE_SIZE, oldPageSize, pageSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SearchResultPackage.SEARCH_RESULT__CATEGORIES:
				return ((InternalEList<?>)getCategories()).basicRemove(otherEnd, msgs);
			case SearchResultPackage.SEARCH_RESULT__FACET_RESULTS:
				return ((InternalEList<?>)getFacetResults()).basicRemove(otherEnd, msgs);
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
			case SearchResultPackage.SEARCH_RESULT__ID:
				return getId();
			case SearchResultPackage.SEARCH_RESULT__CATEGORIES:
				return getCategories();
			case SearchResultPackage.SEARCH_RESULT__CATEGORY_SIZE:
				return getCategorySize();
			case SearchResultPackage.SEARCH_RESULT__ALL_MATCH_RESULT_SIZE:
				return getAllMatchResultSize();
			case SearchResultPackage.SEARCH_RESULT__NATIVE_RESULT:
				return getNativeResult();
			case SearchResultPackage.SEARCH_RESULT__FACET_RESULTS:
				return getFacetResults();
			case SearchResultPackage.SEARCH_RESULT__NATIVE_COLLECTOR_RESULTS:
				return getNativeCollectorResults();
			case SearchResultPackage.SEARCH_RESULT__NATIVE_JOIN_COLLECTOR_RESULTS:
				return getNativeJoinCollectorResults();
			case SearchResultPackage.SEARCH_RESULT__NUMBER_PAGES:
				return getNumberPages();
			case SearchResultPackage.SEARCH_RESULT__PAGE_SIZE:
				return getPageSize();
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
			case SearchResultPackage.SEARCH_RESULT__ID:
				setId((String)newValue);
				return;
			case SearchResultPackage.SEARCH_RESULT__CATEGORIES:
				getCategories().clear();
				getCategories().addAll((Collection<? extends Category>)newValue);
				return;
			case SearchResultPackage.SEARCH_RESULT__NATIVE_RESULT:
				setNativeResult(newValue);
				return;
			case SearchResultPackage.SEARCH_RESULT__FACET_RESULTS:
				getFacetResults().clear();
				getFacetResults().addAll((Collection<? extends FacetResult>)newValue);
				return;
			case SearchResultPackage.SEARCH_RESULT__NATIVE_COLLECTOR_RESULTS:
				getNativeCollectorResults().clear();
				getNativeCollectorResults().addAll((Collection<? extends Object>)newValue);
				return;
			case SearchResultPackage.SEARCH_RESULT__NATIVE_JOIN_COLLECTOR_RESULTS:
				getNativeJoinCollectorResults().clear();
				getNativeJoinCollectorResults().addAll((Collection<? extends Object>)newValue);
				return;
			case SearchResultPackage.SEARCH_RESULT__NUMBER_PAGES:
				setNumberPages((Integer)newValue);
				return;
			case SearchResultPackage.SEARCH_RESULT__PAGE_SIZE:
				setPageSize((Integer)newValue);
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
			case SearchResultPackage.SEARCH_RESULT__ID:
				setId(ID_EDEFAULT);
				return;
			case SearchResultPackage.SEARCH_RESULT__CATEGORIES:
				getCategories().clear();
				return;
			case SearchResultPackage.SEARCH_RESULT__NATIVE_RESULT:
				setNativeResult(NATIVE_RESULT_EDEFAULT);
				return;
			case SearchResultPackage.SEARCH_RESULT__FACET_RESULTS:
				getFacetResults().clear();
				return;
			case SearchResultPackage.SEARCH_RESULT__NATIVE_COLLECTOR_RESULTS:
				getNativeCollectorResults().clear();
				return;
			case SearchResultPackage.SEARCH_RESULT__NATIVE_JOIN_COLLECTOR_RESULTS:
				getNativeJoinCollectorResults().clear();
				return;
			case SearchResultPackage.SEARCH_RESULT__NUMBER_PAGES:
				setNumberPages(NUMBER_PAGES_EDEFAULT);
				return;
			case SearchResultPackage.SEARCH_RESULT__PAGE_SIZE:
				setPageSize(PAGE_SIZE_EDEFAULT);
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
			case SearchResultPackage.SEARCH_RESULT__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case SearchResultPackage.SEARCH_RESULT__CATEGORIES:
				return categories != null && !categories.isEmpty();
			case SearchResultPackage.SEARCH_RESULT__CATEGORY_SIZE:
				return getCategorySize() != CATEGORY_SIZE_EDEFAULT;
			case SearchResultPackage.SEARCH_RESULT__ALL_MATCH_RESULT_SIZE:
				return getAllMatchResultSize() != ALL_MATCH_RESULT_SIZE_EDEFAULT;
			case SearchResultPackage.SEARCH_RESULT__NATIVE_RESULT:
				return NATIVE_RESULT_EDEFAULT == null ? nativeResult != null : !NATIVE_RESULT_EDEFAULT.equals(nativeResult);
			case SearchResultPackage.SEARCH_RESULT__FACET_RESULTS:
				return facetResults != null && !facetResults.isEmpty();
			case SearchResultPackage.SEARCH_RESULT__NATIVE_COLLECTOR_RESULTS:
				return nativeCollectorResults != null && !nativeCollectorResults.isEmpty();
			case SearchResultPackage.SEARCH_RESULT__NATIVE_JOIN_COLLECTOR_RESULTS:
				return nativeJoinCollectorResults != null && !nativeJoinCollectorResults.isEmpty();
			case SearchResultPackage.SEARCH_RESULT__NUMBER_PAGES:
				return NUMBER_PAGES_EDEFAULT == null ? numberPages != null : !NUMBER_PAGES_EDEFAULT.equals(numberPages);
			case SearchResultPackage.SEARCH_RESULT__PAGE_SIZE:
				return PAGE_SIZE_EDEFAULT == null ? pageSize != null : !PAGE_SIZE_EDEFAULT.equals(pageSize);
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
		result.append(" (id: ");
		result.append(id);
		result.append(", nativeResult: ");
		result.append(nativeResult);
		result.append(", nativeCollectorResults: ");
		result.append(nativeCollectorResults);
		result.append(", nativeJoinCollectorResults: ");
		result.append(nativeJoinCollectorResults);
		result.append(", numberPages: ");
		result.append(numberPages);
		result.append(", pageSize: ");
		result.append(pageSize);
		result.append(')');
		return result.toString();
	}

} //SearchResultImpl
