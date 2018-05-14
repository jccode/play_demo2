package services

import com.github.jccode.slickx.core.BaseRepo
import slick.lifted.TableQuery
import common.Slick._
import common.migrate._
import common.utils._
import scala.concurrent.{Future, ExecutionContext}

trait BaseService[E] {
  def all(): Future[Seq[E]]

  def get(id: Int): Future[Option[E]]

  def insert(entity: E): Future[Int]

  def update(entity: E): Future[Int]

  def delete(id: Int): Future[Int]
}

abstract class AbstractService[T <: slick.lifted.AbstractTable[_], Q <: TableQuery[T], E]
(repo: BaseRepo[T, Q])
(implicit rowToModelMigration: Migration[T#TableElementType, E],
 modelToRowMigration: Migration[E, T#TableElementType],
 ec: ExecutionContext)
  extends BaseService[E] {

  private def rowToModel(e: T#TableElementType) = e.migrateTo[E]

  private def modelToRow(m: E): T#TableElementType = m.migrateTo[T#TableElementType]

  def all(): Future[Seq[E]] = repo.all().map(_.map(rowToModel))

  def get(id: Int): Future[Option[E]] = repo.get(id).map(_.map(rowToModel))

  def insert(entity: E): Future[Int] = repo.insert(modelToRow(entity))

  def update(entity: E): Future[Int] = repo.update(modelToRow(entity))

  def delete(id: Int): Future[Int] = repo.delete(id)
}