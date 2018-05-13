package controllers

import common.utils._
import javax.inject.{Inject, Singleton}
import play.api.mvc.{AbstractController, ControllerComponents}
import services.apis.UserService

import scala.concurrent.ExecutionContext

@Singleton
class UserController @Inject()(cc: ControllerComponents, service: UserService)(implicit ec: ExecutionContext) extends AbstractController(cc) {

  def userList() = Action.async {
    service.all.map(success(_))
  }

}
