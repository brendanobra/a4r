package org.a4r

import akka.actor.ActorSystem
import akka.cluster.pubsub.DistributedPubSub
import com.typesafe.config.ConfigFactory
import net.ceedubs.ficus.Ficus._
import org.a4r.factory.ProviderFactory

/**
  * Created by brendan on 6/3/17.
  */
object Main extends App with Logged {
  override def main(args: Array[String]): Unit = {
    info(s"starting with $args")

    info(s"starting up...")
    val appConfig = A4RConfig().parse(args)
    val config = ConfigFactory.load(appConfig.configFile)

    val actorSystem = ActorSystem(appConfig.actorSystemName)
    DistributedPubSub(actorSystem).mediator ! "foo"
    info(s"started in ${actorSystem.startTime}")


    val factories = config.as[Seq[String]]("factories")
    val toCreate = ProviderFactory.apply(factories)
    val actors = toCreate.map(p => {
      p.references(actorSystem, config)
    }).flatten
    actors.foreach(a => a ! "hello")


    Thread.sleep(2000)
    actorSystem.terminate()


  }
}
