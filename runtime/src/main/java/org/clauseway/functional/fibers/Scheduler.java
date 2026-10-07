package org.clauseway.functional.fibers;

import org.clauseway.functional.fibers.interpreter.StepListener;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Drives a {@link Fiber} to completion, delivering each completed value to a
 * sink. {@link #step} performs one scheduling step and reports whether the
 * whole computation has finished; {@link #run(int, Consumer)} bounds the
 * steps, {@link #run(Consumer)} runs until finished, {@link #run(int)} yields
 * the result as an {@link Optional} when it completes within the count, and
 * {@link #get()} runs until finished and returns the result.
 * {@link #withListener} installs a
 * {@link org.clauseway.functional.fibers.interpreter.StepListener} and
 * {@link #close()} releases the scheduler's resources. The implementations
 * live in {@code org.clauseway.functional.fibers.schedulers}; they differ in
 * which frame they step next.
 */
public interface Scheduler<A> extends Supplier<A>, AutoCloseable {
	boolean step(Consumer<? super A> sink);

	/**
	 * Drive by an explicit STEP COUNT — the stepping schedulers' contract. A
	 * scheduler that cannot count steps (a pool drive) refuses loudly; callers
	 * that just want bounded progress use {@link #advance}.
	 */
	boolean run(int iterations, Consumer<? super A> sink);

	/**
	 * Advance the computation by this scheduler's own bounded quantum — a
	 * step batch on stepping schedulers, a poll window on pool schedulers — and
	 * report whether the computation has completed. The quantum belongs to
	 * the scheduler: callers ask for progress, never for a unit count.
	 */
	default boolean advance(Consumer<? super A> sink) {
		return run(64, sink);
	}

	void run(Consumer<? super A> sink);

	Optional<A> run(int iterations);

	/**
	 * Install a step observer. Schedulers driven by the shared step
	 * interpreter honour it; one not built on the interpreter has nothing
	 * per-step to report and leaves it a no-op.
	 */
	default Scheduler<A> withListener(StepListener listener) {
		return this;
	}
}
