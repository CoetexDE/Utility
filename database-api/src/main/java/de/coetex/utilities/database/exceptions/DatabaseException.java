package de.coetex.utilities.database.exceptions;

import de.coetex.utilities.database.action.DatabaseAction;

import javax.annotation.Nonnull;

/**

 *
 * @see DatabaseAlreadyConnectedException
 * @see DatabaseConnectionClosedException
 * @see DatabaseUnsupportedFeatureException
 *
 * @see DatabaseAction#execute()
 */
public class DatabaseException extends Exception {

	protected DatabaseException() {
		super();
	}

	public DatabaseException(@Nonnull String message) {
		super(message);
	}

	public DatabaseException(@Nonnull Throwable cause) {
		super(cause);
	}

	public DatabaseException(@Nonnull String message, @Nonnull Throwable cause) {
		super(message, cause);
	}
}
