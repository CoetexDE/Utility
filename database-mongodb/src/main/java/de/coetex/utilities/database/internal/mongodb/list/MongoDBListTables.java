package de.coetex.utilities.database.internal.mongodb.list;

import de.coetex.utilities.database.action.DatabaseListTables;
import de.coetex.utilities.database.exceptions.DatabaseException;
import de.coetex.utilities.database.internal.mongodb.MongoDBDatabase;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;


public class MongoDBListTables implements DatabaseListTables {

	protected final MongoDBDatabase database;

	public MongoDBListTables(@Nonnull MongoDBDatabase database) {
		this.database = database;
	}

	@Nonnull
	@Override
	public List<String> execute() throws DatabaseException {
		try {
			return database.getDatabase().listCollectionNames().into(new ArrayList<>());
		} catch (Exception ex) {
			throw new DatabaseException(ex);
		}
	}

}
