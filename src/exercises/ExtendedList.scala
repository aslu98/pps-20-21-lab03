package exercises

import u03.Lists.List.{Cons, Nil, append}

object ExtendedList extends App {

  /** EX1 */
  import u03.Lists.List
  def drop[A](l: List[A], n: Int): List[A] = (n, l) match {
    case (n, Cons(_, tail)) if (n > 0) => drop(tail, n - 1)
    case _ => l
  }

  def flatMap[A,B](l: List[A])(f: A => List[B]): List[B] = l match {
    case Cons(head, tail) => append(f(head), flatMap(tail)(f))
    case _ => Nil()
  }

  def map[A,B](l: List[A])(mapper: A=>B): List[B] = flatMap(l)(x => Cons(mapper(x), Nil()))

  def filter[A](l1: List[A])(pred: A=>Boolean): List[A] = flatMap[A, A](l1)(x => pred(x) match {
    case true => Cons(x, Nil())
    case _ => Nil()
  })


  /** EX2 */
  import u02.Optionals._
  import u02.Optionals.Option._
  def max(l: List[Int]): Option[Int] = l match {
    case Cons(h, t) => filter(t)(x => x>h) match {
      case Nil() => Some(h)
      case _ => max(t)
    }
    case Nil() => None()
  }



  /** EX4 */
  def foldLeft[A, B](l: List[A])(init:B)(f: (B, A) => B):B = l match {
    case Cons(head, tail) => foldLeft(tail)(f(init, head))(f)
    case _ => init
  }

  def foldRight[A, B](l: List[A])(init:B)(f: (A, B) => B):B = l match {
    case Cons(head, tail) => f(head, foldRight(tail)(init)(f))
    case _ => init
  }
}
