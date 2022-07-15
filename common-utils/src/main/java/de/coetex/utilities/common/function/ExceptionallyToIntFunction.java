package de.coetex.utilities.common.function;

import de.coetex.utilities.common.collection.WrappedException;

import java.util.function.ToIntFunction;

/**

 */
@FunctionalInterface
public interface ExceptionallyToIntFunction<T> extends ToIntFunction<T> {

	@Override
	default int applyAsInt(T t) {
		try {
			return applyExceptionally(t);
		} catch (Exception ex) {
			throw WrappedException.rethrow(ex);
		}
	}

	int applyExceptionally(T t) throws Exception;

}
