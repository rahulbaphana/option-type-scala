package com.rahul.fp

import org.scalatest.{Matchers, WordSpec}

class ChoiceTest extends WordSpec with Matchers {

  "Choice" can {
    "map" should {
      "Choice(Int) to Something(String)" in {
        Choice(10).map(e => s"You entered value : $e") shouldBe Something("You entered value : 10")
      }

      "None to None" in {
        None.map(e => s"${e}") shouldBe None
      }

      "Choice(null) to None" in {
        Choice(null).map(e => s"${e}") shouldBe None
      }
    }

    "flatMap" should {
      "Choice(Int) to Something(String)" in {
        Choice(10).flatMap(e => Something(s"You entered value : $e")) shouldBe Something("You entered value : 10")
      }

      "None to None" in {
        None.flatMap(e => Something(e)) shouldBe None
      }

      "Choice(null) to None" in {
        Choice(null).flatMap(e => Something(e)) shouldBe None
      }
    }


    "getOrElse" should {
      "Choice(element: String) to element" in {
        Choice("Hello World!").getOrElse("No World!") shouldBe "Hello World!"
      }

      "Choice(null) to default value" in {
        Choice(null).getOrElse("No World!") shouldBe "No World!"
      }

      "Choice(None) to None" in {
        Choice(None).getOrElse("No Value") shouldBe None
      }
    }

    "orElse" should {
      "Choice(element: String) to Something(element)" in {
        Choice("Hello World!").orElse(Something("No World!")) shouldBe Something("Hello World!")
      }

      "Choice(null) to default Something(default_value)" in {
        Choice(null).orElse(Something("No World!")) shouldBe Something("No World!")
      }

      "Choice(None) to Something(None)" in {
        Choice(None).orElse(Something("No World!")) shouldBe Something(None)
      }
    }

    "filter" should {
      "return the output with string when condition is met" in {
        Choice("Hello World!").filter(e => e.contains("Hello")).map(e => s"Welcome to $e") shouldBe Something("Welcome to Hello World!")
      }

      "return None when condition is met" in {
        Choice("Hello World!").filter(e => e.contains("zzzz")).map(e => s"Welcome to $e") shouldBe None
      }

      "Choice(null) to None" in {
        Choice(null).filter(_ => true) shouldBe None
      }

      "Choice(None) to None" in {
        Choice(None).filter(_ => true) shouldBe Something(None)
      }
    }

    "get" should {
      "return the element" in {
        Choice("Hello World!").get shouldBe "Hello World!"
      }

      "throw exception when None.get" in {
        val exception = intercept[Exception] {
          None.get
        }
        exception.getMessage shouldBe "Getting something non-existent: None.get"
      }
    }
  }
}
