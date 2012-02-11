package euler.level_02

import math._
import euler.Naturals
import org.junit.Assert._
import org.junit.Test

final class Test_045 {
  lazy val Hexagonal = Naturals.map(n => n * (2 * n - 1))

  // NOTE: triangular numbers is a subset of hexagonal numbers.
  // Test for pentagonal numbers: http://en.wikipedia.org/wiki/Pentagonal_number
  def isPentagonal(x: Long) = (sqrt(24 * x + 1) + 1) % 6 == 0

  @Test def verifyAnswer() {
    val ExpectedAnswer = 1533776805
    assertEquals(ExpectedAnswer, answer)
  }

  def answer = Hexagonal.drop(143).find(isPentagonal).get
}