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

import java.io.File;
import java.io.IOException;

import org.apache.lucene.store.Directory;
import org.apache.lucene.store.MMapDirectory;
import org.gecko.search.core.provider.ISearchWorkspaceProvider;
import org.gecko.search.index.core.SearchIndexException;
import org.gecko.search.index.lucene.analyzer.LuceneAnalyzerRegistry;
import org.gecko.search.index.lucene.writer.IIndexWriterProvider;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;

/**
 * MMap index writer provider
 * @author Mark Hoffmann
 * @since 07.08.2014
 */
@Component(service = IIndexWriterProvider.class, property = {
		"type=MMAP",
		"ws=WS"
})
public class MMapIndexWriter extends AbstractIndexWriterProvider {

	private ISearchWorkspaceProvider workspaceProvider;
	
	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.index.lucene.writer.IIndexWriterProvider#getWriterProviderId()
	 */
	@Override
	public String getWriterProviderId() {
		return "indexWriter.mmap";
	}

	/* 
	 * (non-Javadoc)
	 * @see de.dim.search.index.lucene.writer.impl.AbstractIndexWriterProvider#getDirectory(java.lang.String)
	 */
	@Override
	protected Directory getDirectory(String path) {
		File file = new File(getWorkspaceProvider().getIndexWorkspaceLocation() + "/" + path);
		try {
			return MMapDirectory.open(file.toPath());
		} catch (IOException e) {
			throw new SearchIndexException("Error opening file directory for index at location: " + file.getAbsolutePath(), e);
		}
	}
	
	@Deactivate
	public void deactivate() {
		dispose();
	}

	/**
	 * Returns the workspaceProvider.
	 * @return the workspaceProvider
	 */
	public ISearchWorkspaceProvider getWorkspaceProvider() {
		return workspaceProvider;
	}

	/**
	 * Sets the workspace provider.
	 * @param workspaceProvider the workspace provider to set
	 */
	@Reference(cardinality = ReferenceCardinality.MANDATORY, target = "(type=workspace)")
	public void setWorkspaceProvider(ISearchWorkspaceProvider workspaceProvider) {
		this.workspaceProvider = workspaceProvider;
	}
	
	/**
	 * Un-sets the workspace provider.
	 * @param workspaceProvider the workspace provider to unset
	 */
	public void unsetWorkspaceProvider(ISearchWorkspaceProvider workspaceProvider) {
		this.workspaceProvider = workspaceProvider;
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.search.index.lucene.writer.impl.AbstractIndexWriterProvider#setAnalyzerRegistry(org.gecko.search.index.lucene.analyzer.LuceneAnalyzerRegistry)
	 */
	@Override
	@Reference(cardinality = ReferenceCardinality.MANDATORY, policy = ReferencePolicy.STATIC)
	public void setAnalyzerRegistry(LuceneAnalyzerRegistry analyzerRegistry) {
		super.setAnalyzerRegistry(analyzerRegistry);
	}
}
