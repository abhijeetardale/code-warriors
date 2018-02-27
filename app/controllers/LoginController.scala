package controllers

import java.util
import javax.inject._

import play.Routes
import play.api._
import play.api.i18n.MessagesApi
import play.api.mvc._
import play.api.libs.json.Json
import play.api.libs.ws.WSClient
import play.api.mvc.Controller
import play.api.routing.JavaScriptReverseRouter
import play.modules.reactivemongo.ReactiveMongoApi
import reactivemongo.api.{DefaultDB, MongoConnection, MongoDriver}

import scala.concurrent.Future
import scala.concurrent.duration._
import play.api.mvc._
import play.api.libs.ws._
import play.api.http.HttpEntity
import javax.inject.Inject

import play.api._
import play.api.mvc._

import scala.concurrent.ExecutionContext
import scala.util.{Failure, Success, Try}
import play.api.data.Form
import play.api.data.Forms._



@Singleton
class LoginController @Inject() (ws: WSClient)(implicit val messagesApi: MessagesApi, context: ExecutionContext) extends Controller with i18n.I18nSupport {


  def presentLogin = Action { implicit request =>
    Ok(views.html.login())
  }

  def submitLogin = Action { implicit request =>

    loginForm.bindFromRequest.fold(
      hasErrors => BadRequest("Bad Request"),
      successSub => {

        if(successSub.userName.isEmpty){
          Ok("Not Logged in")

        }else {

          Redirect("/home")
        }
      }
    )
  }

  case class LoginForm(userName: String, password: String)

  object LoginForm {
    implicit val formats = Json.format[LoginForm]
  }


  def loginForm(implicit request: Request[_]) = Form(
    mapping(
      "userName" -> text,
      "password" -> text
    )(LoginForm.apply)(LoginForm.unapply)
  )

}


