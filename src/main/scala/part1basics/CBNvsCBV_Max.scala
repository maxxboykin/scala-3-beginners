package part1basics

object CBNvsCBV_Max {

  // CBV is call by value invoking a function with arguments
  // arguments are evaluated before function invocation
  def aFunction(arg: Int): Int = arg + 1 // evaulated right away
  val aComputation = aFunction(23 + 67)

  def aByNameFunction(arg: => Int): Int = arg + 1 //arg is only evaluated when the function is called CBN
  val anotherComputation = aByNameFunction(23 + 67)

  def printTwiceByValue(x: Long): Unit = {
    println("By value: " + x)
    println("By value: " + x)
  }

  // delayed evaluation of the argument
  // argument is evaluated every time it is used
  def printTwiceByName(x: => Long): Unit = {
    println("By name: " + x)
    println("By name: " + x)
  }

  def inifinite(): Int = 1 + inifinite()
  def printFirst(x: Int, y: => Int) = println(x)


  def main(args: Array[String]): Unit = {
    println(aComputation)
    println(anotherComputation)
    println(printTwiceByValue(System.nanoTime()))
    println(printTwiceByName(System.nanoTime())) //passed when the function is called

    //because the second argument is passed by name
    // CBN which are dangerous can be delayed until they are needed
    // since it prints out x right away, CBV, is prints out x and doesnt need the expressed value
    // if both are passed by value, then both will hit before returning and it would be an infinite loop
    // call by value is computed before the call and the same value used everywhere
    // call by name is expresion is passed literally and is evaluated at every use within

    printFirst(42, inifinite())
    // does not execute as max call stack is hit since infinite is executed right away
    //
    // printFirst(inifinite(), 42)

  }
}
