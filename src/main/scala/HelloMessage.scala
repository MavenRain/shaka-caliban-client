package example

import concurrent.ExecutionContext.Implicits.global
import org.getshaka.shaka.{Component, ComponentBuilder, render}
import org.getshaka.shaka.builders.{color, div, t}
import scala.util.chaining.scalaUtilChainingOps
import sttp.client3.quick.{backend, UriContext}
import zio.ZIO.{fromEither, fromFuture}
import zio.Runtime.default.unsafeRunAsync_

class HelloMessage(user: String) extends Component:
  override val template: ComponentBuilder =
    div{ color("purple"); t"Hello $user"}

@main def launchApp(): Unit =
  Client
    .ColorQueries
    .characters(Client.Character.view)
    .toRequest(uri"http://localhost:8088/api")
    .send(backend)
    .map(_.body)
    .pipe(future => fromFuture(_ => future))
    .flatMap(fromEither(_))
    .map(response => render(HelloMessage(user = response.toString)))
    .pipe(unsafeRunAsync_(_))

