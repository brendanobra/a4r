package org.a4r

import akka.actor.ActorSystem
import org.a4r.Main.appConfig

/**
  * Created by brendan on 6/4/17.
  */
trait A4RActorSystem {
  def createActorSystem(name:String):ActorSystem = {
   ActorSystem( name )
  }
}
