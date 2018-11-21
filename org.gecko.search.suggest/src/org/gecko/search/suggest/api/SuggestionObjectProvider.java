/**
 * Copyright (c) 2012 - 2018 Data In Motion and others.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
 * 
 * @author ilenia
 * @since Nov 8, 2018
 */
@ProviderType
public interface SuggestionObjectProvider {
	
	
	public List<EObject> getSampleObjects();
	
	public Set<EStructuralFeature> getFields();
	
	public EStructuralFeature getPayload();

	public List<String> getLabels();
	
	

}
