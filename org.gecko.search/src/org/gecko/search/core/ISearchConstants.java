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
package org.gecko.search.core;

/**
 * Interface with common constants
 * @author Mark Hoffmann
 * @since 01.10.2011
 */
public interface ISearchConstants {
	
	/**
	 * Source for the annotation
	 */
	public static final String ANNOTATION_SOURCE = "http://geckoware.de/search/1.0/Index";
	
	/**
	 * Annotation key for the index file path on a {@link EClass}. 
	 */
	public static final String ANNOTATION_KEY_PATH = "path";
	
	/**
	 * Annotation key for the index id on an {@link EEnum}, {@link EReference} or {@link EAttribute}
	 */
	public static final String ANNOTATION_KEY_ID = "id";
	
	/**
	 * Annotation key for {@link EReference}s, that don't have a own index file and will be a containment
	 * for child attributes of the parent index object.
	 */
	public static final String ANNOTATION_KEY_CHILD = "child";
	
	/**
	 * Annotation key to indicate if the property should be analyzed or not
	 */
	public static final String ANNOTATION_KEY_ANALYZED = "analyzed";
	
	/**
	 * Annotation that indicated the boost factor as float for the annotated field
	 */
	public static final String ANNOTATION_KEY_BOOSt = "boost";
	
	/**
	 * The primary key constant that is used as index field name
	 */
	public static final String INDEX_KEY = "_key";
	
	/**
	 * Constant for a identifier of the key, which values defines the identifier for an object type
	 */
	public static final String INDEX_KEY_IDENTIFIER = "_keyIdentifier";
	
	/**
	 * Constant for index field to index the descriptor id
	 */
	public static final String INDEX_MASTER_DESCRIPTOR = "_masterDescriptorId";
	
	/**
	 * Constant for the sub descriptor container identifier of the index
	 */
	public static final String INDEX_DESCRIPTOR = "_descriptorId";
	
	/**
	 * Constant for the master category identifier of the index
	 */
	public static final String INDEX_MASTER_CATEGORY = "_masterCategory";
	
	/**
	 * Constant for the sub master category identifier of the index
	 */
	public static final String INDEX_CATEGORY = "_category";
	
	/**
	 * Constant for the display text that will be presented in the UI
	 */
	public static final String DISPLAY_TEXT = "_displayText";
	
	/**
	 * Constant for the display description that will be presented in the UI
	 */
	public static final String DISPLAY_DESCRIPTION = "_displayDescription";

}
