package com.clrs.c04

import com.clrs.common.matrix.SquareMatrix

import scala.math.Numeric.Implicits.infixNumericOps
import scala.reflect.ClassTag

/** Ordinary square matrix multiplication, runs in O(n³).
  * Chapter 4, Section 4.2, Page 79
  */
object OrdinaryMatrixMultiplication extends MatrixMultiplication {

  /** Square matrix multiplication, runs in O(n³).
    *
    * @param A Left matrix.
    * @param B Right matrix.
    * @tparam T Parametric type of elements, has to be numeric.
    * @return C = AB
    */
  def matMul[T: Numeric: ClassTag](A: SquareMatrix[T], B: SquareMatrix[T]): SquareMatrix[T] = {
    require(A.size == B.size, s"Shape mismatch: A: ${A.size} B: ${B.size}")
    val n = A.size
    val C = SquareMatrix(Array.ofDim[T](n, n), n)
    for {
      i <- 0 until n
      j <- 0 until n
      cij = 0.until(n).map(k => A(i, k) * B(k, j)).sum
    } C(i, j) = cij
    C
  }

}
