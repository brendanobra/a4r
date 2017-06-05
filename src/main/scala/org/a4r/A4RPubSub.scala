package org.a4r

import akka.actor.ActorSystem
import akka.cluster.pubsub.DistributedPubSub

/**
  * Created by brendan on 6/4/17.
  */
trait A4RPubSub {

  def startPubSub(actorSystem:ActorSystem) = {
    DistributedPubSub(actorSystem).mediator
  }

}
