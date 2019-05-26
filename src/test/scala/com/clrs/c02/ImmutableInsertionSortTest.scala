package com.clrs.c02

import com.clrs.c01.SortPropertyTest

import scala.collection.immutable.Seq

class ImmutableInsertionSortTest extends SortPropertyTest[Int, Seq](ImmutableInsertionSort)
