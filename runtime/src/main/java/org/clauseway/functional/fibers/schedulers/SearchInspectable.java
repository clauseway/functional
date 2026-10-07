package org.clauseway.functional.fibers.schedulers;

// ABOUTME: Capability of schedulers that hold a walkable run queue: snapshot the live search.
// ABOUTME: Not on Scheduler — a parallel scheduler has no central queue to inspect.

import org.clauseway.functional.fibers.interpreter.SearchSnapshot;

/**
 * A scheduler whose run queue can be read as a {@link SearchSnapshot}. The
 * sequential schedulers keep their runnable frames in an inspectable queue and
 * implement this; {@link ForkJoinScheduler} hands frames to a pool as tasks and
 * does not. Test capability with {@code instanceof SearchInspectable}.
 */
public interface SearchInspectable {

	/**
	 * A snapshot of the frames currently in the run queue. Frames parked at an
	 * await are held outside the queue and are not counted.
	 */
	SearchSnapshot snapshot();
}
