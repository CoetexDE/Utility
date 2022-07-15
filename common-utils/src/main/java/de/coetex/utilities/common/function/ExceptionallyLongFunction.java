package de.coetex.utilities.common.function;

import de.coetex.utilities.common.collection.WrappedException;

import java.util.function.LongFunction;

/**

 */
@FunctionalInterface
public interface ExceptionallyLongFunction<R> extends LongFunction<R> {

	@Override
	default R apply(long value) {
		try {
			return applyExceptionally(value);
		} catch (Exception ex) {
			throw WrappedException.rethrow(ex);
		}
	}

	R applyExceptionally(long value) throws Exception;

}
