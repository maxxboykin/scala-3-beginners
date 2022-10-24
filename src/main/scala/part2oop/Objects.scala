package part2oop

object Objects {

  object MySingleton { // type + the only instance of this type
    val aField = 45
    def aMethod(x: Int) = x + 1
  }

  val theSingleton = MySingleton
  val anotherSingleton = MySingleton
  val isSameSingleton = theSingleton == anotherSingleton

  val theSingletonField = MySingleton.aField
  val theSingletonMethodCall = MySingleton.aMethod(99)


  class Person(name: String) {
    def sayHi(): String = s"Hi, my name is $name"
  }

  // companions = class + object with the same name in the same file
  // methods are not depended on a specific instance of Person
  object Person { // companion object
    val N_EYES = 2
    def canFly(): Boolean = false
  }

  // methods and fields in classes are used for instance-dependent functionality
  val mary = new Person("Mary")
  val maryV2 = new Person("Mary")
  val marysGreeting = mary.sayHi()
  mary == mary

  // methods and fields in objects are used for instance-independent functionality - "static" in other languages
  val humansCanFly = Person.canFly()
  val nEyesHuman = Person.N_EYES

  // equality of reference
  // 1 - equality of reference
  val sameMary = mary eq maryV2 // false since they are different class instances
  val sameSingleton = MySingleton eq MySingleton // true same in reference of memory
  // 2 equality of "sameness" in Java as defined as .equals
  val sameMary_v2 = mary equals maryV2 // false
  val sameMary_v3 = mary == maryV2 // same as equals; returns false
  val sameSingleton_V2 = MySingleton == MySingleton // true

  // objects can extend classes
  object BigFoot extends Person("Big Foot")

  // Scala application is an object with a singleton object and a main: def main(args: Array[String]): Unit
  // similar to Java
  // its identical to the java object main below. have an object with main in it 
  /*
  public class Objects {
    public static void main(String[] args) { ... }
  }
  */
  def main(args: Array[String]): Unit = {
    println(isSameSingleton)

  }
}
