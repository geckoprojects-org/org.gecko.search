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

import java.util.List;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import {{basePackageName}}.pojo.Person;

/**
 * Example Component
 */
@Component
public class PersonIndexComponent {
	
	@Reference
	private PersonIndexService pis;
	@Reference
	private PersonSearchService pss;
	
	/**
	 * Index and search
	 * @param ctx
	 */
	@Activate
	public void activate(BundleContext ctx) {
		System.out.println("Resetting index ...");
		pis.resetIndex();
		System.out.println("Indexing persons ...");
		Person p01 = createPerson("et", "Emil", "Tester", 42);
		Person p02 = createPerson("eta", "Emilia", "Testerowski", 23);
		Person p03 = createPerson("demo", "Peter", "Demonstrator", 12);
		pis.indexPerson(p01, true);
		pis.indexPerson(p02, true);
		pis.indexPerson(p03, true);
		
		System.out.println("Search persons 'Emi' ...");
		List<Person> byFirstName = pss.searchPersonsByFirstName("Emi", false);
		byFirstName.forEach(p->{
			System.out.println("[" + p.getId() + "] " + p.getFirstName() + " " + p.getLastName()  + " (" + p.getAge() + ")");
		});
	}
	
	/**
	 * Create a person
	 * @param id person id
	 * @param firstName person's first name
	 * @param lastName person' last name
	 * @param age persons age
	 * @return the created person
	 */
	private Person createPerson(String id, String firstName, String lastName, int age) {
		Person p = new Person();
		p.setId(id);
		p.setAge(age);
		p.setFirstName(firstName);
		p.setLastName(lastName);
		return p;
	}

}
