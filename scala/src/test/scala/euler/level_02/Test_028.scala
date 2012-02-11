package euler.level_02

import org.junit.Assert._
import org.junit.Test

final class Test_028 {

  @Test def verifyAnswer() {
    val ExpectedAnswer = 669171001
    def diag(i: Int): Int = if (i == 1) 1 else 4 * i * i - (6 * i - 6) + diag(i - 2)
    assertEquals(ExpectedAnswer, diag(1001))

  }
}