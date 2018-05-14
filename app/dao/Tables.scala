package dao
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = slick.jdbc.H2Profile
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.jdbc.JdbcProfile
  import profile.api._
  import com.github.jccode.slickx.core._

  import com.github.jccode.slickx.play.JsonFormatImplicits._
  import play.api.libs.json._
      import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = accounts.schema ++ products.schema ++ users.schema
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table accounts
   *  @param id Database column ID SqlType(INTEGER), AutoInc, PrimaryKey
   *  @param userId Database column USER_ID SqlType(INTEGER)
   *  @param name Database column NAME SqlType(VARCHAR), Length(50,true)
   *  @param balance Database column BALANCE SqlType(INTEGER)
   *  @param createTime Database column CREATE_TIME SqlType(TIMESTAMP)
   *  @param updateTime Database column UPDATE_TIME SqlType(TIMESTAMP) */
  case class Account(id: Int, userId: Int, name: String, balance: Option[Int], createTime: java.sql.Timestamp, updateTime: java.sql.Timestamp) extends BaseEntity
  object Account { implicit val accountFormat: OFormat[Account] = Json.format[Account]}
  /** GetResult implicit for fetching Account objects using plain SQL queries */
  implicit def GetResultAccount(implicit e0: GR[Int], e1: GR[String], e2: GR[Option[Int]], e3: GR[java.sql.Timestamp]): GR[Account] = GR{
    prs => import prs._
    (Account.apply _).tupled((<<[Int], <<[Int], <<[String], <<?[Int], <<[java.sql.Timestamp], <<[java.sql.Timestamp]))
  }
  /** Table description of table ACCOUNT. Objects of this class serve as prototypes for rows in queries. */
  class AccountTable(_tableTag: Tag) extends profile.api.Table[Account](_tableTag, "ACCOUNT") with BaseTable {
    def * = (id, userId, name, balance, createTime, updateTime) <> ((Account.apply _).tupled, Account.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(userId), Rep.Some(name), balance, Rep.Some(createTime), Rep.Some(updateTime)).shaped.<>({r=>import r._; _1.map(_=> (Account.apply _).tupled((_1.get, _2.get, _3.get, _4, _5.get, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(INTEGER), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("ID", O.AutoInc, O.PrimaryKey)
    /** Database column USER_ID SqlType(INTEGER) */
    val userId: Rep[Int] = column[Int]("USER_ID")
    /** Database column NAME SqlType(VARCHAR), Length(50,true) */
    val name: Rep[String] = column[String]("NAME", O.Length(50,varying=true))
    /** Database column BALANCE SqlType(INTEGER) */
    val balance: Rep[Option[Int]] = column[Option[Int]]("BALANCE")
    /** Database column CREATE_TIME SqlType(TIMESTAMP) */
    val createTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CREATE_TIME")
    /** Database column UPDATE_TIME SqlType(TIMESTAMP) */
    val updateTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("UPDATE_TIME")

    /** Index over (name) (database name ACCOUNT_NAME) */
    val index1 = index("ACCOUNT_NAME", name)
  }
  /** Collection-like TableQuery object for table accounts */
  lazy val accounts = new TableQuery(tag => new AccountTable(tag))

  /** Entity class storing rows of table products
   *  @param id Database column ID SqlType(INTEGER), AutoInc, PrimaryKey
   *  @param name Database column NAME SqlType(VARCHAR), Length(50,true)
   *  @param price Database column PRICE SqlType(INTEGER)
   *  @param stock Database column STOCK SqlType(INTEGER)
   *  @param createTime Database column CREATE_TIME SqlType(TIMESTAMP)
   *  @param updateTime Database column UPDATE_TIME SqlType(TIMESTAMP) */
  case class Product(id: Int, name: String, price: Option[Int], stock: Option[Int], createTime: java.sql.Timestamp, updateTime: java.sql.Timestamp) extends BaseEntity
  object Product { implicit val productFormat: OFormat[Product] = Json.format[Product]}
  /** GetResult implicit for fetching Product objects using plain SQL queries */
  implicit def GetResultProduct(implicit e0: GR[Int], e1: GR[String], e2: GR[Option[Int]], e3: GR[java.sql.Timestamp]): GR[Product] = GR{
    prs => import prs._
    (Product.apply _).tupled((<<[Int], <<[String], <<?[Int], <<?[Int], <<[java.sql.Timestamp], <<[java.sql.Timestamp]))
  }
  /** Table description of table PRODUCT. Objects of this class serve as prototypes for rows in queries. */
  class ProductTable(_tableTag: Tag) extends profile.api.Table[Product](_tableTag, "PRODUCT") with BaseTable {
    def * = (id, name, price, stock, createTime, updateTime) <> ((Product.apply _).tupled, Product.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(name), price, stock, Rep.Some(createTime), Rep.Some(updateTime)).shaped.<>({r=>import r._; _1.map(_=> (Product.apply _).tupled((_1.get, _2.get, _3, _4, _5.get, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(INTEGER), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("ID", O.AutoInc, O.PrimaryKey)
    /** Database column NAME SqlType(VARCHAR), Length(50,true) */
    val name: Rep[String] = column[String]("NAME", O.Length(50,varying=true))
    /** Database column PRICE SqlType(INTEGER) */
    val price: Rep[Option[Int]] = column[Option[Int]]("PRICE")
    /** Database column STOCK SqlType(INTEGER) */
    val stock: Rep[Option[Int]] = column[Option[Int]]("STOCK")
    /** Database column CREATE_TIME SqlType(TIMESTAMP) */
    val createTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CREATE_TIME")
    /** Database column UPDATE_TIME SqlType(TIMESTAMP) */
    val updateTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("UPDATE_TIME")

    /** Index over (name) (database name PRODUCT_NAME) */
    val index1 = index("PRODUCT_NAME", name)
  }
  /** Collection-like TableQuery object for table products */
  lazy val products = new TableQuery(tag => new ProductTable(tag))

  /** Entity class storing rows of table users
   *  @param id Database column ID SqlType(INTEGER), AutoInc, PrimaryKey
   *  @param name Database column NAME SqlType(VARCHAR), Length(50,true)
   *  @param password Database column PASSWORD SqlType(VARCHAR), Length(128,true)
   *  @param salt Database column SALT SqlType(VARCHAR), Length(128,true)
   *  @param mobile Database column MOBILE SqlType(VARCHAR), Length(20,true)
   *  @param createTime Database column CREATE_TIME SqlType(TIMESTAMP)
   *  @param updateTime Database column UPDATE_TIME SqlType(TIMESTAMP) */
  case class User(id: Int, name: String, password: String, salt: String, mobile: Option[String], createTime: java.sql.Timestamp, updateTime: java.sql.Timestamp) extends BaseEntity
  object User { implicit val userFormat: OFormat[User] = Json.format[User]}
  /** GetResult implicit for fetching User objects using plain SQL queries */
  implicit def GetResultUser(implicit e0: GR[Int], e1: GR[String], e2: GR[Option[String]], e3: GR[java.sql.Timestamp]): GR[User] = GR{
    prs => import prs._
    (User.apply _).tupled((<<[Int], <<[String], <<[String], <<[String], <<?[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp]))
  }
  /** Table description of table USER. Objects of this class serve as prototypes for rows in queries. */
  class UserTable(_tableTag: Tag) extends profile.api.Table[User](_tableTag, "USER") with BaseTable {
    def * = (id, name, password, salt, mobile, createTime, updateTime) <> ((User.apply _).tupled, User.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(name), Rep.Some(password), Rep.Some(salt), mobile, Rep.Some(createTime), Rep.Some(updateTime)).shaped.<>({r=>import r._; _1.map(_=> (User.apply _).tupled((_1.get, _2.get, _3.get, _4.get, _5, _6.get, _7.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(INTEGER), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("ID", O.AutoInc, O.PrimaryKey)
    /** Database column NAME SqlType(VARCHAR), Length(50,true) */
    val name: Rep[String] = column[String]("NAME", O.Length(50,varying=true))
    /** Database column PASSWORD SqlType(VARCHAR), Length(128,true) */
    val password: Rep[String] = column[String]("PASSWORD", O.Length(128,varying=true))
    /** Database column SALT SqlType(VARCHAR), Length(128,true) */
    val salt: Rep[String] = column[String]("SALT", O.Length(128,varying=true))
    /** Database column MOBILE SqlType(VARCHAR), Length(20,true) */
    val mobile: Rep[Option[String]] = column[Option[String]]("MOBILE", O.Length(20,varying=true))
    /** Database column CREATE_TIME SqlType(TIMESTAMP) */
    val createTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("CREATE_TIME")
    /** Database column UPDATE_TIME SqlType(TIMESTAMP) */
    val updateTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("UPDATE_TIME")

    /** Index over (name) (database name USER_NAME) */
    val index1 = index("USER_NAME", name)
  }
  /** Collection-like TableQuery object for table users */
  lazy val users = new TableQuery(tag => new UserTable(tag))
}
