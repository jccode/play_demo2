package services

import com.google.inject.ImplementedBy
import models.User


@ImplementedBy(classOf[UserServiceImpl])
trait UserService extends BaseService[User]

