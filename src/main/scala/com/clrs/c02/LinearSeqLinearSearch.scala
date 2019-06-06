package com.clrs.c02

import com.clrs.common.Index

import scala.collection.LinearSeq

/** Linear search for `LinearSeq`s, which have efficient `head` and `tail` methods.
  * Works for both mutable and immutable linear sequences.
  *
  * Chapter 2, Section 2.1, Exercise 2.1-3, Page 22
  */
object LinearSeqLinearSearch extends Search[LinearSeq] {

  def search[T: Ordering](a: LinearSeq[T], v: T): Option[Index] = {
    var i  = 0
    var xs = a
    while (xs.nonEmpty) {
      if (xs.head == v) return Some(i)
      i = i + 1
      xs = xs.tail
    }
    Option.empty[Index]
  }

}
