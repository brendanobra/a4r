package org.a4r.actors.default

import akka.actor.Props
import org.a4r.actors.pubsub.DistributedSubscriber
import org.a4r.messages
import org.a4r.messages.{DefaultTopic, OtherDefaultTopic}

/**
  * Created by brendan on 6/4/17.
  */
class DefaultSubscriber extends DistributedSubscriber{

  override def topics: Seq[messages.MessageTopic] =Seq(DefaultTopic(),OtherDefaultTopic())


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
