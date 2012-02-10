package level_02

object Problem_031 extends App {

  import Predef.timed

  val coins = List(200, 100, 50, 20, 10, 5, 2, 1)
  val maxValue = 200

  def combinations(coins: List[Int], value: Int, acc: Int): Int = (coins, value) match {
    case (_, v) if (v == maxValue) => acc + 1
    case (h :: Nil, v) => if (v % h == 0) 1 else 0
    case (h :: t, v) => (0 to (maxValue - v) / h).map(i => combinations(t, v + i * h, acc)).sum
  }

  println(combinations(coins, 0, 0).toString)

  val duration = timed("duration: %d ms.") {
    assert(73682 == combinations(coins, 0, 0))
  }
}