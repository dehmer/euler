
object Problem_025 extends App {
  // give otherwise anonymous tuple members meaningful names
  case class Fib(term: Int, n: BigInt)

  // NOTE: case (a, b) => ... binds ._1 and ._2 to names a, b
  val fibs: Stream[Fib] =
    Fib(0, BigInt(0)) #::
    Fib(1, BigInt(1)) #::
    fibs.zip(fibs.tail).map { case(a, b) => Fib(b.term + 1, a.n + b.n) }

  assert(4782 == fibs.dropWhile(x => x.n < BigInt(10).pow(999)).take(1).head.term)
}