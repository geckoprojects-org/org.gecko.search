/**
 * Copyright (c) 2014 Data In Motion and others.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Data In Motion - initial API and implementation
 */
package org.gecko.search.index.lucene.indexer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.facet.FacetsConfig;
import org.apache.lucene.facet.taxonomy.TaxonomyWriter;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.gecko.search.index.core.BatchSearchIndexException;
import org.gecko.search.index.core.IIndexer;
import org.gecko.search.index.core.SearchIndexException;
import org.gecko.search.index.core.provider.IIndexObjectProvider;
import org.gecko.search.index.lucene.analyzer.IndexObjectAnalyzerConverter;
import org.gecko.search.index.lucene.writer.IIndexWriterProvider;
import org.gecko.searchindex.FacetContext;
import org.gecko.searchindex.FacetField;
import org.gecko.searchindex.IndexDescriptor;
import org.gecko.searchindex.IndexFieldObject;
import org.gecko.searchindex.IndexObject;
import org.gecko.searchindex.SearchableFacetDocumentObject;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementation of the {@link IIndexer} using lucene as index backend
 * @author Mark Hoffmann
 * @since 05.08.2014
 */
public class LuceneIndexer implements IIndexer {
	
	private static final Logger LOG = LoggerFactory.getLogger(LuceneIndexer.class.getName());

	protected IIndexWriterProvider indexWriterProvider;
	protected IIndexObjectProvider indexObjectProvider;
	protected IndexObjectAnalyzerConverter converter;
	protected EventAdmin eventAdmin;

	class UpdateContext {
		public String path = null;
		public String updateFieldName = null;
		public FacetContext facetContext;
		public List<Document> searchableFacetDocuments = new LinkedList<Document>();
		public List<Document> documents = new LinkedList<Document>();
		public List<SearchIndexException> exceptions = new LinkedList<SearchIndexException>();
		public List<Event> events = new LinkedList<>();
		public String defaultAnalizerid = null; 
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.index.core.ISearchIndexer#canIndex(org.eclipse.emf.ecore.EObject[])
	 */
	@Override
	public boolean canIndex(EObject... objects) {
		return false;
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.index.core.ISearchIndexer#index(org.eclipse.emf.ecore.EObject[])
	 */
	@Override
	public void index(EObject... objects) throws SearchIndexException {
		Map<IndexDescriptor, UpdateContext> ctxs = doCreateDocuments(null, objects);
		doWriteIndex(ctxs, false);
	}
	
	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.index.core.ISearchIndexer#update(org.eclipse.emf.ecore.EObject[])
	 */
	@Override
	public void update(EObject... objects) throws SearchIndexException {
		Map<IndexDescriptor, UpdateContext> ctxs = doCreateDocuments(null, objects);
		doWriteIndex(ctxs, true);
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.index.core.ISearchIndexer#remove(org.eclipse.emf.ecore.EObject[])
	 */
	@Override
	public void remove(EObject... objects) throws SearchIndexException {
		List<IndexObject> indexObjects = indexObjectProvider.createIndexObjects(objects);
		List<Term> deleteTerms = new LinkedList<Term>();
		String path = null;
		String[] eClassUris = getEClassUris(objects);
		
		String analizerid = null;
		for (IndexObject indexObject : indexObjects) {
			IndexFieldObject idField = indexObject.getIdField();
			if (idField == null || idField.getValue() == null) {
				continue;
			}
			if (path == null) {
				path = indexObject.getDescriptor().getId();
			}
			if(analizerid == null) {
				analizerid = indexObjectProvider.getAnalyizerid(indexObject.getDescriptor());
			}
			String idvalue = indexObject.getIdField().getValue().toString();
			
			Term t = new Term(idField.getField().getKey(), idvalue);
			deleteTerms.add(t);
			
		}
		doDeleteIndex(deleteTerms, path, analizerid);
		if(eventAdmin != null){
			indexObjects.forEach(io -> {
				Map<String, Object> eventProperties = new HashMap<>();
				eventProperties.put("index.path", io.getDescriptor().getId());
				eventProperties.put("index.object.id", io.getIdField().getValue());
				eventProperties.put("deleted", Boolean.TRUE);
				eventProperties.put("EClasses", eClassUris);
				eventAdmin.postEvent(new Event("de/dim/index/update/" + io.getDescriptor().getId(), eventProperties));
			});
		}
	}

	/* (non-Javadoc)
	 * @see de.dim.search.index.core.IIndexer#batchIndexMany(java.util.List, boolean)
	 */
	@Override
	public void batchIndexMany(List<EObject[]> objectLists, @Deprecated boolean forceMerge)
			throws SearchIndexException {
		validateLists(objectLists);
		Map<IndexDescriptor, UpdateContext> ctxs = null;
		for (EObject[] objects : objectLists) {
			ctxs = doCreateDocuments(ctxs, objects);
		}
		doWriteIndex(ctxs, false);
		for (Entry<IndexDescriptor, UpdateContext> entry : ctxs.entrySet()) {
			entry.getValue().documents.clear();
			entry.getValue().exceptions.clear();
			entry.getValue().facetContext = null;
			entry.getValue().path = null;
			entry.getValue().events = null;
		}
		ctxs.clear();
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.index.core.IIndexer#batchIndex(java.util.List)
	 */
	@Override
	public void batchIndex(List<EObject> objectLists, boolean forceMerge) throws SearchIndexException {
		validateLists(objectLists);
		Map<IndexDescriptor, UpdateContext> ctxs = null;
		for (EObject object : objectLists) {
				ctxs = doCreateDocuments(ctxs, object);
		}
		doWriteIndex(ctxs, false);
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.index.core.ISearchIndexer#batchUpdateMany(java.util.List[])
	 */
	@Override
	public void batchUpdateMany(List<EObject[]> objectLists)
			throws SearchIndexException {
		validateLists(objectLists);
		Map<IndexDescriptor, UpdateContext> ctxs = null;
		for (EObject[] objects : objectLists) {
			ctxs = doCreateDocuments(ctxs, objects);
		}
		doWriteIndex(ctxs, true);
		for (Entry<IndexDescriptor, UpdateContext> entry : ctxs.entrySet()) {
			entry.getValue().documents.clear();
			entry.getValue().exceptions.clear();
			entry.getValue().facetContext = null;
			entry.getValue().path = null;
			entry.getValue().events = null;
		}
		ctxs.clear();
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.index.core.ISearchIndexer#batchRemoveMany(java.util.List[])
	 */
	@Override
	public void batchRemoveMany(List<EObject[]> objectLists)
			throws SearchIndexException {
		List<Term> deleteTerms = new LinkedList<Term>();
		String path = null;
		List<Event> events = new LinkedList<>();
		String analizerid = null;
		for (EObject[] objects : objectLists) {
			List<IndexObject> indexObjects = indexObjectProvider.createIndexObjects(objects);
			String[] eClassUris = getEClassUris(objects); 
			for (IndexObject indexObject : indexObjects) {
				IndexFieldObject idField = indexObject.getIdField();
				if (idField == null || idField.getValue() == null) {
					continue;
				}
				if (path == null) {
					path = indexObject.getDescriptor().getId();
				}
				if(analizerid == null) {
					analizerid = indexObjectProvider.getAnalyizerid(indexObject.getDescriptor());
				}
				String idvalue = indexObject.getIdField().getValue().toString();
				Term t = new Term(idField.getField().getKey(), idvalue);
				deleteTerms.add(t);
				if(eventAdmin != null){
					Map<String, Object> eventProperties = new HashMap<>();
					eventProperties.put("index.path", path);
					eventProperties.put("index.object.id", indexObject.getIdField().getValue());
					eventProperties.put("deleted", Boolean.TRUE);
					eventProperties.put("EClasses", eClassUris);
					events.add(new Event("de/dim/index/update/" + indexObject.getDescriptor().getId(), eventProperties));
				}
			}
		}
		doDeleteIndex(deleteTerms, path, analizerid);
		
		if(eventAdmin != null){
			events.forEach(e -> eventAdmin.postEvent(e));
			events.clear();
		}
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.index.core.IIndexer#dropIndex(org.eclipse.emf.ecore.EClass[])
	 */
	@Override
	public void dropIndex(EClass... eClasses) throws SearchIndexException {
		String path = indexObjectProvider.getIndexPath(eClasses);
		if (path == null) {
			throw new SearchIndexException("No index path found to drop index for EClasses. " + eClasses);
		}
		dropIndex(path);
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.index.core.IIndexer#dropIndex(java.lang.String)
	 */
	@Override
	public void dropIndex(String indexName) throws SearchIndexException {
		if (indexName == null) {
			throw new SearchIndexException("No index path found to drop index for index name. " + indexName);
		}
		try {
			indexWriterProvider.dropIndex(indexName);
		} catch (Exception e) {
			if (e instanceof SearchIndexException) {
				throw e;
			} else {
				throw new SearchIndexException("Error dropping index for path: " + indexName, e);
			}
		}
	}

	/**
	 * Sets the index writer provider.
	 * @param indexWriterProvider the index writer provider to set
	 */
	public void setIndexWriterProvider(IIndexWriterProvider indexWriterProvider) {
		this.indexWriterProvider = indexWriterProvider;
	}
	
	/**
	 * Un-sets the index writer provider.
	 * @param indexWriterProvider the index writer provider to set
	 */
	public void unsetIndexWriterProvider(IIndexWriterProvider indexWriterProvider) {
		this.indexWriterProvider = null;
	}

	/**
	 * Sets the index object provider.
	 * @param indexObjectProvider the index object provider to set
	 */
	public void setIndexObjectProvider(IIndexObjectProvider indexObjectProvider) {
		this.indexObjectProvider = indexObjectProvider;
	}
	
	/**
	 * Un-sets the index object provider.
	 * @param indexObjectProvider the index object provider to un-set
	 */
	public void unsetIndexObjectProvider(IIndexObjectProvider indexObjectProvider) {
		this.indexObjectProvider = null;
	}

	/**
	 * Sets the EventAdmin.
	 * @param eventAdmin the EventAdmin to set
	 */
	public void setEventAdmin(EventAdmin eventAdmin) {
		this.eventAdmin = eventAdmin;
	}
	
	/**
	 * Un-sets the EventAdmin.
	 * @param eventAdmin the EventAdmin( to un-set
	 */
	public void unsetEventAdmin(EventAdmin eventAdmin) {
		this.eventAdmin = null;
	}
	
	/**
	 * Sets the index object analyzer converter that returns the analyzer identification for a index object.
	 * @param converter the index object analyzer converter to set
	 */
	public void setIndexObjectAnalyzerConverter(IndexObjectAnalyzerConverter converter) {
		this.converter = converter;
	}
	
	/**
	 * Un-sets the index object analyzer converter.
	 * @param converter the index object analyzer converter to un-set
	 */
	public void unsetIndexObjectAnalyzerConverter(IndexObjectAnalyzerConverter converter) {
		this.converter = null;
	}
	
	/**
	 * Returns the index writer
	 * @return the index writer
	 */
	public IndexWriter getIndexWriter(String path) {
		return indexWriterProvider.openIndexWriter(path);
	}

	/**
	 * Create documents from the objects and adds them to the documents list
	 * @param documents the documents list to add the new documents
	 * @param objects the objects to create documents from
	 * @return path the path, where the index of the descriptor will be stored
	 */
//	protected String doCreateDocuments(List<Document> documents, EObject... objects) {
//		List<IndexObject> indexObjects = indexObjectProvider.createIndexObjects(objects);
//		String path = null;
//		for (IndexObject indexObject : indexObjects) {
//			if (path == null) {
//				path = indexObject.getDescriptor().getId();
//			}
//			List<Document> objectDocs = indexWriterProvider.createIndexDocuments(indexObject);
//			documents.addAll(objectDocs);
//		}
//		return path;
//	}
	
	/**
	 * Create documents from the objects and adds them to the documents list
	 * @param ctxs the Map of contexts sorted by {@link IndexDescriptor}
	 * @param objects the objects to create documents from
	 * @return path the path, where the index of the descriptor will be stored
	 */
	protected Map<IndexDescriptor, UpdateContext> doCreateDocuments(Map<IndexDescriptor, UpdateContext> ctxs, EObject... objects) {
		if(ctxs == null){
			ctxs = new HashMap<IndexDescriptor, LuceneIndexer.UpdateContext>();
		}
		List<IndexObject> indexObjects = indexObjectProvider.createIndexObjects(objects);
		String[] eClassUris = getEClassUris(objects);
		for (IndexObject indexObject : indexObjects) {
			UpdateContext ctx = ctxs.get(indexObject.getDescriptor());
			Map<String, Object> eventProperties = new HashMap<>();
			eventProperties.put("EClasses", eClassUris);
			if(ctx == null){
				ctx = new UpdateContext();
				ctxs.put(indexObject.getDescriptor(), ctx);
			}
			if (ctx.path == null) {
				ctx.path = indexObject.getDescriptor().getId();
				eventProperties.put("index.path", ctx.path);
			}
			if(ctx.defaultAnalizerid == null) {
				ctx.defaultAnalizerid = indexObjectProvider.getAnalyizerid(indexObject.getDescriptor());
			}
			if (ctx.updateFieldName == null && indexObject.getIdField() != null) {
				ctx.updateFieldName = indexObject.getIdField().getField().getKey();
				eventProperties.put("index.object.id", indexObject.getIdField().getValue());
			}
			try{
				List<Document> objectDocs = indexWriterProvider.createIndexDocuments(indexObject);
				ctx.documents.addAll(objectDocs);
				if(indexObject.getFacetObjects().size() > 0 && ctx.facetContext ==  null){
					ctx.facetContext =  indexObject.getFacetObjects().get(0).getField().getFacetContext();
				}
				if(!indexObject.getSearchableFacetDocumentObjects().isEmpty()){
					for (SearchableFacetDocumentObject object : indexObject.getSearchableFacetDocumentObjects()) {
						ctx.searchableFacetDocuments.add(indexWriterProvider.createIndexDocumentsForSearchableFacetIndex(object));
					}
				}
				ctx.events.add(new Event("de/dim/index/update/" + ctx.path, eventProperties));
			} catch(SearchIndexException e) {
				ctx.exceptions.add(e);
			}
		}
		
		return ctxs;
	}
	
	private String[] getEClassUris(EObject[] objects) {
		String[] eClassUris = new String[objects.length];
		for (int i = 0; i < objects.length; i++) {
			EObject eObject = objects[i];
			eClassUris[i] = EcoreUtil.getURI(eObject.eClass()).toString();
		}
		return eClassUris;
	}

	/**
	 * Builds the faceted documents and writes them to the facetWriter.
	 * Note that the facet writer has the be committed separately
	 * @param documents the {@link Document}s to convert
	 * @param ctx the {@link UpdateContext} containing the {@link FacetContext}
	 * @return a {@link List} of the converted {@link Document}s
	 * @throws IOException
	 */
	public List<Document> prepareDocumentForFacetWriter(
			List<Document> documents, UpdateContext ctx) throws IOException {
		
		//open the facet writer
		TaxonomyWriter facetWriter = indexWriterProvider.openFacetWriter(ctx.path);
		
		// build the facetconfig
		FacetsConfig facetConfig = new FacetsConfig();
		
		for(FacetField ff : ctx.facetContext.getFacetFields()){
			facetConfig.setHierarchical(ff.getKey(), ff.isHirachical());
			facetConfig.setMultiValued(ff.getKey(), ff.isMultiValued());
			facetConfig.setRequireDimCount(ff.getKey(), ff.isRequireCount());
		}
		
		// build the facet stuff for the given documents and write it to the facet writer
		List<Document> result = new ArrayList<Document>(documents.size());
		
		for(Document doc : documents){
			
			result.add(facetConfig.build(facetWriter, doc));
		}
		return result;
	}

	/**
	 * Sorts all documents by their corresponding {@link Analyzer}. The {@link Analyzer} id determined
	 * by the {@link IndexObjectAnalyzerConverter}
	 * @param documents the list of documents to sort
	 * @return the {@link Map} with the analyzer id as key and a list of documents as value
	 */
	protected Map<String, List<Document>> sortDocumentsByAnalyzer(UpdateContext ctx) {
		Map<String, List<Document>> analyzerDocumentMap = new HashMap<String, List<Document>>();
		String analyzerField = converter.getAnalyzerFieldName();
		for (Document d : ctx.documents) {
			String analyzerFieldValue = d.get(analyzerField);
			String analyzerId = converter.convertToAnalyzerId(analyzerFieldValue);
			if (analyzerId == null) {
				analyzerId = ctx.defaultAnalizerid;
			}
			if (analyzerId == null) {
				analyzerId = "default";
			}
			List<Document> analyzerDocuments = analyzerDocumentMap.get(analyzerId);
			if (analyzerDocuments == null) {
				analyzerDocuments = new LinkedList<Document>();
				analyzerDocumentMap.put(analyzerId, analyzerDocuments);
			}
			analyzerDocuments.add(d);
		}
		return analyzerDocumentMap;
	}
	
	/**
	 * Writes the given documents to the index
	 * @param documents the document to add to the index writer
	 * @param update if true performs and update instead of add 
	 */
	protected void doWriteIndex(Map<IndexDescriptor, UpdateContext> ctxs, boolean update) {
		LOG.debug("Handling {} ctxs", ctxs.size());
		for(UpdateContext ctx : ctxs.values()){
			if (ctx == null || ctx.documents == null || ctx.documents.size() == 0) {
				continue;
			}
			Map<String, List<Document>> sortDocumentsByAnalyzer = sortDocumentsByAnalyzer(ctx);
			try {
				long startOpening = System.currentTimeMillis();
				LOG.debug("opening took {}ms" , (System.currentTimeMillis() - startOpening));
					for (String analyzerId : sortDocumentsByAnalyzer.keySet()) {
						IndexWriter writer = indexWriterProvider.openIndexWriter(ctx.path, analyzerId);
						try{
							long startPrepare = System.currentTimeMillis();
							List<Document> indexDocs = sortDocumentsByAnalyzer.get(analyzerId);
							if (indexDocs == null) {
								continue;
							} 
							if(ctx.facetContext != null){
								indexDocs = prepareDocumentForFacetWriter(indexDocs, ctx);
							}
							LOG.debug("preparing took {}ms", (System.currentTimeMillis() - startPrepare));
							long analyizer = System.currentTimeMillis();;
							LOG.debug("getting the analyzer {}ms", (System.currentTimeMillis() - analyizer));
							long doing = System.currentTimeMillis();;
							if(update){
								for (Document document : indexDocs) {
									String id = document.get(ctx.updateFieldName);
									writer.updateDocument(new Term(ctx.updateFieldName, id), document);
								}							
							} else {
							writer.addDocuments(indexDocs);
							}
							
							LOG.debug("adding/updating {} ms", (System.currentTimeMillis() - doing));
							long commit = System.currentTimeMillis();
							indexWriterProvider.commitIndexWriter(writer);
							LOG.debug("commiting {} ms", (System.currentTimeMillis() - commit));
							//if there are facets write them too
							if(ctx.facetContext != null){
								indexWriterProvider.commitFacetWriter(ctx.path);
							}
							if(!ctx.searchableFacetDocuments.isEmpty()){
								IndexWriter facetWriter = indexWriterProvider.openSearchableFacetWriter(ctx.path, analyzerId);
								for(Document doc : ctx.searchableFacetDocuments){
									String id = doc.get("id");
									facetWriter.updateDocument(new Term("id", id), doc);
								}
								indexWriterProvider.commitIndexWriter(facetWriter);
							}
						} catch(SearchIndexException e) {
							ctx.exceptions.add(e);
						}
					}
				if(eventAdmin != null){
					ctx.events.forEach(e -> eventAdmin.postEvent(e));
				}
			} catch (Exception e) {
				ctx.exceptions.add(new SearchIndexException("Error writing index and adding document to index writer", e));
			}
		}
		LOG.debug("Finished handling {} ctxs", ctxs.size());
		//Now check if Exeptions appeared
		List<BatchSearchIndexException> exceptions = new LinkedList<BatchSearchIndexException>();
		for(Map.Entry<IndexDescriptor, UpdateContext> entry: ctxs.entrySet()){
			UpdateContext ctx = entry.getValue();
			if(!ctx.exceptions.isEmpty()){
				exceptions.add(new BatchSearchIndexException("Exceptions appeard while " + (update ? "updateing" : "indexing") + " " + entry.getKey().getId(), ctx.exceptions));
			}
		}
		if(!exceptions.isEmpty()){
			throw new BatchSearchIndexException("Errors appeared during " + (update ? "updateing" : "indexing"), exceptions);
		}
	}
	
	/**
	 * Deletes the given documents from the index
	 * @param deleteTerms {@link List} of {@link Term}'s to delete
	 * @param path the index path
	 */
	protected void doDeleteIndex(List<Term> deleteTerms, String path, String analizerId) {
		if (deleteTerms == null || deleteTerms.size() == 0 || path == null) {
			return;
		}
		try {
			IndexWriter writer = indexWriterProvider.openIndexWriter(path, analizerId);
			writer.deleteDocuments(deleteTerms.toArray(new Term[deleteTerms.size()]));
			indexWriterProvider.commitIndexWriter(path, analizerId);
		} catch (IOException e) {
			throw new SearchIndexException("Error writing index and adding document to index writer", e);
		}
	}
	
	/**
	 * Validates, if the lists in the array are of the same size
	 * @param objectLists the array of object lists to check
	 */
	private void validateLists(List<?> objectLists) {
		boolean valid = true;
		if (objectLists == null || objectLists.size() == 0) {
			valid = false;
		}
		if (!valid) {
			throw new SearchIndexException("Batch update cannot be executed because lists are not of the same size");
		}
	}

	/* (non-Javadoc)
	 * @see de.dim.search.index.core.IIndexer#forceMergeIndex(org.eclipse.emf.ecore.EClass[])
	 */
	@Override
	public synchronized void forceMergeIndex(EClass... eClasses) throws SearchIndexException {
		String path = indexObjectProvider.getIndexPath(eClasses);
		if (path == null) {
			throw new SearchIndexException("No index path found to drop index for EClasses. " + eClasses);
		}
		IndexWriter indexWriter = getIndexWriter(path);
		try {
			indexWriter.forceMerge(1);
			indexWriterProvider.commitIndexWriter(indexWriter);
		} catch (IOException e) {
			throw new SearchIndexException("An error appeared while merging the index", e);
		}
	}
}
