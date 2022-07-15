package de.coetex.utilities.database.internal.mongodb.query;

import de.coetex.utilities.common.config.document.BsonDocument;

import javax.annotation.Nonnull;


public final class MongoDBResult extends BsonDocument {

	public MongoDBResult(@Nonnull org.bson.Document bsonDocument) {
		super(bsonDocument);
	}

	@Override
	public boolean isReadonly() {
		return true;
	}

}
