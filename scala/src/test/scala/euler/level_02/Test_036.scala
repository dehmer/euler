package euler.level_02

import org.junit.Assert._
import org.junit.Test

final class Test_036 {
  def isPalindrom(s: String) = s == s.reverse

  @Test def verifyAnswer() {
    val ExpectedAnswer = 872187
    assertEquals(ExpectedAnswer, answer)
  }

  def answer = (1 to 999999 by 2).filter(x => isPalindrom(x.toString) && isPalindrom(x.toBinaryString)).sum
}