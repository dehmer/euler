object Problem_028 extends App {
  import Predef.timed

  def diag(i: Int): Int = if(i == 1) 1 else 4 * i * i - (6 * i - 6) + diag(i - 2)
  val duration = timed(assert(669171001 == diag (1001)))
  println("duration: " + duration + " ms.")
}