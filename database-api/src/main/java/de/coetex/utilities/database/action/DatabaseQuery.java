package de.coetex.utilities.database.action;

import de.coetex.utilities.database.Database;
import de.coetex.utilities.database.Order;
import de.coetex.utilities.database.SpecificDatabase;
import de.coetex.utilities.database.action.hierarchy.OrderedAction;
import de.coetex.utilities.database.action.hierarchy.WhereAction;
import de.coetex.utilities.database.exceptions.DatabaseException;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**

 *
 * @see Database#query(String)
 * @see SpecificDatabase#query()
 */
public interface DatabaseQuery extends DatabaseAction<ExecutedQuery>, WhereAction, OrderedAction {

	@Nonnull
	@CheckReturnValue
	DatabaseQuery where(@Nonnull String field, @Nullable Object object);

	@Nonnull
	@CheckReturnValue
	DatabaseQuery where(@Nonnull String field, @Nullable Number value);

	@Nonnull
	@CheckReturnValue
	DatabaseQuery where(@Nonnull String field, @Nullable String value, boolean ignoreCase);

	@Nonnull
	@CheckReturnValue
	DatabaseQuery where(@Nonnull String field, @Nullable String value);

	@Nonnull
	@CheckReturnValue
	DatabaseQuery whereNot(@Nonnull String field, @Nullable Object value);

	@Nonnull
	@CheckReturnValue
	DatabaseQuery select(@Nonnull String... selection);

	@Nonnull
	@CheckReturnValue
	DatabaseQuery orderBy(@Nonnull String field, @Nonnull Order order);

	@Nonnull
	@Override
	@CheckReturnValue
	ExecutedQuery execute() throws DatabaseException;

}
