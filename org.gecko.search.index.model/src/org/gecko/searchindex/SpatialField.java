/**
 */
package org.gecko.searchindex;

import org.gecko.emf.utilities.FeaturePath;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Spatial Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchindex.SpatialField#getLongitude <em>Longitude</em>}</li>
 *   <li>{@link org.gecko.searchindex.SpatialField#getLatitude <em>Latitude</em>}</li>
 * </ul>
 *
 * @see org.gecko.searchindex.SearchIndexPackage#getSpatialField()
 * @model
 * @generated
 */
public interface SpatialField extends IndexField {
	/**
	 * Returns the value of the '<em><b>Longitude</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Longitude</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Longitude</em>' containment reference.
	 * @see #setLongitude(FeaturePath)
	 * @see org.gecko.searchindex.SearchIndexPackage#getSpatialField_Longitude()
	 * @model containment="true" required="true"
	 * @generated
	 */
	FeaturePath getLongitude();

	/**
	 * Sets the value of the '{@link org.gecko.searchindex.SpatialField#getLongitude <em>Longitude</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Longitude</em>' containment reference.
	 * @see #getLongitude()
	 * @generated
	 */
	void setLongitude(FeaturePath value);

	/**
	 * Returns the value of the '<em><b>Latitude</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Latitude</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Latitude</em>' containment reference.
	 * @see #setLatitude(FeaturePath)
	 * @see org.gecko.searchindex.SearchIndexPackage#getSpatialField_Latitude()
	 * @model containment="true" required="true"
	 * @generated
	 */
	FeaturePath getLatitude();

	/**
	 * Sets the value of the '{@link org.gecko.searchindex.SpatialField#getLatitude <em>Latitude</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Latitude</em>' containment reference.
	 * @see #getLatitude()
	 * @generated
	 */
	void setLatitude(FeaturePath value);

} // SpatialField
