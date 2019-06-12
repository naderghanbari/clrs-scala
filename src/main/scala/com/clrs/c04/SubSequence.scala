package com.clrs.c04

import com.clrs.common.Index

/** Represents a sub-sequence (sub array in the book's terminology).
  *
  * @param start Start index of the sub-sequence (inclusive).
  * @param end End index of the sub-sequence (inclusive).
  * @param sum Sum of the elements of the sub-array.
  */
case class SubSequence[T: Numeric](start: Index, end: Index, sum: T)
