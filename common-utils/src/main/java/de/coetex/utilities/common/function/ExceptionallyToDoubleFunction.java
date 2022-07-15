package de.coetex.utilities.common.function;

import de.coetex.utilities.common.collection.WrappedException;

import java.util.function.ToDoubleFunction;

/**

 */
@FunctionalInterface
public interface ExceptionallyToDoubleFunction<T> extends ToDoubleFunction<T> {

	@Override
	default double applyAsDouble(T t) {
		try {
			return applyExceptionally(t);
		} catch (Exception ex) {
			throw WrappedException.rethrow(ex);
		}
	}

	double applyExceptionally(T T) throws Exception;

}
