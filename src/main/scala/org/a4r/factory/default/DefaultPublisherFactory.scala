package org.a4r.factory.default

import akka.actor.Props
import org.a4r.actors.default.DefaultActor
import org.a4r.factory.PublisherFactory

/**
  * Created by brendan on 6/3/17.
  */
class DefaultPublisherFactory extends PublisherFactory{
  override def props(): Seq[Props] = Seq(DefaultActor.props(),DefaultActor.props())
}
