package com.clrs

package object common {

  /**
    * Type for better code clarity.
    * Whenever an algorithm needs to return an index as the result, we will use this type.
    */
  type Index = Int

  /**
    * Type for all classes which have a key that can be used as indices of arrays.
    */
  type IndexKey = HasKey[Index]

}
