Introduction to Algorithms in Scala
===================================

You will nee Java 8 or later and [sbt](http://www.scala-sbt.org) in
order to compile and run tests.

This project is an attempt to implement algorithms in
`Introduction to algorithms, 3rd edition, CLRS, MIT Press` in Scala.

In most cases the implementations are identical to the original
algorithms in the book. In many cases a functional counterpart is also
implemented. Check the Scaladocs of classes and functions for more
info per case.

Indices
-------
The book has the convention of 1-based indices for arrays, i.e. first
element is located at index 1, except for very rare cases
where 0-based indices are used. Fortunately the book clearly
mentions it in each case when stating the problem.
We follow the 0-based convention here though because in Scala, as in
almost every other programming language, arrays are 0-based.

Exercises are not implemented, except for those  introducing new ideas
and algorithms. The code of honor here is
that this project should be used solely for learning more about
algorithms, Scala, and functional programming and not as a help for
exercises.

Test
----
Tests are written using [ScalaTest](http://www.scalatest.org/).
Run them with the following command:

    > sbt test

Disclaimer
----------
This project is written simply for learning and educational purposes.
None of the written data structures and algorithm are properly tested
against real data.