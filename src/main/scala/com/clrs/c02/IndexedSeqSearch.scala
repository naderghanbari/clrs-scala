package com.clrs.c02

import com.clrs.common.Index

import scala.collection.IndexedSeq
import scala.language.higherKinds

/** Searching Problem for indexed sequences, which have efficient `apply` and `length` methods.
  * Works for both mutable and immutable indexed sequences.
  *
  * Chapter 2, Section 2.1, Exercise 2.1-3, Page 22
  */
object IndexedSeqSearch extends GenericSearch {

  override type C[T] = IndexedSeq[T]

  override def search[T](a: C[T], v: T): Option[Index] = {
    for (j <- 0 until a.length) if (a(j) == v) return Some(j)
    Option.empty[Index]
  }

}
