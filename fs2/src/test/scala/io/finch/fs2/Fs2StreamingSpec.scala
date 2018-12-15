package io.finch.fs2

import _root_.fs2.Stream
import cats.effect.IO
import io.finch._
import org.scalatest.prop.GeneratorDrivenPropertyChecks

class Fs2StreamingSpec extends FinchSpec with GeneratorDrivenPropertyChecks {

  checkAll("fs2.streamBody", StreamingLaws[Stream, IO](
    list => Stream(list:_*),
    _.compile.toList.unsafeRunSync()
  ).all)

}
