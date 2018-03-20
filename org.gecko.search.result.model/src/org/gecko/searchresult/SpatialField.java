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

import org.gecko.emf.utilities.LatLng;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Spatial Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchresult.SpatialField#getLatLng <em>Lat Lng</em>}</li>
 *   <li>{@link org.gecko.searchresult.SpatialField#getDistance <em>Distance</em>}</li>
 * </ul>
 *
 * @see org.gecko.searchresult.SearchResultPackage#getSpatialField()
 * @model
 * @generated
 */
public interface SpatialField extends LuceneQueryField {
	/**
	 * Returns the value of the '<em><b>Lat Lng</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lat Lng</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lat Lng</em>' containment reference.
	 * @see #setLatLng(LatLng)
	 * @see org.gecko.searchresult.SearchResultPackage#getSpatialField_LatLng()
	 * @model containment="true"
	 * @generated
	 */
	LatLng getLatLng();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.SpatialField#getLatLng <em>Lat Lng</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lat Lng</em>' containment reference.
	 * @see #getLatLng()
	 * @generated
	 */
	void setLatLng(LatLng value);

	/**
	 * Returns the value of the '<em><b>Distance</b></em>' attribute.
	 * The default value is <code>"100"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Distance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Distance</em>' attribute.
	 * @see #setDistance(double)
	 * @see org.gecko.searchresult.SearchResultPackage#getSpatialField_Distance()
	 * @model default="100"
	 * @generated
	 */
	double getDistance();

	/**
	 * Sets the value of the '{@link org.gecko.searchresult.SpatialField#getDistance <em>Distance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Distance</em>' attribute.
	 * @see #getDistance()
	 * @generated
	 */
	void setDistance(double value);

} // SpatialField
