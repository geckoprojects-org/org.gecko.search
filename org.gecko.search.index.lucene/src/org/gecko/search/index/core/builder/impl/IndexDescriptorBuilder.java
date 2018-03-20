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
package org.gecko.search.index.core.builder.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.gecko.emf.utilities.FeaturePath;
import org.gecko.emf.utilities.UtilFactory;
import org.gecko.search.index.core.SearchIndexException;
import org.gecko.search.index.core.builder.IIndexDescriptorBuilder;
import org.gecko.searchindex.IndexDescriptor;
import org.gecko.searchindex.IndexField;
import org.gecko.searchindex.IndexFieldType;
import org.gecko.searchindex.IndexType;
import org.gecko.searchindex.SearchIndexFactory;
import org.gecko.searchindex.StoreType;
import org.gecko.searchindex.TermVectorType;

/**
 * Implementation for the {@link IndexDescriptorBuilder}
 * @author Mark Hoffmann
 * @since 11.07.2014
 */
public class IndexDescriptorBuilder implements IIndexDescriptorBuilder {

	public static final String ID_PREFIX = "_desc";
	private boolean followContainment = false;
	private int followDepth = 1;
	private final List<EReference> referenceCache = new LinkedList<EReference>();
	private final List<EClass> eclassCache = new LinkedList<EClass>();

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.index.core.builder.IIndexDescriptorBuilder#createIndexDescriptor(org.eclipse.emf.ecore.EClass[])
	 */
	@Override
	public IndexDescriptor createIndexDescriptor(EClass... eclasses) {
		return createIndexDescriptor(null, eclasses);
	}
	
	/**
	 * Creates an index descriptor or atteches new fields to the given index descriptor 
	 * @param descriptor the index descriptor, if <code>null</code> a new one will be created
	 * @param eclasses the {@link EClass}'es to parse
	 * @return the index descriptor
	 */
	public IndexDescriptor createIndexDescriptor(IndexDescriptor descriptor, EClass... eclasses) {
		checkValidEClasses(eclasses);
		if (descriptor == null) {
			descriptor = SearchIndexFactory.eINSTANCE.createIndexDescriptor();
		}
		for (EClass eclass : eclasses) {
			if (eclassCache.contains(eclass)) {
				continue;
			}
			descriptor.getClasses().add(eclass);
			List<IndexField> fields = createIndexFields(eclass, 0, null);
			if (fields != null) {
				descriptor.getFields().addAll(fields);
			}
			eclassCache.add(eclass);
		}
		String id = generateId(eclasses);
		descriptor.setId(id);
		return descriptor;
	}
	
	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.index.core.builder.IIndexDescriptorBuilder#setFollowContainment(boolean, int)
	 */
	@Override
	public void setFollowContainment(boolean follow, int depth) {
		this.followContainment = follow;
		this.followDepth = depth > 0 ? depth : 1;
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.index.core.builder.IIndexDescriptorBuilder#setFollowContainment(boolean)
	 */
	@Override
	public void setFollowContainment(boolean follow) {
		this.setFollowContainment(follow, 1);
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.index.core.builder.IIndexDescriptorBuilder#isFollowContainment()
	 */
	@Override
	public boolean isFollowContainment() {
		return followContainment;
	}

	/**
	 * Creates a list of index fields from a given {@link EClass}
	 * @param eclass the eclass to create the index fields from
	 * @param parent the parent {@link EReference}, can be <code>null</code>
	 * @param currentDepth the current depth in the containment hierarchy
	 * @param path the existing feature patj
	 * @return the list of index fields or <code>null</code>
	 */
	private List<IndexField> createIndexFields(EClass eclass, int currentDepth, FeaturePath path) {
		if (eclass == null) {
			return null;
		}
		List<IndexField> fields = new LinkedList<IndexField>();
		for (EAttribute attribute : eclass.getEAllAttributes()) {
			IndexField field = createIndexField(attribute, path);
			if (field != null) {
				fields.add(field);
			}
		}
		// early break if we reached the final hierarchy depth
		if (currentDepth == followDepth) {
			return fields;
		}
		FeaturePath featurePath = path;
		for (EReference reference : eclass.getEAllReferences()) {
			if (reference.isContainment() && 
					isFollowContainment() && 
					!referenceCache.contains(reference)) {
				referenceCache.add(reference);
				if (path == null) {
					featurePath = UtilFactory.eINSTANCE.createFeaturePath();
				} else {
					featurePath = EcoreUtil.copy(path);
				}
				featurePath.getFeatures().add(reference);
				EClass containmentClass = reference.getEReferenceType();
				if (eclassCache.contains(containmentClass)) {
					continue;
				}
				List<IndexField> containmentFields = createIndexFields(containmentClass, currentDepth + 1, featurePath);
				fields.addAll(containmentFields);
				if (path == null) {
					eclassCache.clear();
					referenceCache.clear();
					featurePath = null;
				}
			} 
		}
		return fields;
	}

	/**
	 * Creates an {@link IndexField} from a given {@link EAttribute}
	 * @param attribute the {@link EAttribute} to create the index field from
	 * @param parent the parent feature, can be <code>null</code>
	 * @param path the feature path
	 * @return the {@link IndexField} or <code>null</code>
	 */
	private IndexField createIndexField(EAttribute attribute, FeaturePath path) {
		if (attribute == null) {
			return null;
		}
		IndexField field = SearchIndexFactory.eINSTANCE.createIndexField();
		FeaturePath featurePath = UtilFactory.eINSTANCE.createFeaturePath();
		featurePath.setId(EcoreUtil.generateUUID());
		if (path != null) {
			featurePath.getFeatures().addAll(path.getFeatures());
		} 
		featurePath.getFeatures().add(attribute);
		field.setFeature(featurePath);
		if (attribute.isID()) {
			field.setIdField(true);
			field.setPkField(true);
			field.setStore(StoreType.YES);
			field.setTermVector(TermVectorType.NO);
			field.setIndex(IndexType.NO);
		}
		field.setKey(featurePath.getKey());
		boolean check = false;
		check = checkNumericDate(field, attribute);
		if (check) {
			return field;
		}
		check = checkString(field, attribute);
		if (check) {
			return field;
		}
		check = checkEnumBoolean(field, attribute);
		if (check) {
			return field;
		}
		return null;
	}

	/**
	 * Checks if the attribute is an enumeration
	 * @param field the field to update
	 * @param attribute the attribute to check
	 * @return <code>true</code>, if the check was successful
	 */
	private boolean checkEnumBoolean(IndexField field, EAttribute attribute) {
		if (attribute == null || field == null) {
			return false;
		}
		EDataType dataType = attribute.getEAttributeType();
		Class<?> dataTypeClass = dataType.getInstanceClass();
		if (dataType instanceof EEnum || dataTypeClass == Boolean.TYPE) {
			field.setIndex(IndexType.NOT_ANALYZED_NO_NORMS);
			field.setOmitNorms(true);
			field.setStore(StoreType.YES);
			field.setTermVector(TermVectorType.NO);
			return true;
			
		}
		return false;
	}

	/**
	 * Checks if the attribute is a {@link String}
	 * @param field the field to update
	 * @param attribute the attribute to check
	 * @return <code>true</code>, if the check was successful
	 */
	private boolean checkString(IndexField field, EAttribute attribute) {
		if (attribute == null || field == null) {
			return false;
		}
		EDataType dataType = attribute.getEAttributeType();
		Class<?> dataTypeClass = dataType.getInstanceClass();
		if (dataTypeClass != String.class) {
			return false;
		}
		// check for primary key
		if (attribute.isID()) {
			field.setIndex(IndexType.NO);
			field.setStore(StoreType.YES);
			field.setTermVector(TermVectorType.NO);
			return true;
		}
		// check for unique keys; unique==true in EMF means the value can occur more than once
		if (!attribute.isUnique()) {
			field.setIndex(IndexType.NOT_ANALYZED_NO_NORMS);
			field.setStore(StoreType.YES);
			field.setTermVector(TermVectorType.NO);
			return true;
		}
		// set default values
		field.setIndex(IndexType.ANALYZED);
		if (attribute.isTransient()) {
			field.setStore(StoreType.NO);
		} else {
			field.setStore(StoreType.YES);
		}
		field.setTermVector(TermVectorType.WITH_POSTION_OFFSETS);
		return true;
	}

	/**
	 * Checks if the feature is a numeric field 
	 * @param field the field to update
	 * @param attribute the attribute to check
	 * @return <code>true</code>, if the attribute is a number
	 */
	private boolean checkNumericDate(IndexField field, EAttribute attribute) {
		if (attribute == null || field == null) {
			return false;
		}
		EDataType dataType = attribute.getEAttributeType();
		Class<?> dataTypeClass = dataType.getInstanceClass();
		if (dataTypeClass == null) {
			return false; 
		}
		if (dataTypeClass ==Float.TYPE) {
			field.setType(IndexFieldType.FLOAT); 
		} else if (dataTypeClass == BigInteger.class || dataTypeClass == Integer.TYPE) {
			field.setType(IndexFieldType.INT); 
		} else if (dataTypeClass == BigDecimal.class || dataTypeClass == Double.TYPE) {
			field.setType(IndexFieldType.DOUBLE); 
		} else if (dataTypeClass == Date.class || dataTypeClass == Long.TYPE) {
			field.setType(IndexFieldType.LONG); 
		} else if (dataTypeClass == Integer.TYPE) {
			field.setType(IndexFieldType.INT); 
		} else {
			return false;
		}
		return true;
	}

	/**
	 * Creates the id for the descriptor
	 * @param eclasses the {@link EClass}'es to generate an id from
	 * @return the id string
	 */
	protected String generateId(EClass[] eclasses) {
		checkValidEClasses(eclasses);
		String id = ID_PREFIX;
		for (EClass eclass : eclasses) {
			id += "-" + eclass.getName();
		}
		return id;
	}

	/**
	 * Checks if the eclasses argument is valid
	 * @param eclasses the {@link EClass}'es to check
	 */
	protected void checkValidEClasses(EClass[] eclasses) {
		if (eclasses == null || eclasses.length == 0) {
			throw new SearchIndexException("Invalid eclasses paremter. The parameter is null or an empty array");
		}
	}

}
