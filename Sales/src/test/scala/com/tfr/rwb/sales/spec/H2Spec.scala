package com.tfr.rwb.sales.spec

import com.tfr.rwb.sales.model.ProductModel.ProductsRepository
import com.tfr.rwb.sales.model.SaleItemModel.SaleItemsRepository
import com.tfr.rwb.sales.model.SaleModel.SalesRepository
import org.scalatest._

import scala.concurrent.Await
import scala.concurrent.duration._
import scala.util.{Failure, Success, Try}
import slick.jdbc.H2Profile.api._

/**
  * Created by Erik on 8/21/2017.
  */
abstract class H2Spec(dbConfig: String) extends FlatSpec
  with BeforeAndAfterEach
  with Matchers {

  val db = Database.forConfig(dbConfig)
  val timeout = 5 seconds
  val products = new ProductsRepository(db)
  val saleItems = new SaleItemsRepository(db)
  val sales = new SalesRepository(db)

  override def beforeEach() {
    Try {
      Await.result(products.init(), timeout)
    } match {
      case Success(_) => println("products schema created")
      case Failure(ex) => println("failed to create products schema")
    }

    Try {
      Await.result(sales.init(), timeout)
    } match {
      case Success(_) => println("sales schema created")
      case Failure(ex) => println("failed to create sales schema")
    }

    Try {
      Await.result(saleItems.init(), timeout)
    } match {
      case Success(_) => println("saleItems schema created")
      case Failure(ex) => println("failed to create saleItems schema")
    }
  }

  override def afterEach() {
    Try {
      Await.result(products.drop(), timeout)
    } match {
      case Success(_) => println("products schema created")
      case Failure(ex) => println("failed to create products schema")
    }

    Try {
      Await.result(sales.drop(), timeout)
    } match {
      case Success(_) => println("sales schema dropped")
      case Failure(ex) => println("failed to drop sales schema" + ex)
    }

    Try {
      Await.result(saleItems.drop(), timeout)
    } match {
      case Success(_) => println("saleItems schema dropped")
      case Failure(ex) => println("failed to drop saleItems schema" + ex)
    }
  }

}
