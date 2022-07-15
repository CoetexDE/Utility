package de.coetex.utilities.common.collection;

import javax.annotation.Nullable;


@Deprecated
public class Tuple<F, S> extends de.coetex.utilities.common.collection.pair.Tuple<F, S> {

	public Tuple() {
	}

	public Tuple(@Nullable F first, @Nullable S second) {
		super(first, second);
	}

}
