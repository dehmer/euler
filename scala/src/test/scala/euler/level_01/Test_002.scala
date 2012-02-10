package euler.level_01

import org.junit.Test
import euler.Fibonaccis

/**
 * By considering the terms in the Fibonacci sequence whose values do not exceed four million,
 * find the sum of the even-valued terms.
 */
final class Test_002 {

  def even(x: Long) = x % 2 == 0

  @Test def verifyAnsert() {
    val ExpectedAnswer = 4613732
    assert(ExpectedAnswer == Fibonaccis.takeWhile(_ < 4000000).filter(even).reduce(_ + _))
  }
}