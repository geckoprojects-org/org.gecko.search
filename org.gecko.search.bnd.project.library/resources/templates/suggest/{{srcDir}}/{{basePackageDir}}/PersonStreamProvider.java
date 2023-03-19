/**
 * Copyright (c) 2012 - 2023 Data In Motion and others.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *     Data In Motion - initial API and implementation
 */
package {{basePackageName}};

import static {{basePackageName}}.helper.PersonSuggestHelper.createPerson;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.stream.Stream;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

import {{basePackageName}}.pojo.Person;

import org.osgi.util.pushstream.PushStream;
import org.osgi.util.pushstream.PushStreamProvider;

/**
 * Provider component for the PushStream. Registers the PushStream as a service
 */
@Component
public class PersonStreamProvider {
	
	@SuppressWarnings("rawtypes")
	private ServiceRegistration<PushStream> registration;

	@Activate
	public void activate(BundleContext ctx) {
		Person p01 = createPerson("et", "Emil", "Tester", 42);
		Person p02 = createPerson("eta", "Emilia", "Testerowski", 23);
		Person p03 = createPerson("demo", "Peter", "Emiskowski", 12);
		PushStreamProvider psp = new PushStreamProvider();
		PushStream<Person> stream = psp.streamOf(Stream.of(p01, p02, p03));
		Dictionary<String, Object> properties = new Hashtable<>();
		properties.put("streamName", "personStream");
		registration = ctx.registerService(PushStream.class, stream, properties);
	}
	
	@Deactivate
	public void deactivate() {
		if (registration != null) {
			registration.unregister();
		}
	}

}
