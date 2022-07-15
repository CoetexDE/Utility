package de.coetex.utilities.database.action;

import de.coetex.utilities.database.Database;
import de.coetex.utilities.database.SpecificDatabase;
import de.coetex.utilities.database.action.hierarchy.SetAction;
import de.coetex.utilities.database.exceptions.DatabaseException;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**

 *
 * @see Database#insert(String)
 * @see SpecificDatabase#insert()
 */
public interface DatabaseInsertion extends DatabaseAction<Void>, SetAction {

	@Nonnull
	@CheckReturnValue
	DatabaseInsertion set(@Nonnull String field, @Nullable Object value);

	@Nullable
	@Override
	Void execute() throws DatabaseException;

}
