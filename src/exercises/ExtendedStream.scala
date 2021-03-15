package exercises

import u03.Streams.Stream.{Cons, Empty, cons, empty}

object ExtendedStream extends App {

  /** EX5 */
  import u03.Streams.Stream
  def drop[A](stream: Stream[A])(n: Int): Stream[A] = (stream, n) match {
    case (Cons(_,tail), n) if n>0 => drop(tail())(n-1)
    case _ => stream
  }

  /** EX6 */
  def constant[A](elem: => A): Stream[A] = cons(elem, constant(elem))

  /** EX7 */
  def iterateTwoInputs[A](first: => A)(second: => A)(next: (A,A) => A): Stream[A] =
    cons(first, iterateTwoInputs(second) (next(first, second)) (next))
  val fibs: Stream[Int] = iterateTwoInputs(0)(1)((a, b) => a+b)
}
