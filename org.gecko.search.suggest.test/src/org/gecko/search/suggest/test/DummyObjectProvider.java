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
package org.gecko.search.suggest.test;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.gecko.emf.osgi.model.test.Person;
import org.gecko.emf.osgi.model.test.TestPackage;
import org.gecko.search.suggest.api.SuggestionObjectProvider;

/**
 * 
 * @author mark
 * @since 24.11.2018
 */
public class DummyObjectProvider implements SuggestionObjectProvider {
	
	private final List<Person> persons;

	/**
	 * Creates a new instance.
	 */
	public DummyObjectProvider(List<Person> persons) {
		this.persons = persons;
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.suggest.api.SuggestionObjectProvider#getObjectStream()
	 */
	@Override
	public List<? extends EObject> getObjectStream() {
		return persons;
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.suggest.api.SuggestionObjectProvider#getFields()
	 */
	@Override
	public Set<EStructuralFeature> getFields() {
		Set<EStructuralFeature> features = new HashSet<EStructuralFeature>();
		features.add(TestPackage.Literals.PERSON__LAST_NAME);
		return features;
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.suggest.api.SuggestionObjectProvider#getPayload()
	 */
	@Override
	public EStructuralFeature getPayload() {
		return TestPackage.Literals.PERSON__ID;
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.suggest.api.SuggestionObjectProvider#getLabels()
	 */
	@Override
	public List<String> getLabels() {
		return Collections.singletonList("person");
	}

}
