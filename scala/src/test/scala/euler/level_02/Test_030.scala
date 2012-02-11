package euler.level_02

import math.pow
import org.junit.Assert._
import org.junit.Test

final class Test_030 {

  @Test def verifyAnswer() {
    val ExpectedAnswer = 443839
    def isQuintSum(n: Long) = n == n.toString.map(c => pow(c - '0', 5).toLong).sum
    assertEquals(ExpectedAnswer, (2L to 5 * (pow(9, 5)).toLong).filter(isQuintSum).sum)
  }
}