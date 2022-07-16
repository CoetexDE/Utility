package de.coetex.utilities.database.internal.sql.abstraction;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import de.coetex.utilities.database.DatabaseConfig;
import de.coetex.utilities.database.SQLColumn;
import de.coetex.utilities.database.action.*;
import de.coetex.utilities.database.exceptions.DatabaseException;
import de.coetex.utilities.database.internal.abstraction.AbstractDatabase;
import de.coetex.utilities.database.internal.sql.abstraction.count.SQLCountEntries;
import de.coetex.utilities.database.internal.sql.abstraction.deletion.SQLDeletion;
import de.coetex.utilities.database.internal.sql.abstraction.insertion.SQLInsertion;
import de.coetex.utilities.database.internal.sql.abstraction.insertorupdate.SQLInsertionOrUpdate;
import de.coetex.utilities.database.internal.sql.abstraction.query.SQLQuery;
import de.coetex.utilities.database.internal.sql.abstraction.update.SQLUpdate;
import de.coetex.utilities.database.internal.sql.abstraction.where.SQLWhere;

import javax.annotation.Nonnull;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;


public abstract class AbstractSQLDatabase extends AbstractDatabase {

	private HikariDataSource dataSource;

	public AbstractSQLDatabase(@Nonnull DatabaseConfig config) {
		super(config);
	}

	public Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void disconnect0() throws Exception {
		if(isConnected()) {
			dataSource.close();
		}
	}

	@Override
	public void connect0() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setUsername(config.getUser());
		hikariConfig.setPassword(config.getPassword());
		hikariConfig.setJdbcUrl(createUrl());
		setDataSource(hikariConfig);
	}

	public void setDataSource(HikariConfig config) {
		config.setMaximumPoolSize(10);
		config.setPoolName("database-api");

		config.addDataSourceProperty("cachePrepStmts",true);
		config.addDataSourceProperty("characterEncoding","utf-8");
		config.addDataSourceProperty("useUnicode",true);
		config.addDataSourceProperty("allowMultiQueries",true);

		config.addDataSourceProperty("ssl", true);
		config.addDataSourceProperty("useSSL", true);
		config.setConnectionTestQuery("SELECT 1");

		this.dataSource = new HikariDataSource(config);
	}

	protected abstract String createUrl();

	@Override
	public boolean isConnected() {
		try{
			return dataSource != null && !(dataSource.isClosed()) ;
		}catch (Exception ignored){}
		return false;
	}

	@Override
	public void createTable(@Nonnull String name, @Nonnull SQLColumn... columns) throws DatabaseException {
		try {
			StringBuilder command = new StringBuilder();
			command.append("CREATE TABLE IF NOT EXISTS `");
			command.append(name);
			command.append("` (");
			{
				int index = 0;
				for (SQLColumn column : columns) {
					if (index > 0) command.append(", ");
					command.append(column);
					index++;
				}
			}
			command.append(")");

			PreparedStatement statement = prepare(command.toString());
			statement.execute();
		} catch (Exception ex) {
			throw new DatabaseException(ex);
		}
	}

	@Nonnull
	@Override
	public DatabaseCountEntries countEntries(@Nonnull String table) {
		return new SQLCountEntries(this, table);
	}

	@Nonnull
	@Override
	public DatabaseQuery query(@Nonnull String table) {
		return new SQLQuery(this, table);
	}

	@Nonnull
	public DatabaseQuery query(@Nonnull String table, @Nonnull Map<String, SQLWhere> where) {
		return new SQLQuery(this, table, where);
	}

	@Nonnull
	@Override
	public DatabaseUpdate update(@Nonnull String table) {
		return new SQLUpdate(this, table);
	}

	@Nonnull
	@Override
	public DatabaseInsertion insert(@Nonnull String table) {
		return new SQLInsertion(this, table);
	}

	@Nonnull
	public DatabaseInsertion insert(@Nonnull String table, @Nonnull Map<String, Object> values) {
		return new SQLInsertion(this, table, values);
	}

	@Nonnull
	@Override
	public DatabaseInsertionOrUpdate insertOrUpdate(@Nonnull String table) {
		return new SQLInsertionOrUpdate(this, table);
	}

	@Nonnull
	@Override
	public DatabaseDeletion delete(@Nonnull String table) {
		return new SQLDeletion(this, table);
	}

	@Nonnull
	public PreparedStatement prepare(@Nonnull CharSequence command, @Nonnull Object... args) throws SQLException, DatabaseException {
		checkConnection();
		PreparedStatement statement = getConnection().prepareStatement(command.toString());
		SQLHelper.fillParams(statement, args);
		return statement;
	}

}