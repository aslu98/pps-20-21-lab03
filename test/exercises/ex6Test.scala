package exercises

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test
import u03.Lists.List.{Cons, Nil}
import u03.Streams.Stream

class ex6Test {
  
  @Test def testConstant(): Unit = {
    val x:Int = 12
    assertEquals(Cons(x, Cons(x, Cons(x, Cons(x, Cons(x, Nil ()))))), Stream.toList(Stream.take(ExtendedStream.constant(x))(5)))
    assertEquals(Nil(), Stream.toList(Stream.take(ExtendedStream.constant(x))(0)))
  }

}