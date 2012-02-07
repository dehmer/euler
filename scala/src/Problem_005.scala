
/**
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
object Problem_005 extends App {
  import Predef.timed

  val duration = timed {
    lazy val divisors = List[Long](11, 12, 13, 14, 15, 16, 17, 18, 19, 20)

    // NOTE: using Int instead of Long as parameter type introduces major overhead.
    def dividable(n: Long) = divisors.forall(n % _ == 0)
    def result = Stream.from(20, 20).dropWhile(n => !dividable(n)).head
    assert(232792560 == result)
  }

  println("duration: " + duration + " ms")
}