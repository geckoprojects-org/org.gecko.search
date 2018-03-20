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

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;

/**
 * Index writer base of a RAM directory
 * @author Mark Hoffmann
 * @since 04.08.2014
 */
public class RamIndexWriter extends AbstractIndexWriterProvider {

	private Map<String, Directory> directories = new ConcurrentHashMap<String, Directory>();
	
	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.index.core.IIndexWriterProvider#getWriterProviderId()
	 */
	@Override
	public String getWriterProviderId() {
		return "indexWriter.ram";
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.index.lucene.writer.impl.AbstractIndexWriterProvider#getDirectory(java.lang.String)
	 */
	@Override
	public Directory getDirectory(String path) {
		Directory dir = directories.get(path);
		
		if(dir == null){
			dir = new RAMDirectory();
			directories.put(path, dir);
		}
		return dir;
	}

}
