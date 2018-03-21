package org.gecko.search.result.lucene.highlight;

import java.io.IOException;
import java.util.Arrays;

import org.apache.lucene.index.FieldInfo;
import org.apache.lucene.index.StoredFieldVisitor;

public class OffSetLimitedStoredFieldVisitor extends StoredFieldVisitor {
    private final String fields[];
    private final char valueSeparators[];
    private final int maxLength;
    private final StringBuilder builders[];
    private int currentField = -1;
    
    public OffSetLimitedStoredFieldVisitor(String fields[], char valueSeparators[], int maxLength) {
      assert fields.length == valueSeparators.length;
      this.fields = fields;
      this.valueSeparators = valueSeparators;
      this.maxLength = maxLength;
      builders = new StringBuilder[fields.length];
      for (int i = 0; i < builders.length; i++) {
        builders[i] = new StringBuilder();
      }
    }
    
    @Override
    public void stringField(FieldInfo fieldInfo, byte[] value) throws IOException {
      stringField(fieldInfo, new String(value));
    }
    
    public void stringField(FieldInfo fieldInfo, String value) throws IOException {
      assert currentField >= 0;
      StringBuilder builder = builders[currentField];
      if (builder.length() > 0 && builder.length() < maxLength) {
        builder.append(valueSeparators[currentField]);
      }
      if (builder.length() + value.length() > maxLength) {
        builder.append(value, 0, maxLength - builder.length());
      } else {
        builder.append(value);
      }
    }

    @Override
    public Status needsField(FieldInfo fieldInfo) throws IOException {
      currentField = Arrays.binarySearch(fields, fieldInfo.name);
      if (currentField < 0) {
        return Status.NO;
      } else if (builders[currentField].length() > maxLength) {
        return fields.length == 1 ? Status.STOP : Status.NO;
      }
      return Status.YES;
    }
    
    String getValue(int i) {
      return builders[i].toString();
    }
    
    void reset() {
      currentField = -1;
      for (int i = 0; i < fields.length; i++) {
        builders[i].setLength(0);
      }
    }
  }