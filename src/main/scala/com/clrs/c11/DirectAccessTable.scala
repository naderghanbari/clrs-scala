package com.clrs.c11

import com.clrs.common.{Index, IndexKey}

import scala.reflect.ClassTag

/** Direct address table
  * Chapter 11, Section 11.1, Page 254
  *
  * This is an object oriented version, i.e. operations are defined as methods and table X is an instance member
  * of this class. Instead of `Nil` convention we use `Option` type.
  *
  * @param m Size of the universe, we have the same assumption as in the book that keys belong to [0, m -1].
  * @tparam X Type of elements. Must have a key that can be used as index.
  */
class DirectAccessTable[X <: IndexKey: ClassTag](m: Int) {

  type Entry = Option[X]
  private val T = Array.fill[Entry](m - 1)(None)

  /** Direct address search.
    *
    * @param k Key to lookup.
    * @return Some(value) if key exists in the table, or None otherwise.
    */
  def search(k: Index): Entry = T(k)

  /** Direct address insert.
    *
    * @param x Element to insert, note that x has a key which can be used as an index.
    */
  def insert(x: X): Unit = T(x.key) = Some(x)

  /** Direct address delete.
    *
    * @param x Element to delete, note that x has a key which can be used as an index.
    */
  def delete(x: X): Unit = T(x.key) = None

}
