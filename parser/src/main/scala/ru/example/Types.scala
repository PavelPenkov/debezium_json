package ru.example

sealed trait DbzSource

case class DbzPostgreSQLSource(
                                version: String,
                                name: String,
                                db: String,
                                ts_usec: Long,
                                txId: Long,
                                lsn: Long
                              ) extends DbzSource {
}

case class DbzSqlServerSource(version: String,
                              name: String,
                              ts_ms: Long,
                              change_lsn: String,
                              commit_lsn: String,
                              snapshot: Boolean) extends DbzSource {
}

case class MapWrapper(bytes: Array[Byte])

sealed trait Payload {
  val ts_ms: Long
  val source: DbzSource
}

case class CreatePayload(after: MapWrapper, ts_ms: Long, source: DbzSource) extends Payload
case class DeletePayload(before: MapWrapper, ts_ms: Long, source: DbzSource) extends Payload
case class UpdatePayload(before: MapWrapper, after: MapWrapper, ts_ms: Long, source: DbzSource) extends Payload

case class FastValue(payload: Payload)
