package euler.level_02

import org.junit.Assert._
import org.junit.Test

final class Test_034 {

  def fac(n: Int): Int = if (n == 0) 1 else n * fac(n - 1)

  val result = (3 to fac(9)).fold(0) {
    (acc, i) =>
    val sum = i.toString.map(c => (c - '0').toInt).foldLeft(0)((acc, i) => acc + fac(i))
    if (sum.toString() == i.toString) acc + i
    else acc
  }

  @Test def verifyAnswer() {
    val ExpectedAnswer = 40730 
    assertEquals(ExpectedAnswer, result)
  }
}