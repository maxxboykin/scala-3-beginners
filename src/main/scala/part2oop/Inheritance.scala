package part2oop

object Inheritance {

  class Animal {
    val creatureType = "wild"
    def eat(): Unit = println("nononom")
  }

  class Cat extends Animal { // conceptually saying a cat is an animal
    def crunch(): Unit = {
      eat()
      println("crunch, crunch")
    }
  }

  val cat = new Cat

  class Person(val name: String, age: Int) {
    // aux constructor
    // using secondary constructors are not that useful
    // in terms of inheritence since you have to specify what constructor you are referring too if you are extending
    // the Person class --- see below with Adult, compilation error if you just write "extends Person", needs to be
    // calling a specific constructor since there are two options here: primary and auxilary
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name) { // must specify super-constructor
  }

  // overriding
  class Dog extends Animal {
    override val creatureType = "domestic"
    override def eat(): Unit = println("mmm, I like this bone")

    // popular overridable method
    override def toString: String = "a dog"
  }

  val dog = new Dog

  // subtype polymorphism
  // created variables of a declared type and instantiate a subtype of the declared type
  val newDog: Animal = new Dog

  // orverloading vs overriding
  class Crocodile extends Animal {
    override val creatureType = "very wild"
    override def eat(): Unit = println("I can eat anything, I'm a croc.")

    // overloading: multiple methods with the same name, different signatures
    // different signature = different argument list + different return type (optional)
    def eat(animal: Animal): Unit = println("I'm eating this poor fella") // this is overloading

    def eat(dog: Dog): Unit = println("eating a dog") // valid overload since its different argument
    def eat(person: Person): Unit = println("I'm eating a human with the name ${person.name}") // valid overload
    def eat(person: Person, dog: Dog): Unit = println("I'm eating a human AND the dog") // valid overload, arg list is different
    // def eat(): Int = 45 // not a valid overload even though it returns something different, already has no arguments eat method
    def eat(dog: Dog, person: Person): Unit = println("I'm eating a human AND the dog") // not a valid overload since we already have a dog and person arg list

    /*
      def eat(): Int = 45 // not a valid overload even though it returns something different, already has no arguments eat method
      def eat(dog: Dog, person: Person): Unit = println("I'm eating a human AND the dog") // not a valid overload since we already have a dog and person arg list
      // got above one wrong!! it is an overload since its in a unique order
    */


  }

  def main(args: Array[String]): Unit = {
    cat.eat()
    cat.crunch()
    dog.eat()
    println(dog) // really runs the toString of the class, if none mentioned it will be an address

    // testing subtype polymorphism
    newDog.eat() // it uses the dog method since it ocerrides animal, the most specific method is called at runtime
  }

}
