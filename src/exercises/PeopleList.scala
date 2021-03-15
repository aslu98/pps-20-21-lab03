package exercises

import u03.Lists.List
import u02.SumTypes._
import exercises.ExtendedList._
import u03.Lists.List.{Cons, Nil}

object PeopleList extends App {

  /** EX3 */
  def getCourses (lp:List[Person]): List[String] =
    map(filter(lp)(x => x match {
      case Teacher(_,_) => true
      case _ => false
    }))(p => p match {
      case Teacher(_, c) => c
    })

  def getCoursesFlatMap (lp:List[Person]): List[String] = flatMap(lp)(p => p match {
    case Teacher(_, c) => Cons(c, Nil())
    case _ => Nil()
  })
}
