package dev.cgss.json

import spray.json.{BasicFormats, JsBoolean, JsNull, JsNumber, JsString, JsValue, JsonFormat, deserializationError, enrichAny}

trait OptionBasicFormats extends BasicFormats {

  implicit object OptionIntJsonFormat extends JsonFormat[Option[Int]] {
    override def read(json: JsValue): Option[Int] = json match {
      case number: JsNumber => Some(number.convertTo[Int])
      case JsNull => None
      case value => deserializationError("Expected optional Int as JsNumber or JsNull, but got " + value)
    }

    override def write(obj: Option[Int]): JsValue = obj match {
      case Some(value) => value.toJson
      case None => JsNull
    }
  }

  implicit object OptionLongJsonFormat extends JsonFormat[Option[Long]] {
    override def read(json: JsValue): Option[Long] = json match {
      case number: JsNumber => Some(number.convertTo[Long])
      case JsNull => None
      case value => deserializationError("Expected optional Long as JsNumber or JsNull, but got " + value)
    }

    override def write(obj: Option[Long]): JsValue = obj match {
      case Some(value) => value.toJson
      case None => JsNull
    }
  }

  implicit object OptionFloatJsonFormat extends JsonFormat[Option[Float]] {
    override def read(json: JsValue): Option[Float] = json match {
      case number: JsNumber => Some(number.convertTo[Float])
      case JsNull => None
      case value => deserializationError("Expected optional Float as JsNumber or JsNull, but got " + value)
    }

    override def write(obj: Option[Float]): JsValue = obj match {
      case Some(value) => value.toJson
      case None => JsNull
    }
  }

  implicit object OptionDoubleJsonFormat extends JsonFormat[Option[Double]] {
    override def read(json: JsValue): Option[Double] = json match {
      case number: JsNumber => Some(number.convertTo[Double])
      case JsNull => None
      case value => deserializationError("Expected optional Double as JsNumber or JsNull, but got " + value)
    }

    override def write(obj: Option[Double]): JsValue = obj match {
      case Some(value) => value.toJson
      case None => JsNull
    }
  }

  implicit object OptionByteJsonFormat extends JsonFormat[Option[Byte]] {
    override def read(json: JsValue): Option[Byte] = json match {
      case number: JsNumber => Some(number.convertTo[Byte])
      case JsNull => None
      case value => deserializationError("Expected optional Byte as JsNumber or JsNull, but got " + value)
    }

    override def write(obj: Option[Byte]): JsValue = obj match {
      case Some(value) => value.toJson
      case None => JsNull
    }
  }

  implicit object OptionShortJsonFormat extends JsonFormat[Option[Short]] {
    override def read(json: JsValue): Option[Short] = json match {
      case number: JsNumber => Some(number.convertTo[Short])
      case JsNull => None
      case value => deserializationError("Expected optional Short as JsNumber or JsNull, but got " + value)
    }

    override def write(obj: Option[Short]): JsValue = obj match {
      case Some(value) => value.toJson
      case None => JsNull
    }
  }

  implicit object OptionBigDecimalJsonFormat extends JsonFormat[Option[BigDecimal]] {
    override def read(json: JsValue): Option[BigDecimal] = json match {
      case number: JsNumber => Some(number.convertTo[BigDecimal])
      case JsNull => None
      case value => deserializationError("Expected optional BigDecimal as JsNumber or JsNull, but got " + value)
    }

    override def write(obj: Option[BigDecimal]): JsValue = obj match {
      case Some(value) => value.toJson
      case None => JsNull
    }
  }

  implicit object OptionBigIntJsonFormat extends JsonFormat[Option[BigInt]] {
    override def read(json: JsValue): Option[BigInt] = json match {
      case number: JsNumber => Some(number.convertTo[BigInt])
      case JsNull => None
      case value => deserializationError("Expected optional BigInt as JsNumber or JsNull, but got " + value)
    }

    override def write(obj: Option[BigInt]): JsValue = obj match {
      case Some(value) => value.toJson
      case None => JsNull
    }
  }

  implicit object OptionUnitJsonFormat extends JsonFormat[Option[Unit]] {
    override def read(json: JsValue): Option[Unit] = Some(json.convertTo[Unit])

    override def write(obj: Option[Unit]): JsValue = obj match {
      case Some(value) => value.toJson
      case None => JsNull
    }
  }

  implicit object OptionBooleanJsonFormat extends JsonFormat[Option[Boolean]] {
    override def read(json: JsValue): Option[Boolean] = json match {
      case bool: JsBoolean => Some(bool.convertTo[Boolean])
      case JsNull => None
      case value => deserializationError("Expected optional Boolean or JsNull, but got " + value)
    }

    override def write(obj: Option[Boolean]): JsValue = obj match {
      case Some(value) => value.toJson
      case None => JsNull
    }
  }

  implicit object OptionCharJsonFormat extends JsonFormat[Option[Char]] {
    override def read(json: JsValue): Option[Char] = json match {
      case string: JsString => Some(string.convertTo[Char])
      case JsNull => None
      case value => deserializationError("Expected optional Char or JsNull, but got " + value)
    }

    override def write(obj: Option[Char]): JsValue = obj match {
      case Some(value) => value.toJson
      case None => JsNull
    }
  }

  implicit object OptionStringJsonFormat extends JsonFormat[Option[String]] {
    override def read(json: JsValue): Option[String] = json match {
      case string: JsString => Some(string.convertTo[String])
      case JsNull => None
      case value => deserializationError("Expected optional String or JsNull, but got " + value)
    }

    override def write(obj: Option[String]): JsValue = obj match {
      case Some(value) => value.toJson
      case None => JsNull
    }
  }

  implicit object OptionSymbolJsonFormat extends JsonFormat[Option[Symbol]] {
    override def read(json: JsValue): Option[Symbol] = json match {
      case string: JsString => Some(string.convertTo[Symbol])
      case JsNull => None
      case value => deserializationError("Expected optional Symbol or JsNull, but got " + value)
    }

    override def write(obj: Option[Symbol]): JsValue = obj match {
      case Some(value) => value.toJson
      case None => JsNull
    }
  }
}
