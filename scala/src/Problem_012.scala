
/**
 * What is the value of the first triangle number to have over five hundred divisors?
 */
object Problem_012 extends App {
  import Predef.{primes, timed}
  
  val triangleNums: Stream[Long] = 0 #:: triangleNums.zipWithIndex.map { case (a,b) => a + b + 1 }

  /* Returns number of prime factors of a number. */
  def primeFactors(i: Long) = {
    def inc(m: Map[Long, Long], x: Long) = m + (x -> (m.getOrElse(x, 0L) + 1))

    def factor(i: Long, p: Int, acc: Map[Long, Long]): Map[Long, Long] = {
      lazy val prime = primes.take(p).last
      i match {
        case 1 => acc
        case x if (x % prime == 0) => factor(i / prime, p, inc(acc, prime))
        case x => factor(i, p + 1, acc)
      }
    }

    factor(i, 1, Map[Long, Long]()).map(x => x._2 + 1).foldLeft(1L)((acc, x) => acc * x)
  }

  val duration = timed {
    assert(76576500 == triangleNums.drop(1).find(x => primeFactors(x) > 500).get)
  }
  
  println("duration: " + duration + " ms.")
}