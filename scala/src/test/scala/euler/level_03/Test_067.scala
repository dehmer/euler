package euler.level_03

import io.Source
import math.max
import org.junit.Test

final class Test_067 {

  def asIntArray(s: String) = s.trim.split("\n").map(_.split("\\s").map(_.toInt))
  val a: Array[Array[Int]] = asIntArray(Source.fromFile("triangle.txt").mkString)

  def path(rows: Array[Array[Int]], bottom: Seq[Int]): Int = {
    val ms = bottom.zip(bottom.tail).map { case (a, b) => max(a, b) }
    val ss = rows.last.zip(ms).map { case (a, b) => a + b }
    if (ss.size == 1) ss.head else path(rows.init, ss)
  }

  @Test def verifyAnswer() {
    val ExpectedAnswer = 7273
    assert(ExpectedAnswer == path(a.init, a.last))
  }
}