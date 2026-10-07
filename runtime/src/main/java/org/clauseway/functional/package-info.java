// ABOUTME: Small general-purpose helpers shared by the runtime: throwing
// ABOUTME: functions, the unit semilattice, Optional and cast utilities, a mutable cell.

/**
 * General-purpose helpers used across the runtime.
 * {@link org.clauseway.functional.Exceptions} builds functional interfaces
 * that throw a supplied {@link java.lang.Throwable};
 * {@link org.clauseway.functional.Nothing} is the one-point
 * {@link org.clauseway.functional.algebra.Semilattice} that fibers complete
 * with when they carry no value;
 * {@link org.clauseway.functional.Optionals} and
 * {@link org.clauseway.functional.Types} add {@link java.util.Optional}
 * combinators and {@code Optional}-returning casts; and
 * {@link org.clauseway.functional.Reference} is a mutable cell. The fiber
 * computation model lives in the {@code org.clauseway.functional.fibers}
 * subpackage, with its interpreter and schedulers beneath it.
 */
package org.clauseway.functional;
