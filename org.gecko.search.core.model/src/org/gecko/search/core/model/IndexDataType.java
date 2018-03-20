/**
 * Copyright (c) 2014 Data In Motion and others.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Data In Motion - initial API and implementation
 */
package org.gecko.search.core.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Index Data Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.gecko.search.core.model.SearchPackage#getIndexDataType()
 * @model
 * @generated
 */
public enum IndexDataType implements Enumerator {
	/**
   * The '<em><b>File System</b></em>' literal object.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #FILE_SYSTEM_VALUE
   * @generated
   * @ordered
   */
	FILE_SYSTEM(0, "FileSystem", "FS"),

	/**
   * The '<em><b>MMap</b></em>' literal object.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #MMAP_VALUE
   * @generated
   * @ordered
   */
	MMAP(1, "MMap", "MMAP"),

	/**
   * The '<em><b>RAM</b></em>' literal object.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #RAM_VALUE
   * @generated
   * @ordered
   */
	RAM(2, "RAM", "RAM"),

	/**
   * The '<em><b>Mongo DB</b></em>' literal object.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #MONGO_DB_VALUE
   * @generated
   * @ordered
   */
	MONGO_DB(3, "MongoDB", "MONGODB");

	/**
   * The '<em><b>File System</b></em>' literal value.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>File System</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @see #FILE_SYSTEM
   * @model name="FileSystem" literal="FS"
   * @generated
   * @ordered
   */
	public static final int FILE_SYSTEM_VALUE = 0;

	/**
   * The '<em><b>MMap</b></em>' literal value.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MMap</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @see #MMAP
   * @model name="MMap" literal="MMAP"
   * @generated
   * @ordered
   */
	public static final int MMAP_VALUE = 1;

	/**
   * The '<em><b>RAM</b></em>' literal value.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RAM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @see #RAM
   * @model
   * @generated
   * @ordered
   */
	public static final int RAM_VALUE = 2;

	/**
   * The '<em><b>Mongo DB</b></em>' literal value.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Mongo DB</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @see #MONGO_DB
   * @model name="MongoDB" literal="MONGODB"
   * @generated
   * @ordered
   */
	public static final int MONGO_DB_VALUE = 3;

	/**
   * An array of all the '<em><b>Index Data Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private static final IndexDataType[] VALUES_ARRAY =
		new IndexDataType[] {
      FILE_SYSTEM,
      MMAP,
      RAM,
      MONGO_DB,
    };

	/**
   * A public read-only list of all the '<em><b>Index Data Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public static final List<IndexDataType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
   * Returns the '<em><b>Index Data Type</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
	public static IndexDataType get(String literal) {
    for (int i = 0; i < VALUES_ARRAY.length; ++i) {
      IndexDataType result = VALUES_ARRAY[i];
      if (result.toString().equals(literal)) {
        return result;
      }
    }
    return null;
  }

	/**
   * Returns the '<em><b>Index Data Type</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
	public static IndexDataType getByName(String name) {
    for (int i = 0; i < VALUES_ARRAY.length; ++i) {
      IndexDataType result = VALUES_ARRAY[i];
      if (result.getName().equals(name)) {
        return result;
      }
    }
    return null;
  }

	/**
   * Returns the '<em><b>Index Data Type</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
	public static IndexDataType get(int value) {
    switch (value) {
      case FILE_SYSTEM_VALUE: return FILE_SYSTEM;
      case MMAP_VALUE: return MMAP;
      case RAM_VALUE: return RAM;
      case MONGO_DB_VALUE: return MONGO_DB;
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
	private IndexDataType(int value, String name, String literal) {
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
	
} //IndexDataType
