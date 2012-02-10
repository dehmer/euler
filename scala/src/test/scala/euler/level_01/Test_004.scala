package euler.level_01

import math.max
import org.junit.Test

/**
 * Find the largest palindrome made from the product of two 3-digit numbers. 
 */
final class Test_004 {

  @Test def verifyAnswer() {
    val ExpectedAnswer = 906609 
    assert(ExpectedAnswer == answer)
  }
  
  def answer = (for (x <- 900 to 999; y <- x to 999; c = x * y if isPalindrome(c)) yield c).foldLeft(0)(max)

  def isPalindrome(x: Int) = x.toString match {
    case s: String => s == s.reverse
  }
}