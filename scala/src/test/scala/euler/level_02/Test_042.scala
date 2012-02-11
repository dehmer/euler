package euler.level_02

import io.Source
import euler.Naturals
import org.junit.Assert._
import org.junit.Test

final class Test_042 {

  def triangle(n: Long) = (n * (n + 1)) / 2
  def encode(s: String): Int = s.foldLeft(0)((acc, c) => acc + c - 'A' + 1)

  @Test def verifyAnswer() {
    val ExpectedAnswer = 162
    assertEquals(ExpectedAnswer, answer)
  }

  def answer = {
    val Triangles = Naturals.map(triangle)
    val words = Source.fromFile("words.txt").mkString.split(",").map(s => s.drop(1).dropRight(1))
    words.map(encode).filter(c => Triangles.takeWhile(_ <= c).last == c).size
  }

}