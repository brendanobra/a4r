package org.a4r


import com.typesafe.config.{Config, ConfigFactory}

/**
  * Created by brendan on 6/4/17.
  */
class A4RApp extends App with Logged{

  var appConfig:A4RConfig = _
  var config:Config = _

  override def main(args: Array[String]): Unit = {

    appConfig =  A4RConfig().parse(args)
    config = ConfigFactory.load(appConfig.configFile)


  }
}
