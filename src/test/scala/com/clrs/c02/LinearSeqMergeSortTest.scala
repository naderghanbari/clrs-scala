package com.clrs.c02

import com.clrs.c01.SortPropertyTest

import scala.collection.LinearSeq

class LinearSeqMergeSortTest extends SortPropertyTest[Int, LinearSeq](LinearSeqMergeSort)
