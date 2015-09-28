package io.finch

import java.io.File
import java.nio.file.Files
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
}
