object Problem_030 extends App {
  import Predef.timed
  import math.pow

  def isQuintSum(n: Long) = n == n.toString.map(c => pow(c - '0', 5).toLong).sum

  val duration = timed("duration: %d ms.") {
    assert(443839 == (2L to 5 * (pow(9, 5)).toLong).filter(isQuintSum).sum)
  }
}