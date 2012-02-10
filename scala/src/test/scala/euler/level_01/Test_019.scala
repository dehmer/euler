package euler.level_01

import org.junit.Assert._
import org.junit.Test
import org.joda.time.{DateTime, DateTimeConstants}
import org.joda.time.format.DateTimeFormat

final class Test_019 {
  val formatter = DateTimeFormat.forPattern("yyyyMMdd")
  def date(s: String) = formatter.parseDateTime(s)
  val days: Stream[DateTime] = date("19010101") #:: days.map (_.plusDays(1))
  
  @Test def verifyAnswer() {
    val ExpectedAnswer = 171
    assertEquals(ExpectedAnswer, answer)
  }

  def answer = days.takeWhile(p => p.compareTo(date("20001231")) <= 0).filter {
    p => p.getDayOfMonth == 1 && p.getDayOfWeek == DateTimeConstants.SUNDAY
  }.size
}