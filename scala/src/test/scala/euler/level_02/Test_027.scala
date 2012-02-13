package euler.level_02

import org.junit.Assert._
import org.junit.Test
import euler.{Primes, Naturals}

class Test_027 {

  // f(n) = n^2 + a * n + b
  // => b must be a prime (f(0))
  // => a must be (almost ever) odd

  @Test def verifyAnswer() {
    val ExpectedAnswer = -61 * 971 // -59231
    assertEquals(ExpectedAnswer, answer)
  }

  def answer = {
    case class Answer(s: Int, a: Int, b: Long)
    def isPrime(n: Long) = (n > 1) && (Primes.takeWhile(_ <= math.sqrt(n)).forall(n % _ != 0))
    def quadratic(a: Int, b: Long) = (n: Long) => n * n + a * n + b

    val answer = (-999 to 999 by 2).foldLeft(Answer(0, 0, 0L)) {
      (acc, x) =>
        val c = Primes.takeWhile(_ < 999).foldLeft(acc) {
          (acc, y) =>
            val sequence = (0 #:: Naturals).takeWhile(n => isPrime(math.abs(quadratic(x, y)(n)))).size
            if (sequence > acc.s) Answer(sequence, x, y) else acc
        }

        if (c.s > acc.s) c else acc
    }

    answer.a * answer.b
  }
}