package controllers

import models.DataModel
import org.scalatest.mockito.MockitoSugar
import org.scalatestplus.play.guice.GuiceOneAppPerTest
import play.api.mvc.ControllerComponents
import uk.gov.hmrc.play.test.UnitSpec
import play.api.test.FakeRequest
import play.api.http.Status
import repositories.DataRepository
import org.mockito.ArgumentMatchers._
import org.mockito.Mockito._
import play.api.test.Helpers.GET

import scala.concurrent.{ExecutionContext, Future}


class ApplicationControllerSpec extends UnitSpec with GuiceOneAppPerTest with MockitoSugar{
  lazy val controllerComponents: ControllerComponents = app.injector.instanceOf[ControllerComponents]

  implicit lazy val executionContext: ExecutionContext = app.injector.instanceOf[ExecutionContext]
  val mockDataRepository: DataRepository = mock[DataRepository]

  object TestApplicationController extends ApplicationController(
    controllerComponents, mockDataRepository, executionContext
  )

  val dataModel: DataModel = DataModel(
    "abcd",
    "test name",
    "test description",
    100
  )

    "ApplicationController .index" should {





      "return TODO" in {
        when(mockDataRepository.find(any())(any()))
          .thenReturn(Future(List(dataModel)))

        lazy val result = TestApplicationController.index()(FakeRequest())

        status(result) shouldBe Status.OK
      }
    }



  "ApplicationController .create()" should {

  }
  "ApplicationController .read()" should {

  }
  "ApplicationController .update()" should {

  }
  "ApplicationController .delete()" should {

  }


}
