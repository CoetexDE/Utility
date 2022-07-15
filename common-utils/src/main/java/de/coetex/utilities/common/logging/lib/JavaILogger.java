package de.coetex.utilities.common.logging.lib;

import de.coetex.utilities.common.logging.ILogger;
import de.coetex.utilities.common.logging.LogLevel;

import javax.annotation.Nonnull;
import java.util.logging.Logger;

/**

 */
public abstract class JavaILogger extends Logger implements ILogger {

	protected JavaILogger(String name, String resourceBundleName) {
		super(name, resourceBundleName);
	}

	@Nonnull
	@Override
	public abstract JavaILogger setMinLevel(@Nonnull LogLevel level);

}
