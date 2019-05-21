package com.clrs.c02

import com.clrs.common.Index

import scala.collection.IndexedSeq

/** Linear search for indexed sequences, which have efficient `apply` and `length` methods.
  * Works for both mutable and immutable indexed sequences.
  *
  * Chapter 2, Section 2.1, Exercise 2.1-3, Page 22
  */
object IndexedSeqLinearSearch extends GenericSearch[IndexedSeq] {

  def search[T](a: IndexedSeq[T], v: T): Option[Index] = {
    for (j <- 0 until a.length) if (a(j) == v) return Some(j)
    Option.empty[Index]
  }

}
