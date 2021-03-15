package exercises

import exercises.ExtendedList._
import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test
import u03.Lists.List.{Cons, Nil}
import u03.Lists.List
import u02.SumTypes._
import exercises.PeopleList._

class ex3Test {
  val p1: Teacher = Teacher("Viroli", "OOP")
  val p2: Teacher = Teacher("Viroli", "PPS")
  val p3: Teacher = Teacher("Ghini", "SO")
  val s1: Student = Student("Rossi", 22)
  val s2: Student = Student("Verdi", 25)

  @Test def testCourses(): Unit = {
    assertEquals( Nil(),
                  getCourses(Cons(s1, Cons(s2, Nil()))))
    assertEquals( Cons("OOP", Cons("PPS", Nil())),
                  getCourses(Cons(p1, Cons(p2, Nil()))))
    assertEquals( Cons("SO", Cons("PPS", Nil())),
                  getCourses(Cons(p3, Cons(s1, (Cons(p2, Nil()))))))
  }

  @Test def testCoursesFlatMap(): Unit = {
    assertEquals( Nil(),
      getCoursesFlatMap(Cons(s1, Cons(s2, Nil()))))
    assertEquals( Cons("OOP", Cons("PPS", Nil())),
      getCoursesFlatMap(Cons(p1, Cons(p2, Nil()))))
    assertEquals( Cons("SO", Cons("PPS", Nil())),
      getCoursesFlatMap(Cons(p3, Cons(s1, (Cons(p2, Nil()))))))
  }
}