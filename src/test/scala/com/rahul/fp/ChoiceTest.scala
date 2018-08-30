package com.rahul.fp

import org.scalatest.{Matchers, WordSpec}

class ChoiceTest extends WordSpec with Matchers {

  "Choice" can {
    "map" should {
      "Something(Int) to Something(String)" in {
        Something(10).map(e => s"You entered value : $e") shouldBe Something("You entered value : 10")
      }

      "None to None" in {
        None.map(_ => "Hello") shouldBe "Hello"
      }

      "Something(null) to None" in {
        Something(null).map(_ => "Hello") shouldBe Something("Hello")
      }
    }

    "flatMap" should {
      "Something(Int) to Something(String)" in {
        Something(10).flatMap(e => Something(s"You entered value : $e")) shouldBe Something("You entered value : 10")
      }

      "None to None" in {
        None.flatMap(_ => Something("Hello")) shouldBe Something("Hello")
      }

      "Something(null) to None" in {
        Something(null).flatMap(_ => Something("Hello")) shouldBe Something("Hello")
      }
    }


    "getOrElse" should {
      "Something(element: String) to element" in {
        Something("Hello World!").getOrElse("No World!") shouldBe "Hello World!"
      }

      "Something(null) to default value" in {
        Something(null).getOrElse("No World!") shouldBe "No World!"
      }

      "Something(None) to None" in {
        Something(None).flatMap(_ => Something("Hello")) shouldBe None
      }
    }

    "orElse" should {
      "Something(element: String) to Something(element)" in {
        Something("Hello World!").orElse(Something("No World!")) shouldBe Something("Hello World!")
      }

      "Something(null) to default Something(default_value)" in {
        Something(null).orElse(Something("No World!")) shouldBe Something("No World!")
      }

      "Something(None) to Something(default_value)" in {
        Something(None).orElse(Something("No World!")) shouldBe Something("No World!")
      }
    }

    "filter" should {
      "return the output with string when condition is met" in {
        Something("Hello World!").filter(e => e.contains("Hello")).map(e => s"Welcome to $e") shouldBe Something("Welcome to Hello World!")
      }

      "return None when condition is met" in {
        Something("Hello World!").filter(e => e.contains("zzzz")).map(e => s"Welcome to $e") shouldBe None
      }

      "Something(null) to None" in {
        Something(null).filter(_ => true) shouldBe Something(null)
      }

      "Something(None) to None" in {
        Something(None).filter(_ => true) shouldBe Something(None)
      }
    }

    "get" should {
      "return the element" in {
        Something("Hello World!").get shouldBe "Hello World!"
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
