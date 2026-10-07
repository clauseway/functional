// ABOUTME: Algebraic interfaces (monoids, semilattices, partial orders, semirings and
// ABOUTME: their capability subtypes), standard witnesses, and a monotone worklist drain.

/**
 * Law-governed algebraic structures, each interface documenting the laws its
 * implementors must satisfy. Two hierarchies share the package: fold algebras
 * ({@link org.clauseway.functional.algebra.Monoid},
 * {@link org.clauseway.functional.algebra.CommutativeMonoid},
 * {@link org.clauseway.functional.algebra.Semiring} and its capability subtypes
 * {@link org.clauseway.functional.algebra.IdempotentSemiring},
 * {@link org.clauseway.functional.algebra.ClosedSemiring},
 * {@link org.clauseway.functional.algebra.BoundedSemiring} and
 * {@link org.clauseway.functional.algebra.SuperiorSemiring}) are witness objects over
 * a carrier type, while order algebras
 * ({@link org.clauseway.functional.algebra.PartialOrder},
 * {@link org.clauseway.functional.algebra.Semilattice},
 * {@link org.clauseway.functional.algebra.Absorbing}) are self-typed and implemented
 * by the value class. Standard witnesses live in
 * {@link org.clauseway.functional.algebra.Semirings},
 * {@link org.clauseway.functional.algebra.Monoids},
 * {@link org.clauseway.functional.algebra.Lattices} and
 * {@link org.clauseway.functional.algebra.PartialOrders}, with
 * {@link org.clauseway.functional.algebra.Provenance} as the regular-expression carrier
 * of the provenance semiring; {@link org.clauseway.functional.algebra.MonotoneDrain}
 * drains a worklist over a semilattice state with an absorbing element.
 * {@link org.clauseway.functional.algebra.CheckedBy} names, per interface, the law-kit
 * ids that certify an implementor. The kits themselves are in
 * {@code org.clauseway.functional.algebra.laws} (artifact {@code functional-algebra-laws})
 * and the claim/coverage gate in {@code org.clauseway.functional.laws}
 * (artifact {@code functional-laws}); this package depends on neither.
 */
package org.clauseway.functional.algebra;
