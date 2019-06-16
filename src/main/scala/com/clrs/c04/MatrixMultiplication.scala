package com.clrs.c04

import com.clrs.common.matrix.SquareMatrix

import scala.reflect.ClassTag

/** Square matrix multiplication problem.
  * Chapter 4, Section 4.2, Pages 75 to 83
  */
trait MatrixMultiplication {

  /** Square matrix multiplication.
    *
    * @param A Left matrix.
    * @param B Right matrix.
    * @tparam T Parametric type of elements, has to be numeric.
    * @return C = AB
    */
  def matMul[T: Numeric: ClassTag](A: SquareMatrix[T], B: SquareMatrix[T]): SquareMatrix[T]

}
