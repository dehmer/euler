package euler.level_02

import io.Source

object Problem_042 extends App {

  def triangle(n: Int) = (n * (n + 1)) / 2
  def encode(s: String): Int = s.foldLeft(0)((acc, c) => acc + c - 'A' + 1)

  val N: Stream[Int] = 1 #:: N.map(_ + 1)
  val T = N.map(triangle)

  val words = Source.fromFile("words.txt").mkString.split(",").map(s => s.drop(1).dropRight(1))
  val result = words.map(encode).filter(c => T.takeWhile(_ <= c).last == c).size
  assert(162 == result)
}