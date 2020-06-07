[![Build Status](https://travis-ci.org/naderghanbari/clrs-scala.svg?branch=master)](https://travis-ci.org/naderghanbari/clrs-scala)

# Introduction to Algorithms in Scala
This project is an attempt to implement algorithms from
`Introduction to algorithms, 3rd edition, CLRS, MIT Press` in Scala, solely for 
learning and educational purposes.

In most cases the implementations are identical to the original
algorithms in the book. In some cases a functional counterpart is also
implemented. Check the docs of classes and functions for more
info per case.

## Indices
The book has the convention of 1-based indices for arrays, i.e. first
element is located at index 1, except for very rare cases
where 0-based indices are used.
We follow the 0-based convention here though, as in Scala like many 
other programming language, arrays are 0-based.

## Compile and Test
Java 8 or later and [sbt](http://www.scala-sbt.org) are required.

    > sbt compile

Tests are written using [ScalaTest](http://www.scalatest.org/) and [ScalaCheck](https://github.com/typelevel/scalacheck)
Run them with the following command:

    > sbt test
