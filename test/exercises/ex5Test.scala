package exercises

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test
import u03.Streams.Stream
import u03.Lists.List.{Cons, Nil}

class ex5Test {
  val s = Stream. take (Stream.iterate(0)(_+1))(10)

  @Test def testDrop(): Unit = {
    assertEquals(Cons(6, Cons(7, Cons(8, Cons(9, Nil())))), Stream.toList(ExtendedStream.drop(s)(6)))
    assertEquals(Cons(9, Nil()), Stream.toList(ExtendedStream.drop(s)(9)))
  }

}