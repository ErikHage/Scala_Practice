package com.tfr.rwb.sales.util

import com.fasterxml.jackson.databind.{DeserializationFeature, ObjectMapper}
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule

/**
  * Created by Erik Hage on 8/13/2017.
  */
object JsonUtil {

  val mapper = new ObjectMapper() with ScalaObjectMapper
  mapper.registerModule(DefaultScalaModule)
  mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

  def fromJson[T](json: String)(implicit m : Manifest[T]): T ={
    mapper.readValue[T](json)
  }

  def toJson(value: Any): String = {
    mapper.writeValueAsString(value)
  }

}