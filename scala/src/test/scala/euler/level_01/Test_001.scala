package euler.level_01

import org.junit.Test

/**
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
final class Test_001 {

  @Test def verifyAnswer() {
    val ExpectedAnswer = 233168
    assert(ExpectedAnswer == ((1 to 999).filter(x => x % 3 == 0 || x % 5 == 0).reduce(_ + _)))
  }
}