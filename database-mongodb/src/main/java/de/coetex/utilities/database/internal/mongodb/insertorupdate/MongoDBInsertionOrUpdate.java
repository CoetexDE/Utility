package de.coetex.utilities.database.internal.mongodb.insertorupdate;

import de.coetex.utilities.common.misc.BsonUtils;
import de.coetex.utilities.database.action.DatabaseInsertionOrUpdate;
import de.coetex.utilities.database.exceptions.DatabaseException;
import de.coetex.utilities.database.internal.mongodb.MongoDBDatabase;
import de.coetex.utilities.database.internal.mongodb.update.MongoDBUpdate;
import de.coetex.utilities.database.internal.mongodb.where.MongoDBWhere;
import org.bson.BsonDocument;
import org.bson.Document;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Map.Entry;


public class MongoDBInsertionOrUpdate extends MongoDBUpdate implements DatabaseInsertionOrUpdate {

	public MongoDBInsertionOrUpdate(@Nonnull MongoDBDatabase database, @Nonnull String collection) {
		super(database, collection);
	}

	@Nonnull
	@Override
	public DatabaseInsertionOrUpdate where(@Nonnull String field, @Nullable String value, boolean ignoreCase) {
		super.where(field, value, ignoreCase);
		return this;
	}

	@Nonnull
	@Override
	public DatabaseInsertionOrUpdate where(@Nonnull String field, @Nullable Object value) {
		super.where(field, value);
		return this;
	}

	@Nonnull
	@Override
	public DatabaseInsertionOrUpdate where(@Nonnull String field, @Nullable String value) {
		super.where(field, value);
		return this;
	}

	@Nonnull
	@Override
	public DatabaseInsertionOrUpdate where(@Nonnull String field, @Nullable Number value) {
		super.where(field, value);
		return this;
	}

	@Nonnull
	@Override
	public DatabaseInsertionOrUpdate whereNot(@Nonnull String field, @Nullable Object value) {
		super.whereNot(field, value);
		return this;
	}

	@Nonnull
	@Override
	public DatabaseInsertionOrUpdate set(@Nonnull String field, @Nullable Object value) {
		super.set(field, value);
		return this;
	}

	@Override
	public Void execute() throws DatabaseException {
		if (database.query(collection, where).execute().isSet()) {
			return super.execute();
		} else {
			Document document = new Document(values);
			for (Entry<String, MongoDBWhere> entry : where.entrySet()) {
				BsonDocument bson = BsonUtils.convertBsonToBsonDocument(entry.getValue().toBson());
				document.putAll(bson);
			}

			database.insert(collection, document).execute();
			return null;
		}
	}

	@Override
	public boolean equals(Object o) {
		return super.equals(o);
	}

}
