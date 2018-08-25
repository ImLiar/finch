package io.finch.syntax

import com.twitter.finagle.http.Method
import io.finch._

trait EndpointMappers {

  /**
   * A combinator that wraps the given [[Endpoint]] with additional check of the HTTP method. The
   * resulting [[Endpoint]] succeeds on the request only if its method is `GET` and the underlying
   * endpoint succeeds on it.
   */
  def get[F[_], A](e: Endpoint[F, A]): EndpointMapper[F, A] = new EndpointMapper[F, A](Method.Get, e)

  /**
   * A combinator that wraps the given [[Endpoint]] with additional check of the HTTP method. The
   * resulting [[Endpoint]] succeeds on the request only if its method is `POST` and the underlying
   * endpoint succeeds on it.
   */
  def post[F[_], A](e: Endpoint[F, A]): EndpointMapper[F, A] = new EndpointMapper[F, A](Method.Post, e)

  /**
   * A combinator that wraps the given [[Endpoint]] with additional check of the HTTP method. The
   * resulting [[Endpoint]] succeeds on the request only if its method is `PATCH` and the underlying
   * endpoint succeeds on it.
   */
  def patch[F[_], A](e: Endpoint[F, A]): EndpointMapper[F, A] = new EndpointMapper[F, A](Method.Patch, e)

  /**
   * A combinator that wraps the given [[Endpoint]] with additional check of the HTTP method. The
   * resulting [[Endpoint]] succeeds on the request only if its method is `DELETE` and the
   * underlying endpoint succeeds on it.
   */
  def delete[F[_], A](e: Endpoint[F, A]): EndpointMapper[F, A] = new EndpointMapper[F, A](Method.Delete, e)

  /**
   * A combinator that wraps the given [[Endpoint]] with additional check of the HTTP method. The
   * resulting [[Endpoint]] succeeds on the request only if its method is `HEAD` and the underlying
   * endpoint succeeds on it.
   */
  def head[F[_], A](e: Endpoint[F, A]): EndpointMapper[F, A] = new EndpointMapper[F, A](Method.Head, e)

  /**
   * A combinator that wraps the given [[Endpoint]] with additional check of the HTTP method. The
   * resulting [[Endpoint]] succeeds on the request only if its method is `OPTIONS` and the
   * underlying endpoint succeeds on it.
   */
  def options[F[_], A](e: Endpoint[F, A]): EndpointMapper[F, A] = new EndpointMapper[F, A](Method.Options, e)

  /**
   * A combinator that wraps the given [[Endpoint]] with additional check of the HTTP method. The
   * resulting [[Endpoint]] succeeds on the request only if its method is `PUT` and the underlying
   * endpoint succeeds on it.
   */
  def put[F[_], A](e: Endpoint[F, A]): EndpointMapper[F, A] = new EndpointMapper[F, A](Method.Put, e)

  /**
   * A combinator that wraps the given [[Endpoint]] with additional check of the HTTP method. The
   * resulting [[Endpoint]] succeeds on the request only if its method is `CONNECT` and the
   * underlying endpoint succeeds on it.
   */
  def connect[F[_], A](e: Endpoint[F, A]): EndpointMapper[F, A] = new EndpointMapper[F, A](Method.Connect, e)

  /**
   * A combinator that wraps the given [[Endpoint]] with additional check of the HTTP method. The
   * resulting [[Endpoint]] succeeds on the request only if its method is `TRACE` and the underlying
   * router endpoint on it.
   */
  def trace[F[_], A](e: Endpoint[F, A]): EndpointMapper[F, A] = new EndpointMapper[F, A](Method.Trace, e)
}
