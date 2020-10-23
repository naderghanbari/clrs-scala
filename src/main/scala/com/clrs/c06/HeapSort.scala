package com.clrs.c06

import com.clrs.c01.Sort

import scala.collection.mutable

object HeapSort extends Sort[mutable.IndexedSeq] {

  def heapSort[T: Ordering](input: mutable.IndexedSeq[T]): mutable.IndexedSeq[T] = ???

  override def sort[T: Ordering](input: mutable.IndexedSeq[T]): mutable.IndexedSeq[T] = {
    heapSort(input)
    input
  }

}
