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
package org.gecko.search.index.core.provider.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.gecko.emf.utilities.FeaturePath;
import org.gecko.emf.utilities.LatLng;
import org.gecko.emf.utilities.UtilFactory;
import org.gecko.search.converter.IIndexConverter;
import org.gecko.search.converter.registry.IIndexConverterRegistry;
import org.gecko.search.index.core.SearchIndexException;
import org.gecko.search.index.core.provider.IIndexObjectProvider;
import org.gecko.search.index.core.registry.IIndexDescriptorRegistry;
import org.gecko.searchindex.FacetField;
import org.gecko.searchindex.FacetFieldObject;
import org.gecko.searchindex.IndexDescriptor;
import org.gecko.searchindex.IndexField;
import org.gecko.searchindex.IndexFieldObject;
import org.gecko.searchindex.IndexObject;
import org.gecko.searchindex.SearchIndexFactory;
import org.gecko.searchindex.SearchIndexPackage;
import org.gecko.searchindex.SpatialField;

/**
 * Default index object provider that creates one IndexObject from the given objects
 * 
 * XXX It looks like this implementation is very outdated and will never work..
 * @author Mark Hoffmann
 * @since 05.08.2014
 */
public class DefaultIndexObjectProvider implements IIndexObjectProvider {

	private IIndexConverterRegistry indexConverterRegistry;
	private IIndexDescriptorRegistry indexDescriptorRegistry;
	
	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.index.core.provider.IIndexObjectProvider#createIndexObjects(org.eclipse.emf.ecore.EObject[])
	 */
	@Override
	public List<IndexObject> createIndexObjects(EObject... objects) {
		EClass[] eclasses = getEClasses(objects);
		IndexDescriptor descriptor = indexDescriptorRegistry.getActiveIndexDescriptor(eclasses);
		if (descriptor == null) {
			return null;
		}
		IndexObject indexObject = SearchIndexFactory.eINSTANCE.createIndexObject();
		indexObject.setDescriptor(descriptor);
		indexObject.getObject().addAll(Arrays.asList(objects));
		for (IndexField field : descriptor.getFields()) {
			IndexFieldObject ifo = SearchIndexFactory.eINSTANCE.createIndexFieldObject();
			ifo.setField(field);
			Object value = null;
			if(field instanceof SpatialField){
				LatLng latLng = UtilFactory.eINSTANCE.createLatLng();
				latLng.setLatitude((double) getValue(((SpatialField) field).getLatitude(), objects));
				latLng.setLongitude((double) getValue(((SpatialField) field).getLongitude(), objects));
				value = latLng;
			} else {
				value = getValue(field.getFeature(), objects);
			}
			value = convert(value, field);
			ifo.setValue(value);
			indexObject.getFieldObjects().add(ifo);
		}
		if(descriptor.getFacetContext() != null){
			for(FacetField facetField : descriptor.getFacetContext().getFacetFields()){
				FacetFieldObject ffo = SearchIndexFactory.eINSTANCE.createFacetFieldObject();
				ffo.setField(facetField);
				Object value = null;
				if(facetField.getFeature() != null){
					value = getValue(facetField.getFeature());
				} else {
					value = getValue(facetField.getReferencedIndexField().getFeature());
				}
				ffo.setValue(value);
				indexObject.getFacetObjects().add(ffo);
			}
		}
		return Collections.singletonList(indexObject);
	}

	/**
	 * Sets the index desciptor registry
	 * @param indexDescriptorRegistry the registry to set
	 */
	public void setIndexDescriptorRegistry(IIndexDescriptorRegistry indexDescriptorRegistry) {
		this.indexDescriptorRegistry = indexDescriptorRegistry;
	}
	
	/**
	 * Un-Sets the index descriptor registry
	 * @param indexDescriptorRegistry the registry to unset
	 */
	public void unsetIndexDescriptorRegistry(IIndexDescriptorRegistry indexDescriptorRegistry) {
		this.indexDescriptorRegistry = null;
	}

	/**
	 * Sets the index converter registry
	 * @param indexConverterRegistry the index converter registry to unset
	 */
	public void setIndexConverterRegistry(IIndexConverterRegistry indexConverterRegistry) {
		this.indexConverterRegistry = indexConverterRegistry;
	}
	
	/**
	 * Un-sets the index converter registry
	 * @param indexConverterRegistry the index converter registry to set
	 */
	public void unsetIndexConverterRegistry(IIndexConverterRegistry indexConverterRegistry) {
		this.indexConverterRegistry = null;
	}
	
	/**
	 * Returns the {@link EClass}'es from the objects given as parameter
	 * @param objects the object to get eclasses from
	 */
	private EClass[] getEClasses(EObject... objects) {
		EClass[] eclasses = new EClass[objects.length];
		for (int i = 0; i < objects.length; i++) {
			eclasses[i] = objects[i].eClass();
		}
		return eclasses;
	}

	/**
	 * Converts the given value for the given index field
	 * @param value the value to convert
	 * @param field the index field with an optional converter
	 * @return the converted value or the original value
	 */
	private Object convert(Object value, IndexField field) {
		if (field == null || !field.eIsSet(SearchIndexPackage.Literals.INDEX_FIELD__CONVERTER)) {
			return value;
		}
		String converterId = field.getConverter().getConverterId();
		IIndexConverter converter = indexConverterRegistry.getConverter(converterId);
		if (converter != null) {
			value = converter.convert(value);
		}
		return value;
	}

	/**
	 * Returns the value for the feature path for the right object in the parameter array
	 * @param path the feature path
	 * @param objects the array of {@link EObject} the feature path belongs to
	 * @return the value or <code>null</code>
	 */
	private Object getValue(FeaturePath path, EObject... objects) {
		if (path == null || objects == null || objects.length == 0) {
			return null;
		}
		EStructuralFeature feature = path.getFeatures().get(0);
		EObject featureObject = null;
		// find the object that has this feature
		for (EObject o : objects) {
			if (o.eClass().getEAllStructuralFeatures().contains(feature)) {
				featureObject = o;
				break;
			}
		}
		// no object has the given feature
		if (featureObject == null) {
			return null;
		}
		return getFeaturePathValue(path, featureObject, 0);
	}

	/**
	 * Returns the value for a certain hierarchy of a feature path
	 * @param path the feature path
	 * @param currentObject the current object
	 * @param currentFeaturePathIndex the current index of the feature in the path
	 * @return the resulting object
	 */
	@SuppressWarnings("unchecked")
	private Object getFeaturePathValue(FeaturePath path, EObject currentObject, int currentFeaturePathIndex) {
		Object result = null;
		EStructuralFeature currentFeature = path.getFeatures().get(currentFeaturePathIndex);
		result = currentObject.eGet(currentFeature);
		if( result == null ){
			return null;
		}
		if (currentFeature instanceof EAttribute) {
			return result;
		}
		if (!(result instanceof EObject) && !(result instanceof EList<?>) && currentFeaturePathIndex < (path.getFeatures().size() - 1)) {
			throw new SearchIndexException("Error getting the value from feature path because result is no EObject but should be one");
		}
		int idx = ++currentFeaturePathIndex;
		if (result instanceof EList<?>) {
			EList<EObject> list = (EList<EObject>) result;
			List<Object> oList = new LinkedList<Object>();
			for (EObject eo : list) {
				Object o = getFeaturePathValue(path, eo, idx);
				if(o == null){
					continue;
				}
				if(o instanceof List){
					oList.addAll((Collection<? extends Object>) o);
				} else {
					oList.add(o);
				}
			}
			return oList;
		} else {
			return getFeaturePathValue(path, (EObject) result, idx);
		}
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.index.core.provider.IIndexObjectProvider#getIndexPath(org.eclipse.emf.ecore.EClass[])
	 */
	@Override
	public String getIndexPath(EClass... eClasses) {
		IndexDescriptor descriptor = indexDescriptorRegistry.getActiveIndexDescriptor(eClasses);
		if (descriptor == null) {
			return null;
		}
		return descriptor.getId();
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.index.core.provider.IIndexObjectProvider#getIdFieldObjects(org.eclipse.emf.ecore.EObject[])
	 */
	@Override
	public List<IndexFieldObject> getIdFieldObjects(EObject... objects) {
		return null;
	}

	@Override
	public String getAnalyizerid(EObject... objects) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAnalyizerid(IndexDescriptor descriptor) {
		// TODO Auto-generated method stub
		return null;
	}

}
