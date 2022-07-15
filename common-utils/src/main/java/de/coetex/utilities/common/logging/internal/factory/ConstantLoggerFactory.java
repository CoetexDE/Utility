package de.coetex.utilities.common.logging.internal.factory;

import de.coetex.utilities.common.logging.ILogger;
import de.coetex.utilities.common.logging.ILoggerFactory;
import de.coetex.utilities.common.logging.LogLevel;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;


public class ConstantLoggerFactory implements ILoggerFactory {

	protected final ILogger logger;

	public ConstantLoggerFactory(@Nonnull ILogger logger) {
		this.logger = logger;
	}

	@Nonnull
	@Override
	public ILogger forName(@Nullable String name) {
		return logger;
	}

	@Override
	public void setDefaultLevel(@Nonnull LogLevel level) {
		logger.setMinLevel(level);
	}

}
