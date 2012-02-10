package euler.level_01

import org.junit.Test

/**
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
final class Test_009 {

  // a = m^2 - n^2
  // b = 2 * m * n
  // c = m^2 + n^2

  @Test def verifyAnswer() {
    val ExpectedAnswer = 31875000
    assert(ExpectedAnswer == answer.head)
  }

  def answer = for {
    n <- 0 to 500; m <- n + 1 to 500
    a = (m * m - n * n); b = 2 * m * n; c = (m * m + n * n)

    if (a + b + c == 1000)
    if (a * a + b * b == c * c)
    if (a * b * c > 0)
  } yield (a * b * c)
}