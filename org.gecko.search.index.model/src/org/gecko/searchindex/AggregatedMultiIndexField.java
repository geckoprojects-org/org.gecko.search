/**
 */
package org.gecko.searchindex;

import org.eclipse.emf.common.util.EList;

import org.gecko.emf.utilities.FeaturePath;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Aggregated Multi Index Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchindex.AggregatedMultiIndexField#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.gecko.searchindex.AggregatedMultiIndexField#getIndexFields <em>Index Fields</em>}</li>
 * </ul>
 *
 * @see org.gecko.searchindex.SearchIndexPackage#getAggregatedMultiIndexField()
 * @model
 * @generated
 */
public interface AggregatedMultiIndexField extends IndexField {
	/**
	 * Returns the value of the '<em><b>Features</b></em>' containment reference list.
	 * The list contents are of type {@link org.gecko.emf.utilities.FeaturePath}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' containment reference list.
	 * @see org.gecko.searchindex.SearchIndexPackage#getAggregatedMultiIndexField_Features()
	 * @model containment="true"
	 * @generated
	 */
	EList<FeaturePath> getFeatures();

	/**
	 * Returns the value of the '<em><b>Index Fields</b></em>' reference list.
	 * The list contents are of type {@link org.gecko.searchindex.IndexField}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index Fields</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index Fields</em>' reference list.
	 * @see org.gecko.searchindex.SearchIndexPackage#getAggregatedMultiIndexField_IndexFields()
	 * @model
	 * @generated
	 */
	EList<IndexField> getIndexFields();

} // AggregatedMultiIndexField
