package org.a4r.actors.pubsub

import akka.actor.Actor
import akka.cluster.pubsub.DistributedPubSub
import akka.cluster.pubsub.DistributedPubSubMediator.Publish
import org.a4r.Logged
import org.a4r.messages.MessageTopic

/**
  * Created by brendan on 6/4/17.
  */
trait DistributedPublisher extends Actor with Logged{
  // activate the extension
  def topic:MessageTopic
  val mediator = DistributedPubSub(context.system).mediator
  def publish( msg:Any ) = {
    info(s"publishing $msg to ${topic.name}")
    mediator ! Publish(topic.name,msg)
  }


}
