
/**
 * What is the largest prime factor of the number 600851475143?
 */
object Problem_003 extends App {
  import Predef.timed

  def maxPrimeFactor(n: Long) = {
    def divide(n: Long,  fac: Int): Int = {
      if (n == fac) fac
      else if (n % fac == 0) divide(n / fac, fac)
      else divide(n, fac + 1)
    }

    divide(n, 2)
  }
  
  val duration = timed(assert(6857 == maxPrimeFactor(600851475143L)))
  println("duration: " + duration + " ms.")
}