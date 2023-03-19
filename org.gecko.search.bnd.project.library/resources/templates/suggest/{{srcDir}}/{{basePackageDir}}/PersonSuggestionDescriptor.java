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
package {{basePackageName}};

import static {{basePackageName}}.helper.PersonSuggestHelper.createPerson;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.gecko.search.IndexType;
import org.gecko.search.suggest.api.SuggestionDescriptor;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

import {{basePackageName}}.pojo.Person;

/**
 * Descriptor Person's for suggestion
 */
@Component(immediate = true, property = "descriptor=Person")
public class PersonSuggestionDescriptor implements SuggestionDescriptor<Person, Field> {
	
	private List<Person> persons;

	@Activate
	public void activate() {
		Person p01 = createPerson("et", "Emil", "Tester", 42);
		Person p02 = createPerson("eta", "Emilia", "Testerowski", 23);
		Person p03 = createPerson("demo", "Peter", "Demonstrator", 12);
		persons = List.of(p01, p02, p03);
	}
	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.IndexDescriptor#getName()
	 */
	@Override
	public String getName() {
		return Person.class.getSimpleName();
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.IndexDescriptor#getIndexType()
	 */
	@Override
	public IndexType getIndexType() {
		return IndexType.SUGGEST;
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.suggest.api.SuggestionDescriptor#getObjectStream()
	 */
	@Override
	public Stream<Person> getObjectStream() {
		return persons == null ? Stream.empty() : persons.stream();
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.suggest.api.SuggestionDescriptor#getFields()
	 */
	@Override
	public Set<Field> getFields() {
		try {
			Field fnf = Person.class.getField("firstName");
			Field lnf = Person.class.getField("lastName");
			return Set.of(fnf, lnf);
		} catch (Exception e) {
			throw new IllegalStateException("Cannot find field 'id' in Person.class", e);
		}
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.suggest.api.SuggestionDescriptor#getPayload()
	 */
	@Override
	public Field getPayload() {
		try {
			return Person.class.getField("id");
		} catch (Exception e) {
			throw new IllegalStateException("Cannot find field 'id' in Person.class", e);
		}
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.suggest.api.SuggestionDescriptor#getLabels()
	 */
	@Override
	public List<String> getLabels() {
		return List.of("firstName", "lastName");
	}

}
