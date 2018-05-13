package models

import com.github.jccode.slickx.core.BaseEntity
import play.api.libs.json.{Json, OFormat}
import common.JsonFormater._

case class User(id: Int, name: String, password: String, salt: String, mobile: Option[String], createTime: java.sql.Timestamp, updateTime: java.sql.Timestamp) extends BaseEntity

object User {
  implicit val userFormat: OFormat[User] = Json.format[User]
}
