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

import java.io.IOException;

import org.gecko.emf.osgi.example.model.basic.Person;
import org.gecko.emf.search.document.EObjectDocumentIndexObjectContext;
import org.gecko.search.IndexActionType;
import org.gecko.search.document.LuceneIndexService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import {{basePackageName}}.helper.PersonIndexHelper;

/**
 * This is a sample Index Service to index objects.
 */
@Component(service = PersonIndexService.class, immediate = true)
public class PersonIndexService {

	@Reference(target = "(id=test)")
	private LuceneIndexService<EObjectDocumentIndexObjectContext> personIndex;
	
	/**
	 * Indexes a person as add, if paramter add is set to <code>true</code>
	 * @param person the person to be added
	 * @param add set to <code>true</code>, for adding, <code>false</code> for updating
	 */
	public void indexPerson(Person person, boolean add) {
		if(add) {
			indexPerson(person, IndexActionType.ADD);
		}
		else {
			indexPerson(person, IndexActionType.MODIFY);
		}	
	}

	/**
	 * Deletes a person from the index
	 * @param person the peron to delete
	 */
	public void deletePerson(Person person) {
		indexPerson(person, IndexActionType.REMOVE);		
	}

	/**
	 * Resets the whle index
	 */
	public void resetIndex() {
		try {
			personIndex.getIndexWriter().deleteAll();
			personIndex.commit();
		} catch (IOException e) {
			System.err.println("Could not delete Person index " + e);
		}		
		
	}
	
	private void indexPerson(Person person, IndexActionType actionType) {
		EObjectDocumentIndexObjectContext context = PersonIndexHelper.mapPerson(person, actionType);			
		personIndex.handleContextSync(context);
	}
	
}