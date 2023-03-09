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
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.eclipse.emf.ecore.EObject;
import org.gecko.emf.mongo.Options;
import org.gecko.emf.osgi.ResourceSetFactory;
import org.gecko.emf.osgi.UriMapProvider;
import org.gecko.emf.pushstream.EPushStreamProvider;
import org.gecko.emf.repository.EMFRepository;
import org.gecko.emf.repository.query.IQuery;
import org.gecko.emf.repository.query.QueryRepository;
import org.gecko.emf.osgi.example.model.basic.Person;
import org.gecko.emf.osgi.example.model.basic.BasicPackage;
import org.gecko.search.api.IndexActionType;
import org.gecko.search.document.DocumentIndexContextObject;
import org.gecko.search.document.LuceneIndexService;
import org.gecko.util.pushstreams.GeckoPushbackPolicyOption;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ServiceScope;
import org.osgi.util.promise.Promise;
import org.osgi.util.promise.PromiseFactory;
import org.osgi.util.pushstream.PushEvent;
import org.osgi.util.pushstream.PushStream;
import org.osgi.util.pushstream.QueuePolicyOption;

import {{basePackageName}}.helper.PersonIndexHelper;



/**
 * This is a sample Index Service to index EObjects. It references to both an EMF model, which is the model from which the 
 * objects to be indexed come from; and to a mongo repository, where such objects are also stored.
 * At the component activation, all objects of that type present in the mongodb will be re-indexed.
 * @author ilenia
 * @since Feb 20, 2023
 */
@Component(name = "PersonIndexService", service = PersonIndexService.class, 
		scope = ServiceScope.SINGLETON, reference = {
		@Reference(name = "mongoCondition", service = UriMapProvider.class, target = "(uri.map.src=mongodb://test/)", cardinality = ReferenceCardinality.MANDATORY),
		@Reference(name = "modelCondition", service = ResourceSetFactory.class, target = "(emf.model.name=basic)", cardinality = ReferenceCardinality.MANDATORY)
})
public class PersonIndexService {
	
	@Reference(target = "(repo_id=test.test)", cardinality = ReferenceCardinality.MANDATORY)
	private ComponentServiceObjects<EMFRepository> repositoryServiceObjects;

	@Reference(target = "(id=test)")
	private LuceneIndexService personIndex;
	
	@Reference
	BasicPackage personPackage;
	
	private PromiseFactory factory = new PromiseFactory(Executors.newFixedThreadPool(4));
	
	private AtomicInteger counter = new AtomicInteger(0);
	
	@Activate
	public void activate() {
		indexPersons();
	}
	
	private void indexPersons() {
		factory.submit(() -> {
			CountDownLatch latch = new CountDownLatch(1);
			latch.await(100, TimeUnit.MILLISECONDS);
			initializeIndex();
			return true;
		}).onSuccess(t -> System.out.println("Finished indexing Person objects!"))
		.onFailure(t -> t.printStackTrace());		
	}
	
	public Promise<Void> initializeIndex() {
		System.out.println("Starting indexing Person objects...");
		
		EMFRepository repository = repositoryServiceObjects.getService();
		QueryRepository queryRepo = (QueryRepository) repository.getAdapter(QueryRepository.class);
		IQuery query = queryRepo.createQueryBuilder().allQuery().build();

		resetIndex();
		
		EPushStreamProvider psp = queryRepo.getEObjectByQuery(personPackage.getPerson(), query, getLoadOptions());
		if(psp == null) {
			return null;
		}
		
		counter = new AtomicInteger(0);
		PushStream<EObject> indexNew = psp.createPushStreamBuilder()
				.withPushbackPolicy(GeckoPushbackPolicyOption.LINEAR_AFTER_THRESHOLD.getPolicy(50))
				.withQueuePolicy(QueuePolicyOption.BLOCK)
				.withExecutor(Executors.newSingleThreadExecutor())
				.withBuffer(new ArrayBlockingQueue<PushEvent<? extends EObject>>(100))
				.build();
		
		List<DocumentIndexContextObject> contexts = new LinkedList<>();
		Promise<Void> resultPromise = indexNew
				.map(eo -> (Person) eo)
				.map(PersonIndexHelper::mapPersonNew)
				.forEach(d -> {
					repository.detach(d.getObject());
					if(contexts.size() < 10) {
						contexts.add(d);
					}
					else {
						personIndex.handleContextsSync(contexts);
						contexts.clear();
						contexts.add(d);
					}
					counter.incrementAndGet();
				})
				.thenAccept(result -> {
					if(!contexts.isEmpty()) {
						try {
							personIndex.handleContextsSync(contexts);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
		
		return resultPromise.onFailure(t -> repositoryServiceObjects.ungetService(repository))
				.thenAccept(result -> System.out.println("Finished indexing " + counter.get() + " Person object(s)!"))
				.thenAccept(result -> repositoryServiceObjects.ungetService(repository));
	}
	
	
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
	
	public static Map<Object, Object> getLoadOptions(){
		Map<Object, Object> loadOptions = new HashMap<>();
		loadOptions.put(Options.OPTION_BATCH_SIZE, Integer.valueOf(600));
		loadOptions.put(MongoPushStreamConstants.OPTION_QUERY_PUSHSTREAM, Boolean.TRUE);
		loadOptions.put(Options.OPTION_READ_DETACHED, true);
		return loadOptions;
	}
}
