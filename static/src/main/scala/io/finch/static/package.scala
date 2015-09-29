package io.finch

import java.io.File
import java.nio.file._
import com.twitter.io.Buf
import io.finch.response.EncodeResponse

package object static {

  /**
   * Encoder for java.io.File
   */
  implicit def encodeFile: EncodeResponse[File] =
    EncodeResponse("application/octet-stream") { file =>
      Buf.ByteArray.Shared(Files readAllBytes file.toPath)
    }

  /**
   * Helper endpoint for serving static files from base directory
   */
  def static(baseDirectory: File)(path: Seq[String]): Endpoint.Output[File] = {
    val file = new File(baseDirectory.getPath + "/" + path.mkString("/"))
    Ok(file)
  }

  /**
   * Helper endpoint for serving static files from base directory
   */
  def static(baseDirectory: String)(path: Seq[String]): Endpoint.Output[File] = static(new File(baseDirectory))(path)
}
