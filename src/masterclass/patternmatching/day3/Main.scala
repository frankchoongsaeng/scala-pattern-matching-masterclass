package masterclass.patternmatching.day3

import scala.math._



object Main {
  // reference patterns
//  val e = 2.718
//  E match {
//    case e => println(e)
//    case E => println(E)
//  }
//
//  case class Foo(name: String)
//  val F = Foo("Ebuka")
//  Foo("Frank") match {
//    case F => println("f")
//    case Foo("Frank") => println("frank")
//  }


  // pattern guards
  "B" match {
    case char if char.length == 1 => println("just a single character")
    case hasSpaces if hasSpaces.contains(' ') => println("multi word string")
    case _ => println("regular one word string")
  }

  /**
   * case class Foo()
   * // for free
   * object Foo {
   *   def apply(): Foo
   *   def unapply: Option[()]
   * }
   */

  // sealed traits & exhaustiveness
  sealed trait Color
  case class Green() extends Color
  case object Red extends Color
  case object Blue extends Color


  trait Box
  case object B extends Box with Color

  val color: Color = Green()
  color match {
    case Red => ???
    case Blue => ???
    case B => ???
  }


  def main(args: Array[String]): Unit = {
//    println(E)
  }

}
