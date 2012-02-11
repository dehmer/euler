package euler.level_02

import euler.Primes
import org.junit.Assert._
import org.junit.Test

final class Test_035 {

  def rotations(n: Long): List[Long] = {
    def rotate(s: String, n: Int) = (s.substring(n) + s.substring(0, n)).toLong
    val s = n.toString
    (1 to s.length() - 1).foldLeft(List[Long]())((acc, x) => rotate(s, x) :: acc)
  }

  @Test def verifyAnswer() {
    val ExpectedAnswer = 55
    val ps = Primes.takeWhile(_ < 1000000).toSet // hash-based set for faster lookup
    assertEquals(ExpectedAnswer, ps.filter(x => rotations(x).forall(p => ps.contains(p))).size)
  }
}