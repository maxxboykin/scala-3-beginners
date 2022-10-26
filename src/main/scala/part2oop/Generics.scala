package part2oop

object Generics {
  // NOTE TO MAX: I stopped at 18:30 in the video and didnt do the exercise so i can continue and get to case classes
  // reuse code on different types

  abstract class MyList[A] { // "generic" list
    def head: A
    def tail: MyList[A]
  }

  class Empty[A] extends MyList[A] {
    override def head: A = throw new NoSuchElementException
    override def tail: MyList[A] = throw new NoSuchElementException
  }

  class NonEmpty[A](override val head: A, override val tail: MyList[A]) extends MyList[A] {
  }

  val listOfIntegers: MyList[Int] = new NonEmpty[Int](1, new NonEmpty[Int](2, new Empty[Int]))
  val listOfStrings: MyList[String] = new NonEmpty[String]("Scala", new NonEmpty[String("Java", new Empty[String]))

  val firstNumber: Int = listOfIntegers.head
  val adding = firstNumber + 3

  // multiple generic types K stands for key and V stands for value
  trait MyMap[K, V]

  // generic methods
  object MyList {
    def from2Elements[A](elem: A, elem2: A): MyList[A] = {
      new NonEmpty[A](elem1, new NonEmpty[A](elem2, new Empty[A]))
    }
  }

  // calling methods
  val first2Numbers = MyList.from2Elements[Int](1, 2)
  val first2Numbers_v2 = MyList.from2Elements(1, 2)
  val first2Numbers_v3 = new NonEmpty(1, new NonEmpty(2, new Empty))


  def main(args: Array[String]): Unit = {

  }


}
