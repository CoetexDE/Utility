package de.coetex.utilities.common.function;

import de.coetex.utilities.common.collection.WrappedException;

import java.util.function.IntFunction;

/**

 */
@FunctionalInterface
public interface ExceptionallyIntFunction<R> extends IntFunction<R> {

	@Override
	default R apply(int value) {
		try {
			return applyExceptionally(value);
		} catch (Exception ex) {
			throw WrappedException.rethrow(ex);
		}
	}

	R applyExceptionally(int value) throws Exception;

}
