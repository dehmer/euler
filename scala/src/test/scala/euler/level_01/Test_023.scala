package euler.level_01

import org.junit.Assert._
import org.junit.Test

final class Test_023 {
  import euler.Primes
  import math.pow

  def primeFactors(n: Long, p: Stream[Long], acc: Map[Long, Int]): Map[Long, Int] = {
    def inc(n: Long) = acc + (n -> (acc.getOrElse(n, 0) + 1))
    if (n == 1) acc
    else if (n % p.head == 0) primeFactors(n / p.head, p, inc(p.head))
    else primeFactors(n, p.tail, acc)
  }

  // Sum of divisors (sigma 1) from prime factorization;
  // http://planetmath.org/encyclopedia/FormulaForSumOfDivisors.html
  def sigma1(factors: Map[Long, Int]) = factors.foldLeft(1L) {
    case (acc, (factor, exp)) => acc * ((pow(factor, exp + 1) - 1) / (factor - 1)).toLong
  }

  def sigma(n: Long) = sigma1(primeFactors(n, Primes, Map())) - n
  def abundant(n: Int) = sigma(n) > n


  @Test def verifyAnswer() {
    val ExpectedAnswer = 4179871
    assertEquals(ExpectedAnswer, answer)
  }

  def answer = {
    val max = 28123
    val as = (1 to max).filter(abundant)
    as.foldLeft((1 to max).toSet) {
      (acc, a) => as.foldLeft(acc)((acc, b) => if (a <= b && (a + b) <= max) acc - (a + b) else acc)
    }.sum
  }
}