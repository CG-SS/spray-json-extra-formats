package dev.cgss.json

import spray.json.DefaultJsonProtocol.listFormat
import spray.json.{JsArray, JsNull, JsValue, JsonFormat, RootJsonFormat, deserializationError, enrichAny}

trait OptionCollectionFormats {

  implicit def optionListFormat[T: JsonFormat]: RootJsonFormat[Option[List[T]]] = new RootJsonFormat[Option[List[T]]] {
    override def write(obj: Option[List[T]]): JsValue = obj match {
      case Some(value) => value.toJson
      case None => JsNull
    }

    override def read(json: JsValue): Option[List[T]] = json match {
      case array: JsArray => Some(array.convertTo[List[T]])
      case JsNull => None
      case value => deserializationError("Expected optional List as JsArray or JsNull, but got " + value)
    }
  }

}
