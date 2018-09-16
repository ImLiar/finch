package io.finch.circe.test

import com.twitter.util.Try
import io.catbird.util._
import io.circe.generic.auto._
import io.finch.test.AbstractJsonSpec

class CirceSpec extends AbstractJsonSpec {
  import io.finch.circe._
  checkJson("circe")
  checkEnumerateJson[Try]("circe")
}

class CirceAccumulatingSpec extends AbstractJsonSpec {
  import io.finch.circe.accumulating._
  checkJson("circe-accumulating")
  checkEnumerateJson[Try]("circe-accumulating")
}

class CirceDropNullKeysSpec extends AbstractJsonSpec {
  import io.finch.circe.dropNullValues._
  checkJson("circe-dropNullKeys")
}

class CircePredictSizeSpec extends AbstractJsonSpec {
  import io.finch.circe.predictSize._
  checkJson("circe-predictSize")
}
