package part1basics

object StringOps_Interpolations_Max {

  val aString: String = "Hello, I am learning Scala"

  // string functions
  // tied to an instance of strings
  val secondChar = aString.charAt(1)
  val firstWord = aString.substring(0, 5)
  val words = aString.split(" " ) // Array("Hello,", "I", "am", "learning", "Scala")

  val startsWithHello = aString.startsWith("Hello") //true
  val allDates = aString.replace(' ', '-')
  val allUppercase = aString.toUpperCase() //also lowercase

  val nChars = aString.length //no parenthesis. access method.

  // common methods above
  // common sense in most languages and present in standard libs

  // other functions
  val reversed = aString.reverse
  val aBunchOfChars = aString.take(10)

  // parse to numeric
  val numberAsString = "2"
  val number: Int = numberAsString.toInt

  // interpolation
  // structures in scala called interpolator
  val name = "Alice"
  val age = 12
  val greeting: String = "Hello, I'm " + name + " and I am " + age + "years old."
  val greetingV2 = s"Hello, I'm $name and I'm $age years old"
  val greetingV3 = s"Hello, I'm $name and I will be turning ${age + 1} years old"

  // f-interpolation
  // format interpolator
  // can format the speed below
  // %2.5f 2.0, the last digit is the number of digits
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f burgers per minute"

  // raw interpolation
  val escapes = "This is a \n newline"


  def main(args: Array[String]): Unit = {
  println(myth)
  println(escapes)
  }
}
