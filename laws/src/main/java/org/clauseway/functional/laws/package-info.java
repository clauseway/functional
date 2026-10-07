// ABOUTME: Framework-neutral infrastructure for law kits: the assertion helper,
// ABOUTME: the registry of exercised classes, and the coverage gate over claims.

/**
 * Infrastructure shared by law kits — test helpers that certify an interface's
 * implementors by running the interface's laws over caller-supplied samples.
 * {@link org.clauseway.functional.laws.Laws Laws} is the assertion helper every kit reports failures through, as
 * a plain {@link java.lang.AssertionError AssertionError} with no test-framework dependency.
 * {@link org.clauseway.functional.laws.LawRegistry LawRegistry} records which kit id exercised which class.
 * {@link org.clauseway.functional.laws.LawsFor LawsFor} is placed on a test class to claim coverage for the named
 * implementors (and for classes nested in them, which is how anonymous
 * implementors are claimed). {@link org.clauseway.functional.laws.LawChecker LawChecker} is the coverage gate: given a
 * domain's marker annotation (any annotation with a {@code String[] value()}
 * naming accepted kit ids), it discovers every non-abstract implementor of a
 * marked interface and verifies each is claimed, and per test class verifies
 * that each claimed implementor was exercised by a kit its marked interfaces
 * accept. The kits themselves live in domain packages such as
 * {@code org.clauseway.functional.algebra.laws}, whose marker annotation is
 * {@code org.clauseway.functional.algebra.CheckedBy}.
 */
package org.clauseway.functional.laws;
