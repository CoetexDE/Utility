package de.coetex.utilities.database.internal.sql.abstraction.query;

import de.coetex.utilities.common.config.Document;
import de.coetex.utilities.common.config.document.EmptyDocument;
import de.coetex.utilities.common.config.document.GsonDocument;
import de.coetex.utilities.common.config.document.MapDocument;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Map;

public final class SQLResult extends MapDocument {

	public SQLResult(@Nonnull Map<String, Object> values) {
		super(values);
	}

	@Nonnull
	@Override
	public Document getDocument0(@Nonnull String path, @Nonnull Document root, @Nullable Document parent) {
		try {
			return new GsonDocument(getString(path), this, this).readonly();
		} catch (Exception ex) {
			return new EmptyDocument(this, null);
		}
	}

	@Override
	public boolean isReadonly() {
		return true;
	}

}
