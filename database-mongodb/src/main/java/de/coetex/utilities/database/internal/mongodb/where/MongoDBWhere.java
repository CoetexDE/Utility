package de.coetex.utilities.database.internal.mongodb.where;

import com.mongodb.client.model.Collation;
import org.bson.conversions.Bson;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;


public interface MongoDBWhere {

	@Nonnull
	Bson toBson();

	@Nullable
	Collation getCollation();

}
