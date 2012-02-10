package euler.level_01

import org.junit.Test

/**
 * What is the largest prime factor of the number 600851475143?
 */
final class Test_003 {

  def maxPrimeFactor(n: Long) = {
    def divide(n: Long, divisor: Int): Int = {
      if (n == divisor) divisor
      else if (n % divisor == 0) divide(n / divisor, divisor)
      else divide(n, divisor + 1)
    }

    divide(n, 2)
  }

  @Test def verifyAnswer() {
    val Input = 600851475143L
    val ExpectedAnswer = 6857
    assert(ExpectedAnswer == maxPrimeFactor(Input))
  }
}