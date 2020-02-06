package model

import play.api.libs.json.{Json, OWrites, Writes}

case class Response[T](data: Option[T], error: Option[Error] = None)

object Response {
  implicit def writes[T](implicit nested: Writes[T]): Writes[Response[T]] = OWrites[Response[T]] { response =>
    Json.obj(
      "data" -> response.data,
      "error" -> response.error
    )
  }
}