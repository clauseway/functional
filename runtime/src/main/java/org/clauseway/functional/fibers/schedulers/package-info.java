// ABOUTME: The Scheduler implementations: queue disciplines over the fiber interpreter - breadth-first,
// ABOUTME: unfair breadth-first, depth-first, round-robin, randomized and fork-join.

/**
 * Implementations of {@link org.clauseway.functional.fibers.Scheduler} that step
 * {@link org.clauseway.functional.fibers.interpreter.Frame}s. The sequential schedulers
 * ({@link org.clauseway.functional.fibers.schedulers.BreadthFirstScheduler BreadthFirstScheduler}, {@link org.clauseway.functional.fibers.schedulers.UnfairBreadthFirstScheduler UnfairBreadthFirstScheduler},
 * {@link org.clauseway.functional.fibers.schedulers.DepthFirstScheduler DepthFirstScheduler}, {@link org.clauseway.functional.fibers.schedulers.RoundRobin RoundRobin} and {@link org.clauseway.functional.fibers.schedulers.RandomizedScheduler RandomizedScheduler}) each own a
 * run queue and an {@link org.clauseway.functional.fibers.interpreter.AwaitBoundary} for
 * frames parked at an await, and differ in which queued frame they step next; they
 * implement {@link org.clauseway.functional.fibers.schedulers.SearchInspectable SearchInspectable} so the run queue can be read as a
 * {@link org.clauseway.functional.fibers.interpreter.SearchSnapshot}. {@link org.clauseway.functional.fibers.schedulers.ForkJoinScheduler ForkJoinScheduler}
 * instead runs each frame as a task on a {@link java.util.concurrent.ForkJoinPool}.
 */
package org.clauseway.functional.fibers.schedulers;
