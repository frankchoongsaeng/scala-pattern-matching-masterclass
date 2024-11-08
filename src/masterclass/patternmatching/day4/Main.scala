package masterclass.patternmatching.day4

import scala.math._


object Main extends App {
  val e = 2.718

  // Stable Identifier Pattern
  // 1. ref to property of object
  case object Foo {
    val bar = "bar"
  }

  "bar" match {
    case Foo.bar => println("hit bar as catch all")
    case _ => println("default case")
  }

  // 2. Identifiers starting with uppercase
  2.7183 match {
    case E => println(E)
    // 3. Identifiers wrapped in a backtick
    case `e` => println("hit for e")
    case _ => println("default case")
  }


  // Unapply Pattern
  // compiler generates, companion object, apply and unapply methods
  case class Person(name: String)
  val person = Person("Ebuka")
  person match {
    case Person(_) => println("matched a person")
  }

  class SimplePerson(val name: String)
  object SimplePerson {
    def apply(str: String): SimplePerson = new SimplePerson(str)
    def unapply(simplePerson: SimplePerson): Option[String] = Some(simplePerson.name)
  }
  val simplePerson = SimplePerson("Ebuka")
  simplePerson match {
    case SimplePerson(_) => println("matched on simple person")
  }


  // Extractor Objects
  object SimplePersonExtractor {
    def unapply(arg: SimplePerson): Option[String] = Some(arg.name)
  }
  simplePerson match {
    case SimplePerson("Frank") => println("matched simple person 1")
    case SimplePersonExtractor("Ebuka") => println("matched simple person extractor")
  }

  // using object instances to Unapply
  class SimplePersonExtractorFactory {
    def unapply(arg: SimplePerson): Option[String] = Some(arg.name)
  }
  val simplePersonExtractorFactory = new SimplePersonExtractorFactory
  simplePerson match {
    case SimplePerson("Frank") => println("matched simple person 2")
    case simplePersonExtractorFactory("Ebuka") => println("matched simple person extractor factory")
  }

  val SimplePersonExtractor(name1) = simplePerson
  val simplePersonExtractorFactory(name2) = simplePerson

  val lst = List(1, 2, 3)
  val _ :: secondItem :: _ = lst

  // Partial Functions
  val nameLength: PartialFunction[SimplePerson, Int] = {
    case SimplePerson("") => 0
    case SimplePerson(name) => name.length
  }

  println(nameLength(simplePerson))

  sealed trait Hobby
  case object Football extends Hobby
  case object Hockey extends Hobby
  case class Employee(empId: Int, firstName: String, hobbies: List[Hobby])

  def hockeySelection: PartialFunction[Employee, Boolean] = {
    case Employee(_, _, Hockey :: _) => true
    case _ => false
  }

  def soccerSelection: PartialFunction[Employee, Boolean] = {
    case Employee(_, _, Football :: _) => true
  }

  val soccerOrHockeySelection = soccerSelection.orElse(hockeySelection)

  def addToTeam(employee: Employee, selectionCriteria: PartialFunction[Employee, Boolean]): Boolean =
  selectionCriteria(employee)

  val employee = Employee(0, "Ebuka", List(Football))
  println(s"can we add Ebuka to team: ${addToTeam(employee, soccerSelection)}")


}



