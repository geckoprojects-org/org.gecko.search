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

import static java.util.Objects.requireNonNull;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.FuzzyQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.WildcardQuery;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import {{basePackageName}}.helper.PersonIndexHelper;
import {{basePackageName}}.pojo.Person;

/**
 * This is a sample Search Service to retrieve the objects from the index
 */
@Component(service = PersonSearchService.class, immediate = true)
public class PersonSearchService {
	
	@Reference(target = "(id=test)")
	private ComponentServiceObjects<IndexSearcher> searcherSO;
	
	/**
	 * Executes a search by first name
	 * @param firstName the first name to look for persons
	 * @param exactMatch <code>true</code>, if the given first name should match exactly as given
	 * @return the matched documents
	 */
	public List<Person> searchPersonsByFirstName(String firstName, boolean exactMatch) {
		requireNonNull(firstName, "Cannot search Person by null firstName!");
		Query query;
		if(exactMatch) {
			query = new TermQuery(new Term(PersonIndexHelper.PERSON_FIRST_NAME, firstName));
			
		} else {
			Query q1 = new WildcardQuery(new Term(PersonIndexHelper.PERSON_FIRST_NAME_LOWER, "*" + firstName.toLowerCase() + "*"));
			Query q2 = new FuzzyQuery(new Term(PersonIndexHelper.PERSON_FIRST_NAME_LOWER, firstName.toLowerCase()));
			query = new BooleanQuery.Builder().add(q1, Occur.SHOULD).add(q2, Occur.SHOULD).build();
		}
		return executeTermSearch(query);
	}

	/**
	 * Executes a search by last name
	 * @param firstName the last name to look for persons
	 * @param exactMatch <code>true</code>, if the given last name should match exactly as given
	 * @return the matched documents
	 */
	public List<Person> searchPersonsByLastName(String lastName, boolean exactMatch) {
		requireNonNull(lastName, "Cannot search Person by null lastName!");
		Query query;
		if(exactMatch) {
			query = new TermQuery(new Term(PersonIndexHelper.PERSON_LAST_NAME, lastName));
			
		} else {
			Query q1 = new WildcardQuery(new Term(PersonIndexHelper.PERSON_LAST_NAME_LOWER, "*" + lastName.toLowerCase() + "*"));
			Query q2 = new FuzzyQuery(new Term(PersonIndexHelper.PERSON_LAST_NAME_LOWER, lastName.toLowerCase()));
			query = new BooleanQuery.Builder().add(q1, Occur.SHOULD).add(q2, Occur.SHOULD).build();
		}
		return executeTermSearch(query);
	}
	
	/**
	 * Executes the Lucene search
	 * @param query the {@link Query}
	 * @return the list of documents
	 */
	private List<Person> executeTermSearch(Query query) {

		IndexSearcher searcher = searcherSO.getService();
		try {
			TopDocs topDocs = searcher.search(query, Integer.MAX_VALUE);
			if (topDocs.scoreDocs.length == 0) {
				return Collections.emptyList();
			}
			return Arrays.asList(topDocs.scoreDocs).
					stream().
					map(sd -> sd.doc).map(id -> {
						Document d;
						try {
							d = searcher.getIndexReader().storedFields().document(id);
							return d;
						} catch (IOException e) {
							return null;
						}
					}).
					filter(Objects::nonNull).
					map(PersonIndexHelper::mapDocument).
					collect(Collectors.toList());
		} catch (Exception e) {
			System.err.println("Exception while search for Person with query " + query);
			e.printStackTrace();
			return Collections.emptyList();
		} finally {
			searcherSO.ungetService(searcher);
		}
	}

}
