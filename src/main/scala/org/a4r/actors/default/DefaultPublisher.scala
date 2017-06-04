package org.a4r.actors.default

import akka.actor.Props
import org.a4r.actors.pubsub.DistributedPublisher
import org.a4r.messages.{DefaultTopic, MessageTopic}

/**
  * Created by brendan on 6/4/17.
  */
class DefaultPublisher extends DistributedPublisher{

  def topic = DefaultTopic()

  override def receive: Receive = {
    case msg =>
      publish("this is a message", topic)
  }
}
object DefaultPublisher {
  def props() = {
    Props[DefaultPublisher]
  }
}
