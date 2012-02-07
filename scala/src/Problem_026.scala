

object Problem_026 extends App {
  // http://en.wikipedia.org/wiki/Recurring_decimal
  val ps = (2 until 1000).map(i => (1 to 2000).find(BigInt(10).modPow(_, i) == 1))
  ps.flatten.foreach(println)
  val r = 2 + ps.indexOf(Some(ps.flatten.max))
  assert(r == 983)
}
