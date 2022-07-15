package de.coetex.utilities.common.concurrent.cache;

import de.coetex.utilities.common.annotations.ReplaceWith;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;


@Deprecated
@ReplaceWith("com.google.common.cache.Cache")
public interface WriteableCache<K, V> extends ICache<K, V> {

	@Nullable
	V getData(@Nonnull K key);

	void setData(@Nonnull K key, @Nullable V value);

}
