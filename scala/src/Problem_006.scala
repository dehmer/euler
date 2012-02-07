
/**
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */
object Problem_006 extends App {
  val (x, sqrt_y) = Stream.from(1).take(100).foldLeft((0, 0))((acc, p) => (acc._1 + p * p, acc._2 + p))
  val diff = sqrt_y * sqrt_y - x
  assert(25164150 == diff)
}