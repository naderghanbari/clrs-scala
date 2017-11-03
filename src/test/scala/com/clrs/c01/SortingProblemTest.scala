package com.clrs.c01

import scala.math.Ordering.Implicits.infixOrderingOps

object SortingProblemTest {

  /**
    * Checks if a sequence is is sorted.
    * Worst case: O(n)
    * Best case: O(1)
    * Average case: O(1)
    *
    * @param A Sequence of n numbers < a₁, a₂, ..., an >
    * @return True if a₁ ≤ a₂ ≤ ... ≤ an
    */
  def isSorted[Key: Ordering](A: Seq[Key]) = A sliding 2 forall { case Seq(x, y) => x <= y }

}
