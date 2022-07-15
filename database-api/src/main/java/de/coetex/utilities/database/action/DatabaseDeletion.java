package de.coetex.utilities.database.action;

import de.coetex.utilities.database.Database;
import de.coetex.utilities.database.SpecificDatabase;
import de.coetex.utilities.database.action.hierarchy.WhereAction;
import de.coetex.utilities.database.exceptions.DatabaseException;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**

 *
 * @see Database#delete(String)
 * @see SpecificDatabase#delete()
 */
public interface DatabaseDeletion extends DatabaseAction<Void>, WhereAction {

	@Nonnull
	@CheckReturnValue
	DatabaseDeletion where(@Nonnull String field, @Nullable Object value);

	@Nonnull
	@CheckReturnValue
	DatabaseDeletion where(@Nonnull String field, @Nullable Number value);

	@Nonnull
	@CheckReturnValue
	DatabaseDeletion where(@Nonnull String field, @Nullable String value, boolean ignoreCase);

	@Nonnull
	@CheckReturnValue
	DatabaseDeletion where(@Nonnull String field, @Nullable String value);

	@Nonnull
	@CheckReturnValue
	DatabaseDeletion whereNot(@Nonnull String field, @Nullable Object value);

	@Nullable
	@Override
	Void execute() throws DatabaseException;

}
