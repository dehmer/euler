package euler.level_01

import euler.{Primes, TriangleNumbers}
import org.junit.Assert._
import org.junit.Test

/**
 * What is the value of the first triangle number to have over five hundred divisors?
 */
final class Test_012 {

  def primeFactors(n: Long) = {
    (1 to math.sqrt(n).toInt).foldLeft(0) {
      (acc, i) =>
      if (n % i == 0) {
        if (n / i == i) acc + 1
        else acc + 2
      } else acc
    }
  }

  @Test def verifyAnswer() {
    val ExpectedAnswer = 76576500
    assertEquals(ExpectedAnswer, answer)
  }

  def answer = TriangleNumbers.drop(1).find(x => primeFactors(x) > 500).get
}