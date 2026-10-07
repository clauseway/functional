package org.clauseway.functional.fibers;

import static org.clauseway.functional.fibers.Fiber.done;

import java.io.Serializable;
import java.util.function.Function;
import java.util.function.Supplier;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

/**
 * A continuation-passing computation over {@link Fiber}: a {@code Cont<T, R>}
 * is a function that takes a continuation {@code Fiber.Fn<T, R>} (what to do
 * with the {@code T}) and returns the {@code Fiber<R>} of the whole run.
 * {@link #just}, {@link #complete}, {@link #suspend} and {@link #defer} build
 * one; {@link #map} and {@link #flatMap} chain them; {@link #callCC} hands
 * the body its current continuation as a {@link Resume}, and applying that
 * {@code Resume} skips the rest of the body. {@link #run} and
 * {@link #runRec} supply the final continuation and yield the {@code Fiber<R>}
 * to schedule.
 */
public interface Cont<T, R> extends Fiber.Fn<Fiber.Fn<T, R>, R> {

	default <B> Cont<B, R> map(Function<? super T, ? extends B> f) {
		return flatMap(t -> just(f.apply(t)));
	}

	default <B> Cont<B, R> flatMap(Function<? super T, ? extends Cont<B, R>> f) {
		return k ->
				Fiber.defer(() -> apply(a ->
						Fiber.defer(() -> f.apply(a)
								.apply(k))));
	}

	/**
	 * Helper class that allows the resuming function to be used regardless of the current flatMap return type.
	 */
	@Value
	@RequiredArgsConstructor(access = AccessLevel.MODULE, staticName = "of")
	class Resume<T, R> implements Serializable {
		Function<T, Fiber<R>> k;

		public <U> Cont<U, R> with(T value) {
			return aborted -> k.apply(value);
		}
	}

	/**
	 * <pre>
	 * Call-with-current-continuation.
	 * Allows to abort execution of code block using the supplied abort function.
	 * callCC :: ((a -> Cont r b) -> Cont r a) -> Cont r a
	 * </pre>
	 */
	static <A, R> Cont<A, R> callCC(Function<Resume<A, R>, Cont<A, R>> body) {
		return suspend(cc -> body.apply(Resume.of(cc)).apply(cc));
	}

	default Fiber<R> runRec(Fiber.Fn<T, R> cont) {
		return apply(cont);
	}

	default Fiber<R> run(Function<T, @NonNull R> cont) {
		return apply(v -> done(cont.apply(v)));
	}

	static <T, R> Cont<T, R> suspend(Fiber.Fn<Fiber.Fn<T, R>, R> f) {
		return f::apply;
	}

	static <T, R> Cont<T, R> complete(R value) {
		return suspend(k -> done(value));
	}

	static <T, R> Cont<T, R> defer(Supplier<Fiber<Cont<T, R>>> deferred) {
		return k -> deferred.get().flatMap(c -> c.apply(k));
	}

	static <T, R> Cont<T, R> just(T value) {
		return k -> k.apply(value);
	}
}
