package euler.level_02

import math.sqrt
import euler.Naturals
import org.junit.Assert._
import org.junit.Test

final class Test_044 {

  // Test for pentagonal numbers: http://en.wikipedia.org/wiki/Pentagonal_number
  def isPentagonal(x: Long) = (sqrt(24 * x + 1) + 1) % 6 == 0
  val Pentagonal = Naturals.map(n => n * (3 * n - 1) / 2)

  @Test def verifyAnswer() {
    val ExpectedAnswer = 5482660
    assertEquals(ExpectedAnswer, answer)
  }
  
  def answer = Pentagonal.take(2167).foldLeft(0L) {
    (acc, j) =>
      val diffs = Pentagonal.takeWhile(k => k < j).filter(k => isPentagonal(j - k))
      val sums = Pentagonal.takeWhile(k => k < j).filter(k => isPentagonal(j + k))
      if (!sums.intersect(diffs).isEmpty) j - sums.intersect(diffs).max
      else acc
  }
}