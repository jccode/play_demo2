package controllers

import common.migrate._
import common.utils._
import javax.inject.{Inject, Singleton}
import play.api.mvc.{AbstractController, ControllerComponents}
import repos.UserRepo
import models.UserModule._
import dao.Tables.User
import scala.concurrent.ExecutionContext

@Singleton
class UserController @Inject()(cc: ControllerComponents , repo: UserRepo)(implicit ec: ExecutionContext) extends AbstractController(cc) {

  def userList() = Action.async {
    repo.all.map(success(_))
  }

  def query(name: Option[String], mobile: Option[String]) = Action.async {
    repo.query(UserQuery(name, mobile)).map(_.success)
  }

  def get(id: Int) = Action.async {
    repo.get(id).map(_.success)
  }

  def create() = Action.async { request =>
    withRequestJson[UserCreateForm](request) { userForm =>
      val user: User = userForm.migrateTo[User]
      repo.insert(user).map(success(_))
    }
  }

  def update(id: Int) = Action.async { request =>
    withRequestJson[UserUpdate](request) { updateForm =>
      repo.patch(id, updateForm).map(success(_))
    }
  }

  def delete(id: Int) = Action.async {
    repo.delete(id).map(_.success)
  }
}
