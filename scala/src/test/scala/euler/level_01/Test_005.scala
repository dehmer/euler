package euler.level_01

import org.junit.Test

/**
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
final class Test_005 {
  val divisors = List[Long](11, 12, 13, 14, 15, 16, 17, 18, 19, 20)

  @Test def verifyAnswer() {
    val ExpectedAnswer = 232792560
    assert(ExpectedAnswer == answer)
  }

  def answer = {
    // NOTE: using Int instead of Long as parameter type introduces major overhead.
    def dividable(n: Long) = divisors.forall(n % _ == 0)
    Stream.from(20, 20).dropWhile(n => !dividable(n)).head
  }
}