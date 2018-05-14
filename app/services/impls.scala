package services

import javax.inject.{Inject, Singleton}
import slick.lifted.TableQuery
import dao.Tables.UserTable
import repos.UserRepo
import common.migrate._
import scala.concurrent.ExecutionContext

@Singleton
class UserServiceImpl @Inject()
(userRepo: UserRepo)
(implicit rowToModelMigration: Migration[UserTable#TableElementType, models.User],
 modelToRowMigration: Migration[models.User, UserTable#TableElementType],
 ec: ExecutionContext)
  extends AbstractService[UserTable, TableQuery[UserTable], models.User](userRepo) with UserService {

}

