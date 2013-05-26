package akka.SendRcvExample
import akka.actor._
import java.util.Random
import scala.math


abstract class msg
case class GET(stuff:String) extends msg
case class POST(stuff:String) extends msg
case class SEND extends msg

class Receiver extends Actor {
  def receive = {
    case GET(stuff) => 
      println("GET: "+stuff)
      sender ! SEND
    case POST(stuff) => 
      println("POST:"+stuff)
      sender ! SEND
  }
}

class Sender(receiver: ActorRef) extends Actor {
  def chooseMsg() = {
    Thread.sleep(1000)
    val x = new Random()
    val choice = math.floor(x.nextFloat()*3).toInt
    choice match {
      case 0 => GET("Get something")
      case 1 => POST("Post something")
      case 2 => POST("Post something else")
    }
  }
  def receive = {
    case SEND =>
      println("sender is sending msg")
      receiver ! chooseMsg()
  }
}

object SendReceiveTest extends App{
println("Starting")
  val system = ActorSystem("SendReceiveSystem")
  val receiver = system.actorOf(Props[Receiver], name = "receiver")
  val sender = system.actorOf(Props(new Sender(receiver)), name = "sender")
  // start them going
  sender ! SEND
}

