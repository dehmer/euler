package euler.level_01

import org.junit.Assert._
import org.junit.Test

final class Test_016 {

  @Test def verifyAnswer() {
    val ExpectedAnswer = 1366
    assertEquals(ExpectedAnswer, answer)
  }

  def answer = BigInt("2").pow(1000).toString().map(c => c - '0').reduce(_ + _)
}