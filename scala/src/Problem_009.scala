
object Problem_009 extends App {

  // a = m^2 - n^2
  // b = 2 * m * n
  // c = m^2 + n^2

  val cs = for {
    n <- 0 to 500; m <- n + 1 to 500
    a = (m * m - n * n); b = 2 * m * n; c = (m * m + n * n)

    if (a + b + c == 1000)
    if (a * a + b * b == c * c)
    if (a * b * c > 0)
  } yield (a * b * c)

  assert(31875000 == cs.head)
}