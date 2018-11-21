/**
 * Copyright (c) 2012 - 2018 Data In Motion and others.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Data In Motion - initial API and implementation
 */
package org.gecko.search.suggest.impl;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.search.suggest.Lookup;
import org.apache.lucene.search.suggest.analyzing.AnalyzingInfixSuggester;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.BytesRef;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.gecko.search.suggest.api.SuggestionObjectProvider;
import org.gecko.search.suggest.api.SuggestionService;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * SErvice implementation of the suggestion service
 * @author ilenia
 * @since Nov 9, 2018
 */
@Component
public class SuggestionServiceimpl implements SuggestionService {

	@Reference
	private SuggestionObjectProvider objectProvider;
	
	public static final String PROP_INDEX_DIR = "index.dir";
	private static final Logger logger = Logger.getLogger(SuggestionServiceimpl.class.getName());
	private volatile List<EObject> devices = new LinkedList<EObject>();
	private List<SuggestContext> contexts = new LinkedList<SuggestContext>();
	private AnalyzingInfixSuggester suggester;

	private FSDirectory indexDir;
	
	@Activate
	public void activate(ComponentContext ctx) {
		String indexDir = (String) ctx.getProperties().get(PROP_INDEX_DIR);
		if (indexDir == null) {
			indexDir = System.getProperty("user.home");
		}
		logger.info("My index path is: " + indexDir);
		
		//create data sample and context suggests (according to device Fqdn, Alias and Name)
		//List<SuggestContext> contexts = null;;
		this.devices = objectProvider.getSampleObjects();
		createContext();
		
		//Initialize path and analyzer
		this.suggester = initializeUtil(indexDir);
		
		//Indexing data according to the suggester		
		try {
			indexData(contexts, suggester);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * This method creates the list of content we want to make the auto completion against. 
	 * It loops over the list of input data and provides for each entry the payload, the filed against with we
	 * want to auto complete the search, the weight (for now set to 4), and the labels used to search only among
	 * data belonging to a particular category.
	 */
	private void createContext() {
		Set<EStructuralFeature> fields = objectProvider.getFields();
		List<String> labels = objectProvider.getLabels();
		String[] labelsArray = new String[labels.size()];
		labelsArray = labels.toArray(labelsArray);
		for (EObject eo : devices) {
			Object payloadObject = eo.eGet(objectProvider.getPayload());
			String payload = payloadObject == null ? null : payloadObject.toString();				
			for (EStructuralFeature feature : fields) {
				Object value = eo.eGet(feature);
				if (value != null) {
					SuggestContext ctx = new SuggestContextImpl(payload, eo.eGet(feature).toString(), 4, labelsArray);
					contexts.add(ctx);
				}
			}			
		}
	}

	@Deactivate
	public void deactivate() {
		if (indexDir != null) {
			try {
				indexDir.close();
			} catch (IOException e) {
				logger.severe("Error closing index directory");
			}
		}
	}
	
	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.suggest.api.SuggestionService#getAutoCompletion(java.lang.String, java.lang.String[])
	 */
	@Override
	public Map<String, String> getAutoCompletion(String string, String[] label) {
		int numDisplayedRes = 10;
		List<Lookup.LookupResult> results = null;
		Map<String, String> displayRes = new HashMap<>();
		Set<BytesRef> contextsSet = new HashSet<BytesRef>();        
		try {
			if (label != null && label.length > 0) {
				for (String l : label) {
					contextsSet.add(new BytesRef(l.getBytes("UTF8")));
				}
			}
			results = suggester.lookup(string, contextsSet, numDisplayedRes, true, false);
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Error providing a suggestion for " + string, e);
			return Collections.emptyMap();
		}
		for (Lookup.LookupResult result : results) {
			BytesRef payload = result.payload;
			String id = new String(payload.bytes);
			String proposal = result.key.toString();
			displayRes.put(proposal, id);
		}		
		return displayRes;
	}
	
	/**
	 * This method opens a FSDirectory and creates a StandardAnalyzer and a Suggester which are then needed
	 * for the data indexing and searching.
	 * @param indexDir
	 * @return suggester
	 */
	private AnalyzingInfixSuggester initializeUtil(String indexPath) {
		Path path = Paths.get(indexPath);
		AnalyzingInfixSuggester suggester = null;
		try {
			indexDir = FSDirectory.open(path);
			StandardAnalyzer analyzer = new StandardAnalyzer();
			suggester = new AnalyzingInfixSuggester(indexDir, analyzer);
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Something happened : ", e);
		} 
		return suggester;
	}
	
	/**
	 * This method indexes the data through the standardAnalyzer
	 * @param contexts
	 * @param suggester
	 * @throws IOException
	 */
	private void indexData(List<SuggestContext> contexts, AnalyzingInfixSuggester suggester) throws IOException {
		suggester.build(new ContextIteratorImpl(contexts.iterator()));
	}

}
