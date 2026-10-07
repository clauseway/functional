// ABOUTME: Law kits for the interfaces of org.clauseway.functional.algebra: each
// ABOUTME: kit checks one structure's laws over samples and records coverage.

/**
 * Executable laws for the interfaces of {@code org.clauseway.functional.algebra}.
 * Each kit is a final class of static {@code check} methods that run a
 * structure's laws over caller-supplied samples and fail through
 * {@link org.clauseway.functional.laws.Laws#require(boolean, String, Object...)}.
 * The kits for the monoid and semiring hierarchy are {@link org.clauseway.functional.algebra.laws.MonoidLaws MonoidLaws},
 * {@link org.clauseway.functional.algebra.laws.CommutativeMonoidLaws CommutativeMonoidLaws}, {@link org.clauseway.functional.algebra.laws.SemiringLaws SemiringLaws}, {@link org.clauseway.functional.algebra.laws.IdempotentSemiringLaws IdempotentSemiringLaws},
 * {@link org.clauseway.functional.algebra.laws.StarLaws StarLaws}, {@link org.clauseway.functional.algebra.laws.BoundedSemiringLaws BoundedSemiringLaws} and {@link org.clauseway.functional.algebra.laws.SuperiorityLaws SuperiorityLaws};
 * the kits for the order and lattice hierarchy are {@link org.clauseway.functional.algebra.laws.SemilatticeLaws SemilatticeLaws},
 * {@link org.clauseway.functional.algebra.laws.PartialOrderLaws PartialOrderLaws}, {@link org.clauseway.functional.algebra.laws.LatticeLaws LatticeLaws} and {@link org.clauseway.functional.algebra.laws.AbsorbingLaws AbsorbingLaws}.
 * {@link org.clauseway.functional.algebra.laws.FoldLaws FoldLaws}, {@link org.clauseway.functional.algebra.laws.MonotoneLaws MonotoneLaws} and {@link org.clauseway.functional.algebra.laws.ReductorLaws ReductorLaws} check
 * properties of functions over such structures rather than of a declared
 * instance. Every kit except those three records the classes it exercised in
 * {@link org.clauseway.functional.laws.LawRegistry} under a kit id that matches a
 * {@code org.clauseway.functional.algebra.CheckedBy} value, which is how
 * {@link org.clauseway.functional.laws.LawChecker} verifies that each
 * implementor was certified by a kit its interfaces accept.
 */
package org.clauseway.functional.algebra.laws;
