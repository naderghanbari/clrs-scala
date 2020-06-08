package com.clrs.common.binary

import com.clrs.common.binary.Binary.{B0, B1}
import org.scalacheck.Arbitrary.arbitrary
import org.scalacheck.Gen
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class BinaryTest extends AnyWordSpec with Matchers with ScalaCheckPropertyChecks {

  "Binary" should {

    "convert long to binary" in {
      Binary.from(0L) shouldEqual Binary(Seq.empty)
      Binary.from(1L) shouldEqual Binary(Seq(B1))
      Binary.from(2L) shouldEqual Binary(Seq(B1, B0))
      Binary.from(3L) shouldEqual Binary(Seq(B1, B1))
    }

    "conversion to binary should be isomorphic" in {
      forAll(arbitrary[Long], minSuccessful(20)) { n =>
        Binary.from(n).longValue shouldEqual n
      }
    }

    "conversion from binary should be isomorphic" in {
      forAll(Gen.listOf(Gen.oneOf(B0, B1)).map(_.take(63)), minSuccessful(20)) { bits =>
        Binary.from(Binary(bits).longValue) shouldEqual Binary(bits)
      }
    }

  }

}
