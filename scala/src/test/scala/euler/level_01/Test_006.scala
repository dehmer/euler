package euler.level_01

import org.junit.Test

/**
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */
final class Test_006 {

  @Test def verifyAnswer() {
    val ExpectedAnswer = 25164150
    assert(ExpectedAnswer == answer)
  }

  def answer = {
    val (x, sqrt_y) = Stream.from(1).take(100).foldLeft((0, 0))((acc, p) => (acc._1 + p * p, acc._2 + p))
    sqrt_y * sqrt_y - x
  }
}