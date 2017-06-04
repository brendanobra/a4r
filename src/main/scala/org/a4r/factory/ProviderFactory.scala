package org.a4r.factory

import akka.actor.{ActorRef, ActorSystem, Props}
import com.typesafe.config.Config
import org.a4r.Logged

/**
  * Created by brendan on 6/3/17.
  * Basic trait to inherit from in the development
  * of other Providers
  */
trait ProviderFactory extends Logged{
  /*
  return Seq of all Props required for con
   */
  def props():Seq[Props]

  def references(actorSystem:ActorSystem,config: Config):Seq[ActorRef] = {
    props().map( prop =>{
      info(s"creating with $prop")
      actorSystem.actorOf( prop )
    })
  }
}
object ProviderFactory extends Logged{

  /*
  Bit of the dirty here, but neccesary...
   */
  def apply(className:String):ProviderFactory = {
    info(s"loading $className")
    Class.forName(className).newInstance().asInstanceOf[ProviderFactory]
  }
  def apply(classNames:Seq[String]):Seq[ProviderFactory] = {
    classNames.map(c => apply(c))
  }
}
