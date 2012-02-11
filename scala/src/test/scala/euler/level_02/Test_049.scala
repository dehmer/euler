package euler.level_02

import euler.Primes
import org.junit.Assert._
import org.junit.Test

final class Test_049 {

  def digits(i: Long): Set[Long] = {
    def digits(i: Long, acc: Set[Long]): Set[Long] = if (i >= 10) digits(i / 10, acc + (i % 10)) else acc + i
    digits(i, Set[Long]())
  }

  def sameDigits(a: Long, b: Long) = digits(a) == digits(b)

  val xs = Primes.dropWhile(_ < 1000).takeWhile(_ < 10000).toArray

  val tuples = for {
    i <- 0 until xs.length
    j <- i + 1 until xs.length
    if (sameDigits(xs(i), xs(j)))
    k <- j + 1 until xs.length
    if (sameDigits(xs(j), xs(k)))
    if ((xs(j) - xs(i)) == (xs(k) - xs(j)))
  }
  yield ((xs(i), xs(j), xs(k)))

  @Test def verifyAnswer() {
    val ExpectedAnswer = "296962999629"
    assertEquals(ExpectedAnswer, answer)
  }

  def answer = tuples.map {
    case (a, b, c) => "" + a + b + c
  }.filter(_ != "148748178147").head
}