object Problem_037 extends App {
  import math._
  import Predef.{primes, timed}

  def truncated(n: Long): Set[Long] = {
    val cutR = (x: Long) => x / 10
    val cutL = (x: Long) => x % pow(10, log10(x).toLong).toLong

    def truncated(n: Long, knife: Long => Long, acc: Set[Long]): Set[Long] = knife(n) match {
      case x if(x > 0) => truncated(x, knife, acc + x)
      case _ => acc
    }

    truncated(n, cutR, truncated(n, cutL, Set[Long]()))
  }

  timed("duration: %d ms.") {
    val wildGuess = 748318 // whatever works :-)
    val ps = primes.takeWhile(_ < wildGuess).toSet
    val result = ps.filter(p => p > 7 && truncated(p).forall(x => ps.contains(x))).sum
    assert(748317 == result)
  }
}