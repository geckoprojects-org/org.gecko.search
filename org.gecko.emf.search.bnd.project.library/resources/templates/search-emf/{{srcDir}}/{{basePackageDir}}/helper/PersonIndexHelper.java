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
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.index.Term;
import org.gecko.emf.osgi.example.model.basic.BasicFactory;
import org.gecko.emf.osgi.example.model.basic.Person;
import org.gecko.emf.search.document.EObjectContextObjectBuilder;
import org.gecko.emf.search.document.EObjectDocumentIndexObjectContext;
import org.gecko.search.IndexActionType;
import org.gecko.search.document.context.ObjectContextObject;

/**
 * This is an Index Helper class where the actual document to be indexed is created.
 */
public class PersonIndexHelper {
	
	public static final String PERSON_ID = "person_id";
	public static final String PERSON_FIRST_NAME_LOWER = "person_first_name_lower";
	public static final String PERSON_LAST_NAME_LOWER = "person_last_name_lower";
	public static final String PERSON_FIRST_NAME = "person_first_name";
	public static final String PERSON_LAST_NAME = "person_last_name";

	
	public static EObjectDocumentIndexObjectContext mapPersonNew(Person person) {		
		return mapPerson(person, IndexActionType.ADD);
	}

	public static EObjectDocumentIndexObjectContext mapPersonUpdate(Person person) {
		return mapPerson(person, IndexActionType.MODIFY);
	}
	
	/**
	 * Maps a given {@link Person} to {@link ObjectContextObject} with a given {@link IndexActionType}
	 * @param person the person to index
	 * @param indexAction the index action (ADD, UPDATE, REMOVE)
	 * @return the {@link ObjectContextObject}
	 */
	public static EObjectDocumentIndexObjectContext mapPerson(Person person, IndexActionType indexAction) {
		
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
		EObjectContextObjectBuilder builder = (EObjectContextObjectBuilder) EObjectContextObjectBuilder.create().
				withDocuments(Collections.singletonList(doc)).
				withSourceObject(person).
				withIndexActionType(indexAction);

		if (IndexActionType.MODIFY.equals(indexAction) || IndexActionType.REMOVE.equals(indexAction)) {
			builder.withIdentifyingTerm(new Term("id", person.getId()));
		}

		return builder.build();
	}
	
	public static Person mapDocument(Document document) {
		Person p = BasicFactory.eINSTANCE.createPerson();
		getStringValue(document, PERSON_ID).ifPresent(p::setId);
		getStringValue(document, PERSON_FIRST_NAME).ifPresent(p::setFirstName);
		getStringValue(document, PERSON_LAST_NAME).ifPresent(p::setLastName);
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
}