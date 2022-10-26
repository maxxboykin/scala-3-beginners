package part2oop

object AnonymousClasses {

  abstract class Animal {
    def eat(): Unit
  }

  // classes used for just one instance are just boilerplate so its good to make it via anonymously
  class SomeAnimal extends Animal {
    override def eat(): Unit = println("I'm a weird animal")
  }

  val someAnimal = new SomeAnimal
  val someAnimal_v2 = new Animal { // useful to use ananonymous class if you only need one instance of a class
    override def eat(): Unit = println("Im a weird animal.")
  }
  /*
  class AnonymousClasses.AnonClass$1 extends Animal {
    override def eat(): Unit = println("Im a weird animal")
  }

  val someAnimal_v2 = new AnonymousClasses.AnonClass$1
  */

  // works for classses (abstract or not) + traits
  class Person(name: String) {
    def sayHi(): Unit = println(s"Hi, my name is $name")
  }

  val jim = new Person("Jim") {

  }

  def main(args: Array[String]): Unit = {

  }


}
