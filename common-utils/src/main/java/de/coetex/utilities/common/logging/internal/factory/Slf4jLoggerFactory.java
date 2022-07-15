package de.coetex.utilities.common.logging.internal.factory;

import de.coetex.utilities.common.logging.LogLevel;
import de.coetex.utilities.common.logging.ILogger;
import de.coetex.utilities.common.logging.ILoggerFactory;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;


public class Slf4jLoggerFactory implements ILoggerFactory {

	@Nonnull
	@Override
	public ILogger forName(@Nullable String name) {
		return ILogger.forSlf4jLogger(
			LoggerFactory.getLogger(name == null ? "Logger" : name)
		);
	}

	@Override
	public void setDefaultLevel(@Nonnull LogLevel level) {
	}

}
