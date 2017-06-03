# A4R - Akka For Robotics

The current offerings for JVM based robotics programming
leave a few things to be desired - namely, the "only game in town"
appears to be rosjava, which appears to be abandoned and has several limitations:
- Creating new message types for JVM based development is cumbersome and
requires using the proprietary rosjava build tools
- The message system is somewhat brittle
- The framework uses a master node, which does not scale well
- It's based on webservices "under the hood"

## with all that in mind..

 This project will attempt to build a JVM centric Robotics RPC framework
 that is based on Akka (http://akka.io) , which is well suited to building
 asynchronous distributed systems on the JVM.  Not only is Akka VERY efficient ,
  but it also leads it's users towards message based design patterns,
  which are much more likely to be functional and immutable
