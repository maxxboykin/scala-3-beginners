package part2oop

object OOBasics_Max {


  // classes
  class Person(val name: String, age: Int) {
    // constructor argument embedded in class declaration
    // fields
    val allCaps = name.toUpperCase()

    // methods
    def greet(name: String): String = {
      s"${this.name} says: Hi, $name"
    }
    // signature differs
    // called OVERLOADING same name
    def greet(): String = {
      s"Hi, everyone, my name is $name"
    }

    // aux constructor, not used often since its the same thing as having default constructors in the constructor
    // class
    // both combined is the same thing as having class Person(val name: String = "Jane Doe", age: Int = 0)
    def this(name: String) = {
      this(name, 0)
    }
    def this() = {
      this("Jane Doe")
    }
  } // end of Person class


  val aPerson: Person = new Person("Max", 28)
  val max = aPerson.name // class parameter != field; this only works if there is a val before name in the constructor
  val maxSaysHiToDaniel: String = aPerson.greet("Daniel")

  val genericPerson = new Person()



  def main(args: Array[String]): Unit = {
    println(maxSaysHiToDaniel)
    println(genericPerson)

    val charlesDickens = new Writer("Charles", "Dickens", 1812)
    println(charlesDickens.fullname())
    val novel = new Novel("Great Expectations", 1861, charlesDickens)
    val updatedNovel = novel.copy(2022)
    val originalCount = new Counter(10)
    val countIncremented = originalCount.increment()
    val countDecremented = originalCount.decrement()
    println(updatedNovel.authorAge)
    println("countIncremented " + countIncremented.print())
    println("CountDecremented " + countDecremented.print())

    val counter = new Counter()
    counter.print() // 0
    counter.increment().print() // 1
    counter.increment()  // always returns new instance and doesnt change original instances
    counter.print() // 9
  }
}


class Writer(first: String, surName: String, val yearOfBirth: Int) {

  def fullname(): String = {
    s"$first $surName" // also works
   // first + " " + surName also works
  }
}

class Novel(name: String, yearOfRelease: Int, author: Writer) {
  def authorAge: Int = yearOfRelease - author.yearOfBirth // need to make yearofbirth a val in constructor so it becomes a field of the class
  def isWrittenBy: Boolean = this.author == author
  def copy(newYearOfRelease: Int): Novel = new Novel(this.name, newYearOfRelease, author)
}

/**
Exercise 2: an immutable counter class
* constructed with an initial count
* have methods to increment and decrement
* the increment and decrement will return a NEW instance of counter
* only using vals which are constants
* a lot of benefits
 * * - increment(n)/decrement(n) => NEW instance of counter
 * print()
*/


// benefits of immutable data
// well in distributed environments
// easier to read and understand code
class Counter(count: Int = 0) {
  def increment(): Counter = new Counter(count + 1)
  def decrement(): Counter = {
    if(count == 0) this
    else new Counter(count - 1)
  }
  // overloaded method
  def increment(n: Int): Counter = {
    if (n<= 0) this
   // new Counter(count + n)
    increment().increment(n - 1) // same thing as above but sometimes calling a previous method if it has other
    // print statements and make it more modular
    // can make counter vulnerable to stack overflow errors since it calls increment each time so 20000 increment
    // will call increment 20000  times and overload! so in this case just call new Counter(count +n) 
  }

  def decrement(n: Int): Counter = {
    if (n <= 0) this
    else decrement().decrement(n-1)
  }

  def print(): Unit = println(s"Current Count: $count")
}

