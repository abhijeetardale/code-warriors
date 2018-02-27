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
import reactivemongo.api.{MongoConnection, MongoDriver, DefaultDB}

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


@Singleton
class HomeController @Inject() (ws: WSClient)(implicit val messagesApi: MessagesApi, context: ExecutionContext) extends Controller with i18n.I18nSupport {


  def home = Action { implicit request =>
    Ok(views.html.home())
  }
  def profile = Action { implicit request =>
    Ok(views.html.profile())
  }
  def league = Action { implicit request =>
    Ok(views.html.league())
  }
}


