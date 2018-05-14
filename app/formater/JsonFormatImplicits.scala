package formater

import common.JsonFormater
import dao.Tables
import play.api.libs.json.{Json, OFormat}

/**
  * JsonFormatImplicis
  *
  * @author 01372461
  */
trait JsonFormatImplicits extends JsonFormater with Tables {

  implicit val userFormat: OFormat[User] = Json.format[User]

}
