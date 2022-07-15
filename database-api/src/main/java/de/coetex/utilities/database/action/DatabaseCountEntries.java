package de.coetex.utilities.database.action;

import de.coetex.utilities.database.Database;
import de.coetex.utilities.database.SpecificDatabase;
import de.coetex.utilities.database.exceptions.DatabaseException;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

/**

 *
 * @see Database#countEntries(String)
 * @see SpecificDatabase#countEntries()
 */
public interface DatabaseCountEntries extends DatabaseAction<Long> {

	@Nonnull
	@Override
	@Nonnegative
	Long execute() throws DatabaseException;

}
