package com.clrs.common

/** A very simple object as a showcase of objects with key and satellite data.
  *
  * @param key                  Key.
  * @param satelliteStringField A satellite field.
  * @tparam K Key type.
  */
case class SatelliteObject[+K](key: K, satelliteStringField: String) extends HasKey[K] {
  override def toString: String = s"""<K:$key Sat:"$satelliteStringField">"""
}

object SatelliteObject {

  /** Ordering which only takes key into account, which is all we want.
    *
    * @tparam K Type of k, which should have an ordering.
    * @return
    */
  implicit def orderingByKey[K: Ordering]: Ordering[SatelliteObject[K]] = Ordering.by(_.key)

}
