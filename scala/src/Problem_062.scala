
/** Find the smallest cube for which exactly five permutations of its digits are cube. */
object Problem_062 extends App {
  import Predef.timed
  lazy val n: Stream[Long] = 1 #:: n.map(_ + 1)
  lazy val c: Stream[Long] = n.map(x => x * x * x)
  
  def group(cs: Stream[Long], keys: Map[String, Set[Long]]): Long = {
    val c = cs.head
    val key = c.toString.sorted
    if(keys.contains(key)) {
      if (keys(key).size == 4) keys(key).min
      else group(cs.tail, keys + (key -> (keys(key) + c)))
    }
    else group(cs.tail, keys + (key -> Set(c)))
  }

  timed("duration: %d ms.") {
    assert(127035954683L == group(c, Map[String,  Set[Long]]()))
  }
}