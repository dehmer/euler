
/** Find the largest palindrome made from the product of two 3-digit numbers. */
object Problem_004 extends App {
  import math.max

  def isPalindrome(x: Int) = x.toString match {
    case s: String => s == s.reverse
  }

  def result = (for (x <- 900 to 999; y <- x to 999; c = x * y if isPalindrome(c)) yield c).foldLeft(0)(max)

  assert(906609 == result)
}