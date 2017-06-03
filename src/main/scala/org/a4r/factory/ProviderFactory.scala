package org.a4r.factory

import akka.actor.{ActorRef, ActorSystem, Props}

/**
  * Created by brendan on 6/3/17.
  * Basic trait to inherit from in the development
  * of other Providers
  */
trait ProviderFactory {
  /*
  return Seq of all Props required for con
   */
  def props():Seq[Props]

  def references(actorSystem:ActorSystem):Seq[ActorRef] = {
    props().map( prop =>{
      actorSystem.actorOf( prop )
    })
  }
}
