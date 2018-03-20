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
package org.gecko.search.index.lucene.writer.impl;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.BinaryDocValuesField;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.DoublePoint;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.FieldType;
import org.apache.lucene.document.FloatPoint;
import org.apache.lucene.document.IntPoint;
import org.apache.lucene.document.LatLonPoint;
import org.apache.lucene.document.LongPoint;
import org.apache.lucene.document.NumericDocValuesField;
import org.apache.lucene.document.SortedDocValuesField;
import org.apache.lucene.document.SortedNumericDocValuesField;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.facet.FacetField;
import org.apache.lucene.facet.taxonomy.TaxonomyWriter;
import org.apache.lucene.facet.taxonomy.directory.DirectoryTaxonomyWriter;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexOptions;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.TwoPhaseCommit;
import org.apache.lucene.search.SearcherManager;
import org.apache.lucene.store.Directory;
import org.apache.lucene.util.BytesRef;
import org.gecko.emf.utilities.LatLng;
import org.gecko.search.index.core.SearchIndexException;
import org.gecko.search.index.lucene.analyzer.LuceneAnalyzerRegistry;
import org.gecko.search.index.lucene.writer.IIndexWriterConfigurer;
import org.gecko.search.index.lucene.writer.IIndexWriterProvider;
import org.gecko.searchindex.FacetFieldObject;
import org.gecko.searchindex.IndexField;
import org.gecko.searchindex.IndexFieldObject;
import org.gecko.searchindex.IndexObject;
import org.gecko.searchindex.SearchableFacetDocumentObject;
import org.gecko.searchindex.SpatialField;
import org.gecko.searchindex.StoreType;
import org.gecko.searchindex.TermVectorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract class of the index writer provider
 * @author Mark Hoffmann
 * @since 05.08.2014
 */
public abstract class AbstractIndexWriterProvider implements IIndexWriterProvider {

	private static final Logger LOG = LoggerFactory.getLogger(AbstractIndexWriterProvider.class.getName());

	
	private static final String DEFAULT_ANALYZER_ID = "default";
	private static final String FACET_INDEX_SUFIX = "-facet";
	private static final String SEARCHABLE_FACET_INDEX_SUFIX = "-searchable-facet";
	
	private ReentrantLock searcherManagerLock = new ReentrantLock();
	private Map<String, SearcherManager> searcherManagerMap = new HashMap<String, SearcherManager>();
	private Map<String, IndexHolder> writerMap = new ConcurrentHashMap<String, IndexHolder>();
	private Map<String, TaxonomyWriter> facetWriterMap = new ConcurrentHashMap<String, TaxonomyWriter>();
	private List<IIndexWriterConfigurer> configurerList = new LinkedList<IIndexWriterConfigurer>();
	private LuceneAnalyzerRegistry analyzerRegistry;
	private static final ExecutorService refreshExecutors = Executors.newCachedThreadPool();

	private static class IndexHolder {
		
		public String analyzerId;
		public IndexWriter writer;

		public IndexHolder(String analyzerId, IndexWriter writer) {
			this.analyzerId = analyzerId;
			this.writer = writer;
			
		}
		
	}
	
	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.index.lucene.writer.IIndexWriterProvider#openIndexWriter(java.lang.String)
	 */
	@Override
	public IndexWriter openIndexWriter(String path) {
		return openIndexWriter(path, DEFAULT_ANALYZER_ID);
	}
	
	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.index.lucene.writer.IIndexWriterProvider#openIndexWriter(java.lang.String)
	 */
	@Override
	public synchronized IndexWriter openIndexWriter(String path, String analyzerId) {
		LOG.info("Opening IndexWriter for Path {} analyzer {}", path, analyzerId);
		Directory directory = null;
		IndexHolder writerHolder = getIndexWriter(path);
		if (writerHolder != null) {
			if(writerHolder.analyzerId.equals(analyzerId)) {
				LOG.info("IndexWriter for Path {} is already open", path);
				return writerHolder.writer;
			} else {
				closeIndexWriter(path, true);
			}
		}
		try {
			Analyzer analyzer = analyzerRegistry.getAnalyzer(analyzerId);
			IndexWriterConfig config = new IndexWriterConfig(analyzer);
			directory = getDirectory(path);
			configureIndexWriter(config);
			IndexWriter writer = new IndexWriter(directory, config);
			addWriter(path, analyzerId, writer);
			return writer;
		} catch (Exception e) {
			LOG.error("Error while opening new Indexwriter for Path "+ path + " with analyzer " + analyzerId, e);
			throw new SearchIndexException("Error creating IndexWriter from the directory " + directory.getClass().getName(), e);
		}
	}
	
	private void addWriter(String path, String analyzerId, IndexWriter writer) {
		writerMap.put(path, new IndexHolder(analyzerId, writer));
	}

	/* (non-Javadoc)
	 * @see de.dim.search.index.lucene.writer.IIndexWriterProvider#openFacetWriter(java.lang.String)
	 */
	@Override
	public synchronized TaxonomyWriter openFacetWriter(String path) {
		LOG.info("Opening FacetWriter for Path {}", path);
		Directory directory = null;
		String facetPath = path + FACET_INDEX_SUFIX; 
		TaxonomyWriter writer = facetWriterMap.get(facetPath);
		if (writer != null) {
			LOG.info("FacetWriter for Path {} is already open", path);
			return writer;
		}
		try {
			directory = getDirectory(facetPath);
			writer = new DirectoryTaxonomyWriter(directory);
			facetWriterMap.put(facetPath, writer);
			return writer;
		} catch (Exception e) {
			throw new SearchIndexException("Error creating IndexWriter from the directory " + directory.getClass().getName(), e);
		}
	}

	/* (non-Javadoc)
	 * @see de.dim.search.index.lucene.writer.IIndexWriterProvider#openSearchableFacetWriter(java.lang.String, java.lang.String)
	 */
	@Override
	public synchronized IndexWriter openSearchableFacetWriter(String path, String analyzerId) {
		LOG.info("Opening Searchable FacetWriter for Path {} analyzer {}", path, analyzerId);
		Directory directory = null;
		String facetPath = path + SEARCHABLE_FACET_INDEX_SUFIX; 
		IndexHolder writerHolder = getIndexWriter(facetPath);
		if (writerHolder != null) {
			if(writerHolder.analyzerId.equals(analyzerId)) {
				LOG.info("Searchable FacetWriter for Path {} is already open", path);
				return writerHolder.writer;
			} else {
				closeIndexWriter(facetPath, true);
			}
		}
		try {
			Analyzer analyzer = analyzerRegistry.getAnalyzer(analyzerId);
			IndexWriterConfig config = new IndexWriterConfig(analyzer);
			directory = getDirectory(facetPath);
			configureIndexWriter(config);
			IndexWriter writer = new IndexWriter(directory, config);
			addWriter(facetPath, analyzerId, writer);
			return writer;
		} catch (Exception e) {
			e.printStackTrace();
			throw new SearchIndexException("Error creating IndexWriter from the directory " + directory.getClass().getName(), e);
		}
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.index.lucene.writer.IIndexWriterProvider#closeIndexWriter(java.lang.String, boolean)
	 */
	@Override
	public boolean closeIndexWriter(String path, boolean waitForMerges) {
		LOG.info("Closing IndexWriter for Path {}", path);
		IndexHolder writerHolder = writerMap.remove(path);
		if (writerHolder == null) {
			return false;
		}
		try {
			writerHolder.writer.close();
			return true;
		} catch (CorruptIndexException e) {
			throw new SearchIndexException("Error closing corrupt index.", e);
		} catch (IOException e) {
			throw new SearchIndexException("Error closing index.", e);
		}
	}
	
	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.index.lucene.writer.IIndexWriterProvider#commitIndexWriter(java.lang.String)
	 */
	@Override
	public void commitIndexWriter(String path, String analizerId) {
		IndexHolder writerHolder = getIndexWriter(path);
		if (writerHolder == null) {
			return;
		}
		if(!writerHolder.analyzerId.equals(analizerId)) {
			LOG.warn("It appears somebody has reopend your writer before you commited it with a new analizer. This should be analyzed!");
		}
		try {
			doCommit(writerHolder.writer, path);
		} catch (CorruptIndexException e) {
			throw new SearchIndexException("Error commiting corrupt index.", e);
		} catch (IOException e) {
			throw new SearchIndexException("Error commiting index.", e);
		}
	}
	
	/* (non-Javadoc)
	 * @see de.dim.search.index.lucene.writer.IIndexWriterProvider#commitFacetWriter(java.lang.String, de.dim.searchindex.FacetContext)
	 */
	@Override
	public void commitFacetWriter(String path) {
		TaxonomyWriter writer = getFacetWriter(path);
		if (writer == null) {
			return;
		}
		try {
			doCommit(writer, path + FACET_INDEX_SUFIX);
		} catch (CorruptIndexException e) {
			throw new SearchIndexException("Error commiting corrupt index.", e);
		} catch (IOException e) {
			throw new SearchIndexException("Error commiting index.", e);
		}
	}
	
	/* (non-Javadoc)
	 * @see de.dim.search.index.lucene.writer.IIndexWriterProvider#commitIndexWriter(org.apache.lucene.index.TwoPhaseCommit)
	 */
	@Override
	public void commitIndexWriter(TwoPhaseCommit writer) throws IOException {
		String path = findWriterPath(writer);
		doCommit(writer, path);
	}

	/**
	 * Does the actual commit and informs a known {@link SearcherManager} to refresh 
	 * @param writer the Writer to commit
	 * @param path the path of the writer
	 * @throws IOException in case something happens
	 */
	private void doCommit(final TwoPhaseCommit writer, final String path) throws IOException {
		writer.commit();
		if(path != null){
			refreshExecutors.submit(new Runnable() {
				@Override
				public void run() {
					SearcherManager searcherManager;
					try {
						searcherManager = getSearcherManager(path);
						if(searcherManager != null){
							searcherManager.maybeRefresh();
						}
					} catch (IOException e) {
						LOG.error("Could not update SearcherManager for path " + path + ", because " + e.getMessage(), e);
					} 
				}
			});
		}
	}

	/**
	 * Finds the Writer and its Path
	 * @param writer the writer to look for
	 * @return the {@link CommitContext} as PoJO holding the writer and its path
	 */
	private String findWriterPath(TwoPhaseCommit writer) {
		if(writer instanceof IndexWriter){
			for (Entry<String, IndexHolder> entry : writerMap.entrySet()) {
				if(entry.getValue().writer.equals(writer)){
					return entry.getKey();
				}
			}
		} else {
			for(Entry<String, TaxonomyWriter> entry : facetWriterMap.entrySet()){
				if(entry.getValue().equals(writer)){
					return entry.getKey();
				}
			}
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see de.dim.search.index.lucene.writer.IIndexWriterProvider#createIndexDocumentsForSearchableFacetIndex(de.dim.searchindex.SearchableFacetDocumentObject)
	 */
	@Override
	public Document createIndexDocumentsForSearchableFacetIndex(
			SearchableFacetDocumentObject object) {
		Document indexDocument = new Document();

		indexDocument.add(new StringField("id", object.getId(), Store.YES));
		indexDocument.add(new StringField("facet", object.getFacet(), Store.YES));
		indexDocument.add(new StringField("translationFieldKey", object.getTranslationFieldKey(), Store.YES));
		indexDocument.add(new StringField("language", object.getLanguage(), Store.YES));
		indexDocument.add(new StringField("systemName", object.getSystemName(), Store.YES));
		indexDocument.add(new TextField("translation", object.getTranslation(), Store.YES));
		return indexDocument;
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.index.lucene.writer.IIndexWriterProvider#createIndexDocuments(de.dim.searchindex.IndexObject)
	 */
	@Override
	public List<Document> createIndexDocuments(IndexObject indexObject) {
		List<Document> documentList = new LinkedList<Document>();
		if (indexObject == null) {
			return documentList;
		}
		doCreateDocuments(documentList, indexObject);
		return documentList;
	}
	
	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.index.lucene.writer.IIndexWriterProvider#dropIndex(java.lang.String)
	 */
	@Override
	public void dropIndex(String path) {
		try {
			IndexHolder writerHolder = getIndexWriter(path);
			IndexWriter writer = writerHolder != null ? writerHolder.writer : null;
			if (writer == null) {
				writer = openIndexWriter(path, DEFAULT_ANALYZER_ID);
			}
			writer.deleteAll();
			doCommit(writer, path);
			//also delete the Searchable Facet Index
			writer = openSearchableFacetWriter(path, DEFAULT_ANALYZER_ID);
			writer.deleteAll();
			doCommit(writer, path);
		} catch (IOException e) {
			throw new SearchIndexException("Error dropping lucene index for path: " + path, e);
		}
	}
	
	@Override
	public Analyzer getAnalyizerById(String analyzerId) {
		if(analyzerId == null){
			analyzerId = DEFAULT_ANALYZER_ID;
		}
		Analyzer analyzer = analyzerRegistry.getAnalyzer(analyzerId);
		if(analyzer == null){
			return analyzerRegistry.getAnalyzer(DEFAULT_ANALYZER_ID);
		}
		return analyzer;
	}
	
	/* (non-Javadoc)
	 * @see de.dim.search.index.lucene.writer.IIndexWriterProvider#getSearcherManager(java.lang.String)
	 */
	@Override
	public SearcherManager getSearcherManager(String path) throws IOException {
		searcherManagerLock.lock();
		try{
			SearcherManager manager = searcherManagerMap.get(path);
			if(manager == null){
				manager = new SearcherManager(getDirectory(path), null);
				searcherManagerMap.put(path, manager);
			}
			return manager;
		} finally {
			searcherManagerLock.unlock();
		}
	}
	
	/* (non-Javadoc)
	 * @see de.dim.search.index.lucene.writer.IIndexWriterProvider#closeSearcherManager(org.apache.lucene.search.SearcherManager)
	 */
	@Override
	public void closeSearcherManager(SearcherManager manager) throws IOException {
		searcherManagerLock.lock();
		try{
			String path = null;
			for(Entry<String, SearcherManager> entry : searcherManagerMap.entrySet()){
				if(entry.getValue().equals(manager)){
					path = entry.getKey();
					break;
				}
			}
			searcherManagerMap.remove(path);
			manager.close();
		} finally {
			searcherManagerLock.unlock();
		}
	}
	
	/**
	 * Returns the index writer instance
	 * @param path the index path
	 * @param analizerid the analizers id the wanted writer has. if the id is null, the first available writer will be returend
	 * @return the index writer instance
	 */
	public IndexHolder getIndexWriter(String path) {
		return writerMap.get(path); 
	}
	
	/**
	 * Returns the index writer instance
	 * @param path the index path
	 * @return the index writer instance
	 */
	public TaxonomyWriter getFacetWriter(String path) {
		String thePath = path + FACET_INDEX_SUFIX;
		return facetWriterMap.get(thePath);
	}

	/**
	 * Adds a index writer configurer to the system 
	 * @param configurer the index writer configurer to add
	 */
	public void addConfigurer(IIndexWriterConfigurer configurer) {
		synchronized (this.configurerList) {
			if (configurer != null) {
				this.configurerList.add(configurer);
			}
		}
	}
	
	/**
	 * Removes a index writer configurer from the system 
	 * @param configurer the index writer configurer to remove
	 */
	public void removeConfigurer(IIndexWriterConfigurer configurer) {
		synchronized (this.configurerList) {
			if (configurer != null) {
				this.configurerList.remove(configurer);
			}
		}
	}
	
	/**
	 * Sets the analyzer registry
	 * @param analyzerRegistry
	 */
	public void setAnalyzerRegistry(LuceneAnalyzerRegistry analyzerRegistry) {
		this.analyzerRegistry = analyzerRegistry;
	}
	
	/**
	 * Disposes all index writer
	 */
	public void dispose() {
		searcherManagerLock.lock();
		for (String key : searcherManagerMap.keySet()) {
			SearcherManager manager = searcherManagerMap.get(key);
			try {
				manager.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		searcherManagerLock.unlock();
		writerMap.clear();
		writerMap.entrySet().forEach(entry -> {
			
				try {
					entry.getValue().writer.commit();
					entry.getValue().writer.close();
				} catch (IOException e) {
					LOG.error("Error while finally commiting and closing writer for path " + entry.getKey() + " on disposing of the service", e);
				}
			}
		);
		writerMap.clear();
		for (String key : facetWriterMap.keySet()) {
			TaxonomyWriter writer = facetWriterMap.get(key);
			try {
				writer.commit();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		facetWriterMap.clear();
	}
	
	/**
	 * Returns the lucene directory to create the index writer from
	 * @param the path
	 * @return the lucene directory to create the index writer from
	 */
	protected abstract Directory getDirectory(String path);

	/**
	 * Creates the documents from the index object
	 * @param documents the lucene documents as result
	 * @param indexObject the index object
	 */
	@SuppressWarnings("unchecked")
	protected void doCreateDocuments(List<Document> documents, IndexObject indexObject) {
		try {
			Document indexDocument = new Document();
			for (IndexFieldObject indexFieldObject : indexObject.getFieldObjects()) {
				IndexField indexField = indexFieldObject.getField();
				Object value = indexFieldObject.getValue();
				if (value == null) {
					continue;
				}
				if (value instanceof List<?>) {
					List<?> values = (List<?>) value;
					for (Object o : values) {
						if (o != null) {
							addField(o, indexField, indexDocument);
						}
					}
					
				} else if(indexField instanceof SpatialField && value instanceof LatLng){
					createSpatialFields((LatLng) value, (SpatialField) indexField, indexDocument);
				} else {
					addField(value, indexField, indexDocument);
				}
			}
			for(FacetFieldObject ffo : indexObject.getFacetObjects()){
				String[] value = null;
				String storedValue = null;
				if(ffo.getValue() instanceof List){
					List<String> hirachy = (List<String>) ffo.getValue();
					value = hirachy.toArray(new String[0]);
				} 
				if (ffo.getValue() instanceof String[]){
					if(!ffo.getField().isHirachical()){
						throw new IllegalArgumentException("The FacetFieldObject " + ffo.getField().getKey() + " has more then one value. This is not allowed for fields with isHirachical == false");
					}
					value = (String[]) ffo.getValue();
					StringBuilder builder = new StringBuilder();
					for(String curValue : (String[])  value){
						builder.append('$');
						builder.append(curValue);
					}
					storedValue = builder.toString();
				} else if (ffo.getValue() instanceof String){
					String curValue = (String) ffo.getValue();
					storedValue = "$" + curValue;
					value = new String[]{(String) curValue};
				} else {
					throw new IllegalArgumentException("Facet " + ffo.getField().getKey() + " has an unsupported value " + ffo.getValue());
				}
				
				//Add the Facet as stored field again, so we can extract them later for the categorisation
				indexDocument.add(new StringField("_facet", ffo.getField().getKey() + storedValue, Store.YES));
				
				
				indexDocument.add(new FacetField(ffo.getField().getKey(), value));
			}
			documents.add(indexDocument);
		} catch (Exception e) {
			throw new SearchIndexException("Error create Lucene documents for document with id " + indexObject.getIdField().getValue(), e);
		}
	}

	/**
	 * Configures the index writer
	 * @param configuration the index writer configuration instance
	 */
	protected void configureIndexWriter(IndexWriterConfig configuration) {
		if (configuration == null) {
			return;
		}
		for (IIndexWriterConfigurer configurer : configurerList) {
			configurer.configureIndexWriter(configuration);
		}
	}

	/**
	 * Creates a lucene field for the given model an value
	 * @param value the payload value
	 * @param indexField the field model
	 * @return the Lucene field
	 */
	private void addField(Object value, IndexField indexField, Document doc) {
		
		Field.Store store = indexField.getStore().equals(StoreType.YES) ? Field.Store.YES : Field.Store.NO;
		
		
		FieldType fieldType = new FieldType();
		fieldType.setOmitNorms(indexField.isOmitNorms());
		fieldType.setStored(indexField.getStore().equals(StoreType.YES));

	
		switch (indexField.getType()) {
		case BOOST:
			long boostValue = value instanceof Long ? (long) value : Long.parseLong(value.toString());
			doc.add(new NumericDocValuesField(indexField.getKey(), boostValue));
			if(indexField.getStore().equals(StoreType.YES)) {
				doc.add(new StoredField(indexField.getKey(), boostValue));
			}
			break;
		case DOUBLE:
			double doubleValue = value instanceof Double ? (double) value : Double.parseDouble(value.toString());
			doc.add(new DoublePoint(indexField.getKey(), doubleValue));
			if(indexField.getStore().equals(StoreType.YES)) {
				doc.add(new StoredField(indexField.getKey(), doubleValue));
			}
			break;
		case FLOAT:
			float floatValue = value instanceof Float ? (float) value : Float.parseFloat(value.toString());
			doc.add(new FloatPoint(indexField.getKey(), floatValue));
			if(indexField.getStore().equals(StoreType.YES)) {
				doc.add(new StoredField(indexField.getKey(), floatValue));
			}
			break;
		case INT:
		case SHORT:
			int intValue = value instanceof Integer ? (int) value : Integer.parseInt(value.toString());
			doc.add(new IntPoint(indexField.getKey(), intValue));
			if(indexField.getStore().equals(StoreType.YES)) {
				doc.add(new StoredField(indexField.getKey(), intValue));
			}
			break;
		case LONG:
			long longValue = value instanceof Long ? (long) value : value instanceof Date ? ((Date)value).getTime() : Long.parseLong(value.toString());
			doc.add(new LongPoint(indexField.getKey(), longValue));
			if(indexField.getStore().equals(StoreType.YES)) {
				doc.add(new StoredField(indexField.getKey(), longValue));
			}
			break;
		case TEXT:
		case SHINGLE:
			if (indexField.getTermVector().equals(TermVectorType.NO)) {
				doc.add( new TextField(indexField.getKey(), value.toString(), store));
			} else {
//				fieldType.setIndexed(true);
				fieldType.setIndexOptions(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS);
				fieldType.setStored(store.equals(Store.YES));
				fieldType.setTokenized(true);
			    Field field = new Field(indexField.getKey(), value.toString(), fieldType);
			    field.setBoost(indexField.getBoost());
			    doc.add(field);
			}
			break;
		case SORTED_DOC_VALUE:
			doc.add(new SortedDocValuesField(indexField.getKey(), new BytesRef(value.toString().getBytes())));
			if(indexField.getStore().equals(StoreType.YES)) {
				doc.add(new StoredField(indexField.getKey(), value.toString()));
			}
			break;
		case SORTED_NUMERIC_DOC_VALUE:
			doc.add(new SortedNumericDocValuesField(indexField.getKey(),value instanceof Long ? (long) value : Long.valueOf((int) value)));
			if(indexField.getStore().equals(StoreType.YES)) {
				doc.add(new StoredField(indexField.getKey(), Long.valueOf((int) value)));
			}
			break;
		case BINARY_DOC_VALUE:
			doc.add(new BinaryDocValuesField(indexField.getKey(), new BytesRef(value.toString().getBytes())));
			if(indexField.getStore().equals(StoreType.YES)) {
				doc.add(new StoredField(indexField.getKey(), value.toString().getBytes()));
			}
			break;
		case STRING:
		default:
			doc.add(new StringField(indexField.getKey(), value.toString(), store));
			break;
		}
	}

	/**
	 * Creates the necessary IndexFields to enable a spatial search on them 
	 * @param value the LatLng Object representing the point
	 * @param indexField the {@link SpatialField} from the descriptor
	 * @return a {@link List} of {@link Field} to add to the document
	 */
	private void createSpatialFields(LatLng value, SpatialField indexField, Document doc) {
		Field field = new LatLonPoint (indexField.getKey(), value.getLatitude() ,value.getLongitude());
		doc.add(field);
	}
	
}
