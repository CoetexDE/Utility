package de.coetex.utilities.database;

import de.coetex.utilities.common.misc.ReflectionUtils;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;


public final class SimpleDatabaseTypeResolver {

	private SimpleDatabaseTypeResolver() {}

	private static final Map<String, String> registry = new HashMap<>();
	static {
		registerType("mongodb", "de.coetex.utilities.database.internal.mongodb.MongoDBDatabase");
		registerType("mysql",   "de.coetex.utilities.database.internal.sql.mysql.MySQLDatabase");
		registerType("sqlite",  "de.coetex.utilities.database.internal.sql.sqlite.SQLiteDatabase");
	}

	@Nullable
	public static Class<? extends Database> findDatabaseType(@Nonnull String name) {
		return ReflectionUtils.getClassOrNull(registry.get(name));
	}

	@Nullable
	public static Class<? extends Database> findDatabaseType(@Nonnull String name, boolean initialize, @Nonnull ClassLoader classLoader) {
		return ReflectionUtils.getClassOrNull(registry.get(name), initialize, classLoader);
	}

	public static void registerType(@Nonnull String name, @Nonnull String className) {
		registry.put(name, className);
	}

	public static void registerType(@Nonnull String name, @Nonnull Class<? extends Database> databaseClass) {
		registerType(name, databaseClass.getName());
	}

}
