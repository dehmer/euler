package euler.level_01

import org.junit.Test

/**
 * Find the sum of all the primes below two million.
 */
final class Test_010 {

  @Test def verifyAnswer() {
    val ExpectedAnswer = 142913828922L
    assert(ExpectedAnswer == euler.Primes.takeWhile(_ < 2000000).reduceLeft(_ + _))
  }
}