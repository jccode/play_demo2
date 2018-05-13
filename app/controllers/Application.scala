package controllers

import javax.inject.{Inject, Singleton}
import play.api._
import play.api.mvc._

@Singleton
class Application @Inject() (cc: ControllerComponents) extends AbstractController(cc) {

  def index = Action {
    Ok("Your new application is ready.")
  }

}