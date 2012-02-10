package level_02

object Problem_036 extends App {

  import Predef.timed

  def isPalindrom(s: String) = s == s.reverse

  timed("duration: %d ms.") {
    val result = (1 to 999999 by 2).filter(x => isPalindrom(x.toString) && isPalindrom(x.toBinaryString)).sum
    assert(872187 == result)
  }
}