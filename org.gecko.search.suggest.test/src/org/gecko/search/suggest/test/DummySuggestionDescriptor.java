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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.gecko.emf.osgi.example.model.basic.BasicPackage;
import org.gecko.emf.osgi.example.model.basic.Person;
import org.gecko.search.api.IndexType;
import org.gecko.search.suggest.api.SuggestionDescriptor;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.util.promise.PromiseFactory;


/**
 * 
 * @author ilenia
 * @since Feb 24, 2023
 */
@Component(service = SuggestionDescriptor.class, configurationPolicy=ConfigurationPolicy.REQUIRE, configurationPid = "SuggestionDescriptor")
public class DummySuggestionDescriptor implements SuggestionDescriptor {

	@Reference
	BasicPackage basicPackage;	

	private PromiseFactory factory = new PromiseFactory(Executors.newFixedThreadPool(4));
	List<Person> persons = new ArrayList<>();

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
	public List<? extends EObject> getObjectStream() {
		return persons;
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
