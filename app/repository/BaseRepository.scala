package repository

trait BaseRepository[Entity] {
  def list(page: Int, limit: Int): Seq[Entity]
  def byId(id: Long): Option[Entity]
}
