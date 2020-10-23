package com.clrs.c06

import com.clrs.common.Index

import scala.reflect.ClassTag
import scala.math.Ordering.Implicits.infixOrderingOps

/** A heap backed by an array. Can be a MaxHeap or a MinHeap depending on the provided Ordering.
  *
  * Chapter 6, section 1, page 152-154
  *
  * @tparam T Type of elements with an order relation, i.e. an implicit Ordering[T].
  */
class Heap[T: ClassTag](implicit ord: Ordering[T]) {

  val A             = Array.empty[T]
  var heapSize: Int = 0

  def length: Int            = A.length
  def apply(index: Index): T = A(index)

  def parent(index: Index): Index = index / 2
  def left(index: Index): Index   = index * 2
  def right(index: Index): Index  = index * 2 + 1

  def heapify(i: Index): Unit = {
    var l       = left(i)
    var r       = right(i)
    var largest = if ((l <= heapSize) && (A(l) > A(r))) l else i
    if ((l <= heapSize) && (A(l) > A(r))) {}
  }

}
