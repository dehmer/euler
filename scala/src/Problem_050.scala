
/** Which prime, below one-million, can be written as the sum of the most consecutive primes? */
object Problem_050 extends App {
  import Predef.primes

  // 78,498 prime numbers < 1,000,000
  val ps: Stream[(Long,  Long)] = (2L, 2L) #:: primes.drop(1).zip(ps.map(_._2)).map { case (a, b) => (a, a + b) }
  val xs = ps.takeWhile { case (p, _) => p < 1000000 }.toArray

  def chain: (Long, Int) = {
    def chains(ix: Int, hix: Int, lix: Int, acc: List[Int]): List[Int] = {
      if(lix == xs.length) acc
      else {
        val diff = if(hix == -1) xs(lix)._2 else xs(lix)._2 - xs(hix)._2
        if (diff == xs(ix)._1) (lix - hix) :: acc
        else if (diff < xs(ix)._1) chains(ix, hix, lix + 1, acc)
        else chains(ix, hix + 1, lix, acc)
      }
    }
    
    (0 until xs.length).foldLeft((0L, 0)) {
      (acc, ix) =>
      val max = chains(ix, -1, 0, List(0)).max
      if (max > acc._2) (xs(ix)._1, max) else acc
    }
  }
  
  assert((997651L, 543) == chain)
}