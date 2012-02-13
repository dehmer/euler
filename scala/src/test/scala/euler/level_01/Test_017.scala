package euler.level_01

import org.junit.Assert._
import org.junit.Test

final class Test_017 {

  val nums = Map(
    1 -> "one", 2 -> "two", 3 -> "three", 4 -> "four", 5 -> "five", 6 -> "six", 7 -> "seven", 8 -> "eight", 9 -> "nine",
    10 -> "ten", 11 -> "eleven", 12 -> "twelve", 13 -> "thirteen", 14 -> "fourteen", 15 -> "fifteen", 16 -> "sixteen",
    17 -> "seventeen", 18 -> "eighteen", 19 -> "nineteen", 20 -> "twenty", 30 -> "thirty", 40 -> "forty", 50 -> "fifty",
    60 -> "sixty", 70 -> "seventy", 80 -> "eighty", 90 -> "ninety", 100 -> "onehundred", 1000 -> "onethousand"
  )

  def strlen(n: Int): Int =  {
    def strlist(n: Int, acc: List[String]): List[String] = {
      if (n == 0) acc
      else if (nums.contains(n)) nums(n) :: acc
      else if (n > 100) strlist(n - (n / 100) * 100, nums(n / 100) :: "hundred" :: (if(n % 100 == 0) "" else "and") :: acc)
      else strlist(n - (n / 10) * 10, nums((n / 10) * 10) :: acc)
    }

    strlist(n, Nil).foldLeft(0)((acc, s) => acc + s.length())
  }

  @Test def verifyAnswer() {
    val ExpectedAnswer = 21124
    assertEquals(ExpectedAnswer, answer)
  }

  def answer = (1 to 1000).map(strlen).sum
}