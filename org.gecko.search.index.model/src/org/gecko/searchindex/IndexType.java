/**
 */
package org.gecko.searchindex;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Index Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.gecko.searchindex.SearchIndexPackage#getIndexType()
 * @model
 * @generated
 */
public enum IndexType implements Enumerator {
	/**
	 * The '<em><b>ANALYZED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ANALYZED_VALUE
	 * @generated
	 * @ordered
	 */
	ANALYZED(0, "ANALYZED", "ANALYZED"),

	/**
	 * The '<em><b>NOT ANALYZED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOT_ANALYZED_VALUE
	 * @generated
	 * @ordered
	 */
	NOT_ANALYZED(1, "NOT_ANALYZED", "NOT_ANALYZED"),

	/**
	 * The '<em><b>ANALYZED NO NORMS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ANALYZED_NO_NORMS_VALUE
	 * @generated
	 * @ordered
	 */
	ANALYZED_NO_NORMS(2, "ANALYZED_NO_NORMS", "ANALYZED_NO_NORMS"),

	/**
	 * The '<em><b>NOT ANALYZED NO NORMS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOT_ANALYZED_NO_NORMS_VALUE
	 * @generated
	 * @ordered
	 */
	NOT_ANALYZED_NO_NORMS(3, "NOT_ANALYZED_NO_NORMS", "NOT_ANALYZED_NO_NORMS"),

	/**
	 * The '<em><b>NO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NO_VALUE
	 * @generated
	 * @ordered
	 */
	NO(4, "NO", "NO");

	/**
	 * The '<em><b>ANALYZED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ANALYZED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ANALYZED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ANALYZED_VALUE = 0;

	/**
	 * The '<em><b>NOT ANALYZED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NOT ANALYZED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NOT_ANALYZED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NOT_ANALYZED_VALUE = 1;

	/**
	 * The '<em><b>ANALYZED NO NORMS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ANALYZED NO NORMS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ANALYZED_NO_NORMS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ANALYZED_NO_NORMS_VALUE = 2;

	/**
	 * The '<em><b>NOT ANALYZED NO NORMS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NOT ANALYZED NO NORMS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NOT_ANALYZED_NO_NORMS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NOT_ANALYZED_NO_NORMS_VALUE = 3;

	/**
	 * The '<em><b>NO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NO
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NO_VALUE = 4;

	/**
	 * An array of all the '<em><b>Index Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IndexType[] VALUES_ARRAY =
		new IndexType[] {
			ANALYZED,
			NOT_ANALYZED,
			ANALYZED_NO_NORMS,
			NOT_ANALYZED_NO_NORMS,
			NO,
		};

	/**
	 * A public read-only list of all the '<em><b>Index Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IndexType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Index Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IndexType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IndexType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Index Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IndexType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IndexType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Index Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IndexType get(int value) {
		switch (value) {
			case ANALYZED_VALUE: return ANALYZED;
			case NOT_ANALYZED_VALUE: return NOT_ANALYZED;
			case ANALYZED_NO_NORMS_VALUE: return ANALYZED_NO_NORMS;
			case NOT_ANALYZED_NO_NORMS_VALUE: return NOT_ANALYZED_NO_NORMS;
			case NO_VALUE: return NO;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private IndexType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //IndexType
