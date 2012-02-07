import annotation.tailrec

/**
 * What is the 10,001st prime number?
 */
object Problem_007 extends App {
  import Predef.{timed, primes}
  val duration = timed(assert(104743 == (primes.take(10001).last)))
  println("duration: " + duration + " ms.")
}