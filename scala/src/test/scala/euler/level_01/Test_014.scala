package euler.level_01

import org.junit.Test

/**
 * Which starting number, under one million, produces the longest chain?
 */
final class Test_014 {

  def collatz(n: Long, acc: Int): Int = if (n == 1) acc else collatz(if (n % 2 == 1) 3 * n + 1 else n / 2, acc + 1)

  @Test def verifyAnswer() {
    val ExpectedAnswer = 837799
    assert(ExpectedAnswer == answer)
  }

  def answer = (1L to 999999L).map(i => (i, collatz(i, 1))).maxBy(_._2)._1
}