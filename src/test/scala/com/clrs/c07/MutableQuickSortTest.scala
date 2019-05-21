package com.clrs.c07

import com.clrs.c01.GenericSortTest

import scala.collection.mutable

class MutableQuickSortTest extends GenericSortTest[Int, mutable.IndexedSeq](MutableQuickSort)