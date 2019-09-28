package com.clrs.c04

import com.clrs.common.matrix.SquareMatrix
import org.scalacheck.{Arbitrary, Gen}
import org.scalatest.propspec.AnyPropSpec
import org.scalatest.OptionValues
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

import scala.reflect.ClassTag
import org.scalatest.matchers.should.Matchers

abstract class MatrixMultiplicationPropertyTest(alg: MatrixMultiplication)
    extends AnyPropSpec
    with Matchers
    with ScalaCheckPropertyChecks
    with OptionValues {

  def squareMatrixGenN[T: Numeric: ClassTag: Arbitrary](n: Int): Gen[SquareMatrix[T]] = for {
    size <- Gen.const(n)
    rowGen = Gen.containerOfN[Array, T](size, implicitly[Arbitrary[T]].arbitrary)
    elems <- Gen.containerOfN[Array, Array[T]](size, rowGen)
  } yield SquareMatrix(elems, size)

  def squareMatrixGen[T: Numeric: ClassTag: Arbitrary]: Gen[SquareMatrix[T]] = for {
    size <- Gen.choose(1, 100)
    m    <- squareMatrixGenN(size)
  } yield m

  property("A0 = 0 [Zero]") {
    forAll(squareMatrixGen[Int]) { A =>
      val zeros  = SquareMatrix.zeros[Int](A.size)
      val result = alg.matMul(A, zeros)
      result.size  shouldEqual zeros.size
      result.elems should contain theSameElementsAs zeros.elems
    }
  }

  property("AI = A [Left identity]") {
    forAll(squareMatrixGen[Int]) { A =>
      val I      = SquareMatrix.identity[Int](A.size)
      val result = alg.matMul(A, I)
      result.size  shouldEqual A.size
      result.elems should contain theSameElementsAs A.elems
    }
  }

  property("IA = A [Right identity]") {
    forAll(squareMatrixGen[Int]) { A =>
      val I      = SquareMatrix.identity[Int](A.size)
      val result = alg.matMul(I, A)
      result.size  shouldEqual A.size
      result.elems should contain theSameElementsAs A.elems
    }
  }

  property("(AB)C = A(BC) [Left identity]") {
    forAll(Gen.listOfN(3, squareMatrixGenN[Int](10))) { ms =>
      val left = ms.reduceLeft[SquareMatrix[Int]](alg.matMul)
      val right = ms.reduceRight[SquareMatrix[Int]](alg.matMul)
      left.elems should contain theSameElementsAs right.elems
    }
  }

  property("*/ = \\* [Generalized associativity]") {
    forAll(Gen.nonEmptyListOf(squareMatrixGenN[Int](4))) { ms =>
      val left = ms.reduceLeft[SquareMatrix[Int]](alg.matMul)
      val right = ms.reduceRight[SquareMatrix[Int]](alg.matMul)
      left.elems should contain theSameElementsAs right.elems
    }
  }

}

class OrdinaryMatrixMultiplicationTest extends MatrixMultiplicationPropertyTest(OrdinaryMatrixMultiplication)
