package models

import play.api.libs.json.{Json, OFormat}

trait UserModule {

  case class UserQuery(name: Option[String], mobile: Option[String])

  case class UserCreateForm(name: String, password: String, salt: String, mobile: Option[String])

  object UserCreateForm {
    implicit val userCreateFormat: OFormat[UserCreateForm] = Json.format[UserCreateForm]
  }

  case class UserUpdate(name: Option[String], password: Option[String], mobile: Option[String])

  object UserUpdate {
    implicit val userUpdateFormFormat: OFormat[UserUpdate] = Json.format[UserUpdate]
  }

}

object UserModule extends UserModule