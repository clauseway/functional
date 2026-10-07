package org.clauseway.functional;

import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * A mutable cell holding one value of type {@code T}, read with {@link #get}
 * and written with {@link #set}; {@link #update} replaces the value with a
 * function of the current one and returns this reference. {@link #to} holds
 * a given initial value, {@link #empty} starts at {@code null}, and
 * {@link #defer} routes {@code get} and {@code set} to a supplied
 * {@link Supplier} and {@link Consumer}.
 * {@link org.clauseway.functional.fibers.MFiber#mcache MFiber.mcache} uses
 * one as the memo cell for a computed value.
 */
public interface Reference<T> {
	T get();

	void set(T v);

	default Reference<T> update(UnaryOperator<T> f) {
		set(f.apply(get()));
		return this;
	}

	static <T> Reference<T> to(T v) {
		return new Reference<T>() {
			private T value = v;

			@Override
			public T get() {
				return value;
			}

			@Override
			public void set(T v) {
				value = v;
			}
		};
	}

	static <T> Reference<T> defer(Supplier<T> s, Consumer<T> c) {
		return new Reference<T>() {
			@Override
			public T get() {
				return s.get();
			}

			@Override
			public void set(T v) {
				c.accept(v);
			}
		};
	}

	static <T> Reference<T> empty() {
		return to(null);
	}
}
