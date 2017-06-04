package org.a4r.actors.default

import akka.actor.{Actor, Props}
import org.a4r.Logged

/**
  * Created by brendan on 6/3/17.
  */
class DefaultActor extends Actor with Logged {

  override def receive: Receive = {
    case msg => info(s"got msg: $msg")
  }
}
object DefaultActor{
  def props() = {
    Props(new DefaultActor)
  }

}
