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

import java.util.Collections;
import java.util.Optional;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.IntPoint;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.index.Term;
import org.gecko.search.IndexActionType;
import org.gecko.search.document.context.ObjectContextBuilder;
import org.gecko.search.document.context.ObjectContextObject;

import {{basePackageName}}.pojo.Person;

/**
 * This is an Index Helper class where the actual document to be indexed is created.
 */
public class PersonIndexHelper {
	
	public static final String PERSON_ID = "person_id";
	public static final String PERSON_FIRST_NAME_LOWER = "person_first_name_lower";
	public static final String PERSON_LAST_NAME_LOWER = "person_last_name_lower";
	public static final String PERSON_FIRST_NAME = "person_first_name";
	public static final String PERSON_LAST_NAME = "person_last_name";
	public static final String PERSON_AGE = "person_age";

	/**
	 * Creates a {@link ObjectContextObject} for a new added object
	 * @param person the person to add
	 * @return the {@link ObjectContextObject}
	 */
	public static ObjectContextObject mapPersonNew(Person person) {		
		return mapPerson(person, IndexActionType.ADD);
	}

	/**
	 * Creates a {@link ObjectContextObject} for a object to be updated
	 * @param person the person to update
	 * @return the {@link ObjectContextObject}
	 */
	public static ObjectContextObject mapPersonUpdate(Person person) {
		return mapPerson(person, IndexActionType.MODIFY);
	}
	
	/**
	 * Maps a given {@link Person} to {@link ObjectContextObject} with a given {@link IndexActionType}
	 * @param person the person to index
	 * @param indexAction the index action (ADD, UPDATE, REMOVE)
	 * @return the {@link ObjectContextObject}
	 */
	public static ObjectContextObject mapPerson(Person person, IndexActionType indexAction) {
		
		Document doc = new Document();
		
		doc.add(new StringField(PERSON_ID, person.getId(), Store.YES));

		if(person.getFirstName() != null) {
			doc.add(new StringField(PERSON_FIRST_NAME_LOWER, person.getFirstName().toLowerCase(), Store.NO));
			doc.add(new StringField(PERSON_FIRST_NAME, person.getFirstName(), Store.YES));
		}
		if(person.getLastName() != null) {
			doc.add(new StringField(PERSON_LAST_NAME_LOWER, person.getLastName().toLowerCase(), Store.NO));
			doc.add(new StringField(PERSON_LAST_NAME, person.getLastName(), Store.YES));
		}
		doc.add(new IntPoint(PERSON_AGE, person.getAge()));
		doc.add(new StoredField(PERSON_AGE, person.getAge()));

		ObjectContextBuilder builder = (ObjectContextBuilder) ObjectContextBuilder.create().
				withDocuments(Collections.singletonList(doc)).
				withSourceObject(person).
				withIndexActionType(indexAction);

		if (IndexActionType.MODIFY.equals(indexAction) || IndexActionType.REMOVE.equals(indexAction)) {
			builder.withIdentifyingTerm(new Term("id", person.getId()));
		}

		return builder.build();
	}
	
	public static Person mapDocument(Document document) {
		Person p = new Person();
		getStringValue(document, PERSON_ID).ifPresent(p::setId);
		getStringValue(document, PERSON_FIRST_NAME).ifPresent(p::setFirstName);
		getStringValue(document, PERSON_LAST_NAME).ifPresent(p::setLastName);
		getIntValue(document, PERSON_AGE).ifPresent(p::setAge);
		return p;
	}
	
	private static Optional<Object> getValue(Document doc, String fieldName) {
		IndexableField field = doc.getField(fieldName);
		if (field != null && field instanceof StoredField) {
			if (field.numericValue() != null) {
				return Optional.of((int)field.numericValue());
			} else {
				return Optional.of(field.stringValue());
			}
		}
		return Optional.empty();
	}
	
	private static Optional<String> getStringValue(Document doc, String fieldName) {
		return getValue(doc, fieldName).map(String.class::cast);
	}
	private static Optional<Integer> getIntValue(Document doc, String fieldName) {
		return getValue(doc, fieldName).map(Integer.class::cast);
	}
}

