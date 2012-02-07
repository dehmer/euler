

/**
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
object Problem_001 extends App {
  assert(233168 == ((1 to 999).filter(x => x % 3 == 0 || x % 5 == 0).reduce (_ + _)))
}