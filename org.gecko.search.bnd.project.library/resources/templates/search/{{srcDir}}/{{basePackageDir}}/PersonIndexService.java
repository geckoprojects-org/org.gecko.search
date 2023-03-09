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

import org.gecko.search.api.IndexActionType;
import org.gecko.search.document.DocumentIndexContextObject;
import org.gecko.search.document.LuceneIndexService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import {{basePackageName}}.helper.PersonIndexHelper;
import {{basePackageName}}.pojo.Person;


/**
 * This is a sample Index Service to index objects.
 * 
 * @author ilenia
 * @since Feb 20, 2023
 */
@Component(name = "PersonIndexService", service = PersonIndexService.class, scope = ServiceScope.SINGLETON)
public class PersonIndexService {

	@Reference(target = "(id=test)")
	private LuceneIndexService personIndex;
	
	private PromiseFactory factory = new PromiseFactory(Executors.newFixedThreadPool(4));
	
	private AtomicInteger counter = new AtomicInteger(0);
	
	
	public void indexPerson(Person person, boolean isFirstSave) {
		if(isFirstSave) {
			indexPerson(person, IndexActionType.ADD);
		}
		else {
			indexPerson(person, IndexActionType.MODIFY);
		}	
	}


	public void deletePerson(Person person) {
		indexPerson(person, IndexActionType.REMOVE);		
	}

	
	public void resetIndex() {
		try {
			personIndex.getIndexWriter().deleteAll();
			personIndex.commit();
		} catch (IOException e) {
			System.err.println("Could not delete Person index " + e);
		}		
		
	}
	
	private void indexPerson(Person person, IndexActionType actionType) {
		DocumentIndexContextObject context = PersonIndexHelper.mapPerson(person, actionType, null);			
		personIndex.handleContextSync(context);
	}
	

}
