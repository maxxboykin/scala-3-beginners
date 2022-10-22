package part1basics

import scala.annotation.tailrec

object DefaultArgs_Max {
    @tailrec
    def sumUntilTailRec(x: Int, accumulator: Int = 0): Int = {
      if (x <= 0) accumulator
      else sumUntilTailRec(x - 1, accumulator + x)
      // no further stack frames necessary
    }

    val sumUntil100 = sumUntilTailRec(100) // additional arg passed automatically

    // when you use a function most of the time with the same value = default arguments
    def savePicture(dirPath: String, name: String, format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = {
      println("Saving picture in format " + format + " in path " + dirPath)
    }


    def main(args: Array[String]): Unit = {
      // default args are automatically injected
      savePicture("/users/daniel/photos", "myphoto")
      //pass explicit different values for default args
      savePicture("/users/daniel/photos", "myphoto", "png")
      // pass values after default argument
      savePicture("/users/daniel/photos", "myphoto", width = 800, height = 600)
    }
}
