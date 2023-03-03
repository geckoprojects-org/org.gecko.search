/**
 * Copyright (c) 2012 - 2023 Data In Motion and others.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made available under the terms of the 
 * Eclipse Public License v2.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *     Data In Motion - initial API and implementation
 */
package org.gecko.search.suggest.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.gecko.search.suggest.api.SuggestionConstants;
import org.osgi.annotation.bundle.Requirement;

/**
 * Annotation to define a require capability for the gecko search suggestion
 * @author Mark Hoffmann
 * @since 08.12.2018
 */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target({
		ElementType.TYPE, ElementType.PACKAGE
})
@Requirement(namespace = SuggestionConstants.CAPABILITY_NS, //
		name = SuggestionConstants.CAPABILITY_NAME, //
		version = SuggestionConstants.CAPABILITY_VERSION)
public @interface RequireSearchSuggestion {

}
