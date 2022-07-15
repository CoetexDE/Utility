package de.coetex.utilities.database.exceptions;


public class DatabaseAlreadyConnectedException extends DatabaseException {

	public DatabaseAlreadyConnectedException() {
		super("Database already connected");
	}

}
