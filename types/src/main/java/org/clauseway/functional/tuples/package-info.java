// ABOUTME: Structural tuples of arity 1 to 8 plus an array-backed tuple for wider
// ABOUTME: rows, and the n-ary function interfaces their apply methods destructure through.

/**
 * Immutable tuples with componentwise equality. {@link org.clauseway.functional.tuples.Tuple}
 * is the entry point: its static {@code of} overloads build the typed classes
 * {@link org.clauseway.functional.tuples.Tuple1} through
 * {@link org.clauseway.functional.tuples.Tuple8}, and {@code ofAll} builds a tuple of
 * any arity, falling back to {@link org.clauseway.functional.tuples.TupleN} above
 * arity 8. Every tuple exposes the structural contract {@code arity()},
 * {@code get(int)} and {@code withMembers(Object[])}; the typed classes additionally
 * carry {@code _1}-style fields and accessors, {@code map} variants and an
 * {@code apply} method that passes the members to a function of matching arity.
 * {@link org.clauseway.functional.tuples.Function3} through
 * {@link org.clauseway.functional.tuples.Function8} are those functions for arities
 * beyond the JDK's {@code Function} and {@code BiFunction}. This package has no
 * dependency on the other packages of the library.
 */
package org.clauseway.functional.tuples;
