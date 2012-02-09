
object Problem_035 extends App {
  import Predef.{primes, timed}

  def binarySearch[A <% Ordered[A]](a: IndexedSeq[A], v: A) = {
    def recurse(low: Int, high: Int): Option[Int] = (low + high) / 2 match {
      case _ if high < low => None
      case mid if a(mid) > v => recurse(low, mid - 1)
      case mid if a(mid) < v => recurse(mid + 1, high)
      case mid => Some(mid)
    }
    recurse(0, a.size - 1)
  }

  def rotations(n: Long): List[Long] = {
    def rotate(s: String, n: Int) = (s.substring(n) + s.substring (0, n)).toLong
    val s = n.toString

    (1 to s.length() - 1).foldLeft(List[Long]())((acc, x) => rotate(s, x) :: acc)
  }

  timed("duration: %d ms.") {
    val ps = primes.takeWhile(_ < 1000000).toArray
    val result = ps.filter(x => rotations(x).forall(p => binarySearch(ps, p).isDefined)).size
    assert(55 == result)
  }
}