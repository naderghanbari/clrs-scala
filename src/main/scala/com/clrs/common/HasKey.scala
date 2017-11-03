package com.clrs.common

/**
  * Objects having this trait will have an accessible key.
  *
  * @tparam K Key type.
  * @author Nader Hadji Ghanbari
  */
trait HasKey[+K] {

  /**
    * Key of this object.
    *
    * @return Key.
    */
  def key: K

}