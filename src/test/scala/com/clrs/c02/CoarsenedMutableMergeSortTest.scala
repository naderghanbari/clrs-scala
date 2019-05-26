package com.clrs.c02

import com.clrs.c01.SortPropertyTest

import scala.collection.mutable

class CoarsenedMutableMergeSortTest extends SortPropertyTest[Int, mutable.IndexedSeq](new CoarsenedMutableMergeSort(2))
