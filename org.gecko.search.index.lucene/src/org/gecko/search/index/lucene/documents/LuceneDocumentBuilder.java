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
package org.gecko.search.index.lucene.documents;

import java.util.Date;
import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.DoublePoint;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.FloatPoint;
import org.apache.lucene.document.IntPoint;
import org.apache.lucene.document.LongPoint;
import org.apache.lucene.document.NumericDocValuesField;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.facet.FacetField;
import org.gecko.emf.utilities.LatLng;
import org.gecko.search.core.exceptions.SearchException;
import org.gecko.search.index.core.SearchIndexException;
import org.gecko.searchindex.FacetFieldObject;
import org.gecko.searchindex.IndexField;
import org.gecko.searchindex.IndexFieldObject;
import org.gecko.searchindex.IndexObject;
import org.gecko.searchindex.SpatialField;
import org.gecko.searchindex.StoreType;

/**
 * Builder class to create Lucene documents from {@link IndexObject}
 * @author Mark Hoffmann
 * @since 06.10.2014
 */
@Deprecated
public class LuceneDocumentBuilder {

  /**
   * Creates the documents from the index object
   * @param documents the lucene documents as result
   * @param indexObject the index object
   */
  protected void buildDocuments(List<Document> documents, IndexObject indexObject) {
    try {
      Document indexDocument = new Document();
      for (IndexFieldObject indexFieldObject : indexObject.getFieldObjects()) {
        createField(indexDocument, indexFieldObject);
      }
      for(FacetFieldObject ffo : indexObject.getFacetObjects()){
        createFacetField(ffo, indexDocument);
      }
      documents.add(indexDocument);
    } catch (Exception e) {
      throw new SearchIndexException("Error create Lucene documents", e);
    }
  }

  /**
   * Creates a Lucene field from the {@link IndexFieldObject}
   * @param document the Lucene {@link Document}
   * @param indexFieldObject the index field model
   */
  private void createField(Document document, IndexFieldObject indexFieldObject) {
    IndexField indexField = indexFieldObject.getField();
    Object value = indexFieldObject.getValue();
    if (value == null) {
      return;
    }
    if (value instanceof List<?>) {
      List<?> values = (List<?>) value;
      for (Object o : values) {
        if (o != null) {
          Field field = createLuceneField(o, indexField);
          document.add(field);
        }
      }

    } else if(indexField instanceof SpatialField && value instanceof LatLng){
      List<Field> spatialFields = createSpatialFields((LatLng) value, (SpatialField) indexField);
      for(Field f : spatialFields){
        document.add(f);
      }
    } else {
      Field field = createLuceneField(value, indexField);
      document.add(field);
    }
  }

  /**
   * Creates field for facetted search
   * @param facetObject the facet field object
   * @param document the Lucene index document
   */
  @SuppressWarnings("unchecked")
  private void createFacetField(FacetFieldObject facetObject, Document document) {
    String[] value = null;
    String storedValue = null;
    if(facetObject.getValue() instanceof List){
      List<String> hierarchy = (List<String>) facetObject.getValue();
      value = hierarchy.toArray(new String[0]);
    } 
    if (facetObject.getValue() instanceof String[]){
      if(!facetObject.getField().isHirachical()){
        throw new SearchException("The FacetFieldObject " + facetObject.getField().getKey() + " has more then one value. This is not allowed for fields with isHirachical == false");
      }
      value = (String[]) facetObject.getValue();
      StringBuilder builder = new StringBuilder();
      for(String curValue : (String[])  value){
        builder.append('$');
        builder.append(curValue);
      }
      storedValue = builder.toString();
    } else if (facetObject.getValue() instanceof String){
      String curValue = (String) facetObject.getValue();
      storedValue = "$" + curValue;
      value = new String[]{(String) curValue};
    } else {
      throw new IllegalArgumentException("Facet " + facetObject.getField().getKey() + " has an unsupported value " + facetObject.getValue());
    }
    //Add the Facet as stored field again, so we can extract them later for the categorisation
    document.add(new StringField("_facet", facetObject.getField().getKey() + storedValue, Store.YES));
    document.add(new FacetField(facetObject.getField().getKey(), value));
  }

  /**
   * Creates a Lucene field for the given model an value
   * @param value the payload value
   * @param indexField the field model
   * @return the Lucene field
   */
  private Field createLuceneField(Object value, IndexField indexField) {
    Field.Store store = indexField.getStore().equals(StoreType.YES) ? Field.Store.YES : Field.Store.NO;
    // create field type
    boolean stored = StoreType.YES.equals(indexField.getStore());

    Field field = null;
    switch (indexField.getType()) {
      // special field in Lucene used for boosting/ranking documents
      case BOOST:
        long boostValue = value instanceof Long ? (long) value : Long.parseLong(value.toString());
        if (!stored) {
          field = new NumericDocValuesField(indexField.getKey(), boostValue);
        }
        break;
      case DOUBLE:
        double doubleValue = value instanceof Double ? (double) value : Double.parseDouble(value.toString());
        if (stored) {
          field = new StoredField(indexField.getKey(), doubleValue);
        } else {
          field = new DoublePoint(indexField.getKey(), doubleValue);
        }
        break;
      case FLOAT:
        float floatValue = value instanceof Float ? (float) value : Float.parseFloat(value.toString());
        if (stored) {
          field = new StoredField(indexField.getKey(), floatValue);
        } else {
          field = new FloatPoint(indexField.getKey(), floatValue);
        }
        break;
      case INT:
      case SHORT:
        int intValue = value instanceof Integer ? (int) value : Integer.parseInt(value.toString());
        if (stored) {
          field = new StoredField(indexField.getKey(), intValue);
        } else {
          field = new IntPoint(indexField.getKey(), intValue);
        }
        break;
      case LONG:
        long longValue = value instanceof Long ? (long) value : value instanceof Date ? ((Date)value).getTime() : Long.parseLong(value.toString());
        if (stored) {
          field = new StoredField(indexField.getKey(), longValue);
        } else {
          field = new LongPoint(indexField.getKey(), longValue);
        }
        break;
      case TEXT:
        field = new TextField(indexField.getKey(), value.toString(), store);
        break;
      case STRING:
      default:
        field = new StringField(indexField.getKey(), value.toString(), store);
        break;
    }
    return field;
  }

  /**
   * Creates the necessary IndexFields to enable a spatial search on them 
   * @param value the LatLng Object representing the point
   * @param indexField the {@link SpatialField} from the descriptor
   * @return a {@link List} of {@link Field} to add to the document
   */
  private List<Field> createSpatialFields(LatLng value, SpatialField indexField) {
//    Field geoField = new GeoPointField(indexField.getKey(), value.getLongitude() ,value.getLatitude(), Store.NO);
//    return Arrays.asList(geoField);
	  return null;
  }

}
