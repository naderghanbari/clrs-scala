package com.clrs.c04

import com.clrs.common.Index

/** Represents a sub-sequence (sub array in the book's terminology).
  *
  * @param sum Sum of the elements of the sub array.
  * @param start Start index of the sub-sequence (inclusive).
  * @param end End index of the sub-sequence (inclusive).
  * @tparam T Parametric type of the parent elements, must be numeric.
  */
case class SubSequence[T: Numeric](sum: T, start: Index, end: Index)
