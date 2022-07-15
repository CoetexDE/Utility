package de.coetex.utilities.database.internal.mongodb.count;

import de.coetex.utilities.database.action.DatabaseCountEntries;
import de.coetex.utilities.database.exceptions.DatabaseException;
import de.coetex.utilities.database.internal.mongodb.MongoDBDatabase;

import javax.annotation.Nonnull;
import java.util.Objects;


public class MongoDBCountEntries implements DatabaseCountEntries {

	protected final MongoDBDatabase database;
	protected final String table;

	public MongoDBCountEntries(@Nonnull MongoDBDatabase database, @Nonnull String table) {
		this.database = database;
		this.table = table;
	}

	@Nonnull
	@Override
	public Long execute() throws DatabaseException {
		try {
			return database.getCollection(table).countDocuments();
		} catch (Exception ex) {
			throw new DatabaseException(ex);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		MongoDBCountEntries that = (MongoDBCountEntries) o;
		return Objects.equals(database, that.database) && Objects.equals(table, that.table);
	}

	@Override
	public int hashCode() {
		return Objects.hash(database, table);
	}
}
