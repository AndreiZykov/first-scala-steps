package repository

import com.fasterxml.jackson.module.scala.deser.overrides.MutableList
import javax.inject.{Inject, Singleton}
import model.entity.User

@Singleton
class UserRepository @Inject() extends BaseRepository[User] {

  private val users: MutableList[User] = List[User](
    User(0, "userName1", "firstName1", "lastName1"),
    User(1, "userName2", "firstName2", "lastName2"),
    User(2, "userName3", "firstName3", "lastName3"),
    User(3, "userName4", "firstName4", "lastName4")
  )

  override def list(page: Int = 0, limit: Int = 10): Seq[User] = users.toSeq

  override def byId(id: Long): Option[User] = users.find(user => user.id.equals(id))

}
