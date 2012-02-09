
object Problem_020 extends App {
  import Predef.fac
  println(fac(100).toString().map(c => c - '0').reduce(_ + _))
}