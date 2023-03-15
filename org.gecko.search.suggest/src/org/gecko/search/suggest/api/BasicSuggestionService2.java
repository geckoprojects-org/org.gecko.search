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

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.lucene.search.suggest.Lookup;
import org.apache.lucene.search.suggest.analyzing.AnalyzingInfixSuggester;
import org.apache.lucene.util.BytesRef;
import org.gecko.search.BasicLuceneImpl;
import org.gecko.search.IndexActionType;
import org.gecko.search.suggest.context.ContextIteratorImpl;
import org.gecko.search.suggest.context.IndexContext;
import org.gecko.search.suggest.context.SuggestionContext;
import org.gecko.search.suggest.context.SuggestionContextImpl;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.component.ComponentContext;
import org.osgi.util.promise.Promise;

/**
 * Service implementation of the suggestion service. To define the index location,
 * the corresponding configuration property must be provided
 * @author Ilenia Salvadori, Mark Hoffmann
 * @since 03.03.2023
 */
public abstract class BasicSuggestionService2<O, F> extends BasicLuceneImpl implements SuggestionService {

	private static final Logger LOGGER = Logger.getLogger(BasicSuggestionService2.class.getName());
	protected SuggestionDescriptor<O, F> suggestionDescriptor;
	protected Promise<AnalyzingInfixSuggester> suggesterPromise;
	protected SuggestionConfiguration configuration;
	
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
			Set<BytesRef> contextSet = new HashSet<>();        
			List<Lookup.LookupResult> results = doLookup(string, label, suggester, contextSet);
			for (Lookup.LookupResult result : results) {
				BytesRef payload = result.payload;
				String id = new String(payload.bytes);
				String proposal = result.key.toString();
				displayRes.put(proposal, id);
			}		
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			LOGGER.log(Level.SEVERE, String.format("[%s] Getting suggester was interupted %s}", configuration.suggestionName(), string));
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, String.format("[%s] Error creating a suggestion proposal for query %s", configuration.suggestionName(), string));
		}
		return displayRes;
	}
	
	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.document.index.BasicLuceneIndexImpl#createConfiguration()
	 */
	@Override
	public Configuration createConfiguration() {
		return new Configuration() {
			
			@Override
			public String getIndexName() {
				return configuration.suggestionName();
			}
			
			@Override
			public String getDirectoryType() {
				return configuration.directory_type();
			}
			
			@Override
			public String getBasePath() {
				return configuration.base_path();
			}
		};
	}
	
	/**
	 * Does the lookup
	 * @param string string to lookup
	 * @param label the labels to look into
	 * @param suggester the suggester
	 * @param contextSet the context data set
	 * @return The result list or an empty list
	 * @throws IOException 
	 */
	protected List<Lookup.LookupResult> doLookup(String string, String[] label, AnalyzingInfixSuggester suggester, Set<BytesRef> contextSet) throws IOException {
		if (label != null && label.length > 0) {
			for (String l : label) {
				contextSet.add(new BytesRef(l.getBytes(StandardCharsets.UTF_8)));
			}
		}
		return suggester.lookup(string, contextSet, configuration.suggestionNumberResults(), configuration.suggestionAllTermsRequired(), false);
	}
	/**
	 * Called on component activation
	 * @param ctx the component context
	 * @throws ConfigurationException
	 */
	protected void activate(ComponentContext ctx , SuggestionConfiguration configuration) throws ConfigurationException {
		this.configuration = configuration;
		super.activate();
		suggesterPromise = getPromiseFactory().submit(()->new AnalyzingInfixSuggester(getDirectory(), getAnalyzer()));
	}

	/**
	 * Called on component de-activation
	 */
	public void deactivate() {
		try (AnalyzingInfixSuggester value = suggesterPromise.getValue()) {
			if (value != null) {
				LOGGER.log(Level.FINE, ()->"Closing suggester " + value.toString());
			}
		} catch (InvocationTargetException | InterruptedException | IOException e) {
			if (e instanceof InterruptedException) {
				Thread.currentThread().interrupt();
			}
			LOGGER.log(Level.SEVERE, "Error closing suggester", e);
		}
		basicDeactivate();
	}

	/**
	 * Sets the suggestionDescriptor.
	 * @param suggestionDescriptor the suggestionDescriptor to set
	 */
	protected void setSuggestionDescriptor(SuggestionDescriptor<O, F> suggestionDescriptor) {
		this.suggestionDescriptor = suggestionDescriptor;
	}

	/**
	 * This method creates the list of content we want to make the auto completion against. 
	 * It loops over the list of input data and provides for each entry the payload, the filed against with we
	 * want to auto complete the search, the weight (for now set to 4), and the labels used to search only among
	 * data belonging to a particular category.
	 * @return the list with contexts
	 */
	protected List<SuggestionContext<O, F>> createContextFromDescriptor() {
		Set<F> fields = suggestionDescriptor.getFields();
		List<String> labels = suggestionDescriptor.getLabels();
		final String[] labelsArray = labels.toArray(new String[labels.size()]);
		Stream<O> objects = suggestionDescriptor.getObjectStream();
		return objects.
				map(object-> createContextsForFields(fields, object, IndexActionType.ADD, labelsArray, 4)).
				flatMap(Collection::stream).
				collect(Collectors.toList());
	}
	
	/**
	 * This method creates the list of content we want to make the auto completion against. 
	 * It loops over the list of input data and provides for each entry the payload, the filed against with we
	 * want to auto complete the search, the weight (for now set to 4), and the labels used to search only among
	 * data belonging to a particular category.
	 * @return the list with contexts
	 */
	protected List<SuggestionContext<O, F>> createContext(O object) {
		Set<F> fields = suggestionDescriptor.getFields();
		List<String> labels = suggestionDescriptor.getLabels();
		final String[] labelsArray = labels.toArray(new String[labels.size()]);
		List<SuggestionContext<O, F>> contexts = createContextsForFields(fields, object, IndexActionType.ADD, labelsArray, 4);
		return contexts == null ? Collections.emptyList() : contexts;
	}
	
	protected Collection<IndexContext<O, F>> buildIndexContext(List<SuggestionContext<O, F>> suggestionContext) {
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
	protected List<SuggestionContext<O, F>> createContextsForFields(Set<F> fields, O object, IndexActionType indexType, String[] labels, int numberResults) {
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
	protected SuggestionContext<O, F> createSuggestionContext(O object, F field, IndexActionType indexType, String payload, String value, String[] labels, int numberResults) {
		requireNonNull(object);
		requireNonNull(field);
		requireNonNull(indexType);
		requireNonNull(payload);
		requireNonNull(value);
		requireNonNull(labels);
		SuggestionContextImpl<O, F> ctx = new SuggestionContextImpl<>(indexType, payload, value, labels, numberResults);
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
	protected void indexIteratorContext(List<SuggestionContext<O, F>> contexts, AnalyzingInfixSuggester suggester) throws IOException {
		suggester.build(new ContextIteratorImpl<O, F>(contexts.iterator()));
	}
	
	/**
	 * Indexes an context objects, with the given suggester
	 * @param contexts the contexts to be indexed
	 * @param suggester the suggester to be used
	 */
	protected void indexContexts(Collection<IndexContext<O, F>> contexts, AnalyzingInfixSuggester suggester) {
		Objects.requireNonNull(contexts);
		Objects.requireNonNull(suggester);
		contexts.forEach(c->indexContext(c, suggester));
	}

	/**
	 * Indexes an context object, with the given suggester
	 * @param context the context to be indexed
	 * @param suggester the suggester to be used
	 */
	protected void indexContext(IndexContext<O, F> context, AnalyzingInfixSuggester suggester) {
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
	protected abstract Object getPayload(O object, F payloadField);
	/**
	 * Returns the value from the given field
	 * @param object the object
	 * @param field the field
	 * @return the field data from the object
	 */
	protected abstract Object getFieldValue(O object, F field);

}
