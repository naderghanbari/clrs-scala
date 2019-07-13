package com.clrs.c02

import com.clrs.common.binary.Binary
import org.scalatest.Matchers
import org.scalatest.wordspec.AnyWordSpec

class BinaryAdderTest extends AnyWordSpec with Matchers {

  "Binary Adder" should {

    "add binary numbers correctly" in {
      val twelve = Binary("1100")
      val three  = Binary("011")
      (twelve + three).intValue shouldEqual 15
    }

  }

}
