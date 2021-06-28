package dev.cgss.json

import spray.json.DefaultJsonProtocol.StringJsonFormat
import spray.json.{JsString, JsValue, JsonFormat, deserializationError, enrichAny}

import java.time.format.DateTimeFormatter
import java.time.{Instant, ZoneId}
import java.util.{Date, TimeZone}

trait DateFormats {

  implicit object DateJsonFormat extends JsonFormat[Date] {
    override def read(json: JsValue): Date = json match {
      case JsString(value) => new Date(Instant.from(DateTimeFormatter.ISO_DATE.parse(value)).toEpochMilli)
      case value => deserializationError("Expected Date as JsString, but got " + value)
    }

    override def write(obj: Date): JsValue = Option(obj) match {
      case Some(value) => DateTimeFormatter.ISO_DATE.format(value.toInstant.atZone(ZoneId.systemDefault())).toJson
      case None => deserializationError("Date cannot be null")
    }
  }

  implicit object TimeZoneJsonFormat extends JsonFormat[TimeZone] {
    override def write(obj: TimeZone): JsValue = obj.toString.toJson

    override def read(json: JsValue): TimeZone = json match {
      case JsString(value) => TimeZone.getTimeZone(value)
      case value => deserializationError("Expected TimeZone as JsString, but got " + value)
    }
  }

}
