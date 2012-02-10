package euler.level_02

object Problem_045 extends App {
  import math._

  lazy val N: Stream[Long] = 1 #:: N.map(_ + 1)
  lazy val H = N.map(n => n * (2 * n - 1))

  // NOTE: triangular numbers is a subset of hexagonal numbers.
  // Test for pentagonal numbers: http://en.wikipedia.org/wiki/Pentagonal_number
  def isPentagonal(x: Long) = (sqrt(24 * x + 1) + 1) % 6 == 0

  assert(1533776805 == H.drop(143).find(isPentagonal).get)
}