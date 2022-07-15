package de.coetex.utilities.database.exceptions;

import de.coetex.utilities.database.action.DatabaseAction;
import de.coetex.utilities.common.collection.WrappedException;

import javax.annotation.Nonnull;

/**

 *
 * @see DatabaseException
 *
 * @see DatabaseAction#executeUnsigned()
 */
public class UnsignedDatabaseException extends WrappedException {

	public UnsignedDatabaseException(@Nonnull DatabaseException cause) {
		super(cause);
	}

	@Nonnull
	@Override
	public DatabaseException getCause() {
		return (DatabaseException) super.getCause();
	}
}
