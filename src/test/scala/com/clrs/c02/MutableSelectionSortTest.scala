package com.clrs.c02

import com.clrs.c01.SortPropertyTest

import scala.collection.mutable

class MutableSelectionSortTest extends SortPropertyTest[Int, mutable.IndexedSeq](MutableSelectionSort)
