object Problem_034 extends App {
  import Predef.timed

  def fac(n: Int): Int = if(n == 0) 1 else n * fac(n-1)

  timed("duration: %d ms.") {
    val result = (3 to fac(9)).fold(0) {
      (acc, i) =>
      val sum = i.toString.map(c => c - '0').foldLeft(0)((acc, i) => acc + fac (i))
      if(sum.toString() == i.toString) acc + i
      else acc
    }

    assert(40730 == result)
  }
}
