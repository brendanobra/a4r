package org.a4r

import akka.actor.ActorRef

/**
  * Created by brendan on 6/4/17.
  */
package object messages {

  trait A4RMessage
  trait MessageTopic {
    def name:String
  }
  trait PublishMessage extends A4RMessage
  trait ReceivedMessage extends A4RMessage

  case class PublishThis(msg:Any,topic:MessageTopic,sender:ActorRef) extends PublishMessage
  case class ReceivedThis(msg:Any,topic: MessageTopic,sender:ActorRef)

  case class DefaultTopic()extends MessageTopic {
    def name:String = "default"
    override def toString() = {
      name
    }
  }
  case class OtherDefaultTopic()extends MessageTopic {
    def name:String = "otherDefault"
    override def toString() = {
      name
    }
  }

}
