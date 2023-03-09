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
package org.gecko.search.suggest.test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

import org.gecko.search.api.IndexType;
import org.gecko.search.suggest.api.SuggestionDescriptor;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.util.promise.PromiseFactory;


/**
 * 
 * @author Ilenia Salvadory
 * @since 24.022023
 */
@Component(name = "ObjectSuggestionDescriptor", service = SuggestionDescriptor.class, configurationPolicy=ConfigurationPolicy.REQUIRE)
public class DummySuggestionDescriptor implements SuggestionDescriptor<Object, Field> {
	
	public static class Person {
		public String firstName;
		public String lastName;
		public long id;
	}

	private PromiseFactory factory = new PromiseFactory(Executors.newFixedThreadPool(4));
	List<Object> persons = new ArrayList<>();

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
			Person p = new Person();
			p.firstName = "Emil-" + i;
			p.lastName = "Tester-" + i;
			p.id = i;
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
		return Person.class.getName();
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
	public Stream<Object> getObjectStream() {
		return persons.stream();
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.suggest.api.SuggestionDescriptor#getFields()
	 */
	@Override
	public Set<Field> getFields() {
		Set<Field> features = new HashSet<Field>();
		try {
			features.add(Person.class.getField("lastName"));
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return features;
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.suggest.api.SuggestionDescriptor#getPayload()
	 */
	@Override
	public Field getPayload() {
		try {
			return Person.class.getField("id");
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return null;
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
