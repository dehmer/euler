package euler.level_01

import org.junit.Assert._
import org.junit.Test

final class Test_025 {

  // give otherwise anonymous tuple members meaningful names
  case class Fib(term: Int, n: BigInt)

  // NOTE: case (a, b) => ... binds ._1 and ._2 to names a, b
  val Fibonaccis: Stream[Fib] = Fib(0, BigInt(0)) #:: Fib(1, BigInt(1)) #:: Fibonaccis.zip(Fibonaccis.tail).map {
    case (a, b) => Fib(b.term + 1, a.n + b.n)
  }

  @Test def verifyAnswer() {
    val ExpectedAnswer = 4782
    assertEquals(ExpectedAnswer, answer)
  }

  def answer = Fibonaccis.dropWhile(x => x.n < BigInt(10).pow(999)).take(1).head.term
}