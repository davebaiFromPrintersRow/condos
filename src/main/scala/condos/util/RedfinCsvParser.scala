package condos.util

import java.nio.charset.CodingErrorAction

import scala.io.{Codec, Source}

object RedfinCsvParser extends App {
  val csvFile = "src/main/resources/housingstats.csv"
  implicit val codec = Codec("UTF-8")
  codec.onMalformedInput(CodingErrorAction.REPLACE)
  codec.onUnmappableCharacter(CodingErrorAction.REPLACE)

  for (line <- Source.fromFile(csvFile).getLines()) {
    println(line)
  }
}
