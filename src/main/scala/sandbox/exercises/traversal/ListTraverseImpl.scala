package sandbox.exercises.traversal

import cats.{Applicative, Eval, Monad, Traverse}

object ListTraverseImpl {

  val listApplicative: Applicative[List] = new Applicative[List] {
    override def pure[A](x: A): List[A] = List(x)

    override def ap[A, B](ff: List[A => B])(fa: List[A]): List[B] =
      fa.flatMap(a => ff.map(f => f(a)))
  }

  val listTraversal: Traverse[List] = new Traverse[List] {
    override def traverse[G[_], A, B](fa: List[A])(f: A => G[B])(implicit appG: Applicative[G]): G[List[B]] =
      {
        fa match {
          case Nil => appG.pure(Nil)
          case head :: tail =>
            appG.map2(appG.map(f(head))(List(_)), traverse(tail)(f))(_ ++ _)
        }
      }

    override def foldLeft[A, B](fa: List[A], b: B)(f: (B, A) => B): B = ???

    override def foldRight[A, B](fa: List[A], lb: Eval[B])(f: (A, Eval[B]) => Eval[B]): Eval[B] = ???
  }

}
