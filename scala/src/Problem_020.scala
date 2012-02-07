
object Problem_020 extends App {
  def fac(n: BigInt): BigInt = if (n == BigInt(1)) BigInt(1) else n * fac(n - 1)

  println(fac(100).toString().map(c => c - '0').reduce(_ + _))
}