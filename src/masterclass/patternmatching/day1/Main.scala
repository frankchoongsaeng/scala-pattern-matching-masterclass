package masterclass.patternmatching.day1

object Main {

  case class Person(name: String, spokenLanguage: String)


  def greetPerson(person: Person) = person match {
    case Person(_, "French") => println("Bonjour...")
    case Person(_, "English") => println("Good morning...")
    case p => println("Cannot greet, in persons language")
    case _ => println("Default")
  }




  val label: String = "Fragile"

// scala.MatchError
  def handleItems(itemLabel: String) =
    itemLabel match {
      case "Fragile" => println("handling fragile item")
      case "Flammable" => println("handling flammable item")
      case "Heavy" => println("handling heavy item")
      case _ => println("did not match known patterns")
    }

  def initCodes(code: Int) = code match {
    case 0 => println("restarting program...")
  }

  def process(arg: Any): Unit = {
    arg match {
      case str: String if str.length > 1  => handleItems(str)
      case int: Int => initCodes(int)
      case _ => sys.error("Unknown argument: " + arg)
    }
  }




  // Pattern matching is matching a value against a PATTERN.
  def main(args: Array[String]): Unit = {
    val mike = Person("mike", "French")
    greetPerson(mike)
  }
}
