package euler.level_01

import euler.{Primes, TriangleNumbers}
import org.junit.Test

// TODO: quite a long-runner => speed up (somehow)!

/**
 * What is the value of the first triangle number to have over five hundred divisors?
 */
final class Test_012 {

  /* Returns number of prime factors of a number. */
  def primeFactors(i: Long) = {
    def inc(m: Map[Long, Long], x: Long) = m + (x -> (m.getOrElse(x, 0L) + 1))

    def factor(i: Long, p: Int, acc: Map[Long, Long]): Map[Long, Long] = {
      lazy val prime = Primes.take(p).last
      i match {
        case 1 => acc
        case x if (x % prime == 0) => factor(i / prime, p, inc(acc, prime))
        case x => factor(i, p + 1, acc)
      }
    }

    factor(i, 1, Map[Long, Long]()).map(x => x._2 + 1).foldLeft(1L)((acc, x) => acc * x)
  }

  @Test def verifyAnswer() {
    val ExpectedAnswer = 76576500
    assert(ExpectedAnswer == answer)
  }

  def answer = TriangleNumbers.drop(1).find(x => primeFactors(x) > 500).get
}