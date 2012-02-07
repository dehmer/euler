

object Problem_010 extends App {
  import Predef.primes
  assert(142913828922L == primes.takeWhile(_ < 2000000).reduceLeft(_ + _))
}