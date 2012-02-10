package level_02

object Problem_035 extends App {

  import Predef.{primes, timed}

  def rotations(n: Long): List[Long] = {
    def rotate(s: String, n: Int) = (s.substring(n) + s.substring(0, n)).toLong
    val s = n.toString
    (1 to s.length() - 1).foldLeft(List[Long]())((acc, x) => rotate(s, x) :: acc)
  }

  timed("duration: %d ms.") {
    val ps = primes.takeWhile(_ < 1000000).toSet // hash-based set for faster lookup
    assert(55 == ps.filter(x => rotations(x).forall(p => ps.contains(p))).size)
  }
}