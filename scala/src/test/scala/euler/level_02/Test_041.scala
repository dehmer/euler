package euler.level_02

import math.sqrt
import euler.Naturals
import org.junit.Assert._
import org.junit.Test

final class Test_041 {

  def isPrime(n: Long) = !Naturals.drop(1).take(sqrt(n).intValue()).exists(n % _ == 0)

  @Test def verifyAnswer() {
    val ExpectedAnswer = 7652413
    assertEquals(ExpectedAnswer, answer)
  }

  def answer = {
    // start at 1234567 because of cross sum for 1*8 and 1*9 is dividable by 3. i.e. no prime there
    "1234567".permutations.map(_.toLong).foldLeft(0L)((acc, x) => if (isPrime(x) && x > acc) x else acc)
  }
}