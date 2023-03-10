/**
 * Copyright (c) 2012 - 2023 Data In Motion and others.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *     Data In Motion - initial API and implementation
 */
package org.gecko.search.util;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.function.Predicate;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.StringField;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.BasicEObjectImpl;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * {@link Document} helper class
 * @author ilenia
 * @since Mar 19, 2021
 */
public class DocumentUtil {
	
	/**
	 * Option to provide a list of EStructuralFeatures that can be ignored for the index
	 */
	public static final String IGNORE_FEATURE_LIST = "ignore.feature.list";
	
	/**
	 * Option to specify whether non-containment reference should be index or not.
	 * If not provided, <code>false<code> will be used as default value.
	 */
	public static final String INDEX_NON_CONTAINEMENT = "index.non.containment";
	
	public static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

	static
	{
		SDF.setTimeZone(TimeZone.getTimeZone("UTC"));
	}

	/** _E_CLASS_URI */
	private static final String _E_CLASS_URI = "_eClassUri";
	/** _NULL */
	private static final String _NULL = "_NULL_";	
	/** _PROXY_URI */
	private static final String _PROXY_URI = "_proxyUri";

	
	public static void toDocument(Document doc, EObject eObject, Map<Object, Object> options) {
		toDocument(doc, eObject, "", options);
	}

	public static void toDocument(Document doc, EObject eObject) {
		toDocument(doc, eObject, "", Collections.emptyMap());
	}

	@SuppressWarnings("unchecked")
	public static void toDocument(Document doc, EObject eObject, String prefix, Map<Object, Object> options) {
		
		boolean saveNonContainmentAsProxy = options.containsKey(INDEX_NON_CONTAINEMENT) ? (Boolean) options.get(INDEX_NON_CONTAINEMENT) : false;
		if(saveNonContainmentAsProxy && eObject.eIsProxy()) {
			doc.add(new StringField(prefix + _PROXY_URI, EcoreUtil.getURI(eObject).toString(), Store.YES));
		}
		doc.add(new StringField(prefix + _E_CLASS_URI, EcoreUtil.getURI(eObject.eClass()).toString(), Store.YES));
		
		Predicate<EStructuralFeature> ignoreFeaturePred = r -> true;
		if(options.containsKey(IGNORE_FEATURE_LIST)) {
			List<String> excludedFeatureNames = (List<String>) options.get(IGNORE_FEATURE_LIST);
			ignoreFeaturePred = r -> !excludedFeatureNames.contains(r.getName());
		}
		
		eObject.eClass().getEAllAttributes().stream().filter(ignoreFeaturePred).forEach(a -> {
			Object value = eObject.eGet(a);
			if(value != null) {
				if(!a.isMany()) {
					if(value instanceof Date) {
						Date date = (Date) value;
						String dateStr = SDF.format(date);
						doc.add(new StringField(prefix +  a.getName(), dateStr, Store.YES));
					}
					else {
						doc.add(new StringField(prefix + a.getName(), EcoreUtil.convertToString(a.getEAttributeType(), value), Store.YES));
					}
				} else {
					Collection<Object> values = (Collection<Object>) value;
					int i = 0;
					
					for(Object v : values) {
						if(v != null) {
							if(v instanceof Date) {
								Date date = (Date) v;
								String dateStr = SDF.format(date);
								doc.add(new StringField(prefix +  a.getName() + "." +  i++  , dateStr, Store.YES));
							}
							else {
								doc.add(new StringField(prefix +  a.getName() + "." +  i++  , EcoreUtil.convertToString(a.getEAttributeType(), v), Store.YES));
							}
						} else {
							doc.add(new StringField(prefix +  a.getName() + "." +  i++  , _NULL , Store.YES));
						}
					}
				}
			}
		});

		Predicate<EReference> predicate = r -> true;
		Predicate<EReference> containmentPred = r -> true;
		
		if(!saveNonContainmentAsProxy) {
			containmentPred = r-> r.isContainment();
		}
		predicate = containmentPred.and(ignoreFeaturePred);
		
		eObject.eClass().getEAllReferences().stream().filter(predicate).forEach(r -> {
			Object value = eObject.eGet(r);
			if(value != null) {
				String newPrefix = prefix + r.getName() + ".";
				if(value instanceof EObject) {
					toDocument(doc, (EObject) value, newPrefix, options);
				}
				else if(r.isMany()) {					
					BasicEList<EObject> values = (BasicEList<EObject>) value;
					for(int i = 0 ; i < values.size(); i++) {
						EObject v = values.basicGet(i);
						if(v != null && v instanceof EObject) {
							toDocument(doc, (EObject) v, newPrefix + i + ".", options);
						} else {
							doc.add(new StringField(newPrefix + _E_CLASS_URI +  i  , _NULL , Store.YES));
						}
					}
				}
			}
		});
	}		

	public static EObject toEObject(Document doc, ResourceSet set) {
		return toEObject(doc, "", set, Collections.emptyMap());
	}
	
	public static EObject toEObject(Document doc, ResourceSet set, Map<Object, Object> options) {
		return toEObject(doc, "", set, options);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static EObject toEObject(Document doc, String prefix, ResourceSet set, Map<Object, Object> options) {
		String uri = doc.get(prefix + _E_CLASS_URI);
		if(uri == null || _NULL.equals(uri)) {
				return null;			
		}
		String proxyUri = doc.get(prefix + _PROXY_URI);
		boolean isProxy = proxyUri != null;
		
		URI theUri = URI.createURI(uri);
		EObject eObject = set.getEObject(theUri, true);

		if(eObject == null) {
			throw new IllegalStateException("no EClass found for " + uri + " at prefix " + prefix);
		}
		if(!(eObject instanceof EClass)) {
			throw new IllegalStateException(prefix + "_eClassUri value " + uri + " is no EClass but an " + eObject.eClass().getName());
		}

		EClass eClass = (EClass) eObject;
		EObject result = EcoreUtil.create(eClass);

		Predicate<EStructuralFeature> ignoreFeaturePred = r -> true;
		if(options.containsKey(IGNORE_FEATURE_LIST)) {
			List<String> excludedFeatureNames = (List<String>) options.get(IGNORE_FEATURE_LIST);
			ignoreFeaturePred = r -> !excludedFeatureNames.contains(r.getName());
		}
		
		eClass.getEAllAttributes().stream().filter(ignoreFeaturePred).forEach(a -> {
			if(!a.isMany()) {
				String valueString = doc.get(prefix + a.getName());
				Object value = null;
				if(valueString != null) {
					value = EcoreUtil.createFromString(a.getEAttributeType(), valueString);
				}
				result.eSet(a, value);
			} else {
				Collection values = (Collection) result.eGet(a);
				int i = 0;
				String valueString = doc.get(prefix + a.getName() + "." + i++);
				while(valueString != null) {
					if(_NULL.equals(valueString)) {
						values.add(null);
					} else {
						values.add(EcoreUtil.createFromString(a.getEAttributeType(), valueString));
					}
					valueString = doc.get(prefix + a.getName() + "." + i++);
				}
			}
		});

		eClass.getEAllReferences().stream().filter(ignoreFeaturePred).forEach(r -> {
			String newPrefix = prefix + r.getName() + ".";
			if(!r.isMany()) {
				result.eSet(r, toEObject(doc, newPrefix, set, options));
			} else {
				Collection values = (Collection) result.eGet(r);
				int i = 0;
				String countedPrefix = newPrefix + i++ + ".";
				String valueString = doc.get(countedPrefix + _E_CLASS_URI); 
				while(valueString != null) {
					if(_NULL.equals(valueString)) {
						values.add(null);
					} else {
						values.add(toEObject(doc, countedPrefix, set, options));
					}
					countedPrefix = newPrefix + i++ + ".";
					valueString = doc.get(countedPrefix + _E_CLASS_URI); 
				}
			}
		});
		if(isProxy) {
			BasicEObjectImpl basicEObj = (BasicEObjectImpl) result;
			((InternalEObject) basicEObj).eSetProxyURI(URI.createURI(proxyUri));
			return basicEObj;
		}
		return result;
	}

}
