package de.coetex.utilities.database.action;

import de.coetex.utilities.database.SpecificDatabase;
import de.coetex.utilities.database.exceptions.DatabaseException;
import de.coetex.utilities.database.Database;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**

 *
 * @see Database#insertOrUpdate(String)
 * @see SpecificDatabase#insertOrUpdate()
 */
public interface DatabaseInsertionOrUpdate extends DatabaseUpdate, DatabaseInsertion {

	@Nonnull
	@CheckReturnValue
	DatabaseInsertionOrUpdate where(@Nonnull String field, @Nullable Object value);

	@Nonnull
	@CheckReturnValue
	DatabaseInsertionOrUpdate where(@Nonnull String field, @Nullable Number value);

	@Nonnull
	@CheckReturnValue
	DatabaseInsertionOrUpdate where(@Nonnull String field, @Nullable String value, boolean ignoreCase);

	@Nonnull
	@CheckReturnValue
	DatabaseInsertionOrUpdate where(@Nonnull String field, @Nullable String value);

	@Nonnull
	@Override
	DatabaseInsertionOrUpdate whereNot(@Nonnull String field, @Nullable Object value);

	@Nonnull
	@Override
	DatabaseInsertionOrUpdate set(@Nonnull String field, @Nullable Object value);

	@Nullable
	@Override
	Void execute() throws DatabaseException;

}
