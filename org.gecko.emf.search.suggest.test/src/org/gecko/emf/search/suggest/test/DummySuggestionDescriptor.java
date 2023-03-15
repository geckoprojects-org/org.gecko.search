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
package org.gecko.emf.search.suggest.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.gecko.emf.osgi.example.model.basic.BasicPackage;
import org.gecko.emf.osgi.example.model.basic.Person;
import org.gecko.search.IndexType;
import org.gecko.search.suggest.api.SuggestionDescriptor;
import org.gecko.emf.search.suggest.api.EObjectSuggestionDescriptor;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.util.promise.PromiseFactory;

/**
 * 
 * @author Ilenia Salvadori
 * @since Feb 24, 2023
 */
@Component(name = "EObjectSuggestionDescriptor", service = SuggestionDescriptor.class, configurationPolicy=ConfigurationPolicy.REQUIRE)
public class DummySuggestionDescriptor implements EObjectSuggestionDescriptor {

	@Reference
	BasicPackage basicPackage;	

	private PromiseFactory factory = new PromiseFactory(Executors.newFixedThreadPool(4));
	List<EObject> persons = new ArrayList<>();

	@Activate
	public void activate() {
		factory.submit(() -> {
			initialize();
			return true;
		}).onSuccess(t -> System.out.println("Finished!"))
		.onFailure(t -> t.printStackTrace());	
	}

	private void initialize() {

		for (int i = 0; i < 10; i++) {
			Person p = basicPackage.getBasicFactory().createPerson();
			p.setFirstName("Emil-" + i);
			p.setLastName("Tester-" + i);
			p.setId("et-" + i);
			persons.add(p);
		}
	}

	@Deactivate
	public void deactivate() {
		if(persons != null) persons.clear();
	}


	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.api.IndexDescriptor#getName()
	 */
	@Override
	public String getName() {
		return null;
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.api.IndexDescriptor#getIndexType()
	 */
	@Override
	public IndexType getIndexType() {
		return IndexType.INDEX;
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.suggest.api.SuggestionDescriptor#getObjectStream()
	 */
	@Override
	public Stream<EObject> getObjectStream() {
		return persons.stream();
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.suggest.api.SuggestionDescriptor#getFields()
	 */
	@Override
	public Set<EStructuralFeature> getFields() {
		Set<EStructuralFeature> features = new HashSet<EStructuralFeature>();
		features.add(basicPackage.getPerson_LastName());
		return features;
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.suggest.api.SuggestionDescriptor#getPayload()
	 */
	@Override
	public EStructuralFeature getPayload() {
		return basicPackage.getPerson_Id();
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.suggest.api.SuggestionDescriptor#getLabels()
	 */
	@Override
	public List<String> getLabels() {
		return Collections.singletonList("person");
	}

}
