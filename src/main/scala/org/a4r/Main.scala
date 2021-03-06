package org.a4r
import net.ceedubs.ficus.Ficus._
import org.a4r.factory.ProviderFactory

/**
  * Created by brendan on 6/3/17.
  */
object Main extends A4RApp with A4RActorSystem with  A4RPubSub {
  override def main(args: Array[String]): Unit = {
    info(s"starting with $args")
    super.main(args)

    val actorSystem = createActorSystem(appConfig.actorSystemName)

    startPubSub( actorSystem )

    val factories = config.as[Seq[String]]("factories")
    val toCreate = ProviderFactory.apply(factories)

    Thread.sleep(2000)

    val actors = toCreate.map(p => {
      p.references(actorSystem, config)
    }).flatten

    actors.foreach(a => {
      (1 to 10).foreach( i=> a! s"$i msg")
    })

    actorSystem.terminate()
  }
}
