package org.a4r

import org.slf4j.LoggerFactory

/**
  * Created by brendan on 6/3/17.
  */
trait Logged {
  val loggr = LoggerFactory.getLogger(getClass.getName)
  def info(msg:String) = {loggr.info(msg)}
  def debug(msg:String) = loggr.debug(msg)

}
