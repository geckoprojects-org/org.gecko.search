/**
 */
package org.gecko.searchindex;

import org.eclipse.emf.ecore.EObject;

import org.gecko.emf.utilities.Converter;
import org.gecko.emf.utilities.FeaturePath;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Index Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.searchindex.IndexField#getTermVector <em>Term Vector</em>}</li>
 *   <li>{@link org.gecko.searchindex.IndexField#getStore <em>Store</em>}</li>
 *   <li>{@link org.gecko.searchindex.IndexField#getBoost <em>Boost</em>}</li>
 *   <li>{@link org.gecko.searchindex.IndexField#getType <em>Type</em>}</li>
 *   <li>{@link org.gecko.searchindex.IndexField#getKey <em>Key</em>}</li>
 *   <li>{@link org.gecko.searchindex.IndexField#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.gecko.searchindex.IndexField#getConverter <em>Converter</em>}</li>
 *   <li>{@link org.gecko.searchindex.IndexField#isOmitNorms <em>Omit Norms</em>}</li>
 *   <li>{@link org.gecko.searchindex.IndexField#isIdField <em>Id Field</em>}</li>
 *   <li>{@link org.gecko.searchindex.IndexField#getIndex <em>Index</em>}</li>
 *   <li>{@link org.gecko.searchindex.IndexField#isPkField <em>Pk Field</em>}</li>
 * </ul>
 *
 * @see org.gecko.searchindex.SearchIndexPackage#getIndexField()
 * @model
 * @generated
 */
public interface IndexField extends EObject {
	/**
	 * Returns the value of the '<em><b>Term Vector</b></em>' attribute.
	 * The literals are from the enumeration {@link org.gecko.searchindex.TermVectorType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Term Vector</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Term Vector</em>' attribute.
	 * @see org.gecko.searchindex.TermVectorType
	 * @see #setTermVector(TermVectorType)
	 * @see org.gecko.searchindex.SearchIndexPackage#getIndexField_TermVector()
	 * @model required="true"
	 * @generated
	 */
	TermVectorType getTermVector();

	/**
	 * Sets the value of the '{@link org.gecko.searchindex.IndexField#getTermVector <em>Term Vector</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Term Vector</em>' attribute.
	 * @see org.gecko.searchindex.TermVectorType
	 * @see #getTermVector()
	 * @generated
	 */
	void setTermVector(TermVectorType value);

	/**
	 * Returns the value of the '<em><b>Store</b></em>' attribute.
	 * The literals are from the enumeration {@link org.gecko.searchindex.StoreType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Store</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Store</em>' attribute.
	 * @see org.gecko.searchindex.StoreType
	 * @see #setStore(StoreType)
	 * @see org.gecko.searchindex.SearchIndexPackage#getIndexField_Store()
	 * @model required="true"
	 * @generated
	 */
	StoreType getStore();

	/**
	 * Sets the value of the '{@link org.gecko.searchindex.IndexField#getStore <em>Store</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Store</em>' attribute.
	 * @see org.gecko.searchindex.StoreType
	 * @see #getStore()
	 * @generated
	 */
	void setStore(StoreType value);

	/**
	 * Returns the value of the '<em><b>Boost</b></em>' attribute.
	 * The default value is <code>"1.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Boost</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Boost</em>' attribute.
	 * @see #setBoost(float)
	 * @see org.gecko.searchindex.SearchIndexPackage#getIndexField_Boost()
	 * @model default="1.0"
	 * @generated
	 */
	float getBoost();

	/**
	 * Sets the value of the '{@link org.gecko.searchindex.IndexField#getBoost <em>Boost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Boost</em>' attribute.
	 * @see #getBoost()
	 * @generated
	 */
	void setBoost(float value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"STRING"</code>.
	 * The literals are from the enumeration {@link org.gecko.searchindex.IndexFieldType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.gecko.searchindex.IndexFieldType
	 * @see #setType(IndexFieldType)
	 * @see org.gecko.searchindex.SearchIndexPackage#getIndexField_Type()
	 * @model default="STRING" required="true"
	 * @generated
	 */
	IndexFieldType getType();

	/**
	 * Sets the value of the '{@link org.gecko.searchindex.IndexField#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.gecko.searchindex.IndexFieldType
	 * @see #getType()
	 * @generated
	 */
	void setType(IndexFieldType value);

	/**
	 * Returns the value of the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key</em>' attribute.
	 * @see #setKey(String)
	 * @see org.gecko.searchindex.SearchIndexPackage#getIndexField_Key()
	 * @model unique="false"
	 * @generated
	 */
	String getKey();

	/**
	 * Sets the value of the '{@link org.gecko.searchindex.IndexField#getKey <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key</em>' attribute.
	 * @see #getKey()
	 * @generated
	 */
	void setKey(String value);

	/**
	 * Returns the value of the '<em><b>Feature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature</em>' containment reference.
	 * @see #setFeature(FeaturePath)
	 * @see org.gecko.searchindex.SearchIndexPackage#getIndexField_Feature()
	 * @model containment="true" required="true"
	 * @generated
	 */
	FeaturePath getFeature();

	/**
	 * Sets the value of the '{@link org.gecko.searchindex.IndexField#getFeature <em>Feature</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature</em>' containment reference.
	 * @see #getFeature()
	 * @generated
	 */
	void setFeature(FeaturePath value);

	/**
	 * Returns the value of the '<em><b>Converter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Converter</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Converter</em>' containment reference.
	 * @see #setConverter(Converter)
	 * @see org.gecko.searchindex.SearchIndexPackage#getIndexField_Converter()
	 * @model containment="true"
	 * @generated
	 */
	Converter getConverter();

	/**
	 * Sets the value of the '{@link org.gecko.searchindex.IndexField#getConverter <em>Converter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Converter</em>' containment reference.
	 * @see #getConverter()
	 * @generated
	 */
	void setConverter(Converter value);

	/**
	 * Returns the value of the '<em><b>Omit Norms</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Omit Norms</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Omit Norms</em>' attribute.
	 * @see #setOmitNorms(boolean)
	 * @see org.gecko.searchindex.SearchIndexPackage#getIndexField_OmitNorms()
	 * @model default="false"
	 * @generated
	 */
	boolean isOmitNorms();

	/**
	 * Sets the value of the '{@link org.gecko.searchindex.IndexField#isOmitNorms <em>Omit Norms</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Omit Norms</em>' attribute.
	 * @see #isOmitNorms()
	 * @generated
	 */
	void setOmitNorms(boolean value);

	/**
	 * Returns the value of the '<em><b>Id Field</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id Field</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id Field</em>' attribute.
	 * @see #setIdField(boolean)
	 * @see org.gecko.searchindex.SearchIndexPackage#getIndexField_IdField()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isIdField();

	/**
	 * Sets the value of the '{@link org.gecko.searchindex.IndexField#isIdField <em>Id Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id Field</em>' attribute.
	 * @see #isIdField()
	 * @generated
	 */
	void setIdField(boolean value);

	/**
	 * Returns the value of the '<em><b>Index</b></em>' attribute.
	 * The literals are from the enumeration {@link org.gecko.searchindex.IndexType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index</em>' attribute.
	 * @see org.gecko.searchindex.IndexType
	 * @see #setIndex(IndexType)
	 * @see org.gecko.searchindex.SearchIndexPackage#getIndexField_Index()
	 * @model
	 * @generated
	 */
	IndexType getIndex();

	/**
	 * Sets the value of the '{@link org.gecko.searchindex.IndexField#getIndex <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' attribute.
	 * @see org.gecko.searchindex.IndexType
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(IndexType value);

	/**
	 * Returns the value of the '<em><b>Pk Field</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pk Field</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pk Field</em>' attribute.
	 * @see #setPkField(boolean)
	 * @see org.gecko.searchindex.SearchIndexPackage#getIndexField_PkField()
	 * @model default="false"
	 * @generated
	 */
	boolean isPkField();

	/**
	 * Sets the value of the '{@link org.gecko.searchindex.IndexField#isPkField <em>Pk Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pk Field</em>' attribute.
	 * @see #isPkField()
	 * @generated
	 */
	void setPkField(boolean value);

} // IndexField
