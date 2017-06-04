package org.a4r.factory.default

import akka.actor.Props
import org.a4r.actors.default.{DefaultActor, DefaultPublisher, DefaultSubscriber}
import org.a4r.factory.PublisherFactory

/**
  * Created by brendan on 6/3/17.
  */
class DefaultPublisherFactory extends PublisherFactory {

  override def props(): Seq[Props] = Seq(
    DefaultSubscriber.props(),
    DefaultPublisher.props(),
    DefaultActor.props(),
    DefaultActor.props())

}
