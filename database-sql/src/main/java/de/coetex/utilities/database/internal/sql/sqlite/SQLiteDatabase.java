package de.coetex.utilities.database.internal.sql.sqlite;

import de.coetex.utilities.common.misc.FileUtils;
import de.coetex.utilities.database.DatabaseConfig;
import de.coetex.utilities.database.action.DatabaseListTables;
import de.coetex.utilities.database.exceptions.DatabaseException;
import de.coetex.utilities.database.internal.sql.abstraction.AbstractSQLDatabase;
import de.coetex.utilities.database.internal.sql.sqlite.list.SQLiteListTables;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;


public class SQLiteDatabase extends AbstractSQLDatabase {

	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException ex) {
			LOGGER.error("Could not load sqlite driver");
		}
	}

	protected final File file;

	public SQLiteDatabase(@Nonnull DatabaseConfig config) {
		super(config);
		file = new File(config.getFile());
	}

	@Override
	public void connect() throws DatabaseException {
		try {
			FileUtils.createFilesIfNecessary(file);
		} catch (IOException ex) {
			throw new DatabaseException(ex);
		}

		super.connect();
	}

	@Override
	protected String createUrl() {
		return "jdbc:sqlite:" + file;
	}

	@Nonnull
	@Override
	public DatabaseListTables listTables() {
		return new SQLiteListTables(this);
	}

}
