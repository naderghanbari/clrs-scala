package com.clrs.c07

import com.clrs.c01.SortPropertyTest

import scala.collection.mutable

class MutableQuickSortTest extends SortPropertyTest[Int, mutable.IndexedSeq](MutableQuickSort)