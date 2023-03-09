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

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.lucene.search.suggest.analyzing.AnalyzingInfixSuggester;
import org.gecko.search.api.IndexActionType;
import org.gecko.search.suggest.context.SuggestionContext;
import org.osgi.service.cm.ConfigurationException;

/**
 * Service implementation of the suggestion service. To define the index location,
 * the corresponding configuration property must be provided
 * @author Ilenia Salvadori, Mark Hoffmann
 * @since 03.03.2023
 */
public abstract class SuggestionServiceImpl<O, FIELD> extends BasicSuggestionService<O, FIELD> {

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
		AnalyzingInfixSuggester suggester = super.initializeSuggestionIndex();
		indexContexts(buildIndexContext(createContext()), suggester);
		return suggester;
	}

	/**
	 * This method creates the list of content we want to make the auto completion against. 
	 * It loops over the list of input data and provides for each entry the payload, the filed against with we
	 * want to auto complete the search, the weight (for now set to 4), and the labels used to search only among
	 * data belonging to a particular category.
	 * @return the list with contexts
	 */
	protected List<SuggestionContext<O, FIELD>> createContext() {
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

}
