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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Grouping Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchresult.GroupingContext#getMaxGroups <em>Max Groups</em>}</li>
 *   <li>{@link org.gecko.searchresult.GroupingContext#getOffSet <em>Off Set</em>}</li>
 *   <li>{@link org.gecko.searchresult.GroupingContext#getGroupFieldName <em>Group Field Name</em>}</li>
 *   <li>{@link org.gecko.searchresult.GroupingContext#getResultsPerGroup <em>Results Per Group</em>}</li>
 *   <li>{@link org.gecko.searchresult.GroupingContext#getCachSize <em>Cach Size</em>}</li>
 *   <li>{@link org.gecko.searchresult.GroupingContext#getGroupSort <em>Group Sort</em>}</li>
 * </ul>
 *
 * @see org.gecko.searchresult.SearchResultPackage#getGroupingContext()
 * @model
 * @generated
 */
public interface GroupingContext extends EObject {
	/**
	 * Returns the value of the '<em><b>Max Groups</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Groups</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Groups</em>' attribute.
	 * @see #setMaxGroups(int)
	 * @see org.gecko.searchresult.SearchResultPackage#getGroupingContext_MaxGroups()
	 * @model
	 * @generated
	 */
	int getMaxGroups();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.GroupingContext#getMaxGroups <em>Max Groups</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Groups</em>' attribute.
	 * @see #getMaxGroups()
	 * @generated
	 */
	void setMaxGroups(int value);

	/**
	 * Returns the value of the '<em><b>Off Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Off Set</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Off Set</em>' attribute.
	 * @see #setOffSet(int)
	 * @see org.gecko.searchresult.SearchResultPackage#getGroupingContext_OffSet()
	 * @model
	 * @generated
	 */
	int getOffSet();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.GroupingContext#getOffSet <em>Off Set</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Off Set</em>' attribute.
	 * @see #getOffSet()
	 * @generated
	 */
	void setOffSet(int value);

	/**
	 * Returns the value of the '<em><b>Group Field Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group Field Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group Field Name</em>' attribute.
	 * @see #setGroupFieldName(String)
	 * @see org.gecko.searchresult.SearchResultPackage#getGroupingContext_GroupFieldName()
	 * @model
	 * @generated
	 */
	String getGroupFieldName();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.GroupingContext#getGroupFieldName <em>Group Field Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Group Field Name</em>' attribute.
	 * @see #getGroupFieldName()
	 * @generated
	 */
	void setGroupFieldName(String value);

	/**
	 * Returns the value of the '<em><b>Results Per Group</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Results Per Group</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Results Per Group</em>' attribute.
	 * @see #setResultsPerGroup(int)
	 * @see org.gecko.searchresult.SearchResultPackage#getGroupingContext_ResultsPerGroup()
	 * @model default="0"
	 * @generated
	 */
	int getResultsPerGroup();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.GroupingContext#getResultsPerGroup <em>Results Per Group</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Results Per Group</em>' attribute.
	 * @see #getResultsPerGroup()
	 * @generated
	 */
	void setResultsPerGroup(int value);

	/**
	 * Returns the value of the '<em><b>Cach Size</b></em>' attribute.
	 * The default value is <code>"4.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cach Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cach Size</em>' attribute.
	 * @see #setCachSize(double)
	 * @see org.gecko.searchresult.SearchResultPackage#getGroupingContext_CachSize()
	 * @model default="4.0"
	 * @generated
	 */
	double getCachSize();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.GroupingContext#getCachSize <em>Cach Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cach Size</em>' attribute.
	 * @see #getCachSize()
	 * @generated
	 */
	void setCachSize(double value);

	/**
	 * Returns the value of the '<em><b>Group Sort</b></em>' reference list.
	 * The list contents are of type {@link org.gecko.searchresult.SortField}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group Sort</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group Sort</em>' reference list.
	 * @see org.gecko.searchresult.SearchResultPackage#getGroupingContext_GroupSort()
	 * @model
	 * @generated
	 */
	EList<SortField> getGroupSort();

} // GroupingContext
