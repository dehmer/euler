

object Problem_016 extends App {
  // 1366
  println(BigInt("2").pow(1000).toString().map(c => c - '0').reduce(_ + _))
}