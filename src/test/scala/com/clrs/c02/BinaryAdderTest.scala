package com.clrs.c02

import com.clrs.common.binary.Binary
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class BinaryAdderTest extends AnyWordSpec with Matchers {

  "Binary Adder" should {

    "add binary numbers correctly" in {
      val twelve = Binary.from("1100")
      val three  = Binary.from("011")
      (twelve + three).longValue shouldEqual 15
    }

  }

}
