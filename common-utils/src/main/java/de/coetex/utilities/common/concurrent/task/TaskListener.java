package de.coetex.utilities.common.concurrent.task;

import javax.annotation.Nonnull;

/**

 */
public interface TaskListener<T> {

	default void onComplete(@Nonnull Task<T> task, @Nonnull T value) {
	}

	default void onCancelled(@Nonnull Task<T> task) {
	}

	default void onFailure(@Nonnull Task<T> task, @Nonnull Throwable ex) {
	}

}
