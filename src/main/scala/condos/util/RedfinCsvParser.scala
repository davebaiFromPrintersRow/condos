package condos.util

import java.nio.charset.CodingErrorAction

import scala.collection.mutable.ListBuffer
import scala.io.{Codec, Source}

object RedfinCsvParser extends App {
  val csvFile = "src/main/resources/housingstats.csv"
  implicit val codec = Codec("UTF-8")
  codec.onMalformedInput(CodingErrorAction.REPLACE)
  codec.onUnmappableCharacter(CodingErrorAction.REPLACE)

  val bufferedLines = Source.fromFile(csvFile)
  private val lines = bufferedLines.getLines().toArray

  val region = "Region"
  val monthOfPeriodEnd = "Month of Period End"
  val medianSalePrice = "Median Sale Price"
  val medianSalePriceMoM = "Median Sale Price MoM"
  val medianSalePriceYoy = "Median Sale Price YoY"
  val homesSold = "Homes Sold"
  val homesSoldMom = "Homes Sold MoM"
  val homesSoldYoY = "Homes Sold YoY"
  val newListings = "New Listings"
  val newListingsMom = "New Listings MoM"
  val newListingsYoY = "New Listings YoY"
  val inventory = "Inventory"
  val inventoryMoM = "Inventory MoM"
  val inventoryYoY = "Inventory YoY"
  val daysOnMarket = "Days on Market"
  val daysOnMarketMoM = "Days on Market MoM"
  val daysOnMarketYoY = "Days on Market YoY"
  val avgSaleToList = "Average Sale To List"
  val avgSaleToListMoM = "Average Sale To List MoM"
  val avgSaleToListYoY = "Average Sale To List YoY"

  var filteredLines = new ListBuffer[String]()
  for (line <- lines) {
    val filteredLine = line.filter(char => (char >= 32 && char <= 127) || char == 10 || char == 9)
    filteredLines += filteredLine
  }

  filteredLines.foreach(println)
  bufferedLines.close
}
