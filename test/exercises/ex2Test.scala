package exercises

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test
import u03.Lists.List.{Cons, Nil}
import u02.Optionals.Option.{Some, None}
import exercises.ExtendedList._

class ex2Test {
  val lst = Cons(10, Cons(20, Cons(30, Nil())))

  @Test def testMax(): Unit = {
    assertEquals(Some(25), max(Cons(10, Cons(25, Cons(20, Nil())))))
    assertEquals(None(), max(Nil()))
  }
}