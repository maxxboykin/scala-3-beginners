package practice

import scala.annotation.tailrec

// singly linked lists
// [1, 2, 3] = [1] -> [2] -> [3]
abstract class LinkedList {
  def head: Int
  def tail: LinkedList
  def isEmpty: Boolean
  def add(element: Int): LinkedList = new Cons(element, this)
  // def add(element: Int): LinkedList (this is what we originally had but changed to above since both
  // Empty and Cons had the same implementation override of add

  override def toString = super.toString
}

class Empty extends LinkedList {
  override def head: Int = throw new NoSuchElementException
  override def tail = throw new NoSuchElementException
  override def isEmpty: Boolean = true
  //  override def add(element: Int): LinkedList = new Cons(element, this)
  override def toString: String = "[]"
}

//Cons is non empty list, short for constructor
class Cons(override val head: Int, override val tail: LinkedList) extends LinkedList {
  override def isEmpty: Boolean = false

  //  override def add(element: Int): LinkedList = new Cons(element, this)
  override def toString: String = {
    @tailrec
    def concatenateElements(remainder: LinkedList, acc: String): String = {
      if (remainder.isEmpty) acc
      else concatenateElements(remainder.tail, s"$acc ${remainder.head}")
    }

    s"[${concatenateElements(this.tail, s"$head")}]"
  }
}

//class Node {
//  val value: Int
//  val next: Node
//}

object LinkedListTest {
  def main(args: Array[String]): Unit = {
    val empty = new Empty
    println(empty)
    println(empty.isEmpty)

    val first3Numbers = new Cons(1, new Cons(2, new Cons(3, empty)))
    val first3Numbers_v2 = empty.add(1).add(2)
    println(first3Numbers)
    println(first3Numbers_v2)
  }
}
