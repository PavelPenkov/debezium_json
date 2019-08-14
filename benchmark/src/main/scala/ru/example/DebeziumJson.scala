package ru.example

import com.github.plokhotnyuk.jsoniter_scala.core._
import org.openjdk.jmh.annotations._

import scala.io.Source

@State(Scope.Thread)
class DebeziumJson {
  import Codecs._

  var jsonBytes: Array[Byte] = _

  @Setup
  def initialize(): Unit = {
    jsonBytes = Source.fromResource("posting.json").mkString.getBytes()
  }

  @Benchmark
  def jsonIter() = {
    readFromArray[FastValue](jsonBytes)
  }
}
