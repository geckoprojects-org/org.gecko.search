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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.gecko.searchresult.FacetFilter;
import org.gecko.searchresult.FacetQueryContext;
import org.gecko.searchresult.SearchResultPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Facet Query Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchresult.impl.FacetQueryContextImpl#getFacetFields <em>Facet Fields</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.FacetQueryContextImpl#isCountFacets <em>Count Facets</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.FacetQueryContextImpl#isFillInCategories <em>Fill In Categories</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.FacetQueryContextImpl#isAllowDuplicatesInCategories <em>Allow Duplicates In Categories</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.FacetQueryContextImpl#getMaxFacets <em>Max Facets</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.FacetQueryContextImpl#getDimensions <em>Dimensions</em>}</li>
 *   <li>{@link org.gecko.searchresult.impl.FacetQueryContextImpl#getMaxResultPerCategory <em>Max Result Per Category</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FacetQueryContextImpl extends MinimalEObjectImpl.Container implements FacetQueryContext {
	/**
	 * The cached value of the '{@link #getFacetFields() <em>Facet Fields</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacetFields()
	 * @generated
	 * @ordered
	 */
	protected EList<FacetFilter> facetFields;

	/**
	 * The default value of the '{@link #isCountFacets() <em>Count Facets</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCountFacets()
	 * @generated
	 * @ordered
	 */
	protected static final boolean COUNT_FACETS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCountFacets() <em>Count Facets</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCountFacets()
	 * @generated
	 * @ordered
	 */
	protected boolean countFacets = COUNT_FACETS_EDEFAULT;

	/**
	 * The default value of the '{@link #isFillInCategories() <em>Fill In Categories</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFillInCategories()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FILL_IN_CATEGORIES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFillInCategories() <em>Fill In Categories</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFillInCategories()
	 * @generated
	 * @ordered
	 */
	protected boolean fillInCategories = FILL_IN_CATEGORIES_EDEFAULT;

	/**
	 * The default value of the '{@link #isAllowDuplicatesInCategories() <em>Allow Duplicates In Categories</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllowDuplicatesInCategories()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ALLOW_DUPLICATES_IN_CATEGORIES_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isAllowDuplicatesInCategories() <em>Allow Duplicates In Categories</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllowDuplicatesInCategories()
	 * @generated
	 * @ordered
	 */
	protected boolean allowDuplicatesInCategories = ALLOW_DUPLICATES_IN_CATEGORIES_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxFacets() <em>Max Facets</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxFacets()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_FACETS_EDEFAULT = 10;

	/**
	 * The cached value of the '{@link #getMaxFacets() <em>Max Facets</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxFacets()
	 * @generated
	 * @ordered
	 */
	protected int maxFacets = MAX_FACETS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDimensions() <em>Dimensions</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDimensions()
	 * @generated
	 * @ordered
	 */
	protected EList<String> dimensions;

	/**
	 * The default value of the '{@link #getMaxResultPerCategory() <em>Max Result Per Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxResultPerCategory()
	 * @generated
	 * @ordered
	 */
	protected static final Integer MAX_RESULT_PER_CATEGORY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaxResultPerCategory() <em>Max Result Per Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxResultPerCategory()
	 * @generated
	 * @ordered
	 */
	protected Integer maxResultPerCategory = MAX_RESULT_PER_CATEGORY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FacetQueryContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SearchResultPackage.Literals.FACET_QUERY_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FacetFilter> getFacetFields() {
		if (facetFields == null) {
			facetFields = new EObjectResolvingEList<FacetFilter>(FacetFilter.class, this, SearchResultPackage.FACET_QUERY_CONTEXT__FACET_FIELDS);
		}
		return facetFields;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCountFacets() {
		return countFacets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCountFacets(boolean newCountFacets) {
		boolean oldCountFacets = countFacets;
		countFacets = newCountFacets;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.FACET_QUERY_CONTEXT__COUNT_FACETS, oldCountFacets, countFacets));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFillInCategories() {
		return fillInCategories;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFillInCategories(boolean newFillInCategories) {
		boolean oldFillInCategories = fillInCategories;
		fillInCategories = newFillInCategories;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.FACET_QUERY_CONTEXT__FILL_IN_CATEGORIES, oldFillInCategories, fillInCategories));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAllowDuplicatesInCategories() {
		return allowDuplicatesInCategories;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllowDuplicatesInCategories(boolean newAllowDuplicatesInCategories) {
		boolean oldAllowDuplicatesInCategories = allowDuplicatesInCategories;
		allowDuplicatesInCategories = newAllowDuplicatesInCategories;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.FACET_QUERY_CONTEXT__ALLOW_DUPLICATES_IN_CATEGORIES, oldAllowDuplicatesInCategories, allowDuplicatesInCategories));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxFacets() {
		return maxFacets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxFacets(int newMaxFacets) {
		int oldMaxFacets = maxFacets;
		maxFacets = newMaxFacets;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.FACET_QUERY_CONTEXT__MAX_FACETS, oldMaxFacets, maxFacets));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getDimensions() {
		if (dimensions == null) {
			dimensions = new EDataTypeUniqueEList<String>(String.class, this, SearchResultPackage.FACET_QUERY_CONTEXT__DIMENSIONS);
		}
		return dimensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getMaxResultPerCategory() {
		return maxResultPerCategory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxResultPerCategory(Integer newMaxResultPerCategory) {
		Integer oldMaxResultPerCategory = maxResultPerCategory;
		maxResultPerCategory = newMaxResultPerCategory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SearchResultPackage.FACET_QUERY_CONTEXT__MAX_RESULT_PER_CATEGORY, oldMaxResultPerCategory, maxResultPerCategory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SearchResultPackage.FACET_QUERY_CONTEXT__FACET_FIELDS:
				return getFacetFields();
			case SearchResultPackage.FACET_QUERY_CONTEXT__COUNT_FACETS:
				return isCountFacets();
			case SearchResultPackage.FACET_QUERY_CONTEXT__FILL_IN_CATEGORIES:
				return isFillInCategories();
			case SearchResultPackage.FACET_QUERY_CONTEXT__ALLOW_DUPLICATES_IN_CATEGORIES:
				return isAllowDuplicatesInCategories();
			case SearchResultPackage.FACET_QUERY_CONTEXT__MAX_FACETS:
				return getMaxFacets();
			case SearchResultPackage.FACET_QUERY_CONTEXT__DIMENSIONS:
				return getDimensions();
			case SearchResultPackage.FACET_QUERY_CONTEXT__MAX_RESULT_PER_CATEGORY:
				return getMaxResultPerCategory();
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
			case SearchResultPackage.FACET_QUERY_CONTEXT__FACET_FIELDS:
				getFacetFields().clear();
				getFacetFields().addAll((Collection<? extends FacetFilter>)newValue);
				return;
			case SearchResultPackage.FACET_QUERY_CONTEXT__COUNT_FACETS:
				setCountFacets((Boolean)newValue);
				return;
			case SearchResultPackage.FACET_QUERY_CONTEXT__FILL_IN_CATEGORIES:
				setFillInCategories((Boolean)newValue);
				return;
			case SearchResultPackage.FACET_QUERY_CONTEXT__ALLOW_DUPLICATES_IN_CATEGORIES:
				setAllowDuplicatesInCategories((Boolean)newValue);
				return;
			case SearchResultPackage.FACET_QUERY_CONTEXT__MAX_FACETS:
				setMaxFacets((Integer)newValue);
				return;
			case SearchResultPackage.FACET_QUERY_CONTEXT__DIMENSIONS:
				getDimensions().clear();
				getDimensions().addAll((Collection<? extends String>)newValue);
				return;
			case SearchResultPackage.FACET_QUERY_CONTEXT__MAX_RESULT_PER_CATEGORY:
				setMaxResultPerCategory((Integer)newValue);
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
			case SearchResultPackage.FACET_QUERY_CONTEXT__FACET_FIELDS:
				getFacetFields().clear();
				return;
			case SearchResultPackage.FACET_QUERY_CONTEXT__COUNT_FACETS:
				setCountFacets(COUNT_FACETS_EDEFAULT);
				return;
			case SearchResultPackage.FACET_QUERY_CONTEXT__FILL_IN_CATEGORIES:
				setFillInCategories(FILL_IN_CATEGORIES_EDEFAULT);
				return;
			case SearchResultPackage.FACET_QUERY_CONTEXT__ALLOW_DUPLICATES_IN_CATEGORIES:
				setAllowDuplicatesInCategories(ALLOW_DUPLICATES_IN_CATEGORIES_EDEFAULT);
				return;
			case SearchResultPackage.FACET_QUERY_CONTEXT__MAX_FACETS:
				setMaxFacets(MAX_FACETS_EDEFAULT);
				return;
			case SearchResultPackage.FACET_QUERY_CONTEXT__DIMENSIONS:
				getDimensions().clear();
				return;
			case SearchResultPackage.FACET_QUERY_CONTEXT__MAX_RESULT_PER_CATEGORY:
				setMaxResultPerCategory(MAX_RESULT_PER_CATEGORY_EDEFAULT);
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
			case SearchResultPackage.FACET_QUERY_CONTEXT__FACET_FIELDS:
				return facetFields != null && !facetFields.isEmpty();
			case SearchResultPackage.FACET_QUERY_CONTEXT__COUNT_FACETS:
				return countFacets != COUNT_FACETS_EDEFAULT;
			case SearchResultPackage.FACET_QUERY_CONTEXT__FILL_IN_CATEGORIES:
				return fillInCategories != FILL_IN_CATEGORIES_EDEFAULT;
			case SearchResultPackage.FACET_QUERY_CONTEXT__ALLOW_DUPLICATES_IN_CATEGORIES:
				return allowDuplicatesInCategories != ALLOW_DUPLICATES_IN_CATEGORIES_EDEFAULT;
			case SearchResultPackage.FACET_QUERY_CONTEXT__MAX_FACETS:
				return maxFacets != MAX_FACETS_EDEFAULT;
			case SearchResultPackage.FACET_QUERY_CONTEXT__DIMENSIONS:
				return dimensions != null && !dimensions.isEmpty();
			case SearchResultPackage.FACET_QUERY_CONTEXT__MAX_RESULT_PER_CATEGORY:
				return MAX_RESULT_PER_CATEGORY_EDEFAULT == null ? maxResultPerCategory != null : !MAX_RESULT_PER_CATEGORY_EDEFAULT.equals(maxResultPerCategory);
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
		result.append(" (countFacets: ");
		result.append(countFacets);
		result.append(", fillInCategories: ");
		result.append(fillInCategories);
		result.append(", allowDuplicatesInCategories: ");
		result.append(allowDuplicatesInCategories);
		result.append(", maxFacets: ");
		result.append(maxFacets);
		result.append(", dimensions: ");
		result.append(dimensions);
		result.append(", maxResultPerCategory: ");
		result.append(maxResultPerCategory);
		result.append(')');
		return result.toString();
	}

} //FacetQueryContextImpl
