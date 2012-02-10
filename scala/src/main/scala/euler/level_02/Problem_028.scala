package euler.level_02

object Problem_028 extends App {
  def diag(i: Int): Int = if (i == 1) 1 else 4 * i * i - (6 * i - 6) + diag(i - 2)
  assert(669171001 == diag(1001))
}