package de.coetex.utilities.database.action.hierarchy;

import de.coetex.utilities.database.Order;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;


public interface OrderedAction {

	@Nullable
	OrderedAction orderBy(@Nonnull String field, @Nonnull Order order);

}
