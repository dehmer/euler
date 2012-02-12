package euler.level_01

import org.junit.Assert._
import org.junit.Test
import io.Source

final class Test_022 {

  @Test def verifyAnswer() {
    val ExpectedAnswer = 871198282
    assertEquals(ExpectedAnswer, answer)
  }

  def answer = {
    def names = Source.fromFile("names.txt").getLines().mkString.split(",").map(_.replace("\"", ""))
    def ord(c: Char) = (c - 'A').toInt + 1
    def score(s: String) = s.foldLeft(0)((acc, c) => acc + ord (c))

    names.sorted.zipWithIndex.foldLeft(0) { case (acc, (name, index)) => acc + score(name) * (index + 1) }
  }
}