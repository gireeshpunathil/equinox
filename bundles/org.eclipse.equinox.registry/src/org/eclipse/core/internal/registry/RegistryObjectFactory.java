/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.core.internal.registry;

/**
 * A factory method for the creation of the registry objects.
 */
public class RegistryObjectFactory {

	// The extension registry that this element factory works in
	protected ExtensionRegistry registry;

	public RegistryObjectFactory(ExtensionRegistry registry) {
		this.registry = registry;
	}

	////////////////////////////////////////////////////////////////////////////
	// Contribution
	public Contribution createContribution(long contributorId) {
		return new Contribution(contributorId, registry);
	}

	////////////////////////////////////////////////////////////////////////////
	// Extension point
	public ExtensionPoint createExtensionPoint() {
		return new ExtensionPoint(registry);
	}

	public ExtensionPoint createExtensionPoint(int self, int[] children, int dataOffset) {
		return new ExtensionPoint(self, children, dataOffset, registry);
	}

	////////////////////////////////////////////////////////////////////////////
	// Extension
	public Extension createExtension() {
		return new Extension(registry);
	}

	public Extension createExtension(int self, String simpleId, String namespace, int[] children, int extraData) {
		return new Extension(self, simpleId, namespace, children, extraData, registry);
	}

	////////////////////////////////////////////////////////////////////////////
	// Configuration element
	public ConfigurationElement createConfigurationElement() {
		return new ConfigurationElement(registry);
	}

	public ConfigurationElement createConfigurationElement(int self, long contributorId, long namespaceOwnerId, String name, String[] propertiesAndValue, int[] children, int extraDataOffset, int parent, byte parentType) {
		return new ConfigurationElement(self, contributorId, namespaceOwnerId, name, propertiesAndValue, children, extraDataOffset, parent, parentType, registry);
	}
}
