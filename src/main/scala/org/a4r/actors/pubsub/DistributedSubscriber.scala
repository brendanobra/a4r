package org.a4r.actors.pubsub

import akka.actor.Actor
import akka.cluster.pubsub.DistributedPubSub
import akka.cluster.pubsub.DistributedPubSubMediator.{Subscribe, SubscribeAck}
import org.a4r.Logged
import org.a4r.messages.MessageTopic

/**
  * Created by brendan on 6/4/17.
  */
trait DistributedSubscriber extends Actor with Logged {

  def topic:MessageTopic
  import akka.cluster.pubsub.DistributedPubSubMediator.Subscribe
  val mediator = DistributedPubSub(context.system).mediator
  // subscribe to the topic named "content"
  info(s"--------------- subscribing to topic $topic")
  mediator ! Subscribe(topic.name, self)

  def wrappedReceive:Receive

  override def receive: Receive = {
    case ack:SubscribeAck =>
      info(s"got subscribe ACK: $ack")
    case msg =>
      wrappedReceive(msg)
  }

}
