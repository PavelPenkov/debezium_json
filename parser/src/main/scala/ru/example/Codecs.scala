package ru.example

import com.github.plokhotnyuk.jsoniter_scala.core.{JsonReader, JsonValueCodec, JsonWriter}
import com.github.plokhotnyuk.jsoniter_scala.macros.{CodecMakerConfig, JsonCodecMaker}

object Codecs {
  implicit val sourceCodec = JsonCodecMaker.make[DbzSource](
    CodecMakerConfig(discriminatorFieldName = Some("connector"),
      adtLeafClassNameMapper = {
        case "ru.example.DbzSqlServerSource" => "sqlserver"
        case "ru.example.DbzPostgreSQLSource" => "postgres"
      }
    )
  )

  implicit val mapCodec = new JsonValueCodec[MapWrapper] {
    override def decodeValue(in: JsonReader, default: MapWrapper): MapWrapper = {
      MapWrapper(in.readRawValAsBytes())
    }

    override def encodeValue(x: MapWrapper, out: JsonWriter): Unit = ???

    override def nullValue: MapWrapper = MapWrapper(new Array[Byte](0))
  }

  implicit val payloadCodec = JsonCodecMaker.make[Payload](CodecMakerConfig(
    discriminatorFieldName = Some("op"),
    adtLeafClassNameMapper = {
      case "ru.example.UpdatePayload" => "u"
      case "ru.example.CreatePayload" => "c"
      case "ru.example.DeletePayload" => "d"
    }
  ))

  implicit val fastValueCodec = JsonCodecMaker.make[FastValue](CodecMakerConfig())
}
