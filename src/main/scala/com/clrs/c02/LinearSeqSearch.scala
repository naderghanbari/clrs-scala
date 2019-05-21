package com.clrs.c02

import com.clrs.common.Index

import scala.collection.LinearSeq
import scala.language.higherKinds

/** Searching Problem for Lists, which have efficient `head` and `tail` methods.
  * Works for both mutable and immutable linear sequences.
  *
  * Chapter 2, Section 2.1, Exercise 2.1-3, Page 22
  */
object LinearSeqSearch extends GenericSearch {

  override type C[T] = LinearSeq[T]

  override def search[T](a: C[T], v: T): Option[Index] = {
    var i  = 0
    var xs = a
    while (xs.nonEmpty) {
      if (xs.head == v) return Some(i)
      i += 1
      xs = xs.tail
    }
    Option.empty[Index]
  }

}
