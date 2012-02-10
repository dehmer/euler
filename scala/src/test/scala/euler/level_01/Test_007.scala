package euler.level_01

import org.junit.Test

/**
 * What is the 10,001st prime number?
 */
final class Test_007 {

  @Test def verifyAnswer() {
    val NthPrime = 10001
    val ExpectedAnswer = 104743
    assert(ExpectedAnswer == (euler.Primes.take(NthPrime).last))
  }
}