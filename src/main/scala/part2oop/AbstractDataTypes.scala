package part2oop

object AbstractDataTypes {

  abstract class Animal {
    // abstract (no implementation)
    val creatureType: String
    def eat(): Unit
    // non-abstract fields/methods allowed (can also have that in abstract classes)
    def preferredMeal: String = "anything" // accessor methods
  }

 // val anAnimal: Animal = new Animal // cannot do since you cant create an
  // instance of an abstract class, you can do Dog like below since it extends Animal and has
  // concrete values

  class Dog extends Animal { // creatureType and eat is required since its extending an abstract class
    override val creatureType: String = "domestic"
    override def eat(): Unit = println("crunching this bone")
    // overriding is legal for everything
    override val preferredMeal: String = "bones" // overriding accessor
    // method (without args/parenthesis) with a field
  }

  val aDog: Animal = new Dog

  // traits
  // datatype that describes a behavior
  trait Carnivore { // Scala 3 - traits can have a constructor args
    def eat(animal: Animal): Unit
  }

  class TRex extends Carnivore {
    override def eat(animal: Animal): Unit = println("I'm a TRex and I eat animals")
  }

  // practical difference between abstract classes and traits
  // a class can only extend one other abstract class
  // but a class can extend multiple traits

  trait ColdBlooded
  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType = "croc"
    override def eat(): Unit = println("Im a croc, I just crunch stuff")
    override def eat(animal: Animal): Unit = println("croc eating animal")
  }// can chain as many traits as possible

  /* philosophical difference abstract classes vs traits
  - abstract classes are things
  - traits are behaviors
  */

  /* TYPE HIERARCHY IN SCALA
  Any
    AnyRef
      All classes we write extend AnyRef (to compiler)
        scala.Null (the null reference)
    AnyVal
      Int, Boolean, Char, ... (primitive data types)

        scala.Nothing (proper replacement for any type) - no possible instances really
  */
  val aNonExistentAnimal: Animal = null
  val anInt: Int = throw new NullPointerException // really returns scala.Nothing

  class MyThing // extends AnyRef implied

  val newCroc = new Crocodile
  def main(args: Array[String]): Unit = {
    println(newCroc.preferredMeal)
  }
}
