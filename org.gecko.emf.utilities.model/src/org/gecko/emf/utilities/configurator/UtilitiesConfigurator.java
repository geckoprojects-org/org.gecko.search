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
package org.gecko.emf.utilities.configurator;

import org.gecko.emf.osgi.EPackageConfigurator;
import org.gecko.emf.osgi.annotation.EMFModel;
import org.gecko.emf.osgi.annotation.provide.ProvideEMFModel;
import org.gecko.emf.utilities.UtilPackage;
import org.osgi.service.component.annotations.Component;

/**
 * Configurator for the EMFCollection model
 * @author Mark Hoffmann
 * @since 26.07.2017
 */
@Component(name= UtilPackage.eNAME + "Configurator", immediate=true, service=EPackageConfigurator.class)
@EMFModel(emf_model_name = UtilPackage.eNAME, emf_model_nsURI = UtilPackage.eNS_URI, emf_model_version = "1.0")
@ProvideEMFModel(name = UtilPackage.eNAME, nsURI = UtilPackage.eNS_URI, version = "1.0")
public class UtilitiesConfigurator implements EPackageConfigurator {

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.emf.osgi.EPackageConfigurator#configureEPackage(org.eclipse.emf.ecore.EPackage.Registry)
	 */
	@Override
	public void configureEPackage(org.eclipse.emf.ecore.EPackage.Registry registry) {
		UtilPackage.eINSTANCE.getClass();
		registry.put(UtilPackage.eNS_URI, UtilPackage.eINSTANCE);
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.emf.osgi.EPackageConfigurator#unconfigureEPackage(org.eclipse.emf.ecore.EPackage.Registry)
	 */
	@Override
	public void unconfigureEPackage(org.eclipse.emf.ecore.EPackage.Registry registry) {
		registry.remove(UtilPackage.eNS_URI);
	}

}
