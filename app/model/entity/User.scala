package model.entity

import play.api.libs.json.{Json, Writes}

case class User(id: Long, userName: String, firstName: String, lastName: String)

object User {
  implicit val writes: Writes[User] = (user: User) => Json.obj(
    "id" -> user.id,
    "username" -> user.userName,
    "firstName" -> user.firstName,
    "lastName" -> user.lastName
  )
}
