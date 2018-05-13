package repos

import com.github.jccode.slickx.core.{AbstractRepo, BaseRepo}
import com.google.inject.ImplementedBy
import dao.Tables._
import javax.inject.{Inject, Singleton}
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile
import slick.lifted.TableQuery

import scala.concurrent.ExecutionContext

@ImplementedBy(classOf[UserRepoImpl])
trait UserRepo extends BaseRepo[UserTable, TableQuery[UserTable]]

@Singleton
class UserRepoImpl @Inject() (dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext)
  extends AbstractRepo[JdbcProfile, User, UserTable, TableQuery[UserTable]](dbConfigProvider.get[JdbcProfile], users) with UserRepo {

}