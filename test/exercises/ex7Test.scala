package exercises

import exercises.ExtendedStream.iterateTwoInputs
import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test
import u03.Lists.List.{Cons, Nil}
import u03.Streams.Stream

class ex7Test {
  
  @Test def testFibonacci(): Unit = {
    val fibs: Stream[Int] = iterateTwoInputs(0)(1)((a, b) => a+b)
    assertEquals( Cons(0, Cons(1, Cons(1, Cons(2, Cons(3, Cons(5, Cons(8, Cons(13, Nil())))))))),
                  Stream.toList(Stream.take(fibs)(8)))
  }

}