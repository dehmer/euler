package euler.level_02

import org.junit.Assert._
import org.junit.Test

final class Test_048 {

  @Test def verifyAnswer() {
    val ExpectedAnswer = "9110846700"
    assertEquals(ExpectedAnswer, answer)
  }

  def answer = {
    val sum = (1 to 1000).map(x => BigInt(x).pow(x)).sum.toString()
    sum.substring(sum.length() - 10)
  }
}