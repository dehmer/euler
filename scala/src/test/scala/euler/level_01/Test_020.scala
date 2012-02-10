package euler.level_01

import euler.fac
import org.junit.Assert._
import org.junit.Test

final class Test_020 {

  @Test def verifyAnswer() {
    val ExpectedAnswer = 648
    assertEquals(ExpectedAnswer, answer)
  }

  def answer = fac(100).toString().map(c => c - '0').reduce(_ + _)
}