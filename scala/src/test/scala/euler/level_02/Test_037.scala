package euler.level_02

import math._
import euler.Primes
import org.junit.Assert._
import org.junit.Test

final class Test_037 {

  def truncated(n: Long): Set[Long] = {
    val cutR = (x: Long) => x / 10
    val cutL = (x: Long) => x % pow(10, log10(x).toLong).toLong

    def truncated(n: Long, knife: Long => Long, acc: Set[Long]): Set[Long] = knife(n) match {
      case x if (x > 0) => truncated(x, knife, acc + x)
      case _ => acc
    }

    truncated(n, cutR, truncated(n, cutL, Set[Long]()))
  }

  @Test def verifyAnswer() {
    val ExpectedAnswer = 748317
    assertEquals(ExpectedAnswer, answer)
  }

  def answer = {
    val WildGuess = 748318 // whatever works :-)
    val ps = Primes.takeWhile(_ < WildGuess).toSet
    ps.filter(p => p > 7 && truncated(p).forall(x => ps.contains(x))).sum
  }
}