package euler.level_02

import org.junit.Assert._
import org.junit.Test

final class Test_026 {

  @Test def verifyAnswer() {
    val ExpectedAnswer =
    assertEquals(983, asnwer)
  }
  
  def asnwer = {
    // http://en.wikipedia.org/wiki/Recurring_decimal
    val ps = (2 until 1000).map(i => (1 to 2000).find(BigInt(10).modPow(_, i) == 1))
    2 + ps.indexOf(Some(ps.flatten.max))
  }
}