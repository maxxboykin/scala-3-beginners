package part2oop

object CaseClasses {

  // create case classes as lightweight data structures
  // send them over the wire
  // for large pieces of classes - should not make it a case class
  // case classes are used to hold data, be stored and be compared
  case class Person(name: String, age: Int) { //granted it with a bunch of properties instantly by using case!!
    // do some other stuff that you would do if you have another class
    // cant have a case class with no constructor args
  }

  // 1 class arguments are now automatically converted to fields - (like putting "val" in front of name above in def)
  val daniel = new Person("Daniel", 99)
  val danielsAge = daniel.age

  // 2 - toString, equals (from JVM method) and hashcode are automatically included see main. can add hash map
  // hashcode comes with each and every case class
  val danielDuped = new Person("Daniel", 99)
  val isSameDaniel = daniel equals danielDuped

  // 3 - utility methods
  val danielYounger = daniel.copy(age = 78) // create a new instance of the case class so new Person
  // new Person with daniel

  // 4 automatically have companion objects when you have a case class
  val thePersonSingleton = Person
  val daniel_v2 = Person.apply("Daniel", 99)
  val daniel_v3 = Person("Daniel", 99) // "constructor" same thing as above - using apply method

  // 5 - case classes are serializable - can turn an instance of Person in this case to bytes that some other computer, or JVM can understand
  // can send them over the wire
  // akka actor framework

  // 6 case classes have extractor patterns for PATTERN MATCHING
  // NOTE That you cant have a case class with no arguments
  //
  //    case class CCWithNoArgs { // cannot work with case class with no argument list
  //      // some code
  //    }
  //
  //    val ccna = new CCWithNoArgs // these two are the same since CCWITHNOARGS has no arguments so its just one variation
  //    val ccna_v2 = new CCWithNoArgs
  //

  case object UnitedKingdom { // does not take any constructor arguments
    // single instance (hence object)
    // 2 toString, equals and hashcode and the part with serializability

    // fields and methods
    def name: String = "The UK of G8 and Northern Ireland"
  }


  case class CCWithArgListNoArgs[A](){ // legal mainly used in the context of generics
  val ccna = new CCWithArgListNoArgs()
  val ccna_v2 = new CCWithArgListNoArgs()
}

  def main(args: Array[String]): Unit = {
    println(daniel) // prints Person(Daniel, 99); it would print out com.rockthejvm.part2oop.CaseClasses$Person@5c0369c4 if it was just
    // class Person and not case class
    println(isSameDaniel) // this would be false if it wasnt a case class since == would look at reference operator and both
    // will have different references
  }
}
