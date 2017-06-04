package org.a4r.actors.default

import akka.actor.Props
import org.a4r.actors.pubsub.DistributedSubscriber
import org.a4r.messages
import org.a4r.messages.DefaultTopic

/**
  * Created by brendan on 6/4/17.
  */
class DefaultSubscriber extends DistributedSubscriber{

  override def topic: messages.MessageTopic = DefaultTopic()


  override def wrappedReceive: Receive = {
    case msg =>
      info(s"------------ got a distributed msg: $msg")
  }
}


object DefaultSubscriber {
  def props() = {
    Props[DefaultSubscriber]
  }
}
