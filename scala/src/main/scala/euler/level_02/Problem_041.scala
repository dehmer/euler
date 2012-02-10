package level_02

object Problem_041 extends App {

  import Predef.timed
  import math.sqrt

  lazy val naturals: Stream[Long] = 1 #:: naturals.map(_ + 1)

  def isPrime(n: Long) = !naturals.drop(1).take(sqrt(n).intValue()).exists(n % _ == 0)

  // start at 1234567 because of cross sum for 1*8 and 1*9 is dividable by 3. i.e. no prime there
  val duration = timed("duration: %d ms.") {
    val result = "1234567".permutations.map(_.toLong).foldLeft(0L)((acc, x) => if (isPrime(x) && x > acc) x else acc)
    assert(7652413 == result)
  }

}