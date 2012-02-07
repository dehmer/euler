
object Problem_048 extends App {
  val sum = (1 to 1000).map(x => BigInt(x).pow(x)).sum.toString()
  println(sum.substring(sum.length() - 10))
}