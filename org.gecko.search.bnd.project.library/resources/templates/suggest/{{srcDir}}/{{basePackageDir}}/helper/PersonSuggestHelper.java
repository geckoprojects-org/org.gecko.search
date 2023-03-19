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
package {{basePackageName}}.helper;

import {{basePackageName}}.pojo.Person;

/**
 * This is an Index Helper class where the actual document to be indexed is created.
 */
public class PersonSuggestHelper {
	
	/**
	 * Create a person
	 * @param id person id
	 * @param firstName person's first name
	 * @param lastName person' last name
	 * @param age persons age
	 * @return the created person
	 */
	public static Person createPerson(String id, String firstName, String lastName, int age) {
		Person p = new Person();
		p.setId(id);
		p.setAge(age);
		p.setFirstName(firstName);
		p.setLastName(lastName);
		return p;
	}

}

