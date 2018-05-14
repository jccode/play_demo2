package repos

import com.github.jccode.slickx.core.{AbstractRepo, BaseRepo}
import com.google.inject.ImplementedBy
import dao.Tables._
import javax.inject.{Inject, Singleton}
import models.UserModule
import models.UserModule.{UserQuery, UserUpdate}
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}

@ImplementedBy(classOf[UserRepoImpl])
trait UserRepo extends BaseRepo[User] {

  def query(query: UserQuery): Future[Seq[User]]

  def patch(id: Int, update: UserUpdate): Future[Int]
}

@Singleton
class UserRepoImpl @Inject() (dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext)
  extends AbstractRepo[JdbcProfile, User, UserTable](dbConfigProvider.get[JdbcProfile], users) with UserRepo {

  import profile.api._

  override def query(query: UserModule.UserQuery) =
    db.run(users
      .filterOpt(query.name)(_.name === _)
      .filterOpt(query.mobile)(_.name === _)
      .result
    )

  override def patch(id: Int, user: UserModule.UserUpdate) =
    get(id).flatMap{ userOpt =>
      userOpt.map { u0 =>
        val u1 = u0.copy(name = user.name.getOrElse(u0.name), password = user.password.getOrElse(u0.password), mobile = user.mobile.orElse(u0.mobile))
        update(u1)
      }.getOrElse(Future { 0 })
    }
}