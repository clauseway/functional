// ABOUTME: The fiber computation model: Fiber nodes and their factories, the
// ABOUTME: Scheduler contract, continuations, and the optional-valued MFiber.

/**
 * The fiber computation model. {@link org.clauseway.functional.fibers.Fiber}
 * is the tree of nodes a computation is written as, with the static
 * factories for sequencing, forking, detaching, claiming a
 * {@link org.clauseway.functional.fibers.interpreter.Scope}, producing into
 * and awaiting a channel;
 * {@link org.clauseway.functional.fibers.Scheduler} is the contract for
 * driving one to completion. {@link org.clauseway.functional.fibers.Emitter}
 * and {@link org.clauseway.functional.fibers.AwaitResult} are the
 * production capability and the await completion of a channel;
 * {@link org.clauseway.functional.fibers.Cont} is continuation passing over
 * fibers; {@link org.clauseway.functional.fibers.MFiber} is a fiber of an
 * {@link java.util.Optional}. The node semantics (scopes, channels, work
 * counting) live in {@code org.clauseway.functional.fibers.interpreter}, and the
 * concrete schedulers in {@code org.clauseway.functional.fibers.schedulers}.
 */
package org.clauseway.functional.fibers;
