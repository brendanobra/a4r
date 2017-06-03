package com.a4r

import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory

/**
  * Created by brendan on 6/3/17.
  */
object Main extends App{
  override def main(args: Array[String]): Unit = {
    val appConfig = A4RConfig().parse(args)
    val config = ConfigFactory.load(appConfig.configFile)
    println(s"starting up...")
    val actorSystem = ActorSystem(appConfig.actorSystemName)
    println(s"started in ${actorSystem.startTime}")
    Thread.sleep(2000)
    actorSystem.terminate()



  }
}
