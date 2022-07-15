package de.coetex.utilities.database.action;

import de.coetex.utilities.database.Database;
import de.coetex.utilities.database.exceptions.DatabaseException;

import javax.annotation.Nonnull;
import java.util.List;

/**

 *
 * @see Database#listTables()
 */
public interface DatabaseListTables extends DatabaseAction<List<String>> {

	@Nonnull
	@Override
	List<String> execute() throws DatabaseException;

}
