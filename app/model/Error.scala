package model

import play.api.libs.json.{Json, Writes}

case class Error(code: Int, message: String)

object Error {
  implicit val writes: Writes[Error] = (error: Error) => Json.obj(
    "code" -> error.code,
    "message" -> error.message,
  )
}
