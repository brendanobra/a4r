package org.a4r.actors.pubsub

import akka.actor.Actor
import akka.cluster.pubsub.DistributedPubSub
import akka.cluster.pubsub.DistributedPubSubMediator.Publish
import org.a4r.Logged
import org.a4r.messages.MessageTopic

/**
  * Created by brendan on 6/4/17.
  * a with-able trait to implement distributed publishers
  */
trait DistributedPublisher extends Actor with Logged{
  // activate the extension
  def topics:Seq[MessageTopic]
  val mediator = DistributedPubSub(context.system).mediator

  def publish( msg:Any ) = {
    topics.map(topic => {
      info(s"publishing $msg to ${topic.name}")
      mediator ! Publish(topic.name, msg)
    })
  }


}
