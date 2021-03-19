/**
 * Copyright (c) 2012 - 2021 Data In Motion and others.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Data In Motion - initial API and implementation
 */
package org.gecko.search.util;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
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
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.BasicEObjectImpl;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * 
 * @author ilenia
 * @since Mar 19, 2021
 */
public class DocumentUtil {
	
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


	public static void toDocument(Document doc, EObject eObject, boolean saveNonContainmentAsProxy) {
		toDocument(doc, eObject, "", saveNonContainmentAsProxy);
	}

	public static void toDocument(Document doc, EObject eObject) {
		toDocument(doc, eObject, false);
	}

	@SuppressWarnings("unchecked")
	public static void toDocument(Document doc, EObject eObject, String prefix, boolean saveNonContainmentAsProxy) {
		if(saveNonContainmentAsProxy && eObject.eIsProxy()) {
			doc.add(new StringField(prefix + _PROXY_URI, EcoreUtil.getURI(eObject).toString(), Store.YES));
		}
		doc.add(new StringField(prefix + _E_CLASS_URI, EcoreUtil.getURI(eObject.eClass()).toString(), Store.YES));
		eObject.eClass().getEAllAttributes().forEach(a -> {
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
		if(!saveNonContainmentAsProxy) {
			predicate = r-> r.isContainment();
		}
		eObject.eClass().getEAllReferences().stream().filter(predicate).forEach(r -> {
			Object value = eObject.eGet(r);
			if(value != null) {
				String newPrefix = prefix + r.getName() + ".";
				if(value instanceof EObject) {
					toDocument(doc, (EObject) value, newPrefix, saveNonContainmentAsProxy);
				}
				else if(value instanceof EObjectContainmentEList) {					
					Collection<Object> values = (Collection<Object>) value;
					int i = 0;
					for( Object v : values) {
						if(v != null && v instanceof EObject) {
							toDocument(doc, (EObject) v, newPrefix + i++ + ".", saveNonContainmentAsProxy);
						} else {
							doc.add(new StringField(newPrefix + _E_CLASS_URI +  i++  , _NULL , Store.YES));
						}
					}
				}
				else if(value instanceof EObjectResolvingEList) {
					BasicEList<EObject> values = (BasicEList<EObject>) value;
					int i = 0;
					for(Object v : values) {
						if(v != null && v instanceof EObject) {
							toDocument(doc, (EObject) v, newPrefix + i++ + ".", saveNonContainmentAsProxy);
						} else {
							doc.add(new StringField(newPrefix + _PROXY_URI +  i++  , _NULL , Store.YES));
						}
					}	
				}
			}
		});
	}		

	public static EObject toEObject(Document doc, ResourceSet set) {
		return toEObject(doc, "", set);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static EObject toEObject(Document doc, String prefix, ResourceSet set) {
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

		eClass.getEAllAttributes().forEach(a -> {
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

		eClass.getEAllReferences().stream().forEach(r -> {
			String newPrefix = prefix + r.getName() + ".";
			if(!r.isMany()) {
				result.eSet(r, toEObject(doc, newPrefix, set));
			} else {
				Collection values = (Collection) result.eGet(r);
				int i = 0;
				String countedPrefix = newPrefix + i++ + ".";
				String valueString = doc.get(countedPrefix + _E_CLASS_URI); 
				while(valueString != null) {
					if(_NULL.equals(valueString)) {
						values.add(null);
					} else {
						values.add(toEObject(doc, countedPrefix, set));
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
