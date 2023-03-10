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
package org.gecko.search.suggest.api;

import static java.util.Objects.requireNonNull;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.search.suggest.Lookup;
import org.apache.lucene.search.suggest.analyzing.AnalyzingInfixSuggester;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.BytesRef;
import org.gecko.search.api.IndexActionType;
import org.gecko.search.suggest.context.ContextIteratorImpl;
import org.gecko.search.suggest.context.IndexContext;
import org.gecko.search.suggest.context.SuggestionContext;
import org.gecko.search.suggest.context.SuggestionContextImpl;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.component.ComponentContext;
import org.osgi.util.promise.Promise;
import org.osgi.util.promise.PromiseFactory;

/**
 * Service implementation of the suggestion service. To define the index location,
 * the corresponding configuration property must be provided
 * @author Ilenia Salvadori, Mark Hoffmann
 * @since 03.03.2023
 */
public abstract class BasicSuggestionService<O, FIELD> implements SuggestionService {

	private static final Logger LOGGER = Logger.getLogger(BasicSuggestionService.class.getName());
	protected SuggestionDescriptor<O, FIELD> suggestionDescriptor;
	protected Promise<AnalyzingInfixSuggester> suggesterPromise;
	protected FSDirectory indexDir;
	protected volatile SuggestionConfiguration configuration;
	
	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.suggest.api.SuggestionService#getAutoCompletion(java.lang.String, java.lang.String[])
	 */
	@Override
	public Map<String, String> getAutoCompletion(String string, String[] label) {
		Map<String, String> displayRes = new HashMap<>();
		AnalyzingInfixSuggester suggester;
		try {
			suggester = suggesterPromise.getValue();
			List<Lookup.LookupResult> results = null;
			Set<BytesRef> contextSet = new HashSet<BytesRef>();        
			try {
				if (label != null && label.length > 0) {
					for (String l : label) {
						contextSet.add(new BytesRef(l.getBytes("UTF8")));
					}
				}
				results = suggester.lookup(string, contextSet, configuration.suggestionNumberResults(), configuration.suggestionAllTermsRequired(), false);
			} catch (IOException e) {
				LOGGER.log(Level.SEVERE, "[{0}] Error providing a suggestion for {1}", new Object[] {configuration.suggestionName(), string, e});
				return Collections.emptyMap();
			}
			for (Lookup.LookupResult result : results) {
				BytesRef payload = result.payload;
				String id = new String(payload.bytes);
				String proposal = result.key.toString();
				displayRes.put(proposal, id);
			}		
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "[{0}] Error creating a suggestion proposal for query {1}", new Object[] {configuration.suggestionName(), string});
		}
		return displayRes;
	}
	/**
	 * Called on component activation
	 * @param ctx the component context
	 * @throws ConfigurationException
	 */
	protected void activate(ComponentContext ctx , SuggestionConfiguration configuration) {
		this.configuration = configuration;
		PromiseFactory pf = new PromiseFactory(Executors.newSingleThreadExecutor());
		suggesterPromise = pf.submit(this::initializeSuggestionIndex);
	}

	/**
	 * Called on component de-activation
	 */
	protected void deactivate() {
		try (AnalyzingInfixSuggester value = suggesterPromise.getValue()) {
			if (value != null) {
				value.close();
			}
		} catch (InvocationTargetException | InterruptedException | IOException e) {
			LOGGER.log(Level.SEVERE, "Error closing suggester", e);
		};
		if (indexDir != null) {
			try {
				indexDir.close();
			} catch (IOException e) {
				LOGGER.log(Level.SEVERE, "Error closing index directory", e);
			}
		}
	}

	/**
	 * Sets the suggestionDescriptor.
	 * @param suggestionDescriptor the suggestionDescriptor to set
	 */
	protected void setSuggestionDescriptor(SuggestionDescriptor<O, FIELD> suggestionDescriptor) {
		this.suggestionDescriptor = suggestionDescriptor;
	}
	/**
	 * Creates the initial index with data
	 * @return the suggester;
	 * @throws ConfigurationException 
	 */
	protected AnalyzingInfixSuggester initializeSuggestionIndex() throws ConfigurationException {
		//Initialize path and analyzer
		AnalyzingInfixSuggester suggester = initializeSuggester();
		return suggester;
	}

	/**
	 * This method opens a FSDirectory and creates a StandardAnalyzer and a Suggester which are then needed
	 * for the data indexing and searching.
	 * @throws ConfigurationException
	 */
	protected AnalyzingInfixSuggester initializeSuggester() throws ConfigurationException {
		File file = null;
		AnalyzingInfixSuggester suggester = null;
		if(configuration.base_path().length() > 0) {
			file = new File(configuration.base_path());
		}
		if(file == null) {
			throw new ConfigurationException("base.path", "The property is required for the suggester index");
		}
	
		try {
			indexDir = FSDirectory.open(file.toPath());
			StandardAnalyzer analyzer = new StandardAnalyzer();
			suggester = new AnalyzingInfixSuggester(indexDir, analyzer);
		} catch (IOException e) {
			throw new ConfigurationException("base.path", String.format("Error opening suggestion index for the given path '%s'"));
		} 
		return suggester;
	}
	
	/**
	 * This method creates the list of content we want to make the auto completion against. 
	 * It loops over the list of input data and provides for each entry the payload, the filed against with we
	 * want to auto complete the search, the weight (for now set to 4), and the labels used to search only among
	 * data belonging to a particular category.
	 * @return the list with contexts
	 */
	protected List<SuggestionContext<O, FIELD>> createContextFromDescriptor() {
		Set<FIELD> fields = suggestionDescriptor.getFields();
		List<String> labels = suggestionDescriptor.getLabels();
		final String[] labelsArray = labels.toArray(new String[labels.size()]);
		Stream<O> objects = suggestionDescriptor.getObjectStream();
		List<SuggestionContext<O, FIELD>> contexts = objects.
				map(object-> createContextsForFields(fields, object, IndexActionType.ADD, labelsArray, 4)).
				flatMap(Collection::stream).
				collect(Collectors.toList());
		return contexts;
	}
	
	/**
	 * This method creates the list of content we want to make the auto completion against. 
	 * It loops over the list of input data and provides for each entry the payload, the filed against with we
	 * want to auto complete the search, the weight (for now set to 4), and the labels used to search only among
	 * data belonging to a particular category.
	 * @return the list with contexts
	 */
	protected List<SuggestionContext<O, FIELD>> createContext(O object) {
		Set<FIELD> fields = suggestionDescriptor.getFields();
		List<String> labels = suggestionDescriptor.getLabels();
		final String[] labelsArray = labels.toArray(new String[labels.size()]);
		List<SuggestionContext<O, FIELD>> contexts = createContextsForFields(fields, object, IndexActionType.ADD, labelsArray, 4);
		return contexts == null ? Collections.emptyList() : contexts;
	}
	
	protected Collection<IndexContext<O, FIELD>> buildIndexContext(List<SuggestionContext<O, FIELD>> suggestionContext) {
		return suggestionContext.stream().map(IndexContext::new).collect(Collectors.toList());
	}

	/**
	 * Create {@link SuggestionContext} for each field ofthe object
	 * @param fields the fields to create a context for
	 * @param object the business object instance
	 * @param indexType type of the indexing process
	 * @param labels the labels to create suggestion for
	 * @param numberResults the number of results
	 * @return
	 */
	protected List<SuggestionContext<O, FIELD>> createContextsForFields(Set<FIELD> fields, O object, IndexActionType indexType, String[] labels, int numberResults) {
		Object payloadObject = getPayload(object, suggestionDescriptor.getPayload());
		String payload = payloadObject == null ? null : payloadObject.toString();		
		return fields.stream().map(field->{
			Object value = getFieldValue(object, field);
			if (value != null) {
				return createSuggestionContext(object, field, indexType, payload, value.toString(), labels, numberResults);
			} else {
				return null;
			}
		}).filter(Objects::nonNull).collect(Collectors.toList());
	}

	/**
	 * Instantiates a {@link SuggestionContext}
	 * @param object the business object instance
	 * @param field the field to create the context for
	 * @param indexType the index type
	 * @param payload the suggestion payload
	 * @param value the data value
	 * @param labels the labels to create suggestions for
	 * @param numberResults  number of results
	 * @return the context or <code>null</code>
	 */
	protected SuggestionContext<O, FIELD> createSuggestionContext(O object, FIELD field, IndexActionType indexType, String payload, String value, String[] labels, int numberResults) {
		requireNonNull(object);
		requireNonNull(field);
		requireNonNull(indexType);
		requireNonNull(payload);
		requireNonNull(value);
		requireNonNull(labels);
		SuggestionContextImpl<O, FIELD> ctx = new SuggestionContextImpl<>(indexType, payload, value, labels, numberResults);
		ctx.setField(field);
		ctx.setObject(object);
		return ctx;
	}

	/**
	 * This method indexes the data through the standardAnalyzer and an iterator
	 * @param contexts the {@link SuggestionContext}
	 * @param suggester the suggester
	 * @throws IOException
	 */
	protected void indexIteratorContext(List<SuggestionContext<O, FIELD>> contexts, AnalyzingInfixSuggester suggester) throws IOException {
		suggester.build(new ContextIteratorImpl<O, FIELD>(contexts.iterator()));
	}
	
	/**
	 * Indexes an context objects, with the given suggester
	 * @param contexts the contexts to be indexed
	 * @param suggester the suggester to be used
	 */
	protected void indexContexts(Collection<IndexContext<O, FIELD>> contexts, AnalyzingInfixSuggester suggester) {
		Objects.requireNonNull(contexts);
		Objects.requireNonNull(suggester);
		contexts.forEach(c->indexContext(c, suggester));
	}

	/**
	 * Indexes an context object, with the given suggester
	 * @param context the context to be indexed
	 * @param suggester the suggester to be used
	 */
	protected void indexContext(IndexContext<O, FIELD> context, AnalyzingInfixSuggester suggester) {
		Objects.requireNonNull(context);
		Objects.requireNonNull(suggester);
		try {
			switch (context.getContext().getActionType()) {
			case ADD:
				suggester.add(context.content(), context.labels(), context.weight(), context.payload());
				break;
			case MODIFY:
				suggester.update(context.content(), context.labels(), context.weight(), context.payload());
				break;
			default:
				suggester.update(new BytesRef(BytesRef.EMPTY_BYTES), Collections.emptySet(), context.weight(), context.payload());
				break;
			}
			suggester.commit();
			suggester.refresh();
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, String.format("[%s] Error handling context for payload %s", configuration.suggestionName(), context.getContext().getPayload()), e);
		}
	}
	
	/**
	 * Returns the payload from the given object for the given field
	 * @param object the object
	 * @param payloadField the field
	 * @return the payload data
	 */
	protected abstract Object getPayload(O object, FIELD payloadField);
	/**
	 * Returns the value from the given field
	 * @param object the object
	 * @param field the field
	 * @return the field data from the object
	 */
	protected abstract Object getFieldValue(O object, FIELD field);

}
