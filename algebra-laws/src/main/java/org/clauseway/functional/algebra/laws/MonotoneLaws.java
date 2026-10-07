package org.clauseway.functional.algebra.laws;

// ABOUTME: Monotone maps between two orders: as the input ascends its declared
// ABOUTME: chain, the output never moves against the supplied target order.

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.clauseway.functional.laws.Laws;

/**
 * The law of maps between DIFFERENT orders — {@code a ⊑ b ⇒ f(a) ⊑ f(b)} —
 * checked along a caller-declared ascending chain, so the source side needs
 * no interface (the source type need not implement any order). The
 * target order is supplied as a {@link BiPredicate}, so a map into counts
 * ordered DOWNWARD (more knowledge in, fewer-or-equal answers out) is
 * checked by passing {@code (x, y) -> x >= y}.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MonotoneLaws {

	/**
	 * @param ascending samples DECLARED ascending in the source order,
	 * 		weakest first
	 * @param leq the target order's ≤
	 */
	public static <A, B> void check(List<A> ascending, Function<A, B> f, BiPredicate<B, B> leq) {
		for (int i = 0; i < ascending.size(); i++) {
			for (int j = i + 1; j < ascending.size(); j++) {
				B lo = f.apply(ascending.get(i));
				B hi = f.apply(ascending.get(j));
				Laws.require(leq.test(lo, hi),
						"monotone: a ⊑ b ⇒ f(a) ⊑ f(b)", i, j, lo, hi);
			}
		}
	}
}
