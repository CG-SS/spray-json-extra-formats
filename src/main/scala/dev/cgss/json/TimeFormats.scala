package dev.cgss.json

import spray.json.DefaultJsonProtocol.StringJsonFormat
import spray.json.{JsString, JsValue, JsonFormat, deserializationError, enrichAny}

import java.time.format.DateTimeFormatter
import java.time.{Instant, LocalDate, LocalDateTime, ZoneId}

trait TimeFormats {

  implicit object InstantFormat extends JsonFormat[Instant] {
    override def write(obj: Instant): JsValue = obj.toString.toJson

    override def read(json: JsValue): Instant = json match {
      case JsString(value) => Instant.parse(value)
      case value => deserializationError("Expected Instant as JsString, but got " + value)
    }
  }

  implicit object ZoneIdFormat extends JsonFormat[ZoneId] {
    override def read(json: JsValue): ZoneId = json match {
      case JsString(value) => ZoneId.of(value)
      case value => deserializationError("Expected ZoneId as JsString, but got " + value)
    }

    override def write(obj: ZoneId): JsValue = obj.toString.toJson
  }

  implicit object LocalDateJsonFormat extends JsonFormat[LocalDate] {
    override def read(json: JsValue): LocalDate = json match {
      case JsString(value) => LocalDate.from(DateTimeFormatter.ISO_LOCAL_DATE.parse(value))
      case value => deserializationError("Expected LocalDate as JsString, but got " + value)
    }

    override def write(obj: LocalDate): JsValue = Option(obj) match {
      case Some(value) => DateTimeFormatter.ISO_LOCAL_DATE.format(value).toJson
      case None => deserializationError("LocalDate cannot be null")
    }
  }

  implicit object LocalDateTimeJsonFormat extends JsonFormat[LocalDateTime] {
    override def read(json: JsValue): LocalDateTime = json match {
      case JsString(value) => LocalDateTime.from(DateTimeFormatter.ISO_LOCAL_DATE_TIME.parse(value))
      case value => deserializationError("Expected LocalDateTime as JsString, but got " + value)
    }

    override def write(obj: LocalDateTime): JsValue = Option(obj) match {
      case Some(value) => DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(value).toJson
      case None => deserializationError("LocalDateTime cannot be null")
    }
  }

}
