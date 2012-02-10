package euler.level_02

object Problem_044 extends App {

  import math.sqrt

  // Test for pentagonal numbers: http://en.wikipedia.org/wiki/Pentagonal_number
  def isPentagonal(x: Long) = (sqrt(24 * x + 1) + 1) % 6 == 0

  lazy val N: Stream[Long] = 1 #:: N.map(_ + 1)
  lazy val P = N.map(n => n * (3 * n - 1) / 2)

  // P(2167) seems to cut it ;-)

  P.take(2167).foreach {
    j =>
      val diffs = P.takeWhile(k => k < j).filter(k => isPentagonal(j - k))
      val sums = P.takeWhile(k => k < j).filter(k => isPentagonal(j + k))
      if (!sums.intersect(diffs).isEmpty) println("intersect: " + j + " => " + sums.intersect(diffs).mkString(", "))
  }

  // 5482660
  println("7042750 - 1560090: " + isPentagonal(7042750 - 1560090))
  println("7042750 + 1560090: " + isPentagonal(7042750 + 1560090))
  println("7042750 - 1560090: " + (7042750 - 1560090))
}