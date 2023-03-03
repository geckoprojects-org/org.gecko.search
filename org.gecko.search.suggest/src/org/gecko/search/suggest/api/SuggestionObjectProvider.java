/**
 * Copyright (c) 2012 - 2023 Data In Motion and others.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made available under the terms of the 
 * Eclipse Public License v2.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *     Data In Motion - initial API and implementation
 */
package org.gecko.search.suggest.api;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.osgi.annotation.versioning.ProviderType;

/**
 * Object provider that defines the suggestion input and result
 * @author Ilenia Salvadori
 * @since Nov 8, 2018
 * @deprecated Use {@link SuggestionDescriptor} instead
 */
@ProviderType
public interface SuggestionObjectProvider {
	
	
	/**
	 * Returns the initial set of data, to be indexed. The list must not be <code>null</code> 
	 * @return the initial set of data, to be indexed
	 */
	public List<? extends EObject> getObjectStream();
	
	/**
	 * Returns the {@link EStructuralFeature}, to be indexed
	 * @return the {@link EStructuralFeature}, to be indexed
	 */
	public Set<EStructuralFeature> getFields();
	
	/**
	 * Returns the {@link EStructuralFeature} for the payload, usually the id feature
	 * @return the {@link EStructuralFeature} for the payload
	 */
	public EStructuralFeature getPayload();

	/**
	 * Returns different labeling/tagging for indexing
	 * @return different labeling/tagging for indexing
	 */
	public List<String> getLabels();
	
}
