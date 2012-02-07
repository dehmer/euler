
/**
 * By considering the terms in the Fibonacci sequence whose values do not exceed four million,
 * find the sum of the even-valued terms.
 */
object Problem_002 extends App {
  import Predef.timed

  val fibs: Stream[Int] = 0 #:: 1 #:: fibs.zip(fibs.tail).map { case(a, b) => a + b }

  val duration = timed {
    def even(x: Int) = x % 2 == 0
    assert(4613732 == fibs.takeWhile(_ < 4000000).filter(even).reduce(_ + _))
  }

  println("duration: " + duration + " ms.")
}