
object Predef {
  lazy val odds: Stream[Long] = 3 #:: odds.map(_ + 2)
  lazy val primes: Stream[Long] = 2L #:: odds.filter(n => primes.takeWhile(p => p * p <= n).forall(n % _ != 0))

  def timed[B](block: => B) = {
    val time = System.currentTimeMillis(); block; System.currentTimeMillis() - time
  }

  def timed[B](msg: String)(block: => B) = {
    val time = System.currentTimeMillis();
    val result = block
    println(msg.format(System.currentTimeMillis() - time))
    result
  }
}