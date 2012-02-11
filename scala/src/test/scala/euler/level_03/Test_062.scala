package euler.level_03

import euler.Cubes
import org.junit.Assert._
import org.junit.Test

/**
 * Find the smallest cube for which exactly five permutations of its digits are cube.
 */
final class Test_062 {

  def group(cs: Stream[Long], count: Int, keys: Map[String, Set[Long]]): Long = {
    val c = cs.head
    val key = c.toString.sorted
    if (keys.contains(key)) {
      if (keys(key).size == count - 1) keys(key).min
      else group(cs.tail, count, keys + (key -> (keys(key) + c)))
    }
    else group(cs.tail, count, keys + (key -> Set(c)))
  }

  @Test def verifyAnswer() {
    val PermutationCount = 5
    val ExpectedAnswer = 127035954683L 
    assertEquals(ExpectedAnswer, group(Cubes, PermutationCount, Map[String, Set[Long]]()))
  }
}