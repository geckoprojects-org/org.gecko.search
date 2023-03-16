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

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.lucene.search.suggest.analyzing.AnalyzingInfixSuggester;
import org.gecko.search.IndexActionType;
import org.gecko.search.suggest.context.SuggestionContext;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.util.promise.Promise;

/**
 * Service implementation of the suggestion service. To define the index location,
 * the corresponding configuration property must be provided
 * @author Ilenia Salvadori, Mark Hoffmann
 * @since 03.03.2023
 */
public abstract class SuggestionServiceImpl<O, F> extends BasicSuggestionImpl<O, F> {

	/**
	 * Sets the suggestionDescriptor.
	 * @param suggestionDescriptor the suggestionDescriptor to set
	 */
	@Override
	protected void setDescriptor(SuggestionDescriptor<O, F> suggestionDescriptor) {
		super.setDescriptor(suggestionDescriptor);
	}
	/**
	 * Creates the initial index with data
	 * @return the suggester;
	 * @throws ConfigurationException 
	 */
	@Override
	protected Promise<Void> initializeSuggestionIndex()  {
		requireNonNull(getPromiseFactory());
		requireNonNull(getLookup());
		return getPromiseFactory().submit(()->{
			indexContexts(buildIndexContext(createContext()));
			return null;
		});
	}

	/**
	 * This method creates the list of content we want to make the auto completion against. 
	 * It loops over the list of input data and provides for each entry the payload, the filed against with we
	 * want to auto complete the search, the weight (for now set to 4), and the labels used to search only among
	 * data belonging to a particular category.
	 * @return the list with contexts
	 */
	protected List<SuggestionContext<O, F>> createContext() {
		SuggestionDescriptor<O,F> descriptor = getDescriptor();
		Set<F> fields = descriptor.getFields();
		List<String> labels = descriptor.getLabels();
		final String[] labelsArray = labels.toArray(new String[labels.size()]);
		Stream<O> objects = descriptor.getObjectStream();
		return objects.
				map(object-> createContextsForFields(fields, object, IndexActionType.ADD, labelsArray, 4)).
				flatMap(Collection::stream).
				collect(Collectors.toList());
	}

}
