package io.finch.static

import java.io.File
import java.nio.file.Files

import com.twitter.finagle.httpx.Request
import com.twitter.util.Await
import io.finch._
import io.finch.route._
import io.finch.response.EncodeResponse
import org.scalatest.{Matchers, FlatSpec}

class StaticEndpointSpec extends FlatSpec with Matchers {

  private def getFile(path: String): File = {
    val resource = getClass.getResource(path)
    new File(resource.getPath)
  }

  private def service[A](out: => A)(implicit encoder: EncodeResponse[A]) = get(/) { out } toService

  it should "properly encode binary file as an endpoint output" in {

    val file = getFile("/static/finch-logo.png")
    val response = Await result service(file).apply(Request("/"))

    response.getStatusCode() shouldBe 200
    response.contentType shouldBe Some("application/octet-stream;charset=utf-8")

    val responseString = response.contentString
    val fileString = new String(Files.readAllBytes(file.toPath))
    responseString shouldBe fileString

  }

  it should "properly encode text file as an endpoint output" in {

    val file = getFile("/static/text.txt")
    val response = Await result service(file).apply(Request("/"))

    response.getStatusCode() shouldBe 200
    response.contentType shouldBe Some("application/octet-stream;charset=utf-8")

    val responseString = response.contentString

    responseString shouldBe "fffinch"

  }

}