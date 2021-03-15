package exercises

import exercises.ExtendedList._
import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test
import u03.Lists.List.{Cons, Nil}

class ex4Test {
  val lst1 = Cons(3, Cons(7, Cons(1, Cons(5, Nil()))))
  val lst2 = Cons(20, Cons(10, Cons(2, Nil())))

  @Test def testFoldLeft(): Unit ={
    assertEquals(-16, foldLeft[Int, Int]( lst1 )(0)(_ - _))
    assertEquals(16, foldLeft[Int, Int]( lst1 )(0)(_ + _))
    assertEquals(1, foldLeft[Int, Int]( lst2 )(400)(_ / _))
  }

  @Test def testFoldRight(): Unit ={
    assertEquals(-8, foldRight[Int, Int]( lst1 )(0)(_ - _))
    assertEquals(16, foldRight[Int, Int]( lst1 )(0)(_ + _))
    assertEquals(4, foldRight[Int, Int]( lst2 )(1)(_ / _))
  }

}