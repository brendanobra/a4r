package org.a4r.actors.default

import akka.actor.{Actor, Props}
import org.a4r.Logged

/**
  * Created by brendan on 6/3/17.
  */
class DefaultActor extends Actor with Logged {
  import akka.cluster.pubsub.DistributedPubSubMediator._

  override def receive: Receive = {
    case msg => info(s"I am ${getClass.getSimpleName} got msg: $msg")
  }
}
object DefaultActor{
  def props() = {
    Props(new DefaultActor)
  }

}
