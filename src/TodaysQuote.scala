import java.io.File

import scala.io.Source
import scala.util.Random

object TodaysQuote extends App {

  private val rawResult = Source.fromFile(new File("/Users/leenabora/quotes.txt")).getLines.toList

  val quotes = parseQuotes(rawResult, List.empty)

  println(s"Today's quote \n ${Random.shuffle(quotes).head}")

  def parseQuotes(rawResult: List[String], parsedResult: List[String]): List[String] = {
    rawResult match {
      case Nil => parsedResult
      case _ => val list = rawResult.takeWhile(_.trim.nonEmpty)
        parseQuotes(rawResult.dropWhile(_.trim.nonEmpty).dropWhile(_.trim.isEmpty), parsedResult :+ (list.mkString("\n")))
    }
  }
}

