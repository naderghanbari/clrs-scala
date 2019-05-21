package com.clrs.c02

import com.clrs.c01.GenericSortTest

import scala.collection.immutable.Seq

class ImmutableInsertionSortTest extends GenericSortTest[Int, Seq](ImmutableInsertionSort)
