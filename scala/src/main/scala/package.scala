package object euler {

  lazy val Naturals: Stream[Long] = 1 #:: Naturals.map(_ + 1)
  lazy val Odds: Stream[Long] = 3 #:: Odds.map(_ + 2)
  lazy val Primes: Stream[Long] = 2L #:: Odds.filter(n => Primes.takeWhile(p => p * p <= n).forall(n % _ != 0))
  lazy val Fibonaccis: Stream[Long] = 0 #:: 1 #:: Fibonaccis.zip(Fibonaccis.tail).map { case (a, b) => a + b }
  lazy val Cubes: Stream[Long] = Naturals.map(x => x * x * x)

  val TriangleNumbers: Stream[Long] = 0 #:: TriangleNumbers.zipWithIndex.map {
    case (a, b) => a + b + 1
  }

  def fac(n: Int): BigInt = if (n == 0) BigInt(1) else n * fac(n - 1)
}