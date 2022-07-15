package de.coetex.utilities.common.collection;

import javax.annotation.Nonnull;

/**

 */
public class PublicSecurityManager extends SecurityManager {

	@Nonnull
	public Class<?>[] getPublicClassContext() {
		return getClassContext();
	}

}
