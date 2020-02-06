package controllers

import javax.inject._
import model.{Error, Response}
import model.entity.User
import play.api.libs.json.{JsValue, Json}
import play.api.mvc._
import repository.UserRepository

@Singleton
class UserController @Inject()(val controllerComponents: ControllerComponents,
                               val userRepository: UserRepository) extends BaseController {

  def index(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(Json.toJson(Response(Some(userRepository.list()))))
  }

  def byId(id: Long): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    def success(user: User): JsValue = Json.toJson(Response(Some(user)))
    // why None is not working, only Some(None) ???
    def failure(): JsValue = Json.toJson(Response(Some(None), Some(Error(404, "resource not found"))))
    Ok(userRepository.byId(id)
      .fold(failure())(user => success(user)))
  }

}