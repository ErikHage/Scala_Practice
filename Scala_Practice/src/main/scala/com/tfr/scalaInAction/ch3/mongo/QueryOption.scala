package com.tfr.scalaInAction.ch3.mongo

import com.mongodb.DBObject

/**
  * Created by Erik on 7/14/2017.
  */
sealed trait QueryOption {

}

case object NoOption extends QueryOption

case class Sort(sorting:DBObject, anotherOption: QueryOption) extends QueryOption

case class Skip(number:Int, anotherOption: QueryOption) extends QueryOption

case class Limit(limit:Int, anotherOption: QueryOption) extends QueryOption