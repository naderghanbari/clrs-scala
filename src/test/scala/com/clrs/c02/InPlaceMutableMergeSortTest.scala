package com.clrs.c02

import com.clrs.c01.GenericSortTest

import scala.collection.mutable

class InPlaceMutableMergeSortTest extends GenericSortTest[Int, mutable.IndexedSeq](InPlaceMutableMergeSort)
