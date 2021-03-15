package exercises

import u03.Streams.Stream.{Cons, Empty, cons, take}

object ExtendedStream extends App {

  /** EX1 */
  import u03.Streams.Stream
  def drop[A](stream: Stream[A])(n: Int): Stream[A] = (stream, n) match {
    case (Cons(_, tail), n) if n>0 => drop(tail())(n-1)
    case _ => stream
  }
}
