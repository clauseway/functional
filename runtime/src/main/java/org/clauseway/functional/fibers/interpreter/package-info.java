// ABOUTME: The fiber interpreter: Frame.step dispatches one Fiber node, Scope counts
// ABOUTME: started/finished frames and seals when drained, Channel grows a value and completes waiters.

/**
 * The interpreter every scheduler drives. {@link org.clauseway.functional.fibers.interpreter.Frame}
 * holds one fiber under evaluation and its {@code step} dispatches one
 * {@link org.clauseway.functional.fibers.Fiber} node per call, reporting completion,
 * forks, detached children and parks to the scheduler through
 * {@link org.clauseway.functional.fibers.interpreter.Frame.Effects Frame.Effects}.
 * {@link org.clauseway.functional.fibers.interpreter.Scope} counts the frames started
 * and finished under it, records blocked frames with the place they wait at, and
 * seals once drained; {@link org.clauseway.functional.fibers.interpreter.Channel} is a
 * monotone {@code Semilattice} value produced under one Scope, whose growth completes
 * the waiters whose predicate holds and whose Scope's seal completes the rest with the
 * final value. {@link org.clauseway.functional.fibers.interpreter.ResumeHandle} hands a
 * suspended frame its result and re-queues it, and
 * {@link org.clauseway.functional.fibers.interpreter.AwaitBoundary} holds a scheduler's
 * suspended entries and the injection queue they re-enter through.
 * {@link org.clauseway.functional.fibers.interpreter.StepListener} observes every step
 * ({@link org.clauseway.functional.fibers.interpreter.ScopeProfiler} is one that counts
 * steps per scope), and {@link org.clauseway.functional.fibers.interpreter.SearchSnapshot}
 * is a scheduler's report of the frames alive between steps.
 * The fiber nodes live in {@code org.clauseway.functional.fibers}; the
 * schedulers in {@code org.clauseway.functional.fibers.schedulers} implement
 * {@code Frame.Effects}, own the run queue and choose the step granularity.
 */
package org.clauseway.functional.fibers.interpreter;
