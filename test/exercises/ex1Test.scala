package exercises

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test
import u03.Lists.List.{Cons, Nil}
import exercises.ExtendedList._

class ex1Test {
  val lst = Cons(10, Cons(20, Cons(30, Nil())))

  @Test def testDrop(){
    assertEquals(Cons(20, Cons(30, Nil())), drop(lst, 1))
    assertEquals(Cons(30, Nil()), drop(lst, 2))
    assertEquals(Nil(), drop(lst, 5))
  }

  @Test def testFlatMap(): Unit ={
    assertEquals( Cons(11, Cons(21, Cons (31, Nil()))),
                  flatMap(lst)(v => Cons(v+1, Nil())))
    assertEquals( Cons (11, Cons(12, Cons (21, Cons (22, Cons(31, Cons(32, Nil ())))))),
                  flatMap(lst)(v => Cons(v+1, Cons(v+2, Nil()))))
    assertEquals( Cons (12, Cons(11, Cons (22, Cons (21, Cons(32, Cons(31, Nil ())))))),
                  flatMap(lst)(v => Cons(v+2, Cons(v+1, Nil()))))
  }

  @Test def testMap(): Unit ={
    assertEquals( Cons(11, Cons(21, Cons (31, Nil()))), map(lst)(v => v+1))
    assertEquals( Cons(5, Cons(10, Cons (15, Nil()))), map(lst)(v => v/2))
  }

  @Test def testFilter(): Unit = {
    assertEquals(Cons(20, Cons(30, Nil())),filter[Int](lst)(_ >=20))
    assertEquals(Cons(20, Nil()),filter[Int](lst)(_ == 20))
    assertEquals(Nil(),filter[Int](lst)(_ >=100))
  }
}