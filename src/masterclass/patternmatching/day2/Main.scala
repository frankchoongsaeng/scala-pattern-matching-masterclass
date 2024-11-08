package masterclass.patternmatching.day2

object Main {

  def main(args: Array[String]): Unit = {

    val code: Int = 0

    // Constant Patterns
    code match {
      case 0 => println("zero")
      case 1 => println("one")
      case 2 => println("two")
      case _ => println(s"unexpected value $code")
    }

    // Type test
    // 1. Do not pattern match on generic types
    // 2. This problem may not exist in Scala 3
    val res: Any = List(0)
    res match {
      case _: String => println("I got a string")
      case _: Int => println("I got an int")
      case _: List[_] => println("I got a list of strings")
      case _: List[Int] => println("I got a list of integers") // this branch will never be reached
    }

    // Alternate Patterns
    val num: Int = 0
    num match {
      case 1 => println("st")
      case 2 => println("nd")
      case 3 => println("rd")
      case 0 | 4 | 5 | 6 | 7 | 8 | 9 => println("th")
    }

    // variable pattern
    // got a list like List("-t", "1")
    val res2: Any = List(0)
    res2 match {
      case str: String => println(s"I got a string: $str")
      case _: Int => println("I got an int")
      case lst @ List("-c", code) => println(s"found tuple-like list: $lst, with second value as: $code")
      case _: List[String] => println("I got a list of strings")
    }

    // case classes & classes
    case class Foo(name: String)
    val f = Foo("Ebuka")
    f match {
      case Foo("Ebuka") => ???
      case Foo(_) => ???
    }


    // list patterns
    val lst = List(0, 1, 2)
    lst match {
      case List(_) => ???
      case List(1, _) => ???
      case 0 :: _ => ???
      case _ :: 1 :: rest => ???
      case List(_, 1, _*) => ???
      case _ => ???
    }


  }

}
