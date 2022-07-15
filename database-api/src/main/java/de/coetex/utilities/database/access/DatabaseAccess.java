package de.coetex.utilities.database.access;

import de.coetex.utilities.database.exceptions.DatabaseException;
import de.coetex.utilities.database.Database;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Optional;


public interface DatabaseAccess<V> {

	@Nullable
	V getValue(@Nonnull String key) throws DatabaseException;

	@Nonnull
	V getValue(@Nonnull String key, @Nonnull V def) throws DatabaseException;

	@Nonnull
	Optional<V> getValueOptional(@Nonnull String key) throws DatabaseException;

	void setValue(@Nonnull String key, @Nullable V value) throws DatabaseException;

	default boolean hasValue(@Nonnull String key) throws DatabaseException {
		return getValueOptional(key).isPresent();
	}

	@Nonnull
	Database getDatabase();

	@Nonnull
	DatabaseAccessConfig getConfig();

}
