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
package org.gecko.search.converter.registry.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.gecko.search.converter.IIndexConverter;
import org.gecko.search.converter.registry.IIndexConverterRegistry;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;

/**
 * Implementation for the converter registry
 * @author Mark Hoffmann
 * @since 04.08.2014
 */
@Component(enabled = true)
public class IndexConverterRegistry implements IIndexConverterRegistry {
	
	private final Map<String, IIndexConverter> converterMap = new ConcurrentHashMap<String, IIndexConverter>();

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.index.core.registry.IIndexConverterRegistry#getConverter(java.lang.String)
	 */
	@Override
	public IIndexConverter getConverter(String converterId) {
		return converterMap.get(converterId);
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.index.core.registry.IIndexConverterRegistry#hasConverter(java.lang.String)
	 */
	@Override
	public boolean hasConverter(String converterId) {
		return converterMap.containsKey(converterId);
	}
	
	/**
	 * Registers the given converter
	 * @param converter the converter to register
	 */
	@Reference(policy = ReferencePolicy.DYNAMIC, cardinality = ReferenceCardinality.MULTIPLE)
	public void registerConverter(IIndexConverter converter) {
		if (converter != null && converter.getConverterId() != null) {
			converterMap.put(converter.getConverterId(), converter);
		}
	}
	
	/**
	 * Un-registers the given converter
	 * @param converter the converter to register
	 */
	public void unregisterConverter(IIndexConverter converter) {
		if (converter != null && converter.getConverterId() != null) {
			converterMap.remove(converter.getConverterId());
		}
	}

}
