package com.clrs.common.matrix

import com.clrs.common.Index

import scala.reflect.ClassTag

/** A matrix.
  *
  * @param elems Elements of the matrix.
  * @tparam T Polymorphic type of elements, has to be numeric.
  */
class Matrix[T: Numeric](elems: Array[Array[T]], rows: Int, cols: Int) {
  require(rows > 0)
  require(cols > 0)
  require(elems.length == rows, s"#rows must be $rows")
  require(elems.forall(_.length == cols), s"#cols must be $cols")

  @inline final def apply(i: Index, j: Index): T = elems(i)(j)

  @inline final def update(i: Index, j: Index, elem: T): Unit = elems(i)(j) = elem
}

case class SquareMatrix[T: Numeric](elems: Array[Array[T]], size: Int) extends Matrix(elems, size, size)

object SquareMatrix {

  /** Returns a square matrix of zeros.
    *
    * @param n Size of the matrix, should be positive.
    * @return An nxn matrix of all zeros.
    */
  def zeros[T: Numeric: ClassTag](n: Int): SquareMatrix[T] =
    SquareMatrix(Array.fill(n, n)(implicitly[Numeric[T]].zero), n)

  /** Returns a square matrix of ones.
    *
    * @param n Size of the matrix, should be positive.
    * @return An nxn matrix of all ones.
    */
  def ones[T: Numeric: ClassTag](n: Int): SquareMatrix[T] =
    SquareMatrix(Array.fill(n, n)(implicitly[Numeric[T]].one), n)

  /** Returns an identity matrix of the given size.
    *
    * @param n Size of the matrix, should be positive.
    * @return Identity matrix of size nxn.
    */
  def identity[T: Numeric: ClassTag](n: Int): SquareMatrix[T] = {
    val m   = zeros(n)
    val one = implicitly[Numeric[T]].one
    (0 until n).foreach(i => m(i, i) = one)
    m
  }

}
