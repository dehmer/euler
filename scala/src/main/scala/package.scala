package object euler {

  val Odds: Stream[Long] = 3 #:: Odds.map(_ + 2)
  val Primes: Stream[Long] = 2L #:: Odds.filter(n => Primes.takeWhile(p => p * p <= n).forall(n % _ != 0))
  val Fibonaccis: Stream[Long] = 0 #:: 1 #:: Fibonaccis.zip(Fibonaccis.tail).map { case (a, b) => a + b }

  val TriangleNumbers: Stream[Long] = 0 #:: TriangleNumbers.zipWithIndex.map {
    case (a, b) => a + b + 1
  }

  def fac(n: BigInt): BigInt = if (n == BigInt(1) || n == BigInt(0)) BigInt(1) else n * fac(n - 1)
}