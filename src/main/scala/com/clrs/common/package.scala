package com.clrs

import scala.collection.mutable

package object common {

  /** Type for better code clarity.
    * Whenever an algorithm needs to return an index as the result, we will use this type.
    */
  type Index = Int

  /** Type for all classes which have a key that can be used as indices of arrays. */
  type IndexKey = HasKey[Index]

  /** Swaps two elements of the given array at given indices.
    *
    * @param a Array to mutate.
    */
  def swap[T](a: mutable.Seq[T])(i: Int, j: Int): Unit = {
    val temp = a(i)
    a.update(i, a(j))
    a.update(j, temp)
  }

}
