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

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static java.util.Objects.requireNonNull;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
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
import org.apache.lucene.store.Directory;
import org.apache.lucene.util.BytesRef;
import org.gecko.search.BasicLuceneImpl;
import org.gecko.search.IndexActionType;
import org.gecko.search.suggest.context.ContextIteratorImpl;
import org.gecko.search.suggest.context.SuggestionContext;
import org.gecko.search.suggest.context.SuggestionContextWrapper;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.util.promise.Promise;

/**
 * Service implementation of the suggestion service. To define the index location,
 * the corresponding configuration property must be provided.
 * 
 * ATTENTION: 
 * This implementation does not warm up the suggester. Executing a lookup before something was indexed will fail!
 * Especially when using an in memory {@link Directory}. The SearcherManager is activated lazily, when indexing something
 * Implementors should care about this.
 * 
 * @author Ilenia Salvadori, Mark Hoffmann
 * @since 03.03.2023
 */
public abstract class BasicSuggestionImpl<O, F> extends BasicLuceneImpl implements SuggestionService {

	private static final Logger LOGGER = Logger.getLogger(BasicSuggestionImpl.class.getName());
	private SuggestionDescriptor<O, F> descriptor;
	private AnalyzingInfixSuggester lookup;
	private SuggestionConfiguration configuration;
	
	SuggestionDescriptor<O, F> getDescriptor() {
		return descriptor;
	}
	
	protected void setDescriptor(SuggestionDescriptor<O, F> descriptor) {
		this.descriptor = descriptor;
	}
	
	
	/**
	 * Returns the lookup.
	 * @return the lookup
	 */
	public AnalyzingInfixSuggester getLookup() {
		requireNonNull(lookup);
		return lookup;
	}
	
	/**
	 * Returns the configuration
	 * @return the configuration
	 */
	protected SuggestionConfiguration getConfiguration() {
		return configuration;
	}
	
	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.document.index.BasicLuceneIndexImpl#createConfiguration()
	 */
	@Override
	public Configuration createInternalConfiguration() {
		requireNonNull(configuration);
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

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.suggest.api.SuggestionService#getAutoCompletion(java.lang.String, java.lang.String[])
	 */
	@Override
	public Map<String, String> getAutoCompletion(String stringToComplete, String[] label) {
		requireNonNull(stringToComplete);
		requireNonNull(label);
		requireNonNull(getPromiseFactory());
		Set<BytesRef> contextSet = convertLabels(label);
		try {
			       
			Promise<Map<String, String>> result = getPromiseFactory().submit(()->doLookup(stringToComplete, contextSet)).
					map(lrl->lrl.stream().
							collect(Collectors.toMap(lr->lr.key.toString(), lr->{
								BytesRef payload = lr.payload;
								return payload == null ? "" : new String(payload.bytes, StandardCharsets.UTF_8);
							}
					)));
			return result.getValue();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			LOGGER.log(Level.SEVERE, String.format("[%s] Getting suggester was interupted %s}", configuration.suggestionName(), stringToComplete));
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, String.format("[%s] Error creating a suggestion proposal for query %s", configuration.suggestionName(), stringToComplete));
		}
		return Collections.emptyMap();
	}

	/**
	 * Converts labels into {@link BytesRef}
	 * @param label label array
	 * @return {@link Set} of {@link BytesRef} of the labels
	 */
	protected Set<BytesRef> convertLabels(String[] label) {
		if (label == null) {
			LOGGER.warning(()->"No labels are provided to convert");
			return Collections.emptySet();
		}
		return Arrays.asList(label).stream().
				filter(this::filterLabel).
				map(l->l.getBytes(StandardCharsets.UTF_8)).
				map(BytesRef::new).
				collect(Collectors.toSet());
	}
	
	/**
	 * Returns <code>true</code>, if label is not <code>null</code>, empty and blank
	 * @param label the label to check
	 * @return <code>true</code>, if label is not <code>null</code>, empty and blank
	 */
	protected boolean filterLabel(String label) {
		return nonNull(label) && !label.isEmpty() && !label.isBlank();
	}
	
	/**
	 * Does the lookup
	 * @param string string to lookup
	 * @param contextSet the context data set
	 * @param lookup the suggester
	 * @return The result list or an empty list
	 * @throws IOException 
	 */
	protected List<Lookup.LookupResult> doLookup(String stringToComplete, Set<BytesRef> contextSet) throws IOException {
		requireNonNull(getLookup());
		if (isNull(stringToComplete)) {
			LOGGER.info(()->"There is no string to be completed");
			return Collections.emptyList();
		}
		if (contextSet == null) {
			contextSet = Collections.emptySet();
		}
		return lookup.lookup(stringToComplete, contextSet, configuration.suggestionNumberResults(), configuration.suggestionAllTermsRequired(), false);
	}
	/**
	 * Called on component activation
	 * @throws ConfigurationException
	 */
	protected void activate(SuggestionConfiguration configuration) throws ConfigurationException {
		String configName= "<no-config>";
		try {
			requireNonNull(configuration);
			configName = configuration.suggestionName();
			this.configuration = configuration;
			super.activate();
			lookup = createLookup(configuration);
			indexIteratorContext(Collections.emptyList());
		} catch (Exception e) {
			this.configuration = null;
			throw new ConfigurationException(configName, "Cannot setup suggestor for this configuration", e);
		}
	}
	
	/**
	 * Creates the lookup instance depending on the configuration.
	 * Default falls back to the {@link AnalyzingInfixSuggester}
	 * @param configuration the configuration
	 * @return the {@link Lookup}
	 * @throws IOException
	 */
	protected AnalyzingInfixSuggester createLookup(SuggestionConfiguration configuration) throws IOException {
		requireNonNull(configuration);
		requireNonNull(configuration.suggestion_type());
		requireNonNull(getPromiseFactory());
		return new AnalyzingInfixSuggester(getDirectory(), getAnalyzer());
	}
	
	/**
	 * Initializes the suggestion index.
	 * We pre-configure the suggester, to deal with lookups before we indexed something
	 * @return a Promise that resolved when the initialization is done or an error occurred
	 */
	protected Promise<Void> initializeSuggestionIndex() {
		requireNonNull(getPromiseFactory());
		return getPromiseFactory().resolved(null);
	}

	/**
	 * Called on component de-activation
	 */
	public void deactivate() {
		try {
			if (lookup != null) {
				LOGGER.log(Level.FINE, ()->"Closing suggester " + lookup.toString());
				lookup.close();
			}
		} catch (Exception e) {
			if (e instanceof InterruptedException) {
				Thread.currentThread().interrupt();
			}
			LOGGER.log(Level.SEVERE, "Error closing suggester", e);
		} finally {
			lookup = null;
		}
		try {
			basicDeactivate();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e, ()->"Failed to deactivate implementation");
		}
	}

	/**
	 * This method creates the list of content we want to make the auto completion against. 
	 * It loops over the list of input data and provides for each entry the payload, the filed against with we
	 * want to auto complete the search, the weight (for now set to 4), and the labels used to search only among
	 * data belonging to a particular category.
	 * @return the list with contexts
	 */
	protected List<SuggestionContext<O, F>> createContextFromDescriptor() {
		requireNonNull(descriptor);
		Set<F> fields = new HashSet<>(); 
		if (nonNull(descriptor.getFields())) {
			fields.addAll(descriptor.getFields());
		} else {
			LOGGER.warning(()->"No fields are available from SuggestionDescriptor");
		}
		List<String> labels = descriptor.getLabels();
		final String[] labelsArray = labels == null ? new String[0] : labels.toArray(new String[labels.size()]);
		Stream<O> objects = descriptor.getObjectStream();
		if (isNull(objects)) {
			LOGGER.warning(()->"No data is available to read data from");
			return Collections.emptyList();
		}
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
		requireNonNull(object);
		requireNonNull(descriptor);
		Set<F> fields = descriptor.getFields();
		List<String> labels = descriptor.getLabels();
		final String[] labelsArray = labels == null ? new String[0] : labels.toArray(new String[labels.size()]);
		List<SuggestionContext<O, F>> contexts = createContextsForFields(fields, object, IndexActionType.ADD, labelsArray, 4);
		return contexts == null ? Collections.emptyList() : contexts;
	}
	
	protected Collection<SuggestionContextWrapper<O, F>> buildIndexContext(List<SuggestionContext<O, F>> suggestionContext) {
		requireNonNull(suggestionContext);
		return suggestionContext.stream().map(SuggestionContext::toIndexContext).collect(Collectors.toList());
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
		requireNonNull(object);
		requireNonNull(indexType);
		requireNonNull(labels);
		requireNonNull(descriptor);
		if (fields == null) {
			fields = Collections.emptySet();
		}
		try {
			Object payloadObject = getPayload(object, descriptor.getPayload());
			String payload = payloadObject == null ? null : payloadObject.toString();		
			return fields.stream().map(field->{
				Object value = getFieldValue(object, field);
				if (value != null) {
					return SuggestionContext.createAddContext(object, field, indexType, payload, value.toString(), labels, numberResults);
				} else {
					return null;
				}
			}).filter(Objects::nonNull).collect(Collectors.toList());
		} catch (Exception e) {
			throw new IllegalStateException("Error creating context for fields", e);
		}
	}

	/**
	 * This method indexes the data through the standardAnalyzer and an iterator
	 * @param contexts the {@link SuggestionContext}
	 * @param lookup the suggester
	 * @throws IOException
	 */
	protected void indexIteratorContext(List<SuggestionContext<O, F>> contexts) throws IOException {
		requireNonNull(contexts);
		requireNonNull(getLookup());
		lookup.build(new ContextIteratorImpl<O, F>(contexts.iterator()));
	}
	
	/**
	 * Indexes an context objects, with the given suggester
	 * @param contexts the contexts to be indexed
	 * @param lookup the suggester to be used
	 */
	protected void indexContexts(Collection<SuggestionContextWrapper<O, F>> contexts) {
		requireNonNull(contexts);
		requireNonNull(getLookup());
		contexts.forEach(c->indexContext(c));
	}

	/**
	 * Indexes an context object, with the given suggester
	 * @param wrapper the context wrapper to be indexed
	 * @param lookup the suggester to be used
	 */
	protected void indexContext(SuggestionContextWrapper<O, F> wrapper) {
		requireNonNull(wrapper);
		requireNonNull(getLookup());
		try {
			switch (wrapper.getContext().getActionType()) {
			case ADD:
				lookup.add(wrapper.content(), wrapper.labels(), wrapper.weight(), wrapper.payload());
				break;
			case MODIFY:
				lookup.update(wrapper.content(), wrapper.labels(), wrapper.weight(), wrapper.payload());
				break;
			default:
				lookup.update(new BytesRef(BytesRef.EMPTY_BYTES), Collections.emptySet(), wrapper.weight(), wrapper.payload());
				break;
			}
			lookup.commit();
			lookup.refresh();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, String.format("[%s] Error handling context for payload %s", configuration.suggestionName(), wrapper.getContext().getPayload()), e);
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
