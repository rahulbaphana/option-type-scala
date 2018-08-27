package com.rahul.fp

sealed trait Choice[+A] {
  def map[B](f: A => B): Choice[B]
  def flatMap[B](f: A => Choice[B]): Choice[B]
  def getOrElse[B >: A](default: => B): B
  def orElse[B >: A](op: => Choice[B]): Choice[B]
  def filter(f: A => Boolean): Choice[A]
  def get: A
}

object None extends Choice[Nothing] {
  override def map[B](f: Nothing => B): Choice[B] = ???

  override def flatMap[B](f: Nothing => Choice[B]): Choice[B] = ???

  override def getOrElse[B >: Nothing](default: => B): B = ???

  override def orElse[B >: Nothing](op: => Choice[B]): Choice[B] = ???

  override def filter(f: Nothing => Boolean): Choice[A] = ???

  override def get = ???
}

case class Something[+A](element: A) extends Choice[A] {
  override def map[B](f: A => B): Choice[B] = ???

  override def flatMap[B](f: A => Choice[B]): Choice[B] = ???

  override def getOrElse[B >: A](default: => B): B = ???

  override def orElse[B >: A](op: => Choice[B]): Choice[B] = ???

  override def filter(f: A => Boolean): Choice[A] = ???

  override def get: A = ???
}