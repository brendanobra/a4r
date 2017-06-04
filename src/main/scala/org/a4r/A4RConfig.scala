package org.a4r

/**
  * Created by brendan on 6/3/17.
  */
case class A4RConfig(actorSystemName:String = "A4R",
                     configFile:String = "application.conf",role:String = "master")  {
  def parse(args:Seq[String]):A4RConfig = {
   val parser =  new scopt.OptionParser[A4RConfig]("A4R") {
     head("A4R","1.0")
     opt[String]('a', "actorSystemName").action( (x, c) =>
       c.copy(actorSystemName = x) ).text("ActorSystemName")
     opt[String]('c', "configFile").action( (x, c) =>
       c.copy(configFile = x) ).text("configFile")
     opt[String]('r', "role").action( (x, c) =>
       c.copy(role = x) ).text("role")
    }
    parser.parse(args,this).getOrElse(A4RConfig())
  }
}
