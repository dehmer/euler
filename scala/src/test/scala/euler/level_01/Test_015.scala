package euler.level_01

import euler.fac
import org.junit.Test
import org.junit.Assert._

/**
 * How many routes are there through a 20 x 20 grid?
 */
final class Test_015 {

  @Test def verifyAnswer() {
    val ExpectedAnswer = BigInt(137846528820L)
    assertEquals(ExpectedAnswer, (euler.fac(40) / (fac(20) * fac(20))))
  }
}