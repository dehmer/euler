package euler.level_01

import org.junit.Assert._
import org.junit.Test

final class Test_018 {

  val a = Array(
    Array(75),
    Array(5, 64),
    Array(17, 47, 82),
    Array(18, 35, 87, 10),
    Array(20, 04, 82, 47, 65),
    Array(19, 01, 23, 75, 03, 34),
    Array(88, 02, 77, 73, 07, 63, 67),
    Array(99, 65, 04, 28, 06, 16, 70, 92),
    Array(41, 41, 26, 56, 83, 40, 80, 70, 33),
    Array(41, 48, 72, 33, 47, 32, 37, 16, 94, 29),
    Array(53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14),
    Array(70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57),
    Array(91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48),
    Array(63, 66, 04, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31),
    Array(04, 62, 98, 27, 23,  9, 70, 98, 73, 93, 38, 53, 60, 04, 23)
  )

  def path(rows: Array[Array[Int]], bottom: Seq[Int]): Int = {
    val ms = bottom.zip(bottom.tail).map(p => p._1 max p._2)
    val ss = rows.last.zip(ms).map(p => p._1 + p._2)
    if (ss.size == 1) ss.head else path(rows.init, ss)
  }

  @Test def verifyAnswer() {
    val ExpectedAnswer = 1074
    assertEquals(ExpectedAnswer, path(a.init, a.last))
  } 
}