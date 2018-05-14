package formater

import common.JsonFormater
import dao.Tables.User
import play.api.libs.json.{Json, OFormat}

/**
  * JsonFormatImplicis
  *
  * @author 01372461
  */
object JsonFormatImplicits extends JsonFormater {

  implicit val userFormat: OFormat[User] = Json.format[User]

}
