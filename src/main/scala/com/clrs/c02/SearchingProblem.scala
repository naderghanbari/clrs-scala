package com.clrs.c02

import com.clrs.common.Index

import scala.reflect.ClassTag

/**
  * Searching Problem
  * Chapter 2, Section 2.1, Exercise 2.1-3, Page 22
  *
  * @author Nader Hadji Ghanbari
  */
trait SearchingProblem {

  /**
    * A searching problem.
    *
    * @param A A sequence of n numbers < a₁, a₂, ..., an >
    * @param v Value to search for.
    * @tparam Key Type of the keys.
    * @return An index i such that v = A[i] or `None` if v does not appear in A.
    */
  def search[Key: ClassTag](A: Seq[Key], v: Key): Option[Index]

}
